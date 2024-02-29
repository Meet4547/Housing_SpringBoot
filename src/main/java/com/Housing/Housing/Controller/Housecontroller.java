package com.Housing.Housing.Controller;

import com.Housing.Housing.Entity.House;
import com.Housing.Housing.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/housing")
public class Housecontroller {
    @Autowired
    HouseService houseService;



    @PostMapping("/add")
    public ResponseEntity<String> addhouse(@RequestBody List<House> data) {
        try {
            houseService.adddata(data);
            return ResponseEntity.ok("Housing data added successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding housing data: " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Integer> average() {
        try {
            int averageSalePrice = houseService.Averagesaleprice();
            return ResponseEntity.ok(averageSalePrice);
        } catch (Exception e) {
            // Handle any exceptions and return an appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1); // or any other default value
        }
    }

    @GetMapping("/avgByLocation")
    public List<Object> AverageByLocation(){
        return houseService.AverageByLocation();
    }
    @GetMapping("/maxPrice")
    public List<Object> maxsaleprice(){
        return houseService.maxsaleprice();
    }

    @GetMapping("/minPrice")
    public List<Object> minsaleprice(){
        return houseService.minsaleprice();
    }

}