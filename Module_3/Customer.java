package Module_3;

public class Customer {

    private String name;
    private String address;
    private String city;
    private String zipCode;
    private Account account = new Account();

    public Customer(){

    }

    public Customer(String name, String address, String city, String zipcode){
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipCode = zipcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString(){
        return "Name:" + name + "\n" + 
        "Address:" + address + "\n" +
        "City:" + city + "\n" +
        "Zip:" +zipCode;

    }


}