package com.dn.Controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dn.DTO.Coupon;
import com.dn.Repo.ProductRepo;
import com.dn.model.Product;

@RestController
@RequestMapping("/productapi")
public class ProductController {
	
	@Autowired
	private RestTemplate rt;

	@Autowired
	ProductRepo pr;

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		Coupon  c=rt.getForObject("http://localhost:9090/couponapi/coupons/"+product.getCouponCode(), Coupon.class);
		double discount = c.getDiscount(); // Assuming getDiscount() returns a double
		double newPrice = product.getPrice() - discount;
		product.setPrice(newPrice);
		
		return pr.save(product);

	}
	
	@GetMapping("/products/{id}")
	public  Optional<Product> getProduct(@PathVariable int id) {
		return pr.findById((long) id);
	}

}
