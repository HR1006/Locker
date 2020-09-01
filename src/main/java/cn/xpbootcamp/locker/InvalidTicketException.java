package cn.xpbootcamp.locker;

public class InvalidTicketException extends RuntimeException {
    public static final String PICK_UP_BAG_FAILED = "取包失败，非法票据！";
    public InvalidTicketException(String message) {
        super(message);
    }
}
