package Aiss.vimeoMiner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import  Aiss.vimeoMiner.model.Comments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class CommentsService {

    @Autowired
    RestTemplate restTemplate;



    public List<Comments> getComments(String channelId, String videoId, String token,String maxComments){
        HttpHeaders headers = new HttpHeaders();
        String uri = "https://api.vimeo.com/channels/"+channelId+"/videos/"+videoId+"/comments";
        headers.setBearerAuth(token);
        HttpEntity<Comments> request = new HttpEntity<>(null,headers);

        ResponseEntity<Comments> response = restTemplate.exchange(uri+"?per_page="+maxComments,HttpMethod.GET, request,Comments.class);

        return response.getBody().getData();

    }


}
