package jm.task.core.jdbc.util;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.security.auth.login.AppConfigurationEntry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;

public class Util {
    // реализуйте настройку соеденения с БД
    //   создаём переменные
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String DB_USERNAME = "Makumazan";
    private static final String DB_PASSWORD = "root";

    //создаём соединение

    public static Connection getConnection() {
        Connection connection = null;
        // если вылетят ошибки

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }


    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(AvailableSettings.DRIVER, DB_DRIVER);
            settings.put(AvailableSettings.URL, DB_URL);
            settings.put(AvailableSettings.USER, DB_USERNAME);
            settings.put(AvailableSettings.PASS, DB_PASSWORD);
            settings.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            settings.put(HBM2DDL_AUTO, "");
            configuration.setProperties(settings).addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (
                HibernateException e) {
            e.printStackTrace();
            System.out.println("Session isn't create");
        }
        return sessionFactory;
    }
}

