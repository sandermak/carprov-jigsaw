package carprov.music;

import javafx.scene.Node;
import javafx.scene.text.Text;

import carprov.dashboard.api.App;
import carprov.dashboard.api.ImageHelper;

public class MusicApp implements App {

    @Override
    public String getAppName() {
        return "Music";
    }

    @Override
    public int getPreferredPosition() {
        return 5;
    }

    @Override
    public Node getDashboardIcon() {
        return new Text("Music App");
        //return ImageHelper.getImage(this, "music.png");
    }

    @Override
    public Node getMainApp() {
        return new Text("hiya!");
    }

}
