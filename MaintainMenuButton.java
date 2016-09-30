import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class MaintainMenuButton extends JMenuItem implements ActionListener {

	
	MaintainMenuButton(String title){
		super(title);
		addActionListener(this);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainFrame.enableMaintainButtons();
	}

	
	
}
