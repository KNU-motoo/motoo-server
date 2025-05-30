package knu.motoo.tradingapi.order.exception;

import knu.motoo.commoncore.exception.BaseErrorCode;
import org.springframework.http.HttpStatus;

public enum OrderErrorCode implements BaseErrorCode {
    ORDER_NOT_FOUND("주문을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;

    OrderErrorCode(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
