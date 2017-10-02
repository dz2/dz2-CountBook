package dizhang.com.example.dz2_countbook;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


    }
}
