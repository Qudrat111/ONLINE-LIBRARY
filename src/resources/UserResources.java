package resources;
import Bean.ApiResponse;
import Bean.UserBean;
import repositery.DB;

public class UserResources {
    public ApiResponse register(UserBean user) {
        boolean b = DB.addUser(user);
        if(!b){
            return  new ApiResponse(400,"Error",user);
        }
        return  new ApiResponse(200,"Success",user);
    }
    public ApiResponse logIn(UserBean user){
        boolean b = DB.logIn(user);
        if(!b){
            return new ApiResponse(400,"This logIn exist",user);
        }
        return new ApiResponse(200,"successfully logged",user);
    }
}
