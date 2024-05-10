package YoutubeMiner.Models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Video {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("releaseTime")
    private String releaseTime;

    @JsonProperty("captions")
    private List<Caption> captions;

    @JsonProperty("comments")
    private List<Comment> comments;



    public Video() {
        this.captions = new ArrayList<Caption>();
        this.comments = new ArrayList<Comment>();
    }



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

    public String getUser_link() {
        return description;
    }

    public void setUser_link(String User_link) {
        this.description = description;
    }

    public String picture_link() {
        return releaseTime;
    }

    public void setWeb_url(String picture_link) {
        this.releaseTime = releaseTime;
    }

    public List<Caption> getCaptions() {
        return this.captions;
    }

    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", captions=" + captions +
                ", comments=" + comments +
                '}';
    }
}


