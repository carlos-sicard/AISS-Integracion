package Aiss.vimeoMiner.model;

import java.util.List;

public class MinedChannel {

    private Channel channel;
    private List<Video> videos;
    private List<List<Caption>> captions;
    private List<List<Comments>> comments;

    public MinedChannel(Channel channel, List<Video> videos, List<List<Comments>> comments, List<List<Caption>> captions){
        this.channel=channel;
        this.videos=videos;
        this.comments=comments;
        this.captions=captions;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<List<Comments>> getComments() {
        return comments;
    }

    public void setComments(List<List<Comments>> comments) {
        this.comments = comments;
    }

    public List<List<Caption>> getCaptions() {
        return captions;
    }

    public void setCaptions(List<List<Caption>> captions) {
        this.captions = captions;
    }

    @Override
    public String toString() {
        return "MinedChannel{" +
                "channel=" + channel +
                ", videos=" + videos +
                ", captions=" + captions +
                ", comments=" + comments +
                '}';
    }
}
