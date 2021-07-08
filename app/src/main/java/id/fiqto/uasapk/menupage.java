package id.fiqto.uasapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menupage extends AppCompatActivity {

    Button btnlogout, btnpilih, btnpendapatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage);

        btnpendapatan = (Button) findViewById(R.id.btnPendapatan);
        btnpilih = (Button) findViewById(R.id.btnPilih);
        btnlogout = (Button) findViewById(R.id.btnLogout);

        btnpilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menupage.this, pilihpage.class);
                startActivity(intent);
                finish();
            }
        });

        btnpendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menupage.this, pendapatan.class);
                menupage.this.startActivity(intent);
                finish();
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "ANDA TELAH LOGOUT",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(menupage.this, MainActivity.class);
                menupage.this.startActivity(intent);
                finish();
            }
        });

    }
}