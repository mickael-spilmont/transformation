package transforms;

import static transforms.Constants.MAX_X;
import static transforms.Constants.MAX_Y;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FC2 the best !");
        primaryStage.setScene(new Scene(root, MAX_X, MAX_Y + 300));
        primaryStage.setWidth(800.0);
        primaryStage.setHeight(800.0);
        primaryStage.resizableProperty().set(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
