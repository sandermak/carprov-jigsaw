package carprov.dashboard.api;

import javafx.scene.Node;

public interface App {

   String getAppName();
   
   int getPreferredPosition();
   
   Node getDashboardIcon();
   
   Node getMainApp();

}