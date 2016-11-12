package com.example.android.challenge;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Brady on 11/11/2016.
 */

public class ChallengeViewHolder extends RecyclerView.ViewHolder {
    ChallengeView challengeView;
    private int difficultyRating;
    private String distance;
    private String peakName;

    public ChallengeViewHolder(ChallengeView challengeView) {
        super(challengeView);
        this.challengeView = challengeView;
    }

    public void bind(Challenge challenge){
        this.peakName = challenge.getPeakName();
        this.difficultyRating = challenge.getDifficultyRating();
        this.distance = challenge.getDistance();

        challengeView.setPeakDist(this.distance);
        challengeView.setPeakName(this.peakName);
        challengeView.setStars(this.difficultyRating);
    }

    public ChallengeView getChallengeView() {
        return challengeView;
    }

    public int getDifficultyRating() {
        return difficultyRating;
    }

    public String getDistance() {
        return distance;
    }

    public String getPeakName() {
        return peakName;
    }
}
