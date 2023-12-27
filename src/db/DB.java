package db;

import bean.CarBean;
import bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private static final List<UserBean> users = new ArrayList<>();
    private static final List<CarBean> cars = new ArrayList<>();


    public static UserBean addUser(UserBean bean){
        if(checkUserExistByLogin(bean.getLogin())){
            return null;
        }
        bean.setId(users.size());
        users.add(bean);
        return bean;
    }

    public static boolean checkUserExistByLogin(String login){
        for(UserBean user:users){
            if(user.getLogin().equals(login)){
                return true;
            }
        }

        return false;
    }

    public static UserBean getUser(UserBean bean){

        for(UserBean user:users){
            if(user.getLogin().equals(bean.getLogin())&&user.getPassword().equals(bean.getPassword())){
                return user;
            }
        }

        return null;
    }

}
