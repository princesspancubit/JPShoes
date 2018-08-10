package com.uci.rest.model;


import javax.xml.bind.annotation.XmlRootElement;

public class Order {
    private String orderID;
    private String custFirstName;
    private String custLastName;
    private String phoneNumber;
    private String email;
    private String shipAdd;
    private String shipMeth;
    private String cardNum;
    private String cardName;
    private int month;
    private int year;
    private int totalQty;
    private int totalPrice;

    public String getOrderId(){
        return orderID;
    }

    public void setOrderId(String orderID){
        this.orderID = orderID;
    }

    public String getCustFirstName(){
        return custFirstName;
    }

    public void setCustFirstName(String fn){
        this.custFirstName = fn;
    }

    public String getCustLastName(){
        return custLastName;
    }

    public void setCustLastName(String ln){
        this.custLastName = ln;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String pn){
        this.phoneNumber = pn;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String em){
        this.email = em;
    }

    public String getShipAdd(){
        return shipAdd;
    }

    public void setShipAdd(String shipad){
        this.shipAdd = shipad;
    }

    public String getShipMeth(){
        return shipMeth;
    }

    public void setShipMeth(String sm){
        this.shipMeth = sm;
    }

    public String getCardNum(){
        return cardNum;
    }

    public void setCardNum(String cn){
        this.cardNum = cn;
    }

    public String getCardName(){
        return cardName;
    }

    public void setCardName(String cna){
        this.cardName = cna;
    }

    public int getMonth(){
        return month;
    }

    public void setMonth(int m){
        this.month = m;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int y){
        this.year = y;
    }

    public int getTotalQty(){
        return totalQty;
    }

    public void setTotalQty(int x){
        this.totalQty = x;
    }

    public int getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(int p){
        this.totalPrice = p;
    }

}