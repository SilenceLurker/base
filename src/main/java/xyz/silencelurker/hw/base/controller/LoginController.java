package xyz.silencelurker.hw.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.silencelurker.hw.base.entity.Stuff;

@Controller
/**
 * @author Silence_Lurker
 */
@RequestMapping("/")
public class LoginController {
    @RequestMapping("/index")
    public String index(Model model) {
        Stuff stuff = new Stuff();
        // stuff.setStuffId(0);
        model.addAttribute("user", stuff);
        return "IndexPage";
    }
}
