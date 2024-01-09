package com.kh.freeeat.place.model.vo;



import java.util.Date;

import lombok.Data;

@Data
public class Request {
	
	private int requesetNo; // REQUEST_NO	NUMBER
	private String requestContent; // REQUEST_CONTENT	VARCHAR2(2000 BYTE)
	private Date requestDate; // REQUEST_DATE	DATE
	private int placeNo; // PLACE_NO	NUMBER
	private int memNo; // MEM_NO	NUMBER
	private String placeName;
	private String memId;

}
