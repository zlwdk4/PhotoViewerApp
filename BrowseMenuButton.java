import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class BrowseMenuButton extends JMenuItem implements ActionListener{

	BrowseMenuButton(String title){
		super(title);
		addActionListener(this);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("browse mode active");
		MainFrame.disableMaintainButtons();
	}

}
