package com.iyal.idn.retofitcrud.remote;

import com.iyal.idn.retofitcrud.activity.ProductActivity;

public class APIUtils {

    private APIUtils(){
    }

    public static final String API_URL =
            "http://localhost/marketplace/index.php/";

    public static ProductService getProductService(){
        return RetrofitClient.getClient(API_URL)
                .create(ProductService.class);
    }
}
