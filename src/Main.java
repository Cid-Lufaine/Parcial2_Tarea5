import uaslp.objetos.list.ArrayList.ArrayList;
import uaslp.objetos.list.List;
import uaslp.objetos.list.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {

        List<String> lista1=new LinkedList<>();
        List<String> lista2=new ArrayList<>();
        System.out.println("test del programa LinkedList");
        test(lista1);
        System.out.println("test del programa ArrayList");
        test(lista2);
    }

    public static void test(List<String> lista){

        lista.printList();

        lista.addAtFront("primero");
        lista.addAtFront("segundo");
        lista.addAtTail("tercero");
        lista.addAtTail("cuarto");
        lista.printList();
        System.out.println("el tamaño de la lista es: "+lista.getSize());

        lista.setAt(2,"quinto");
        lista.printList();
        System.out.println("el tamaño de la lista es: "+lista.getSize());


        lista.addAtFront("primero");
        lista.addAtFront("primero");
        lista.addAtFront("primero");
        lista.addAtFront("primero");
        lista.printList();
        System.out.println("el tamaño de la lista es: "+lista.getSize());

        lista.remove(100);
        lista.remove(0);
        lista.remove(8);
        lista.remove(1);
        lista.printList();
        System.out.println("el tamaño de la lista es: "+lista.getSize());

        lista.removeAllWithValue("primero");

        lista.printList();
        System.out.println("el tamaño de la lista es: "+lista.getSize());

        lista.removeAll();
        lista.printList();
        System.out.println("el tamaño de la lista es: "+lista.getSize());
        System.out.println("find del test");
        System.out.println();
    }
}