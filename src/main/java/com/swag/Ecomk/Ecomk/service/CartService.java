package com.swag.Ecomk.Ecomk.service;

import com.swag.Ecomk.Ecomk.dto.CartRequest;
import com.swag.Ecomk.Ecomk.model.CartItem;
import com.swag.Ecomk.Ecomk.model.Product;
import com.swag.Ecomk.Ecomk.model.User;
import com.swag.Ecomk.Ecomk.repository.CartRepository;
import com.swag.Ecomk.Ecomk.repository.ProductRepository;
import com.swag.Ecomk.Ecomk.repository.UserRepository;
//import jakarta.transaction.TransactionScoped;
import jakarta.transaction.TransactionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
//Do all database operations as ONE unit — either everything succeeds OR everything fails.
public class CartService {
    @Autowired
private ProductRepository productRepository;
    @Autowired
private UserRepository userRepository;
    @Autowired
private CartRepository cartRepository;
    public boolean addToCart(String userId, CartRequest request) {
        //TODO-LOOK FOR THE PRODUCT
        Optional<Product> productopt=productRepository.findById(request.getProductId());
        if(productopt.isEmpty()){
            return false;
        }
        Product product=productopt.get();
        if(product.getStockQuality()<request.getQuantity()){
            return  false;
        }
        Optional<User> useropt=userRepository.findById(Long.valueOf(userId));
        if(useropt.isEmpty()){
            return  false;
        }
        User user=useropt.get();
        CartItem exitignCartItem=cartRepository.findByUserAndProduct(user,product);
        if(exitignCartItem!=null){
//         Update the quantity
            exitignCartItem.setQuantity(exitignCartItem.getQuantity()+request.getQuantity());
            exitignCartItem.setPrice(product.getPrice().multiply(exitignCartItem.getPrice()));
            cartRepository.save(exitignCartItem);
        }else {
//         Create the new  item
CartItem cartItem=new CartItem();
cartItem.setUser(user);
cartItem.setProduct(product);
cartItem.setQuantity(request.getQuantity());
cartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity())));
cartRepository.save(cartItem);
        }
        return true;
    }

    public boolean deleteItemFromCart(String userID, Long productId) {

        Optional<Product> productOpt=productRepository.findById(productId);
//                if(productOpt.isEmpty()){
//                    return  false;
//                }
        Optional<User>useropt=userRepository.findById(Long.valueOf(userID));
//                if(useropt.isEmpty()){
//                    return false;
//                }
////useropt.flatMap(user->productOpt.map(product -> {
//    cartRepository.deleteByUserAndProduct(user,product);
//    return true;
//}));
//                NOTE- heck if user exists
//If yes → check if product exists
//If both exist →
//delete cart item
//return true
//If any missing → return empty
//        return false;

if(productOpt.isPresent() && useropt.isPresent()){
    cartRepository.deleteByUserAndProduct(useropt.get(),productOpt.get());
    return true;
}
return  false;
    }

}
