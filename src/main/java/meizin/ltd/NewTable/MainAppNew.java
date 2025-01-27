package meizin.ltd.NewTable;

import javax.swing.*;

//import meizin.ltd.ToLearnHibernate.MainApp;
//import meizin.ltd.ToLearnHibernate.Product;
//import meizin.ltd.ToLearnHibernate.ProductService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAppNew {
	
	private final ProductServiceNew productService = new ProductServiceNew();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainAppNew().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Product Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setTitle("meizin\uD83D\uDE38 for my Kirill");
        frame.setLayout(new GridLayout(6, 2));
        
        JLabel lblEmployeeId = new JLabel("Employee ID:");
        JTextField txtEmployeeId = new JTextField();

        JLabel lblProductName = new JLabel("Product Name:");
        JTextField txtProductName = new JTextField();

        JLabel lblQuantityPerUnit = new JLabel("Quantity Per Unit:");
        JTextField txtQuantityPerUnit = new JTextField();

        JLabel lblUnitPrice = new JLabel("Unit Price:");
        JTextField txtUnitPrice = new JTextField();

        JButton btnRead = new JButton("Read");
        JButton btnWrite = new JButton("Write");
        JButton btnExecute = new JButton("Execute");

        frame.add(lblEmployeeId);
        frame.add(txtEmployeeId);
        frame.add(lblProductName);
        frame.add(txtProductName);
        frame.add(lblQuantityPerUnit);
        frame.add(txtQuantityPerUnit);
        frame.add(lblUnitPrice);
        frame.add(txtUnitPrice);
        frame.add(btnRead);
        frame.add(btnWrite);
        frame.add(btnExecute);

        // Состояние выполнения
        final String[] actionState = {""};

        btnRead.addActionListener(e -> {
            actionState[0] = "READ";
            JOptionPane.showMessageDialog(frame, "Enter Employee ID and press Execute to read data.");
        });

        btnWrite.addActionListener(e -> {
            actionState[0] = "WRITE";
            JOptionPane.showMessageDialog(frame, "Enter data and press Execute to write to the database.");
        });

        btnExecute.addActionListener(e -> {
            try {
                if ("READ".equals(actionState[0])) {
                    Short employeeId = Short.parseShort(txtEmployeeId.getText());
                    ProductNew product = productService.getEmployeeById(employeeId);

                    if (product != null) {
                        txtProductName.setText(product.getProductName());
                        txtQuantityPerUnit.setText(product.getQuantityPerUnit());
                        txtUnitPrice.setText(String.valueOf(product.getUnitPrice()));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Employee not found!");
                    }
                } else if ("WRITE".equals(actionState[0])) {
                    ProductNew product = new ProductNew();
                    product.setEmployeeId(Short.parseShort(txtEmployeeId.getText()));
                    product.setProductName(txtProductName.getText());
                    product.setQuantityPerUnit(txtQuantityPerUnit.getText());
                    product.setUnitPrice(Float.parseFloat(txtUnitPrice.getText()));

                    productService.saveOrUpdateProduct(product);
                    JOptionPane.showMessageDialog(frame, "Employee saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "No action selected!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }

}
