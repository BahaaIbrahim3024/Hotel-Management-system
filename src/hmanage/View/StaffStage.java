/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmanage.View;

import hmanage.Controller.DBManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static hmanage.View.HManage.staff;

/**
 *
 * @author ibaha
 */
public class StaffStage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        staff(primaryStage);
    }

    public void staff(Stage stage) {
        GridPane p = new GridPane();
        p.setAlignment(Pos.CENTER);
        p.setVgap(20);
        p.setHgap(20);
        p.setPadding(new Insets(0, 0, 30, 0));

        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        Label username = new Label();
        username.setText("User Name");
        TextField usertxt = new TextField();
        usertxt.setPromptText("Enter User Name");

        Label pass = new Label();
        pass.setText("Password");
        PasswordField passtxt = new PasswordField();
        passtxt.setPromptText("Password");

        HBox hb1 = new HBox();
        BorderPane stackPane = new BorderPane();

        Button canBtn = new Button();
        canBtn.setText("Cancel");
        canBtn.setMaxSize(250, 300);
        Button loginBtn = new Button();
        loginBtn.setText("Login");
        loginBtn.setMaxSize(250, 300);

        p.add(username, 0, 1);
        p.add(usertxt, 2, 1);
        p.add(pass, 0, 2);
        p.add(passtxt, 2, 2);
        p.add(canBtn, 0, 3);
        p.add(loginBtn, 2, 3);
        Scene scene = new Scene(p, 400, 500);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        DropShadow shadow = new DropShadow();
        Lighting l = new Lighting();

        // Cancel Button
        canBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            canBtn.setEffect(shadow);
        });
        canBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            canBtn.setEffect(null);
        });
        canBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            canBtn.setEffect(l);

        });
        canBtn.setOnAction(event -> {
            stage.close();
        });

        canBtn.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            canBtn.setEffect(null);
        });

        //Login Button
        loginBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            loginBtn.setEffect(shadow);
        });
        loginBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            loginBtn.setEffect(null);
        });
        loginBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            loginBtn.setEffect(l);

        });

        loginBtn.setOnAction(event -> {
            try {
                DBManager db1 = new DBManager();
                db1.getAllStaff();
                String n = usertxt.getText();
                String pasV = passtxt.getText();
                for (int i = 0; i < staff.size(); i++) {
                    if (n.equals(staff.get(i).getUsername()) && pasV.equals(staff.get(i).getPassword())) {
                        System.out.println("User IS exsist");
                        stage.close();
                        StaffTableViwer stv = new StaffTableViwer();
                        try {
                            stv.start(new Stage());
                        } catch (Exception ex) {
                            Logger.getLogger(StaffStage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(StaffStage.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        loginBtn.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            loginBtn.setEffect(null);
        });

    }

}
