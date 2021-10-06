package com.depot_air.model;

public class SliderModel {
    String description,imagesUrl;

    public SliderModel(String description, String imagesUrl) {
        this.description = description;
        this.imagesUrl = imagesUrl;
    }

    public SliderModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }
}
