package com.alzamora.tipoCambio.controller;

import com.alzamora.tipoCambio.entity.Currency;
import com.alzamora.tipoCambio.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.OPTIONS})
@RequestMapping(value = "/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<List<Currency>> listCurrency(){
        List<Currency> currencies = currencyService.listAllCurrency();
        if(currencies.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(currencies);
    }
}
