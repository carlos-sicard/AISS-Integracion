package Aiss.vimeoMiner.controllerTest;

import Aiss.vimeoMiner.controller.ChannelController;
import Aiss.vimeoMiner.model.MinedChannel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Aiss.vimeoMiner.model.Channel;

@SpringBootTest
public class ChannelControllerTest {

    @Autowired
    ChannelController channelController;

    @Test
    @DisplayName("get a channel with videos with captions and comments for each one")
    void getChannelfunctionTest(){
        Channel channel = channelController.getChannelFunction("324545","10","10");
        System.out.println(channel);


    }
}
