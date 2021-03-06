package com.example.hp.germanarticles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Article extends AppCompatActivity {

    String[] wordArray ;
    private AdView  mAdviewAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        mAdviewAd = (AdView)findViewById(R.id.adView);
        initializeBannerAd("ca-app-pub-6189499490928275~3401756754");
        loadBannerAd("ca-app-pub-6189499490928275/4436750216");

        Bundle b;
        b = getIntent().getExtras();
        String name = b.getString("name");

        TextView textView = (TextView) findViewById(R.id.headingText);
        textView.setText(name);

        if(name.equalsIgnoreCase("das")){
            wordArray = new String[]{"-chen","-lein","-ment","-nis","-tum","-um"};
        }
        else if(name.equalsIgnoreCase("der")){
            wordArray = new String[]{"-ant","-ig","-ling","-us","-er","-en","-or","-is","-ismus"};
        }
        else if(name.equalsIgnoreCase("die")){
            wordArray = new String[]{"-e","-ei","-schaft","-heit","-keit","-ung","-tät","-ik","-ion","-ur","-enz"};
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, wordArray);


        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

    }
    public void initializeBannerAd(String s){
        MobileAds.initialize(this, s);
    }
    public void loadBannerAd(String s){
        mAdviewAd.loadAd(new AdRequest.Builder().build());
    }
}
