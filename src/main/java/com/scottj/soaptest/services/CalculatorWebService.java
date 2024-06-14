package com.scottj.soaptest.services;

import jakarta.jws.WebMethod;

public interface CalculatorWebService {
    @WebMethod
    public int add(int a, int b);
//    public int subtract(int a, int b);
//    public int multiply(int a, int b);
//    public int divide(int a, int b);
}
