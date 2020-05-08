package com.example.myapplication;

public class farmer_data {

    private String name;
    private String add;
    private String phone;
    private String veg;
    private String quant;
    private String time;
    private String id;
    private String type;
    private int img;
    private String back;
    private String cards;

    public farmer_data(){}

    public farmer_data(String id, String name, String add, String phone,
                       String veg, String quant, String time, String type,
                       int img, String back, String cards){
        this.id = id;
        this.name = name;
        this.add = add;
        this.phone = phone;
        this.veg = veg;
        this.quant = quant;
        this.time = time;
        this.type = type;
        this.img = img;
        this.back = back;
        this.cards = cards;

    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }

    public void setQuant(String quant) {
        this.quant = quant;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdd() {
        return add;
    }

    public String getPhone() {
        return phone;
    }

    public String getTime() {
        return time;
    }

    public String getQuant() {
        return quant;
    }

    public String getVeg() {
        return veg;
    }
}
