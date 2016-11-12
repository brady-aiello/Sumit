package com.example.android.challenge;

import android.content.Context;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Brady on 11/11/2016.
 */

public class ChallengeListAdapter extends RecyclerView.Adapter<ChallengeViewHolder> {
    private Context context;
    private ChallengeActivity listActivity;
    private List<Challenge> challengeList;
    private int selected_position;
    private ActionMode.Callback actionCallBack;
    private ActionMode actionMode;

    public ChallengeListAdapter(final Context context, List<Challenge> challengeList, final ChallengeActivity listActivity) {
        this.context = context;
        this.challengeList = challengeList;
        this.listActivity = listActivity;
    }

    @Override
    public ChallengeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ChallengeView challengeView = new ChallengeView(this.context);
        return new ChallengeViewHolder(challengeView);
    }

    @Override
    public void onBindViewHolder(final ChallengeViewHolder holder, int position) {
        final Challenge challenge = this.challengeList.get(position);
        holder.challengeView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (actionMode != null) {
                    return false;
                }
                actionMode = listActivity.startSupportActionMode(actionCallBack);
                selected_position = holder.getAdapterPosition();
                return true;
            }
        });
        holder.bind(challenge);
    }
    @Override
    public int getItemCount() {
        if (challengeList == null)
            return 0;
        else
            return challengeList.size();
    }
}
