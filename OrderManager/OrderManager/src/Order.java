public interface Order {
  public void accept(OrderVisitor v);
  public double getOrderAmount();
  public double getTaxAmount();
  public void setOrderAmount(double oAmount);
  public void setTaxAmount(double tAmount);
  public double getOrderTotal();
  public int getId();
}
