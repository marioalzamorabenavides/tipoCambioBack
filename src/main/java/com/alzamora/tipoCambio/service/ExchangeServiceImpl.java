package com.alzamora.tipoCambio.service;

import com.alzamora.tipoCambio.dto.ReqExchange;
import com.alzamora.tipoCambio.dto.ReqExchangeUpdate;
import com.alzamora.tipoCambio.dto.ResExchange;
import com.alzamora.tipoCambio.entity.Exchange;
import com.alzamora.tipoCambio.repository.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    private final ExchangeRepository exchangeRepository;

    @Override
    public List<Exchange> listAllExchange() {
        return exchangeRepository.findAll();
    }

    @Override
    public List<Exchange> listExchangeById(Long exchangeId) {
        return exchangeRepository.findExchangeByCurrencyChangeFrom(exchangeId);
    }

    @Override
    public ResExchange convertAmountExchange(ReqExchange exchange) {
        Exchange exchangeRes = exchangeRepository.finExchangedByCurrencyChangeFromAndCurrencyChangeTo(exchange);
        ResExchange resExchange = new ResExchange();

        resExchange.setAmountTypeExchange(exchangeRes.getExchange_rate().multiply(exchange.getAmount()));
        resExchange.setAmount(exchange.getAmount());
        resExchange.setExchangeRate(exchangeRes.getExchange_rate());
        resExchange.setCurrencyTo(exchange.getCurrencyTo());
        resExchange.setCurrencyFrom(exchange.getCurrencyFrom());
        return resExchange;
    }

    @Override
    public Exchange updateRateExchange(Long exchangeId, ReqExchangeUpdate data) {
        Exchange exchange = exchangeRepository.getById(exchangeId);
        if(data.equals(null)){
            return null;
        }
        exchange.setExchange_rate(data.getExchangeRate());
        exchange.setExchange_update(new Date());
        return exchangeRepository.save(exchange);
    }
}
