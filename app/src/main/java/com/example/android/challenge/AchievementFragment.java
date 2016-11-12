package com.example.android.challenge;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class AchievementFragment extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        ChallengeDescriptionActivity challengeDescriptionActivity = (ChallengeDescriptionActivity)getActivity();
        String peakName = challengeDescriptionActivity.getPeakName();
        LayoutInflater inflater = challengeDescriptionActivity.getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_achievement, null);
        TextView textView = (TextView)view.findViewById(R.id.tv_congrats);
        textView.setText("You completed " + peakName  + "!");
        builder.setView(view);
        return builder.create();
    }
}
