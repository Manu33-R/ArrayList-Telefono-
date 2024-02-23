import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts = new ArrayList<Contacto>();

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<Contacto>();
    }

    private int findContact(Contacto contacto){
        if (myContacts.contains(contacto))
            return myContacts.indexOf(contacto);
        else
            return -1;
    }

    private int findContactName(String name){
        int res = -1;
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                res = i;
                i = myContacts.size();
            }
        }
        return res;
    }

    public boolean addNewContact(Contacto contacto){
        if (findContactName(contacto.getName()) == -1){
            myContacts.add(contacto);
            return true;
        }else
            return false;
    }

    public boolean updateContact(Contacto oldContact,Contacto newContact){
        if (findContact(oldContact) >= 0){
            if (findContact(newContact) == -1 && queryContact(newContact.getName()) == null){
                myContacts.set(myContacts.indexOf(oldContact),newContact);
                return true;
            }else
                return false;
        }else
            return false;
    }

    public boolean removeContact(Contacto contact){
        if (findContact(contact) >= 0){
            myContacts.remove(contact);
            return true;
        }else
            return false;
    }

    public Contacto queryContact(String nombre){
        if (findContactName(nombre) >= 0){
            return myContacts.get(findContactName(nombre));
        }else
            return null;
    }

    public void printContacts(){
        System.out.println("Lista de contactos:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i+1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }


}
