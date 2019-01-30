package com.html.dto;

import java.sql.Timestamp;

public class BoardUserVO
{
   private int userNum;
   private String userId;
   private String userPw;
   private String userNick;
   private int userPhone;
   private String userName;
   private String userEmail;
   private Timestamp joindate;
   private int userClass;
   
   public int getUserNum() { return userNum; }
   public void setUserNum(int userNum) { this.userNum = userNum; }
   public String getUserId() { return userId; }
   public void setUserId(String userId) { this.userId = userId; }
   public String getUserPw() { return userPw; }
   public void setUserPw(String userPw) { this.userPw = userPw; }
   public String getUserNick() { return userNick; }
   public void setUserNick(String userNick) { this.userNick = userNick; }
   public int getUserPhone() { return userPhone; }
   public void setUserPhone(int userPhone) { this.userPhone = userPhone; }
   public String getUserName() { return userName; }
   public void setUserName(String userName) { this.userName = userName; }
   public String getUserEmail() { return userEmail; }
   public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
   public Timestamp getJoindate() { return joindate; }
   public void setJoindate(Timestamp joindate) { this.joindate = joindate; }
   public int getUserClass() { return userClass; }
   public void setUserClass(int userClass) { this.userClass = userClass; }
   @Override
   public String toString()
   {
      return "BoardUserVO [userNum=" + userNum + ", userId=" + userId + ", userPw=" + userPw + ", userNick="
            + userNick + ", userPhone=" + userPhone + ", userName=" + userName + ", userEmail=" + userEmail
            + ", joindate=" + joindate + ", userClass=" + userClass + "]";
   }
}
