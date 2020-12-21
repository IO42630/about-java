

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * How it works:
 * [1] start() calls .fxml file
 * [2] .fxml file contains location of controller class, which controlls what stuff does.
 */
public class FXMLApp extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLApp.fxml"));





        Scene scene = new Scene(root, 300, 275);


        primaryStage.setTitle("mucc");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
