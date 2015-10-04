package carprov.dashboard.jfx;

import carprov.dashboard.api.App;
import carprov.dashboard.api.ImageHelper;

import java.util.ServiceLoader;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dashboard {

   private static final String DASHBOARD_TITLE = "Ace Car Entertainment";

   private static Text titleText;
   private static BorderPane mainView;
   private static FlowPane dashboardIcons;

   public static void main(String[] args) {
      // Workaround to trigger toolkit init because
      // we are not using JavaFX's Application class
      new JFXPanel();
      Platform.runLater(() -> createUI());
   }

   public static void createUI() {
      mainView = new BorderPane();
      mainView.setPadding(new Insets(20));
      Scene scene = new Scene(mainView, 600, 400);
      mainView.setStyle("-fx-background-color: #444444;");
      mainView.setTop(getTopBar());

      dashboardIcons = new FlowPane();
      dashboardIcons.setVgap(25);
      dashboardIcons.setHgap(25);
      dashboardIcons.setPadding(new Insets(20));
      dashboardIcons.setOrientation(Orientation.HORIZONTAL);
      
      Stage primaryStage = new Stage();
      Iterable<App> apps = ServiceLoader.load(App.class);

      for(App app: apps) {
        renderDashboardIcon(app);
      }
      
      startDashboard();
      primaryStage.setScene(scene);
      primaryStage.show();
   }

  private static void renderDashboardIcon(App app) {
    Node dashboardIcon = app.getDashboardIcon();
    dashboardIcons.getChildren().add(dashboardIcon);
    dashboardIcon.setOnMouseClicked(event -> startApp(app));
  }

  private static void startApp(App app) {
    titleText.setText(DASHBOARD_TITLE + " > " + app.getAppName()); 
    Node mainApp = app.getMainApp();
    mainView.setCenter(mainApp);
  }

  private static void startDashboard() {
    titleText.setText(DASHBOARD_TITLE);
    mainView.setCenter(dashboardIcons);
  }

   private static Node getTopBar() {
      ImageView homeImg = ImageHelper.getImage(Dashboard.class.getResourceAsStream("/home.png"));
      homeImg.setFitHeight(40);
      homeImg.setOnMouseClicked(event -> startDashboard());
      

      titleText = new Text(DASHBOARD_TITLE);
      titleText.setFont(new Font("Open Sans", 22));
      titleText.setFill(Color.AZURE);

      BorderPane pane = new BorderPane();
      pane.setPadding(new Insets(10));
      pane.setStyle("-fx-background-color: #222222;");
      pane.setLeft(titleText);
      pane.setRight(homeImg);
      return pane;
  }
}