package MembershipManagement;

public class Membership {
    private String msId;
    private String msType;
    private String msDesc;
    private double msCost;
    private Users.User userId;


    public Membership(String msId, String msType, String msDesc, double msCost, Users.User userId) {
        this.msId = msId;
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

    public Users.User getUserId() {
        return userId;
    }

    public void setUserId(Users.User userId) {
        this.userId = userId;
    }
}
