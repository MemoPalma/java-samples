package edu.upc.sunat.service;

import edu.upc.sunat.dao.UserDaoImpl;
import edu.upc.sunat.entity.User;
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
public class UserServiceImpl implements ServiceInterface<User> {

    private static Logger log = LoggerFactory.getLogger(UserDaoImpl.class);    

    public UserServiceImpl() {
    }
    
    
    @Autowired
    private UserDaoImpl usuarioDao;
    
    public Boolean autenticar(String correo,String password) {
        if (correo.contains("@")) {
            User user = usuarioDao.buscar(correo);
            if (user != null) {
                return user.getPassword().equals(password);
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public List<User> listarTodos() {
        log.info("Buscando todos los usuarios");
        return usuarioDao.listarTodos();
    }

    @Override
    public Integer insertar(User object) {
        if (object.getPassword().length() > 4) {
            log.info("Creando usuario");
            return usuarioDao.insertar(object);
        }       
        return null;
    }

    @Override
    public List<User> listarPor(String[] filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elimnar(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(User object) {
        log.info("Eliminando usuario");
        usuarioDao.elimnar(object);
    }

    @Override
    public User buscar(Integer pk) {
        log.info("Buscar usuario por id");
        return usuarioDao.buscar(pk);
    }

    @Override
    public List<User> listarPor(String filtro) {
        return usuarioDao.listarPor(filtro);
    }
}
