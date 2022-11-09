package tw.brad.myjava;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyFoodTable extends JTable {
	private MyTableModel tableModel;
	private FoodDB foodDB;
	
	public MyFoodTable() throws Exception {
		
		foodDB = new FoodDB();
		foodDB.queryData("SELECT * FROM food");
		
		tableModel = new MyTableModel();
		setModel(tableModel);
		tableModel.setColumnIdentifiers(foodDB.getHeader());
	}
	
	public void delRow() {
		tableModel.removeRow(getSelectedRow());
		repaint();
	}
	
	public void addRow() {
		
	}
	
	private class MyTableModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return foodDB.getRows();
		}

		@Override
		public int getColumnCount() {
			return foodDB.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return foodDB.getData(row+1, column+1);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			foodDB.setData(row+1, column+1, (String)aValue);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column > 0;
		}

		@Override
		public void removeRow(int row) {
			foodDB.delData(row+1);
		}
		
		@Override
		public void addRow(Object[] rowData) {
			
		}
		
	}
}
