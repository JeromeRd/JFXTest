package sample;

import com.google.common.eventbus.Subscribe;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

public class TabPaneController implements Initializable {
    @FXML private TabPane tabpane;
    @FXML private Tab tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8, tab9, tab10;

    private Queue<Tab> originalTabs;
    private Set<TableRow> selectedRows = new HashSet<>();

    @Subscribe
    public void handlePurchaseEvent(MenuEvent menuEvent) {
        Tab selectedTab = tabpane.getSelectionModel().getSelectedItem();
        TableView tableView = null;
        if (selectedTab != null) {
            tableView = (TableView) selectedTab.getContent();
        }
        switch (menuEvent.getType()) {
            case NEW_PROJECT:
                if (originalTabs.isEmpty()) {
                    System.out.println("Cannot add a new project, limit is reached");
                } else {
                    tabpane.getTabs().add(originalTabs.poll());
                }
                break;
            case REMOVE_PROJECT:
                if (selectedTab != null) {
                    tabpane.getTabs().remove(selectedTab);
                    tableView.getSelectionModel().clearSelection();
                    originalTabs.add(selectedTab);
                }
                break;
            case ADD_IN_PROJECT:
                if (tableView != null) {
                    ObservableList<Project> list = tableView.getItems();
                    list.add(ProjectManagerSingleton.getInstance().createProject());
                }
                break;
            case REMOVE_FROM_PROJECT:
                if (tableView != null) {
                    ObservableList<Project> items = tableView.getItems();
                    ObservableList<Project> selectedItems = menuEvent.getSelectedProjects();
                    if (selectedItems == null) {
                        selectedItems = tableView.getSelectionModel().getSelectedItems();
                    }
                    for (Project project : selectedItems) {
                        items.remove(project);
                    }
                }
                break;
            case SELECT_ALL:
                if (tableView != null) {
                    tableView.getSelectionModel().selectAll();
                }
                break;
            case DEPLOY:
                if (tableView != null) {
                    List<TableRow> rowsToUpdate = new ArrayList<>(selectedRows);
                    for (TableRow row : rowsToUpdate) {
                        row.setId(StyleLibrary.PROCESSING_TABLE_ROW_CELL_STYLE);
                        row.updateSelected(false);
                        ((Project) row.getItem()).loading(true);
                    }
                    tableView.refresh();
                }
                break;
            case CANCEL_ACTION:
                if (tableView != null) {
                    List<TableRow> rowsToCancel = new ArrayList<>(selectedRows);
                    for (TableRow row : rowsToCancel) {
                        ((Project) row.getItem()).loading(false);
                    }
                    tableView.refresh();
                }
                break;
           default:
               //Do nothing
               break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventBusSingleton.getInstance().register(this);

        ObservableList<Tab> tabs = tabpane.getTabs();
        originalTabs = new LinkedList<>(tabs);

        Iterator<Tab> tabIterator = tabs.iterator();
        while (tabIterator.hasNext()) {
            Tab tab = tabIterator.next();
            TableView tableView = (TableView) tab.getContent();
            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            tableView.setRowFactory(new RowFactory<Project>(selectedRows));
            tabIterator.remove();
        }
    }
}
