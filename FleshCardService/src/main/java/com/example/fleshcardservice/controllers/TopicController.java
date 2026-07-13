package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.dtos.requests.TopicCreateDto;
import com.example.fleshcardservice.dtos.requests.TopicUpdateDto;
import com.example.fleshcardservice.dtos.responses.TopicResponseDto;
import com.example.fleshcardservice.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.fleshcardservice.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH +"/topic")
public class TopicController extends AbstractController<TopicService> {

    protected TopicController(TopicService service) {
        super(service);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody @Valid TopicCreateDto dto) {
        service.create(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<TopicResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TopicResponseDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody TopicUpdateDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
