import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args){
    Item item1 = new Item();
    Item item2 = new Item('z');
    item1.print();

    FulfilmentCenterContainer spis = new FulfilmentCenterContainer();
    spis.addCenter("Kolorado",100);
    spis.addCenter("Singapur",100);
    spis.addCenter("Pekin",100);


    spis.mapa.get("Kolorado").addProduct(item1);
    spis.mapa.get("Kolorado").addProduct(item1);
    spis.mapa.get("Kolorado").addProduct(item2);
    spis.mapa.get("Singapur").addProduct(item2);


    spis.mapa.get("Kolorado").removeProduct(item1);
    spis.mapa.get("Kolorado").addProduct(item1);
    spis.mapa.get("Kolorado").getProduct(item1);

    System.out.println("podsumowanie magazynu:");
    spis.mapa.get("Kolorado").summary();

    System.out.println("Wyszukiwanie:");
    spis.mapa.get("Kolorado").search("Buty").print();

    System.out.println("Wyszukiwanie po stanie:");
    System.out.println(spis.mapa.get("Kolorado").countByConditions(ItemCondition.NEW));

    System.out.println("Wyszukiwanie po czesci nazwy:");
    for(Item temp : spis.mapa.get("Kolorado").searchPartial("u")) {
        System.out.println(temp.nazwa);
    }






    System.out.println("Sortowanie po nazwie");
    for(Item temp :  spis.mapa.get("Kolorado").sortByName()) {
        System.out.println(temp.nazwa);
    }

    System.out.println("Sortowanie po ilosci:");
    for(Item temp :   spis.mapa.get("Kolorado").sortByAmount()) {
        System.out.println(temp.nazwa);
    }

    System.out.println("Max produkt:");
    spis.mapa.get("Kolorado").max().print();

    System.out.println("Szukanie pustych:");
    for(String temp :   spis.findEmpty()) {
        System.out.println(temp);
    }

    System.out.println("podsumowanie magazynów:");
    spis.summary();


    spis.removeCenter("Pekin");






    }


}
