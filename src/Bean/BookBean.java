package Bean;

public class BookBean extends BasIdBean{
    String name;
    String author;
    Integer userId;

    public BookBean(Integer id, String name, String author) {
        this.name = name;
        this.author = author;
    }
    public BookBean(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", userId=" + userId +
                '}';
    }
}
