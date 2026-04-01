/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_que2;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class AddressBookGUI extends JFrame {

    ArrayList<Address> addressList = new ArrayList<>();

    JTextField txtName, txtHomeAddr, txtHomePhone,
            txtBizAddr, txtBizPhone, txtFax, txtMobile, txtPager;

    JTextArea output;

    public AddressBookGUI() {

        setTitle("Address Book");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(8, 2));

        txtName = new JTextField();
        txtHomeAddr = new JTextField();
        txtHomePhone = new JTextField();
        txtBizAddr = new JTextField();
        txtBizPhone = new JTextField();
        txtFax = new JTextField();
        txtMobile = new JTextField();
        txtPager = new JTextField();

        form.add(new JLabel("Name")); form.add(txtName);
        form.add(new JLabel("Home Address")); form.add(txtHomeAddr);
        form.add(new JLabel("Home Phone")); form.add(txtHomePhone);
        form.add(new JLabel("Business Address")); form.add(txtBizAddr);
        form.add(new JLabel("Business Phone")); form.add(txtBizPhone);
        form.add(new JLabel("Fax")); form.add(txtFax);
        form.add(new JLabel("Mobile")); form.add(txtMobile);
        form.add(new JLabel("Pager")); form.add(txtPager);

        add(form, BorderLayout.NORTH);

        JPanel buttons = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnFind = new JButton("Find");
        JButton btnDelete = new JButton("Delete");

        buttons.add(btnAdd);
        buttons.add(btnFind);
        buttons.add(btnDelete);

        add(buttons, BorderLayout.CENTER);

        output = new JTextArea();
        add(new JScrollPane(output), BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> {
            Address a = new Address(
                    txtName.getText(),
                    txtHomeAddr.getText(),
                    txtHomePhone.getText(),
                    txtBizAddr.getText(),
                    txtBizPhone.getText(),
                    txtFax.getText(),
                    txtMobile.getText(),
                    txtPager.getText()
            );
            addressList.add(a);
            output.setText("Record Added Successfully");
        });

        btnFind.addActionListener(e -> {
            String name = txtName.getText();
            for (Address a : addressList) {
                if (a.getName().equalsIgnoreCase(name)) {
                    output.setText(
                            "Name: " + a.getName() +
                            "\nHome Address: " + a.getHomeAddress() +
                            "\nMobile: " + a.getMobile()
                    );
                    return;
                }
            }
            output.setText("Record Not Found");
        });

        btnDelete.addActionListener(e -> {
            String name = txtName.getText();
            addressList.removeIf(a -> a.getName().equalsIgnoreCase(name));
            output.setText("Record Deleted");
        });
    }

    public static void main(String[] args) {
        new AddressBookGUI().setVisible(true);
    }
}
