package dizhang.com.example.dz2_countbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final String FILENAME = "file.sav";

    public static ArrayList bookList;

    ListView mainListDis;

    private ArrayList mainList;

    private ArrayAdapter<Counter> adapter;

    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListDis = (ListView) findViewById(R.id.counterList);





        setupButton();

        //mainListDis = (ListView) findViewById(R.id.counterList);


        /*createButton.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CreateNew.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        */
    }

   /* public void addNew(View view) {
        Intent intent = new Intent(this, CreateNew.class);
        startActivity(intent);
        finish();
    }*/

   private void setupButton() {

        Button myButton = (Button) findViewById(R.id.createButton);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CreateNew.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();
            }

        });
    }


}
