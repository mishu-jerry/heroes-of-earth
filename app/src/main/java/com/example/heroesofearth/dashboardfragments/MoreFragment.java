package com.example.heroesofearth.dashboardfragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.heroesofearth.R;
import com.example.heroesofearth.WebViewActivity;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoreFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View.OnClickListener articleOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String url = "https://climate.nasa.gov/news/2961/new-3d-view-of-methane-tracks-sources-"
                    + "and-movement-around-the-globe/";

            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra("URL", url);
            intent.putExtra("SOURCE_NAME", "climate.nasa.gov");

            startActivity(intent);
        }
    };
    private String mParam1;
    private String mParam2;
    private TextView articleTextView;
    private ImageView articleImageView;
    private RelativeLayout relativeLayout;

    public MoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoreFragment newInstance(String param1, String param2) {
        MoreFragment fragment = new MoreFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_more, container, false);

        articleImageView = rootView.findViewById(R.id.imageViewArticle);
        articleTextView = rootView.findViewById(R.id.textViewArticle);
        relativeLayout = rootView.findViewById(R.id.relativeLayoutButtonArticle);

        try {
            Picasso.with(getContext()).load(R.drawable.methane_sources).placeholder(R.color.colorPrimary)
                    .fit().centerCrop().into(articleImageView);
        } catch (Exception e) {
            Log.v("Jerry", "Failed to load article thumbnail");
        }

        articleTextView.setText("Methane Tracks Sources and Movement around the Globe");

        relativeLayout.setOnClickListener(articleOnClickListener);

        return rootView;
    }
}