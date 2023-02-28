package lab1.classes;

public class BankPermissionException extends RuntimeException {
    BankPermissionException(){};
    BankPermissionException(String msg) {
        super(msg);
    }
}
