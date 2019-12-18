package com.dilupa.acmepayment.controllers;

import com.dilupa.acmepayment.models.Invoice;
import com.dilupa.acmepayment.services.InvoiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {

  @Autowired
  private InvoiceService invoiceService;

  @GetMapping("/invoices")
  public String listInvoices(Model model) {
    List<Invoice> invoices = invoiceService.getAllInvoices();
    model.addAttribute("invoices", invoices);

    return "invoices";
  }
}
