package com.rgarmal.gestion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rgarmal.gestion.model.Alergeno;
import com.rgarmal.gestion.services.AlergenoService;

@Controller
@RequestMapping("/alergenos")
public class AlergenoController {
    
    @Autowired
    AlergenoService alergenoService;

    @GetMapping(value = "/list")
    public ModelAndView listPage(Model model) {

        List<Alergeno> alergenos = alergenoService.findAll();

        ModelAndView modelAndView = new ModelAndView("alergenos/list");
        modelAndView.addObject("alergenos", alergenos);
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Alergeno alergeno = alergenoService.findById(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("alergeno", alergeno);
        modelAndView.setViewName("alergenos/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Alergeno alergeno) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("alergeno", new Alergeno());
        modelAndView.setViewName("alergenos/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Alergeno alergeno) {

        Alergeno save = alergenoService.save(alergeno);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + save.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Alergeno alergeno) {

        alergenoService.update(alergeno);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + alergeno.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int id) {

        alergenoService.deleteById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}
