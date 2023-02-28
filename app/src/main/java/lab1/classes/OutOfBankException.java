package lab1.classes;

public class OutOfBankException extends RuntimeException {

    OutOfBankException(){};
    OutOfBankException(String msg) {
        super(msg);
    }
}
