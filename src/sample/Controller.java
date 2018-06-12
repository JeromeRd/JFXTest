package sample;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Subscribe
    public void handlePurchaseEvent(MenuEvent menuEvent) {
        switch (menuEvent.getType()) {
            case DEPLOY:

                break;
            default:
                //Do nothing
                break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventBusSingleton.getInstance().register(this);
    }
}
