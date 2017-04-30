package ex.sl.cgolife.boardDs;

public class PrimitiveMatrixDataStructure implements BoardDataStructure {

	private Boolean boardMap[][];
	private int sizeRow;
	private int sizeColumn;

	
	@Override
	public void initialize(int rowCount, int columnCount) {
		this.sizeRow = rowCount;
		this.sizeColumn = columnCount;
		boardMap = new Boolean[rowCount][columnCount];
	}

	@Override
	public Boolean getCellStateAccountFornull(int x, int y) {
		if(x >= getRowSize() || x < 0 || y >= getColumnSize() || y < 0) {
			return null;
		}
		return boardMap[x][y];
	}

	@Override
	public Boolean getCellState(int x, int y) {
		return boardMap[x][y];
	}

	@Override
	public void updateCellState(int x, int y, Boolean state) {
		boardMap[x][y] = state;
	}

	@Override
	public BoardDataStructure getEmptyClone() {
		PrimitiveMatrixDataStructure m = new PrimitiveMatrixDataStructure();
		m.initialize(sizeRow, sizeColumn);
		return m;
	}

	@Override
	public boolean equalsDataStructure(Object o) {
		if(o instanceof PrimitiveMatrixDataStructure) {
			PrimitiveMatrixDataStructure other = (PrimitiveMatrixDataStructure)o;
			return equalsMap(boardMap, other.getBoardMap());
		}
		return false;
	}
	
	protected Boolean[][] getBoardMap() {
		return boardMap;
	}
	
	private <O> boolean equalsMap(O[][] map1, O[][] map2) {
		if(map1.length !=  map2.length) {
			return false;
		}
		for(int r=0; r < sizeRow; r++) {
			if(map1[r].length != map2[r].length) {
				return false;
			}
			for(int c=0; c < sizeColumn; c++) {
				map1[r][c].equals(map2[r][c]);
			}
		}
		return true;
	}

	@Override
	public int getRowSize() {
		return sizeRow;
	}

	@Override
	public int getColumnSize() {
		return sizeColumn;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int r=sizeRow-1; r >= 0; r--) {
			for(int c=0; c< sizeColumn; c++) {
				sb.append(boardMap[r][c] ? "\u25CF" : "\u25cb").append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
