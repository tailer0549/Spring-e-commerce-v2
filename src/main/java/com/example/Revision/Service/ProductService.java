package com.example.Revision.Service;

import com.example.Revision.DTO.product.ProductInsertDTO;
import com.example.Revision.Entities.Product;
import com.example.Revision.Repository.ProductRepository;
import com.example.Revision.Service.Exceptions.DatabaseException;
import com.example.Revision.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        List<Product> list = repository.findAll();
        return list;
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(ProductInsertDTO obj) {
        Product entity =  fromInsertDTO(obj);
        return repository.save(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Product update(Long id, Product obj) {
        try {
            Product entity = repository.getReferenceById(id); // Rastreando o produto que queremos atualizar
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    private void updateData(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setCategories(obj.getCategories());
    }

    //Converter ProductInsertDTO para Product
    public Product fromInsertDTO(ProductInsertDTO dto) {
        return new Product(null, dto.getName(), dto.getDescription(), dto.getPrice(), dto.getImgUrl());
    }
}
