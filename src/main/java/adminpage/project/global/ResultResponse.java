package adminpage.project.global;

import lombok.Getter;

@Getter
public class ResultResponse {

    private int status;

    private String message;

    private Object data;

    public ResultResponse(ResultCode resultCode, Object data) {
        this.status = resultCode.getStatus();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}