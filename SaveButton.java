
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SaveButton extends JButton implements ActionListener {

	SaveButton(String name)
	{
		super(name);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Save Button Presed");
		MainFrame.savaData();
	}

}
