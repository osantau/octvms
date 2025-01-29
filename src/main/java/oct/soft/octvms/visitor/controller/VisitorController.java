package oct.soft.octvms.visitor.controller;

import javax.validation.Valid;
import oct.soft.octvms.util.WebUtils;
import oct.soft.octvms.visitor.model.VisitorDTO;
import oct.soft.octvms.visitor.service.VisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(final VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("visitors", visitorService.findAll());
        return "visitor/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("visitor") final VisitorDTO visitorDTO) {
        return "visitor/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("visitor") @Valid final VisitorDTO visitorDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "visitor/add";
        }
        visitorService.create(visitorDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("visitor.create.success"));
        return "redirect:/visitors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("visitor", visitorService.get(id));
        return "visitor/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
            @ModelAttribute("visitor") @Valid final VisitorDTO visitorDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "visitor/edit";
        }
        visitorService.update(id, visitorDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("visitor.update.success"));
        return "redirect:/visitors";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
            final RedirectAttributes redirectAttributes) {
        visitorService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("visitor.delete.success"));
        return "redirect:/visitors";
    }

}
