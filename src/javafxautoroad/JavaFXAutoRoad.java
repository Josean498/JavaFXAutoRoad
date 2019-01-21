/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxautoroad;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.AQUA;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.GRAY;
import static javafx.scene.paint.Color.ORANGE;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;


/* 
 * @author José Antonio Naranjo Ortega.
 * 1ºDAW.
 */

public class JavaFXAutoRoad extends Application {
    Pane root;
    int posY1 = 0;
    int posY2 = -800;
    int velocidad = 4;
    Scene scene;
    int cochePosX = 500;
    int cochePosY = 450;
    int cocheCurrentSpeed = 0;
    Group groupCoche = new Group();
    /*
    Creación de un método para el diseño del coche:
    */
    public void coche () {
            /*
            Rectángulo grande del coche, parte trasera del coche.
            */
            Rectangle rectangleCoche = new Rectangle(150, 130, 240, 75);
            rectangleCoche.setFill(BLUE);
            groupCoche.getChildren().add(rectangleCoche);
            /*
            Son dos rectángulos pequeños que hacen de rudeas del coche.
            */
            Rectangle rectangle = new Rectangle(150, 203, 35, 30);
            rectangle.setFill(BLACK);
            groupCoche.getChildren().add(rectangle);

            Rectangle rectangle2 = new Rectangle(355, 203, 35, 30);
            rectangle2.setFill(BLACK);
            groupCoche.getChildren().add(rectangle2);
            /*
            Parte superior del coche donde va la luna.
            */
            Rectangle rectangleCoche2 = new Rectangle(196, 80, 150, 75);
            rectangleCoche2.setFill(BLUE);
            groupCoche.getChildren().add(rectangleCoche2);
            /*
            Luna del coche.
            */
            Rectangle rectangleCoche3 = new Rectangle(209, 88, 125, 40);
            rectangleCoche3.setFill(AQUA);
            groupCoche.getChildren().add(rectangleCoche3);
            /*
            Simulación de un techo solar abierto.
            */
            Rectangle rectangle3 = new Rectangle(216, 74, 115, 6);
            rectangle3.setFill(BLACK);
            groupCoche.getChildren().add(rectangle3);
            /*
            Los rectángulos rojos y los circulos naranjas son los faros con intermitentes.
            */
            Rectangle rectangle4 = new Rectangle(340, 130, 50, 30);
            rectangle4.setFill(RED);
            groupCoche.getChildren().add(rectangle4);

            Rectangle rectangle5 = new Rectangle(150, 130, 50, 30);
            rectangle5.setFill(RED);
            groupCoche.getChildren().add(rectangle5);

            Circle circleBall = new Circle(170, 144, 7);
            circleBall.setFill(ORANGE);
            groupCoche.getChildren().add(circleBall);

            Circle circleBall2 = new Circle(370, 144, 7);
            circleBall2.setFill(ORANGE);
            groupCoche.getChildren().add(circleBall2);
            /*
            Esto es la matrícula en blanca y lo color aqua tambien forma parte de la matrícula.
            */
            Rectangle rectangle6 = new Rectangle(238, 160, 70, 20);
            rectangle6.setFill(WHITE);
            groupCoche.getChildren().add(rectangle6);

            Rectangle rectangleCoche7 = new Rectangle(237, 160, 10, 20);
            rectangleCoche7.setFill(AQUA);
            groupCoche.getChildren().add(rectangleCoche7);
            /*
            Con las elipses he hecho los escapes.
            */
            Ellipse ellipse = new Ellipse();
            {
                ellipse.setCenterX(295.0f);
                ellipse.setCenterY(194.0f);
                ellipse.setRadiusX(16.0f);
                ellipse.setRadiusY(7.0f);
                groupCoche.getChildren().add(ellipse);
                ellipse.setFill(GRAY);
            }

            Ellipse ellipse2 = new Ellipse();
            {
                ellipse2.setCenterX(295.0f);
                ellipse2.setCenterY(194.0f);
                ellipse2.setRadiusX(11.0f);
                ellipse2.setRadiusY(5.0f);
                groupCoche.getChildren().add(ellipse2);
                ellipse2.setFill(BLACK);
            }

            Ellipse ellipse3 = new Ellipse();
            {
                ellipse3.setCenterX(250.0f);
                ellipse3.setCenterY(194.0f);
                ellipse3.setRadiusX(16.0f);
                ellipse3.setRadiusY(7.0f);
                groupCoche.getChildren().add(ellipse3);
                ellipse3.setFill(GRAY);
            }

            Ellipse ellipse4 = new Ellipse();
            {
                ellipse4.setCenterX(250.0f);
                ellipse4.setCenterY(194.0f);
                ellipse4.setRadiusX(11.0f);
                ellipse4.setRadiusY(5.0f);
                groupCoche.getChildren().add(ellipse4);
                ellipse4.setFill(BLACK);
            }
        groupCoche.setScaleX(0.55);
        groupCoche.setScaleY(0.55);
        groupCoche.setLayoutX(cochePosX);
        groupCoche.setLayoutY(cochePosY);
        root.getChildren().add(groupCoche);
        
    }
    /*
    Creación de un método para la carretera y el moviemnto infinito de la imagen:
    */
    public void carretera () {
       Image image1 = new Image(getClass().getResourceAsStream("images/carretera.png"));
       ImageView imageView1 = new ImageView(image1);
       root.getChildren().add(imageView1);
       imageView1.setFitHeight(800);
       imageView1.setFitWidth(900);
       
       ImageView imageView2 = new ImageView(image1);
       root.getChildren().add(imageView2);
       imageView2.setFitHeight(800);
       imageView2.setFitWidth(900);
       AnimationTimer animationCoche = new AnimationTimer() {
        @Override
        public void handle(long now) {
            imageView1.setY(posY1);
            imageView2.setY(posY2);
            posY1 += velocidad;
            posY2 += velocidad;
            if (posY2==0) {
                posY1=-800;
            }
            if (posY1==0) {
                posY2=-800;
            }
            cochePosX += cocheCurrentSpeed;
            groupCoche.setLayoutX(cochePosX);
        };
       };
       animationCoche.start();
    }
    /*
    Creación de un método para los obstáculos para que se vayan generando en posiciones aleatorias:
    */
    public void obstáculos () {
        Image image2 = new Image(getClass().getResourceAsStream("images/guardia.png"));
        ImageView imageView3 = new ImageView(image2);
        root.getChildren().add(imageView3);
        imageView3.setFitHeight(150);
        imageView3.setFitWidth(170);
      
        Rectangle rectangleBidon = new Rectangle(300, 300, 50, 70);
        rectangleBidon.setFill(RED);
        root.getChildren().add(rectangleBidon);
        
        Rectangle rectangleBidon2 = new Rectangle(280, 295, 25, 8);
        rectangleBidon2.setFill(BLACK);
        rectangleBidon2.setRotate(20);
        root.getChildren().add(rectangleBidon2);
       
    };

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        scene = new Scene(root, 900, 800, Color.GRAY);
        primaryStage.setTitle("AutoroadFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        carretera();
        coche();
        obstáculos();
        scene.setOnKeyPressed((KeyEvent event) -> {  
            switch(event.getCode()) {
                case RIGHT:
                    cocheCurrentSpeed = 6;
                    break;
                case LEFT:                 
                    cocheCurrentSpeed = -6;
                    break;
            } 
        }); 
        scene.setOnKeyReleased((KeyEvent event) -> {  
            cocheCurrentSpeed = 0;
        });
    }
}