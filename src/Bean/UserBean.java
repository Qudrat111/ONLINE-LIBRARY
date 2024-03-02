package Bean;


public class UserBean extends BasIdBean{
    String userName;
    Integer password;
    String role = null;

    public UserBean(){

    }



    public UserBean(String userName, Integer password) {
        this.userName = userName;
        this.password = password;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
    public void setRole(String role ){
        this.role = role;
    }
    public String getRole(){
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                ", userName='" + userName + '\'' +
                ", password=" + password +
                ", role='" + role + '\'' +
                '}';
    }
}
