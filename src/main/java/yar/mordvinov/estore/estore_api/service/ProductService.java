package yar.mordvinov.estore.estore_api.service;

import yar.mordvinov.estore.estore_api.dto.CreateProductDto;
import yar.mordvinov.estore.estore_api.dto.ProductResponseDto;
import yar.mordvinov.estore.estore_api.dto.UpdateProductDto;
import yar.mordvinov.estore.estore_db.entities.enums.ProductType;

import java.util.List;

public interface ProductService {
    Long addProduct(CreateProductDto productDto);
    void updateProduct(UpdateProductDto productDto);
    List<ProductResponseDto> getProductsByType(ProductType type);
    ProductResponseDto getProductById(Long id);
}
