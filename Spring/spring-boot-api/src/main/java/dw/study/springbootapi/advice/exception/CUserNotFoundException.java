package dw.study.springbootapi.advice.exception;

public class CUserNotFoundException extends RuntimeException{
    public CUserNotFoundException(String msg, Throwable t){
        super(msg, t);
    }
    public CUserNotFoundException(String msg){ //Controller 에서 메세지 받아 예외 처리 시 사용
        super(msg);
    }
    public CUserNotFoundException(){
        super();
    }
}
