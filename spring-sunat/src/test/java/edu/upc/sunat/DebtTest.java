/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat;
import edu.upc.sunat.dao.ConceptDaoImpl;
import edu.upc.sunat.dao.DebtDaoImpl;
import edu.upc.sunat.dao.PersonDaoImpl;
import edu.upc.sunat.entity.Concept;
import edu.upc.sunat.entity.Debt;
import edu.upc.sunat.entity.Person;
import java.util.List;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author herald olivares
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-base-test.xml")
@Transactional
public class DebtTest {
    private static Logger log = LoggerFactory.getLogger(ConceptDaoTest.class);
    
    @Autowired
    DebtDaoImpl debtDao;
    @Autowired
    PersonDaoImpl personDao;
    @Autowired
    ConceptDaoImpl conceptDao;
    
    @Test
    public void testMultasPorRuc(){
        Person person = new Person();
        person.setName("Heral Olivares");
        person.setPhone("54354");
        person.setRuc("00000666777");
        person.setType(1);
        Integer r = personDao.insertar(person);
        Assert.assertNotNull(r);
        Concept concept = new Concept(null, "Tributo 0000");
        r = conceptDao.insertar(concept);
        Assert.assertNotNull(r);
        
        Debt debt1 = new Debt(null, concept, person, "Diciembre",
                "4343", "4343", 4343.434);
        Debt debt2 = new Debt(null, concept, person, "Diciembre",
                "4343", "4343", 4343.434);
        Debt debt3 = new Debt(null, concept, person, "Diciembre",
                "4343", "4343", 4343.434);
        r = debtDao.insertar(debt1);
        Assert.assertNotNull(r);
        r = debtDao.insertar(debt2);
        Assert.assertNotNull(r);
        r = debtDao.insertar(debt3);
        Assert.assertNotNull(r);
        //Assert.assertEquals(new Integer(3), r);
        List<Debt> multas = debtDao.listarPor(person.getRuc());
        Assert.assertEquals(3, multas.size());
        
        Assert.assertEquals("00000666777", multas.get(0).getPerson().toString());
    }
}
