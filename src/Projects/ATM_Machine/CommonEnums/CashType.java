package Projects.ATM_Machine.CommonEnums;

public enum CashType {
    BILL_100(100),
    BILL_200(200),
    BILL_500(500);

    public final int value;

    CashType(int value) {
        this.value = value;
    }
}
