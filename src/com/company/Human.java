package com.company;

public class Human {
  Human(){
      Head myhead=new Head();
      myhead.getEyes();
      myhead.getNose();
      Arm myarm=new Arm();
      myarm.Things();
      Skin myskin=new Skin();
      myskin.Color();
  }

}

class Head{
    void getEyes(){
        System.out.println("У человека синие глаза");
    }
    void getNose(){
        System.out.println("Всего один нос");
    }
}
class Arm{
    void Things(){
        System.out.println("В руках у человека факел и груша");
    }
}
class Skin{
    void Color(){
        System.out.println("У человека кожа бледного цвета");
    }
}
class go{
    public static void main(String[] args) {
        Human Noy=new Human();
    }
}