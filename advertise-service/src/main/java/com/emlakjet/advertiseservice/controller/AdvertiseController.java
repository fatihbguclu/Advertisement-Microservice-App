package com.emlakjet.advertiseservice.controller;

import com.emlakjet.advertiseservice.service.AdvertiseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/advertises")
public class AdvertiseController {

    private final AdvertiseService advertiseService;

    public AdvertiseController(AdvertiseService advertiseService) {
        this.advertiseService = advertiseService;
    }

}