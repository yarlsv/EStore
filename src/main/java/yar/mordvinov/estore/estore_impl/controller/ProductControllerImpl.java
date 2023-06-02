package yar.mordvinov.estore.estore_impl.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import yar.mordvinov.estore.estore_api.controller.ProductController;
import yar.mordvinov.estore.estore_api.dto.CreateProductDto;
import yar.mordvinov.estore.estore_api.dto.ProductResponseDto;
import yar.mordvinov.estore.estore_api.dto.UpdateProductDto;
import yar.mordvinov.estore.estore_api.service.ProductService;
import yar.mordvinov.estore.estore_db.entities.enums.ProductType;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    @Override
    public Long addProduct(CreateProductDto productDto) {
        log.info("Creating {}", productDto.toString());
        return productService.addProduct(productDto);
    }

    @Override
    public void updateProduct(UpdateProductDto productDto) {
        log.info("Updating {} by id: {}", productDto.getProductType(), productDto.getId());
        productService.updateProduct(productDto);
    }

    @Override
    public List<ProductResponseDto> getProductsByType(ProductType type) {
        log.info("Getting products by type: {}", type);
        return productService.getProductsByType(type);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        log.info("Get product by id: {}", id);
        return productService.getProductById(id);
    }
}
