package carprov.navigation;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import carprov.dashboard.api.App;
import carprov.dashboard.api.ImageHelper;

public class NavigationApp implements App {
      
   @Override
   public String getAppName() {
      return "Navigation";
   }
   
   @Override
   public int getPreferredPosition() {
      return 10;
   }
   
   @Override
   public Node getDashboardIcon() {
      return ImageHelper.getImage(getClass().getResourceAsStream("/maps.png"));
   }

   @Override
   public Node getMainApp() {
      Text text = new Text("Destination: ");
      text.setFont(new Font("Open Sans", 18));
      text.setFill(Color.AZURE);
      VBox box = new VBox(text);
      box.setPadding(new Insets(2));
      box.setBackground(new Background(new BackgroundFill(Color.web("#444444"), new CornerRadii(3), Insets.EMPTY)));
      TextField dest = new TextField("J-Fall 2015!");
      FlowPane flowPane = new FlowPane(box, dest);
      flowPane.setPadding(new Insets(30));
      Image image = ImageHelper.getImage(getClass().getResourceAsStream("/map.png")).getImage();
      flowPane.setBackground(
          new Background(
                new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 
                      new BackgroundSize(100, 100,true, true, false, true))));
       
      return flowPane;
   }

}
