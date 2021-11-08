package dao;

import enity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import util.MysqlConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonDao {

    public Person selectPerson(int id) throws SQLException, IOException, ClassNotFoundException {
        Person person = new Person();
        Connection connection =null;
        connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement =null;
        String sql ="select name from person where id=?";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.getResultSet();
        if(preparedStatement.execute()){
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            return person;
        }
        else {
            System.out.println("找不到");
            return null;
        }

    }

    public int addPerson(Person person) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = MysqlConnection.getInstance().getConnection();
        String sql ="Insert into person(id,name,age)values(?,?,?)";
        preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setInt(1,person.getId());
        preparedStatement.setString(2,person.getName());
        preparedStatement.setInt(3,person.getAge());
        return preparedStatement.executeUpdate();
    }
}
