package furama_resort.utils.checks;

public class CheckRegexFacility {

    public boolean checkServiceCodeVilla(String serviceCode ) {
        String regex = "^SVVL-\\d{4}$";
        return serviceCode.matches(regex);
    }
    public boolean checkServiceCodeHouse (String serviceCode ) {
        String regex = "^SVHO-\\d{4}$";
        return serviceCode.matches(regex);
    }
    public boolean checkServiceCodeRoom  (String serviceCode ) {
        String regex = "^SVRO-\\d{4}$";
        return serviceCode.matches(regex);
    }
    public boolean checkServiceName(String serviceName){
        String regex="^([A-Z][a-z]+ )+$";
        return serviceName.matches(regex);
    }
}