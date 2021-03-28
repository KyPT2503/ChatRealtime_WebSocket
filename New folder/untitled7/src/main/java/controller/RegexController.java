package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

@Controller
@RequestMapping("/home")
public class RegexController {
    @GetMapping("/{name:[a-z]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}") //  spring web-3.0.5.jar
    public ModelAndView test(@PathVariable String name, @PathVariable String version, @PathVariable String ext) {
        System.out.println(name);
        System.out.println(version);
        System.out.println(ext);
        return new ModelAndView("home");
    }

    @GetMapping("/test/r{part:}")
    public ModelAndView test2(@PathVariable String part) {
        System.out.println(part);
        return new ModelAndView("home");
    }
}
