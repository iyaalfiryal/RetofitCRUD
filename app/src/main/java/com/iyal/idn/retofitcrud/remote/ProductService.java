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

    @GET("person/get/")
    Call<List<PersonItem>> getProduct();

    @POST("person/add/")
    Call<PersonItem> addProduct(@Body PersonItem personItem);

    @PUT("person/update/")
    Call<PersonItem> updateProduct(@Path("id") int id,
                                   @Body PersonItem personItem);
    @DELETE("person/delete/")
    Call<PersonItem> deleteProduct(@Path("id") int id);

}
