package sample;

import javafx.scene.layout.Pane;

public class Project {

    private String name;
    private String status;
    private Pane action;
    private String step;
    private boolean isLoading;

    public Project(String name, String status, Pane pane, String step) {
        this.name = name;
        this.status = status;
        this.action = pane;
        this.step = step;
        this.isLoading = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pane getAction() {
        return action;
    }

    public void setAction(Pane pane) {
        this.action = pane;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public void loading(boolean on) {
        if (on && !isLoading) {
            ProjectManagerSingleton.getInstance().loadingOn(this);
        } else {
            ProjectManagerSingleton.getInstance().loadingOff(this);
        }
        isLoading = !isLoading;
    }
}
