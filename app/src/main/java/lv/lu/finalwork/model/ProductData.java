package lv.lu.finalwork.model;

import lombok.Getter;

@Getter
public class ProductData {
    private final String id;
    private final String name;
    private final String price;

    public ProductData(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
