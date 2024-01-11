package resource;

import bean.ApiResponse;
import bean.UserBean;
import db.DB;

public class UserResource {
    public ApiResponse create(UserBean bean) {
        if (DB.checkUserExistByLogin(bean.getUsername())){
            System.out.println("exist user");
        }else {
            UserBean user = DB.addUser(bean);
            return new ApiResponse(200, "success", user);
        }
        return null;
    }

    public ApiResponse login(UserBean newUser) {
        UserBean existUser = DB.getUser(newUser);
        return new ApiResponse(existUser == null ? 401 : 200,existUser == null ? "user not found":"success",existUser);
    }
//    TODO:
}
