package dizhang.com.example.dz2_countbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by ggranked on 2017-10-01.
 */

public class EditOld extends AppCompatActivity {

    private EditText nameE;
    private EditText curValueE;
    private EditText initValueE;
    private EditText commentE;
    private Date dataE;
    public Integer id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_counter);

        Button doneButton = (Button) findViewById(R.id.doneEdit);
        int id = getIntent().getIntExtra("position", 0);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameM = nameE.getText().toString();
                Integer initValueM = Integer.parseInt(initValueE.getText().toString());
                String commentM = commentE.getText().toString();

                //Counter counter = new Counter(nameM, initValueM, commentM);

                Intent i = new Intent(EditOld.this, MainActivity.class);

                i.putExtra("nameM", nameM);
                i.putExtra("initValueM", initValueM);
                i.putExtra("commentM", commentM);
                setResult(Activity.RESULT_OK, i);
                startActivity(i);

                finish();


            }
        });


    }
}
