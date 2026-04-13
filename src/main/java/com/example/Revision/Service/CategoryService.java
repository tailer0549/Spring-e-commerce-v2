package com.example.Revision.Service;

import com.example.Revision.Entities.Category;
import com.example.Revision.Repository.CategoryRepository;
import com.example.Revision.Service.Exceptions.DatabaseException;
import com.example.Revision.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired // Injeção de dependência automatica
    private CategoryRepository repository;

    public List<Category> findAll() {
        List<Category> list = repository.findAll();
        return list;
    }

    public Category findById(Long id) {
        Optional<Category> obj =  repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // orElseThrow -> Tenta executar o get, se não conseguir ele lança uma execeção
    }

    public Category insert(Category obj) {
        return repository.save(obj);
    }

    public Category update(Long id, Category obj) {
        try {
            Category entity = repository.getReferenceById(id); // Rastreando o objeto que queremos atualizar
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Category entity, Category obj) {
        entity.setName(obj.getName());
    }
}
