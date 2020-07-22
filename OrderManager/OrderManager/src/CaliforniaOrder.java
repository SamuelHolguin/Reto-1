
public class CaliforniaOrder implements Order {

    private double orderAmount;
    private double additionalTax;
    private double orderTotal;
    private int id;
    

    public CaliforniaOrder() {
    }

    public CaliforniaOrder(double inp_orderAmount,
            double inp_additionalTax, int inp_id) {
        orderAmount = inp_orderAmount;
        additionalTax = inp_additionalTax;
        id = inp_id;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getTaxAmount() {
        return additionalTax;
    }
    
    public void setOrderAmount(double oAmount){
        this.orderAmount=oAmount;
    }
    public void setTaxAmount(double tAmount){
        this.additionalTax=tAmount;
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
