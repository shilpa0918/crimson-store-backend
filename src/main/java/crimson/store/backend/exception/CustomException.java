package crimson.store.backend.exception;

public class CustomException extends RuntimeException{
    public CustomException(String errorMsg){
        super(errorMsg);
    }
}
