package com.example.bscs_3b_group_opina.server.Views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdminDashboard extends Application {

    private TableView<Candidate> table;
    private ObservableList<Candidate> candidates;

    public static void main(String[] args) {
        launch(args); // Entry point for JavaFX
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Admin Dashboard");

        candidates = FXCollections.observableArrayList();

        table = new TableView<>();
        TableColumn<Candidate, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Candidate, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Candidate, String> partyCol = new TableColumn<>("Party");
        partyCol.setCellValueFactory(new PropertyValueFactory<>("party"));

        table.getColumns().addAll(idCol, nameCol, partyCol);
        table.setItems(candidates);

        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> addCandidate());

        Button editBtn = new Button("Edit");
        editBtn.setOnAction(e -> editCandidate());

        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> deleteCandidate());

        HBox buttonBox = new HBox(10, addBtn, editBtn, deleteBtn);
        VBox layout = new VBox(10, table, buttonBox);
        layout.setPadding(new javafx.geometry.Insets(10));

        primaryStage.setScene(new Scene(layout, 600, 400));
        primaryStage.show();
    }

    private void addCandidate() {
        TextInputDialog idDialog = new TextInputDialog();
        idDialog.setHeaderText("Enter ID:");
        String id = idDialog.showAndWait().orElse(null);

        TextInputDialog nameDialog = new TextInputDialog();
        nameDialog.setHeaderText("Enter Name:");
        String name = nameDialog.showAndWait().orElse(null);

        TextInputDialog partyDialog = new TextInputDialog();
        partyDialog.setHeaderText("Enter Party:");
        String party = partyDialog.showAndWait().orElse(null);

        if (id != null && name != null && party != null) {
            candidates.add(new Candidate(id, name, party));
        }
    }

    private void editCandidate() {
        Candidate selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            TextInputDialog idDialog = new TextInputDialog(selected.getId());
            idDialog.setHeaderText("Edit ID:");
            selected.setId(idDialog.showAndWait().orElse(selected.getId()));

            TextInputDialog nameDialog = new TextInputDialog(selected.getName());
            nameDialog.setHeaderText("Edit Name:");
            selected.setName(nameDialog.showAndWait().orElse(selected.getName()));

            TextInputDialog partyDialog = new TextInputDialog(selected.getParty());
            partyDialog.setHeaderText("Edit Party:");
            selected.setParty(partyDialog.showAndWait().orElse(selected.getParty()));

            table.refresh();
        } else {
            showAlert("Please select a candidate to edit.");
        }
    }

    private void deleteCandidate() {
        Candidate selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            candidates.remove(selected);
        } else {
            showAlert("Please select a candidate to delete.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static class Candidate {
        private String id, name, party;

        public Candidate(String id, String name, String party) {
            this.id = id;
            this.name = name;
            this.party = party;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParty() {
            return party;
        }

        public void setParty(String party) {
            this.party = party;
        }
    }

    public Object setVisible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }
}