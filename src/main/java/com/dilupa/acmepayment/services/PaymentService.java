package com.dilupa.acmepayment.services;

import com.dilupa.acmepayment.models.Invoice;
import com.dilupa.acmepayment.models.Payment;
import com.dilupa.acmepayment.repository.InvoiceRepository;
import com.dilupa.acmepayment.repository.PaymentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  @Autowired
  private InvoiceRepository invoiceRepository;

  public void savePayment(Payment payment) {
    Invoice invoice = new Invoice();
    invoice.setDescription("Invoice made for " + payment.getEmail());
    invoice.setEmail(payment.getEmail());

    invoiceRepository.save(invoice);

    payment.setInvoiceId(invoice.getId());
    paymentRepository.save(payment);
  }

  public Payment getPaymentById(Integer id) {
    Optional<Payment> payment = paymentRepository.findById(id);
    return payment.get();
  }

  public List<Payment> getAllPayments() {
    List<Payment> payments = new ArrayList<Payment>();
    paymentRepository.findAll().forEach(payments::add);

    return payments;
  }
}
