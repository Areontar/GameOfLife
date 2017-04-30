package ex.sl.cgolife.board;

import ex.sl.cgolife.boardDs.BoardDataStructure;

/**
 * a Game of life board with Dead Edge
 * @author slemay
 *
 */
public class DeadEdgeBoard extends AbstractBoard{
	
	public DeadEdgeBoard(BoardDataStructure boardMap) {
		super(boardMap);
	}
	
	private DeadEdgeBoard(BoardDataStructure boardMap, int rowSize, int columnSize) {
		super(boardMap);
		this.sizeRow = rowSize;
		this.sizeColumn = columnSize;
	}
	
	@Override
	public Boolean getCellState(int x, int y) {
		return boardMap.getCellStateAccountFornull(x, y);
	}
	
	public Board cloneToEmtpyBoard() {
		return new DeadEdgeBoard(boardMap.getEmptyClone(), getRowSize(), getColumnSize());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DeadEdgeBoard) {
			DeadEdgeBoard other = (DeadEdgeBoard)obj;
			return boardMap.equals(other.boardMap);
		}
		return false;
	}
}
