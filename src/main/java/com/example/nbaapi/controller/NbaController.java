package com.example.nbaapi.controller;

import com.example.nbaapi.dto.NbaResponsive;
import com.example.nbaapi.service.NbaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nba")
public class NbaController {

    public NbaService nbaService;

    public NbaController(NbaService nbaService) {
        this.nbaService = nbaService;
    }

    @GetMapping
    public NbaResponsive getNbaResponsive() {
        return nbaService.getNbaResponsive();
    }

}
