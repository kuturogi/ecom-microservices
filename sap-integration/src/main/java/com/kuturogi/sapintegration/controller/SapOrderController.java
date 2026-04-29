package com.kuturogi.sapintegration.controller;

import com.kuturogi.sapintegration.model.SapSalesOrder;
import com.kuturogi.sapintegration.service.SapErpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sap/orders")
@RequiredArgsConstructor
@Tag(name = "SAP Sales Orders", description = "SAP ERP'ye aktarılan satış siparişleri")
public class SapOrderController {

    private final SapErpService sapErpService;

    @GetMapping
    @Operation(summary = "Tüm SAP siparişlerini listele", description = "SAP ERP'ye aktarılmış tüm satış siparişlerini döner")
    public List<SapSalesOrder> getAllSapOrders() {
        return sapErpService.getAllOrders();
    }

    @GetMapping("/{sapDocNumber}")
    @Operation(summary = "SAP belge numarasına göre sipariş getir")
    public ResponseEntity<SapSalesOrder> getByDocNumber(@PathVariable String sapDocNumber) {
        return sapErpService.getOrderByDocNumber(sapDocNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ecom/{orderId}")
    @Operation(summary = "E-commerce sipariş ID'sine göre SAP kaydını getir")
    public ResponseEntity<SapSalesOrder> getByEcomOrderId(@PathVariable Long orderId) {
        return sapErpService.getOrderByEcomId(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
