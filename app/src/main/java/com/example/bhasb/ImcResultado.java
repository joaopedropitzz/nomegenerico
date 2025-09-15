package com.example.bhasb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImcResultado extends AppCompatActivity {
    TextView tvResultado;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc_resultado);
        tvResultado=findViewById(R.id.textView2);
        imageView=findViewById(R.id.imageViewPerfil);
        //recuperando a intenção
        Intent i=getIntent();
        Bundle b=i.getExtras();
        Double peso =b.getDouble("peso");
        Double altura =b.getDouble("altura");
        Double imc = peso/(altura*altura);
        tvResultado.setText(Double.toString(imc));
        imageView.setImageResource(R.drawable.perfil);

        if(imc<18.9){imageView.setImageResource(R.drawable.abaixopeso);}
        if(imc>=18.9 && imc<25){imageView.setImageResource(R.drawable.normal);}
        if(imc>=25 && imc<30){imageView.setImageResource(R.drawable.normal);}
        if(imc>=30 && imc<35){imageView.setImageResource(R.drawable.normal);}


    }
}