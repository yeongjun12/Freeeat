package com.kh.freeeat.place.model.vo;

import lombok.Data;

@Data
public class PlaceMenu {
	
	private int placeNo; //PLACE_NO	NUMBER
	private String menuName; //MENU_NAME	VARCHAR2(30 BYTE)
	private int price; //PRICE	NUMBER
	private String menuType; //MENU_TYPE	VARCHAR2(100 BYTE)

}
