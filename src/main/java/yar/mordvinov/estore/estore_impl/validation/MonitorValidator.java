package yar.mordvinov.estore.estore_impl.validation;

import org.springframework.stereotype.Component;
import yar.mordvinov.estore.estore_impl.exceptions.InvalidFeatureException;

@Component("MONITOR")
public class MonitorValidator implements FeatureValidator {

    @Override
    public void validate(String feature) {
        int diagonal;
        try {
            diagonal = Integer.parseInt(feature);
        } catch (IllegalArgumentException e) {
            throw new InvalidFeatureException("Введите числовое значение");
        }

        if (diagonal < 0 ) {
            throw new InvalidFeatureException("Введите значение больше 0");
        }
    }
}
