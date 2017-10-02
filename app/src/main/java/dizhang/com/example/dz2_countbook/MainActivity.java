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
import java.security.PublicKey;
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

    private static ArrayList <Counter> bookList = new ArrayList<Counter>();

    private ListView mainListDis;

    private ArrayAdapter<Counter> adapter;

    Button createNew;

    //public ArrayList mainList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNew = (Button) findViewById(R.id.createButton);
        //registerForContextMenu(mainListDis);
        adapter = new ArrayAdapter<Counter>(this,
                R.layout.list_item, bookList);


        mainListDis = (ListView) findViewById(R.id.counterList);
        mainListDis.setAdapter(adapter);
        //populateLV();

        createNew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateNew.class);
                startActivityForResult(intent, 1);


                //saveInFile();
            }
        });
/*
        mainListDis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditOld.class);
                intent.putExtra("item_position", position);
                startActivity(intent);
                finish();
            }
        });

        mainListDis.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
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

        }); */
    }



   protected void onActivityResult(int resultCode, Intent data){
       if (resultCode == Activity.RESULT_OK){
           String name = data.getStringExtra("nameM");
           Integer value = data.getIntExtra("valueM", 0);
           String comment = data.getStringExtra("commentM");

           Counter counter = new Counter (name, value, comment);
           bookList.add(counter);
           adapter.notifyDataSetChanged();
           saveFile();
       }

   }
    @Override
    protected void onStart() {
        super.onStart();
        LoadFromFile();

        //adapter = new ArrayAdapter<Counter>(this,
        //      R.layout.list_item, bookList);


        adapter = new ArrayAdapter<Counter>(this, R.layout.list_item, bookList);


        mainListDis.setAdapter(adapter);
    }


    private void LoadFromFile(){
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Counter>>(){}.getType();

            bookList = gson.fromJson(in, listType);

            //fis.close();

        } catch (FileNotFoundException e) {
            bookList = new ArrayList<Counter>();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void saveFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(bookList, writer);
            writer.flush();
            //fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }

}
