package com.couponmap.core.dao;

import java.util.List;

import com.couponmap.core.entity.Coupon;

public interface CouponDao extends GenericDao<Coupon> {
	public List<Coupon> listCouponsByStoreName(String storeName);

	public List<Coupon> listCouponsByLocationAndDistance(Double latitude,
			Double longitude, Double distance);

}
