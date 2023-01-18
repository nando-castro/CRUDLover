package com.cars.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dto.CarDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/cars")
public class Cars {

    String modelo;
    String fabricante;
    String dataFabricacao;
    double valor;
    int anoModelo;

    @PostMapping
    public void createCar(@RequestBody CarDTO req) {
        modelo = req.modelo();
        fabricante = req.fabricante();
        dataFabricacao = req.dataFabricacao();
        valor = req.valor();
        anoModelo = req.anoModelo();
        System.out.println(req);
        System.out.println(req.modelo());
        System.out.println(req.anoModelo());
    }

    @GetMapping
    public String getCars() {
        return "{ " + modelo + " / " + fabricante + " / " + dataFabricacao + " / " + valor + " / " + anoModelo + " }";
    }
}
