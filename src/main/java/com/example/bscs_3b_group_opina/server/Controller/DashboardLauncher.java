package com.example.bscs_3b_group_opina.server.Controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bscs_3b_group_opina.server.Views.AdminDashboard;

import javax.swing.SwingUtilities;

@Component
public class DashboardLauncher implements CommandLineRunner {
    private final AdminDashboard adminDashboard;

    public DashboardLauncher(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
    }

    @Override
    public void run(String... args) {
        SwingUtilities.invokeLater(() -> adminDashboard.setVisible(true));
    }
}