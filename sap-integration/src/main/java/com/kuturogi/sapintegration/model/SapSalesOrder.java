package com.kuturogi.sapintegration.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class SapSalesOrder {
    private String sapDocumentNumber;   // SAP belge no: 0000012345
    private Long ecomOrderId;           // Bizim order ID'miz
    private String customerId;          // SAP customer ID
    private String salesOrg;            // Satış organizasyonu: TR01
    private String distributionChannel; // Dağıtım kanalı: 10
    private String division;            // Bölüm: 00
    private BigDecimal netValue;        // Net tutar
    private String currency;            // Para birimi: TRY
    private String status;              // SAP statüsü: OPEN / TRANSFERRED
    private LocalDateTime createdAt;
    private LocalDateTime transferredAt;
}
