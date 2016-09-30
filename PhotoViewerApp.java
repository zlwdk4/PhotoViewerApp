import javax.swing.JFrame;



public class PhotoViewerApp {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame("Photo Viewer");
		//frame.setSize(500, 300);
		frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        frame.setVisible(true);

        System.out.println("Program begins...");

	}

}
