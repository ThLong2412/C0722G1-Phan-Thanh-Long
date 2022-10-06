package furama_resort.model;

public class Contract {
    private int contractNumber;
    private String codeBooking;
    private double deposit;
    private double totalMoney;
    private String codeCustomer;

    public Contract() {
    }

    public Contract(int contractNumber, String codeBooking, double deposit, double totalMoney, String codeCustomer) {
        this.contractNumber = contractNumber;
        this.codeBooking = codeBooking;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.codeCustomer = codeCustomer;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
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
                "contractNumber=" + contractNumber +
                ", codeBooking='" + codeBooking + '\'' +
                ", deposit=" + deposit +
                ", totalMoney=" + totalMoney +
                ", codeCustomer='" + codeCustomer + '\'' +
                '}';
    }
}
