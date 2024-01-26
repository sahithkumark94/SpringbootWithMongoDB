package org.springmongocrudapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springmongocrudapp.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Long> {

}
