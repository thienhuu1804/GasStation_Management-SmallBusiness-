package gasstation_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DataTable extends JPanel {

    JTable tb;
    DefaultTableModel tbModel;
    JScrollPane pane;

    public DataTable() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(950, 300));

        tb = new JTable();
        tbModel = new DefaultTableModel();
        pane = new JScrollPane(tb);

        tb.setFillsViewportHeight(true);
        tb.setFont(new Font("Segoe UI", 0, 16));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tb.setRowHeight(40);

        // color
        int bgColor = 235;
        int color = 0;
        tb.getTableHeader().setBackground(new Color(bgColor, bgColor, bgColor));
        tb.getTableHeader().setForeground(new Color(color, color, color));
        tb.setBackground(new Color(bgColor, bgColor, bgColor));
        tb.setForeground(new Color(color, color, color));

        add(pane, BorderLayout.CENTER);
    }

    public void setHeaders(String[] headers) {
        tbModel.setColumnIdentifiers(headers);
        tb.setModel(tbModel);
    }

    public void addRow(String[] data) {
        tbModel.addRow(data);
    }

    public void addRow(Vector data) {
        tbModel.addRow(data);
    }

    public JTable getTable() {
        return tb;
    }

    public DefaultTableModel getModel() {
        return tbModel;
    }

    public void clear() {
        tbModel.setRowCount(0);
    }

    // https://www.codejava.net/java-se/swing/setting-column-width-and-row-height-for-jtable
    public void setJTableColumnsWidth(int tablePreferredWidth, double[] percentages) {

        double total = 0;
        for (int i = 0; i < tb.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < tb.getColumnModel().getColumnCount(); i++) {
            TableColumn column = tb.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
        }
    }

    public void setHeaders(DBConnect c, String tbName) {
        ArrayList<String> headers = new ArrayList();
        headers = c.getHeaders(tbName);
        tbModel.setColumnIdentifiers(headers.toArray()); 
        tb.setModel(tbModel); 
    }
}
