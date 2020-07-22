
public class NonCaliforniaOrder implements Order {

    private double orderAmount;
    private double orderTotal;

    private int id;

    public NonCaliforniaOrder() {
    }

    public NonCaliforniaOrder(double inp_orderAmount, int inp_id) {
        orderAmount = inp_orderAmount;
        id = inp_id;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
    
    public double getTaxAmount() {
        return 0;
    }
    
    public void setOrderAmount(double oAmount){
        this.orderAmount=oAmount;
    }
    public void setTaxAmount(double tAmount){
        
    }

    public int getId() {
        return id;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void accept(OrderVisitor v) {
        v.visit(this);
    }

}
