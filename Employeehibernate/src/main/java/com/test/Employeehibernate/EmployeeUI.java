package com.test.Employeehibernate;



import javax.swing.*;
import java.awt.*;
import org.hibernate.SessionFactory;



public class EmployeeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	SessionFactory factory = new org.hibernate.cfg.Configuration()
            .configure("hibernate.cfg.xml").buildSessionFactory();

    public EmployeeUI() {
        
        setTitle("Employee Management System");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10));

        // Buttons
        JButton addBtn = new JButton("Add Employee");
        JButton getBtn = new JButton("Get Employee by ID");
        JButton updateBtn = new JButton("Update Employee");
        JButton deleteBtn = new JButton("Delete Employee");
        JButton exitBtn = new JButton("Exit");

        // Add buttons to frame
        add(addBtn);
        add(getBtn);
        add(updateBtn);
        add(deleteBtn);
        add(exitBtn);

        // Add Employee button action
        addBtn.addActionListener(e -> addEmployeeUI());

        // Get Employee button action
        getBtn.addActionListener(e -> getEmployeeUI());

        // Update Employee button action
        updateBtn.addActionListener(e -> updateEmployeeUI());

        // Delete Employee button action
        deleteBtn.addActionListener(e -> deleteEmployeeUI());

        // Exit
        exitBtn.addActionListener(e -> {
            factory.close();
            System.exit(0);
        });

        setVisible(true);
    }

    // ---------------------- UI Methods ----------------------

    private void addEmployeeUI() {
        JTextField name = new JTextField();
        JTextField email = new JTextField();
        JTextField salary = new JTextField();

        Object[] message = {
                "Name:", name,
                "Email:", email,
                "Salary:", salary
        };

        int option = JOptionPane.showConfirmDialog(null, message, 
                "Add Employee", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            Employee emp = new Employee(name.getText(), email.getText(), Integer.parseInt(salary.getText()));

            var session = factory.openSession();
            var tx = session.beginTransaction();
            session.save(emp);
            tx.commit();
            session.close();

            JOptionPane.showMessageDialog(null, "Employee Added Successfully!");
        }
    }

    private void getEmployeeUI() {
        String id = JOptionPane.showInputDialog("Enter Employee ID:");
        var session = factory.openSession();
        Employee emp = session.get(Employee.class, Integer.parseInt(id));
        session.close();

        if (emp != null)
            JOptionPane.showMessageDialog(null, emp.toString());
        else
            JOptionPane.showMessageDialog(null, "Employee Not Found!");
    }

    private void updateEmployeeUI() {
        String id = JOptionPane.showInputDialog("Enter Employee ID:");
        var session = factory.openSession();
        Employee emp = session.get(Employee.class, Integer.parseInt(id));

        if (emp == null) {
            JOptionPane.showMessageDialog(null, "Employee Not Found!");
            return;
        }

        String[] options = {"Name", "Email", "Salary"};
        String choice = (String) JOptionPane.showInputDialog(null,
                "What do you want to update?",
                "Update Choice",
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        var tx = session.beginTransaction();

        switch (choice) {
            case "Name":
                String newName = JOptionPane.showInputDialog("Enter New Name:");
                emp.setName(newName);
                break;

            case "Email":
                String newEmail = JOptionPane.showInputDialog("Enter New Email:");
                emp.setEmail(newEmail);
                break;

            case "Salary":
                int newSalary = Integer.parseInt(JOptionPane.showInputDialog("Enter New Salary:"));
                emp.setSalary(newSalary);
                break;
        }

        session.update(emp);
        tx.commit();
        session.close();

        JOptionPane.showMessageDialog(null, "Employee Updated Successfully!");
    }

    private void deleteEmployeeUI() {
        String id = JOptionPane.showInputDialog("Enter Employee ID:");
        var session = factory.openSession();
        Employee emp = session.get(Employee.class, Integer.parseInt(id));

        if (emp == null) {
            JOptionPane.showMessageDialog(null, "Employee Not Found!");
            return;
        }

        var tx = session.beginTransaction();
        session.delete(emp);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!");
    }

    // ---------------------- MAIN METHOD ----------------------
    public static void main(String[] args) {
        new EmployeeUI();
    }
}
