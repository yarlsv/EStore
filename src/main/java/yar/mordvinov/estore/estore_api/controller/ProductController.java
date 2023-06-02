package yar.mordvinov.estore.estore_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yar.mordvinov.estore.estore_api.dto.CreateProductDto;
import yar.mordvinov.estore.estore_api.dto.ProductResponseDto;
import yar.mordvinov.estore.estore_api.dto.UpdateProductDto;
import yar.mordvinov.estore.estore_db.entities.enums.ProductType;

import java.util.List;

@Tag(name = "Product Controller", description = "Контроллер для работы с компьютерами и комплектующми")
@RequestMapping("/api/v1/product")
@Validated
public interface ProductController {

    @Operation(summary = "Добавить новый продукт")
    @PostMapping
    Long addProduct(@Validated @RequestBody  CreateProductDto productDto);
    @Operation(summary = "Редактировать продукт")
    @PatchMapping
    void updateProduct(@Validated @RequestBody UpdateProductDto productDto);
    @Operation(summary = "Получить продукты по типу")
    @GetMapping("/type")
    List<ProductResponseDto> getProductsByType(@RequestParam ProductType type);
    @Operation(summary = "Получить продукт по id")
    @GetMapping("/{id}")
    ProductResponseDto getProductById(@PathVariable ("id") Long id);
}
