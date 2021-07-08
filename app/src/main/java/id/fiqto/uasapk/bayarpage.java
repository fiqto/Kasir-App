package id.fiqto.uasapk;

import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bayarpage extends AppCompatActivity {

    Button btnbayar, btnsimpan;
    EditText bayar;
    TextView kembalian, totaluang ,hitung;

    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayarpage);


        btnbayar = (Button) findViewById(R.id.btnBayar);
        btnsimpan = (Button) findViewById(R.id.btnSimpan);
        bayar = (EditText) findViewById(R.id.editTextbayar);
        kembalian = (TextView) findViewById(R.id.textKembalianuang);
        totaluang = (TextView) findViewById(R.id.textTotaluang);
        hitung = (TextView) findViewById(R.id.textHitung);
        hitung.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        String uang = intent.getStringExtra("uang");
        totaluang.setText(totaluang.getText().toString() + uang);

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Membaca
                try {
                    FileInputStream fis = new FileInputStream(myExternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                        myData = strLine;
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                hitung.setText(myData);

                int uang1 = Integer.parseInt(hitung.getText().toString());
                int uang2 = Integer.parseInt(totaluang.getText().toString());
                int total = uang1 + uang2;
                hitung.setText(Integer.toString(total));

                //Menulis
                try {
                    FileOutputStream fos = new FileOutputStream(myExternalFile);
                    fos.write(hitung.getText().toString().getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(bayarpage.this, menupage.class);
                startActivity(intent);
                finish();
            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            btnsimpan.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }

        btnbayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bayar.getText().length()>0)
                {
                    int angka1 = Integer.parseInt(totaluang.getText().toString());
                    int angka2 = Integer.parseInt(bayar.getText().toString());
                    int result = angka2 - angka1;
                    kembalian.setText(Integer.toString(result));
                }
                else {
                    Toast toast = Toast.makeText(bayarpage.this, "Mohon isi bayar", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });



    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

}