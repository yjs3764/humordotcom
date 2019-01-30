package com.html.dto;

import java.sql.Timestamp;

public class BoardVO {
	private int boardnum;
	private Timestamp boarddate;
	private String boardtitle;
	private String boardcontent;
	private String usernick;
	private int recomm;
	private String ipnum;
	private int ismember;
	private int readcount;
	private String boardpass;
	private String boardfile;
/*	private int boardref;
	private int boardlev;
	private int boardseq;*/
	
	public String getBoardfile() {
		return boardfile;
	}
	public void setBoardfile(String boardfile) {
		this.boardfile = boardfile;
	}
/*	public int getBoardref() {
		return boardref;
	}
	public void setBoardref(int boardref) {
		this.boardref = boardref;
	}
	public int getBoardlev() {
		return boardlev;
	}
	public void setBoardlev(int boardlev) {
		this.boardlev = boardlev;
	}
	public int getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}*/
	public String getBoardpass() {
		return boardpass;
	}
	public void setBoardpass(String boardpass) {
		this.boardpass = boardpass;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public Timestamp getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(Timestamp boarddate) {
		this.boarddate = boarddate;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getBoardcontent() {
		return boardcontent;
	}
	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}
	public String getUsernick() {
		return usernick;
	}
	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}
	public int getRecomm() {
		return recomm;
	}
	public void setRecomm(int recomm) {
		this.recomm = recomm;
	}
	public String getIpnum() {
		return ipnum;
	}
	public void setIpnum(String ipnum) {
		this.ipnum = ipnum;
	}
	public int getIsmember() {
		return ismember;
	}
	public void setIsmember(int ismember) {
		this.ismember = ismember;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

}
