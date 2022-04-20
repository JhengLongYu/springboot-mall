package com.leoyu.springbootmall.controller;

import com.leoyu.springbootmall.constant.ProductCategory;
import com.leoyu.springbootmall.dto.ProductQueryParams;
import com.leoyu.springbootmall.dto.ProductRequest;
import com.leoyu.springbootmall.model.Product;
import com.leoyu.springbootmall.service.ProductService;
import com.leoyu.springbootmall.util.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(

            //查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            //排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,

            //分頁 pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset

    ){

        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        // 取得 product list
        List<Product> productList = productService.getProducts(productQueryParams);

        // 取得 product 總數
        Integer total = productService.countProduct(productQueryParams);

        // 分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResult(productList);

        return ResponseEntity.status(HttpStatus.OK).body(page);

    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    //Swagger 練習用
//    @ApiResponses(value = {
//            @ApiResponse(code=200, message="查詢成功"),
//            @ApiResponse(code=404, message="無此商品")
//    })
//    @ApiOperation(value = "查詢商品", notes = "查詢商品12")
//    @GetMapping("/products/{productId}")
//    public ResponseEntity<Product> getProduct(
//            @ApiParam(required = true, value = "商品序號")
//            @PathVariable Integer productId) {
//        Product product = productService.getProductById(productId);
//        if(product != null){
//            return ResponseEntity.status(HttpStatus.OK).body(product);
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {
        //檢查product 是否存在
        Product product = productService.getProductById(productId);
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改商品資料
        productService.updateProduct(productId, productRequest);
        Product updated = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
