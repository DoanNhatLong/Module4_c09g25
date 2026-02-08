package com.example.ss8_validator.dto;

import com.example.ss8_validator.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class Cart {

    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public void add(Product product) {
        CartItem item = items.get(product.getId());
        if (item == null) {
            items.put(Math.toIntExact(product.getId()), new CartItem(product, 1));
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    public void update(Integer productId, int quantity) {
        if (quantity <= 0) {
            items.remove(productId);
        } else {
            items.get(productId).setQuantity(quantity);
        }
    }

    public void remove(Integer productId) {
        items.remove(productId);
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
}