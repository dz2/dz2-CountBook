package dizhang.com.example.dz2_countbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.security.cert.CRLReason;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
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

public class MainActivity extends AppCompatActivity {
    private static final String FILENAME = "file.sav";

    public static ArrayList <Counter> bookList = new ArrayList<Counter>();

    private ListView mainListDis;

    private ArrayAdapter<Counter> adapter;

    Button createNew;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        mainListDis = (ListView) findViewById(R.id.counterList);
        createNew = (Button) findViewById(R.id.createButton);
        //registerForContextMenu(mainListDis);

        createNew.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateNew.class);
                startActivity(intent);
            }
        });


        mainListDis.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v,int position,long id){
                Intent intent = new Intent(MainActivity.this, CreateNew.class);
                intent.putExtra("item_position",position);
                startActivityForResult(intent, 1);
                finish();
            }
        });

        mainListDis.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id){
                bookList.remove(position);
                adapter.notifyDataSetChanged();
                //counter = (TextView) findViewById(R.id.count);
                //counter.setText("number of entries : "+sizeList.size());
                try {
                    FileOutputStream fos = openFileOutput(FILENAME,
                            Context.MODE_PRIVATE);
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

                    Gson gson = new Gson();

                    gson.toJson(MainActivity.bookList, out);

                    out.flush();


                    fos.close();

                } catch (FileNotFoundException e) {
                    throw new RuntimeException();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
                return true;
            }

        });






       // setupButton();

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
    }

   private void setupButton() {
       bookList = new ArrayList<Counter>();
       bookList.add(new Counter("Test", "1", "yes"));

        Button myButton = (Button) findViewById(R.id.createButton);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CreateNew.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();
            }

        });
    }*/
   public void addNew(View view){
       Intent i = new Intent(this, CreateNew.class);
       startActivity(i);
       finish();
   }




    private void LoadFromFile(){
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            bookList = gson.fromJson(in, new TypeToken<ArrayList<Counter>>(){}.getType());

            fis.close();

        } catch (FileNotFoundException e) {
//            sizeList = new ArrayList<Size>();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        bookList = new ArrayList<Counter>();
        LoadFromFile();

        mainListDis.setAdapter(adapter);
    }

}
