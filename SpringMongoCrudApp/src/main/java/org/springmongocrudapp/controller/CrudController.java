package org.springmongocrudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springmongocrudapp.model.Book;
import org.springmongocrudapp.repository.BookRepository;
import org.springmongocrudapp.response.Response;

import java.util.List;

@RestController
@RequestMapping(value = "/crud")
public class CrudController {

    @Autowired
    private BookRepository repo;

    @PostMapping("/addBook")
    public ResponseEntity<?> saveBook(@RequestBody Book book){
        try{
            repo.save(book);
            return new ResponseEntity<>(new Response("Successfully added",200,null,null), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Response(e.getMessage(),500,e.getMessage(),null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findAllBooks")
    public ResponseEntity<?> getBooks() {
        try{
            return new ResponseEntity<>(new Response("Successfully fetch the book details",200,null,repo.findAll()), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Response(e.getMessage(),500,e.getMessage(),null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(new Response("Successfully removed the book details",200,null,null), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), 500, e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
