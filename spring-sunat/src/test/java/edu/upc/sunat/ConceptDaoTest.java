/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat;

import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import edu.upc.sunat.dao.ConceptDaoImpl;
import edu.upc.sunat.entity.Concept;

/**
 *
 * @author herald olivares
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-base-test.xml")
@Transactional
public class ConceptDaoTest {
    private static Logger log = LoggerFactory.getLogger(ConceptDaoTest.class);
    
    @Autowired
    ConceptDaoImpl conceptDao;
    
    @Test
    public void testInsertarConcept(){
        Concept concept = new Concept(null, "Tributo1");
        Integer r= conceptDao.insertar(concept);
        Assert.assertNotNull(r);
    }
    
}
