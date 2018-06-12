package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ProjectManagerSingleton {

    private static ProjectManagerSingleton instance = new ProjectManagerSingleton();

    private ProjectManagerSingleton() {
    }

    private Pane createLoadingPane() {
        Pane loadingPane = new VBox();
        ImageView loading = new ImageView("loading.gif");
        loading.setFitWidth(20);
        loading.setFitHeight(20);
        loadingPane.getChildren().add(loading);
        loadingPane.setId(StyleLibrary.LOADING_STYLE);
        ((VBox)loadingPane).setAlignment(Pos.CENTER);
        return loadingPane;
    }

    public static ProjectManagerSingleton getInstance() {
        return instance;
    }

    public Project createProject() {
        Project project = new Project("test", "status", null, "step");
        //project.setAction(createAction(project));
        return project;
    }

    public void loadingOn(Project project) {
        project.setAction(createLoadingPane());
    }

    public void loadingOff(Project project) {
        //project.setAction(createAction(project));
        project.setAction(null);
    }

    private Pane createAction(Project project) {
        VBox pane = new VBox();
        pane.setSpacing(2);pane.setPrefWidth(100);
        pane.getChildren().add(ButtonFactory.createDeployButton(project));
        pane.setVisible(false);
        pane.setId(StyleLibrary.ACTION_PANE_STYLE);
        return pane;
    }
}