package com.payment.controller;

import com.payment.model.Request;
import com.payment.model.Response;
import com.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "generate-plan")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Response> processPayment(@RequestBody final Request request) throws Exception {
        return paymentService.processPayment(request);
    }
}