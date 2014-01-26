package edu.upc.sunat.service;

import edu.upc.sunat.dao.ConceptDaoImpl;
import edu.upc.sunat.entity.Concept;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gian
 *
 */
@Service
public class ConceptServiceImpl implements ServiceInterface<Concept> {

    private static Logger log = LoggerFactory.getLogger(ConceptDaoImpl.class);
    
    @Autowired
    private ConceptDaoImpl conceptDao;

    @Override
    public List<Concept> listarTodos() {
        return conceptDao.listarTodos();
    }

    @Override
    public Integer insertar(Concept object) {
        return conceptDao.insertar(object);
    }

    @Override
    public List<Concept> listarPor(String[] filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concept> listarPor(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elimnar(Concept object) {
        conceptDao.elimnar(object);
    }

    @Override
    public void actualizar(Concept object) {
        conceptDao.actualizar(object);
    }

    @Override
    public Concept buscar(Integer pk) {
        return conceptDao.buscar(pk);
    }
    
    
}
