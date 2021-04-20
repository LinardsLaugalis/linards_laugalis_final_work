package lv.lu.finalwork.model;

import lombok.Data;

@Data
public class ProductInputData {

    private String name;
    private Double price;
    private String category;
    private Double discount;
    private String description;
}
