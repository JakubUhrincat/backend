package com.example.demo.nakup;

import com.example.demo.polozka.Polozka;
import com.example.demo.polozka.PolozkaEntity;
import com.example.demo.polozka.PolozkaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class NakupService {

    private PolozkaRepository polozkaRepository;

    private NakupRepository nakupRepository;

    private static NakupDto mapToNakupDto(NakupEntity nakupEntity){
        NakupDto nakupDto = new NakupDto();

        nakupDto.setId(nakupEntity.getId());
        nakupDto.setDatum(nakupEntity.getDatum());
        nakupDto.setObchod(nakupEntity.getObchod());
        nakupDto.setPolozkaId(nakupEntity.getPolozka().getId());
        nakupDto.setNazov(nakupEntity.getPolozka().getNazov());
        nakupDto.setCena(nakupEntity.getPolozka().getCena());


        return nakupDto;
    }

    public NakupService(NakupRepository nakupRepository, PolozkaRepository polozkaRepository) {
        this.nakupRepository = nakupRepository;
        this.polozkaRepository = polozkaRepository;

    }

    @Transactional
    public Long createNakup(NakupDto nakupDto){
        NakupEntity nakupEntity = new NakupEntity();

        Optional<PolozkaEntity> polozka = polozkaRepository.findById(nakupDto.getPolozkaId());
        nakupEntity.setObchod(nakupDto.getObchod());
        nakupEntity.setDatum(nakupDto.getDatum());
        nakupEntity.setPolozka(polozka.get());

        this.nakupRepository.save(nakupEntity);
        return nakupEntity.getId();
    }

    @Transactional
    public NakupDto getNakup(Long id){
        Optional<NakupEntity> byId = nakupRepository.findById(id);
        if(byId.isPresent()){
            return  mapToNakupDto(byId.get());
        }
        return null;
    }

    @Transactional
    public List<NakupDto> getNakupy(Long id) {
        List<NakupDto> nakupy = new LinkedList<>();
        for (NakupEntity b1 : nakupRepository.findAll()) {
            NakupDto b2 = mapToNakupDto(b1);
            nakupy.add(b2);
        }
        return nakupy;
    }

    @Transactional
    public void updateNakup(Long id,NakupDto nakupDto){
        Optional<NakupEntity> byId = nakupRepository.findById(id);
        if(byId.isPresent()){
            byId.get().setDatum(nakupDto.getDatum());
            byId.get().setObchod(nakupDto.getObchod());
            byId.get().setPolozka(polozkaRepository.findById(nakupDto.getPolozkaId()).get());
        }
    }
    @Transactional
    public void deleteNakup(Long id){
        Optional<NakupEntity> byId = nakupRepository.findById(id);
        if (byId.isPresent()) {
            nakupRepository.delete(byId.get());
        }
    }

}
