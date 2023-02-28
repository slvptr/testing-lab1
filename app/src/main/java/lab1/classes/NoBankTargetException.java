package lab1.classes;

public class NoBankTargetException extends RuntimeException {
    NoBankTargetException(){};
    NoBankTargetException(String msg) {
        super(msg);
    }
}
