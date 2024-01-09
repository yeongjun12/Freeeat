package com.kh.freeeat.place.model.vo;

import lombok.Data;

@Data
public class PlacePhoto {
	
	private int placePhotoNo;
	private	int placeNo;
	private String originName;
	private String changeName;
	private String filePath;
	private String uploadDate;
	private String status;

}
