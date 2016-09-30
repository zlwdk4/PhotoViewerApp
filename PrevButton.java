
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PrevButton extends JButton implements ActionListener {

	PrevButton(String name)
	{
		super(name);
		addActionListener(this);
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Prev Button Pressed");
		MainFrame.prevImage();
	}

}
