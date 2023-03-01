package lab1.story.classes;

public class BankPermissionException extends RuntimeException {
    BankPermissionException(){};
    BankPermissionException(String msg) {
        super(msg);
    }
}
