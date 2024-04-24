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

import com.rgarmal.gestion.model.Establecimiento;
import com.rgarmal.gestion.model.Tapa;
import com.rgarmal.gestion.services.EstablecimientoServices;
import com.rgarmal.gestion.services.TapaServices;

@Controller
@RequestMapping("/establecimientos")
public class EstablecimientoController {
    @Autowired
    EstablecimientoServices establecimientoServices;

    @Autowired
    TapaServices tapaServices;

    @GetMapping(value = "/list")
    public ModelAndView listPage(Model model) {

        List<Establecimiento> establecimientos = establecimientoServices.findAll();

        ModelAndView modelAndView = new ModelAndView("establecimientos/list");
        modelAndView.addObject("establecimientos", establecimientos);
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Establecimiento establecimiento = establecimientoServices.findById(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("establecimiento", establecimiento);
        modelAndView.setViewName("establecimientos/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Establecimiento establecimiento) {

        ModelAndView modelAndView = new ModelAndView();
        List<Tapa> tapas = tapaServices.findAll();

        modelAndView.addObject("establecimiento", new Establecimiento());
        modelAndView.addObject("tapas", tapas);
        modelAndView.setViewName("establecimientos/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Establecimiento establecimiento) {

        Establecimiento save = establecimientoServices.save(establecimiento);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + save.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Establecimiento establecimiento) {

        establecimientoServices.update(establecimiento);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + establecimiento.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int id) {

        establecimientoServices.deleteById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}
