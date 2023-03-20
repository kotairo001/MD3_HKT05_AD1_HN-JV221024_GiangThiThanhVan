package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.Scanner;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    private Boolean sex;
    private int year;
    public Author() {};

    public Author(int authorId, String authorName, Boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the author's ID");
        int authorId = Integer.parseInt(input.nextLine());
        setAuthorId(authorId);
        System.out.println("Input the author's name");
        String authorName = input.nextLine();
        setAuthorName(authorName);
        System.out.println("Input the author's gender");
        String sex = input.nextLine();
        setSex(sex.equalsIgnoreCase("male")?true:false);
        System.out.println("Input the author's year of birth");
        int year = input.nextInt();
        setYear(year);
    }

    @Override
    public void display() {
        System.out.println("Author's ID: " + getAuthorId() + "\n"
                + "Author's Name: " + getAuthorName() + "\n"
                + "-------------------------");
    }
}
