package resources;


import Bean.ApiResponse;
import Bean.BookBean;
import Bean.UserBean;
import repositery.DB;

public class BookResource {
    public ApiResponse showFreeBooks() {
        if (DB.showFreeBooks()) {
            return new ApiResponse(200, "success", DB.session);
        }
        return new ApiResponse(400, "don't have free books", DB.session);
    }

    public ApiResponse showMyBooks(UserBean userBean) {
        if (DB.showMyBooks(userBean)) {
            return new ApiResponse(200, "success", userBean);
        }
        return new ApiResponse(400, "don't have your books", userBean);
    }

    public ApiResponse getBook(int index) {
        BookBean book1 = DB.getBook(index);
        if (book1 == null) {
            return new ApiResponse(400, "not found", book1);
        }
        return new ApiResponse(200, "success", book1);
    }

    public ApiResponse returnBook(int index) {
        BookBean book1 = DB.returnBook(index);
        if (book1 == null) {
            return new ApiResponse(400, "error", book1);
        }
        return new ApiResponse(200, "success", book1);
    }
    public ApiResponse addBook(BookBean book) {
        DB.addBook(book);
        return new ApiResponse(200, "success", book);
    }
    public ApiResponse showAllBooks(){
        DB.showAllBooks();
        return new ApiResponse(200, "success", null);
    }
}
