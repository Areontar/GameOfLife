package ex.sl.cgolife.board;

import java.util.Random;

import ex.sl.cgolife.boardDs.BoardDataStructure;
import ex.sl.cgolife.util.Neighborhood;
import ex.sl.cgolife.util.Neighborhood.Location;
import ex.sl.cgolife.util.Neighborhood.NeighborhoodBuilder;

public abstract class AbstractBoard implements Board{
	
	protected final BoardDataStructure boardMap;
	protected int sizeRow;
	protected int sizeColumn;
	
	public AbstractBoard(BoardDataStructure boardMap) {
		this.boardMap = boardMap;
	}

	@Override
	public int generateNewBoard(long seed, int sizeRow, int sizeColumn) {
		this.sizeRow = sizeRow;
		this.sizeColumn = sizeColumn;
		boardMap.initialize(sizeRow, sizeColumn);
		Random rand = new Random(seed);
		int generationCount = 0;
		rand.nextBoolean();
		for(int r=0; r < sizeRow; r++) {
			for(int c=0; c < sizeColumn; c++) {
				generationCount++;
				boardMap.updateCellState(r, c, rand.nextBoolean());
			}
		}
		return generationCount;
	}
	
	@Override
	public Neighborhood getNeighborhood(int x, int y) {
		NeighborhoodBuilder builder = new NeighborhoodBuilder(boardMap.getCellState(x, y));
		builder.addNeighbor(Location.NORTH, 	 getCellState(x+1, y));
		builder.addNeighbor(Location.NORTH_EAST, getCellState(x+1, y+1));
		builder.addNeighbor(Location.EAST, 		 getCellState(x, 	y+1));
		builder.addNeighbor(Location.SOUTH_EAST, getCellState(x-1, y+1));
		builder.addNeighbor(Location.SOUTH, 	 getCellState(x-1, y));
		builder.addNeighbor(Location.SOUTH_WEST, getCellState(x-1, y-1));
		builder.addNeighbor(Location.WEST, 		 getCellState(x, 	y-1));
		builder.addNeighbor(Location.NORTH_WEST, getCellState(x+1, y-1));
		return builder.build();
	}

	@Override
	public void updateCell(int x, int y, Boolean state) {
		boardMap.updateCellState(x, y, state);
	}

	@Override
	public abstract Boolean getCellState(int x, int y);

	@Override
	public abstract Board cloneToEmtpyBoard();

	@Override
	public int getRowSize() {
		return sizeColumn;
	}

	@Override
	public int getColumnSize() {
		return sizeColumn;
	}
	
	@Override
	public String toString() {
		return boardMap.toString();
	}

}
