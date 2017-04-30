package ex.sl.cgolife.board;

import ex.sl.cgolife.util.Neighborhood;

public interface Board {
	
	
	/**
	 * generate a random new board based on the seed
	 * @param seed
	 * @param sizeRow
	 * @param sizeColumn
	 * @return the amount of cell that where created
	 */
	public int generateNewBoard(long seed, int sizeRow, int sizeColumn);
	
	/**
	 * get the neighborhood of the coordinate
	 * @param x
	 * @param y
	 * @return
	 */
	public Neighborhood getNeighborhood(int x, int y);
	
	/**
	 * update the state of the cell
	 * @param x
	 * @param y
	 * @param state true is alive, false if dead
	 */
	public void updateCell(int x, int y, Boolean state);
	
	/**
	 * get the state of the cell
	 * @param x
	 * @param y
	 * @return
	 */
	public Boolean getCellState(int x, int y);
	
	/**
	 * clone the board with empty maps
	 * @return
	 */
	public Board cloneToEmtpyBoard();
	
	public int getRowSize();
	
	public int getColumnSize();
}
