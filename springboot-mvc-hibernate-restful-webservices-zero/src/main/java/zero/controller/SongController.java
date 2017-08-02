package zero.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import zero.service.SongService;

@Controller
public class SongController {

    @RequestMapping("/thefatrat")
    public String thefatrat(@RequestParam(value="name2", required=false, defaultValue="World") String name2, Model model) {
        model.addAttribute("name2", "ABC");
        /*ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-datasource-using-hibernate.xml");
    	SongService songService = (SongService) appContext.getBean("songService");*/
        return "thefatrat";
    }
    
    @RequestMapping(value = "/thefatrat_monody2", method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
    public HttpEntity<byte[]> downloadRecipientFile(@PathVariable("id") int id,
            ModelMap model, HttpServletResponse response) throws IOException,
            ServletException {
    	ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-datasource-using-hibernate.xml");
    	SongService songService = (SongService) appContext.getBean("songService");
        /*VoiceAudioLibrary dGroup = SongService.findAudioClip(id);
        if (dGroup == null || dGroup.getAudioData() == null
                || dGroup.getAudioData().length <= 0) {
            throw new ServletException("No clip found/clip has not data, id="
                    + id);
        }
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("audio", "mp3"));
        header.setContentLength(dGroup.getAudioData().length);
        return new HttpEntity<byte[]>(dGroup.getAudioData(), header);*/
    	return null;
    }
}
