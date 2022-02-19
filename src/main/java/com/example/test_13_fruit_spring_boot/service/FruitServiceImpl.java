package com.example.test_13_fruit_spring_boot.service;

import com.example.test_13_fruit_spring_boot.model.Fruit;
import com.example.test_13_fruit_spring_boot.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Iterable<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Optional<Fruit> findById(Long id) {
        return fruitRepository.findById(id);
    }

    @Override
    public void save(Fruit fruit) {
        fruitRepository.save(fruit);
    }

    @Override
    public void remove(Long id) {
        fruitRepository.deleteById(id);
    }
}
