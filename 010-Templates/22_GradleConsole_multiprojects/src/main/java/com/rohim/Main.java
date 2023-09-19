package com.rohim;

import com.rohim.contact.infra.ContactInfra;
import com.rohim.customer.infra.CustomerInfra;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    new ContactInfra();
    new CustomerInfra();
  }
}