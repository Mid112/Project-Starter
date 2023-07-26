package persistence;


//Credit: The program is greatly based off of JsonSerializationDemo, CPSC210, UBC

import model.Book;
import model.ReadingList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {


    @Test
    void testWriterInvalidFile() {
        try {
            ReadingList rl = new ReadingList("My work room");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            ReadingList rl = new ReadingList("Good");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyReadList.json");
            writer.open();
            writer.write(rl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyReadList.json");
            rl = reader.read();
            assertEquals("Good", rl.getName());
            assertEquals(0, rl.howLong());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            ReadingList rl = new ReadingList("Good");
            rl.addBook(new Book("mm", "mm", "NotCompleted"));
            rl.addBook(new Book("zz", "zz", "NotCompleted"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralReadList.json");
            writer.open();
            writer.write(rl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralReadList.json");
            rl = reader.read();
            assertEquals("Good", rl.getName());
            List<Book> books = rl.getAllBooks();
            assertEquals(2, books.size());
            checkBook("mm", "mm", "NotCompleted.", books.get(0));
            checkBook("zz", "zz", "NotCompleted.", books.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
