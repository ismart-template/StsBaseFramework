package net.hibiznet.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestTestController {
     
	private static final Logger logger = LoggerFactory.getLogger(TestTestController.class);
     
    @RequestMapping(value="/interceptorTest")
    public ModelAndView interceptorTest() throws Exception{
         
        ModelAndView mv = new ModelAndView("");
        logger.debug("인터셉터 테스트입니다!");
         
        return mv;
    }
     
}