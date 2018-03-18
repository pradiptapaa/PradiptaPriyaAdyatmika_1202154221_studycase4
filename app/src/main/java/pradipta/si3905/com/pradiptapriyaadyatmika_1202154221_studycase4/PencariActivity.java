package pradipta.si3905.com.pradiptapriyaadyatmika_1202154221_studycase4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class PencariActivity extends AppCompatActivity {
    //deklarasikan variabel yang akan digunakan
    EditText urls;
    Button src;
    ImageView gambar;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencari);

        //definisikan variabel yang didklarasikan dengan ID
        urls = (EditText) findViewById(R.id.urlInput);
        src = (Button) findViewById(R.id.btnSrc);
        gambar = (ImageView) findViewById(R.id.gambarUrl);

        //menghilangkan imageView sebelumnya
        gambar.setVisibility(View.INVISIBLE);

    }

    //saat button ditekan
    public void cari(View view) {
        //tampilkan imageView
        gambar.setVisibility(View.VISIBLE);
        //ambil url dari EditText lalu ubah ke string
        url = urls.getText().toString();

        //panggil method loadImageFromUrl
        loadImageFromUrl(url);
    }


    //buat method loadImageFromUrl
    public void loadImageFromUrl(String url){

        //jika url-nya kosong
        if (url.isEmpty()){
            //pasang gambar launcher_background
            gambar.setImageResource(R.drawable.ic_launcher_background);
            Toast.makeText(this, "Url-nya tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else {
            //jika berisi, load url menggunakan picasso ke imageView
            Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                    .into(gambar);
            Toast.makeText(this, "Load Gambar Berhasil", Toast.LENGTH_SHORT).show();
        }
    }
}
