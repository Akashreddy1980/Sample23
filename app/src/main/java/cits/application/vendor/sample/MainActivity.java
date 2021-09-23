    package cits.application.vendor.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity {
    EditText editText;
    RecyclerView recyclerView;
    Button button;
    recyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit1);
        recyclerView = findViewById(R.id.recycle1);
        button = findViewById(R.id.btn2);
        final Context context = this;
        if(editText.getText()==null) {
            recyclerView.setVisibility(View.INVISIBLE);
        }
        recyclerView.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setVisibility(View.VISIBLE);
                recyclerAdapter = new recyclerAdapter(context, editText.getText().toString());
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(recyclerAdapter);
            }
        });
    }
}