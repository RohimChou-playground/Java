package com.rohim.contact.infra;

import com.rohim.contact.core.ContactCore;

public class ContactInfra {
  public ContactInfra() {
    new ContactCore();
    
    System.out.println("ContactInfra Constructor");
  }
}
