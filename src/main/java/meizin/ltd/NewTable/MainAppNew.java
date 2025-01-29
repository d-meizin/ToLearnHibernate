package meizin.ltd.NewTable;

import javax.swing.*;
import java.sql.Date;

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

        JLabel lblLastName = new JLabel("Last Name:");
        JTextField txtLastName = new JTextField();

        JLabel lblFirstName = new JLabel("First Name:");
        JTextField txtFirstName = new JTextField();

        JLabel lblTitle = new JLabel("Title:");
        JTextField txtTitle = new JTextField();
        
        JLabel lblBirthDate = new JLabel("Birth Date:");
        JTextField txtBirthDate = new JTextField();

        JButton btnRead = new JButton("Read");
        JButton btnWrite = new JButton("Write");
        JButton btnExecute = new JButton("Execute");

        frame.add(lblEmployeeId);
        frame.add(txtEmployeeId);
        frame.add(lblLastName);
        frame.add(txtLastName);
        frame.add(lblFirstName);
        frame.add(txtFirstName);
        frame.add(lblTitle);
        frame.add(txtTitle);
        frame.add(lblBirthDate);
        frame.add(txtBirthDate);
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
                        txtLastName.setText(product.getLastName());
                        txtFirstName.setText(product.getFirstName());
                        //txtUnitPrice.setText(String.valueOf(product.getUnitPrice()));
                        txtTitle.setText(product.getTitle());
                        txtBirthDate.setText(String.valueOf(product.getBirthDate()));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Employee not found!");
                    }
                } else if ("WRITE".equals(actionState[0])) {
                    ProductNew product = new ProductNew();
                    product.setEmployeeId(Short.parseShort(txtEmployeeId.getText()));
                    product.setLastName(txtLastName.getText());
                    product.setFirstName(txtFirstName.getText());
                    //product.setUnitPrice(Float.parseFloat(txtUnitPrice.getText()));
                    product.setTitle(txtTitle.getText());
                    product.setBirthDate(Date.parseDate(txtBirthDate.getText()));
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
