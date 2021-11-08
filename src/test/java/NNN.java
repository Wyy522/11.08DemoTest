import enity.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.personServiceImpl;

import java.io.IOException;
import java.sql.SQLException;


public class NNN {
    @Autowired
    private personServiceImpl personService;
    @Test
    public void test() throws SQLException, IOException, ClassNotFoundException {
        personService.addPerson(new Person(88,"fff",77));
        personService.selectPerson(88);
    }
}
