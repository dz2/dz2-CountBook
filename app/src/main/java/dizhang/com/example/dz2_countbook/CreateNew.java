package dizhang.com.example.dz2_countbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

import com.google.gson.Gson;

/**
 * Created by ggranked on 2017-09-30.
 */

public class CreateNew extends Activity {

    int id = -1;

    EditText name;
    EditText initValue;
    EditText comment;
    //public Date date;

    private static final String FILENAME = "file.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);


        name = (EditText) findViewById(R.id.nameCre);
        initValue = (EditText) findViewById(R.id.initCre);
        comment = (EditText) findViewById(R.id.comCre);

        Intent current = getIntent();
        id = current.getIntExtra("item_position", -1);

        if (id != 1) {
            Counter book = (Counter) MainActivity.bookList.get(id);
            name.setText(book.nameC);
            initValue.setText(book.initValueC);
            comment.setText(book.commentC);

        }

    }

    public void SaveInFile(View v) {
        if (name.getText().toString().isEmpty()){}
        else{

            Counter enter = new Counter(name.getText().toString(),
                    initValue.getText().toString(),
                    //initValue.getText().toString(),
                    comment.getText().toString()
            );


        try {

            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            if(id == -1){
                MainActivity.bookList.add(enter);}
            else{
                MainActivity.bookList.set(id,enter);
            }

            gson.toJson(MainActivity.bookList, out);

            out.flush();


            fos.close();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
}
