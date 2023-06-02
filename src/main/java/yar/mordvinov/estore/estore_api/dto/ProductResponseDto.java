package yar.mordvinov.estore.estore_api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import yar.mordvinov.estore.estore_db.entities.enums.ProductType;

@Data
public class ProductResponseDto {
    @NotNull
    private Long id;
    @NotNull
    private String serialNumber;
    @NotNull
    private String manufacturer;
    @NotNull
    @DecimalMin("0.0")
    private Double price;
    @NotNull
    @Min(0)
    private Integer quantity;
    @NotNull
    private ProductType productType;
    @NotNull
    private String feature;
}
