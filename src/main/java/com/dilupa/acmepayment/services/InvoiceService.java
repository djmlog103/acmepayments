package com.dilupa.acmepayment.services;

import com.dilupa.acmepayment.models.Invoice;
import com.dilupa.acmepayment.repository.InvoiceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  public List<Invoice> getAllInvoices() {
    List<Invoice> invoices = new ArrayList<Invoice>();
    invoiceRepository.findAll().forEach(invoices::add);

    return invoices;
  }
}
