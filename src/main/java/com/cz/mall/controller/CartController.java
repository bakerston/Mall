package com.cz.mall.controller;

import com.cz.mall.consts.MallConst;
import com.cz.mall.form.CartAddForm;
import com.cz.mall.form.CartUpdateForm;

import com.cz.mall.pojo.User;
import com.cz.mall.service.CartService;
import com.cz.mall.vo.CartVo;
import com.cz.mall.vo.ResponseVo;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@Api(tags = "Carts api")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/carts")
    @Operation(summary = "Cart List")
    public ResponseVo<CartVo> list(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(MallConst.CURRENT_USER);
        return cartService.list(user.getId());
    }

    @PostMapping("/carts")
    @Operation(summary = "Add item to cart")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(MallConst.CURRENT_USER);
        return cartService.cartAdd(user.getId(), cartAddForm);
    }

    @PutMapping("/carts/{productId}")
    @Operation(summary = "Update Cart")
    public ResponseVo<CartVo> update(@Valid @RequestBody CartUpdateForm cartUpdateForm,
                                     @PathVariable Integer productId, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(MallConst.CURRENT_USER);
        return cartService.update(user.getId(), productId, cartUpdateForm);
    }

    @DeleteMapping("/carts/{productId}")
    @Operation(summary = "Remove item from cart")
    public ResponseVo<CartVo> delete(@PathVariable Integer productId, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(MallConst.CURRENT_USER);
        return cartService.delete(user.getId(), productId);
    }

    @PutMapping("/carts/selectAll")
    @Operation(summary = "Select all")
    public ResponseVo<CartVo> selectAll(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(MallConst.CURRENT_USER);
        return cartService.selectAll(user.getId());
    }

    @PutMapping("/carts/unSelectAll")
    @Operation(summary = "Unselect all")
    public ResponseVo<CartVo> unSelectAll(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(MallConst.CURRENT_USER);
        return cartService.unSelectAll(user.getId());
    }

    @GetMapping("/carts/products/sum")
    @Operation(summary = "Get sum in cart")
    public ResponseVo<Integer> sum(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(MallConst.CURRENT_USER);
        return cartService.sum(user.getId());
    }
}
