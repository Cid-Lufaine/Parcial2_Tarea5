package uaslp.objetos.list.linkedlist;

class Node <O>{
    O data;
    Node  <O> next;
    Node  <O> previous;

    Node(){
        next=null;
        previous=null;
    }
}
