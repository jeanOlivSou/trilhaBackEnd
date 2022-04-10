package trilha.back.financys.adapters.exceptions;


public class DivideByZeroException extends ArithmeticException{


    public DivideByZeroException() {
    }

    public DivideByZeroException(String msg) {
        super(msg);
    }
}
