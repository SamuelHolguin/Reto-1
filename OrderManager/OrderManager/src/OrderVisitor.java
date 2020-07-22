
import java.util.*;

class OrderVisitor implements VisitorInterface {

    //private AllOrders orderObjList;
    //private Order objOrder;
    //private double orderTotal;
    //private double ordersTotal;

    public OrderVisitor() {
        //orderObjList = AllOrders.getAllOrders();
    }

    public void visit(NonCaliforniaOrder inp_order) {
        double total = inp_order.getOrderAmount();
        inp_order.setOrderTotal(total);
        //orderObjList.addOrder(inp_order.getId(),inp_order);
    }

    public void visit(CaliforniaOrder inp_order) {
        double total = inp_order.getOrderAmount() + inp_order.getTaxAmount();
        inp_order.setOrderTotal(total);
        //orderObjList.addOrder(inp_order.getId(),inp_order);
    }

    public void visit(OverseasOrder inp_order) {
        double total = inp_order.getOrderAmount() + inp_order.getTaxAmount();
        inp_order.setOrderTotal(total);
        //orderObjList.addOrder(inp_order.getId(),inp_order);
    }

    public void visit(ColombianOrder inp_order) {
        double total = inp_order.getOrderAmount() + inp_order.getTaxAmount();
        inp_order.setOrderTotal(total);
        //orderObjList.addOrder(inp_order.getId(),inp_order);
    }

//    public double getOrderTotal() {
//        //Recorrer todo la coleccion obtener el valor de OrderTotal y sumarlos guardandolos en 
//        //OrdersTotal
//        for (int i = 0; i <= orderObjList.size(); i++) {
//            objOrder = (Order)orderObjList.get(i);
//            ordersTotal = ordersTotal+ objOrder.getOrderTotal() ;
//
//        }
//        return ordersTotal;
//    }

}
