//package org.example.config;
//
//
//import org.example.entity.Author;
//import org.example.entity.Book;
//import org.example.repository.AuthorRepository;
//import org.example.repository.BookRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.sql.Date;
//
//
//@Configuration
//    class LoadDatabase {
//
//        private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//        @Bean
//        CommandLineRunner initDatabase(BookRepository bookRepository, AuthorRepository authorRepository) {
//
//            return args -> {
//                log.info("Preloading " + bookRepository.save(new Book("Fifty shades of grey",
//                        "Lev Tolstoy",
//                        Date.valueOf("1913-04-22").toLocalDate(),
//                        "Tolstoy Lakshery",
//                        1)));
//                log.info("Preloading " + bookRepository.save(new Book("HellRaiser",
//                        "Lemmy Killmister",
//                        Date.valueOf("1978-05-20").toLocalDate(),
//                        "Rock Legends",
//                        2)));
//                log.info("Preloading " + bookRepository.save(new Book("Stairway to heaven",
//                        "Led Zeppelin",
//                        Date.valueOf("1982-01-15").toLocalDate(),
//                        "We are not Deep Purple",
//                        3)));
//                log.info("Preloading " + authorRepository.save(new Author("Zazi",
//                        "Blitz",
//                        Date.valueOf("1982-01-15").toLocalDate(),
//                        "female",
//                        0,
//                        1)));
//                log.info("Preloading " + authorRepository.save(new Author("Zulander",
//                        "Blitz",
//                        Date.valueOf("1982-01-15").toLocalDate(),
//                        "female",
//                        0,
//                        2)));
//                log.info("Preloading " + authorRepository.save(new Author("Zubagai",
//                        "Blitz",
//                        Date.valueOf("1982-01-15").toLocalDate(),
//                        "female",
//                        0,
//                        3)));
//            };
//        }
//    }
