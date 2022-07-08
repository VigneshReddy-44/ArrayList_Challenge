public class Contacts {
    private String phoneNo;
    private String name;

    public Contacts(String name,String phoneNo){
        this.name=name;
        this.phoneNo=phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setName(String name) {
        this.name = name;
    }
}
