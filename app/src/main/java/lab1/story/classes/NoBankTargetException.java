package lab1.story.classes;

public class NoBankTargetException extends RuntimeException {
    NoBankTargetException(){};
    NoBankTargetException(String msg) {
        super(msg);
    }
}
