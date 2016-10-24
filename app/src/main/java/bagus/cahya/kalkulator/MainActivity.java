package bagus.cahya.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nil1 = Integer.parseInt(String.valueOf(nilai1.getText()));
                int nil2 = Integer.parseInt(String.valueOf(nilai2.getText()));
                String hsl = String.valueOf(nil1 + nil2);

                hasil.setText(hsl);
            }
        });
    }

    public int tambah(int nil1, int nil2) {
        return nil1 + nil2;
    }

    public int kurang(int nil1, int nil2) {
        return nil1 - nil2;
    }
}
