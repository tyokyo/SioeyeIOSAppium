package ckt.inspector;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableCellTextAreaRenderer extends JTextArea implements TableCellRenderer { 
    public TableCellTextAreaRenderer() { 
        setLineWrap(true); 
        setWrapStyleWord(true); 
    }
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) { 
        // 计算当下行的最佳高度 
        int maxPreferredHeight = 0; 
        for (int i = 0; i < table.getColumnCount(); i++) { 
            setText("" + table.getValueAt(row, i)); 
            setSize(table.getColumnModel().getColumn(column).getWidth(), 0); 
            maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height); 
        }
        if (table.getRowHeight(row) != maxPreferredHeight)  // 少了这行则处理器瞎忙 
            table.setRowHeight(row, maxPreferredHeight);

        setText(value == null ? "" : value.toString()); 
        return this; 
    }
}