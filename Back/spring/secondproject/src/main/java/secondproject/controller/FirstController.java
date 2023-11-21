package secondproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String nicetoMeetYou(Model model){
        model.addAttribute("username","jaehan");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeuagain(Model model){
        model.addAttribute("username","jaehan");
        return "goodbye";
    }
}
