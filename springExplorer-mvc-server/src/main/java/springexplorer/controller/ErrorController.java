package springexplorer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {
    @RequestMapping("/error")
    @ResponseBody
    public Object error(){
        return "ErrorController->/error->5000";
    }
}
