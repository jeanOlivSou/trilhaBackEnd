package trilha.back.financys.infrastructure.exceptions;


public class DivideByZeroException extends ArithmeticException{


    public DivideByZeroException() {
    }

    public DivideByZeroException(String msg) {
        super(msg);
    }
}
