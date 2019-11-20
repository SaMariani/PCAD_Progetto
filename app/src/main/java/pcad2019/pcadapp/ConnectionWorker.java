package pcad2019.pcadapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by giorgiodelzanno on 09/03/19.
 */

public class ConnectionWorker extends AsyncTask<String,String,Boolean> {

    private Activity activity;
    private AndroidClient client;
    private String command;
    private String location;
    private String searchedW;
    private String words="INITIALIZED";

    public ConnectionWorker(Activity activity, AndroidClient client, String command, String location, String searchedW, String words) {
        this.activity = activity;
        this.client = client;
        this.command = command;
        this.location = location;
        this.searchedW = searchedW;
        //this.words = "GATTO";
    }


    @Override
    protected Boolean doInBackground(String... strings) { // in base al comando specificato  nel costruttore il thread esegue una delle operazioni
        switch(command) {
            case "research":
                return client.research(location, searchedW);

            case "print":
                Intent intent = new Intent(activity, PrintAllActivity.class);
                words = client.print();
                intent.putExtra("msg2", words);
                activity.startActivity(intent);
                return !words.equals("FAIL");

            case "print3words":
                Intent intent2 = new Intent(activity, SigninActivity.class);
                words = client.print();
                intent2.putExtra("msg2", words);
                activity.startActivity(intent2);
                //words = "prova OK";
                /*words = client.print();
                LoginActivity.wordsToPrint=words;*/
                return !words.equals("FAIL");

            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void onPostExecute(Boolean result){
        switch(command) {
            case "research": {
                if (result) {
                    Toast.makeText(activity, "Ricerca effettuata", Toast.LENGTH_SHORT).show();
                    //words=LoginActivity.EXTRA_MESSAGE_ID;
                    //activity.finish();
                }
                else {
                    Toast.makeText(activity, "TESTO/LOCATION MANCANTE", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "print": {
                if (result) {
                    Toast.makeText(activity, "Stampa effettuata", Toast.LENGTH_SHORT).show();
                }
                else { Toast.makeText(activity, "Impossibile cercare", Toast.LENGTH_SHORT).show();}
                break;
            }
            case "print3words": {
                if (result) {
                    Toast.makeText(activity, "Stampa effettuata: "+words, Toast.LENGTH_SHORT).show();
                    //activity.finish();
                }
                else { Toast.makeText(activity, "Impossibile cercare", Toast.LENGTH_SHORT).show();}
                break;
            }
            default: throw new AssertionError();
        }
    }
}