/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.controller;
import edu.upc.sunat.entity.Concept;
import edu.upc.sunat.entity.CriterioBusqueda;
import edu.upc.sunat.service.ConceptServiceImpl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author herald olivares
 */
@Controller("conceptController")
public class ConceptController {
    
    @Autowired
    private ConceptServiceImpl service;
    private static Logger log = LoggerFactory.getLogger(UserController.class);
//@RequestParam("id")Integer id
    @RequestMapping(value = "/admin/concept", method=RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("criterioBusqueda") CriterioBusqueda criterio, SessionStatus status) {
        ModelAndView mav = new ModelAndView("admin/concept");
        log.info(criterio.getNombre());
        List<Concept> concepts = service.listarTodos();
        //CriterioBusqueda criterioBusqueda = new CriterioBusqueda();
        mav.addObject("list", concepts);
        mav.addObject("criterioBusqueda",criterio);
        return mav;
    }
    
    @RequestMapping(value = "/admin/concept/add", method = RequestMethod.GET)
    public ModelAndView newConcept() {
        ModelAndView mav = new ModelAndView("admin/concept/add");
        Concept concept = new Concept();
        mav.getModelMap().put("concept", concept);
        return mav;
    }
    
    @RequestMapping(value = "/admin/concept/add", method = RequestMethod.POST)
    public String createConcept(@ModelAttribute("concept")Concept concept, 
                                SessionStatus status) {        
        service.insertar(concept);
        status.setComplete();
        return "redirect:/pages/admin/concept";
    }
    
    @RequestMapping(value = "/admin/concept/edit", method = RequestMethod.GET)
    public ModelAndView editConcept(@RequestParam("id")Integer id) {    
        ModelAndView mav = new ModelAndView("admin/concept/edit");
        Concept concept = service.buscar(id);
        mav.getModelMap().put("concept", concept);
        return mav;        
    }
    
    @RequestMapping(value="/admin/concept/edit", method=RequestMethod.POST)
    public String update(@ModelAttribute("concept") Concept concept, SessionStatus status) {
        service.actualizar(concept);
        status.setComplete();
        return "redirect:/pages/admin/concept";
    }
    
    @RequestMapping("/admin/concept/delete")
    public ModelAndView delete(@RequestParam("id")Integer id)
    {
        ModelAndView mav = new ModelAndView("redirect:/pages/admin/concept");
        Concept concept = service.buscar(id);
        service.elimnar(concept);
        return mav;
    }
}
