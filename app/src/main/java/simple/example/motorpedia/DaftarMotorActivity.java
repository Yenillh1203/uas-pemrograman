package simple.example.motorpedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import simple.example.motorpedia.model.Hewan;

public class DaftarMotorActivity extends AppCompatActivity {
    public final static String MOTOR_TERPILIH ="motor_obj_key";
    List<Hewan> hewans;
    ListView listView;
    String jenisMotor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_motor);
        Intent intent = getIntent();
        jenisMotor = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        TextView txJudul = findViewById(R.id.text_title_daftar);
        txJudul.setText("DAFTAR BERBAGAI "+jenisMotor.toUpperCase());
        hewans = DataProvider.getMotorsByTipe(this,jenisMotor);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_motor);
        DaftarMotorAdapter adapter = new DaftarMotorAdapter(this, hewans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Hewan terpilih = hewans.get(position);
            bukaProfileMotor(terpilih);
        }
    };

    private void bukaProfileMotor(Hewan motorTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(MOTOR_TERPILIH, motorTerpilih);
        startActivity(intent);
    }

}