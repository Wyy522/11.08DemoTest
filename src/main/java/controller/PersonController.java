package controller;

import enity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.personServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class PersonController {

    @Autowired
    private personServiceImpl personService;


    @RequestMapping("/gggg")
    @ResponseBody
    public String register(int id,String name ,int age) throws SQLException, IOException, ClassNotFoundException {
        if (personService.selectPerson(id)!=null){
            return "该用户已存";
        }else {
            personService.addPerson(new Person(id,name,age));
            return "已注册";
        }
    }

}
