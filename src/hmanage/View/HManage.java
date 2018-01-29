/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmanage.View;

import hmanage.Controller.DBManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import hmanage.model.*;

/**
 *
 * @author ibaha
 */
public class HManage extends Application {

    public static ArrayList<Staff> staff = new ArrayList<>();
    public static ArrayList<Visitor> visitor = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        //Right side
        VBox vb1 = new VBox();
        StackPane sp = new StackPane();
        DropShadow shadow = new DropShadow();
        Lighting l = new Lighting();

        Image logImg1 = new Image("/img/Holo2.png");
        ImageView logVie1 = new ImageView(logImg1);

        Button visBtn = new Button("Visitor");
        visBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            visBtn.setEffect(shadow);
        });
        visBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            visBtn.setEffect(null);
        });
        visBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            visBtn.setEffect(l);
        });
        visBtn.setOnAction((ActionEvent event) -> {
            primaryStage.close();
            VisitorStage v1 = new VisitorStage();
            try {
                v1.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(HManage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        visBtn.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e)
                -> {
            visBtn.setEffect(null);
        });

        Button stafBtn = new Button("Staff");
        stafBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            stafBtn.setEffect(shadow);
        });
        stafBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            stafBtn.setEffect(null);

        });
        stafBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            stafBtn.setEffect(l);
        });
        stafBtn.setOnAction(event -> {
            primaryStage.close();
            StaffStage st = new StaffStage();
            try {
                st.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        stafBtn.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            stafBtn.setEffect(null);
        });

        Button exitBtn = new Button("Exit");
        exitBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            exitBtn.setEffect(shadow);

        });
        exitBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            exitBtn.setEffect(null);
        });
        exitBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            exitBtn.setOnAction(ActionEvent -> Platform.exit());
        });
        exitBtn.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            exitBtn.setEffect(null);
        });

        visBtn.setPrefSize(100.0, 50.0);
        stafBtn.setPrefSize(100.0, 50.0);
        exitBtn.setPrefSize(100.0, 50.0);
        vb1.getChildren().addAll(visBtn, stafBtn, exitBtn);
        vb1.setSpacing(30);
        vb1.setAlignment(Pos.BOTTOM_CENTER);
        vb1.setPadding(new Insets(0, 0, 50, 0));

        sp.getChildren().add(logVie1);
        sp.setMaxSize(500.0, 600.0);
        BorderPane root = new BorderPane();
        //root.setTop(HoLab);
        root.setCenter(sp);
        root.setBottom(vb1);
        Scene scene = new Scene(root, 700, 800);
        scene.getStylesheets().add(HManage.class.getResource("/Styles/loginSt.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        DBManager db1 = new DBManager();
    }

}
