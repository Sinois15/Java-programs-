
public class Result {

    private String qnum;
    private String cans;
    private String fans;
    private String status;

    public Result(String qNum, String cAns, String fAns, String status) {
        this.qnum = qNum;
        this.cans = cAns;
        this.fans = fAns;
        this.status = status;
    }

    public String getcAns() {
        return cans;
    }

    public String getfAns() {
        return fans;
    }

    public String getqNum() {
        return qnum;
    }

    public String getStatus() {
        return status;
    }
}
