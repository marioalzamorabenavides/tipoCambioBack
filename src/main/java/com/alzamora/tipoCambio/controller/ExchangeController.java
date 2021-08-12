package com.alzamora.tipoCambio.controller;

import com.alzamora.tipoCambio.dto.ReqExchange;
import com.alzamora.tipoCambio.dto.ReqExchangeUpdate;
import com.alzamora.tipoCambio.dto.ResExchange;
import com.alzamora.tipoCambio.entity.Exchange;
import com.alzamora.tipoCambio.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS})
@RequestMapping(value = "/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping
    public ResponseEntity<List<Exchange>> listExchangeById(@RequestParam(name = "exchangeFrom", required = false) Long exchangeFrom){
        if(exchangeFrom!=null){
            List<Exchange> exchange = exchangeService.listExchangeById(exchangeFrom);
            if(exchange.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(exchange);
        }else{
            List<Exchange> exchange = exchangeService.listAllExchange();
            if(exchange.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(exchange);
        }
    }

    @PostMapping
    public ResponseEntity<ResExchange> convertExchange(@RequestBody ReqExchange data){
        return ResponseEntity.ok(exchangeService.convertAmountExchange(data));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Exchange> updateRateExchange(@PathVariable Long id, @RequestBody ReqExchangeUpdate data){
        if (exchangeService.updateRateExchange(id, data)==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exchangeService.updateRateExchange(id, data));
    }
}
