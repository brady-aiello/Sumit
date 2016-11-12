package com.example.android.challenge;

import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ChallengeDescriptionActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewDescription;
    TextView textViewPeakName;
    RatingBar ratingBar;
    int rating;
    String peakName;
    String distance;
    private NfcAdapter mNfcAdapter;
    private PendingIntent pendingIntent;

    public String getPeakName() {
        return peakName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_description);
        imageView = (ImageView)findViewById(R.id.map);
        textViewPeakName = (TextView)findViewById(R.id.tv_peak_name_description);
        textViewDescription = (TextView) findViewById(R.id.tv_challenge_description);
        ratingBar = (RatingBar) findViewById(R.id.rating_bar_in_description);

        final Intent intent = getIntent();
        rating = intent.getIntExtra("rating", 0);
        peakName = intent.getStringExtra("peakName");
        distance = intent.getStringExtra("distance");

        ratingBar.setRating(rating);
        textViewPeakName.setText(peakName);
        setImage(this, imageView, peakName);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        pendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
    }

    @Override
    public void onNewIntent(Intent intent) {
        byte[] tagId = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);
        String hfid = new String();
        for (int i = 0; i < tagId.length; i++)
        {
            String x = Integer.toHexString(((int) tagId[i] & 0xff));
            if (x.length() == 1) {
                x = '0' + x;
            }
            hfid += x;
        }
        Log.d("Peak scanned", "Scanned Tag ID " + hfid);
        AchievementFragment achievementFragment = new AchievementFragment();
        achievementFragment.show(getSupportFragmentManager(), "Tag");
    }


    @Override
    public void onResume()
    {
        super.onResume();
        if(mNfcAdapter != null) {
            mNfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNfcAdapter.disableForegroundDispatch(this);
    }

    private static void setImage(Context context, ImageView imageView, String peakName){
        Drawable drawable;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        switch (peakName){
            case "Madonna":
                drawable = resources.getDrawable(R.drawable.madonna_peak, theme);
                imageView.setImageDrawable(drawable);
                break;
            case "Bishops":
                drawable = resources.getDrawable(R.drawable.bishops_peak, theme);
                imageView.setImageDrawable(drawable);
                break;
            case "Bob Jones Trail":
                drawable = resources.getDrawable(R.drawable.bob_jones_trail, theme);
                imageView.setImageDrawable(drawable);
                break;
            case "Harmony Headlands":
                drawable = resources.getDrawable(R.drawable.harmony_headlands_trail, theme);
                imageView.setImageDrawable(drawable);
                break;
            case "Valencia Peak":
                drawable = resources.getDrawable(R.drawable.valencia_peak, theme);
                imageView.setImageDrawable(drawable);
                break;
            case "Johnson Trail":
                drawable = resources.getDrawable(R.drawable.johnson_ranch, theme);
                imageView.setImageDrawable(drawable);
                break;
            case "Mariposa":
                drawable = resources.getDrawable(R.drawable.mariposa_peak, theme);
                imageView.setImageDrawable(drawable);
                break;
            default:
                drawable = resources.getDrawable(R.drawable.bishops_peak, theme);
                imageView.setImageDrawable(drawable);
                break;

        }

    }
}
