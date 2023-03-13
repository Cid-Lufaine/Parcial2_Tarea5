package uaslp.objetos.list.ArrayList;


import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList  <H>  implements List <H>{
    private static final int INITIAL_SIZE = 2;
    private Object []array;
    private int size;


    public ArrayList() {
        array = new Object[INITIAL_SIZE];
    }

    @Override
    public void addAtTail(H data) {
        if (size == array.length) {
            Object []newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {newArray[i] = array[i];}
            array = newArray;
        }
        array[size] = data;
        size++;
    }

    public void addAtFront(H data) {
        int newSize;
        if (size == array.length) {
            newSize = array.length * 2;
        } else {
            newSize = array.length;
        }
        Object[] newArray = new Object[newSize];
        newArray[0] = data;
        for (int i = 0; i < size; i++) {
            newArray[i + 1] = array[i];
        }
        array = newArray;
        size++;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            size--;
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            array[size] = null; //necessary?
        }else {
            System.out.println("index "+ index +" out of range");
        }
    }

    public void removeAll() {
        size = 0;
        array = new Object[INITIAL_SIZE];
        //taking advantage of garbage collectors
    }

    public void setAt(int index, H data) {
        if (index > 0 || index < size) {
            array[index] = data;
        }
    }

    public H getAt(int index) {
        H answer;
        if (index > 0 || index < size) {
            answer =  (H)array[index];
        } else {
            answer = null;
        }
        return answer;
    }

    public void removeAllWithValue(H data) {
        ArrayList <H> newArray = new ArrayList<>();
        int newSize=0;
        for(int i =0;i<size;i++)
        {
            if(array[i]!=data){
                newArray.addAtTail((H) array[i]);
                newSize++;
            }
        }
        array=newArray.array;
        size=newSize;
    }
    public int getSize() {return size;}

    public Iterator <H> getIterator(){
        return new  ArrayListIterator<>(this) ;
    }

    public void printList() {

        if(size!=0){

            Iterator <H> iterator = getIterator();
            while (iterator.hasNext()){
                String data_list = (String)iterator.next();
                System.out.print(data_list+" ");
            }
            System.out.println();
        }else{
            System.out.println("Empty list");
        }
    }


}
