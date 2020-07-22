
import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

public class OrderManager extends JFrame {

    public static final String newline = "\n";
    public static final String GET_TOTAL = "Get Total";
    public static final String CREATE_ORDER = "Create Order";
    public static final String EDIT_ORDER = "Edit Order";//Se agrega Botón de Edicion

    public static final String EXIT = "Exit";
    public static final String BLANK = "";
    static final String CA_ORDER = "California Order";
    public static final String NON_CA_ORDER = "Non-California Order";

    public static final String OVERSEAS_ORDER = "Overseas Order";
    public static final String COLOMBIAN_ORDER = "Colombian Order";//Se Agregar Colombian Order String

    private JComboBox cmbOrderType;
    private JLabel lblOrderType, lblOrderCriteria;
    private JLabel lblTotal, lblTotalValue;

    private JPanel pOrderCriteria;// Se agrega el Panel Builder

    private OrderVisitor objVisitor;

    public OrderManager() {
        super("Puntual Excercise - Example");

        //Create the visitor instance
        objVisitor = new OrderVisitor();

        pOrderCriteria = new JPanel();

        cmbOrderType = new JComboBox();
        cmbOrderType.addItem(OrderManager.BLANK);
        cmbOrderType.addItem(OrderManager.CA_ORDER);
        cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
        cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
        cmbOrderType.addItem(OrderManager.COLOMBIAN_ORDER);

      
        lblOrderCriteria = new JLabel("Order Criteria:");

        lblOrderType = new JLabel("Order Type:");       
        lblTotal = new JLabel("Result:");
        lblTotalValue
                = new JLabel("Click Create or GetTotal Button");

        //Create the open button
        JButton getTotalButton
                = new JButton(OrderManager.GET_TOTAL);
        JButton createOrderButton
                = new JButton(OrderManager.CREATE_ORDER);
        JButton exitButton = new JButton(OrderManager.EXIT);
        JButton editOrderButton = new JButton(OrderManager.EDIT_ORDER);

        ButtonHandler objButtonHandler = new ButtonHandler(this);

        cmbOrderType.addActionListener(objButtonHandler);

        getTotalButton.addActionListener(objButtonHandler);
        createOrderButton.addActionListener(objButtonHandler);
        editOrderButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(new ButtonHandler());

        //For layout purposes, put the buttons in a separate panel
        //JPanel buttonPanel = new JPanel();
        JPanel panel = new JPanel();
        GridBagLayout gridbag2 = new GridBagLayout();
        panel.setLayout(gridbag2);
        GridBagConstraints gbc2 = new GridBagConstraints();
        panel.add(lblOrderType);
        panel.add(cmbOrderType);
        panel.add(getTotalButton);
        panel.add(createOrderButton);
        panel.add(lblOrderCriteria);
        panel.add(pOrderCriteria);// Se agrega el Panel Builder
        panel.add(lblTotal);
        panel.add(lblTotalValue);
        panel.add(exitButton);
        panel.add(editOrderButton);
        gbc2.anchor = GridBagConstraints.WEST;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gridbag2.setConstraints(lblOrderType, gbc2);
        //gbc2.anchor = GridBagConstraints.WEST;
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gridbag2.setConstraints(cmbOrderType, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gridbag2.setConstraints(lblOrderCriteria, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        gridbag2.setConstraints(pOrderCriteria, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 3;
        gridbag2.setConstraints(lblTotal, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 6;
        gridbag2.setConstraints(lblTotalValue, gbc2);
        gbc2.anchor = GridBagConstraints.EAST;
        gbc2.gridx = 0;
        gbc2.gridy = 6;
        gridbag2.setConstraints(createOrderButton, gbc2);
        gbc2.gridx = 1;
        gbc2.gridy = 3;
        gridbag2.setConstraints(editOrderButton, gbc2);
        gbc2.gridx = 2;
        gbc2.gridy = 3;
        gridbag2.setConstraints(getTotalButton, gbc2);
        gbc2.gridx = 3;
        gbc2.gridy = 3;
        gridbag2.setConstraints(exitButton, gbc2);

        //****************************************************
        /*GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(lblOrderType);
        buttonPanel.add(cmbOrderType);
        buttonPanel.add(lblOrderAmount);
        buttonPanel.add(txtOrderAmount);
        buttonPanel.add(lblAdditionalTax);
        buttonPanel.add(txtAdditionalTax);
        buttonPanel.add(lblAdditionalSH);
        buttonPanel.add(txtAdditionalSH);
        buttonPanel.add(lblFourPerThousand);
        buttonPanel.add(txtFourPerThousand);
        buttonPanel.add(lblTotal);
        buttonPanel.add(lblTotalValue);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderType, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(cmbOrderType, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblOrderAmount, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtOrderAmount, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblAdditionalTax, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gridbag.setConstraints(txtAdditionalTax, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblAdditionalSH, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gridbag.setConstraints(txtAdditionalSH, gbc);

        //Se organiza la disposición en el Grid
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(lblFourPerThousand, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gridbag.setConstraints(txtFourPerThousand, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gridbag.setConstraints(lblTotal, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gridbag.setConstraints(lblTotalValue, gbc);

        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;*/
        //****************************************************
        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();

        //contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            SwingUtilities.updateComponentTreeUI(
                    OrderManager.this);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new OrderManager();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        //frame.pack();
        frame.setSize(700, 400);
        frame.setLocation(5, 20);
        frame.setVisible(true);
    }

    public void setTotalValue(String msg) {
        lblTotalValue.setText(msg);
    }
    
    public void setTotal(String msg) {
        lblTotal.setText(msg);
    }

    public OrderVisitor getOrderVisitor() {
        return objVisitor;
    }

    public String getOrderType() {
        return (String) cmbOrderType.getSelectedItem();
    }

    //Metodos Builder
    public JComboBox getSearchTypeCtrl() {
        return cmbOrderType;
    }

    public void displayNewUI(JPanel panel) {
        pOrderCriteria.removeAll();
        pOrderCriteria.add(panel);
        pOrderCriteria.validate();
        validate();
    }

} // End of class OrderManager

class ButtonHandler implements ActionListener {

    OrderManager objOrderManager;
    UIBuilder builder;
    OrderVisitor objVisitorManager;
    AllOrders orderObjList;
    boolean vacio=true;
    int id;

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(OrderManager.EXIT)) {
            System.exit(1);
        }
        if (e.getSource() == objOrderManager.getSearchTypeCtrl()) {
            String selection = objOrderManager.getOrderType();
            if (selection.equals("") == false) {
                if(vacio){
                    objOrderManager.getSearchTypeCtrl().removeItemAt(0);
                    vacio=false;
                }
                BuilderFactory factory = new BuilderFactory();
                //create an appropriate builder instance
                builder = factory.getUIBuilder(selection);
                //configure the director with the builder
                UIDirector director = new UIDirector(builder);
                //director invokes different builder
                // methods
                director.build();
                //get the final build object
                JPanel UIObj = builder.getSearchUI();
                objOrderManager.displayNewUI(UIObj);
            }
        }
        if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {

             Order order = builder.createOrder(id);
            OrderVisitor visitor
                    = objOrderManager.getOrderVisitor();
            order.accept(visitor);
            orderObjList.addOrder(order.getId(), order);
            id++;
            System.out.println(order.getOrderTotal()+" "+order.getId());
            System.out.println(order.getOrderAmount() + "  " + order.getTaxAmount());
            String msj = "Total amount = "+order.getOrderTotal();
            objOrderManager.setTotal(msj);
            
        	
        	JFrame listFrame = ListFrame.getListFrame(orderObjList);
        	((ListFrame) listFrame).updateList();
        	listFrame.setSize(200, 300);
        	listFrame.setLocation(750, 20);
        	listFrame.setVisible(true);

        }

        if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
            
            int total = 0;
            for(int i = 0;i<orderObjList.getSize();i++){
                System.out.println(orderObjList.getOrder(i+1).getOrderTotal());
                total += orderObjList.getOrder(i+1).getOrderTotal();
            }
            System.out.println(total);
            String msj = "Total Cost = "+total;
            objOrderManager.setTotalValue(msj);
            //Get the Visitor
//            OrderVisitor visitor
//                    = objOrderManager.getOrderVisitor();
//            totalResult = new Double(
//                    visitor.getOrderTotal()).toString();
//            totalResult = " Orders Total = " + totalResult;
//            objOrderManager.setTotalValue(totalResult);
        }
        if(e.getActionCommand().equals(OrderManager.EDIT_ORDER)){   

        	
            int i = Integer.parseInt(JOptionPane.showInputDialog(null,"Write the order ID to modify"));
            System.out.println(orderObjList.getOrder(i).getOrderAmount()+" "+orderObjList.getOrder(i).getTaxAmount());
            double d1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Write the new order amount"));
            String s = (JOptionPane.showInputDialog(null,"Write the new order tax (0 for NonCaliforniaOrder)"));
            
            if(s.equals("")) {
            	s = "0";
            }
            
            double d2 = Double.parseDouble(s);
            orderObjList.getOrder(i).setOrderAmount(d1);
            orderObjList.getOrder(i).setTaxAmount(d2);
            System.out.println(orderObjList.getOrder(i).getOrderAmount()+" "+orderObjList.getOrder(i).getTaxAmount());
            System.out.println(orderObjList.getOrder(i).getOrderTotal());
            OrderVisitor visitor = objOrderManager.getOrderVisitor();
            orderObjList.getOrder(i).accept(visitor);
            System.out.println(orderObjList.getOrder(i).getOrderTotal());
        }
    }

    public ButtonHandler() {
    }

    public ButtonHandler(OrderManager inObjOrderManager) {
        objOrderManager = inObjOrderManager;
        orderObjList = new AllOrders();
        id=1;
    }

} // End of class ButtonHandler

class BuilderFactory {

    public UIBuilder getUIBuilder(String str) {
        UIBuilder builder = null;
        if (str.equals(OrderManager.CA_ORDER)) {
            builder = new CaOrderBuilder();
        } else if (str.equals(OrderManager.NON_CA_ORDER)) {
            builder = new NonCaOrderBuilder();
        } else if (str.equals(OrderManager.OVERSEAS_ORDER)) {
            builder = new OverseasOrderBuilder();
        } else if (str.equals(OrderManager.COLOMBIAN_ORDER)) {
            builder = new ColombianOrderBuilder();
        }
        return builder;
    }
}
//End the BuilderFactory class
