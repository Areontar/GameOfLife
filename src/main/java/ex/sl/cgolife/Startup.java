package ex.sl.cgolife;

import ex.sl.cgolife.board.Board;
import ex.sl.cgolife.board.DeadEdgeBoard;
import ex.sl.cgolife.generator.Generator;
import ex.sl.cgolife.rule.B3S23;

public class Startup {
	
	public static void main(String[] args) throws InterruptedException {	
		Board origin = new DeadEdgeBoard();
		B3S23 rule = new B3S23();
		Generator g = new Generator(rule);
		
		origin.generateNewBoard(2L, 30, 30);
		ConsoleWriter writer = new ConsoleWriter();

		while(true) {
			writer.clearText();
			writer.updateText(origin.toString());
			origin = g.generate(origin);	
			Thread.currentThread().sleep(500);
		}
	}
}
