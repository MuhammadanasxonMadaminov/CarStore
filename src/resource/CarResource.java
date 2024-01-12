package resource;

import bean.ApiResponse;
import bean.CarBean;
import db.DB;

import java.util.List;

public class CarResource {

    public ApiResponse create(CarBean bean) {
        CarBean car = DB.addCar(bean);

        return new ApiResponse(car == null ? 401 : 200,car == null ? "error":"success",car);
    }

    public ApiResponse getMyCars(Integer ownerId){
        List<CarBean> myCars = DB.getMyCars(ownerId);

        return new ApiResponse(myCars == null ? 401 : 200,myCars == null ? "error":"success",myCars);

    }
    public ApiResponse getAvailableCars(){
        List<CarBean> availableCars = DB.getAvailableCars();

        return new ApiResponse(availableCars == null ? 401 : 200,availableCars == null ? "error":"success",availableCars);

    }
    public ApiResponse showAllCars(){
        List<CarBean> carBeans = DB.showAllCars();

        return new ApiResponse(carBeans == null ? 401 : 200,carBeans == null ? "error":"success",carBeans);
    }
    public ApiResponse delete(Integer carId){
        boolean b = DB.deleteCar(carId);
        if (b){
            System.out.println("success");
        }else {
            System.out.println("error");
        }
        return null;
    }

}
