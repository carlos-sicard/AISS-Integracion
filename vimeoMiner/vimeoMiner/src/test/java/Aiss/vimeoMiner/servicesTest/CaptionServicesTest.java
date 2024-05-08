package Aiss.vimeoMiner.servicesTest;

import Aiss.vimeoMiner.service.CaptionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import Aiss.vimeoMiner.model.Caption;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class CaptionServicesTest {

    @Autowired
    CaptionService captionService;

    @Test
    @DisplayName("Get all captions of a video")
    public void getAllCaption(){
        List<Caption> lCa = captionService.getCaptionsOfAVideo("13423","1153361","e8c5d5a1bb1265c225ac3fd07b667945");
        System.out.println(lCa);
    }
}
