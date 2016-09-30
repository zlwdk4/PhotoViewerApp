import java.io.Serializable;

import javax.swing.ImageIcon;

public class AlbumImg implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4447807655290900124L;
	private String desc; 
	private String date; 
	private ImageIcon img;
	
	AlbumImg(ImageIcon icon)
	{
		setImg(icon);
		setDesc("");
		setDate("");
	}
	
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ImageIcon getImg() {
		return img;
	}
	public void setImg(ImageIcon img) {
		this.img = img;
	} 

}
