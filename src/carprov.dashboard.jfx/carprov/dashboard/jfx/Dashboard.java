package carprov.dashboard.jfx;

import carprov.dashboard.api.App;

import java.util.ServiceLoader;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class Dashboard {
   public static void main(String[] args) {
      // Workaround to trigger toolkit init because
      // we are not using JavaFX's Application class
      new JFXPanel();
      Platform.runLater(() -> start());
   }

   public static void start() {
      Stage primaryStage = new Stage();
      primaryStage.setTitle("Hello World!");
      Iterable<App> apps = ServiceLoader.load(App.class);
      StackPane root = new StackPane();

      for(App app: apps) {
        root.getChildren().add(app.getMainApp());
      }
        
        
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
   }
}