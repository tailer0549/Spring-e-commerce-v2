package com.example.Revision.Controller;

import com.example.Revision.DTO.user.UserDTO;
import com.example.Revision.DTO.user.UserInsertDTO;
import com.example.Revision.Entities.User;
import com.example.Revision.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/users")
public class UserController implements Serializable {

    @Autowired
    private UserService service;

    // FindAll
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> dtoList = list.stream()
                .map(UserDTO::new)
                .toList();
        return ResponseEntity.ok().body(dtoList);
    }

    // FindById
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO>  findById(@PathVariable Long id) {
        User usuario = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(usuario));
    }

    // Insert
    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) {
        User obj = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDTO(obj));
    }

    // Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // noContent() -> Retorna 204, que é o status code de uma resposta sem conteúdo.
    }

    // Update
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody User obj) {
         obj = service.update(id, obj);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
