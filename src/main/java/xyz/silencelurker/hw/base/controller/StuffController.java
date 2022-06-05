package xyz.silencelurker.hw.base.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/login")
    public String login(Model model) {
        String str = "stuff/showMessage";

        String id = null;
        if (model.getAttribute(ID) == null) {
            id = "1";
        } else {
            id = model.getAttribute("id").toString();
        }

        Stuff stuff = stuffService.findById(Integer.parseInt(id));

        model.addAttribute("user", stuff);

        return str;
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
