package org.example.service.impl;

import org.example.entity.Author;
import org.example.repository.AuthorRepository;
import org.example.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Optional<Author> getAuthor(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public void updateAuthor(Author author, int id) {
        Author authorTemp = authorRepository.findById(id).get();
        authorTemp.setGenderAuthor(author.getGenderAuthor());
        authorTemp.setNameAuthor(author.getNameAuthor());
        authorTemp.setSecondNameAuthor(author.getSecondNameAuthor());
        authorTemp.setDateOfBirthAuthor(author.getDateOfBirthAuthor());
        authorRepository.save(authorTemp);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
