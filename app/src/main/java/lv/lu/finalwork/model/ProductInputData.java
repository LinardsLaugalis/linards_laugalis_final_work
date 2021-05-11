package lv.lu.finalwork.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductInputData {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Price is mandatory")
    @Positive
    private Double price;

    @NotBlank(message = "Category is mandatory")
    private String category;

    private Double discount;
    private String description;
}
