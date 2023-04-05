package com.crio.starter.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "memes")
public class Meme {
    @Id
    private String id;

    private String name;

    private String url;

    private String caption;

    public Meme(String string, String string2, String string3, String string4) {
        id=string;
        name = string2;
        url = string3;
        caption = string4;
    }

    public Meme() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

