package dw.study.springbootapi.service;

import dw.study.springbootapi.model.response.CommonResult;
import dw.study.springbootapi.model.response.ListResult;
import dw.study.springbootapi.model.response.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    public enum CommonResponse{ //api 요청 결과에 대한 code, msg 정의
        SUCCESS(0,"성공"),
        FAIL(-1,"실패");
        int code;
        String msg;

        CommonResponse(int code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    //단일건 결과 처리
    public <T>SingleResult<T> getSingleResult(T data){
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    //다중건 결과 처리
    public <T> ListResult<T> getListResult(List<T> data){
        ListResult<T> result = new ListResult<>();
        result.setList(data);
        setSuccessResult(result);
        return result;
    }

    //성공 결과만 처리
    public CommonResult getSuccessResult(){
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    //실패 결과만 처리
    public CommonResult getFailResult(int code, String msg){
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    //결과 모델에 api 요청 성공 데이터 세팅
    private void setSuccessResult(CommonResult result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

}
