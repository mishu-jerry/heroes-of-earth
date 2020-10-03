package com.example.heroesofearth.dashboardfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.heroesofearth.R;
import com.example.heroesofearth.Score;
import com.example.heroesofearth.repository.Repo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProgressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgressFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ProgressBar progressBar;
    private TextView textViewProgress;
    private RelativeLayout rootRelativeLayout;

    public ProgressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProgressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProgressFragment newInstance(String param1, String param2) {
        ProgressFragment fragment = new ProgressFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_progress, container, false);

        progressBar = rootView.findViewById(R.id.progressBar);
        textViewProgress = rootView.findViewById(R.id.textViewProgress);
        rootRelativeLayout = rootView.findViewById(R.id.relativeLayoutRoot);

        int completionRate = Score.getCompletionRate(Repo.dailyChallengesList);

        if (completionRate >= 50) {
            rootRelativeLayout.setBackground(getResources().getDrawable(R.drawable.bg_progress_good));
        } else {
            rootRelativeLayout.setBackground(getResources().getDrawable(R.drawable.bg_progress_bad));
        }

        progressBar.setProgress(completionRate);

        String progressString = completionRate + "%";
        textViewProgress.setText(progressString);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /*private void showProgress() {
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (i < Score.getCompletionRate()) {
                    i += 1;
                    progressBar.setProgress(i);
                }
                try {
                    // Sleep for 100 milliseconds to show the progress slowly.
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/

}