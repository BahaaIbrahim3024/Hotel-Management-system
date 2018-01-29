package hmanage.View;

import hmanage.Controller.DBManager;
import hmanage.Controller.Validation;
import java.util.ArrayList;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;
import hmanage.model.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ibaha
 */
public class StaffTableViwer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        tableView(primaryStage);
    }

    public void tableView(Stage s) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 5, 10, 5));

        Scene scene = new Scene(root);
        TableView tv = new TableView();
        try {
            new DBManager().getAllStaff();
        } catch (SQLException sQLException) {
        }
        manageColumnsToTableView(tv);

        tv.setItems(FXCollections.observableArrayList(HManage.staff));

        HBox hbox = new HBox();
        hbox.setSpacing(5);

        HBox hbox2 = new HBox();
        hbox2.setSpacing(5);

        addTextFieldInputsAndButtons(hbox, hbox2, tv);
        TextField filter = new TextField();
        filter.setPromptText("Filter Table");

        workWithFilterListener(filter, tv);
        root.getChildren().addAll(filter, tv, hbox, hbox2);
        s.setScene(scene);
        s.initStyle(StageStyle.UNDECORATED);
        s.show();
    }

    private void manageColumnsToTableView(TableView tv) {
        TableColumn id = new TableColumn("ID");
        TableColumn username = new TableColumn("User Name");
        TableColumn password = new TableColumn("Password");
        TableColumn fname = new TableColumn("First Name");
        TableColumn lname = new TableColumn("Last Name");
        TableColumn age = new TableColumn("Age");
        TableColumn phone = new TableColumn("Phone");
        TableColumn address = new TableColumn("Address");

        id.setCellValueFactory(new PropertyValueFactory("id"));
        username.setCellValueFactory(new PropertyValueFactory("username"));
        password.setCellValueFactory(new PropertyValueFactory("password"));
        fname.setCellValueFactory(new PropertyValueFactory("fname"));
        lname.setCellValueFactory(new PropertyValueFactory("lname"));
        age.setCellValueFactory(new PropertyValueFactory("age"));
        phone.setCellValueFactory(new PropertyValueFactory("phone"));
        address.setCellValueFactory(new PropertyValueFactory("address"));

        tv.setEditable(true);

        username.setCellFactory(TextFieldTableCell.forTableColumn());
        password.setCellFactory(TextFieldTableCell.forTableColumn());
        fname.setCellFactory(TextFieldTableCell.forTableColumn());
        lname.setCellFactory(TextFieldTableCell.forTableColumn());
        age.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));//since this one is int
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setCellFactory(TextFieldTableCell.forTableColumn());

        username.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                ((Staff) (t.getTableView().getItems().get(t.getTablePosition()
                        .getRow()))).setUsername(t.getNewValue());
                int index = tv.getSelectionModel().getSelectedIndex();
                ObservableList<Staff> uss = tv.getItems();
                Staff s = uss.get(index);
                s.setUsername(t.getNewValue());
                System.out.println(s.toString());
                try {
                    new DBManager().update(s);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffTableViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        password.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                try {
                    ((Staff) (t.getTableView().getItems().get(t.getTablePosition()
                            .getRow()))).setPassword(t.getNewValue());
                    int index = tv.getSelectionModel().getSelectedIndex();
                    ObservableList<Staff> uss = tv.getItems();
                    Staff s = uss.get(index);
                    new DBManager().update(s);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffTableViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        fname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                ((Staff) (t.getTableView().getItems().get(t.getTablePosition()
                        .getRow()))).setFname(t.getNewValue());
                int index = tv.getSelectionModel().getSelectedIndex();
                ObservableList<Staff> uss = tv.getItems();
                Staff s = uss.get(index);
                System.out.println(s.toString());
                try {
                    new DBManager().update(s);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffTableViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        lname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                ((Staff) (t.getTableView().getItems().get(t.getTablePosition()
                        .getRow()))).setLname(t.getNewValue());
                int index = tv.getSelectionModel().getSelectedIndex();
                ObservableList<Staff> uss = tv.getItems();
                Staff s = uss.get(index);
                System.out.println(s.toString());
                try {
                    new DBManager().update(s);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffTableViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        age.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Staff, Integer>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Staff, Integer> t) {
                ((Staff) (t.getTableView().getItems().get(t.getTablePosition()
                        .getRow()))).setAge(t.getNewValue());
                int index = tv.getSelectionModel().getSelectedIndex();
                ObservableList<Staff> uss = tv.getItems();
                Staff s = uss.get(index);
                System.out.println(s.toString());
                try {
                    new DBManager().update(s);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffTableViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        phone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                ((Staff) (t.getTableView().getItems().get(t.getTablePosition()
                        .getRow()))).setPhone(t.getNewValue());
                int index = tv.getSelectionModel().getSelectedIndex();
                ObservableList<Staff> uss = tv.getItems();
                Staff s = uss.get(index);
                System.out.println(s.toString());
                try {
                    new DBManager().update(s);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffTableViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        address.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                ((Staff) (t.getTableView().getItems().get(t.getTablePosition()
                        .getRow()))).setAddress(t.getNewValue());
                int index = tv.getSelectionModel().getSelectedIndex();
                ObservableList<Staff> uss = tv.getItems();
                Staff s = uss.get(index);
                System.out.println(s.toString());
                try {
                    new DBManager().update(s);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffTableViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        tv.getColumns().addAll(id, username, password, fname, lname, age, phone, address);
    }

    private void workWithFilterListener(TextField filter, TableView tv) {
        ObservableList<Staff> ol = FXCollections.observableArrayList(tv.getItems());
        FilteredList<Staff> filterdata = new FilteredList<>(ol, p -> true);
        filter.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            filterdata.setPredicate(new Predicate<Staff>() {
                @Override
                public boolean test(Staff t) {

                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (String.valueOf(t.getId()).toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches id.
                    } else if (t.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches name.
                    } else if (t.getPassword().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches password.
                    } else if (t.getFname().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches name.
                    } else if (t.getLname().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches name.
                    } else if (String.valueOf(t.getAge()).toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches age.
                    } else if (t.getPhone().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches name.
                    } else if (t.getAddress().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches name.
                    }
                    return false;
                }
            ;
        });
        });
                
        SortedList<Staff> sortedlist = new SortedList<>(filterdata);
        sortedlist.comparatorProperty().bind(tv.comparatorProperty());
        tv.setItems(sortedlist);
    }

    private void addTextFieldInputsAndButtons(HBox hbox, HBox hbox2, TableView tv) {
        TextField tfusername = new TextField();
        TextField tfpassword = new TextField();
        TextField tffname = new TextField();
        TextField tflname = new TextField();
        TextField tfage = new TextField();
        TextField tfphone = new TextField();
        TextField tfaddress = new TextField();

        tfusername.setPromptText("User Name");
        tfpassword.setPromptText("Password");
        tffname.setPromptText("First Name");
        tflname.setPromptText("Last Name");
        tfage.setPromptText("Age");
        tfphone.setPromptText("Phone");
        tfaddress.setPromptText("Address");

        /**
         * **************validate TextFields for inputs**********************
         */
        Validation valid = new Validation();
        valid.ValidateName(tffname);
        valid.ValidateName(tflname);
        valid.ValidateName(tfaddress);
        valid.ValidateNumber(tfage);
        valid.ValidatePhone(tfphone);
        /**
         * ****Wrap up the 4 text fields to take full width in HBox**********
         */
        HBox.setHgrow(tfusername, Priority.ALWAYS);
        HBox.setHgrow(tfpassword, Priority.ALWAYS);
        HBox.setHgrow(tffname, Priority.ALWAYS);
        HBox.setHgrow(tflname, Priority.ALWAYS);
        HBox.setHgrow(tfaddress, Priority.ALWAYS);
        HBox.setHgrow(tfage, Priority.ALWAYS);
        HBox.setHgrow(tfphone, Priority.ALWAYS);
        tfusername.setMaxWidth(Double.MAX_VALUE);
        tfpassword.setMaxWidth(Double.MAX_VALUE);
        tffname.setMaxWidth(Double.MAX_VALUE);
        tflname.setMaxWidth(Double.MAX_VALUE);
        tfage.setMaxWidth(Double.MAX_VALUE);
        tfphone.setMaxWidth(Double.MAX_VALUE);
        tfaddress.setMaxWidth(Double.MAX_VALUE);

        hbox.getChildren().addAll(tfusername, tfpassword, tffname, tflname, tfage, tfphone, tfaddress);

        Button insert = new Button("Insert");
        Button delete = new Button("Delete");

        /**
         * ****Wrap up the two buttons to take full width in HBox************
         */
        HBox.setHgrow(insert, Priority.ALWAYS);
        HBox.setHgrow(delete, Priority.ALWAYS);
        insert.setMaxWidth(Double.MAX_VALUE);
        delete.setMaxWidth(Double.MAX_VALUE);

        hbox2.getChildren().addAll(insert, delete);

        insert.setOnAction(e -> {
            String strusername = tfusername.getText();
            String strpass = tfpassword.getText();
            String strfname = tffname.getText();
            String strlnam = tflname.getText();
            int strage = 0;
            try {
                strage = Integer.parseInt(tfage.getText());
            } catch (NumberFormatException numberFormatException) {
            }
            String strphone = tfphone.getText();
            String straddress = tfaddress.getText();
            if (!strusername.equals("") && !strpass.equals("") && !strfname.equals("") && !strlnam.equals("") && !strphone.equals("") && !straddress.equals("") && strage > 0) {
                try {
                    Staff s = new Staff(strusername, strpass, strfname, strlnam, strage, strphone, straddress);
                    new DBManager().insert(s);
                    tfusername.setText("");
                    tfpassword.setText("");
                    tffname.setText("");
                    tflname.setText("");
                    tfage.setText("");
                    tfphone.setText("");
                    tfaddress.setText("");
                    new DBManager().getAllStaff();
                    tv.setItems(FXCollections.observableArrayList(HManage.staff));
                } catch (SQLException ex) {
                    Logger.getLogger(StaffTableViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                new Messanger("Some Inputs are empty!");
            }
        });

        delete.setOnAction(e -> {
            int index = tv.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                Staff s = (Staff) tv.getItems().get(index);
                System.out.println(index+" "+s.toString());
                new DBManager().delete(s.getId());
                tv.setItems(FXCollections.observableArrayList(HManage.staff));
            }
        });

    }

}
