package xyz.silencelurker.hw.base.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.silencelurker.hw.base.entity.Department;
import xyz.silencelurker.hw.base.entity.Stuff;
import xyz.silencelurker.hw.base.entity.UserRole;
import xyz.silencelurker.hw.base.service.DepartmentService;
import xyz.silencelurker.hw.base.service.OccupationService;
import xyz.silencelurker.hw.base.service.SalaryService;
import xyz.silencelurker.hw.base.service.StuffService;
import xyz.silencelurker.hw.base.service.UserRoleService;

/**
 * @author Silence_Lurker
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final String ADMIN = "管理员";

    @Resource
    private UserRoleService userRoleService;
    @Resource
    private StuffService stuffService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private OccupationService occupationService;
    @Resource
    private SalaryService salaryService;

    @RequestMapping("/login")
    public String adminLogin(Model model) {
        Stuff stuff = (Stuff) model.getAttribute("user");

        UserRole userRole = userRoleService.findById(stuff.getUserRoleId());

        if (ADMIN.equals(userRole.getUserRole())) {
            model.addAttribute("userRole", userRole);
            return "admin/index";
        }

        return "error";
    }

    public String showAllStuffInfo(Model model) {
        List<Stuff> stuffs = stuffService.findAll();

        model.addAttribute("users", stuffs);

        return "admin/showAllStuffInfo";
    }

    @RequestMapping("/addNewStuffService")
    public String addNewStuff(Model model) {
        Stuff stuff = new Stuff();

        int departmentId = 0;

        stuff.setAge(Integer.parseInt(model.getAttribute("age").toString()));
        Iterator<Department> it = departmentService.findAll().iterator();

        while (it.hasNext()) {
            Department d = it.next();
            if (d.getDepartment().equals(model.getAttribute("department").toString())) {
                departmentId = d.getDepartmentId();
            }
        }

        stuff.setDepartmentId(departmentId);

        return "admin/index";
    }
}
