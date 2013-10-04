package com.couponmap.core.service;

import java.util.List;

import com.couponmap.core.entity.Coupon;

public interface CouponService {

	public Coupon create(Coupon coupon);

	public void delete(Long id);

	public Coupon update(Coupon coupon);

	public Coupon find(Long id);

	public List<Coupon> getAll();

	public Long count();

	public List<Coupon> findCouponsByStoreName(String storeName);

	public List<Coupon> findNearCoupons(Double latitude, Double longitude,
			Double distance);
}