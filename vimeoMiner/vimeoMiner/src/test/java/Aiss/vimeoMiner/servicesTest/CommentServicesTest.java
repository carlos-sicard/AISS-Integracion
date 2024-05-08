package Aiss.vimeoMiner.servicesTest;

import Aiss.vimeoMiner.model.Comments;
import Aiss.vimeoMiner.service.CommentsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class CommentServicesTest {

    @Autowired
    CommentsService commentsService;

    @Test
    @DisplayName("Get all comments of a video")
    public void getAllCommentsTest(){
        List<Comments> lcom = commentsService.getComments("324545","12204706","e8c5d5a1bb1265c225ac3fd07b667945","10");
        System.out.println(lcom);
    }

}
