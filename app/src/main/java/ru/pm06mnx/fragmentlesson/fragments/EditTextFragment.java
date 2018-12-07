package ru.pm06mnx.fragmentlesson.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import ru.pm06mnx.fragmentlesson.R;

public class EditTextFragment extends Fragment {

    private EditText mEditText;
    private ArrayList<String> mTexts = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.edit_text_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditText = view.findViewById(R.id.edit_text);
    }

    public void addChars(String chars) {
        mEditText.getText().append(chars);
    }

    public void addText() {
        String text = mEditText.getText().toString();
        if (!text.isEmpty()) {
            mTexts.add(text);
            updateViewTextFragment();
            mEditText.setText("");
        }
    }

    public void clearTexts() {
        mTexts.clear();
        updateViewTextFragment();
    }

    private void updateViewTextFragment() {
        getFragmentManager().beginTransaction().replace(R.id.view_text_container, ViewTextFragment.newInstance(mTexts)).commit();
    }
}
