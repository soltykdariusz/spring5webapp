package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Newman");
        Book domain = new Book("Domain Driven Design", "666");
        Publisher dataPublisher = new Publisher("Hill", "London", "State", "1234" );
        eric.getBooks().add(domain);
        domain.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(domain);
        publisherRepository.save(dataPublisher);

        Author rod = new Author("Rod", "Jonson");
        Book noEJB = new Book("J2EE Development without EJB", "666666");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println(publisherRepository.count());
        System.out.println("Number of books: " + bookRepository.count());

    }
}
