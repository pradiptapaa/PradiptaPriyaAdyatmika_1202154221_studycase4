package pradipta.si3905.com.pradiptapriyaadyatmika_1202154221_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //dekralasikan variabel yang akan digunakan
    Button list, src;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pasang view ke variabel yang telah dideklarasikan
        list = (Button) findViewById(R.id.btnList);
        src = (Button) findViewById(R.id.btnSrc);


    }

    //jika button list ditekan
    public void pindahList(View view) {
        //pindah ke listActivity
        startActivity(new Intent(this, ListActivity.class));
    }

    //jika button search ditekan
    public void pindahSrc(View view) {
        //pindah ke pencariActivity
        startActivity(new Intent(this, PencariActivity.class));
    }
}
