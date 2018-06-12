package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class ContextMenuFactory {

    public static ContextMenu getContextMenu() {
        ContextMenu cm = new ContextMenu();
        MenuItem remove = new MenuItem("Remove");
        cm.getItems().add(remove);
        MenuEvent removeEvent = new MenuEvent(TypeMenuEvent.REMOVE_FROM_PROJECT);
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EventBusSingleton.getInstance().post(removeEvent);
            }
        });

        MenuItem edit = new MenuItem("Edit");
        cm.getItems().add(edit);
        MenuEvent editEvent = new MenuEvent(TypeMenuEvent.EDIT);
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Edit!");
                EventBusSingleton.getInstance().post(editEvent);
            }
        });
        MenuItem deploy = new MenuItem("Deploy");
        cm.getItems().add(deploy);
        MenuEvent deployEvent = new MenuEvent(TypeMenuEvent.DEPLOY);
        deploy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Deploy!");
                EventBusSingleton.getInstance().post(deployEvent);
            }
        });
        MenuItem cancel = new MenuItem("Cancel");
        cm.getItems().add(cancel);
        MenuEvent cancelEvent = new MenuEvent(TypeMenuEvent.CANCEL_ACTION);
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Cancel!");
                EventBusSingleton.getInstance().post(cancelEvent);
            }
        });
        return cm;
    }
}
