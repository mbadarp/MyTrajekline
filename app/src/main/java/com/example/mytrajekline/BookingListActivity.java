package com.example.mytrajekline;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.mytrajekline.Adapter.AdapterData;
import com.arvita.crudvolley.Model.ModelData;
import com.arvita.crudvolley.Util.AppController;
import com.arvita.crudvolley.Util.ServerAPI;
import com.example.mytrajekline.Util.ServerAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookingListActivity extends AppCompatActivity {
    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    List<ModelData> mItems;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookinglist);

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerviewTemp);
        pd = new ProgressDialog(BookingListActivity.this);
        mItems = new ArrayList<>();

        loadJson();

        mManager = new LinearLayoutManager(BookingListActivity.this,LinearLayoutManager.VERTICAL,false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterData(MainActivity.this,mItems);
        mRecyclerview.setAdapter(mAdapter);

    }


    private void loadJson()
    {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, ServerAPI.URL_BOOKINGLIST,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        pd.cancel();
                        Log.d("volley","response : " + response.toString());
                        for(int i = 0 ; i < response.length(); i++)
                        {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelData md = new ModelData();
                                md.setId_pesan(data.getString("id_pesan"));
                                md.setNama_customer(data.getString("nama_customer"));
                                md.setTgl_pesan(data.getString("tgl_pesan"));
                                md.setTgl_tour(data.getString("tgl_tour"));
                                md.setNama_paket(data.getString("nama_paket"));
                                md.setNama_wisata(data.getString("nama_wisata"));
                                md.setHarga_paket(data.getString("harga_paket"));
                                md.setHarga_paket(data.getString("harga_total"));
                                md.setAction(data.getString("action"));
                                mItems.add(md);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("volley", "error : " + error.getMessage());
                    }
                });

        AppController.getInstance().addToRequestQueue(reqData);
    }

}
