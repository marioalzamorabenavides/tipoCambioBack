package com.alzamora.tipoCambio.repository;

import com.alzamora.tipoCambio.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
