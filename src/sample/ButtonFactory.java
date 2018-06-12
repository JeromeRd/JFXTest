package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonFactory {

    public static Button createDeployButton(Project project) {
        MenuEvent deployEvent = new MenuEvent(TypeMenuEvent.DEPLOY);
        deployEvent.getSelectedProjects().add(project);

        Button deployButton = new Button("Deploy");
        deployButton.setId(StyleLibrary.ACTION_BUTTON_STYLE);
        deployButton.setPrefWidth(100);
        deployButton.setPrefHeight(20);
        deployButton.setMaxHeight(20);
        deployButton.setMinHeight(20);
        deployButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EventBusSingleton.getInstance().post(deployEvent);
            }
        });
        return deployButton;
    }
}
