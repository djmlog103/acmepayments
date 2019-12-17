package com.dilupa.acmepayment.controllers;

import com.dilupa.acmepayment.models.Payment;
import com.dilupa.acmepayment.services.PaymentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @GetMapping("/")
  public String paymentForm(Model model) {
    List<Payment> payments = paymentService.getAllPayments();
    model.addAttribute("payments", payments);
    model.addAttribute("payment", new Payment());

    return "home";
  }

  @PostMapping("/makePayment")
  public String makePayment(Model model, RedirectAttributes attributes, @Valid @ModelAttribute Payment payment, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      List<Payment> payments = paymentService.getAllPayments();
      model.addAttribute("payments", payments);
      return "home";
    }

    paymentService.savePayment(payment);
    System.out.println(payment.getId());
    return "redirect:/";
  }
}
