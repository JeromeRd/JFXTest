package sample;

import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.util.Callback;

import java.util.Set;

public class RowFactory<T extends Project> implements Callback<TableView, TableRow<T>> {

    private Set<TableRow> selectedRows;

    public RowFactory(Set<TableRow> selectedRows) {
        this.selectedRows = selectedRows;
    }

    @Override
    public TableRow<T> call(TableView param) {
        final TableRow<T> row = new TableRow() {
            @Override
            public void updateSelected(boolean selected) {
                super.updateSelected(selected);
                if (selected) {
                    selectedRows.add(this);
                } else {
                    selectedRows.remove(this);
                }
            }
        };

        row.setId(StyleLibrary.TABLE_ROW_CELL_STYLE);

        /*row.hoverProperty().addListener((observable) -> {
            final Project project = row.getItem();

            if (project != null) {
                if (row.isHover()) {
                    row.setId(StyleLibrary.HOVERING_TABLE_ROW_CELL_STYLE);
                    if (project.getAction() != null) {
                        project.getAction().setVisible(true);
                    }
                } else {
                    row.setId(StyleLibrary.TABLE_ROW_CELL_STYLE);
                    if (project.getAction() != null && project.getAction().getId().equals(StyleLibrary.ACTION_PANE_STYLE)) {
                        project.getAction().setVisible(false);
                    }
                }
            }
        });*/
        row.setOnMouseClicked(event -> {
            if (! row.isEmpty() && event.getButton()== MouseButton.SECONDARY) {
                ContextMenuFactory.getContextMenu().show(row, event.getScreenX(), event.getScreenY());
            }
        });

        return row;
    }
}
