package com.company;
import java.util.ArrayList;

public abstract class Things
{
    public abstract void Info();
}
class Table extends Things{

    public void Info(){
        System.out.println("СТОЛ - Длина: 2м"+" Высота: 1м"+" Цена: 500 рублей");
    }

}
class Chair extends Things{
    public void Info(){
        System.out.println("СТУЛ - Длина: 0.5м"+" Высота: 1.5м"+ " Цена: 200 рублей");
    }

}
class Person
{
ArrayList<Things> cap=new ArrayList<>();
void take(Things furn){
    cap.add(furn);
}
}

class FurnitureShop{
        ArrayList<Things> mebel=new ArrayList<>();
        Chair chair=new Chair();
        Table table=new Table();
        void add(){
        int i=0;
        while(i!=10)
        {
            Things random= i%2==0 ? chair : table;
            mebel.add(random);
            i++;
        }
    }
}
class Tester{
    public static void main(String[] args) {
        Person human = new Person();
        FurnitureShop shop= new FurnitureShop();
        shop.add();
        int sc = 0, i;
        while (sc<5) {
            i = (int) (Math.random() * 10);
            human.take(shop.mebel.get(i));
            sc++;
            if (sc == 5) break;
        }
        System.out.println("Мебель в корзинке лежит:");
        while (sc > 0) {
            sc--;
            human.cap.get(sc).Info();
        }
    }
}
