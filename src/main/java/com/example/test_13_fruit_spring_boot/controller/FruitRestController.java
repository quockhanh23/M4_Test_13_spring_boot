package com.example.test_13_fruit_spring_boot.controller;

import com.example.test_13_fruit_spring_boot.model.Category;
import com.example.test_13_fruit_spring_boot.model.Fruit;
import com.example.test_13_fruit_spring_boot.service.CategoryService;
import com.example.test_13_fruit_spring_boot.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/fruits")
public class FruitRestController {
    @Autowired
    private FruitService fruitService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Fruit>> findAllFruit() {
        Iterable<Fruit> fruits = fruitService.findAll();
        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fruit> findFruitById(@PathVariable Long id) {
        Optional<Fruit> fruitOptional = fruitService.findById(id);
        if (!fruitOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fruitOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fruit> deleteFruitById(@PathVariable Long id) {
        Optional<Fruit> fruitOptional = fruitService.findById(id);
        if (!fruitOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        fruitService.remove(id);
        return new ResponseEntity<>(fruitOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fruit> saveFruit(@PathVariable Long id, @RequestBody Fruit fruit) {
        Optional<Fruit> blogOptional = fruitService.findById(id);
        fruit.setId(blogOptional.get().getId());
        fruitService.save(fruit);
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Fruit> saveFruit(@RequestBody Fruit fruit) {
        fruitService.save(fruit);
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }
}
