package com.iyal.idn.retofitcrud.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iyal.idn.retofitcrud.R;
import com.iyal.idn.retofitcrud.model.PersonItem;
import com.iyal.idn.retofitcrud.model.ResponseProduct;
import com.iyal.idn.retofitcrud.remote.APIUtils;
import com.iyal.idn.retofitcrud.remote.ProductService;

public class ProductActivity extends AppCompatActivity {

    ProductService productService;
    EditText edtName, edtPrice, edtDesc, edtId;
    Button btnSave, btnDel;
    TextView txtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtName = findViewById(R.id.edt_name);
        edtPrice = findViewById(R.id.edt_price);
        edtDesc = findViewById(R.id.edt_desc);
        btnSave = findViewById(R.id.btn_save);
        btnDel = findViewById(R.id.btn_delete);
        edtId = findViewById(R.id.edt_id);
        txtId = findViewById(R.id.txt_id);

        productService = APIUtils.getProductService();

        Bundle extras = getIntent().getExtras();
        String productName = extras.getString("name");
        String productPrice = extras.getString("price");
        String productDesc = extras.getString("desc");
        final String productID = extras.getString("id");

        edtId.setText(productID);
        edtName.setText(productName);
        edtPrice.setText(productPrice);
        edtDesc.setText(productDesc);

        if (productID != null && productID.trim().length() > 0){
            edtId.setFocusable(false);
        } else {
            txtId.setVisibility(View.INVISIBLE);
            edtId.setVisibility(View.INVISIBLE);
            btnDel.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonItem p = new PersonItem();
                p.setName(edtName.getText().toString());
                p.setPrice(edtPrice.getText().toString());
                p.setDesc(edtDesc.getText().toString());

                if (productID != null && productID.trim().length() > 0){
                    updateProduct(Integer.parseInt(productID), p);
                } else {
                    addProduct(p);
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProduct(Integer.parseInt(productID));
                Intent intent = new Intent(ProductActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void addProduct(PersonItem p) {
        Call<PersonItem> call = productService.addProduct(p);
        call.enqueue(new Callback<PersonItem>() {
            @Override
            public void onResponse(Call<PersonItem> call, Response<PersonItem> response) {
                if (response.isSuccessful()){
                    Toast.makeText(ProductActivity.this, "product added",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<PersonItem> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    private void updateProduct(int id, PersonItem personItem) {
        Call<PersonItem> call = productService.updateProduct(id, personItem);
        call.enqueue(new Callback<PersonItem>() {
            @Override
            public void onResponse(Call<PersonItem> call, Response<PersonItem> response) {
                if (response.isSuccessful()){
                    Toast.makeText(ProductActivity.this, "Product Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<PersonItem> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    private void deleteProduct(int id){
        Call<PersonItem> call = productService.deleteProduct(id);
        call.enqueue(new Callback<PersonItem>() {
            @Override
            public void onResponse(Call<PersonItem> call, Response<PersonItem> response) {
                if (response.isSuccessful()){
                    Toast.makeText(ProductActivity.this, "Product deleted",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<PersonItem> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}