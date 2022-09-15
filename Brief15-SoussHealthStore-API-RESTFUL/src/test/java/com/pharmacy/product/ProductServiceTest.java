package com.pharmacy.product;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.pharmacy.TestObjectFactory;
import com.pharmacy.entities.CategoryEnum;
import com.pharmacy.entities.Product;
import com.pharmacy.repositories.CategoryRepository;
import com.pharmacy.repositories.ProductRepository;
import com.pharmacy.services.ProductService;

public class ProductServiceTest {
	  private static List<Product> products;
	  
	  
//	    @Mock
//	    @Autowired
//	    @InjectMocks

	    private ProductRepository productRepository;

//	    @Mock
//	    @Autowired
//	    @InjectMocks

	    private CategoryRepository categoryRepository;
	    
	    

	    @InjectMocks
//	    @Autowired
	    private ProductService productService;
//	    public ProductServiceTest(ProductService productService){
//	           this.productService = productService;		
//		}
	    
//	    @Before
//	    public void setup()
//	    {
//	        MockitoAnnotations.initMocks(this);
//	    }

	    @BeforeEach
	    public void init() {
	        products = new ArrayList<>();
	        Product p1 = TestObjectFactory.newProduct(1L, "test1", CategoryEnum.INTRAVENOUS);
	        Product p2 = TestObjectFactory.newProduct(2L, "test2", CategoryEnum.AEROSOL);
	        Product p3 = TestObjectFactory.newProduct(3L, "test3", CategoryEnum.ORAL);
	        products = Stream.of(p1, p2, p3).collect(Collectors.toList());
	    }


	    @Test
	    public void findAllProductsTest() throws Exception {
	        given(productRepository.findAll()).willReturn(Collections.emptyList());
	        List<Product> products = productService.findAllProducts();
	        assertTrue(products.isEmpty());
	        verify(productRepository).findAll();
	    }

	    @Test
	    public void addProductTest() throws Exception {
	        Product product = TestObjectFactory.newProduct(4L, "testproduct", CategoryEnum.EYEDROPS);
	        given(categoryRepository.findByName(product.getCategory().getName())).willReturn(product.getCategory());
	        given(productRepository.save(product)).willReturn(product);

	        productService.addProduct(product);
	        verify(productRepository).save(product);
	    }

	    @Test
	    public void findProduct_productFoundTest() throws Exception {
	        Product product = products.get(1);
	        Long id = product.getId();
	        given(productRepository.findById(id)).willReturn(Optional.of(product));

	        productService.findProduct(id);
	        verify(productRepository).findById(id);
	    }

	    @Test
	    public void findProduct_productNotFoundTest() throws Exception {
	        Long id = 4L;
	        given(productRepository.findById(id)).willReturn(Optional.empty());

	        productService.findProduct(id);
	        verify(productRepository).findById(id);
	    }

	   @Test
	   public void updateProductTest() throws Exception {
	       Product product = TestObjectFactory.newProduct(4L, "testproduct", CategoryEnum.EYEDROPS);
	       given(categoryRepository.findByName(product.getCategory().getName())).willReturn(product.getCategory());
	       given(productRepository.save(product)).willReturn(product);

	       productService.updateProduct(product);
	       verify(productRepository).save(product);

	   }

//	   @Test
//	   public void deleteProductTest() throws Exception {
//	       Long id = 3L;
//	       productService.deleteProduct(id);
//	       verify(productRepository).deleteById(id);
//	    }


}
