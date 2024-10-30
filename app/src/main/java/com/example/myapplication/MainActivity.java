package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;//scroll
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ListView listView;//scroll

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tv_username = findViewById(R.id.tv_username);
        Intent intent = getIntent();
        tv_username.setText(intent.getStringExtra("username"));


        //scroll
        listView = findViewById(R.id.listView);
        listView.smoothScrollToPosition(1);

        Button btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        String nama[] = {"Adit", "Wicaksono", "Moeslimar", "Cahya", "Ilham" };
        String hp[] = {"0895323289181", "08973207307", "0845679283", "089543879623", "08942345678"};
        int img[] = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,};

        ListView lv_mhs = findViewById(R.id.listView);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, mhs);
        CustomAdapter adapter = new CustomAdapter(this, nama, hp, img);

        lv_mhs.setAdapter(adapter);

        lv_mhs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),mhs[i], Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + hp[i]));

                startActivity(intent);

                return false;
                }
            });
        };
    }