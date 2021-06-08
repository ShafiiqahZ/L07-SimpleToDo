package sg.edu.rp.c346.id20037987.l07_simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner sp2;
    EditText etTask;
    ListView lvTaskList;
    Button addBtn, delBtn, clrBtn;
    ArrayList<String> alTask;
    ArrayAdapter<String> aaTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp2 = findViewById(R.id.spinner2);
        etTask = findViewById(R.id.etTask);
        lvTaskList = findViewById(R.id.listViewTask);
        addBtn = findViewById(R.id.buttonAdd);
        delBtn = findViewById(R.id.buttonDelete);
        clrBtn = findViewById(R.id.buttonClear);


        alTask = new ArrayList<String>();

        alTask.add("Buy Soap");
        alTask.add("Watch Moana");

        aaTask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTask);

        lvTaskList.setAdapter(aaTask);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        addBtn.setEnabled(true);
                        delBtn.setEnabled(false);
                        break;
                    case 1:
                        addBtn.setEnabled(false);
                        delBtn.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String taskItem = etTask.getText().toString();
                //aiColour.add(colour);
                if(etTask.getText().toString().isEmpty() == false) {
                    //int pos = Integer.parseInt(etColour.getText().toString());
                    //String colour = etColour.getText().toString();
                    String taskItem = etTask.getText().toString();
                    //int pos = Integer.parseInt(etColour.getText().toString());
                    //alColour.add(pos, colour);
                    alTask.add(taskItem);
                    aaTask.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a task", Toast.LENGTH_LONG).show();
                }
                etTask.setText("");

            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String colour = etColour.getText().toString();
                if(etTask.getText().toString().isEmpty() == false) {
                    int pos = Integer.parseInt(etTask.getText().toString());
                    alTask.remove(pos);
                    aaTask.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a index to remove", Toast.LENGTH_LONG).show();
                }
                etTask.setText("");
            }
        });

        clrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alTask.size()==0){
                    Toast.makeText(MainActivity.this, "You have no task to remove", Toast.LENGTH_LONG).show();
                } else {
                    alTask.clear();
                    aaTask.notifyDataSetChanged();
                }
                etTask.setText("");
            }
        });

    }
}