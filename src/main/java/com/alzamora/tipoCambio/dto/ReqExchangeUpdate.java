package com.alzamora.tipoCambio.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ReqExchangeUpdate {
    private BigDecimal exchangeRate;
}
