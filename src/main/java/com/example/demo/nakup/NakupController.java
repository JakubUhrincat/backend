package com.example.demo.nakup;

import com.example.demo.polozka.PolozkaDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class NakupController {

    private NakupService nakupService;

    public NakupController(NakupService nakupService) {
        this.nakupService = nakupService;
    }

    @GetMapping("/api/nakupy")
    public List<NakupDto> getNakupy(@RequestParam(required = false) Long id) {
        return nakupService.getNakupy(id);
    }

    @GetMapping("/api/nakupy/{id}")
    public NakupDto getNakup(@PathVariable Long id) {
        return nakupService.getNakup(id);
    }

    @PostMapping("/api/nakupy")
    public Long createNakup(@RequestBody NakupDto nakup){
        return nakupService.createNakup(nakup);
    }


    @PutMapping("/api/nakupy/{id}")
    public void updateNakup(@PathVariable Long id, @RequestBody NakupDto nakupDto) { nakupService.updateNakup(id,nakupDto);}
    //DELETE CUSTOMER
    @DeleteMapping("/api/nakupy/{id}")
    public void deleteNakup(@PathVariable Long id){
        nakupService.deleteNakup(id);
    }
}
