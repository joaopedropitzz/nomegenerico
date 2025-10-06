package com.example.bhasb;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    EditText editTextText;
    ArrayList<String> nomes;
    String i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        button = findViewById(R.id.button);
        editTextText = findViewById(R.id.editTextText);
        nomes = new ArrayList<String>();


        ArrayAdapter<String> adapter= new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes);
        listView.setAdapter(adapter);
        button.setOnClickListener(v ->{
            nomes.add(editTextText.getText().toString());
            adapter.notifyDataSetChanged();
        });

        listView.setOnItemLongClickListener((parent, view, position, id)->{
            nomes.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });




    }
}