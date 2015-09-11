package carprov.dashboard.jfx;

import carprov.music.MusicPlayer;

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
      System.out.println("Hi from " + MusicPlayer.msg());
      Platform.runLater(() -> start());
   }

   public static void start() {
      Stage primaryStage = new Stage();
      primaryStage.setTitle("Hello World!");
      
        // Button btn = new Button();
        // btn.setText("Say 'Hello World'");
        // btn.setOnAction(new EventHandler<ActionEvent>() {
 
        //     @Override
        //     public void handle(ActionEvent event) {
        //         System.out.println("Hello World!");
        //     }
        // });
        
        StackPane root = new StackPane();
        // root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
   }
}