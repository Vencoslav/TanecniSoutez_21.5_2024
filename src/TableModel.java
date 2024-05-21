import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {
    List<SoutezniPar> seznam;

    public TableModel(List<SoutezniPar> seznam) {
        this.seznam = seznam;
    }

    @Override
    public int getRowCount() {
        return seznam.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SoutezniPar par = seznam.get(rowIndex);
        switch (columnIndex){
            case  0:
                return par.getStartovniCislo();
            case 1:
                return par.getDatum();
            case 2:
                return par.getJmena();
            case 3:
                return par.getDivokaKarta();
            default:
                return null;
        }
    }

    public String getColumnName(int column){
        switch (column){
            case  0:
                return "Startovní číslo";
            case 1:
                return "Datum";
            case 2:
                return "Jmena";
            case 3:
                return "Je divoká karta";
            default:
                return super.getColumnName(column);
        }
    }
}
