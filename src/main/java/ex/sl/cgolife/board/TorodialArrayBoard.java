package ex.sl.cgolife.board;

import ex.sl.cgolife.boardDs.BoardDataStructure;

public class TorodialArrayBoard extends AbstractBoard{

	public TorodialArrayBoard(BoardDataStructure boardMap) {
		super(boardMap);
	}
	
	private TorodialArrayBoard(BoardDataStructure boardMap, int rowSize, int columnSize) {
		super(boardMap);
		this.sizeRow = rowSize;
		this.sizeColumn = columnSize;
	}
	
	@Override
	public Boolean getCellState(int x, int y) {
		int adjustedX = adjustCoordinate3D(x, sizeRow);
		int adjustedY = adjustCoordinate3D(y, sizeColumn);
		
		return boardMap.getCellState(adjustedX, adjustedY);
	}
	//Coordinate
	private int adjustCoordinate3D(int coordinate, int adjustment) {
		int adjusted = 0;
		if(coordinate >= adjustment){
			adjusted = coordinate - adjustment;
		} 
		else if(coordinate < 0) {
			adjusted = coordinate + adjustment;
		}
		else {
			adjusted = coordinate;
		}
		return adjusted;
	}

	public Board cloneToEmtpyBoard() {
		return new TorodialArrayBoard(boardMap.getEmptyClone(), getRowSize(), getColumnSize());
	}
}
