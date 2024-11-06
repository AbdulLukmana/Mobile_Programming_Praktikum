package com.example.formmahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity  {
    //L-1 pembuatan variable untuk komponen
    EditText e_nim, e_nama, e_jurusan, e_alamat;
    //TextView hnim, hnama, hjurusan, halamat;
    Button save, clear;
    //L-2 pembuatan variable untuk penerima nilai dari komponen
    //String n_nim, n_nama, n_jurusan, n_alamat;
    TextView textViewOutput;
    LinkedList<String> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //L_3 inisialisasi setiap komponen ke variable kompnen
        e_nim = findViewById(R.id.nim);
        e_nama = findViewById(R.id.nama);
        e_jurusan = findViewById(R.id.jurusan);
        e_alamat = findViewById(R.id.alamat);
        textViewOutput = findViewById(R.id.textViewDisplay);
       // txt_display=findViewById(R.id.textViewDisplay);
        save = findViewById(R.id.bSave);
        clear = findViewById(R.id.bClear);

      //prosese memanggil method setonclicklistener
        clear.setOnClickListener(this::Clear);
        save.setOnClickListener(this::Save);
        entries = new LinkedList<>();

    }

    public void Clear(View view) {
        e_nim.setText(" ");
        e_nama.setText(" ");
        e_jurusan.setText(" ");
        e_alamat.setText(" ");
        textViewOutput.setText("");
    }
   // @Override
    public void Save(View view) {

        String nims = e_nim.getText().toString().trim();
        String namas = e_nama.getText().toString().trim();
        String juruss=e_jurusan.getText().toString().trim();
        String alamats=e_alamat.getText().toString().trim();
        // Menggabungkan nilai-nilai menjadi satu string dengan newline
        String entrydata = "Nim:"+nims+"\n"+
                "Nama: " + namas + "\n" +
                "Jurusan: " + juruss + "\n" +
                "Alamat: " + alamats + "\n";
        entries.add(entrydata);// Menyimpan entri ke dalam LinkedList

        // Mengupdate TextView dengan semua entri
        StringBuilder output = new StringBuilder();
        for (String entryText : entries) {
            output.append(entryText).append("\n\n"); // Menambahkan jarak antar entri
        }
        // Menampilkan hasil di TextView
        textViewOutput.setText(output.toString());
        // Menghapus input setelah disubmit
        e_nim.setText(" ");
        e_nama.setText("");
        e_jurusan.setText("");
        e_alamat.setText("");

        if (TextUtils.isEmpty(nims)) {
            e_nim.setError("!");
            e_nim.setHint("Nim anda belum diisi bro!");

        }
        if (TextUtils.isEmpty(namas)) {
            e_nama.setError("!");
            e_nama.setHint("Nama anda belum diisi bro!");


        }
        if(TextUtils.isEmpty(juruss)) {
            e_jurusan.setError("!");
            e_jurusan.setHint("Jurusan belum di isi bro");

        }
        if(TextUtils.isEmpty(alamats)){
            e_alamat.setError("!");
            e_alamat.setHint("alamat anda belum terisi!");

        }



    }
}