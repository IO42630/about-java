package javafx;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class DemoApp extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) {

        // some initial setup
        // ------------------

        primaryStage.setTitle("DemoApp");   // set title of primary window

        GridPane grid = new GridPane();     // Create a GridPane container. Useful when implementing a flexible layout.
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(5);


        //Defining the Name text field
        final TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(10);
        name.getText();                     // ???
        GridPane.setConstraints(name, 0, 0);    // set position in grid, column, row
        grid.getChildren().add(name);

        // Defining the Button
        Button button = new Button("Button");
        button.setFont(new Font("Tahoma", 24)); //
        button.setEffect(new Reflection());     // add reflection under button
        GridPane.setConstraints(button, 1, 0);
        grid.getChildren().add(button);

        button.setStyle("-fx-background-color: #ed1c24;");  // overwrite the style set in 'aboutStyle.css'

        // Animating the Button
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(button.opacityProperty(), 0);
        final KeyFrame kf = new KeyFrame(Duration.millis(600), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();





        // different layouts ???

        VBox vbox = new VBox();







        // final setup, and show the window
        // --------------------------------

        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add("javafx/aboutStyle.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
