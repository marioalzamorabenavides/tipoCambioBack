package com.alzamora.tipoCambio.service;

import com.alzamora.tipoCambio.entity.Currency;
import com.alzamora.tipoCambio.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public List<Currency> listAllCurrency() {
        return currencyRepository.findAll();
    }
}
