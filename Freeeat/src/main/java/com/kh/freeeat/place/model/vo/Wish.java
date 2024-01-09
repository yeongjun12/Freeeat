package com.kh.freeeat.place.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Wish {
	
	private String place_Name;
	private int mem_No;
	private String place_No;
	private Date wish_date;
	private String img_Name;
	private String img_Path;

}
