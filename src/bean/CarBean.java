package bean;

public class CarBean {
    private Integer id;
    private String name;
    private String color;
    private Boolean isInStore;
    private Double price;
    private Integer userId;

    public CarBean(String name, String color, Boolean isInStore, Double price, Integer userId) {
        this.name = name;
        this.color = color;
        this.isInStore = isInStore;
        this.price = price;
        this.userId = userId;
    }

    public CarBean(String name, String color, Boolean isInStore, Double price) {
        this.name = name;
        this.color = color;
        this.isInStore = isInStore;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getInStore() {
        return isInStore;
    }

    public void setInStore(Boolean inStore) {
        isInStore = inStore;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("%s :-> [ car id : %s | car color : %s | car isInStore : %s | car price : %s | car owner id : %s ]",getName(),getId(),getColor(),getInStore(),getPrice(),getUserId());
    }
}
