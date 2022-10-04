package case_study.model.person;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer extends Person implements Serializable { // lớp khách hàng
    private String typeCustomer;
    // Loại Customer bao gồm: (Diamond, Platinium, Gold, Silver, Member).
    private String address;

    public Customer() {
    }

    public Customer(String code, String name, LocalDate dayOffBirth, String gender, String idNumbers, String phoneNumbers, String email, String typeCustomer, String address) {
        super(code, name, dayOffBirth, gender, idNumbers, phoneNumbers, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "typeCustomer = " + typeCustomer +
                ", address = " + address +
                '}';
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",getCode(),getName(),getDayOffBirth(),getGender(),getIdNumbers(),getPhoneNumbers(),getEmail(),getTypeCustomer(),getAddress());
    }
}
