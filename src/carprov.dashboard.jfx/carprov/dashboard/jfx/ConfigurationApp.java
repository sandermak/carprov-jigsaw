package carprov.dashboard.jfx;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import carprov.dashboard.api.App;
import carprov.dashboard.api.ImageHelper;

public class ConfigurationApp implements App {
   
   @Override
   public String getAppName() {
      return "Config";
   }
   
   @Override
   public int getPreferredPosition() {
      return 100;
   }

   @Override
   public Node getDashboardIcon() {
      return ImageHelper.getImage(getClass().getResourceAsStream("/config.png"));
   }

   @Override
   public Node getMainApp() {
      FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
      flowPane.setAlignment(Pos.CENTER);
      
      // for(Bundle b: bundleContext.getBundles()) {
      //    if(b.getSymbolicName().startsWith("carprov"))
      //       flowPane.getChildren().add(getBundleVersion(b));
      // }
      
      return flowPane;
   }

   // private Node getBundleVersion(Bundle b) {
   //    Text text = new Text(b.getSymbolicName() + ": " + b.getHeaders().get("Bundle-Version") + " (" + new Date(b.getLastModified())+ ")");
   //    text.setFont(new Font("Open Sans", 18));
   //    text.setFill(Color.AZURE);
   //    return text;
   // }

}
