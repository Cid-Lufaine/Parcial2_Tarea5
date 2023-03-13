package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class LinkedList <T> implements List <T>{
    private Node <T> head;
    private Node <T> tail;
    private int size;

    public LinkedList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    @Override
    public void addAtTail(T data){
        Node <T> node = new    Node<>();
        node.data=data;
        if(head==null) {
            head=node;
        }else
        {
            node.previous=tail;
            tail.next=node;
        }
        tail=node;
        size++;
    }
    public void addAtFront(T data){
        Node <T> node = new Node<>();
        node.data=data;
        if(tail==null) {
            tail=node;
        }else
        {
            node.next=head;
            head.previous=node;
        }
        head=node;
        size++;
    }
    public void remove(int index){
        if(index<0 || index>= size){
            System.out.println("index out of range");
        }else{

            if(index==0||index==size-1) {
                if(index==0){
                    Node <T> NodeAtHead=head;
                    head=head.next;
                    head.previous=null;

                    //para que sea aislado y eliminado por recolector?
                    NodeAtHead.next=null;
                    NodeAtHead.previous=null;

                }else{
                    Node <T> NodeAtTail=tail;
                    tail=tail.previous;
                    tail.next=null;

                    //para que sea aislado y eliminado por recolector?
                    NodeAtTail.next=null;
                    NodeAtTail.previous=null;
                }
            }else {
                Node <T> currentNode=head;
                for (int current_index = 0; current_index < index; current_index++) {
                    currentNode = currentNode.next;
                }

                Node <T> previousNode=currentNode.previous;
                Node <T> nextNode=currentNode.next;

                previousNode.next=nextNode;
                nextNode.previous=previousNode;

                //para que sea aislado y eliminado por recolector?
                currentNode.previous=null;
                currentNode.next=null;

            }
            size--;
        }
    }
    public void removeAll(){
        head=null;
        tail=null;
        size=0;

        //all the nodes are cleaned by the recolector?
    }
    public void setAt(int index, T data){

        if(index<0 || index> size){
            System.out.println("index out of range");
        }else{

            if(index==0||index==size) {
                if(index==0){
                    head.data=data;
                }else{
                    tail.data=data;
                }
            }else {
                Node <T> currentNode=head;
                for (int current_index = 0; current_index < index; current_index++) {
                    currentNode = currentNode.next;
                }
                currentNode.data= data;
            }
        }

    }
    public void insertAt(int index, T data){

        if(index<0 || index> size){
            System.out.println("index out of range");
        }else{

            if(index==0||index==size) {
                if(index==0){
                    addAtFront(data);
                }else{
                    addAtTail(data);
                }
            }else {
                Node <T> currentNode= head;
                for (int current_index = 0; current_index < index; current_index++) {
                    currentNode = currentNode.next;
                }

                Node <T> previousNode=currentNode.previous;

                Node <T> NewNode= new Node<>();
                NewNode.data=data;

                previousNode.next=NewNode;
                NewNode.previous=previousNode;

                NewNode.next=currentNode;
                currentNode.previous=NewNode;

            }
            size++;
        }

    }
    public T getAt(int index) {
        if(index<0 || index >= size ){
            return null;
        }
        Node <T> currentNode=head;
        for( int current_index=0; current_index < index; current_index++)
        {
            currentNode=currentNode.next;
        }
        return currentNode.data;
    }

    public int getSize(){
        return this.size;
    }

    public Iterator <T>getIterator(){
        return new LinkedListIterator<>(head);
    }

    public void removeAllWithValue(T data){
        Node <T> currentNode=head;
        for( int current_index=0; current_index < size; current_index++) {

            if (currentNode.data == data) {


                Node <T> previousNode = currentNode.previous;
                Node <T> nextNode = currentNode.next;

                if (previousNode != null) {
                    previousNode.next = nextNode;
                } else {
                    head = nextNode;
                }
                if (nextNode != null) {
                    nextNode.previous = previousNode;
                } else {
                    tail = previousNode;
                }
                size--;
                //para que sea aislado y eliminado por recolector?
                currentNode.previous = null;
                currentNode.next = null;
                //retomando la exploracion de la lista
                currentNode = nextNode;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    public void printList() {

        if(head!=null){

            Iterator <T> iterator = getIterator();
            while (iterator.hasNext()){
                T data_list = iterator.next();
                System.out.println(data_list);
            }
        }else{
            System.out.println("Empty list");
        }
    }



}
