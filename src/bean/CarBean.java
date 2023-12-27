package bean;

public class CarBean  extends BaseIdBean{
    private String name;
    private String color;
    private double price;
    private UserBean userId;
    private boolean isInStore;

    public CarBean() {

    }

    public CarBean(String name, String color, double price, UserBean userId, boolean isInStore) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.userId = userId;
        this.isInStore = isInStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UserBean getUserId() {
        return userId;
    }

    public void setUserId(UserBean userId) {
        this.userId = userId;
    }

    public boolean isInStore() {
        return isInStore;
    }

    public void setInStore(boolean inStore) {
        isInStore = inStore;
    }
}
