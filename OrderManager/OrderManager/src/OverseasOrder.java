
public class OverseasOrder implements Order {

    private double orderAmount;
    private double additionalSH;
    private double orderTotal;
    private int id;

    public OverseasOrder() {
    }

    public OverseasOrder(double inp_orderAmount,
            double inp_additionalSH, int inp_id) {
        orderAmount = inp_orderAmount;
        additionalSH = inp_additionalSH;
        id = inp_id;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getTaxAmount() {
        return additionalSH;
    }

    public int getId() {
        return id;
    }
    public double getOrderTotal(){
        return orderTotal;
    }
    
    public void setOrderAmount(double oAmount){
        this.orderAmount=oAmount;
    }
    public void setTaxAmount(double tAmount){
        this.additionalSH=tAmount;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void accept(OrderVisitor v) {
        v.visit(this);
    }
}
