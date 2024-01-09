package com.kh.freeeat.place.model.vo;

import lombok.Data;

@Data
public class Place {

	   private int placeNo;
	   private String placeName;
	   private String placeAddress;
	   private String placePhone;
	   private String placeKind;
	   private String placeTime;
	   private String placeDayoff;
	   private String placeParking;
	   private String placeInfo;
	   private String placeStatus;
	   private int placeViews;
	   private String placeType; //타입
	   
	   private double grade; //리뷰 평점
	   private int reviewCount; //리뷰수
	   private int wishCount; //좋아요수
	   private String titleImg; //리스트 대표사진
	   
	   private int countReview;
	   private int sumReview;
	
	
}
