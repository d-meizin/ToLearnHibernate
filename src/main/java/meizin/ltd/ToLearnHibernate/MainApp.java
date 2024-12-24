package meizin.ltd.ToLearnHibernate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {

    private final ProductService productService = new ProductService();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Product Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        JLabel lblProductId = new JLabel("Product ID:");
        JTextField txtProductId = new JTextField();

        JLabel lblProductName = new JLabel("Product Name:");
        JTextField txtProductName = new JTextField();

        JLabel lblQuantityPerUnit = new JLabel("Quantity Per Unit:");
        JTextField txtQuantityPerUnit = new JTextField();

        JLabel lblUnitPrice = new JLabel("Unit Price:");
        JTextField txtUnitPrice = new JTextField();

        JButton btnRead = new JButton("Read");
        JButton btnWrite = new JButton("Write");
        JButton btnExecute = new JButton("Execute");

        frame.add(lblProductId);
        frame.add(txtProductId);
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
            JOptionPane.showMessageDialog(frame, "Enter Product ID and press Execute to read data.");
        });

        btnWrite.addActionListener(e -> {
            actionState[0] = "WRITE";
            JOptionPane.showMessageDialog(frame, "Enter data and press Execute to write to the database.");
        });

        btnExecute.addActionListener(e -> {
            try {
                if ("READ".equals(actionState[0])) {
                    Short productId = Short.parseShort(txtProductId.getText());
                    Product product = productService.getProductById(productId);

                    if (product != null) {
                        txtProductName.setText(product.getProductName());
                        txtQuantityPerUnit.setText(product.getQuantityPerUnit());
                        txtUnitPrice.setText(String.valueOf(product.getUnitPrice()));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Product not found!");
                    }
                } else if ("WRITE".equals(actionState[0])) {
                    Product product = new Product();
                    product.setProductId(Short.parseShort(txtProductId.getText()));
                    product.setProductName(txtProductName.getText());
                    product.setQuantityPerUnit(txtQuantityPerUnit.getText());
                    product.setUnitPrice(Float.parseFloat(txtUnitPrice.getText()));

                    productService.saveOrUpdateProduct(product);
                    JOptionPane.showMessageDialog(frame, "Product saved successfully!");
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
