package com.goffity.mobile.android.demo.retrofitdemo.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class MemberResponse {

  @SerializedName("statuscode")
  private int statuscode;

  @SerializedName("member")
  private Member member;

  @SerializedName("statusdesc")
  private String statusdesc;

  public void setStatuscode(int statuscode) {
    this.statuscode = statuscode;
  }

  public int getStatuscode() {
    return statuscode;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public Member getMember() {
    return member;
  }

  public void setStatusdesc(String statusdesc) {
    this.statusdesc = statusdesc;
  }

  public String getStatusdesc() {
    return statusdesc;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}