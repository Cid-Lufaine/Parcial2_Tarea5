package uaslp.objetos.list.ArrayList;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator <H> implements Iterator <H>{
    private final ArrayList  <H> iterator;
    private int index;
    ArrayListIterator(ArrayList  <H> element){
        index = 0;
        iterator=element;
    }
    public boolean hasNext(){
        if(index< iterator.getSize())
        {
            return iterator.getAt(index)!=null;
        }else {
            return false;
        }

    }
    public H next(){

        H data = iterator.getAt(index);
        index++;
        return data;
    }

}
