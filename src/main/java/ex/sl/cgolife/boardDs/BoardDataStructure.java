package ex.sl.cgolife.boardDs;

public interface BoardDataStructure {

	public void initialize(int rowCount, int columnCount);
	
	public Boolean getCellStateAccountFornull(int x, int y);
	
	public Boolean getCellState(int x, int y);
	
	public void updateCellState(int x, int y, Boolean state);
	
	public BoardDataStructure getEmptyClone();
	
	public boolean equalsDataStructure(Object o);
	
	public String toString();
	
	public int getRowSize();

	public int getColumnSize();
}
