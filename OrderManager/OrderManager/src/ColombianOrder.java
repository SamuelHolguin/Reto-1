
public class ColombianOrder implements Order {

    private double orderAmount;
    private double fourPerThousand;
    private double orderTotal;
    private int id;

    public ColombianOrder() {
    }

    public ColombianOrder(double inp_orderAmount,
            double inp_fourPerThousand, int inp_id) {
        orderAmount = inp_orderAmount;
        fourPerThousand = inp_fourPerThousand;
        id = inp_id;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getTaxAmount() {
        return fourPerThousand;
    }
    
    public void setOrderAmount(double oAmount){
        this.orderAmount=oAmount;
    }
    public void setTaxAmount(double tAmount){
        this.fourPerThousand=tAmount;
    }

    public int getId() {
        return id;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void accept(OrderVisitor v) {
        v.visit(this);
    }

}
