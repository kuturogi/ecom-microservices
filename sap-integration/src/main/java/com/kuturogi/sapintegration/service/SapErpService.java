package com.kuturogi.sapintegration.service;

import com.kuturogi.sapintegration.model.SapSalesOrder;
import com.kuturogi.sapintegration.payload.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class SapErpService {

    private final Map<String, SapSalesOrder> sapOrders = new ConcurrentHashMap<>();
    private final AtomicLong docCounter = new AtomicLong(1000000000L);

    public SapSalesOrder transferOrderToSap(OrderCreatedEvent event) {
        String sapDocNumber = String.format("%010d", docCounter.incrementAndGet());

        log.info("====================================================");
        log.info("SAP ERP TRANSFER BAŞLADI");
        log.info("E-Commerce Order ID  : {}", event.getOrderId());
        log.info("Customer ID          : {}", event.getUserId());
        log.info("Net Tutar            : {} TRY", event.getTotalAmount());
        log.info("Ürün Sayısı          : {}", event.getItems().size());
        log.info("----------------------------------------------------");
        log.info("SAP RFC BAPI_SALESORDER_CREATEFROMDAT2 çağrılıyor...");
        log.info("Sales Org: TR01 | Dist. Channel: 10 | Division: 00");
        log.info("----------------------------------------------------");
        log.info("SAP BELGE NUMARASI OLUŞTURULDU: {}", sapDocNumber);
        log.info("SAP Statüsü: OPEN");
        log.info("====================================================");

        SapSalesOrder sapOrder = SapSalesOrder.builder()
                .sapDocumentNumber(sapDocNumber)
                .ecomOrderId(event.getOrderId())
                .customerId(event.getUserId())
                .salesOrg("TR01")
                .distributionChannel("10")
                .division("00")
                .netValue(event.getTotalAmount())
                .currency("TRY")
                .status("OPEN")
                .createdAt(event.getCreatedAt())
                .transferredAt(LocalDateTime.now())
                .build();

        sapOrders.put(sapDocNumber, sapOrder);
        return sapOrder;
    }

    public List<SapSalesOrder> getAllOrders() {
        return new ArrayList<>(sapOrders.values());
    }

    public Optional<SapSalesOrder> getOrderByDocNumber(String docNumber) {
        return Optional.ofNullable(sapOrders.get(docNumber));
    }

    public Optional<SapSalesOrder> getOrderByEcomId(Long ecomOrderId) {
        return sapOrders.values().stream()
                .filter(o -> o.getEcomOrderId().equals(ecomOrderId))
                .findFirst();
    }
}
