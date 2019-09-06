package com.example.beautyparlour;

public class ModelSkin {

    private int image;
    private String name,desc,view;

    public ModelSkin(int image, String name, String desc, String view) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.view = view;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}


