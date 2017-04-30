package ex.sl.cgolife.board;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ex.sl.cgolife.board.Board;
import ex.sl.cgolife.board.DeadEdgeBoard;
import ex.sl.cgolife.util.Neighborhood;

public class DeadEdgeBoardTest {
	
	private Board board;
	
	@Before
	public void setup() {
		board = new DeadEdgeBoard();
	}
	
	@After
	public void teardown() {
		board = null;
	}

	@Test
	public void testGetNeighborhood() {
		board.generateNewBoard(100L, 15, 15);
		Neighborhood n = board.getNeighborhood(7, 7);
		assertNotNull(n);
	}

	@Test
	public void testGenerateNewBoard() {
		int cellamount = board.generateNewBoard(100L, 15, 15);
		assertTrue(cellamount == 15*15);
	}

	@Test
	public void testUpdateCell() {
		board.generateNewBoard(100L, 15, 15);
		Boolean state = board.getCellState(7, 7);
		board.updateCell(7, 7, !state);
		Boolean newState = board.getCellState(7, 7);
		assertFalse(state == newState);
	}

	@Test
	public void testCloneBoard() {
		board.generateNewBoard(100L, 15, 15);
		Board clonedBoard = board.cloneToEmtpyBoard();
		assertTrue(board != clonedBoard);
		assertFalse(board.equals(clonedBoard));
	}
	
	@Test
	public void testSizeMeasure() {
		board.generateNewBoard(100L, 15, 15);
		assertTrue(board.getRowSize() == 15);
		assertTrue(board.getColumnSize() == 15);
	}

}
