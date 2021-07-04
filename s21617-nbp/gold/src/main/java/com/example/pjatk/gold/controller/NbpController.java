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

    @GetMapping(value = "/nbp/{dateStart}/{dateEnd}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoldValue> calculateValues(
            @ApiParam(name = "gold only",
                    type = "date",
                    value = "input dates",
                    required = true,
                    defaultValue = "2021-07-01")

            @PathVariable Date dateStart, Date dateEnd) {
        return ResponseEntity.ok(goldService.calculateValues(dateStart, dateEnd));
    }
}
