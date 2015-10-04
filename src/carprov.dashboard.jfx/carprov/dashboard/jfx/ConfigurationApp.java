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

import java.lang.reflect.Layer;
import java.lang.reflect.Module;

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
      
      Layer layer = Layer.boot();
      for (Module m: layer.modules()) {
        if(m.getName().startsWith("carprov")) {
           flowPane.getChildren().add(getModuleDescription(m));
        }
      }
      
      return flowPane;
   }

   private Node getModuleDescription(Module m) {
      Text text = new Text(m.getName() + ": " + m.getDescriptor().version().map(Object::toString).orElse("no version specified"));
      text.setFont(new Font("Open Sans", 18));
      text.setFill(Color.AZURE);
      return text;
   }

}
