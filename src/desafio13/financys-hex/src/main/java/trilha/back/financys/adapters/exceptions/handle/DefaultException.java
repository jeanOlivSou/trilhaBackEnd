package trilha.back.financys.adapters.exceptions.handle;

import java.time.LocalDateTime;

public class DefaultException {
    private Integer status;
    private String message;
    private LocalDateTime dateTime;

    public DefaultException(Integer status, String message, LocalDateTime dateTime) {
        this.status = status;
        this.message = message;
        this.dateTime = dateTime;
    }

    public DefaultException() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
