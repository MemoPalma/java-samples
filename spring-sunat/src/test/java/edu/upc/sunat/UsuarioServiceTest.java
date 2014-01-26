
package edu.upc.sunat;

import edu.upc.sunat.entity.User;
import edu.upc.sunat.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author operador
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-base-test.xml")
@Transactional
public class UsuarioServiceTest {

    private static Logger log = LoggerFactory.getLogger(UsuarioServiceTest.class);

    @Autowired
    private UserServiceImpl usuarioService;
    
    @Test
    public void testAutenticarPasswordVacio() {
        Assert.assertEquals(false,usuarioService.autenticar("gian.corzo@antartec.com",""));
    }

    @Test
    public void testAutenticarMinimo() {
        User usuario = new User("Giancarlo Corzo","gian.corzo@antartec.com","ad");
        Integer id = usuarioService.insertar(usuario);
        Assert.assertNull(id);
    }

    @Test
    public void testAutenticarElCorreoTieneFormatoAdecuado() {
        User usuario = new User("Giancarlo Corzo","gian.antartec.com","admin");
        usuarioService.insertar(usuario);
        Assert.assertEquals(false,usuarioService.autenticar("gian.antartec.com","admin"));
    }    
}
