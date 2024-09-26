package com.tk.RedisCacheWithSpringBoot.controller;


import com.tk.RedisCacheWithSpringBoot.model.Invoice;
import com.tk.RedisCacheWithSpringBoot.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")

public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/addInv")
    public Invoice saveInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Invoice>> getAllInvoice() {
        return ResponseEntity.ok(invoiceService.getAllInvoice());
    }

    @GetMapping("/getOne/{id}")
    public Invoice getInvoice(@PathVariable Integer id) {
        return invoiceService.getOneInvoice(id);
    }

    @PutMapping("/update/{id}")
    public Invoice updateInvoice(@PathVariable Integer id, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(invoice, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return "Employee with id: " + id + " " + "Deleted Successfully";
    }

}
