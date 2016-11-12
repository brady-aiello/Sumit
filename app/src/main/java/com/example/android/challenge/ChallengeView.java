package com.example.android.challenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Brady on 11/11/2016.
 */

public class ChallengeView extends LinearLayout{
    TextView distanceTextView, peakNameTextView;
    RatingBar ratingBar;

    String peakName, peakDist;
    int stars;

    public ChallengeView(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);
        inflater.inflate(R.layout.view_challenge, this, true);
        this.distanceTextView = (TextView) findViewById(R.id.tv_distance);
        this.peakNameTextView = (TextView) findViewById(R.id.tv_peak_name);
        this.ratingBar = (RatingBar) findViewById(R.id.rb_stars);
        this.requestLayout();

    }

    public void setPeakName(String peakName){
        this.peakName = peakName;
        this.peakNameTextView.setText(peakName);
    }

    public void setPeakDist(String peakDist) {
        this.peakDist = peakDist;
        this.distanceTextView.setText(peakDist);
    }

    public void setStars(int stars) {
        this.stars = stars;
        this.ratingBar.setRating(stars);
    }
}
