package carprov.music;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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
        return ImageHelper.getImage(getClass().getResourceAsStream("/music.png"));
    }

    @Override
    public Node getMainApp() {
        ImageView background = ImageHelper.getImage(getClass().getResourceAsStream("/wave.gif"));
        ColorInput blackout = new ColorInput();
        blackout.setPaint(Color.BLACK);
        background.setEffect(blackout);
        StackPane stackPane = new StackPane(background);
        
        ImageView playButton = ImageHelper.getImage(getClass().getResourceAsStream("/play.png"));
        playButton.setOnMouseClicked((evt) -> background.setEffect(null));
        ImageView stopButton = ImageHelper.getImage(getClass().getResourceAsStream("/stop.png"));
        stopButton.setOnMouseClicked((evt) -> background.setEffect(blackout));
        HBox buttons = new HBox(
                ImageHelper.getImage(getClass().getResourceAsStream("/prev.png")),
                playButton,
                stopButton,
                ImageHelper.getImage(getClass().getResourceAsStream("/forward.png"))
                );
        StackPane.setMargin(buttons, new Insets(30, 0, 0, 70));
        StackPane.setAlignment(buttons, Pos.TOP_CENTER);
        stackPane.getChildren().add(buttons);
        return stackPane;
    }

}
