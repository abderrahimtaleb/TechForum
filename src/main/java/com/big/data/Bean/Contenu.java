package com.big.data.Bean;


public class Contenu {

    private String text;
    private String image;
    private String video;

    public Contenu() {
    }

    public Contenu(String text, String image, String video) {
        this.text = text;
        this.image = image;
        this.video = video;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
