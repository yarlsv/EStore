package yar.mordvinov.estore.estore_impl.validation;

import org.springframework.stereotype.Component;
import yar.mordvinov.estore.estore_impl.exceptions.InvalidFeatureException;

import java.util.List;

@Component("LAPTOP")
public class LaptopValidator implements FeatureValidator{

    private final List<Integer> sizes = List.of(13,14,15,17);
    @Override
    public void validate(String feature) {

        int size;
        try {
            size = Integer.parseInt(feature);
        } catch (IllegalArgumentException e) {
            throw new InvalidFeatureException(feature, sizes);
        }

        if(!sizes.contains(size)) {
            throw new InvalidFeatureException(feature, sizes);
        }


    }
}
