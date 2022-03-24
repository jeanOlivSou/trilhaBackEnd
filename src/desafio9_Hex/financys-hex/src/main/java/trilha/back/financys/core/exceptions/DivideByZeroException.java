package trilha.back.financys.core.exceptions;


public class DivideByZeroException extends ArithmeticException{


    public DivideByZeroException() {
    }

    public DivideByZeroException(String msg) {
        super(msg);
    }
}
