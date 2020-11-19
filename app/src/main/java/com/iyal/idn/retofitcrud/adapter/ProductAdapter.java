package com.iyal.idn.retofitcrud.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.iyal.idn.retofitcrud.R;
import com.iyal.idn.retofitcrud.activity.ProductActivity;
import com.iyal.idn.retofitcrud.model.PersonItem;
import com.iyal.idn.retofitcrud.model.ResponseProduct;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProductAdapter extends ArrayAdapter<ResponseProduct> {
    private Context context;
    private List<ResponseProduct> personItem;

    public ProductAdapter(@NonNull Context context,
                          int resource,
                          @NonNull List<ResponseProduct> objects) {
        super(context, resource, objects);
        this.context = context;
        this.personItem = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                        .LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_item, parent, false);

        TextView txtNameProduct = v.findViewById(R.id.txt_product_name);
        TextView txtPriceProduct = v.findViewById(R.id.txt_product_price);
        TextView txtDescProduct = v.findViewById(R.id.txt_product_desc);

        txtNameProduct.setText(String.format("name", personItem.get(position).getName()));
        txtPriceProduct.setText(String.format("price", personItem.get(position).getPrice()));
        txtDescProduct.setText(String.format("desc", personItem.get(position).getDesc()));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("name", personItem.get(position).getName());
                intent.putExtra("price", personItem.get(position).getPrice());
                intent.putExtra("desc", personItem.get(position).getDesc());
                context.startActivity(intent);
            }
        });

        return v;
    }

}
