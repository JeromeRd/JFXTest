package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML private MenuBar menuBar;

    @FXML
    private void newProject() {
        System.out.println("New project");
        MenuEvent event = new MenuEvent(TypeMenuEvent.NEW_PROJECT);
        EventBusSingleton.getInstance().post(event);
    }

    @FXML
    private void removeProject() {
        System.out.println("Remove project");
        MenuEvent event = new MenuEvent(TypeMenuEvent.REMOVE_PROJECT);
        EventBusSingleton.getInstance().post(event);
    }

    @FXML
    private void addInProject() {
        System.out.println("Add in project");
        MenuEvent event = new MenuEvent(TypeMenuEvent.ADD_IN_PROJECT);
        EventBusSingleton.getInstance().post(event);
    }

    @FXML
    private void removeFromProject() {
        System.out.println("Remove from project");
        MenuEvent event = new MenuEvent(TypeMenuEvent.REMOVE_FROM_PROJECT);
        EventBusSingleton.getInstance().post(event);
    }

    @FXML
    private void selectAll() {
        System.out.println("Select/deselect all");
        MenuEvent event = new MenuEvent(TypeMenuEvent.SELECT_ALL);
        EventBusSingleton.getInstance().post(event);
    }

    @FXML
    private void exit() {
        System.out.println("Exit");
        MenuEvent event = new MenuEvent(TypeMenuEvent.EXIT);
        EventBusSingleton.getInstance().post(event);
    }

    @FXML
    private void deploy() {
        System.out.println("Deploy");
        MenuEvent event = new MenuEvent(TypeMenuEvent.DEPLOY);
        EventBusSingleton.getInstance().post(event);
    }

    @FXML
    private void test() {
        /*System.out.println("Test");
        MenuEvent event = new MenuEvent(TypeMenuEvent.TEST);
        EventBusSingleton.getInstance().post(event);*/
    }

    /**
     * Handle action related to "About" menu item.
     *
     * @param event Event on "About" menu item.
     */
    @FXML
    private void handleAboutAction(final ActionEvent event)
    {
        //TODO show version and other informations
    }

    /**
     * Handle action related to input (in this case specifically only responds to
     * keyboard event CTRL-A).
     *
     * @param event Input event.
     */
    @FXML
    private void handleKeyInput(final InputEvent event)
    {
        if (event instanceof KeyEvent)
        {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A)
            {
                provideAboutFunctionality();
            }
        }
    }

    /**
     * Perform functionality associated with "About" menu selection or CTRL-A.
     */
    private void provideAboutFunctionality()
    {
        System.out.println("You clicked on About!");
    }


    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        menuBar.setFocusTraversable(true);
    }
}
