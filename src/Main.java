import UserRole.UserRole;
import bean.ApiResponse;
import bean.CarBean;
import bean.UserBean;
import db.DB;
import resource.CarResource;
import resource.UserResource;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scannerNum = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static UserResource userResource = new UserResource();
    static CarResource carResource = new CarResource();

    public static void main(String[] args) {
        showMainMenu();
    }


    //    TODO:
    private static void showMainMenu() {
        if (DB.session == null) {
            registerAndLogin();
        } else {
            carMenu();
        }
    }

    private static void registerAndLogin() {
        System.out.println("1. register");
        System.out.println("2. login");
        System.out.print("choose: ");
        byte choose = scannerNum.nextByte();

        switch (choose) {
            case 1 -> {
                register();
            }
            case 2 -> {
                login();
            }
            default -> System.out.println("error");
        }
        showMainMenu();
    }

    //    TODO:
    private static void register() {
        UserBean newUserBean = new UserBean();
        System.out.print("What is your user name: ");
        newUserBean.setUsername(scannerStr.next());
        System.out.print("Enter password: ");
        newUserBean.setPassword(scannerStr.next());
        ApiResponse res = userResource.create(newUserBean);
        DB.session = (UserBean) res.getData();
        System.out.println(res.getMessage());
        registerAndLogin();
    }

    //    TODO:
    private static void login() {
        UserBean newUser = new UserBean();
        System.out.print("What is your user name: ");
        newUser.setUsername(scannerStr.next());
        System.out.print("Enter password: ");
        newUser.setPassword(scannerStr.next());
        ApiResponse login = userResource.login(newUser);
        switch (login.getCode()) {
            case 200 -> {
                DB.session = (UserBean) login.getData();
            }
            case 401 -> {
                System.out.println(" 401 - Unauthorized : Please try again or Register Now");
            }
            default -> {
                login();
            }
        }
    }

    private static void carMenu() {
        if (DB.session.getUserRole().equals(UserRole.ADMIN)) {
            adminPage();
        } else if (DB.session.getUserRole().equals(UserRole.USER)) {
            userPage();
        }
    }

    private static void adminPage() {
        System.out.println("0. log-out");
        System.out.println("1. add car");
        System.out.println("2. delete car");
        System.out.println("3. update car");
        System.out.println("4. show all cars");
        System.out.println("5. exit");
        System.out.print("choose: ");
        byte choose = scannerNum.nextByte();
        switch (choose) {
            case 0 -> {
                DB.session = null;
            }
            case 1 -> {

            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {
                System.out.println("bye👋");
                System.exit(0);
            }
            default -> {
                System.out.println("invalid number❗");
            }
        }
        showMainMenu();
    }

    private static void userPage() {
        System.out.println("0. log-out");
        System.out.println("1. show my cars");
        System.out.println("2. show available cars");
        System.out.println("3. buy a car");
        System.out.println("4. sell a car");
        System.out.println("5. exit");
        System.out.print("choose: ");
        byte choose = scannerNum.nextByte();
        switch (choose) {
            case 0 -> {
                DB.session = null;
            }
            case 1 -> {
                ApiResponse myCars = carResource.getMyCars(DB.session.getId());
                List<CarBean> data = (List<CarBean>) myCars.getData();

                if (myCars.getCode() == 200){
                    System.out.println("****************************");
                    for (CarBean value : data) {
                        System.out.println(value);
                    }
                    System.out.println("****************************");
                }else {
                    System.out.println("car not found");
                }
            }
            case 2 -> {
                ApiResponse availableCars = carResource.getAvailableCars();
                List<CarBean> availableCarsData = (List<CarBean>) availableCars.getData();
                if (availableCars.getCode() == 200){
                    System.out.println("****************************");
                    for (CarBean value : availableCarsData) {
                        System.out.println(value);
                    }
                    System.out.println("****************************");
                }else {
                    System.out.println("available cars not in car store");
                }

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {
                System.out.println("bye👋");
                System.exit(0);
            }
            default -> {
                System.out.println("invalid number❗");
            }
        }
        showMainMenu();
    }




}
