package com.rohim.customer.infra;

import com.rohim.customer.core.CustomerCore;

public class CustomerInfra {
  public CustomerInfra() {
    new CustomerCore();
    System.out.println("CustomerInfra Constructor");
  }
}
