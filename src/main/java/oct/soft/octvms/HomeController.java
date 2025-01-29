package oct.soft.octvms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oct.soft.octvms.visitor.model.VisitorDTO;


@Controller
public class HomeController {

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
    	String lang = request.getParameter("lang");
    	model.addAttribute("showChoose","true");
    	model.addAttribute("visitor", new VisitorDTO());
    	if(lang!=null)
    	{
    		model.addAttribute("showChoose","false");
    		model.addAttribute("showRegForm","true");
    	} else {
    		model.addAttribute("showRegForm","false");
    		model.addAttribute("showChoose","true");
    	}
        return "home/index";
    }

}
