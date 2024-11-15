package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Agregar un libro a la biblioteca
    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    // Remover un libro de la biblioteca
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Permitir que un usuario tome un libro prestado
    public boolean borrowBook(IUser user, Book book) {
        if (books.contains(book)) {
            boolean r= user.borrowBook(book);
            if (r==true){
                books.remove(book);
            }
            
            return true;
        }
        return false;
    }

    // Permitir que un usuario devuelva un libro
    public void returnBook(IUser user, Book book) {
        if (!books.contains(book)) {
            user.returnBook(book);
            books.add(book);
        }
    }

    // Método para verificar si un libro está disponible en la biblioteca
    public boolean isBookAvailable(Book book) {
        return books.contains(book);
    }

    // Obtener una lista inmutable de los libros
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }
}