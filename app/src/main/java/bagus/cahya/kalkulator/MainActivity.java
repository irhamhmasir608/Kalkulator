package bagus.cahya.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nilai1, nilai2, hasil;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nilai1 = (EditText) findViewById(R.id.edNilai1);
        nilai2 = (EditText) findViewById(R.id.edNilai2);
        hasil  =  (EditText) findViewById(R.id.edhasil);
    }

    public void tambahClick() {

        hasil.setText(Integer.parseInt(String.valueOf(nilai1.getText())) +
                Integer.parseInt(String.valueOf(nilai2.getText())));
    }
}
