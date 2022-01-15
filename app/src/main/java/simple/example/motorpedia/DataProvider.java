package simple.example.motorpedia;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import simple.example.motorpedia.model.Airterjun;
import simple.example.motorpedia.model.Bukit;
import simple.example.motorpedia.model.Hewan;
import simple.example.motorpedia.model.Pantai;

public class DataProvider {
    private static List<Hewan> hewans = new ArrayList<>();

    private static List<Pantai> initDataAyam(Context ctx) {
        List<Pantai>pantais = new ArrayList<>();
        pantais.add(new Pantai(ctx.getString(R.string.pink_pantai), ctx.getString(R.string.pink_asal),
                ctx.getString(R.string.pink_deskripsi), R.drawable.pantaipink));
        pantais.add(new Pantai(ctx.getString(R.string.kurakura_pantai), ctx.getString(R.string.kurakura_asal),
                ctx.getString(R.string.kurakura_deskripsi), R.drawable.pantaikurakura));
        pantais.add(new Pantai(ctx.getString(R.string.penyisok_pantai), ctx.getString(R.string.kurakura_asal),
                ctx.getString(R.string.penyisok_deskripsi), R.drawable.pantaipenyisok));
        pantais.add(new Pantai(ctx.getString(R.string.semeti_pantai), ctx.getString(R.string.semeti_asal),
                ctx.getString(R.string.semeti_deskripsi), R.drawable.pantaisemeti));

        return pantais;
    }

    private static List<Airterjun> initDataPuyuh(Context ctx) {
        List<Airterjun>airterjuns= new ArrayList<>();
        airterjuns.add(new Airterjun(ctx.getString(R.string.skeper_airterjun), ctx.getString(R.string.skeper_asal),
                ctx.getString(R.string.skeper_deskripsi), R.drawable.skeper));
        airterjuns.add(new Airterjun(ctx.getString(R.string.benangkelambu_airteerjun), ctx.getString(R.string.benangkelambu_asal),
                ctx.getString(R.string.benangkelambu_deskripsi), R.drawable.benangkelambu));
        airterjuns.add(new Airterjun(ctx.getString(R.string.tiukelep_airterjun), ctx.getString(R.string.tiukelep_asal),
                ctx.getString(R.string.tiukelep_deskripsi), R.drawable.tiukelep));
        airterjuns.add(new Airterjun(ctx.getString(R.string.jerukmanis_airterjun), ctx.getString(R.string.jerukmanis_asal),
                ctx.getString(R.string.jerukmanis_deskripsi), R.drawable.pantaipenyisok));

        return airterjuns;
    }

    private static List<Bukit> initDataItik(Context ctx) {
        List<Bukit>bukits= new ArrayList<>();
        bukits.add(new Bukit(ctx.getString(R.string.nanggi_bukit),ctx.getString(R.string.nanggi_asal),
                ctx.getString(R.string.nanggi_deskripsi), R.drawable.nanggi));
        bukits.add(new Bukit(ctx.getString(R.string.palljepang_bukit), ctx.getString(R.string.palljepang_asal),
                ctx.getString(R.string.palljepang_deskripsi), R.drawable.palljepang));
        bukits.add(new Bukit(ctx.getString(R.string.anakdara_deskripsi), ctx.getString(R.string.anakdara_asal),
                ctx.getString(R.string.anakdara_deskripsi), R.drawable.anakdara));
        bukits.add(new Bukit(ctx.getString(R.string.sempana_bukit), ctx.getString(R.string.sempana_asal),
                ctx.getString(R.string.sempana_deskripsi), R.drawable.sempana));
        return bukits;
    }

    private static void initAllMotors(Context ctx) {
        hewans.addAll(initDataAyam(ctx));
        hewans.addAll(initDataPuyuh(ctx));
        hewans.addAll(initDataItik(ctx));
    }

    public static List<Hewan> getAllMotor(Context ctx) {
        if (hewans.size() == 0) {
            initAllMotors(ctx);
        }
        return  hewans;
    }

    public static List<Hewan> getMotorsByTipe(Context ctx, String merek) {
        List<Hewan> motorsByType = new ArrayList<>();
        if (hewans.size() == 0) {
            initAllMotors(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getMerek().equals(merek)) {
                motorsByType.add(h);
            }
        }
        return motorsByType;
    }

}
