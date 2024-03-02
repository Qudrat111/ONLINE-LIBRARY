import Bean.ApiResponse;
import Bean.BookBean;
import Bean.UserBean;
import repositery.DB;
import resources.BookResource;
import resources.UserResources;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    static BookResource bookResource = new BookResource();

    public static void main(String[] args) {

        while (true) {
            System.out.println("1 Register");
            System.out.println("2 Log in");
            System.out.println("3 Exit");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1 -> {
                    register();
                }
                case 2 -> {
                    logIn();
                }
                case 3 -> {
                    return;
                }
                default -> {
                    System.out.println("You wrote incorrect index");
                }
            }

        }
    }

    public static void register() {
        UserBean newUser = new UserBean();
        System.out.print("Enter userName = ");
        newUser.setUserName(scanner2.nextLine());
        System.out.print("Enter password = ");
        newUser.setPassword(scanner.nextInt());
        UserResources userResources = new UserResources();
        userResources.register(newUser);

    }

    public static void logIn() {
        UserBean user = new UserBean();
        System.out.print("Enter userName = ");
        user.setUserName(scanner2.nextLine());
        System.out.print("Enter password = ");
        user.setPassword(scanner.nextInt());
        DB.session = user;
        UserResources userResources = new UserResources();
        ApiResponse apiResponse = userResources.logIn(DB.session);
        System.out.println(apiResponse.getMessage());

        if (apiResponse.getCode() == 200 && user.getRole().equals("READER")) {
            infoOfReader();

        } else if (apiResponse.getCode() == 200 && user.getRole().equals("LIBRARIAN")) {
            infoOfLibrarian();
        }
    }

    public static void infoOfReader() {
        System.out.println("1 Show free books");
        System.out.println("2 Show my books");
        System.out.println("3 Get a book");
        System.out.println("4 Return book");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> bookResource.showFreeBooks();
            case 2 -> bookResource.showMyBooks(DB.session);
            case 3 -> {
                bookResource.showFreeBooks();
                System.out.print("Choose = ");
                int chooses = scanner.nextInt();
                ApiResponse book = bookResource.getBook(chooses);
                System.out.println(book.getMessage());
            }
            case 4 -> {
                bookResource.showMyBooks(DB.session);
                System.out.print("Choose = ");
                int chooses = scanner.nextInt();
                ApiResponse apiResponse = bookResource.returnBook(chooses);
                System.out.println(apiResponse.getMessage());
            }
            default -> {
                System.out.println("Incorrect ");
                infoOfReader();
            }
        }
    }

    public static void infoOfLibrarian() {
        System.out.println("1 Add book");
        System.out.println("2 Show all books");
        System.out.println("3 Exit");
        int choose = scanner.nextInt();
        in:
        switch (choose) {
            case 1 -> {
                BookBean book = new BookBean();
                System.out.print("Enter name ");
                book.setName(scanner2.nextLine());
                System.out.println("Enter author = ");
                book.setAuthor(scanner2.nextLine());
                ApiResponse apiResponse = bookResource.addBook(book);
                System.out.println(apiResponse.getMessage());
            }
            case 2 -> {
                ApiResponse apiResponse = bookResource.showAllBooks();
                System.out.println(apiResponse.getMessage());
            }
            default -> {
                System.out.println("error");
                infoOfLibrarian();
            }
        }
    }

}
