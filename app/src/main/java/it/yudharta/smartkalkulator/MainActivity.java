package it.yudharta.smartkalkulator;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText nilai1, nilai2, hasil;
    Button btn;
    TextView tvVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilai1 = (EditText) findViewById(R.id.edNilai1);
        nilai2 = (EditText) findViewById(R.id.edNilai2);
        hasil  =  (EditText) findViewById(R.id.edhasil);

        btn = (Button) findViewById(R.id.button);

        tvVoice = (TextView) findViewById(R.id.tvVoice);

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

    public void clickVoice(View v) {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "ucapkan sesuatu");

        try {
            startActivityForResult(i,100);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Suara Tidak didukung perangkat ini", Toast.LENGTH_SHORT).show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 100 : if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                tvVoice.setText(result.get(0));
            }
        }
    }
}
