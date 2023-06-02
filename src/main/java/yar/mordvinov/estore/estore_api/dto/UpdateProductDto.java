package yar.mordvinov.estore.estore_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import yar.mordvinov.estore.estore_db.entities.enums.ProductType;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateProductDto {
    @NotNull
    @JsonProperty("id")
    private Long id;
    @JsonProperty("serial_number")
    private String serialNumber;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("product_type")
    private ProductType productType;
    @JsonProperty("feature")
    private String feature;
}
