/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmanage.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ibaha
 */
public class VisitorStage extends Application{

     @Override
    public void start(Stage primaryStage) throws Exception {
        visitor(primaryStage);
    }

    public void visitor(Stage stage )
    {BorderPane borderPane=new BorderPane();
        Client(stage);
    }
    public void Client(Stage s)
   {
       HBox hb1=new HBox();
       hb1.setAlignment(Pos.CENTER);
       hb1.setSpacing(20);
       
       HBox hb2=new HBox();
       hb2.setAlignment(Pos.CENTER);
       hb2.setSpacing(20);
       
       HBox hb3=new HBox();
       hb3.setAlignment(Pos.CENTER);
       hb3.setSpacing(20);
       
       HBox hb4=new HBox();
       hb4.setAlignment(Pos.CENTER);
       hb4.setSpacing(20);
              
       HBox hb5=new HBox();
       hb5.setAlignment(Pos.CENTER);
       hb5.setSpacing(20);
              
       HBox hb6=new HBox();
       hb6.setAlignment(Pos.CENTER);
       hb6.setSpacing(20);
          
       HBox hb7=new HBox();
       hb7.setAlignment(Pos.CENTER);
       hb7.setSpacing(20);
       HBox hb8=new HBox();
       hb8.setAlignment(Pos.CENTER);
       hb8.setSpacing(20);
     
       VBox vb1=new VBox();
       vb1.setAlignment(Pos.CENTER);
       vb1.setSpacing(20);
       
       Label labName=new Label("Name");
       TextField fName=new TextField("First");
      TextField lName=new TextField("Last");
      hb1.getChildren().addAll(labName,fName,lName);
      
       Label age=new Label("Age");
       TextField agetxt=new TextField();
       hb2.getChildren().addAll(age,agetxt);
       
       Label gender=new Label();
       ComboBox <String>comboBox=new ComboBox<>();
      comboBox.getItems().addAll("Male","Female");
      hb3.getChildren().addAll(gender,comboBox);
      
      Label labPho=new Label("Phone Number");
       TextField photxt=new TextField("ex:2023456");
       hb4.getChildren().addAll(labPho,photxt);
       

       
        Label labAdd=new Label("Address");
        TextField addtxt=new TextField("street,city,state");
        hb5.getChildren().addAll(labAdd,addtxt);
        
       Label country=new Label("Country");
       TextField countxt=new TextField();
       hb6.getChildren().addAll(country,countxt);
       
       Label labNat=new Label("National ID");
       TextField nattxt=new TextField();
       hb7.getChildren().addAll(labNat,nattxt);
       
       Label labnum=new Label("Number of companions");
       TextField numtxtt=new TextField("ex:4");
       hb8.getChildren().addAll(labPho,photxt);
      
      vb1.getChildren().addAll(hb1,hb2,hb3,hb4,hb5,hb6,hb7,hb8);
       MenuItem m=new CheckMenuItem();
      
       Scene scene=new Scene(vb1,500,800);
       s.setScene(scene);
       s.initStyle(StageStyle.UNDECORATED);
       s.show();
   }
    
}
