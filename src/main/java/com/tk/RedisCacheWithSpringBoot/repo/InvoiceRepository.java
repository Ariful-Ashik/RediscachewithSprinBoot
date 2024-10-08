package com.tk.RedisCacheWithSpringBoot.repo;

import com.tk.RedisCacheWithSpringBoot.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
