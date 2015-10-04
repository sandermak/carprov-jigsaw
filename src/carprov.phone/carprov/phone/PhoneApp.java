package carprov.phone;

import java.util.concurrent.atomic.AtomicReference;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


import carprov.dashboard.api.App;
import carprov.dashboard.api.ImageHelper;

public class PhoneApp implements App {
   
   
   private AtomicReference<Node> mainApp = new AtomicReference<>();
   
   public PhoneApp() {
      mainApp.set(getMainAppNode());
   }
   
   @Override
   public String getAppName() {
      return "Phone";
   }
   
   @Override
   public int getPreferredPosition() {
      return 20;
   }
   
   @Override
   public Node getDashboardIcon() {
      return ImageHelper.getImage(getClass().getResourceAsStream("/phone.png"));
   }

   @Override
   public Node getMainApp() {
      return mainApp.get();
   }
   
   public Node getMainAppNode() {
      BorderPane pane = new BorderPane();
      pane.setPadding(new Insets(20));
      ImageView numberPadImg = ImageHelper.getImage(getClass().getResourceAsStream("/number-pad.png"));
      numberPadImg.setFitHeight(100);
      BorderPane.setAlignment(numberPadImg, Pos.CENTER);
      pane.setLeft(numberPadImg);
      TextField phone = new TextField();
      phone.setFont(new Font(20));
      phone.setMaxWidth(200);
      pane.setCenter(phone);
      return pane;
   }

}
