package id.fiqto.uasapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class pilihpage extends AppCompatActivity {

    TextView texttotal1, texttotal2, texttotal3, texttotal4, texttotal5;
    Button btntambah1, btnkurang1, btntambah2, btnkurang2, btntambah3, btnkurang3, btntambah4, btnkurang4, btntambah5, btnkurang5, btnbeli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihpage);

        texttotal1 = (TextView) findViewById(R.id.texttotal1);
        btnkurang1 = (Button) findViewById(R.id.buttonkurang1);
        btntambah1 = (Button) findViewById(R.id.buttontambah1);
        texttotal2 = (TextView) findViewById(R.id.texttotal2);
        btnkurang2 = (Button) findViewById(R.id.buttonkurang2);
        btntambah2 = (Button) findViewById(R.id.buttontambah2);
        texttotal3 = (TextView) findViewById(R.id.texttotal3);
        btnkurang3 = (Button) findViewById(R.id.buttonkurang3);
        btntambah3 = (Button) findViewById(R.id.buttontambah3);
        texttotal4 = (TextView) findViewById(R.id.texttotal4);
        btnkurang4 = (Button) findViewById(R.id.buttonkurang4);
        btntambah4 = (Button) findViewById(R.id.buttontambah4);
        texttotal5 = (TextView) findViewById(R.id.texttotal5);
        btnkurang5 = (Button) findViewById(R.id.buttonkurang5);
        btntambah5 = (Button) findViewById(R.id.buttontambah5);
        btnbeli = (Button) findViewById(R.id.btnBeli);

        btnkurang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka1 = Integer.parseInt(texttotal1.getText().toString());
                angka1--;
                texttotal1.setText(angka1+""); }
        });

        btntambah1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka1 = Integer.parseInt(texttotal1.getText().toString());
                angka1++;
                texttotal1.setText(angka1+""); }
        });

        btnkurang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka2 = Integer.parseInt(texttotal2.getText().toString());
                angka2--;
                texttotal2.setText(angka2+""); }
        });

        btntambah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka2 = Integer.parseInt(texttotal2.getText().toString());
                angka2++;
                texttotal2.setText(angka2+""); }
        });

        btnkurang3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka3 = Integer.parseInt(texttotal3.getText().toString());
                angka3--;
                texttotal3.setText(angka3+""); }
        });

        btntambah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka3 = Integer.parseInt(texttotal3.getText().toString());
                angka3++;
                texttotal3.setText(angka3+""); }
        });

        btnkurang4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka4 = Integer.parseInt(texttotal4.getText().toString());
                angka4--;
                texttotal4.setText(angka4+""); }
        });

        btntambah4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka4 = Integer.parseInt(texttotal4.getText().toString());
                angka4++;
                texttotal4.setText(angka4+""); }
        });

        btnkurang5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka5 = Integer.parseInt(texttotal5.getText().toString());
                angka5--;
                texttotal5.setText(angka5+""); }
        });

        btntambah5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka5 = Integer.parseInt(texttotal5.getText().toString());
                angka5++;
                texttotal5.setText(angka5+""); }
        });

        btnbeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pilihpage.this, bayarpage.class);
                int total1 = Integer.parseInt(texttotal1.getText().toString());
                int total2 = Integer.parseInt(texttotal2.getText().toString());
                int total3 = Integer.parseInt(texttotal3.getText().toString());
                int total4 = Integer.parseInt(texttotal4.getText().toString());
                int total5 = Integer.parseInt(texttotal5.getText().toString());
                int result = (total1*13000) + (total2*12000) + (total3*10000) + (total4*3000) + (total5*5000);
                String uang = String.valueOf(result);
                intent.putExtra("uang", uang);
                startActivity(intent);
                finish();
            }
        });

    }
}