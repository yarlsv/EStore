package yar.mordvinov.estore.estore_impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import yar.mordvinov.estore.estore_api.config.MapperConfig;
import yar.mordvinov.estore.estore_api.dto.CreateProductDto;
import yar.mordvinov.estore.estore_api.dto.ProductResponseDto;
import yar.mordvinov.estore.estore_api.dto.UpdateProductDto;
import yar.mordvinov.estore.estore_db.entities.Product;

@Mapper(config = MapperConfig.class)
public interface ProductMapper {

    Product toProduct(CreateProductDto productDto);
    void toProduct(UpdateProductDto productDto, @MappingTarget Product product);
    ProductResponseDto toProductResponseDto(Product product);
}
