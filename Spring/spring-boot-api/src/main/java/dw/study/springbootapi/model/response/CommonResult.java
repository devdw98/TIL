package dw.study.springbootapi.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult { //api 처리상태 및 메세지 담는 공통 모델
    @ApiModelProperty(value = "응답 성공 여부 : true/false")
    private boolean success;
    @ApiModelProperty(value = "응답 코드 번호 : >= 0 정상, < 0 비정상")
    private int code;
    @ApiModelProperty(value = "응답 메세지")
    private String msg;
}
