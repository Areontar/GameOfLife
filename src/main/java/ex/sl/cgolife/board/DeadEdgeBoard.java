package ex.sl.cgolife.board;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ex.sl.cgolife.util.Neighborhood;
import ex.sl.cgolife.util.Neighborhood.Location;
import ex.sl.cgolife.util.Neighborhood.NeighborhoodBuilder;

/**
 * a Game of life board with Dead Edge
 * @author slemay
 *
 */
public class DeadEdgeBoard implements Board{
	
	private final HashMap<Integer /*row*/, HashMap<Integer/*Column*/, Boolean/*state true=alive, false=dead*/>> BOARD_MAP = new HashMap<>();
	private int sizeRow;
	private int sizeColumn;
	
	public DeadEdgeBoard() {}
	
	private DeadEdgeBoard(int rowSize, int columnSize) {
		this.sizeRow = rowSize;
		this.sizeColumn = columnSize;
	}

	//for this implementation the edge are dead, so any out of bound cell are considered dead
	@Override
	public Neighborhood getNeighborhood(int x, int y) {
		NeighborhoodBuilder builder = new NeighborhoodBuilder(BOARD_MAP.get(x).get(y));
		builder.addNeighbor(Location.NORTH, 	 getCellAccountForNull(x+1, y));
		builder.addNeighbor(Location.NORTH_EAST, getCellAccountForNull(x+1, y+1));
		builder.addNeighbor(Location.EAST, 		 getCellAccountForNull(x, 	y+1));
		builder.addNeighbor(Location.SOUTH_EAST, getCellAccountForNull(x-1, y+1));
		builder.addNeighbor(Location.SOUTH, 	 getCellAccountForNull(x-1, y));
		builder.addNeighbor(Location.SOUTH_WEST, getCellAccountForNull(x-1, y-1));
		builder.addNeighbor(Location.WEST, 		 getCellAccountForNull(x, 	y-1));
		builder.addNeighbor(Location.NORTH_WEST, getCellAccountForNull(x+1, y-1));
		return builder.build();
	}
	
	@Override
	public Boolean getCellState(int x, int y) {
		return getCellAccountForNull(x, y);
	}
	
	private Boolean getCellAccountForNull(int x, int y) {
		HashMap<Integer, Boolean> column = BOARD_MAP.get(x);
		if(column != null) {
			return column.get(y);
		}
		return null;
	}

	@Override
	public int generateNewBoard(long seed, int sizeRow, int sizeColumn) {
		this.sizeRow = sizeRow;
		this.sizeColumn = sizeColumn;
		Random rand = new Random(seed);
		int generationCount = 0;
		rand.nextBoolean();
		for(int r=0; r < sizeRow; r++) {
			HashMap<Integer, Boolean> columnMap = new HashMap<>();
			for(int c=0; c < sizeColumn; c++) {
				generationCount++;
				columnMap.put(c, rand.nextBoolean());
			}
			BOARD_MAP.put(r, columnMap);
		}
		return generationCount;
	}

	@Override
	public void updateCell(int x, int y, boolean state) {
		HashMap<Integer, Boolean> column = BOARD_MAP.get(x);
		column.put(y, state);
	}
	
	protected HashMap<Integer, HashMap<Integer, Boolean>> getBoardMap() {
		return BOARD_MAP;
	}
	
	public Board cloneToEmtpyBoard() {
		DeadEdgeBoard board = new DeadEdgeBoard(getRowSize(), getColumnSize());
		HashMap<Integer, HashMap<Integer, Boolean>> newMap = board.getBoardMap();
		for(int r=0; r < sizeRow; r++) {
			HashMap<Integer, Boolean> columnMap = new HashMap<>();
			for(int c=0; c < sizeColumn; c++) {
				columnMap.put(c, false);
			}
			newMap.put(r, columnMap);
		}
		return board;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DeadEdgeBoard) {
			DeadEdgeBoard other = (DeadEdgeBoard)obj;
			if(BOARD_MAP.size() == other.getBoardMap().size()) {
				return equalsMap(BOARD_MAP, other.getBoardMap());
			}
		}
		return false;
	}
	
	private <K, V> boolean equalsMap(Map<K,V> map1, Map<K, V> map2) {
		for(K key : map1.keySet()) {
			if(!map1.get(key).equals(map2.get(key))) {
				return false;
			}
		}
		return true;
	}

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
		StringBuilder sb = new StringBuilder();
		for(int r=sizeRow-1; r >= 0; r--) {
			for(int c=0; c< sizeColumn; c++) {
				sb.append(BOARD_MAP.get(r).get(c) ? "\u25CF" : "\u25cb").append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
