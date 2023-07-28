package persistence;


import model.Book;
import model.ReadingList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

//Credit: The program is greatly based off of JsonSerializationDemo, CPSC210, UBC
public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ReadingList rl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyReadList.json");
        try {
            ReadingList rl = reader.read();
            assertEquals("Good", rl.getName());
            assertEquals(0, rl.howLong());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralReadList.json");
        try {
            ReadingList rl = reader.read();
            assertEquals("Good", rl.getName());
            List<Book> books = rl.getAllBooks();
            assertEquals(2, books.size());
            checkBook("mm", "mm", "NotCompleted.", books.get(0));
            checkBook("zz", "zz", "NotCompleted.", books.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
