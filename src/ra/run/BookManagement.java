package ra.run;

import ra.bussinessImp.Author;
import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    public static void main(String[] args) {
        int sizeOfAuthorList = 0;
        int sizeOfBookList = 0;
        List<Author> listAuthor = new ArrayList<>();
        List<Book> listBook = new ArrayList<>();
        String authorName = null;
        int choice = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Input the amount of author and author's information");
            System.out.println("2. Input the book number and enter the information of the books");
            System.out.println("3. Sort books by book price ascending");
            System.out.println("4. Search books by author's name");
            System.out.println("5. Exit");
            System.out.println("Input your choice");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Input the number of authors");
                    sizeOfAuthorList = input.nextInt();
                    for (int i = 0; i < sizeOfAuthorList; i++) {
                        Author author = new Author();
                        listAuthor.add(author);
                        listAuthor.get(i).inputData();
                    }
                    break;
                case 2:
                    System.out.println("Input the number of books");
                    sizeOfBookList = input.nextInt();
                    for (int i = 0; i < sizeOfBookList; i++) {
                        Book book = new Book();
                        book.setAuthors((ArrayList<Author>) listAuthor);
                        listBook.add(book);
                        listBook.get(i).inputData();
                    }
                    break;
                case 3:
                    if (listBook.size() == 0) {
                        System.err.println("There is no book in the list");
                    } else {
                        Collections.sort(listBook);
                    }
                    break;
                case 4:
                    boolean flag = false;
                    System.out.println("Input the author's name you want to search");
                    input.nextLine();
                    authorName = input.nextLine();
                    for (int i = 0; i < listBook.size(); i++) {
                        if (listBook.get(i).getAuthor().getAuthorName().equalsIgnoreCase(authorName)) {
                            flag = true;
                            listBook.get(i).displayData();
                            break;
                        }
                    }
                    if (flag==false) {
                        System.err.println("Can not find the author");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (choice < 5);
    }
}
