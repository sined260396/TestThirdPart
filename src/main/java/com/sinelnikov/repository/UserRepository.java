package com.sinelnikov.repository;

import com.sinelnikov.entity.UserEntity;
import com.sinelnikov.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public List<UserEntity> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("From UserEntity").list();
        }
    }

    public UserEntity getUserById(final Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            UserEntity result = session.get(UserEntity.class, id);
            session.getTransaction().commit();
            return result;
        }
    }

    public UserEntity addUser(final UserEntity userEntity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(userEntity);
            session.getTransaction().commit();
            return userEntity;
        }
    }

    public UserEntity updateUser(final UserEntity userEntity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(userEntity);
            session.getTransaction().commit();
            return userEntity;
        }
    }

    public void deleteUser(final Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            UserEntity del = UserEntity.builder().id(id).build();
            session.delete(del);
            session.getTransaction().commit();
        }
    }
}
