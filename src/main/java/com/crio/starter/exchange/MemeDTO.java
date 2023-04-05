package com.crio.starter.exchange;



public class MemeDTO {

    private String name;

    private String url;

    private String caption;


    public MemeDTO(String string, String string2, String string3) {
        name=string;
        url = string2;
        caption = string3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }


    // getters and setters
}


