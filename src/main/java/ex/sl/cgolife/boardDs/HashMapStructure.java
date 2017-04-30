package ex.sl.cgolife.boardDs;

import java.util.HashMap;
import java.util.Map;

public class HashMapStructure implements BoardDataStructure{
	
	private HashMap<Integer /*row*/, HashMap<Integer/*Column*/, Boolean/*state true=alive, false=dead*/>> BOARD_MAP;

	private int sizeRow;
	private int sizeColumn;
	
	@Override
	public void initialize(int rowCount, int columnCount) {
		this.sizeRow = rowCount;
		this.sizeColumn = columnCount;
		BOARD_MAP = new HashMap<>(rowCount);
		for(int r = 0; r < rowCount; r++) {
			BOARD_MAP.put(r, new HashMap<>(columnCount));
		}
	}

	@Override
	public Boolean getCellStateAccountFornull(int x, int y) {
		HashMap<Integer, Boolean> column = BOARD_MAP.get(x);
		if(column != null) {
			return column.get(y);
		}
		return null;		
	}

	@Override
	public Boolean getCellState(int x, int y) {
		return BOARD_MAP.get(x).get(y);		
	}

	@Override
	public void updateCellState(int x, int y, Boolean state) {
		BOARD_MAP.get(x).put(y, state);
	}
	
	protected HashMap<Integer, HashMap<Integer, Boolean>> getBoardMap() {
		return BOARD_MAP;
	}

	@Override
	public BoardDataStructure getEmptyClone() {
		HashMapStructure hms = new HashMapStructure();
		hms.initialize(sizeRow, sizeColumn);
		return hms;
	}

	@Override
	public boolean equalsDataStructure(Object o) {
		if(o instanceof HashMapStructure) {
			HashMapStructure other = (HashMapStructure)o;
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
