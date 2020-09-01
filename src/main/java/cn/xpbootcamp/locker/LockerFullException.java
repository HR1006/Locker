package cn.xpbootcamp.locker;

public class LockerFullException extends RuntimeException {
    public static final String DEPOSIT_BAG_FAILED = "存包失败，储物柜已满！";
    public LockerFullException(String depositBagFailed) {
    }
}
