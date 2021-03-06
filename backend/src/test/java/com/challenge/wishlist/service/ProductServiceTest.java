package com.challenge.wishlist.service;

import com.challenge.wishlist.domain.Product;
import com.challenge.wishlist.dto.ProductDto;
import com.challenge.wishlist.mapper.ProductMapper;
import com.challenge.wishlist.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

  @Mock
  private ProductRepository productRepository;

  @Mock
  private ProductMapper productMapper;

  @InjectMocks
  private ProductService productService;

  @Test
  public void getProducts () {
    List<Product> products = new ArrayList<>();
    Product product = new Product();
    product.setId("EF1234");
    product.setImgUrl("image");
    product.setName("Random");
    product.setPrice("99.99");
    products.add(product);

    when(productRepository.findAll()).thenReturn(products);

    List<ProductDto> result = productService.getProducts();

    assertNotNull(result);
  }

}
