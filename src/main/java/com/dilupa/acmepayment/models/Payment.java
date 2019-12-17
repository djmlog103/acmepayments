package com.dilupa.acmepayment.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

/**
 * The payment payload
 */
@KeySpace("payment")
public class Payment {

  @Id
  private Integer id;

  private int invoiceId;

  @Min(value = 1, message = "Amount should not be less than 1")
  @Max(value = 100, message = "Amount should not be greater than 100")
  private int amount;

  @Email(message = "Email should be valid")
  @NotEmpty
  private String email;

  public int getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(int invoiceId) {
    this.invoiceId = invoiceId;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getId() {
    return id;
  }
}
