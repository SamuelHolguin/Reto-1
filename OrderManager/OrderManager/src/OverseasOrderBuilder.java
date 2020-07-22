
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;
import java.util.*;

class OverseasOrderBuilder extends UIBuilder {

    private JTextField txtOrderAmount = new JTextField(10);
    private JTextField txtAdditionalSH = new JTextField(10);

    ;

    @Override
    public void addUIControls() {
        orderUI = new JPanel();
        JLabel lblOrderAmount = new JLabel("Order Amount:");
        JLabel lblAdditionalSH = new JLabel("Additional S & H(Overseas Orders Only):");;

        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        orderUI.add(lblOrderAmount);
        orderUI.add(txtOrderAmount);
        orderUI.add(lblAdditionalSH);
        orderUI.add(txtAdditionalSH);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmount, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblAdditionalSH, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtAdditionalSH, gbc);

    }

    @Override
    public void initialize() {

    }
    
    @Override
    public Order createOrder(int i){
        return new OverseasOrder(Double.parseDouble(txtOrderAmount.getText()),Double.parseDouble(txtAdditionalSH.getText()),i);
    }

}
