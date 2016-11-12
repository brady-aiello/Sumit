package com.example.android.challenge;

/**
 * Created by Brady on 11/11/2016.
 */

public class Challenge {
    private int difficultyRating;
    private String distance;
    private String peakName;

    public Challenge(int difficultyRating, String distance, String peakName) {
        this.difficultyRating = difficultyRating;
        this.distance = distance;
        this.peakName = peakName;
    }

    public int getDifficultyRating() {
        return difficultyRating;
    }

    public void setDifficultyRating(int difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPeakName() {
        return peakName;
    }

    public void setPeakName(String peakName) {
        this.peakName = peakName;
    }
}
