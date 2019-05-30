package springexplorer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springexplorer.beans.UserDataBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class HtmlController {

    /**
     * 如果 校验的话 且被校验参数的下一个参数是BindingResult 那么不会抛出系统异常
     * 如果class path 中包含了hibernate validation 那么spring就支持 JSR-303 Bean Validation API
     *
     * @param model
     * @param user
     * @param result
     * @param date
     * @return
     */
    @RequestMapping("/page0")
    public String asyncProc2(Model model, @Validated UserDataBean user, BindingResult result, @RequestParam("date") Date date) {
        model.addAttribute("test", "test");
        System.out.println("complete2");
        System.out.println(date);
        return "0.html";
    }

    @RequestMapping("/async3")
    public void asyncProc3() {
        System.out.println("complete3");
    }

    public ResponseEntity<String> handle(Exception ex, HttpServletRequest rq) {
        return ResponseEntity.ok().body("700");
    }
}
