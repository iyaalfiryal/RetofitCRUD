package com.iyal.idn.retofitcrud.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.iyal.idn.retofitcrud.R;
import com.iyal.idn.retofitcrud.adapter.ProductAdapter;
import com.iyal.idn.retofitcrud.model.PersonItem;
import com.iyal.idn.retofitcrud.model.ResponseProduct;
import com.iyal.idn.retofitcrud.remote.APIUtils;
import com.iyal.idn.retofitcrud.remote.ProductService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAddUser;
    Button btnGetUser;
    ListView rv;
    ProductService productService;
    List<ResponseProduct> list = new ArrayList<ResponseProduct>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddUser = findViewById(R.id.btnAddUser);
        btnGetUser = findViewById(R.id.btnGetUserList);
        rv = findViewById(R.id.rv);

        productService = APIUtils.getProductService();

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        ProductActivity.class);
                intent.putExtra("name", "");
                intent.putExtra("price", "");
                intent.putExtra("desc", "");
                startActivity(intent);
            }
        });

        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserList();
            }
        });

    }

    public void getUserList() {
        Call<List<ResponseProduct>> call = productService.getProduct();
        call.enqueue(new Callback<List<ResponseProduct>>() {
            @Override
            public void onResponse(Call<List<ResponseProduct>> call, Response<List<ResponseProduct>> response) {
                if (response.isSuccessful()){
                    list = response.body();
                    rv.setAdapter(new ProductAdapter(MainActivity.this,
                            R.layout.list_item, list));
                }
            }

            @Override
            public void onFailure(Call<List<ResponseProduct>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}