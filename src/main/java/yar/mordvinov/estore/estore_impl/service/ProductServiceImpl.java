package yar.mordvinov.estore.estore_impl.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yar.mordvinov.estore.estore_api.dto.CreateProductDto;
import yar.mordvinov.estore.estore_api.dto.ProductResponseDto;
import yar.mordvinov.estore.estore_api.dto.UpdateProductDto;
import yar.mordvinov.estore.estore_api.service.ProductService;
import yar.mordvinov.estore.estore_db.entities.Product;
import yar.mordvinov.estore.estore_db.entities.enums.ProductType;
import yar.mordvinov.estore.estore_db.repository.ProductRepository;
import yar.mordvinov.estore.estore_impl.exceptions.ProductNotFoundException;
import yar.mordvinov.estore.estore_impl.mapper.ProductMapper;
import yar.mordvinov.estore.estore_impl.validation.FeatureValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final Map<String, FeatureValidator> validatorMap;
    @Override
    @Transactional
    public Long addProduct(CreateProductDto productDto) {
        validatorMap.get(productDto.getProductType().toString()).validate(productDto.getFeature());
        Product product = mapper.toProduct(productDto);
        productRepository.saveAndFlush(product);
        log.info("Продукт {} с id: {} успешно создан", product.getProductType(), product.getId());
        return product.getId();
    }

    @Override
    @Transactional
    public void updateProduct(UpdateProductDto productDto) {
        Optional<Product> product = Optional.ofNullable(productRepository.findById(productDto.getId())
                .orElseThrow(() -> new ProductNotFoundException(productDto.getId())));
        mapper.toProduct(productDto, product.get());
        validatorMap.get(product.get().getProductType().toString()).validate(product.get().getFeature());
        productRepository.save(product.get());
        log.info("Продукт {} с id: {} был успешно отредактирован", productDto.getProductType(), productDto.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> getProductsByType(ProductType type) {
        return productRepository.getProductsByProductType(type).stream()
                .map(mapper::toProductResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return mapper.toProductResponseDto(product);
    }
}
