import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;


public class NextButton extends JButton implements ActionListener{

	
	public NextButton(String name) {
		super(name);
		addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("next button pressed");
		MainFrame.nextImg();
		//MainFrame.incImgCounter();
	}

}
