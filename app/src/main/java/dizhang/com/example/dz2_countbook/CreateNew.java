package dizhang.com.example.dz2_countbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

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

public class CreateNew extends AppCompatActivity {

    EditText nameN;
    EditText initValueN;
    EditText commentN;
    //public Date date;

    private static final String FILENAME = "file.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);


        nameN = (EditText) findViewById(R.id.nameCre);
        initValueN = (EditText) findViewById(R.id.initCre);
        commentN = (EditText) findViewById(R.id.comCre);

        Button saveButton = (Button) findViewById(R.id.saveCre);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameM = nameN.getText().toString();
                Integer initValueM = Integer.parseInt(initValueN.getText().toString());
                String commentM = commentN.getText().toString();

                Intent i = new Intent();
                i.putExtra("bookName", nameM);
                i.putExtra("bookInitValue", initValueM);
                i.putExtra("bookComment", commentM);

                setResult(Activity.RESULT_OK, i);

                finish();

            }
        });


    }
}

