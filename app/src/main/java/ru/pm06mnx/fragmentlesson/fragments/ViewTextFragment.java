package ru.pm06mnx.fragmentlesson.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewTextFragment extends Fragment {

    private static final String EXTRA_TEXTS = "ViewTextFragment.EXTRA_TEXTS";

    public static ViewTextFragment newInstance(ArrayList<String> texts) {
        ViewTextFragment viewTextFragment = new ViewTextFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(EXTRA_TEXTS, texts);
        viewTextFragment.setArguments(bundle);
        return viewTextFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        ArrayList<String> texts = getArguments().getStringArrayList(EXTRA_TEXTS);
        if (texts != null && !texts.isEmpty()) {
            for (String text : texts) {
                TextView textView = new TextView(getContext());
                textView.setText(text);
                layout.addView(textView);
            }
        }
        return layout;
    }
}
