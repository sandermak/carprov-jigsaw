package carprov.music;

import javafx.scene.Node;
import javafx.scene.text.Text;

import carprov.dashboard.api.App;

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
        return null;
    }

    @Override
    public Node getMainApp() {
        return new Text("hiya!");
    }

}
