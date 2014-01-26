/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.controller;
import edu.upc.sunat.entity.CriterioBusqueda;
import edu.upc.sunat.entity.Debt;
import edu.upc.sunat.service.DebtServiceImpl;
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
 * @author javier olivares
 */
@Controller("HomeController")
public class HomeController {
    
    @Autowired
    private DebtServiceImpl debtService;
    private static Logger log = LoggerFactory.getLogger(UserController.class);
//@RequestParam("id")Integer id
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("criterioBusqueda") CriterioBusqueda criterio, SessionStatus status) {
        ModelAndView mav = new ModelAndView("/");
        log.info(criterio.getNombre());
        List<Debt> multas = debtService.listarPor(criterio.getNombre());
        //CriterioBusqueda criterioBusqueda = new CriterioBusqueda();
        mav.addObject("multas", multas);
        mav.addObject("criterioBusqueda",criterio);
        return mav;
    }
}
