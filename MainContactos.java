import java.util.Scanner;

public class MainContactos {

    private static Scanner sc = new Scanner(System.in);
    private static TelefonoMovil tel = new TelefonoMovil("347507189");
    private static Contacto c = new Contacto("","");

    public static void main(String[] args) {
        menu();
        int opcion = -1;
        while (opcion!=0){
            opcion = -1;
            try{
                System.out.println("Elige una opcion: ");
                opcion= sc.nextInt();
            }catch (Exception e){
                sc.nextLine();
            }
            switch (opcion){
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                case 1:
                    tel.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    menu();
                    break;
                default:
                    System.out.println("Opcion no válida.");
                    menu();
            }
        }
    }

    public static void menu() {
        System.out.println("---Menú de opciones---");
        System.out.println("0. Salir");
        System.out.println("1. Imprimir contactos");
        System.out.println("2. Agregar un contacto");
        System.out.println("3. Actualizar un contacto existente");
        System.out.println("4. Eliminar un contacto");
        System.out.println("5. Buscar un contacto");
        System.out.println("6. Muestra el menu de opciones");
    }

    public static void addContact() {
        System.out.println("Introduce el nombre del contacto: ");
        String nombre = sc.next();
        String numero = valTel(nombre);
        c = new Contacto(nombre,numero);
        if (tel.addNewContact(c)){
            tel.addNewContact(c);
            System.out.println("Contacto añadido.");
        }
        else
            System.out.println("Error al añadir el contacto.");
    }

    public static void updateContact() {
        System.out.println("Introduce el nombre del contacto que quieres actualizar: ");
        String nombre = sc.next();
        if (tel.queryContact(nombre) == null){
            System.out.println("El contacto que quieres actualizar no existe.");
        }else{
            System.out.println("Introduce el nuevo nombre para el contacto: ");
            String newname = sc.next();
            String numero = valTel(newname);
            c=new Contacto(newname,numero);
            if (tel.updateContact(tel.queryContact(nombre),c)){
                tel.updateContact(tel.queryContact(nombre),c);
                System.out.println("Contacto actualizado con éxito.");
            }else{
                System.out.println("Error al actualizar el contacto.");
            }
        }
    }

    public static void removeContact() {
        System.out.println("Introduce el nombre del contacto que quieres eliminar: ");
        String nombre = sc.next();
        if (tel.removeContact(tel.queryContact(nombre))){
            tel.removeContact(tel.queryContact(nombre));
            System.out.println("Contacto eliminado.");
        }else{
            System.out.println("El contacto que quieres eliminar no existe.");
        }
    }

    public static void searchContact() {
        System.out.println("Introduce el nombre del contacto que quieres buscar: ");
        String nombre = sc.next();
        if (tel.queryContact(nombre) == null){
            System.out.println("El contacto que intentas buscar no existe.");
        }else{
            System.out.println("---Informacion del contacto---");
            System.out.println("Nombre: " + tel.queryContact(nombre).getName());
            System.out.println("Número: " + tel.queryContact(nombre).getPhoneNumber());
        }
    }

    public static String valTel(String nombre) {
        String numero = "-1";
        while (!numero.matches("[0-9]{9}")){
            System.out.println("Introduce el numero de telefono para el contacto " + nombre + ": ");
            numero = sc.next();
            if (!numero.matches("[0-9]{9}"))
                System.out.println("Error al introducir el numero de telefono. Prueba de nuevo.");
        }
        return numero;
    }
}
