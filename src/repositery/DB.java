package repositery;

import Bean.BookBean;
import Bean.UserBean;
import resources.BookResource;

import java.util.ArrayList;

import java.util.HashSet;


public class DB {
    private static Integer idUser = 1;
    private static Integer idBook = 1;
    public static UserBean session = null;
    private static final HashSet<BookBean> books = new HashSet<>();
    private static final ArrayList<UserBean> users = new ArrayList<>();

    static {
        users.add(new UserBean("Qudrat", 1111));
        books.add(new BookBean(idBook++, "Jawa", "Someone"));
        books.add(new BookBean(idBook++, "C#", "Somebody"));
        books.add(new BookBean(idBook++, "C++", "Someone"));
    }

    public static boolean addUser(UserBean user) {
        if (checkUserExistByLogin(user.getUserName())) {
            return false;
        }
        users.add(user);
        user.setId(users.size());
        return true;
    }

    public  static boolean checkUserExistByLogin(String login){
        for (UserBean user:users) {
            if(user.getUserName().equals(login)){
                return true;
            }
        }
        return false;
    }

    public static boolean logIn(UserBean user) {
        if (users.get(0).getUserName().equals(user.getUserName()) && users.get(0).getPassword().equals(user.getPassword())) {
            user.setRole("LIBRARIAN");
            return true;
        }
        for (UserBean u : users) {
            if (u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword())) {
                user.setRole("READER");
                return true;
            }
        }
        return false;
    }

    public static boolean showFreeBooks() {
        boolean ishave = false;
        for (BookBean book : books) {
            if (book.getUserId() == null) {
                ishave = true;
                System.out.println(book.getId() + " " + book.getName());
            }
        }
        return ishave;
    }

    public static BookBean getById(Integer index) {
        for (BookBean book : books) {
            if (book.getId().equals(index)) {
                book.setUserId(session.getId());
                return book;
            }
        }
        return null;
    }
    public static BookBean returnById(Integer index) {
        for (BookBean book : books) {
            if (book.getId().equals(index)) {
                book.setUserId(null);
                return book;
            }
        }
        return null;
    }

    public static boolean showMyBooks(UserBean user) {
        boolean isHave = false;
        for (BookBean book : books) {
            if (book.getUserId().equals(user.getId())) {
                isHave = true;
                System.out.println(book.getId() + " " + book.getName());
            }
        }
        return isHave;
    }

    public static BookBean getBook(int index) {
        BookBean byId = getById(index);
        return byId;
    }

    public static BookBean returnBook(int index) {
        BookBean bean = returnById(index);
        return bean;
    }

    public static void addBook(BookBean book) {
        books.add(book);
        book.setId(books.size());
    }
    public static void showAllBooks(){
        for (BookBean book:books) {
            System.out.println(book.getId() + " " + book.getName());
        }
    }


}
