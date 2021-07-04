package com.example.pjatk.gold.service;

import com.example.pjatk.gold.model.GoldValue;
import com.example.pjatk.gold.model.Rate;
import com.example.pjatk.gold.model.Root;
import com.example.pjatk.gold.repository.NbpRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class GoldService {
    private final RestTemplate restTemplate;
    private final NbpRepository nbpRepository;

    public GoldService(RestTemplate restTemplate, NbpRepository nbpRepository) {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;
    }

    public GoldValue calculateValues(Date dateStart, Date dateEnd) {
        String url = "http://api.nbp.pl/api/cenyzlota/" + dateStart + "/" + dateEnd;
        Root root = restTemplate.getForObject(url, Root.class);
        double average = calculate(root.getRates());
        GoldValue goldValue = getGoldValue(dateStart, dateEnd, average);
        return nbpRepository.save(goldValue);

    }

    private GoldValue getGoldValue(Date dateStart, Date dateEnd, double calculate) {
        GoldValue goldValue = new GoldValue();
        goldValue.setValue(calculate);
        goldValue.setDateStart(dateStart);
        goldValue.setDateEnd(dateEnd);
        goldValue.setCreatedAt(LocalDateTime.now());
        return goldValue;
    }


    public double calculate(List<Rate> rateList) {
        return rateList.stream()
                .mapToDouble(Rate::getPrice)
                .average()
                .orElse(0.0d);
    }
}
