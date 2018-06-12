package sample;

import javafx.collections.ObservableList;

public class MenuEvent {
    private TypeMenuEvent type;
    private ObservableList<Project> selectedProjects;

    public MenuEvent(TypeMenuEvent type) {
        this.type = type;
    }

    public TypeMenuEvent getType() {
        return type;
    }

    public ObservableList<Project> getSelectedProjects() {
        return selectedProjects;
    }
}
