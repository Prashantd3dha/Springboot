package com.prashant.demo.dao;

import com.prashant.demo.entity.Course;
import com.prashant.demo.entity.Instructor;
import com.prashant.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao{
    private EntityManager entityManager;

    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        //get associated courses
        List<Course> courses = instructor.getCourses();
        //delete instructor association with these courses
        for(Course c : courses){
            c.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data",Course.class);
        query.setParameter("data",id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id = :data",Instructor.class);
        query.setParameter("data",id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int courseId) {
        return entityManager.find(Course.class,courseId);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int courseId) {
        TypedQuery<Course> query = entityManager.createQuery("Select c from Course c JOIN FETCH c.reviews where c.id = :data", Course.class);
        query.setParameter("data", courseId);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteCourseById(int courseId) {
        Course course = entityManager.find(Course.class,courseId);
        entityManager.remove(course);
    }
}
