package springexplorer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class HtmlController {
    @RequestMapping("/page0")
        public String asyncProc2(Model model, @RequestParam("date") Date date){
        model.addAttribute("test","test");
        System.out.println("complete2");
        System.out.println(date);
        return "0.html";
    }

    @RequestMapping("/async3")
    public void asyncProc3(){
        System.out.println("complete3");
    }

    public ResponseEntity<String> handle(Exception ex, HttpServletRequest rq) {
        return ResponseEntity.ok().body("700");
    }
}
