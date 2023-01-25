package com.example.demo.polozka;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PolozkaController {
    private PolozkaService polozkaService;

    public PolozkaController(PolozkaService polozkaService){
        this.polozkaService = polozkaService;
    }


    @PostMapping("/api/polozky")
    public Long createPolozka(@RequestBody PolozkaDto polozka){ return polozkaService.createPolozka(polozka);
    }


    @GetMapping("/api/polozky")
    public List<PolozkaDto> getPolozky(@RequestParam(required = false) String nazov){
        return polozkaService.getPolozky(nazov);
    }


    @GetMapping("/api/polozky/{id}")
    public PolozkaDto getPolozka(@PathVariable Long id){
        return polozkaService.getPolozka(id);
    }


    @PutMapping("/api/polozky/{id}")
    public void updatePolozka(@PathVariable Long id, @RequestBody Polozka polozka){
        polozkaService.updatePolozka(id, polozka);
    }


    @DeleteMapping("/api/polozky/{id}")
    public void deletePolozka(@PathVariable Long id){
        polozkaService.deletePolozka(id);
    }
}
