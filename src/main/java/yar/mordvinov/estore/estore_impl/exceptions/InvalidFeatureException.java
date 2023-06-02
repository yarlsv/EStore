package yar.mordvinov.estore.estore_impl.exceptions;

import java.util.List;


public class InvalidFeatureException extends RuntimeException{

    public InvalidFeatureException(String message) {
        super();
    }
    public InvalidFeatureException(String feature, List list) {
        super(String.format("Некорректное свойство: %s. Доступные значения - %s", feature, list.toString()));
    }
}
