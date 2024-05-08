package Aiss.vimeoMiner.service;

import Aiss.vimeoMiner.model.Caption;
import Aiss.vimeoMiner.model.Comments;
import Aiss.vimeoMiner.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CommentsService commentsService;
    @Autowired
    CaptionService captionService;

    public  List<Video> findAllVideos(String channelId){

        //send request
        String uri = "https://api.vimeo.com/channels/"+channelId+"/videos";
        Video[] respose = restTemplate.getForObject(uri,Video[].class);

        return Arrays.stream(respose).toList();
    }

    public List<Video> getVideos(String channelId,String token,String maxVideos){
        HttpHeaders headers = new HttpHeaders();
        String uri = "https://api.vimeo.com/channels/";
        headers.setBearerAuth(token);
        HttpEntity<Video> request = new HttpEntity<>(null,headers);

        ResponseEntity<Video> response = restTemplate.exchange(uri+channelId+"/videos?per_page="+maxVideos, HttpMethod.GET,request,Video.class);
        return response.getBody().getData();
    }

    public String parseoId(String uri){
        String res = uri.substring(uri.lastIndexOf("/")+1);
        return  res;
    }


}
