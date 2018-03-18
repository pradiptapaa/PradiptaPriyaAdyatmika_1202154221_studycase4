package pradipta.si3905.com.pradiptapriyaadyatmika_1202154221_studycase4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    Async async;
    ArrayAdapter<String> adapter;
    String[] nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

    }

    public void onSaveInstanceState(Bundle savedState) {
        super.onSaveInstanceState(savedState);
    }



    public void tampil(View view) {

        //buat object dari class Async
        async = new Async();

        //jalankan object async
        async.execute();


        //Mengambil ListView
        listView = (ListView) findViewById(R.id.list);


        //Memberikan nilai array untuk ditampilkan pada ListView
        nama = new String[]{"Pradipta", "Dhimas","Dipta","Chandra","Tyas"};

        /*
         Membbuat adapter
            Parameter pertama = context
                Parameter kedua = layout untuk baris
                    Parameter ketiga = ID TextView dimana data akan tertulis
                        Parameter keempat = array datanya.
         */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, nama);

        //pasang adapter ke ListView
        listView.setAdapter(adapter);
    }

    class Async extends AsyncTask<Void, Integer, Void>{
        ProgressDialog progressDialog;
        int progressStatus = 0;

        //pada preExecute
        protected void onPreExecute() {
            super.onPreExecute();

            //buat progress dialog
            progressDialog = new ProgressDialog(ListActivity.this);
            //buat tittle untuk progressdialog
            progressDialog.setTitle("Loading Data");
            //buat button cancel pada progress dialog
            progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel Process", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            //tampilkan progress dialog
            progressDialog.show();
        }


        protected Void doInBackground(Void...params){
            //progress dari dari 0
            progressStatus = 0;

            //sementara progress masih kurang dari 100
            while(progressStatus<100){
                try{

                    //thread sleep selama 100ms
                    Thread.sleep(100);

                    //dan progressStatus bertambah 5
                    progressStatus+=5;

                }
                //jika ada error, lempar exception
                catch (Exception e){
                    Log.d("Exception", e.toString());
                }

                //tampilkan progress
                publishProgress(progressStatus);
            }
            return null;
        }

        protected  void onProgressUpdate(Integer...values){
            super.onProgressUpdate(values);
            //buat pesan pada progress dialog berisi values ditambah %
            progressDialog.setMessage(String.valueOf(values[0])+"%");
        }

        protected void onPostExecute(Void result){
            super.onPostExecute(result);
            //setelah eksekusi, progress dialog dimatikan
            progressDialog.dismiss();
        }
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
