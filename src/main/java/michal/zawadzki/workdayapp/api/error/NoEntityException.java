package michal.zawadzki.workdayapp.api.error;

public class NoEntityException extends RuntimeException{

    public NoEntityException(String message) {
        super(message);
    }

}