package trilha.back.financys.exceptions;


public class DivideByZeroException extends ArithmeticException{


    public DivideByZeroException() {
    }

    public DivideByZeroException(String msg) {
        super(msg);
    }
}
