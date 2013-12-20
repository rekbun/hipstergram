package com.assignment.hipstergram;

import java.util.Date;

public class ImageBlock {
    public long id;
    public String title;
    public String longitude;
    public String latitude;
    public String path;
    public String date;

    public ImageBlock(String title, String longitude, String latitude, String path, String  date) {
        this.title = title;
        this.longitude = longitude;
        this.latitude = latitude;
        this.path = path;
        this.date = date;
    }

    public ImageBlock() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
