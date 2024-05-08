package Aiss.vimeoMiner.servicesTest;

import Aiss.vimeoMiner.service.ChannelService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import Aiss.vimeoMiner.model.Channel;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class ChannelServicesTest {

    @Autowired
    ChannelService channelService;

    @Test
    @DisplayName("Get all channels")
    public void getAllChannelsTest(){
       List<Channel> lch = channelService.getChannels("e8c5d5a1bb1265c225ac3fd07b667945");
        System.out.println(lch);
    }

    @Test
    @DisplayName("Get a channel")
    public void getChannelByIdTest(){
        Channel ch = channelService.getChannelById("13423","e8c5d5a1bb1265c225ac3fd07b667945");
        System.out.println(ch);
    }
}
