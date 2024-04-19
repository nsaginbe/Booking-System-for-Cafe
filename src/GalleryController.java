import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GalleryController {
    public ImageView image1, image2, image3, image4, image5, image6;
    public Timer timer;

    public void entered(){
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                image1.setImage(new Image("gallery/food" + (new Random().nextInt(4) + 1) + ".jpg"));
                image5.setImage(new Image("gallery/food" + (new Random().nextInt(4) + 5) + ".jpg"));
                image2.setImage(new Image("gallery/food" + (new Random().nextInt(3) + 9) + ".jpg"));
                image6.setImage(new Image("gallery/food" + (new Random().nextInt(3) + 12) + ".jpg"));
                image3.setImage(new Image("gallery/food" + (new Random().nextInt(3) + 15) + ".jpg"));
                image4.setImage(new Image("gallery/food" + (new Random().nextInt(3) + 18) + ".jpg"));
            }
        }, 0, 3000);
    }

    public void exited(){
        timer.cancel();
    }
}
