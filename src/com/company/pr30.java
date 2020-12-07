package com.company;

public class pr30 {
    public static void main(String[] args) {
        iQueue<Integer> Q = new ArrayQueue<>();
        for (int i = 0; i < 20; i+=2) {
            Q.enter(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Q.peek());
            System.out.println(Q.poll());
        }

        iQueue<Integer> q = new LinkedQueue<>();
        for (int i = 0; i < 20; i+=2) {
            q.enter(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(q.peek());
            System.out.println(q.poll());
            }
        }
    }
interface iQueue<E> {
    void enter(E x);
    E peek();
    E poll();
}
//Очередь на ЛОС
class LinkedQueue<E> implements iQueue<E>{
    Node<E> last=null;
    Node<E> first=null;
    public void enter(E x){
        if(first==null){
            first=new Node<E>(x);
            last=new Node<E>(x);
        }else{
            last.next=new Node<E>(x);
            last=last.next;
        }
    }
    public E peek(){
        if(first==null)
            return null;
        else
            return first.value;
    }
    public E poll(){
        if(first==null)
            return null;
        else {
            E val = first.value;
            first = first.next;
            return val;
        }
    }
}
//Узел
class Node<E> {
    Node<E> next;
    E value;
    public Node(E x) {
        this.value = x;
    }
}
//Очередь на массиве
class ArrayQueue<E> implements iQueue<E> {
    Object[] queue=new Object[10];
    private int maxSize;
    private int nElem;
    private int front;
    private int rear;

    public ArrayQueue(){
        rear = -1;
        front = 0;
        nElem = 0;
    }

    public void enter(E elem) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = elem;
        nElem++;
    }
    public E poll() {
        if(nElem == 0)
            return null;
        else {
            Object temp = queue[front++];
            if (front == maxSize) {
                front = 0;
            }
            nElem--;
            return (E)temp;
        }

    }

    public E peek() {
        if(nElem == 0)
            return null;
        else {
            Object temp = queue[front];
            return (E)temp;
        }
    }
}