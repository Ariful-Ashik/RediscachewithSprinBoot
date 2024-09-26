package com.tk.RedisCacheWithSpringBoot.service;

import com.tk.RedisCacheWithSpringBoot.model.Invoice;

import java.util.List;

public interface InvoiceService {

    public Invoice saveInvoice(Invoice invoice);
    public Invoice getOneInvoice(Integer invoiceId);
    public Invoice updateInvoice(Invoice invoice, Integer invId );
    public void deleteInvoice(Integer invId);
    public List<Invoice> getAllInvoice();
}
