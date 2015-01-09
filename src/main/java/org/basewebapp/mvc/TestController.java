package org.basewebapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Deprecated
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String test() {
        return "hello";
    }
    
}
