
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmanage.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ibaha
 */
public class Messanger {
    public Messanger(String errorMessage) {
        Stage stage = new Stage();
        Text text = new Text(errorMessage);
        text.setStyle("-fx-font: 18 arial;");
        text.setFill(Color.LIGHTCYAN);

        BorderPane p = new BorderPane();

        VBox root = new VBox();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(10);

        root.setAlignment(Pos.CENTER);

        Button ok;

        ok = new Button("Ok");

        ok.setStyle("-fx-background-color: \n"
                + "        rgba(0,0,0,0.8),\n"
                + "        linear-gradient(#9a9a9a, #909090),\n"
                + "        linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%);\n"
                + "    -fx-background-insets: 0 0 -1 0,0,1;\n"
                + "    -fx-background-radius: 5,5,4;\n"
                + "    -fx-padding: 3 30 3 30;\n"
                + "    -fx-text-fill: #242d35;\n"
                + "    -fx-font-size: 14px;");

        root.getChildren().addAll(text,ok);

        ok.setOnAction(e -> {
            stage.hide();
        });

        p.setCenter(root);
        root.setStyle("-fx-background-color:rgba(0,0,0,0.5);");
        p.setStyle("-fx-effect: dropshadow(gaussian, blue, 200, 0, 0, 0);"
                + "-fx-background-insets: 200;");

        Scene scene = new Scene(p, 300, 150);

        p.prefHeightProperty().bind(scene.heightProperty());
        p.prefWidthProperty().bind(scene.widthProperty());

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
