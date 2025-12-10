package MembershipManagement;

public class Membership {

    private String msId;
    private String msType;
    private String msDesc;
    private double msCost;
    private int userId;

    public Membership(String msType, String msDesc, double msCost, int userId) {
        this.msType = msType;
        this.msDesc = msDesc;
        this.msCost = msCost;
        this.userId = userId;
    }

    public Membership() {
    }

    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId;
    }

    public String getMsType() {
        return msType;
    }

    public void setMsType(String msType) {
        this.msType = msType;
    }

    public String getMsDesc() {
        return msDesc;
    }

    public void setMsDesc(String msDesc) {
        this.msDesc = msDesc;
    }

    public double getMsCost() {
        return msCost;
    }

    public void setMsCost(double msCost) {
        this.msCost = msCost;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
