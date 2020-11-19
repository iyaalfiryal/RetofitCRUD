package com.iyal.idn.retofitcrud.remote;

import com.iyal.idn.retofitcrud.model.PersonItem;
import com.iyal.idn.retofitcrud.model.ResponseProduct;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductService {

    @GET("person/get")
    Call<List<ResponseProduct>> getProduct();

    @POST("person/add")
    Call<ResponseProduct> addProduct(@Body ResponseProduct personItem);

    @PUT("person/update")
    Call<ResponseProduct> updateProduct(@Path("id") int id,
                                   @Body ResponseProduct personItem);
    @DELETE("person/delete")
    Call<ResponseProduct> deleteProduct(@Path("id") int id);

}
