package Aiss.vimeoMiner.service;

import Aiss.vimeoMiner.model.Caption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CaptionService {

    @Autowired
    RestTemplate restTemplate;

    private String uri = "https://api.vimeo.com/channels";

    public List<Caption> getCaptionsOfAVideo(String channelId, String videoId, String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Caption> request = new HttpEntity<>(null,headers);

        ResponseEntity<Caption> response = restTemplate.exchange(uri+"/"+channelId+"/videos/"
                                        +videoId+"/texttracks", HttpMethod.GET,request,Caption.class);

        return response.getBody().getData();

    }

}
