package com.couponmap.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.couponmap.core.entity.Coupon;
import com.couponmap.core.service.CouponService;

import javax.inject.Inject;


@Controller
@RequestMapping("/rest-services/coupon")
public class CouponRestService {
 
 private static final Logger LOGGER = LoggerFactory.getLogger(CouponService.class);
 
 private CouponService couponService;

 /*
 @RequestMapping(method = RequestMethod.GET)
 @ResponseBody
 public Coupons loadCoupons() {
  
  Coupons couponWrapper = new Coupons();
  couponWrapper.setCoupons(couponService.getAll());
  
 // LOGGER.info("--- Coupon list retrieved ---");
  return couponWrapper;
 }
 */
 @RequestMapping(method = RequestMethod.GET)
 @ResponseBody
 public List<Coupon> loadCoupons() {
  return couponService.getAll();
 }
 
 
 @RequestMapping(method = RequestMethod.POST)
 @ResponseBody
 public Coupon addCoupon(@RequestBody Coupon coupon) {
  
  Coupon newCoupon = getCouponService().create(coupon);
  
  //LOGGER.info("--- New coupon saved ---");
  return newCoupon;
 }
 
 @RequestMapping(value = "/{couponId}", method = RequestMethod.PUT)
 @ResponseBody
 public Coupon updateCoupon(@PathVariable(value = "couponId") Integer couponId, @RequestBody Coupon coupon) {
  
  Coupon newCoupon = getCouponService().update(coupon);
  
  //LOGGER.info("--- Coupon updated ---");
  return newCoupon;
 }
 
 @RequestMapping(value = "/{couponId}", method = RequestMethod.GET)
 @ResponseBody
 public Coupon findCoupon(@PathVariable(value = "couponId") Long couponId) {
  
  Coupon foundCoupon = getCouponService().find(couponId);
  
  LOGGER.info("--- Coupon found ---");
  return foundCoupon;
 }
 
 @RequestMapping(value = "/{couponId}", method = RequestMethod.DELETE)
 @ResponseBody
 public void deleteCoupon(@PathVariable(value = "couponId") Long couponId) {
  
  getCouponService().delete(couponId);
 // LOGGER.info("--- Coupon deleted ---");
 }

public CouponService getCouponService() {
	return couponService;
}

@Inject
public void setCouponService(CouponService couponService) {
	this.couponService = couponService;
}
 
}