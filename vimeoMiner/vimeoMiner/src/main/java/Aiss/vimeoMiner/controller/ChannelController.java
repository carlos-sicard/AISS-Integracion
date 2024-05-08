package Aiss.vimeoMiner.controller;

import Aiss.vimeoMiner.model.*;
import Aiss.vimeoMiner.service.CaptionService;
import Aiss.vimeoMiner.service.ChannelService;
import Aiss.vimeoMiner.service.CommentsService;
import Aiss.vimeoMiner.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vimeo")
public class ChannelController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ChannelService channelService;

    @Autowired
    VideoService videoService;

    @Autowired
    CaptionService captionService;

    @Autowired
    CommentsService commentsService;

    @GetMapping("/{id}")
    public Channel getChannelFunction(@PathVariable(name = "id")String id,
                                           @RequestParam(name = "maxVideo",defaultValue = "10")String maxVideos,
                                           @RequestParam(name = "maxComments",defaultValue = "10")String maxComments){
        Channel channel = channelService.getChannelById(id,"e8c5d5a1bb1265c225ac3fd07b667945");
        List<Video> videos = videoService.getVideos(id,"e8c5d5a1bb1265c225ac3fd07b667945",maxVideos);
        for (int i=0; i< videos.size(); i++){
            List<Comments> comments = commentsService.getComments(id, videoService.parseoId(videos.get(i).getId()),"e8c5d5a1bb1265c225ac3fd07b667945",maxComments);
            List<Caption> captions = captionService.getCaptionsOfAVideo(id,videoService.parseoId(videos.get(i).getId()),"e8c5d5a1bb1265c225ac3fd07b667945");
            videos.get(i).getComments().addAll(comments);
            videos.get(i).getCaption().addAll(captions);
        }
        channel.getVideos().addAll(videos);
        return channel;
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Channel createChannelsFunction(@PathVariable(name = "id")String id,
                                          @RequestParam(name = "maxVideo",defaultValue = "10")String maxVideos,
                                          @RequestParam(name = "maxComments",defaultValue = "10")String maxComments){
        Channel ch = getChannelFunction(id,maxVideos,maxComments);
        String uri = "http://localhost:8080/videominer/channels";
        restTemplate.postForEntity(uri,ch,Channel.class);
        return ch;

    }

}
