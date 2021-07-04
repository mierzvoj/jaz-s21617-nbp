package com.example.pjatk.gold.controller;

import com.example.pjatk.gold.model.GoldValue;
import com.example.pjatk.gold.service.GoldService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/nbp")
public class NbpController {


    private final GoldService goldService;

    public NbpController(GoldService goldService) {
        this.goldService = goldService;
    }

    @ApiOperation(value = "get gold prices", response = GoldValue.class, notes = "This method will return gold price calculations")

    @GetMapping(value = "/{dateStart}/{dateEnd}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoldValue> calculateValues(
            @ApiParam(name = "dateStart",
                    type = "date",
                    value = "input dates",
                    required = true,
                    defaultValue = "2021-07-01")
            @RequestParam Date dateStart, @RequestParam Date dateEnd) {
        return ResponseEntity.ok(goldService.calculateValues(dateStart, dateEnd));
    }
}
