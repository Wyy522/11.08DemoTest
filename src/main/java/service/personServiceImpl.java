package service;

import dao.PersonDao;
import enity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.MysqlConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

@Service
public class personServiceImpl {
    @Autowired
    private PersonDao personDao;

    public boolean addPerson(Person person) throws SQLException, IOException, ClassNotFoundException {
       if(personDao.addPerson(person)!=0) {
           return true;
       }else{
           return false;
       }
    }

    public Person selectPerson(int id) throws SQLException, IOException, ClassNotFoundException {
        return personDao.selectPerson(id);
    }
}
