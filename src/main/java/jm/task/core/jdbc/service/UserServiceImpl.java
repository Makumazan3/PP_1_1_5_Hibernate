package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    public void createUsersTable() {

        userDaoHibernate.createUsersTable();
        System.out.println("was created");
    }

    public void dropUsersTable() {

        userDaoHibernate.dropUsersTable();
        System.out.println("was deleted");
    }

    public void saveUser(String name, String lastName, byte age) {

        userDaoHibernate.saveUser(name, lastName, age);
        System.out.println("was created user");
    }

    public void removeUserById(long id) {

        userDaoHibernate.removeUserById(id);
        System.out.println("was removed");
    }

    public List<User> getAllUsers() {

        return  userDaoHibernate.getAllUsers();

    }

    public void cleanUsersTable() {

        userDaoHibernate.cleanUsersTable();
        System.out.println("was clean");
    }
}
