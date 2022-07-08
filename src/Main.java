import java.util.Scanner;

public class Main {
    private static MobilePhone mobilePhone=new MobilePhone();
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        printMenu();
        boolean quit=false;
        while(!quit){
            System.out.println("Enter: ");
            int x= scanner.nextInt();
            scanner.nextLine();
            switch(x){
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContacts();
                    break;
                case 3:
                    updateExistingContact();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                default:
                    quit=true;

            }
        }
        scanner.close();
    }
    public static void printMenu(){
        System.out.println("Enter :\n1. Print List of contacts\n2. Add new contacts\n3. Update Existing contact\n4. Remove contact\n5. Search/Find contacts\n6. Quit");

    }
    public static void printContacts(){
        for(int i=1;i<=mobilePhone.getContactsList().size();i++){
            System.out.println(i+". Name: "+mobilePhone.getContactsList().get(i-1).getName()+", PhoneNo: "+mobilePhone.getContactsList().get(i-1).getPhoneNo());
        }
    }
    public static void addNewContacts(){
        String name,phoneNo;
        System.out.print("Enter name: ");
        name= scanner.nextLine();

        System.out.print("Enter phoneNo:");
        phoneNo= scanner.nextLine();
        scanner.nextLine();
        if(mobilePhone.getContactsList().contains(new Contacts(name,phoneNo)))
        {
            System.out.println("Contact already exists...");
            return;
        }
        mobilePhone.getContactsList().add(new Contacts(name,phoneNo));
    }
    public static void updateExistingContact(){
        String name,phoneNo;int x=-1;
        System.out.print("Enter the contact name to be updated: ");
        name= scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter the new Phone Number: ");
        phoneNo= scanner.nextLine();
        scanner.nextLine();
        for(int i=0;i<mobilePhone.getContactsList().size();i++){
            if(mobilePhone.getContactsList().get(i).getName().equals(name)){
                x=i;break;
            }
        }
        if(x==-1){
            System.out.println("Contact not found.");return;
        }
        mobilePhone.process(mobilePhone.getContactsList().get(x),phoneNo);
    }
    public static void delete(){
        String name;
        System.out.print("Enter name of contact to delete: ");
        name= scanner.nextLine();
        scanner.nextLine();
        int x=-1;
        for(int i=0;i<mobilePhone.getContactsList().size();i++){
            if(mobilePhone.getContactsList().get(i).getName().equals(name)){
                x=i;break;
            }
        }
        if(x==-1){
            System.out.println("Contact not found.");
            return;
        }
        mobilePhone.process(mobilePhone.getContactsList().get(x));


    }
    public static void search(){
        String name;
        System.out.print("Enter name to search: ");
        name= scanner.nextLine();
        scanner.nextLine();
        int x=-1;
        for(int i=0;i<mobilePhone.getContactsList().size();i++){
            if(mobilePhone.getContactsList().get(i).getName().equals(name)){
                x=i;break;
            }
        }
        if(x==-1){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println(mobilePhone.processSearch(mobilePhone.getContactsList().get(x)));
    }
}
