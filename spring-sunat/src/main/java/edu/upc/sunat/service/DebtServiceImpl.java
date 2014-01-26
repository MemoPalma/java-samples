package edu.upc.sunat.service;

import edu.upc.sunat.dao.DebtDaoImpl;
import edu.upc.sunat.entity.Debt;
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
public class DebtServiceImpl implements ServiceInterface<Debt> {

    private static Logger log = LoggerFactory.getLogger(DebtDaoImpl.class);
    
    @Autowired
    private DebtDaoImpl debtDao;

    @Override
    public List<Debt> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insertar(Debt object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Debt> listarPor(String[] filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Debt> listarPor(String filtro) {
        return debtDao.listarPor(filtro);
    }

    @Override
    public void elimnar(Debt object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Debt object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Debt buscar(Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
