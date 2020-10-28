package com.company;

class List{
    List next;
    int value;
}
public class Collection {
    private List first;
    private List last;
    void add(int x){
        List el = new List();
        el.value=x;
        if(last==null){
            first=el;
        }
        else
        {
            last.next=el;
        }
        last=el;
    }
    void delete(int x){
        if (last==first){
            last=first=null;
            return;
        }
        if (first.value==x)
        {
            first=first.next;
            return;
        }
        List temp=first;
        while(temp.next!=null){
            if (temp.next.value==x){
                {
                    if (last==temp.next)
                        last=temp;
                }
                temp.next=temp.next.next;
                return;
            }
            temp=temp.next;
        }
    }
    void searchID(int id){
        List temp=first;
        boolean flag=false;
        int k=0;
        while(temp!=null){
                k++;
                if (k==id){
                    System.out.println("Элемент на "+id+" позиции - "+temp.value);
                    flag=true;
                    break;
                }
                temp=temp.next;
            }
            if(!flag){
                System.out.println("Элемент не найден");
            }
        }
    void searchval(int val){
        List temp=first;
        int id=0;
        boolean flag=false;
            while(temp!=null){
                id++;
                if (temp.value==val){
                    System.out.println("Элемент на "+id+" позиции - "+temp.value);
                    flag=true;
                    break;
                }
                temp=temp.next;
            }
            if(!flag){
                System.out.println("Элемент не найден");
            }
        }
        void searchmin(){
            List temp=first;
            int min=2147483646;
            while(temp!=null){
                if (temp.value<min)
                    min=temp.value;
                temp=temp.next;
            }
            System.out.println("Минимальное значение - "+min);
        }
    void searchmax(){
        List temp=first;
        int max=-2147483646;
        while(temp!=null){
            if (temp.value>max)
                max=temp.value;
            temp=temp.next;
        }
        System.out.println("Максимальное значение - "+max);
    }
    void Arifmetic(){
        List temp=first;
        int id=0;
        int S=0;
        while(temp!=null){
            id++;
            S+=temp.value;
            temp=temp.next;
        }
        System.out.println("Среднее арифметическое  - "+(double)S/id);
    }
    void print(){
        List temp=first;
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
    }
}
class TEST{
    public static void main(String[] args) {
        Collection test = new Collection();
        System.out.println("Добавление чисел от 1 до 10");
        for (int i=1;i<10;i++){
            test.add(i);
        }
        System.out.println("Вывод:");
        test.print();
        System.out.println();
        System.out.println("Удаление значения 6");
        test.delete(6);
        System.out.println("Вывод:");
        test.print();
        System.out.println();
        System.out.println("Поиск по индексу 4");
        test.searchID(4);
        System.out.println("Поиск по значению 7");
        test.searchval(7);
        test.Arifmetic();
        test.searchmax();
        test.searchmin();

    }
}
