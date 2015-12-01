package com.github.kingready.library.business;

import com.github.kingready.library.model.Book;
import com.github.kingready.library.model.Customer;
import com.github.kingready.library.model.Employee;
import com.github.kingready.library.model.Loan;
import com.github.kingready.library.model.embedded.Address;
import com.github.kingready.library.model.enumeration.BookType;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Startup
@Singleton
public class InitBean {

    @PersistenceContext
    EntityManager em;

    public InitBean() {
    }

    @PostConstruct
    public void init() {
        Book book = new Book("Überfall auf die Daten-Bank", "F. Pohnemann", BookType.SCIENCE);
        Book book2 = new Book("Kräuter und ihre Wirkung", "K. Räuterfreund", BookType.COOK_BOOK);
        Customer seehuber = new Customer("Dominik", "Seehuber", new Address("4711", "Am Hotelierweg", 1));
        Employee pohninger = new Employee("Florian", "Pohninger", "f.pohninger");
        Employee ammerix = new Employee("Simon", "Ammerix", "s.ammerix");
        Loan loan = new Loan(LocalDate.now(), null, book, seehuber, pohninger);

        em.persist(book);
        em.persist(book2);
        em.persist(seehuber);
        em.persist(pohninger);
        em.persist(ammerix);
        em.persist(loan);

        //em.remove(seehuber);
    }
}
