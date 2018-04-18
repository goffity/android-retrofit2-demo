package com.goffity.mobile.android.demo.retrofitdemo.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Member {

  @SerializedName("image")
  private String image;

  @SerializedName("firstname")
  private String firstname;

  @SerializedName("birthdate")
  private String birthdate;

  @SerializedName("gender")
  private String gender;

  @SerializedName("address2")
  private String address2;

  @SerializedName("address1")
  private String address1;

  @SerializedName("facebookid")
  private Object facebookid;

  @SerializedName("lastname")
  private String lastname;

  @SerializedName("phone")
  private String phone;

  @SerializedName("nickname")
  private String nickname;

  @SerializedName("email")
  private String email;

  @SerializedName("memberid")
  private int memberid;

  @SerializedName("username")
  private String username;

  public void setImage(String image) {
    this.image = image;
  }

  public String getImage() {
    return image;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getGender() {
    return gender;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress1() {
    return address1;
  }

  public void setFacebookid(Object facebookid) {
    this.facebookid = facebookid;
  }

  public Object getFacebookid() {
    return facebookid;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhone() {
    return phone;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getNickname() {
    return nickname;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setMemberid(int memberid) {
    this.memberid = memberid;
  }

  public int getMemberid() {
    return memberid;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}