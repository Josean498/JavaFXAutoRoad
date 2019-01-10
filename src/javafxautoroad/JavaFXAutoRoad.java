/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxautoroad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.PINK;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Jose
 */
public class JavaFXAutoRoad extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 400, Color.BROWN);
        primaryStage.setTitle("PongFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Circle circleBall2 = new Circle(300, 200, 50);
        Circle circleBall = new Circle(300, 200, 100);
        circleBall.setFill(PINK);
        circleBall2.setFill(RED);
        root.getChildren().add(circleBall);
        root.getChildren().add(circleBall2);

    }

}
