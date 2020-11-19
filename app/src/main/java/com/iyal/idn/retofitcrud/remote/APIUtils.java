package com.iyal.idn.retofitcrud.remote;

import com.iyal.idn.retofitcrud.activity.ProductActivity;

public class APIUtils {

    private APIUtils(){
    }

    public static final String API_URL =
            "http://192.168.100.157/marketplace/index.php/";

    public static ProductService getProductService(){
        return RetrofitClient.getClient(API_URL)
                .create(ProductService.class);
    }
}
