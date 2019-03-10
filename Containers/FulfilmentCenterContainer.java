import java.util.*;

public class FulfilmentCenterContainer {
    Map<String, FulfillmentCenter> mapa=new HashMap<String, FulfillmentCenter>();

    public void addCenter(String nazwa,double pojemnosc){
        mapa.put(nazwa, new FulfillmentCenter(pojemnosc,nazwa));
    }

    public void removeCenter(String nazwa){
        mapa.remove(nazwa);
    }

    public List<String> findEmpty(){
        Set<Map.Entry<String,FulfillmentCenter>>entrySet=mapa.entrySet();
        List<String> lista= new LinkedList<String>();
        for(Map.Entry<String,FulfillmentCenter> entry:entrySet){
            if(entry.getValue().lista.isEmpty()){
                lista.add(entry.getKey());
            }
        }
        return lista;
    }

    public void summary(){
        Set<Map.Entry<String,FulfillmentCenter>>entrySet=mapa.entrySet();
        for(Map.Entry<String,FulfillmentCenter> entry:entrySet){
            System.out.println("Magazyn-"+entry.getKey());
            System.out.println("Zaladowany w "+(100*(entry.getValue().waga(entry.getValue().lista)/
                    entry.getValue().max))+"%");
            }
    }

}


