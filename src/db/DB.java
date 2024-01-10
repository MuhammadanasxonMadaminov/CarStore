package db;

import bean.CarBean;
import bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public static UserBean session=null;
    private static final List<UserBean> USER_BEANS =new ArrayList<>();
    private static final List<CarBean> CAR_BEANS =new ArrayList<>();

    public static UserBean addUser(UserBean userBean){
        //TODO

        return null;
    }

    public static UserBean getUser(UserBean userBean){
        //TODO

        return null;
    }

    public static boolean checkUserExistByLogin(String login){

        return false;
    }


    public static CarBean addCar(CarBean carBean){
        //TODO

        return null;
    }

    public static List<CarBean> getMyCars(Integer userId){
        //TODO

        return null;
    }

    public static List<CarBean> getAvailableCars(){
        //TODO

        return null;
    }

    public static List<CarBean> showAllCars(){
        return CAR_BEANS;
    }

}
