package com.project_work.fragmentswithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemSelected {
    TextView d_name,d_num;
    EditText a_name,a_num;
    Button add_btn;
    ListFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d_name=findViewById(R.id.d_name);
        d_num=findViewById(R.id.d_num);
        a_name=findViewById(R.id.a_name);
        a_num=findViewById(R.id.a_num);
        add_btn=findViewById(R.id.add_btn);

        fragmentManager=this.getSupportFragmentManager();
        listFrag=(ListFrag) fragmentManager.findFragmentById(R.id.listFrag);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a_name.getText().toString().isEmpty()||a_num.getText().toString().isEmpty())
                {
                     Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ApplicationClass.people.add(new Person(a_name.getText().toString().trim(),a_num.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                    a_name.setText(null);
                    a_num.setText(null);
                    listFrag.getNotifiedDataChanged();
                }

            }
        });
        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        d_name.setText(ApplicationClass.people.get(index).getName());
        d_num.setText(ApplicationClass.people.get(index).getNumber());
    }
}
