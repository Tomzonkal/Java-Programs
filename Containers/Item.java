
import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Item implements Comparable<Item>{
    String nazwa;
    ItemCondition stan;
    double masa;
    int ilosc;

    public Item(double x){
        nazwa="BRAK";
        masa=0;
        ilosc=0;
        stan=ItemCondition.NOTEXIST;

    }
    public Item(){
        Scanner scaner=new Scanner(System.in);
       // System.out.println("Podaj Nazwe");
       // nazwa=scaner.nextLine();
        nazwa="Nuty";
       // System.out.println("Podaj Stan: NEW/USED/REFURBISHED");
       // stan=ItemCondition.valueOf(scaner.nextLine());
        stan=ItemCondition.NEW;
      //  System.out.println("Podaj mase");
      //  masa=scaner.nextDouble();
        masa=1;
       // System.out.println("Podaj ilosc");
       // ilosc=scaner.nextInt();
        ilosc=2;

    }

    public Item(Item another) {
        this.nazwa = another.nazwa;
        this.stan = another.stan;
        this.ilosc = another.ilosc;
        this.masa = another.masa;

    }
    public Item(char z){
        Scanner scaner=new Scanner(System.in);
        // System.out.println("Podaj Nazwe");
        // nazwa=scaner.nextLine();
        nazwa="Buty";
        // System.out.println("Podaj Stan: NEW/USED/REFURBISHED");
        // stan=ItemCondition.valueOf(scaner.nextLine());
        stan=ItemCondition.NEW;
        //  System.out.println("Podaj mase");
        //  masa=scaner.nextDouble();
        masa=1;
        // System.out.println("Podaj ilosc");
        // ilosc=scaner.nextInt();
        ilosc=20;

    }

    public  void print(){
        System.out.println("Informacje o towarze:\n NAZWA-"+nazwa+"\nSTAN-"+stan+"\nMASA-"+masa+"\nIlosc"+ilosc);

    }

    public int getIlosc() {
        return ilosc;
    }


    @Override
    public int compareTo(Item item1) {
       return this.nazwa.compareTo(item1.nazwa);

    }



}
