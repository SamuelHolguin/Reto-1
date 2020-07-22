import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;

public class ListFrame extends JFrame{
	
	private static ListFrame vl;
	private JPanel pListOrders;
	private JLabel lblLists;
	private AllOrders tLists;
	private String Msj;
	
	private ListFrame(AllOrders ao) {
		
		tLists = ao;
		lblLists = new JLabel();
		pListOrders = new JPanel();
		pListOrders.add(lblLists);
		
	    Container contentPane = getContentPane();
	    contentPane.add(pListOrders, BorderLayout.CENTER);
		
		/*Msj = "<html> ID Orden Impuesto" + "<p>";
		
		for (int i=1;i<=TListas.getSize();i++) {
			Msj+=  TListas.getOrder(i).getId() + "  "
		           + TListas.getOrder(i).getOrderAmount() + " " 
				   + TListas.getOrder(i).getTaxAmount() 
				   + "<p>";
			
		}
		Msj+= "</html>";
		lblListas.setText(Msj);*/
	}	

	public void updateList() {
		
		Msj = "<html> ID &nbsp;&nbsp;&nbsp;&nbsp; Order &nbsp;&nbsp;&nbsp;&nbsp; Tax" + "<p>";	
		
		for (int i=1;i<=tLists.getSize();i++) {
			Msj+=  tLists.getOrder(i).getId() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
		           + tLists.getOrder(i).getOrderAmount() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
				   + tLists.getOrder(i).getTaxAmount() 
				   + "<p>";
		}
		Msj+= "</html>";
		lblLists.setText(Msj);
	}
	
	public static ListFrame getListFrame(AllOrders ao) {
		if(vl == null) {
			vl = new ListFrame(ao);
		}
		return vl;
	}
}
