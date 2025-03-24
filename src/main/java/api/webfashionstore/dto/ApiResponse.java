package api.webfashionstore.dto;

public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    public ApiResponse() {
    }

    //Constructor dành cho những repo thành công
    public ApiResponse(T data) {
        this.status = 200;
        this.message = "Thành công";
        this.data = data;
    }

    // Constructor chỉ có status và message (data = null)
    public ApiResponse(int status, String message) {
        this(status, message, null);
    }

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

