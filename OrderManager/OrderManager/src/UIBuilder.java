import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class UIBuilder {
  protected JPanel orderUI;

  public abstract void addUIControls();
  public abstract void initialize();
  public abstract Order createOrder(int i);
  

  public JPanel getSearchUI() {
    return orderUI;
  }
}

