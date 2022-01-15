package simple.example.motorpedia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import simple.example.motorpedia.model.Airterjun;
import simple.example.motorpedia.model.Bukit;
import simple.example.motorpedia.model.Hewan;
import simple.example.motorpedia.model.Pantai;

public class GaleriActivity extends AppCompatActivity {

    Hewan hewan;
    TextView txBrand,txMerek,txCc,txDeskripsi;
    ImageView ivFotoMotor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_brand);
        Intent intent = getIntent();
        hewan = (Hewan) intent.getSerializableExtra(DaftarMotorActivity.MOTOR_TERPILIH);
        inisialisasiView();
        tampilkanProfil(hewan);
    }

    private void inisialisasiView() {

        txBrand = findViewById(R.id.txBrand);
        txMerek = findViewById(R.id.txMerek);
        txCc = findViewById(R.id.txCc);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoMotor = findViewById(R.id.gambarMotor);
    }


    private void tampilkanProfil(Hewan hewan) {
        Log.d("HONDA","Menampilkan honda "+hewan.getMerek());
        if (hewan instanceof Pantai) {
            txBrand.setText(getString(R.string.pantai));
        } else if (hewan instanceof Bukit) {
            txBrand.setText(getString(R.string.bukit));
        } else if (hewan instanceof Airterjun) {
            txBrand.setText(getString(R.string.airterjun));
        }

        txBrand.setText(hewan.getBrand());
        txMerek.setText(hewan.getMerek());
        txCc.setText(hewan.getCc());
        txDeskripsi.setText(hewan.getDeskripsi());
        ivFotoMotor.setImageDrawable(this.getDrawable(hewan.getDrawableRes()));
    }
}