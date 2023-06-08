package sg.edu.nus.iss.ssf_crypto.Model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;



import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class News implements Serializable{
    private String id;
    private long published_on;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;
    private boolean save;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getPublished_on() {
        return published_on;
    }
    public void setPublished_on(long published_on) {
        this.published_on = published_on;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }
    public boolean isSave() {
        return save;
    }
    public void setSave(boolean save) {
        this.save = save;
    }

    //parse the string into the java object
    public static News create(String json) throws IOException{
        News n = new News();
        try (InputStream is = new ByteArrayInputStream(json.getBytes())){
            //build json object from string json
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            //use class setter to set from json object
            n.setId(o.getJsonString("id").toString());
            n.setPublished_on(o.getJsonNumber("published_on").longValue());
            n.setImageurl(o.getJsonString("imageurl").toString());
            n.setTitle(o.getJsonString("title").toString());
            n.setUrl(o.getJsonString("url").toString());
            n.setBody(o.getJsonString("body").toString());
            n.setTags(o.getJsonString("tags").toString());
            n.setCategories(o.getJsonString("categories").toString());
        }
        return n;
    }
}