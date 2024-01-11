package db;

import UserRole.UserRole;
import bean.CarBean;
import bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public static UserBean session=null;
    private static final List<UserBean> USER_BEANS =new ArrayList<>();
    private static final List<CarBean> CAR_BEANS =new ArrayList<>();

    private static int userID = 1;
    private static int carID = 1;

    static {
        UserBean userBean = new UserBean();
        userBean.setId(userID++);
        userBean.setUsername("admin");
        userBean.setPassword("admin");
        userBean.setUserRole(UserRole.ADMIN);
        USER_BEANS.add(userBean);
    }
    public static boolean checkUserExistByLogin(String login){
        for (UserBean user : USER_BEANS) {
            if (user.getUsername().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public static UserBean addUser(UserBean userBean){
        if(checkUserExistByLogin(userBean.getUsername())) {
            return null;
        }
        userBean.setId(userID++);
        userBean.setUserRole(UserRole.USER);
        USER_BEANS.add(userBean);
        return userBean;
    }

    public static UserBean getUser(UserBean userBean){
        for (UserBean user : USER_BEANS) {
            if (user.getUsername().equals(userBean.getUsername())&&user.getPassword().equals(userBean.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public static CarBean addCar(CarBean carBean){
        carBean.setId(carID++);
        CAR_BEANS.add(carBean);
        return carBean;
    }

    public static List<CarBean> getMyCars(Integer ownerId){
        List<CarBean> myCars = new ArrayList<>();
        for (CarBean carBean : CAR_BEANS) {
            if (carBean.getUserId() != null && carBean.getUserId().equals(ownerId) && !carBean.getInStore()){
               myCars.add(carBean);
            }
        }
        return myCars;
    }

    public static List<CarBean> getAvailableCars(){
        List<CarBean> availableCars = new ArrayList<>();
        for (CarBean carBean : CAR_BEANS) {
            if (carBean.getUserId() == null && carBean.getInStore()){
                availableCars.add(carBean);
            }
        }
        return availableCars;

    }

    public static List<CarBean> showAllCars(){
        return CAR_BEANS;
    }



}
