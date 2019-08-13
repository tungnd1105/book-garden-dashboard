
package com.duan.model;

import java.sql.SQLException;
import java.util.Date;

import com.duan.dao.CategoryDAO;
import com.duan.dao.LocationDAO;
import com.duan.helper.DataHelper;
import com.duan.helper.DateHelper;
import com.duan.helper.SettingSave;


public class Book 
{
    private String id;
    private String title;
    private String categoryId ;
    private int  pageNum;
    private String author;
    private int amount;
    private String publisher;
    private int publicationYear ;
    private double price;
    private String image;
    private String locationId;
    private String description;
    private Date createdDate;

    public Book()
    {
    	
    }

    public Book(String id, String title, String categoryId, int pageNum, String author, int amount, String publisher,
			int publicationYear, double price, String image, String locationId, String description, Date createdDate) {
		super();
		this.id = id;
		this.title = title;
		this.categoryId = categoryId;
		this.pageNum = pageNum;
		this.author = author;
		this.amount = amount;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.price = price;
		this.image = image;
		this.locationId = locationId;
		this.description = description;
		this.createdDate = createdDate;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public String getSearchString()
    {
    	String category = "";
    	String location = "";
    	String createdDateStr = DateHelper.dateToString(createdDate, SettingSave.getSetting().getDateFormat());
    	try 
    	{
			category = CategoryDAO.findById(categoryId).getCategoryTitle();
			location = LocationDAO.findByID(locationId).getLocationName();
			
    	} 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
		}
    	return id + " " + title + " " + category + " " + pageNum + " " + author + " " + amount + " " + publisher + " " + publicationYear + " " + price + " " + location  + " " + description + " " + createdDateStr;
    }
    
}
