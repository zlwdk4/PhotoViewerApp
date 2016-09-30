import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.activation.MimetypesFileTypeMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import org.omg.CORBA.INTERNAL;




public class MainFrame extends JFrame{
	
	
	private static int imgCounter = 0;
	
	private static int imgCount = 0; 
	
	private static JLabel imgCountLabel = new JLabel();
	
	private static JTextArea imgTracker = new JTextArea();
	
	private static PrevButton prevBtn = new PrevButton("<Prev");
	
	private static NextButton nextBtn = new NextButton("Next>");
	
	private static ArrayList<AlbumImg> imgList = new ArrayList<AlbumImg>();
	
	private static ImageIcon mainIcon;
	
	private GridBagConstraints gc;
	
	private static JLabel imgLabel = new JLabel();	
	
	private static JTextArea descText = new JTextArea();
	
	private static JTextArea dateText = new JTextArea();
	
	private static SaveButton saveBtn = new SaveButton("Save");
	
	private static AddPhotoButton addPhotoBtn = new AddPhotoButton("Add Photo");
	
	private static DeleteButton delBtn = new DeleteButton("Delete");
	
	
	
	MainFrame(String title)
	{
		super(title);
		Container contentPane = getContentPane();
		
		//setting the layout to use a gridbag
		setLayout(new GridBagLayout());

		////////////////////////////////////////////////////////////////
		//Adding the menu
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_A);
		JMenuItem menuFileExit = new JMenuItem("Exit");
		menuFile.add(menuFileExit);
		menuBar.add(menuFile);
		JMenu menuView = new JMenu("View");
		BrowseMenuButton menuViewBrowse = new BrowseMenuButton("Browse");
		MaintainMenuButton menuViewMaintain = new MaintainMenuButton("Maintain");
		menuView.add(menuViewBrowse);
		menuView.add(menuViewMaintain);
		menuBar.add(menuView);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		//gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.HORIZONTAL;
		//gc.gridwidth = GridBagConstraints.REMAINDER;
		contentPane.add(menuBar, gc);
		
		
		////////////////////////////////////////////////////////////////////

		
		ImageIcon theImg = new ImageIcon("C:\\Users\\ZWolf\\Documents\\EclipseWorkspace\\PhotoViewer\\src\\filler2.jpg");
		//Resizes the Image
		Image rawImg = theImg.getImage();
		Image img = rawImg.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH);
		theImg = new ImageIcon(img);
		
		
		imgLabel.setIcon(theImg);
		
		
		//adds the Jlabel for the image
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 1; 
		gc.gridwidth = 6;
		gc.fill = GridBagConstraints.REMAINDER;
		contentPane.add(imgLabel, gc);
		
		
		/////////////////////////////////////////////////////
		
		//Button Size Variables
		int btnHeight = 150;
		int btnWidth = 100; 
		
		//Adding Next Button  
		
		nextBtn.setSize(btnWidth, btnHeight);
		gc = new GridBagConstraints(); 
		gc.gridx = 2;
		gc.gridy = 4; 
		contentPane.add(nextBtn, gc);
		
		
		

		//Adding Description label
		JLabel descTitle = new JLabel("Description:");
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 2;
		
		contentPane.add(descTitle, gc);
		
		
		//Adding Description Text
		//JTextArea txtArea = new JTextArea();
		descText.setText("Lorem Ipsum");
		descText.setRows(5);
		
		
		
		
		gc = new GridBagConstraints();
		gc.gridx = 1; 
		gc.gridy = 2;
		gc.fill = gc.BOTH;
		gc.gridwidth = 5;
		
		contentPane.add(descText, gc);
		
		
		
		
		//Adding Date Label
		
		JLabel dateLabel = new JLabel("Date:");
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 3; 
		
		contentPane.add(dateLabel, gc);
		
		
		//Adding Date Text
		//JTextArea dateText = new JTextArea();
		dateText.setText("99/99/9999");
		
		gc = new GridBagConstraints();
		gc.gridx = 1; 
		gc.gridy = 3; 
		gc.gridwidth = 2; 
		gc.fill = gc.HORIZONTAL;
		
		contentPane.add(dateText, gc);
		
	
		
		
		
		//Adding Delete Button
		
		delBtn.setSize(btnWidth, btnHeight);
		
		gc = new GridBagConstraints();
		gc.gridx = 3;
		gc.gridy = 3;
		
		
		contentPane.add(delBtn, gc);
		
		
	
		//Adding Save Button
		
		saveBtn.setSize(btnWidth, btnHeight );
		
		gc = new GridBagConstraints();
		gc.gridx = 4; 
		gc.gridy = 3; 
		
		
		contentPane.add(saveBtn, gc);
		
		
		//Adding Add Photo Button
		
		addPhotoBtn.setSize(btnWidth, btnHeight);
		
		gc = new GridBagConstraints();
		gc.gridx = 5;
		gc.gridy = 3;
		
		
		contentPane.add(addPhotoBtn, gc);
		
		
		
		
		//Adding Image tracker Vals
		//TODO needs functionality
		
		
		
		imgTracker.setText(Integer.toString(imgCounter));
		String countTitle = " of " + Integer.toString(imgCounter);
		//JLabel imgCount = new JLabel(countTitle);
		imgCountLabel.setText("of " + Integer.toString(imgCount));
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, imgTracker, imgCountLabel);
		
		gc = new GridBagConstraints(); 
		gc.gridx = 0; 
		gc.gridy = 4; 
		
		contentPane.add(split, gc);
		
		
		
		
		//Adding Prev Button
		
		prevBtn.setSize(btnWidth, btnHeight);
		prevBtn.setForeground(Color.gray);
		
		gc = new GridBagConstraints(); 
		gc.gridx = 1;
		gc.gridy = 4;
		
		
		contentPane.add(prevBtn, gc);
		
		
		
		//Adding Next Button  
		
		nextBtn.setSize(btnWidth, btnHeight);
		
		
		gc = new GridBagConstraints(); 
		gc.gridx = 2;
		gc.gridy = 4; 
		
		
		contentPane.add(nextBtn, gc);
		
		readData();
	}



	public static void switchImg(int index) {
		// TODO Auto-generated method stub
		/*
		ImageIcon theImg = new ImageIcon(path);
		//Resizes the Image
		Image rawImg = theImg.getImage();
		Image img = rawImg.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH);
		theImg = new ImageIcon(img);
		*/ 
		AlbumImg img = imgList.get(index - 1); 
		imgLabel.setIcon(img.getImg());
		descText.setText(img.getDesc());
		dateText.setText(img.getDate());
	}
	



	public static void addNewPhoto(File selectedFile) {
		System.out.println("current path: ");
		System.out.println(selectedFile.getAbsolutePath());
		
		
		
		
		incImgCount();
		imgCounter = imgCount - 1;
		incImgCounter();
		
		ImageIcon newImgIcon = new ImageIcon(selectedFile.getAbsolutePath());
		//resizing
		Image rawImg = newImgIcon.getImage();
		Image img = rawImg.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH);
		newImgIcon = new ImageIcon(img);
		
		imgList.add(new AlbumImg(newImgIcon));
		disableNextBtn();
		if(imgCounter > 1){
			enablePrevBtn();
		}
		switchImg(imgCount);
		
		
		//switchImg(selectedFile.getAbsolutePath());
		
	}
	
	private static void loadNewPhoto(AlbumImg img)
	{
		incImgCount();
		imgCounter = imgCount - 1;
		incImgCounter();
		disableNextBtn();
		if(imgCounter > 1){
			enablePrevBtn();
		}
		switchImg(imgCount);
	}



	private static void incImgCounter() {
		imgCounter++; 
		imgTracker.setText(Integer.toString(imgCounter));
		
		
	}



	private static void incImgCount() {
		imgCount++;
		imgCountLabel.setText("of " + Integer.toString(imgCount));
		
		
	}
	
	private static void decImgCount() {
		if(imgCount > 0){
			imgCount--;
			imgCountLabel.setText("of " + Integer.toString(imgCount));
		}
	}



	public static void decImgCounter() {
		if(imgCounter > 0)
		{
			imgCounter--;
			imgTracker.setText(Integer.toString(imgCounter));
			
		}
		
	}

	private static void enablePrevBtn() {
		prevBtn.setForeground(Color.BLACK);
	}

	private static void disableNextBtn() {
		nextBtn.setForeground(Color.GRAY);
		
	}
	
	private static void disablePrevBtn() 
	{
		prevBtn.setForeground(Color.GRAY);
	}
	
	private static void enableNextBtn(){
		nextBtn.setForeground(Color.BLACK);
	}

	public static void nextImg() {
		if(imgCounter < imgCount){
			System.out.println("going to next image");
			
			if(imgCounter == 1)
			{
				enablePrevBtn();
			}
			
			incImgCounter();
			
			
			if(imgCounter == imgCount)
			{
				disableNextBtn();
			}
			
			
			switchImg(imgCounter);
			
		}
		
	}



	public static void prevImage() {
		// TODO Auto-generated method stub
		if(imgCounter > 1){
			if(imgCounter == imgCount){
				enableNextBtn();
			}
			System.out.println("going to prev image");
			decImgCounter();
			
			if(imgCounter == 1)
			{
				disablePrevBtn();
			}
			switchImg(imgCounter);
		}
		
	}
	
	public static void savaData(){
		try{
			imgList.get(imgCounter - 1).setDesc(descText.getText());
			imgList.get(imgCounter - 1).setDate(dateText.getText());
			
			FileOutputStream fout = new FileOutputStream("C:\\Users\\ZWolf\\Documents\\EclipseWorkspace\\PhotoViewer\\src\\Saved.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(imgList);
			oos.close();
			System.out.println("saved");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private static void readData(){
		try{
			System.out.println("reading in data...");
			InputStream file = new FileInputStream("C:\\Users\\ZWolf\\Documents\\EclipseWorkspace\\PhotoViewer\\src\\Saved.ser");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			
			imgList = (ArrayList<AlbumImg>)input.readObject();
			System.out.println("read.");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println(imgList.size());
		//loadNewPhoto(imgList.get(1));
		
		if(imgList.size() != 0){
			for(int i = 0; i < imgList.size(); i++)
			{
				loadNewPhoto(imgList.get(i));
			}
		}
		
		
	}



	public static void disableMaintainButtons() {
		// TODO Auto-generated method stub
		saveBtn.setVisible(false);
		delBtn.setVisible(false);
		addPhotoBtn.setVisible(false);
		descText.setEditable(false);
		dateText.setEditable(false);
		
	}
	
	public static void enableMaintainButtons(){
		saveBtn.setVisible(true);
		delBtn.setVisible(true);
		addPhotoBtn.setVisible(true);
		descText.setEditable(true);
		dateText.setEditable(true);
	}



	public static void deleteImg() {
		// TODO Auto-generated method stub
		
		
		if(imgCount > 0)
		{
			imgList.remove(imgCounter - 1);
			decImgCount();
			if(imgCounter > imgCount){
				decImgCounter();
			}
			
			System.out.println("new imgCounter: " + Integer.toString(imgCounter));
			System.out.println("new imgCount: " + Integer.toString(imgCount));
			if(imgList.size() >= 1){
				switchImg(imgCounter); 
			}
			else{
				ImageIcon filler = new ImageIcon("C:\\Users\\ZWolf\\Documents\\EclipseWorkspace\\PhotoViewer\\src\\filler2.jpg");
				Image rawImg = filler.getImage();
				Image img = rawImg.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH);
				filler = new ImageIcon(img);
				imgLabel.setIcon(filler);
				descText.setText("Description text area");
				dateText.setText("00/00/0000");
			}
			savaData();
			
		}
	}
	
	
}
