package com.upgrad.booking.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upgrad.booking.entities.Booking;

@FeignClient(name = "payment-service",url = "http://localhost:8082")
public interface Bookingserverclient {

    @RequestMapping(value = "/payment/v1/payment/{bookingId}/payment/{bookingId}", method = RequestMethod.GET)
    
    public Booking getBooking(@PathVariable("bookingId") int bookingId);
}
