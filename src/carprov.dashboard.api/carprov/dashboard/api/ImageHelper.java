package carprov.dashboard.api;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageHelper {
   
   public static ImageView getImage(Class<?> loadingContext, String name) {
         Image image = new Image(loadingContext.getClassLoader().getResourceAsStream("/" + name));
         ImageView view = new ImageView(image);
         view.setPreserveRatio(true);
         return view;
   }

}