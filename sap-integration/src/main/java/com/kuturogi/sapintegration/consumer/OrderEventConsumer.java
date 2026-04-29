package com.kuturogi.sapintegration.consumer;

import com.kuturogi.sapintegration.model.SapSalesOrder;
import com.kuturogi.sapintegration.payload.OrderCreatedEvent;
import com.kuturogi.sapintegration.service.SapErpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderEventConsumer {

    private final SapErpService sapErpService;

    @Bean
    public Consumer<OrderCreatedEvent> orderCreated() {
        return event -> {
            log.info("Kafka'dan sipariş eventi alındı. Order ID: {}", event.getOrderId());
            SapSalesOrder sapOrder = sapErpService.transferOrderToSap(event);
            log.info("SAP transfer tamamlandı. SAP Belge No: {}", sapOrder.getSapDocumentNumber());
        };
    }
}
