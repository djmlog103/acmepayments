package com.dilupa.acmepayment.repository;

import com.dilupa.acmepayment.models.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {

}
