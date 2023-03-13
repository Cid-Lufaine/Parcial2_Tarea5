package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;

public class LinkedListIterator<K> implements Iterator <K>{
    private Node <K> currentNode;
    LinkedListIterator(Node<K> head){
        currentNode = head;
    }
    public boolean hasNext(){

        return currentNode!=null ;
    }
    public K next(){
        K data = currentNode.data;
        currentNode=currentNode.next;
        return data;
    }

}
