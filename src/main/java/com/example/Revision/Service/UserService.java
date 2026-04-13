package com.example.Revision.Service;

import com.example.Revision.DTO.user.UserInsertDTO;
import com.example.Revision.Entities.User;
import com.example.Revision.Repository.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> list = repository.findAll();
        return list;
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // Tenta dar um get, se for null ele lança uma exceção
    }

    public User insert(UserInsertDTO dto) {

        User obj = fromInsertDTO(dto);
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        // Capturei a exceção do java e lancei a minha própria exceção personalizada..
        catch (EmptyResultDataAccessException e) {
           throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage()); // Pegando a mensagem da exceção e mandando para o construtor da minha exceção
            // Estou lançando uma exceção da minha camada de serviço
        }
    }

    public User update(Long id, User obj) {
        try {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage()); // Mostra a nossa exceção personalizada
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


    public User fromInsertDTO(UserInsertDTO dto) {
        return new User(null, dto.getName(), dto.getEmail(), dto.getPhone(), dto.getPassword());
    }
}
