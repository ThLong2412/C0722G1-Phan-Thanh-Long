package case_study.model;

public class Contract {
    private String numberContract;
    private String codeBooking;
    private String advanceStake;
    private String paySum;
    private String codeCustomer;

    public Contract() {}

    public Contract(String numberContract, String codeBooking, String advanceStake, String paySum, String codeCustomer) {
        this.numberContract = numberContract;
        this.codeBooking = codeBooking;
        this.advanceStake = advanceStake;
        this.paySum = paySum;
        this.codeCustomer = codeCustomer;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public String getAdvanceStake() {
        return advanceStake;
    }

    public void setAdvanceStake(String advanceStake) {
        this.advanceStake = advanceStake;
    }

    public String getPaySum() {
        return paySum;
    }

    public void setPaySum(String paySum) {
        this.paySum = paySum;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberContract='" + numberContract + '\'' +
                ", codeBooking='" + codeBooking + '\'' +
                ", advanceStake='" + advanceStake + '\'' +
                ", paySum='" + paySum + '\'' +
                ", codeCustomer='" + codeCustomer + '\'' +
                '}';
    }
}
