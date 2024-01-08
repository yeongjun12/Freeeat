package com.kh.freeeat.member.model.vo;

import lombok.Data;

@Data
public class Member {
	
	private int memNo; //MEM_NO	NUMBER
	private String memId;
	private String memPwd; //MEM_PWD	VARCHAR2(20 BYTE)
	private String memNickName; //MEM_NICKNAME	VARCHAR2(20 BYTE)
	private String phone; //MEM_PHONE	VARCHAR2(20 BYTE)
	private String birthDate; //MEM_BIRTH	DATE
	private String email; //MEM_EMAIL	VARCHAR2(20 BYTE)
	private String type; //MEM_TYPE	VARCHAR2(20 BYTE)
	private String residence; //MEM_RESIDENCE	VARCHAR2(20 BYTE)
	private String enrollDate;//MEM_ENROLLDATE	DATE
	private String status; //MEM_STATUS	VARCHAR2(1 BYTE)
	private String mem_profileOG;
	private String mem_profileRevise;
	private String mem_profile_savePath;

}
