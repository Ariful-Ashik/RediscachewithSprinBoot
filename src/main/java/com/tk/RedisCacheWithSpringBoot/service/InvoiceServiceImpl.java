package com.tk.RedisCacheWithSpringBoot.service;

import com.tk.RedisCacheWithSpringBoot.exception.InvoiceNotFoundException;
import com.tk.RedisCacheWithSpringBoot.model.Invoice;
import com.tk.RedisCacheWithSpringBoot.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Override
    @CacheEvict(value = "Invoice", allEntries = true)
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepo.save(invoice);
    }


    @Override
    @CachePut(value = "Invoice", key = "#invId")
    @CacheEvict(value = "Invoice", allEntries = true)
    public Invoice updateInvoice(Invoice invoice, Integer invId) {
        Invoice invoice1 = invoiceRepo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
        invoice1.setInvAmount(invoice.getInvAmount());
        invoice1.setInvName(invoice.getInvName());
        return invoiceRepo.save(invoice);
    }

    @Override
//    @CacheEvict(value = "Invoice", key = "#invId")
    @CacheEvict(value = "Invoice", allEntries = true)
    public void deleteInvoice(Integer invId) {
        Invoice invoice = invoiceRepo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
        invoiceRepo.delete(invoice);
    }

    @Override
    @Cacheable (value = "Invoice", key="#invId")
    public Invoice getOneInvoice(Integer invId) {
        Invoice invoice = invoiceRepo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
        return invoice;
//        return invoiceRepo.getOne(invId);
    }

    @Override
    @Cacheable(value = "Invoice")
    public List<Invoice> getAllInvoice() {
        return invoiceRepo.findAll();
    }
}
