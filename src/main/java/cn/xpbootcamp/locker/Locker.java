package cn.xpbootcamp.locker;

public class Locker {
    public static final String DEPOSIT_BAG_FAILED = "存包失败！";
    private int idleNum;

    Locker(int idleNum) {
        this.idleNum = idleNum;
    }

    public String depositBag() {
        return DEPOSIT_BAG_FAILED;
    }
}
