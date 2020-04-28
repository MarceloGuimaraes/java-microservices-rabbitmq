package com.guimasoftware.interfaces.rest;

import com.guimasoftware.domain.OrderRequest;
import com.guimasoftware.interfaces.error.ApiError;
import com.guimasoftware.interfaces.error.GenericApiException;
import com.guimasoftware.application.OrderRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class OrderRequestController {

    @Autowired
    private OrderRequestService orderRequestService;


    @PostMapping(path = "/requestorder")
    public ResponseEntity orderRequest(@Valid @RequestBody OrderRequest orderRequest, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        try {
            orderRequestService.auditToQueue(orderRequest);
            return new ResponseEntity(HttpStatus.CREATED);

        }catch (GenericApiException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new ApiError(ex));
        }
    }

    @GetMapping(path = "/order")
    public ResponseEntity<List<OrderRequest>> listOrderRequest() {
            List<OrderRequest> orders = Arrays.asList(
                    new OrderRequest("client1","11111111","mail1@guimasoftware.com", OrderRequest.Status.CONFIRMADO, 111),
                    new OrderRequest("client2","22222222","mail2@guimasoftware.com", OrderRequest.Status.ENTREGUE,222),
                    new OrderRequest("client3","33333333","mail3@guimasoftware.com",OrderRequest.Status.PAGO,333),
                    new OrderRequest("client4","44444444","mail4@guimasoftware.com",OrderRequest.Status.PAGO,333)
                    );
        return ResponseEntity.ok(orders);
    }
}
