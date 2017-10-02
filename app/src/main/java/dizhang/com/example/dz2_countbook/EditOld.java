package dizhang.com.example.dz2_countbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by ggranked on 2017-10-01.
 */

public class EditOld extends AppCompatActivity {

    private EditText nameE;
    private EditText curValueE;
    private EditText initValueE;
    private EditText commentE;

    Button doenButton;
    //private Date dataE;
    //public Integer id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_counter);

        Button doneButton = (Button) findViewById(R.id.doneEdit);
        nameE = (EditText) findViewById((R.id.nameE));
        curValueE = (EditText) findViewById((R.id.curValueE));
        initValueE = (EditText) findViewById((R.id.initValueE));
        commentE = (EditText) findViewById((R.id.commentE));

        Intent i = getIntent();
        String name = i.getStringExtra("nameM");
        Integer initValue = i.getIntExtra("initValueM", 0);
        Integer curValue = i.getIntExtra("curValueM", 0);
        String comment = i.getStringExtra("commentM");
        //int id = getIntent().getIntExtra("position", 0);

        nameE.setText(name, TextView.BufferType.EDITABLE);
        curValueE.setText(curValue,TextView.BufferType.EDITABLE);
        initValueE.setText(initValue,TextView.BufferType.EDITABLE);
        commentE.setText(comment,TextView.BufferType.EDITABLE);



        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameM = nameE.getText().toString();
                Integer curValueM = Integer.parseInt(curValueE.getText().toString());
                Integer initValueM = Integer.parseInt(initValueE.getText().toString());
                String commentM = commentE.getText().toString();



                //Counter counter = new Counter(nameM, initValueM, commentM);

                Intent intentE = getIntent();

                intentE.putExtra("nameM", nameM);
                intentE.putExtra("initValueM", initValueM);
                intentE.putExtra("commentM", commentM);
                intentE.putExtra("curValueM", curValueM);

                setResult(Activity.RESULT_OK, intentE);
                //startActivity(i);

                finish();


            }
        });


    }
}
