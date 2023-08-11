# Reading Pal Project

### An application to support good reading habits

A *brief* description regarding the application:
- **What** will the application do?

> The application will perform the following function:
> - Creates "READ NEXT" list with books to be read next (with images).
>   - The book also had the "RE-READ" list with 'completed' or 'currently reading' books.
>   - User can also store quotes, notes and info from 'completed' or 'currently' reading book.
> - Divide genre of books into categories created by user.
> - Rank all the book to help decide user's favorites (with images).
>   - A reader can joint rank can be given.

- **Who** will use it?
> The reading pal is for passionate reader who love to read, sometimes a bit too much. It will help <br> 
> readers stay focused and encourage a better reading experience through a disciplined goal. The <br> 
> ability to record things like ranks, quotes and notes will be much better than scattered <br> 
> documentations. All readers will find it useful to explore their preference through genres they <br>
> made known through books read in each genre.


- **Why** is this project of interest to you?
> This project is especially interesting to a reader like me, since having to write TO-READ book <br> 
> list somewhere, and keeping scattered documentations of my completed books list is inconvenient. <br>
> The project is especially made to help things like create personal book ranking to especially suit <br>
> tastes of individual readers. The book also promotes individual growth through increasing exposure to <br>
> different genres and setting a disciplined reading goals.

  
  
## *User Stories:*


A user stories for ***Reading Pal*** would be as follows:
- As a user, I want to be able to add book to 'reading list' 
- As a user, I want to be able to view status book like complete, not completed etc.
- As a user, I want to be able to view all the books I have read and will read.
- As a user, I want to be able to remove books from my reading lists.
- As a user, I want to be able to save my reading list to file (if I so choose).
- As a user, I want to be able to load my reading list from file (if I so choose).

## Instructions For Grader

- You can generate the first required action related to adding Xs to a Y by typing a book title, author 
and status with commas, and clicking add.
- You can generate the second required action related to adding Xs to a Y by selecting book from the menu, 
and while the book is selected and menu is open. Click the delete button to remove the book.
- You can generate the third action related to adding Xs to a Y by selecting book from the menu,
  and while the book is selected and menu is open. Click the Completed button the change book status,
- You can locate my visual component by selecting book from the menu,
  and while the book is selected and menu is open. Click the Completed button to change book status. This will
make an image pop-up.
- You can save the state of my application by clicking the save button.
- You can reload the state of my application by clicking the load button.

## Phase 4: Task 2

GUI has been closed

Wed Aug 09 22:52:38 PDT 2023 

You have added a book to reading list.

Wed Aug 09 22:52:42 PDT 2023

You have removed a book from the reading list.

Wed Aug 09 22:52:45 PDT 2023

You have added a book to reading list.

Wed Aug 09 22:52:47 PDT 2023

You have completed a book.

Reading List is closed


## Phase 4: Task 3

**What refactoring might be done to improve your design?**

The system implemented could be improved by making it more scalable. In the project,
ReadingList could have multiplicity of collection (*) in the ReadingListUI. This 
would allow the project to be able to create multiple ReadingList that could be named differently
according to genres. The ability to access writable can be done through a single point of access. 
Creating a singleton method with ReadingList in current implementation can allow better 
features or revisions in the future. With the singleton method, a composite method might be required
this would allow us to create multiple ReadingLists with almost similar specification. Even by applying
singleton and composite method, not only will design improve but, functionality can be increased as well.





