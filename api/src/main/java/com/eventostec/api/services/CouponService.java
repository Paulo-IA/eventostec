package com.eventostec.api.services;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.repositories.CouponRepository;
import com.eventostec.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class CouponService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CouponRepository couponRepository;

    public Coupon createCoupon(CouponRequestDTO data) {
        Coupon newCoupon = new Coupon();
        newCoupon.setCode(data.code());
        newCoupon.setDiscount(data.discount());
        newCoupon.setValid(new Date(data.valid()));
        // Get event on DB

        Event event = eventRepository.getReferenceById(data.event_id());
        newCoupon.setEvent(event);

        return newCoupon;
    }
}
