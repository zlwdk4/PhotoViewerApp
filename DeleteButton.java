
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DeleteButton extends JButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1178793516262101526L;

	
	DeleteButton(String name)
	{
		super(name);
		addActionListener(this);
		
		
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Delete Button Pressed");
		MainFrame.deleteImg();
	
		
	}

}
