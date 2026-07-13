package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.dtos.requests.WordCreateDto;
import com.example.fleshcardservice.dtos.requests.WordUpdateRequestDto;
import com.example.fleshcardservice.dtos.responses.WordFullResponseDto;
import com.example.fleshcardservice.dtos.responses.WordShortResponseDto;
import com.example.fleshcardservice.services.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.fleshcardservice.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/word")
public class WordController extends AbstractController<WordService>{

    protected WordController(WordService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody WordCreateDto dto) {
        service.create(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody WordUpdateRequestDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<WordFullResponseDto>  getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<WordShortResponseDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
