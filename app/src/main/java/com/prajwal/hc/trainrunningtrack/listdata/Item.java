/**
 *
 */package com.prajwal.hc.trainrunningtrack.listdata;

import java.util.Random;

/**
 * A POJO that contains some properties to show in the list
 *
 * @author marvinlabs
 */
public class Item implements Comparable<Item> {

	private int id;
	private String caption;//BASE
	public String subject="";
	private String url="";
	private String discription="";//THUMBS
	public String size="";
	public String degree="";
	public   String sem ="";
	public	byte[] _image;
	public Item( ) {
		super();

	}
	public Item(int id) {
		super();
		this.id = id;
	}
	public Item(int id, String caption,String url) {
		super();
		this.id = id;
		this.caption = caption;
		this.url=url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;

		try {
			Random r = new Random();
			int i1 = r.nextInt(300);
			String ds=String.valueOf( i1+80)+"kb";
		this.size=ds;
		}catch (Exception e){}
	}



	public String getSUBJECT() {
		return this.subject;
	}

	public void setSUBJECT(String BASE) {
		this.subject = BASE;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String Url) {
		this.url = Url;
	}

	public void setSize(String size) {
		this.size = size;
	}
	public String getDiscription() {
		return this.discription;
	}

	public void setdegree(String deg) {
		this.degree = deg;
	}
	public String getdegree() {
		return this.degree;
	}

	public void setsem(String se) {
		this.sem = se;
	}
	public String getsem() {
		return this.sem;
	}

	public void setDiscription(String Discription) {
		this.discription = Discription;
	}

	// getting phone number
	public byte[] getImage() {
		return this._image;
	}

	// setting phone number
	public void setImage(byte[] image) {
		this._image = image;
	}
	/**
	 * Comparable interface implementation
	 *
	 * @see Comparable#compareTo(Object)
	 */
	public int compareTo(Item other) {
		return (int) (id - other.getId());
	}
}
