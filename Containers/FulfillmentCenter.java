
import javax.lang.model.type.NullType;
import java.util.*;

public class FulfillmentCenter  implements Comparator<Item> {
     String nazwa;
     double max;
    List<Item> lista= new LinkedList<Item>();


     FulfillmentCenter(double x,String nazw){
        max=x;
        nazwa=nazw;
    }
    
       double waga(List<Item> lista) {
        double masa=0;

        for (Item temp:lista) {
            masa+=(temp.masa*temp.ilosc);
        }
        return masa;
    }

    
    
    
    
    public void addProduct(Item item){
         Item temp=new Item(item);
         boolean exist=false;
        if(waga(lista)+(item.masa*item.ilosc)<=max){
            for (Item temp1:lista) {
                if(temp1.compareTo(item)==0){
                    exist=true;
                }
            }
            if(exist==true){
                for (Item temp1:lista) {
                   if(temp1.compareTo(item)==0){
                       temp1.ilosc+=temp.ilosc;
                   }
                }

            }else{
                lista.add(temp);
            }

        }else{
            System.err.println("Przekroczono max mase magazynu");
        }


    }


    public void getProduct(Item item){
        for (Item temp:lista) {
            if(temp.compareTo(item)==0){
                temp.ilosc--;
            }
            if(temp.ilosc==0)
                lista.remove(temp);
        }
    }

    public void removeProduct(Item item){
        Item rem=new Item(0);
         for (Item temp:lista) {
            if(temp.nazwa.equals(item.nazwa)){
                rem=temp;
            }

        }
        lista.remove(rem);


    }
    
    public  Item search(String nazwa) {
        Item item=new Item(0);
        for(Item temp :lista){
            if(nazwa.equals(temp.nazwa)) {
                return temp;
            }
        }
        return item;
    }

    public List<Item> searchPartial(String nazwa){
        List<Item> temp1=new LinkedList<Item>();

        for(Item temp :lista) {
            if(temp.nazwa.contains(nazwa)){
                temp1.add(temp);
            }
        }
        return temp1;
    }

    public int countByConditions(ItemCondition stan){
        int suma=0;
        for(Item temp :lista) {
            if(stan.equals(temp.stan)) {
                suma += temp.ilosc;
            }
        }
        return suma;
    }

    public void summary(){
        for(Item temp :lista){

            System.out.println("Nazwa- "+temp.nazwa);
            System.out.println("Ilosc- "+temp.ilosc);
            System.out.println("Stan- "+temp.stan);
            System.out.println("Masa jednej sztuki- "+temp.masa);
            System.out.println();
        }
    }

    public List<Item> sortByName(){
        List<Item> sorted;
        sorted=lista;
        Collections.sort(sorted);
        return sorted;
    }

    public List<Item>sortByAmount(){
        Collections.sort(lista,this::compare);
        return lista;

    }


    public Item max(){
       return Collections.max(lista);
    }

    @Override
    public int compare(Item o1, Item o2) {
        return-1*(o1.nazwa.compareTo(o2.nazwa));
    }
}
