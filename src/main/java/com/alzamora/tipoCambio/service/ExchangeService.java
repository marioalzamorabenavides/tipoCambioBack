package com.alzamora.tipoCambio.service;

import com.alzamora.tipoCambio.dto.ReqExchange;
import com.alzamora.tipoCambio.dto.ReqExchangeUpdate;
import com.alzamora.tipoCambio.dto.ResExchange;
import com.alzamora.tipoCambio.entity.Exchange;

import java.util.List;

public interface ExchangeService {
    public List<Exchange> listAllExchange();
    public List<Exchange> listExchangeById(Long exchangeId);
    public ResExchange convertAmountExchange(ReqExchange exchange);
    public Exchange updateRateExchange(Long exchangeId, ReqExchangeUpdate data);
}
