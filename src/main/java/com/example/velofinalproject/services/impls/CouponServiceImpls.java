package com.example.velofinalproject.services.impls;

import com.example.velofinalproject.dtos.coupon.CouponDto;
import com.example.velofinalproject.models.Coupon;
import com.example.velofinalproject.repositories.CouponRepository;
import com.example.velofinalproject.services.CouponService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpls implements CouponService {
    private final CouponRepository couponRepository;
    private final ModelMapper modelMapper;

    public CouponServiceImpls(CouponRepository couponRepository, ModelMapper modelMapper) {
        this.couponRepository = couponRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CouponDto getCoupon(String coupon) {
        try {
            Coupon findCoupon = couponRepository.findByName(coupon);
            CouponDto couponDto = modelMapper.map(findCoupon,CouponDto.class);
            return couponDto;
        }catch (Exception e){
            return  null;
        }
    }
}
