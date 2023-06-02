package yar.mordvinov.estore.estore_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import yar.mordvinov.estore.estore_db.entities.enums.ProductType;

import static yar.mordvinov.estore.estore_api.util.OpenApiConstants.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProductDto {

    @NotNull
    @Schema(example = SERIAL_NUMBER)
    private String serialNumber;
    @NotNull
    @Schema(example = MANUFACTURER)
    private String manufacturer;
    @NotNull
    @Schema(example = PRICE)
    @DecimalMin("0.0")
    private Double price;
    @NotNull
    @Schema(example = QUANTITY)
    @Min(0)
    private Integer quantity;
    @NotNull
    @Schema(example = TYPE)
    private ProductType productType;
    @NotNull
    @Schema(example = FEATURE)
    private String feature;
}
