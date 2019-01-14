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
import static javafx.scene.paint.Color.AQUA;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.GRAY;
import static javafx.scene.paint.Color.ORANGE;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/* 
 * @author José Antonio Naranjo Ortega.
 */

public class JavaFXAutoRoad extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 400, Color.WHITE);
        primaryStage.setTitle("PongFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
         Rectangle rectangleCoche = new Rectangle(150,130,240,75);
        rectangleCoche.setFill(BLUE);
        root.getChildren().add(rectangleCoche);
        
        Rectangle rectangle = new Rectangle(150, 203,35,30);
        rectangle.setFill(BLACK);
        root.getChildren().add(rectangle);
        
        Rectangle rectangle2 = new Rectangle(355, 203, 35,30);
        rectangle2.setFill(BLACK);
        root.getChildren().add(rectangle2);
        
         Rectangle rectangleCoche2 = new Rectangle(196,80,150,75);
        rectangleCoche2.setFill(BLUE);
        root.getChildren().add(rectangleCoche2);
        
        Rectangle rectangleCoche3 = new Rectangle(209,88,125,40);
        rectangleCoche3.setFill(AQUA);
        root.getChildren().add(rectangleCoche3);
        
        Rectangle rectangle3 = new Rectangle(216, 74, 115,6);
        rectangle3.setFill(BLACK);
        root.getChildren().add(rectangle3);
        
        Rectangle rectangle4 = new Rectangle(340, 130, 50,30);
        rectangle4.setFill(RED);
        root.getChildren().add(rectangle4);
        
        Rectangle rectangle5 = new Rectangle(150, 130, 50,30);
        rectangle5.setFill(RED);
        root.getChildren().add(rectangle5);
        
       
       Circle circleBall = new Circle(170,144,7);
       circleBall.setFill(ORANGE);
       root.getChildren().add(circleBall);
       
       Circle circleBall2 = new Circle(370,144,7);
       circleBall2.setFill(ORANGE);
       root.getChildren().add(circleBall2);
       
       Rectangle rectangle6 = new Rectangle(238, 170, 70,20);
       rectangle6.setFill(WHITE);
       root.getChildren().add(rectangle6);
   
   
    }
    
}
