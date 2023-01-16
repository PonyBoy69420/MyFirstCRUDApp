package ru.crudapp.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.crudapp.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        logger.info("User " + user + " was successfully created");
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User user where user.id =:id")
        .setParameter("id",id).executeUpdate();
        logger.info("User " + " was successfully deleted");
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        logger.info("User " + user + "was successfully updated");
    }

    @Override
    public User getUserById(Long id) {
        User user = (User) entityManager.find(User.class, id);
        logger.info("User: " + user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        List<User> list;
        list = entityManager.createQuery("FROM User").getResultList();
        for(User user:list){
            logger.info("User: "+ user);
        }
        return list;
    }
}
