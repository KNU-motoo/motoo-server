package knu.motoo.commoncore.exception;

public class MotooException extends RuntimeException {
    private final BaseErrorCode errorCode;

    public MotooException(BaseErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public BaseErrorCode getErrorCode() {
        return errorCode;
    }

}
