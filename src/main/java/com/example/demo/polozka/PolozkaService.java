package com.example.demo.polozka;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PolozkaService {

    private final PolozkaRepository polozkaRepository;

    public PolozkaService(PolozkaRepository polozkaRepository) {this.polozkaRepository = polozkaRepository;}

    private static PolozkaDto mapToPolozkaDto(PolozkaEntity polozkaEntity){
        PolozkaDto polozkaDto = new PolozkaDto();

        polozkaDto.setId(polozkaEntity.getId());
        polozkaDto.setNazov(polozkaEntity.getNazov());
        polozkaDto.setCena(polozkaEntity.getCena());

        return polozkaDto;
    }

    @Transactional
    public Long createPolozka(PolozkaDto polozka){
        PolozkaEntity polozkaEntity = new PolozkaEntity();

        polozkaEntity.setNazov(polozka.getNazov());
        polozkaEntity.setCena(polozka.getCena());

        this.polozkaRepository.save(polozkaEntity);

        return polozkaEntity.getId();
    }

    @Transactional
    public List<PolozkaDto> getPolozky(String nazov){
        List<PolozkaDto> polozky = new LinkedList<>();
        for(PolozkaEntity p1 : polozkaRepository.findAll()){
            PolozkaDto p2 = mapToPolozkaDto(p1);
            polozky.add(p2);
        }
        return polozky;
    }

    @Transactional
    public PolozkaDto getPolozka(Long id){
        Optional<PolozkaEntity> byId = polozkaRepository.findById(id);
        if(byId.isPresent()){
            return  mapToPolozkaDto(byId.get());
        }
        return null;
    }


    @Transactional
    public void updatePolozka(Long id, Polozka polozka){
        Optional<PolozkaEntity> byId = polozkaRepository.findById(id);

        if (byId.isPresent()) {
            byId.get().setNazov(polozka.getNazov());
            byId.get().setCena(polozka.getCena());
           }

    }

    @Transactional
    public void deletePolozka(Long id){
        Optional<PolozkaEntity> byId = polozkaRepository.findById(id);

        if (byId.isPresent()) {
            polozkaRepository.delete(byId.get());
        }
    }

}



