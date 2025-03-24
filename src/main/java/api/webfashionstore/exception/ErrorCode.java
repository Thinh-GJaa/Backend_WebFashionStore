package api.webfashionstore.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    OPTIMISTIC_FAILURE(10007,HttpStatus.CONFLICT,"Optimistic Lock");


    private final int code;
    private final HttpStatus status;
    private final String messageTemplate;

    ErrorCode(int code, HttpStatus status, String messageTemplate) {
        this.code=code;
        this.status = status;
        this.messageTemplate = messageTemplate;
    }

    public String formatMessage(Object... args) {
        return String.format(messageTemplate.replace("{}", "%s"), args);
    }
}

