package com.example.bscs_3b_group_opina.server.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import org.springframework.stereotype.Component;

@Component // Register as a Spring Bean
public class AdminDashboard extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel(new Object[] { "ID", "Name", "Party" }, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");

        addBtn.addActionListener(e -> addCandidate());
        editBtn.addActionListener(e -> editCandidate());
        deleteBtn.addActionListener(e -> deleteCandidate());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addCandidate() {
        String id = JOptionPane.showInputDialog(this, "Enter ID:");
        String name = JOptionPane.showInputDialog(this, "Enter Name:");
        String party = JOptionPane.showInputDialog(this, "Enter Party:");
        if (id != null && name != null && party != null) {
            model.addRow(new Object[] { id, name, party });
        }
    }

    private void editCandidate() {
        int row = table.getSelectedRow();
        if (row != -1) {
            String id = JOptionPane.showInputDialog(this, "Edit ID:", model.getValueAt(row, 0));
            String name = JOptionPane.showInputDialog(this, "Edit Name:", model.getValueAt(row, 1));
            String party = JOptionPane.showInputDialog(this, "Edit Party:", model.getValueAt(row, 2));
            if (id != null && name != null && party != null) {
                model.setValueAt(id, row, 0);
                model.setValueAt(name, row, 1);
                model.setValueAt(party, row, 2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a candidate to edit.");
        }
    }

    private void deleteCandidate() {
        int row = table.getSelectedRow();
        if (row != -1) {
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a candidate to delete.");
        }
    }
}