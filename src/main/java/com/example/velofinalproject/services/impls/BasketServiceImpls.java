package com.example.velofinalproject.services.impls;

import com.example.velofinalproject.dtos.basket.BasketAddDto;
import com.example.velofinalproject.dtos.basket.BasketDto;
import com.example.velofinalproject.dtos.coupon.CouponDto;
import com.example.velofinalproject.dtos.user.UserBasketDto;
import com.example.velofinalproject.models.Basket;
import com.example.velofinalproject.models.Product;
import com.example.velofinalproject.models.UserEntity;
import com.example.velofinalproject.repositories.BasketRepository;
import com.example.velofinalproject.repositories.ProductRepository;
import com.example.velofinalproject.repositories.UserRepository;
import com.example.velofinalproject.services.BasketService;
import com.example.velofinalproject.services.CouponService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class BasketServiceImpls implements BasketService {

    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CouponService couponService;

    public BasketServiceImpls(BasketRepository basketRepository, UserRepository userRepository, ProductRepository productRepository, ModelMapper modelMapper, CouponService couponService) {
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.couponService = couponService;
    }

    @Override
    public void addToCart(BasketAddDto basketAddDto, String userEmail) {
        try{
            UserEntity findUser = userRepository.findByEmail(userEmail);
            List<Basket> findBasket = basketRepository.findByUserId(findUser.getId());

            if (findBasket.isEmpty()){
                Product findProduct = productRepository.findById(basketAddDto.getProductId()).orElseThrow();
                Basket basket = new Basket();
                basket.setUser(findUser);
                basket.setProduct(findProduct);
                basket.setQuantity(basketAddDto.getQuantity());
                basketRepository.save(basket);
            }else{
                Optional<Basket> find = findBasket.stream().filter(x->x.getProduct().getId() == basketAddDto.getProductId()).findFirst();

                if (find.isEmpty()){
                    Product findProduct = productRepository.findById(basketAddDto.getProductId()).orElseThrow();
                    Basket basket = new Basket();
                    basket.setUser(findUser);
                    basket.setProduct(findProduct);
                    basket.setQuantity(basketAddDto.getQuantity());
                    basketRepository.save(basket);
                }else{
                    find.get().setQuantity(find.get().getQuantity() + basketAddDto.getQuantity());
                    basketRepository.save(find.get());
                }

            }
        }catch (Exception e){
            String error = e.getMessage();
            System.out.println(error);
        }
    }

    @Override
    public UserBasketDto getBasket(String email, String coupon) {
        UserEntity findUser = userRepository.findByEmail(email);
        UserBasketDto result = new UserBasketDto();
        List<Basket> findBasket = basketRepository.findByUserId(findUser.getId());
        List<BasketDto> basket = findBasket.stream().map(x-> modelMapper.map(x, BasketDto.class)).collect(Collectors.toList());
        Double calculate = basket.stream().mapToDouble(c->c.getQuantity() * c.getProduct().getPrice()).sum();
        CouponDto couponDto = couponService.getCoupon(coupon);
        double priceCalculate = couponDto == null ? calculate : calculate -  (calculate * couponDto.getDiscount() / 100);
        result.setTotal(priceCalculate + 1.4);

        result.setSubtotal(priceCalculate);
        result.setShipping(1.4);
        result.setBaskets(basket);
        return result;
    }

    @Override
    public void removeBasketItem(String userEmail, Long id) {
        UserEntity findUser = userRepository.findByEmail(userEmail);
        Basket filterBasket = basketRepository.findByUserIdAndProductId(findUser.getId(), id);
        basketRepository.delete(filterBasket);
    }
}
