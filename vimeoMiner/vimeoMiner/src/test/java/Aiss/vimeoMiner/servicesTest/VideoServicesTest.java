package Aiss.vimeoMiner.servicesTest;

import Aiss.vimeoMiner.model.Video;
import Aiss.vimeoMiner.service.VideoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VideoServicesTest {

    @Autowired
    VideoService videoService;

    @Test
    @DisplayName("Get all videos of a channel")
    public void getAllVideos(){
        List<Video> lv = videoService.getVideos("13423","e8c5d5a1bb1265c225ac3fd07b667945","10");
        System.out.println(lv);
    }
}
