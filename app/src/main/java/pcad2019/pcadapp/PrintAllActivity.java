package pcad2019.pcadapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class PrintAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_all);
        Intent intent = getIntent();
        String s = intent.getStringExtra("msg2");
        String [] SplitW = s.split("], ");
        String f="";
        if(SplitW[0].isEmpty())
            f="Non hai cercato ancora nessuna parola";
        else {
            for (int i = 0; i < SplitW.length && !SplitW[0].isEmpty(); ++i)
                f = f.concat(SplitW[i].concat("]\n"));
        }
        TextView idText = (TextView) findViewById(R.id.textView);
        idText.setMovementMethod(new ScrollingMovementMethod());
        idText.setText(f);
    }

    public void doGoBack(View view) { // avvia activity per la stampa 3 words
        finish();
    }
}
