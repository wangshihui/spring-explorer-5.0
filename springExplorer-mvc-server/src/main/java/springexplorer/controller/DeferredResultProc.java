package springexplorer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class DeferredResultProc {
    @ResponseBody
    @RequestMapping("/async")
    public DeferredResult<String> asyncProc(){
        DeferredResult<String> result = new DeferredResult<>();
        new Thread(){
            public void run(){
                try{
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("finished");
                result.setResult("success!");
            }
        }.start();
        return result;
    }


}
