package pcad2019.pcadapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PrintAllActivity extends AppCompatActivity {
    private String IPstring ;

    private boolean checkIp(){ // controlla se è stato inserito un indirizzo ip
        if ( IPstring == null ){
            Toast.makeText(this, "Indirizzo IP mancante", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_all);
        Intent intent = getIntent();
        String s = intent.getStringExtra("msg2");
        TextView idText = (TextView) findViewById(R.id.textView);
        idText.setText(s);
    }

    public void doPrint(View view) { // avvia activity per la stampa 3 words
        if (!checkIp()) return;
        Intent intent = new Intent(this, SigninActivity.class);
        //intent.putExtra("msg2", IPstring);
        //startActivity(intent);
        AndroidClient client = new AndroidClient(IPstring , 5005);
        ConnectionWorker worker = new ConnectionWorker(this,client,"print", null,null, null);
        worker.execute();
    }
}
