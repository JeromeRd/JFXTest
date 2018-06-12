package sample;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.layout.Pane;
import javafx.util.Callback;


public class FormattedTableCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {

    public FormattedTableCellFactory() {
    }

    @Override
    public TableCell<S, T> call(TableColumn<S, T> p) {
        TableCell<S, T> cell = new TableCell<S, T>();
        TableRow tableRow = cell.getTableRow();
        if (tableRow != null && tableRow.getItem() != null) {
            Pane pane = ((Project) tableRow.getItem()).getAction();
            pane.setVisible(true);
            cell.setGraphic(pane);
        }
        return cell;
    }
}