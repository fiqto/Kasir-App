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

import java.io.File;
import java.nio.charset.StandardCharsets;

public class pendapatan extends AppCompatActivity {

    Button btnreset, btnkembali, btnrefresh;
    TextView totalpendapatan;

    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendapatan);

        totalpendapatan = (TextView) findViewById(R.id.textTotaluang);
        btnreset = (Button) findViewById(R.id.btnReset);
        btnkembali = (Button) findViewById(R.id.btnKembali);
        btnrefresh = (Button) findViewById(R.id.btnRefresh);

        btnkembali.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pendapatan.this, menupage.class);
                startActivity(intent);
                finish();
            }
        });

        btnreset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
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
                totalpendapatan.setText(myData);

                int uang1 = Integer.parseInt(totalpendapatan.getText().toString());
                int total = uang1*0;
                totalpendapatan.setText(Integer.toString(total));

                //Menulis
                try {
                    FileOutputStream fos = new FileOutputStream(myExternalFile);
                    fos.write(totalpendapatan.getText().toString().getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnrefresh.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

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
                totalpendapatan.setText(myData);
            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            btnreset.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }


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