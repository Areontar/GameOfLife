package ex.sl.cgolife;

import java.awt.Font;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ConsoleWriter {
  
  private final  JTextArea console = new JTextArea("asdhkahdjahjkdhakjsdh");
  private JFrame f = new JFrame("Text Area Examples");
  

  //Should be using swing worker
  public ConsoleWriter()
  {      
	    JPanel upperPanel = new JPanel();
	    f.getContentPane().add(upperPanel, "North");
	    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    f.setSize(500, 500);
	    Font font = new Font(Font.MONOSPACED, 20, 20);

	    upperPanel.add(console);
	    console.setFont(font);
	    f.pack();
	    f.setVisible(true);
  }
  
  public void clearText() {
	  SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
			  console.setText(null);
		}
	  });
  }
  
  public void updateText(String s) {
	  SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
			  console.append(s);
		}
	  });
  }  
}
