package Aiss.vimeoMiner.service;

import Aiss.vimeoMiner.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;

    String uri = "https://api.vimeo.com/channels";
    public List<Channel> getChannels(String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Channel> request = new HttpEntity<>(null,headers);

        ResponseEntity<Channel> response = restTemplate.exchange(uri, HttpMethod.GET,request,Channel.class);


        //return res;
        return response.getBody().getData();
    }

    public Channel getChannelById(String channelId,String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Channel> request = new HttpEntity<>(null,headers);

        ResponseEntity<Channel> response = restTemplate.exchange(uri+"/"+channelId,HttpMethod.GET,request,Channel.class);
        return response.getBody();
    }
}
