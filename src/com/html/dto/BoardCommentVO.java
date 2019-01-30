package com.html.dto;

import java.sql.Timestamp;

public class BoardCommentVO {
	
	private int comment_num;
	private int comment_board;
	private String comment_content;
	private int comment_ismember;
	private String comment_pass;
	private String comment_usernick;
	
	public String getComment_usernick() {
		return comment_usernick;
	}
	public void setComment_usernick(String comment_usernick) {
		this.comment_usernick = comment_usernick;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getComment_board() {
		return comment_board;
	}
	public void setComment_board(int comment_board) {
		this.comment_board = comment_board;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public int getComment_ismember() {
		return comment_ismember;
	}
	public void setComment_ismember(int comment_ismember) {
		this.comment_ismember = comment_ismember;
	}
	public String getComment_pass() {
		return comment_pass;
	}
	public void setComment_pass(String comment_pass) {
		this.comment_pass = comment_pass;
	}
	

}
