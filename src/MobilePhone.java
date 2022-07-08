import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contactslist=new ArrayList<Contacts>();

    public void addContact(Contacts c){
        contactslist.add(c);
    }

    public ArrayList<Contacts> getContactsList() {
        return contactslist;
    }
    private void modify(Contacts o,String newNumber){
        int index=contactslist.indexOf(o);
        if(index>=0){
            contactslist.get(index).setPhoneNo(newNumber);
        }
        else
        {
            System.out.println("Contact does not exist.");
        }

    }
    private void remove(Contacts o){
        int index=contactslist.indexOf(o);
        if(index>=0){
            contactslist.remove(index);
        }
        else
        {
            System.out.println("Contact does not exist.");
        }


    }
    private String searchContact(Contacts o){
        int index=contactslist.indexOf(o);
        if(index>=0){
            return "Contact found: \nName: "+contactslist.get(index).getName()+"\nPhoneNo: "+contactslist.get(index).getPhoneNo()+"\n";
        }
        else{
            return "Contact not found";
        }
    }
    public void process(Contacts o,String phoneNo){
        modify(o,phoneNo);
    }
    public void process(Contacts o){
        remove(o);
    }
    public String processSearch(Contacts o){
        return this.searchContact(o);
    }


}
