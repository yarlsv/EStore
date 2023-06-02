package yar.mordvinov.estore.estore_impl.validation;

import org.springframework.stereotype.Component;
import yar.mordvinov.estore.estore_db.entities.enums.FormFactor;
import yar.mordvinov.estore.estore_impl.exceptions.InvalidFeatureException;

import java.util.Arrays;

@Component("DESKTOP")
public class DesktopValidator implements FeatureValidator{

    @Override
    public void validate(String feature) {
        try {
            FormFactor.valueOf(feature);
        } catch (IllegalArgumentException e) {
            throw new InvalidFeatureException(feature, Arrays.stream(FormFactor.values()).toList());
        }
    }
}
