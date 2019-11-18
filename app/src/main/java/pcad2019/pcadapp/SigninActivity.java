package pcad2019.pcadapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static pcad2019.pcadapp.LoginActivity.*;

public class SigninActivity extends AppCompatActivity {

    AndroidClient client;
    public static final String EXTRA_MESSAGE_ID = "msg1";
    public static final String EXTRA_MESSAGE_IP = "msg2";
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
        setContentView(R.layout.activity_signin);
        Intent intent = getIntent();
        String s = intent.getStringExtra("msg2");
        TextView idText = (TextView) findViewById(R.id.textView);
        //idText.setText(worker.getWords());
        idText.setText(s);
        //Toast.makeText(this, ip, Toast.LENGTH_SHORT).show();
        //client = new AndroidClient(ip, 5005);
    }

    public void sendSignIn(View view) { // effettua la registrazione dell'utente
        /*EditText idText = (EditText) findViewById(R.id.idText);
        String id = idText.getText().toString();
        EditText nameText = (EditText) findViewById(R.id.nameText);
        String name = nameText.getText().toString();
        EditText surnameText = (EditText) findViewById(R.id.surnameText);
        String surname = surnameText.getText().toString();
        Toast.makeText(this, id+" "+name+" "+surname, Toast.LENGTH_SHORT).show();
        ConnectionWorker asyncTask = new ConnectionWorker(this,client, "signIn", id, name, surname);
        asyncTask.execute();*/
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
