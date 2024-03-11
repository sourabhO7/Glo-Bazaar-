package com.app.globazaar.utils;

import com.app.globazaar.GloBazaarApplication;
import com.app.globazaar.dto.ProductDto;
import com.app.globazaar.dto.UserDto;
import com.app.globazaar.entity.Product;
import com.app.globazaar.entity.User;


public class Mapper {
    public static ProductDto mapToProductDto(Product product) {
        return GloBazaarApplication.modelMapper().map(product, ProductDto.class);

    }

    public static Product mapToProductEntity(ProductDto productDto) {
        return GloBazaarApplication.modelMapper().map(productDto, Product.class);
    }

    public static UserDto mapToUserDto(User user) {
        return GloBazaarApplication.modelMapper().map(user, UserDto.class);
    }

    public static User mapToUserEntity(UserDto userDto) {
        return GloBazaarApplication.modelMapper().map(userDto, User.class);
    }
}
