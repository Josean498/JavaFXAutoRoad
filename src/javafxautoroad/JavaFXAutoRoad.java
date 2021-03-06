package javafxautoroad;

import java.util.Random;
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
import javafx.scene.shape.Shape;

/* @author José Antonio Naranjo Ortega.1ºDAW. */

public class JavaFXAutoRoad extends Application {
    Pane root;
    Scene scene;
    int posY1;
    int posY2 = -800;
    int velocidad;
    int velocidadGuardia;
    int cochePosX = 500;
    int cochePosY = 450;
    int cocheCurrentSpeed;
    int posYGuardia;
    ImageView imageGuardia1;
    ImageView imageGuardia2;
    ImageView imageGuardia3;
    ImageView imageGuardia4;
    ImageView intro1;
    ImageView score1;
    ImageView gta;
    Group groupCoche = new Group();
    Group groupGuardia = new Group();
    Group groupGuardia2 = new Group();
    Group groupGuardia3 = new Group();
    Group groupGuardia4 = new Group();
    Random random = new Random();
    Rectangle rectangleCoche = new Rectangle(150, 130, 240, 75);
    Rectangle rectangleGuardia1 = new Rectangle();
    Rectangle rectangleGuardia2 = new Rectangle();
    Rectangle rectangleGuardia3 = new Rectangle();
    Rectangle rectangleGuardia4 = new Rectangle();
    /* Creación de un método para el diseño del coche: */
    public void coche () {
            /*
            Rectángulo grande del coche, parte trasera del coche.
            */
            rectangleCoche = new Rectangle(150, 130, 240, 75);
            rectangleCoche.setFill(BLUE);
            groupCoche.getChildren().add(rectangleCoche);
            /*
            Son dos rectángulos pequeños que hacen de ruedas del coche.
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
        /*
         Rescalado, puesto en su pos inicial, agrupado y mostrado del coche:   
        */
        groupCoche.setScaleX(0.55);
        groupCoche.setScaleY(0.55);
        groupCoche.setLayoutX(cochePosX);
        groupCoche.setLayoutY(cochePosY);
        root.getChildren().add(groupCoche);
        
    }
    /* Creación de un método para la carretera y el moviemnto infinito de la imagen: */
    public void carretera () {
       Image imageCarretera = new Image(getClass().getResourceAsStream("images/carretera.png"));
       ImageView imageCarretera1 = new ImageView(imageCarretera);
       root.getChildren().add(imageCarretera1);
       imageCarretera1.setFitHeight(800);
       imageCarretera1.setFitWidth(900);
       
       ImageView imageCarretera2 = new ImageView(imageCarretera);
       root.getChildren().add(imageCarretera2);
       imageCarretera2.setFitHeight(800);
       imageCarretera2.setFitWidth(900);
       /*
       Rectangulos de los bordes
       */
       Rectangle rectangleBorde = new Rectangle(850,0,5,800);
       Rectangle rectangleBorde2 = new Rectangle(45,0,5,800);
       AnimationTimer animationCarretera = new AnimationTimer() {
        @Override
        public void handle(long now) {
            imageCarretera1.setY(posY1);
            imageCarretera2.setY(posY2);
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
           Shape shapeColision = Shape.intersect(rectangleBorde, rectangleCoche);
           Shape shapeColision2 = Shape.intersect(rectangleBorde2, rectangleCoche);
           boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
           boolean colisionVacia2 = shapeColision2.getBoundsInLocal().isEmpty();
            if(colisionVacia == false) {
                reinicio();
                score1.setVisible(false);
                groupCoche.setVisible(false);
            }
            if(colisionVacia2 == false) {
                reinicio();
                score1.setVisible(false);
                groupCoche.setVisible(false);   
            }
        }
        };
      animationCarretera.start();
    }
    /* Creación de un método para los obstáculos para que se vayan generando en posiciones aleatorias: */
    public void obstáculos () {
        Image imageGuardia = new Image(getClass().getResourceAsStream("images/guardia.png"));
        imageGuardia1 = new ImageView(imageGuardia);
        groupGuardia.getChildren().add(imageGuardia1);
        imageGuardia1.setFitHeight(180);
        imageGuardia1.setFitWidth(230);
        rectangleGuardia1 = new Rectangle(65,55,140,90);
        groupGuardia.getChildren().add(rectangleGuardia1);
        rectangleGuardia1.setVisible(false);
        groupGuardia.setLayoutX(30);

        imageGuardia2 = new ImageView(imageGuardia);
        groupGuardia2.getChildren().add(imageGuardia2);
        imageGuardia2.setFitHeight(180);
        imageGuardia2.setFitWidth(230);
        rectangleGuardia2 = new Rectangle(65,55,140,90);
        groupGuardia2.getChildren().add(rectangleGuardia2);
        rectangleGuardia2.setVisible(false);
        groupGuardia2.setLayoutX(230);

        imageGuardia3 = new ImageView(imageGuardia);
        groupGuardia3.getChildren().add(imageGuardia3);
        imageGuardia3.setFitHeight(180);
        imageGuardia3.setFitWidth(230);
        rectangleGuardia3 = new Rectangle(65,55,140,90);
        groupGuardia3.getChildren().add(rectangleGuardia3);
        rectangleGuardia3.setVisible(false);
        groupGuardia3.setLayoutX(430);
        
        imageGuardia4 = new ImageView(imageGuardia);
        groupGuardia4.getChildren().add(imageGuardia4);
        imageGuardia4.setFitHeight(180);
        imageGuardia4.setFitWidth(230);
        rectangleGuardia4 = new Rectangle(65,55,140,90);
        groupGuardia4.getChildren().add(rectangleGuardia4);
        rectangleGuardia4.setVisible(false);
        groupGuardia4.setLayoutX(630);
        
        root.getChildren().add(groupGuardia);
        root.getChildren().add(groupGuardia2);
        root.getChildren().add(groupGuardia3); 
        root.getChildren().add(groupGuardia4);

        Image wasted = new Image(getClass().getResourceAsStream("images/gta.png"));
        gta = new ImageView(wasted);
        root.getChildren().add(gta);
        gta.setVisible(false);
        gta.setLayoutX(250);
        gta.setLayoutY(150);
        AnimationTimer animationObstaculos = new AnimationTimer() {
        @Override
            public void handle(long now) {
                groupGuardia.setLayoutY(posYGuardia);
                groupGuardia2.setLayoutY(posYGuardia);
                groupGuardia3.setLayoutY(posYGuardia);
                groupGuardia4.setLayoutY(posYGuardia);
                posYGuardia += velocidadGuardia;
                if (posYGuardia >= 800){
                    posYGuardia = -150;
                    obstAleatorio();
                }
                Shape shapeColision3 = Shape.intersect(rectangleGuardia1, rectangleCoche);
                boolean colisionVacia3 = shapeColision3.getBoundsInLocal().isEmpty();
                if(colisionVacia3 == false) {
                    reinicio();
                    gta.setVisible(true);
                    score1.setVisible(false);
                    groupCoche.setVisible(false);
                }
                Shape shapeColision4 = Shape.intersect(rectangleGuardia2, rectangleCoche);
                boolean colisionVacia4 = shapeColision4.getBoundsInLocal().isEmpty();
                if(colisionVacia4 == false) {
                    reinicio();
                    gta.setVisible(true);
                    score1.setVisible(false);
                    groupCoche.setVisible(false);
                }
                Shape shapeColision5 = Shape.intersect(rectangleGuardia3, rectangleCoche);
                boolean colisionVacia5 = shapeColision5.getBoundsInLocal().isEmpty();
                if(colisionVacia5 == false) {
                    reinicio();
                    gta.setVisible(true);
                    score1.setVisible(false);
                    groupCoche.setVisible(false);
                }
                Shape shapeColision6 = Shape.intersect(rectangleGuardia4, rectangleCoche);
                boolean colisionVacia6 = shapeColision6.getBoundsInLocal().isEmpty();
                if(colisionVacia6 == false) {
                    reinicio();
                    gta.setVisible(true);
                    score1.setVisible(false);
                    groupCoche.setVisible(false);
                }
            }
            
        };
        animationObstaculos.start();
    }
    /* Método para generar posiciones aleatorias en el eje X. */
    public void obstAleatorio() {
        int obstAleatorio;
        obstAleatorio = random.nextInt(4);
            switch(obstAleatorio) {
                case 0:
                    groupGuardia.setDisable(true);
                    break;
                case 1:                 
                    groupGuardia2.setDisable(true);
                    break;
                case 2:
                    groupGuardia3.setDisable(true);
                    break;
                case 3:
                    groupGuardia4.setDisable(true);
                    break;
            }
//        int obstAleatorio2;
//        obstAleatorio2 = random.nextInt(4);
//            switch(obstAleatorio2) {
//                case 0:
//                    groupGuardia2.setLayoutX(30);
//                    break;
//                case 1:                 
//                    groupGuardia2.setLayoutX(230);
//                    break;
//                case 2:
//                    groupGuardia2.setLayoutX(430);
//                    break;
//                case 3:
//                    groupGuardia2.setLayoutX(630);
//                    break;
//            }
//        int obstAleatorio3;
//        obstAleatorio3 = random.nextInt(4);
//            switch(obstAleatorio3) {
//                case 0:
//                    groupGuardia3.setLayoutX(30);
//                    break;
//                case 1:                 
//                    groupGuardia3.setLayoutX(230);
//                    break;
//                case 2:
//                    groupGuardia3.setLayoutX(430);
//                    break;
//                case 3:
//                    groupGuardia3.setLayoutX(630);
//                    break;
//            }
    }
    /* Método para la imagen inicial del juego. */
    public void intro () {
        Image intro = new Image(getClass().getResourceAsStream("images/intro1.jpeg"));
        intro1 = new ImageView();
        intro1.setImage(intro);
        intro1.setFitHeight(800);
        intro1.setFitWidth(900);
        root.getChildren().add(intro1);
    }
    /* Método para la puntucaion. */
    public void score() {
        Image score = new Image(getClass().getResourceAsStream("images/score.png"));
        score1 = new ImageView();
        score1.setImage(score);
        score1.setFitHeight(40);
        score1.setFitWidth(90);
        score1.setX(70);
        score1.setY(20);
        root.getChildren().add(score1);
    }
    /* Método para el reinicio del juego. */
    public void reinicio() {
        cochePosX = 500;
        cochePosY = 450;
        posY1 = 0;
        posY2 = -800;
        velocidad = 0;
        velocidadGuardia = 0;
        posYGuardia = -400;
        obstAleatorio();
        gta.setVisible(true);
        
    }
    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        int SCENETAMX = 900;
        int SCENETAMY = 800;
        scene = new Scene(root, SCENETAMX, SCENETAMY, Color.GRAY);
        primaryStage.setTitle("Autoroad");
        primaryStage.setScene(scene);
        primaryStage.show();
        this.carretera();
        this.obstáculos();
        this.coche();
        this.score();
        this.intro();
        /* Si la tecla es pulsada se mueve y cuando es soltada se queda en la pos que está */
        scene.setOnKeyPressed((KeyEvent event) -> {  
            switch(event.getCode()) {
                case RIGHT:
                    cocheCurrentSpeed = 6;
                    break;
                case LEFT:                 
                    cocheCurrentSpeed = -6;
                    break;   
                case ENTER:
                    reinicio();
                    velocidad = 4;
                    velocidadGuardia = 6;
                    intro1.setVisible(false);
                    gta.setVisible(false);
                    score1.setVisible(true);
                    groupCoche.setVisible(true);
                    break;
            } 
        }); 
        scene.setOnKeyReleased((KeyEvent event) -> {  
            cocheCurrentSpeed = 0;
        });
    }
}