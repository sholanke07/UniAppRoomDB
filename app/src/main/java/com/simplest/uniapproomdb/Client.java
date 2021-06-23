package com.simplest.uniapproomdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class Client implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String Name;
    private String Address;
    private String Phone;
    private String From;
    private String To;
    private String Travel;
    private String Code;
    private String Sex;
    private String Color;
    private String Reg;
    private String Model;
    private String Email;
    private String NextName;
    private String NextPhone;
    private String NextMail;
    private String Uploadpic;
    private String BackCode;
    private String Last4;
    private String CardPin;
    private String CardDate;
    private String Amount;
    private String NUMBER;
    private  String PolicyName;
    private String PolicyNo;
    private String Date;
    private String Details;
    private String Medical;
    private String Picture;
    private String Original;
    private String Death;
    private String ClaimEmail;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getTravel() {
        return Travel;
    }

    public void setTravel(String travel) {
        Travel = travel;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getReg() {
        return Reg;
    }

    public void setReg(String reg) {
        Reg = reg;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNextName() {
        return NextName;
    }

    public void setNextName(String nextName) {
        NextName = nextName;
    }

    public String getNextPhone() {
        return NextPhone;
    }

    public void setNextPhone(String nextPhone) {
        NextPhone = nextPhone;
    }

    public String getNextMail() {
        return NextMail;
    }

    public void setNextMail(String nextMail) {
        NextMail = nextMail;
    }

    public String getUploadpic() {
        return Uploadpic;
    }

    public void setUploadpic(String uploadpic) {
        Uploadpic = uploadpic;
    }

    public String getBackCode() {
        return BackCode;
    }

    public void setBackCode(String backCode) {
        BackCode = backCode;
    }

    public String getLast4() {
        return Last4;
    }

    public void setLast4(String last4) {
        Last4 = last4;
    }

    public String getCardPin() {
        return CardPin;
    }

    public void setCardPin(String cardPin) {
        CardPin = cardPin;
    }

    public String getCardDate() {
        return CardDate;
    }

    public void setCardDate(String cardDate) {
        CardDate = cardDate;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getNUMBER() {
        return NUMBER;
    }

    public void setNUMBER(String NUMBER) {
        this.NUMBER = NUMBER;
    }

    public String getPolicyName() {
        return PolicyName;
    }

    public void setPolicyName(String policyName) {
        PolicyName = policyName;
    }

    public String getPolicyNo() {
        return PolicyNo;
    }

    public void setPolicyNo(String policyNo) {
        PolicyNo = policyNo;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getMedical() {
        return Medical;
    }

    public void setMedical(String medical) {
        Medical = medical;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getOriginal() {
        return Original;
    }

    public void setOriginal(String original) {
        Original = original;
    }

    public String getDeath() {
        return Death;
    }

    public void setDeath(String death) {
        Death = death;
    }

    public String getClaimEmail() {
        return ClaimEmail;
    }

    public void setClaimEmail(String claimEmail) {
        ClaimEmail = claimEmail;
    }
}
