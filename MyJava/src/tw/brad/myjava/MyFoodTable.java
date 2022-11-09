package tw.brad.myjava;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyFoodTable extends JTable {
	private MyTableModel tableModel;
	
	public MyFoodTable() {
		
		tableModel = new MyTableModel();
		setModel(tableModel);
		
	}
	
	private class MyTableModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return 7;
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return "Brad " +row + "x" + column;
		}
		
	}

}
