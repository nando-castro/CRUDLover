package com.cars.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dto.CarDTO;
import com.cars.api.model.Car;
import com.cars.api.repository.CarRepository;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/cars")
public class Cars {

    @Autowired
    private CarRepository repository;

    @PostMapping
    public void createCar(@RequestBody @Valid CarDTO req) {
        repository.save(new Car(req));
    }

    @GetMapping
    public List<Car> getCars(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody CarDTO req){
        repository.findById(id).map(car -> {
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setDataFabricacao(req.dataFabricacao());
            car.setValor(req.valor());
            car.setAnoModelo(req.anoModelo());

            return repository.save(car);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
