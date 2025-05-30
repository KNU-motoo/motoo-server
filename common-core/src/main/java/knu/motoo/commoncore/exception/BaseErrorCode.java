package knu.motoo.commoncore.exception;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    String name(); // enum 기본 메서드
    String getMessage();
    HttpStatus getHttpStatus();

}
