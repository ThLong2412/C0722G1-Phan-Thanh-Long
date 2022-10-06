package furama_resort.utils.checks;

public class CheckException {
    public void checkAreaUse(double areaUse) throws Check{
        if (areaUse<=30){
            throw new Check("Diện tích phải lớn hơn 30,mời nhập lại");
        }
    }
    public void checkRentaClosts(double rentaClosts) throws Check{
        if (rentaClosts<=0){
            throw new Check("Chi phí thuê phải là số dương");
        }
    }
    public void checkPeople(int people) throws Check{
        if (people<0||people>20){
            throw new Check("Số lượng người tối đa phải lớn hơn 0 và nhỏ hơn 20");
        }
    }
    public void checkNumberFloors(int numberFloors) throws Check{
        if (numberFloors<=0){
            throw new Check("Số tầng không được nhỏ hơn 0");
        }
    }
}
