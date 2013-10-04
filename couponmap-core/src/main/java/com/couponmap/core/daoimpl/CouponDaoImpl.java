package com.couponmap.core.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.couponmap.core.dao.CouponDao;
import com.couponmap.core.entity.Coupon;

@Repository
public class CouponDaoImpl extends GenericDaoImpl<Coupon> implements CouponDao {
	
	public List<Coupon> listCouponsByStoreName(String storeName) {
		Query query = this.em
                .createQuery("select c FROM Coupon as c where c.storeName = :storeName");
        query.setParameter("storeName", storeName);
        List coupons = query.getResultList();
        return coupons;
	}

	@Override
	public List<Coupon> listCouponsByLocationAndDistance(Double latitude,
			Double longitude, Double distance) {
		Double minLatitude = latitude - distance;
		Double maxLatitude = latitude + distance;
		Double minLongitude = longitude - distance;
		Double maxLongitude = longitude + distance;
		
		Query query = this.em
                .createQuery("select c FROM Coupon as c where c.latitude > :minLatitude and c.latitude < :maxLatitude "
                		+ "and c.longitude > :minLongitude and c.longitude < :maxLongitude");
        query.setParameter("minLatitude", minLatitude);
        query.setParameter("maxLatitude", maxLatitude);
        query.setParameter("minLongitude", minLongitude);
        query.setParameter("maxLongitude", maxLongitude);
        List coupons = query.getResultList();
		return coupons;
	}
}