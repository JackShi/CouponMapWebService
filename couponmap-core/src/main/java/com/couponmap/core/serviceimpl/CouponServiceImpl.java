package com.couponmap.core.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.couponmap.core.dao.CouponDao;
import com.couponmap.core.entity.Coupon;
import com.couponmap.core.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

	 private CouponDao couponDao;

	 @Transactional(readOnly = false)
	 public Coupon create(Coupon coupon) {
	  return getCouponDao().create(coupon);
	 }

	 @Transactional(readOnly = true)
	 public List<Coupon> getAll() {
	  return getCouponDao().getAll();
	 }

	 @Transactional(readOnly = false)
	 public void delete(Long id) {
	  getCouponDao().delete(id);
	 }

	 @Transactional(readOnly = false)
	 public Coupon update(Coupon coupon) {
	  return getCouponDao().update(coupon);
	 }

	 @Transactional(readOnly = false)
	 public Coupon find(Long id) {
	  return getCouponDao().find(id);
	 }

	 @Transactional(readOnly = true)
	 public Long count() {
	  return getCouponDao().count();
	 }

	private CouponDao getCouponDao() {
		return couponDao;
	}

	@Inject
	private void setCouponDao(CouponDao couponDao) {
		this.couponDao = couponDao;
	}

}
