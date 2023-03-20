package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.ArrayList;
import java.util.Scanner;

public class Book implements IShop, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPage;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;
    private ArrayList<Author> authors;


    public Book() {};
    public Book(int bookId, String bookName, String title, int numberOfPage, Author author, float importPrice, float exportPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPage = numberOfPage;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }


    @Override
    public void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the book's ID");
        int bookId = Integer.parseInt(input.nextLine());
        setBookId(bookId);
        System.out.println("Input the book's name");
        String bookName = input.nextLine();
        setBookName(bookName);
        System.out.println("Input the book's title");
        String title = input.nextLine();
        setTitle(title);
        System.out.println("Input the book's page number");
        int numberOfPage = Integer.parseInt(input.nextLine());
        setNumberOfPage(numberOfPage);
        System.out.println("Input the book's import price");
        float importPrice = Float.parseFloat(input.nextLine());
        setImportPrice(importPrice);
        float exportPrice = (importPrice*RATE);
        setExportPrice(exportPrice);
        System.out.println("Input the book's quantity");
        int quantity = Integer.parseInt(input.nextLine());
        setQuantity(quantity);
        System.out.println("Input the book's status");
        String bookStatus = input.nextLine();
        setBookStatus(bookStatus.equalsIgnoreCase("stock")?true:false);
        System.out.println("Choose author of the book");
        for (int i = 0; i < getAuthors().size(); i++) {
            getAuthors().get(i).displayData();
        }
        int choiceOfAuthor = Integer.parseInt(input.nextLine());
        for (int i = 0; i < getAuthors().size(); i++) {
            if(choiceOfAuthor==(i+1)){
                setAuthor(getAuthors().get(i));
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Book's ID: " + getBookId() + "\n"
                + "Product's Name: " + getBookName() + "\n"
                + "Author: " + getAuthor().getAuthorName() + "\n"
                + "Export price: " + getExportPrice() + "\n"
                + "Quantity: " + getQuantity()+ "\n"
                + "Status: " + isBookStatus()+ "\n"
                + "--------------------"
        );
    }

    @Override
    public int compareTo(Book book) {
        return (int)(this.getExportPrice()-book.getExportPrice());
    }
}
