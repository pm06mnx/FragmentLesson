package ru.pm06mnx.fragmentlesson.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.pm06mnx.fragmentlesson.IButtonClickListener;
import ru.pm06mnx.fragmentlesson.R;

public class ButtonFragment extends Fragment {

    private IButtonClickListener mButtonClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.button_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View button = view.findViewById(R.id.add_text_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonClickListener != null) {
                    mButtonClickListener.onClick();
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IButtonClickListener) {
            mButtonClickListener = (IButtonClickListener) context;
        }
    }
}
