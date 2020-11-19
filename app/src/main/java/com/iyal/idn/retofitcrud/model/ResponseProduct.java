package com.iyal.idn.retofitcrud.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseProduct{

	@SerializedName("person")
	private List<ResponseProduct> person;

	@SerializedName("error")
	private boolean error;

	@SerializedName("status")
	private int status;

	@SerializedName("image")
	private String image;

	@SerializedName("price")
	private String price;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("desc")
	private String desc;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	public String getDesc(){
		return desc;
	}

	public void setPerson(List<ResponseProduct> person){
		this.person = person;
	}

	public List<ResponseProduct> getPerson(){
		return person;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}