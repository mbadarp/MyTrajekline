package com.example.mytrajekline.;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.arvita.crudvolley.Util.AppController;
import com.arvita.crudvolley.Util.ServerAPI;
import com.example.mytrajekline.Util.ServerAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class InsertDataBuatPaket extends AppCompatActivity {
    EditText nama_lengkap,email,kota_tujuan,jumlah_orang,lama_hari,tgl_berangkat,tujuan_wisata,tiket,penginapan,fasilitas,status;
    Button btnbatal,btnsimpan;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buatpaket);

        /*get data from intent*/
        Intent data = getIntent();
        final int update = data.getIntExtra("update",0);
        String intent_nama_lengkap = data.getStringExtra("nama_lengkap");
        String intent_email = data.getStringExtra("email");
        String intent_kota_tujuan = data.getStringExtra("kota_tujuan");
        String intent_jumlah_orang = data.getStringExtra("jumlah_orang");
        String intent_lama_hari = data.getStringExtra("lama_hari");
        String intent_tgl_berangkat = data.getStringExtra("tgl_berangkat");
        String intent_tujuan_wisata = data.getStringExtra("tujuan_wisata");
        String intent_tiket = data.getStringExtra("tiket");
        String intent_penginapan = data.getStringExtra("penginapan");
        String intent_fasilitas = data.getStringExtra("fasilitas");
        String intent_status = data.getStringExtra("status");

        /*end get data from intent*/


        nama_lengkap = (EditText) findViewById(R.id.inp_namalengkap);
        email = (EditText) findViewById(R.id.inp_email);
        kota_tujuan = (EditText) findViewById(R.id.inp_kotatujuan);
        jumlah_orang = (EditText) findViewById(R.id.inp_jumlahorang);
        lama_hari = (EditText) findViewById(R.id.inp_lamahari);
        tgl_berangkat = (EditText) findViewById(R.id.inp_tglberangkat);
        tujuan_wisata = (EditText) findViewById(R.id.inp_tujuanwisata);
        tiket = (EditText) findViewById(R.id.inp_tiket);
        penginapan = (EditText) findViewById(R.id.inp_penginapan);
        fasilitas = (EditText) findViewById(R.id.inp_fasilitas);
        status = (EditText) findViewById(R.id.inp_status);
        btnbatal = (Button) findViewById(R.id.btn_cancel);
        btnsimpan = (Button) findViewById(R.id.btn_simpan);
        pd = new ProgressDialog(InsertDataBuatPaket.this);

        /*kondisi update / insert*/
        if(update == 1)
        {
            btnsimpan.setText("Update Data");
            nama_lengkap.setText(intent_nama_lengkap);
            email.setText(intent_email);
            kota_tujuan.setText(intent_kota_tujuan);
            jumlah_orang.setText(intent_jumlah_orang);
            lama_hari.setText(intent_lama_hari);
            tgl_berangkat.setText(intent_tgl_berangkat);
            tujuan_wisata.setText(intent_tujuan_wisata);
            tiket.setText(intent_tiket);
            penginapan.setText(intent_penginapan);
            fasilitas.setText(intent_fasilitas);
            status.setText(intent_status);
        }


        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    simpanData();

            }
        });

        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(InsertDataBuatPaket.this,MainActivity.class);
                startActivity(main);
            }
        });
    }





    private void simpanData()
    {

        pd.setMessage("Menyimpan Data");
        pd.setCancelable(false);
        pd.show();

        StringRequest sendData = new StringRequest(Request.Method.POST, ServerAPI.URL_INSERTBUATPAKET,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.cancel();
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(InsertDataBuatPaket.this, "pesan : "+   res.getString("message") , Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity( new Intent(InsertDataBuatPaket.this,MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Toast.makeText(InsertDataBuatPaket.this, "pesan : Gagal Insert Data", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("username",username.getText().toString());
                map.put("grup",grup.getText().toString());
                map.put("nama",nama.getText().toString());
                map.put("password",password.getText().toString());

                return map;
            }
        };

        AppController.getInstance().addToRequestQueue(sendData);
    }
}
