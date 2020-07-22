
import java.util.*;

/**
 *
 * @author Samuel Holguin y Kevin Rocha
 */
public class AllOrders {
    //private static AllOrders AO;
    private HashMap<Integer, Order> orderObjList;
    private Order order;
    //private int i = 0;
    //private Enumeration e;
    
    public AllOrders(){
        orderObjList = new HashMap<>();
        //e = (Enumeration)orderObjList.values();    
    }
    
//    public static AllOrders getAllOrders(){
//        if(AO==null){
//            AO = new AllOrders();
//        }
//        return AO;
//    }
    
    public void addOrder(int i, Order order){
        orderObjList.put(i, order);
    }
    
    public Order getOrder(int i){
        return orderObjList.get(i);
    }
    
    public int getSize(){
        return orderObjList.size();
    }
    
//    public boolean hasNext(){
//        if(orderObjList.size()!=i){
//            i++;
//            return true;
//        }
//        return false;
//    }
//    
//    public Order next(){
//        if (order == null) {
//          throw new NoSuchElementException();
//        } else {
//          return order;
//        }
//    }
}
