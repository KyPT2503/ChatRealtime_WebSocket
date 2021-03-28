package service.book;

import model.Book;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.*;
import java.util.List;

@Transactional
public class BookService implements IBookService {
    @PersistenceContext
    private EntityManager entityManager;
    /*
    *@Resource
    private UserTransaction transaction;*/

    @Override
    public List<Book> getAll() {
        return entityManager.createQuery("select b from Book as b").getResultList();
    }

    @Override
    public Book getById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getByName(String name) {
        return entityManager.createQuery("select b from Book as b where b.name like ?1").setParameter(1, name).getResultList();
    }

    @Override
    public boolean remove(int id) {
        entityManager.remove(entityManager.find(Book.class, id));
        return true;
    }

    @Override
    public boolean update(int id, Book book) {
        return false;
    }

    @Override
    public int add(Book book) {
        /*try {
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();
        } catch(Exception e){
            try {
                transaction.rollback();
            } catch (SystemException systemException) {
                systemException.printStackTrace();
            }
            e.printStackTrace();
        }*/
        Query query = entityManager.createNativeQuery("call usp_insert_book(?1,?2,?3,?4,?5,?6,?7)");
        query.setParameter(1, book.getName());
        query.setParameter(2, book.getCode());
        query.setParameter(3, book.getAuthor());
        query.setParameter(4, book.isOutOfStock());
        query.setParameter(5, book.getPrice());
        query.setParameter(6, book.getQuantity());
        query.setParameter(7, book.getDateOfPublication());
        query.executeUpdate();
        return book.getId();
    }
}
