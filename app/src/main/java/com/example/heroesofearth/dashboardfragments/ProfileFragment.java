package com.example.heroesofearth.dashboardfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.heroesofearth.Auth;
import com.example.heroesofearth.R;
import com.example.heroesofearth.Score;
import com.example.heroesofearth.pojos.User;
import com.example.heroesofearth.repository.Repo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView experienceLevelTextView;
    TextView completionRateNameTextView;
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView profileNameTextView = rootView.findViewById(R.id.textViewProfileName);
        TextView ageTextView = rootView.findViewById(R.id.textViewAge);
        TextView locationTextView = rootView.findViewById(R.id.textViewLocation);
        experienceLevelTextView = rootView.findViewById(R.id.textViewExperience);
        completionRateNameTextView = rootView.findViewById(R.id.textViewCompletionRate);

        User user = Auth.getCurrentUser();

        profileNameTextView.setText(user.getProfileName());

        String ageText = "Age: " + user.getAge();
        ageTextView.setText(ageText);

        String locationText = "Location: " + user.getLocation();
        locationTextView.setText(locationText);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        String experienceLevelString = "Experience Level: " + Score.getExperienceLevel();

        String completionRateString = "Completion Rate: "
                + Score.getCompletionRate(Repo.dailyChallengesList) + "%";

        experienceLevelTextView.setText(experienceLevelString);
        completionRateNameTextView.setText(completionRateString);
    }
}