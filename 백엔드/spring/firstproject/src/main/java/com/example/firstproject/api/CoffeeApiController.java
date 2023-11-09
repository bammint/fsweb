package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import com.example.firstproject.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CoffeeApiController {

    private final CoffeeService coffeeService;

    // Get
    @GetMapping("/api/coffees")
    public Iterable<Coffee> index(){
        return coffeeService.index();
    }

    @GetMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> show(@PathVariable Long id){
        Coffee coffee = coffeeService.show(id);
        return (coffee != null)?
                ResponseEntity.status(HttpStatus.OK).body(coffee):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    // post
    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeDto coffeeDto){
        Coffee created = coffeeService.create(coffeeDto);
        return (created != null)?
                ResponseEntity.status(HttpStatus.CREATED).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // patch(update)
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeDto coffeeDto){
        Coffee coffee = coffeeDto.toEntity();
        log.info("id: {}, coffee: {}", id, coffee.toString());

        Coffee target = coffeeService.show(id);

        if(target == null || id != coffee.getId()){
            log.info("잘못된 요청! id: {}, coffee: {}", id, coffee.toString());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
        target.patch(coffee);
        Coffee updated = coffeeService.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // delete
    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id){
        Coffee target = coffeeService.show(id);

        if(target == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
        coffeeService.delete(target);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
