import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;


public class AddPhotoButton extends JButton implements ActionListener{

	public AddPhotoButton(String title) {
		super(title);
		addActionListener(this);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Add Photo Button Pressed");
		
		JFileChooser fc =  new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("."));
		fc.setDialogTitle("Pick image to add!");
		
		
		if( fc.showOpenDialog(AddPhotoButton.this) == JFileChooser.APPROVE_OPTION)
		{
			System.out.println(fc.getSelectedFile().getAbsolutePath());
			MainFrame.addNewPhoto(fc.getSelectedFile());
		}
		
		
		
		
	}

}
