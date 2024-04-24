package com.rgarmal.gestion.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rgarmal.gestion.model.Alergeno;
import com.rgarmal.gestion.model.Establecimiento;
import com.rgarmal.gestion.model.Tapa;
import com.rgarmal.gestion.services.AlergenoService;
import com.rgarmal.gestion.services.EstablecimientoServices;
import com.rgarmal.gestion.services.TapaServices;

@Controller
@RequestMapping("/tapas")
public class TapaController {
    
    @Autowired
    TapaServices tapaServices;

    @Autowired
    EstablecimientoServices establecimientoServices;

    @Autowired
    AlergenoService alergenoService;

    @GetMapping(value = "/list")
    public ModelAndView listPage(Model model) {

        List<Tapa> tapas = tapaServices.findAll();

        ModelAndView modelAndView = new ModelAndView("tapas/list");
        modelAndView.addObject("tapas", tapas);
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Tapa tapa = tapaServices.findById(codigo);
        List<Establecimiento> establecimientos = establecimientoServices.findAll();

        List<Alergeno> alergenos = alergenoService.findAll();
        for (Alergeno alergeno : alergenos) {
            if (tapa.getAlergenos() != null) {
                if (tapa.getAlergenos().contains(alergeno)){
                    alergeno.setPerteneceTapa(true);
                }
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tapa", tapa);
        modelAndView.addObject("establecimientos", establecimientos);
        modelAndView.addObject("alergenos", alergenos);

        modelAndView.setViewName("tapas/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Tapa tapa) {

        List<Alergeno> alergenos = alergenoService.findAll();
        List<Establecimiento> establecimientos = establecimientoServices.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tapa", new Tapa());
        modelAndView.addObject("alergenos", alergenos);
        modelAndView.addObject("establecimientos", establecimientos);
        modelAndView.setViewName("tapas/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Tapa tapa) {

        Tapa save = tapaServices.save(tapa);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + save.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Tapa tapa,@RequestParam(value="ck_alergenos") int[] ck_alergenos,HttpServletRequest request) {

        List<Alergeno> alergenos = tapa.getAlergenos();
        if(alergenos == null){
            alergenos = new ArrayList<Alergeno>();
        }

        for (int i : ck_alergenos) {
            Alergeno a = new Alergeno(i);
            alergenos.add(a);
        }               

        String establecimientoSeleccionado = request.getParameter("sl_establecimiento");
        Establecimiento e = new Establecimiento(Integer.parseInt(establecimientoSeleccionado));

        tapa.setAlergenos(alergenos);
        tapa.setEstablecimiento(e);
        tapaServices.update(tapa);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + tapa.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int id) {

        tapaServices.deleteById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}
