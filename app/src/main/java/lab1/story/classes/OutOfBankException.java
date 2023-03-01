package lab1.story.classes;

public class OutOfBankException extends RuntimeException {

    OutOfBankException(){};
    OutOfBankException(String msg) {
        super(msg);
    }
}
