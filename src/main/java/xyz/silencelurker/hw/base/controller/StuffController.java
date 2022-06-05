package xyz.silencelurker.hw.base.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.silencelurker.hw.base.entity.Stuff;
import xyz.silencelurker.hw.base.service.StuffService;

/**
 * @author Silence_Lurker
 */
@Controller
@RequestMapping("/stuff")
public class StuffController {
    private static final String ID = "id";

    @Resource
    private StuffService stuffService;

    @GetMapping(value = "/login")
    public String loginGet(Model model, @ModelAttribute(name = "user") Stuff user) {

        Stuff stuff = (Stuff) model.getAttribute("user");

        stuff = stuffService.findById(stuff.getStuffId());

        model.addAttribute("user", stuff);

        return "stuff/showMessage";
    }

    @PostMapping("/login")
    public String loginPost(Model model, @ModelAttribute(name = "user") Stuff user) {

        Stuff s = null;

        s = stuffService.findById(user.getStuffId());

        model.addAttribute("user", s);

        return "stuff/showMessage";
    }

    /**
     * 控制器测试
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/test")
    public String test(Model model) {
        return "success";
    }

}
