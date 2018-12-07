package ru.pm06mnx.fragmentlesson;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.pm06mnx.fragmentlesson.broadcast.CharBroadcastReceiver;
import ru.pm06mnx.fragmentlesson.fragments.EditTextFragment;
import ru.pm06mnx.fragmentlesson.services.GeneratingService;

public class MainActivity extends AppCompatActivity implements IButtonClickListener, ICharReceiveListener {

    private EditTextFragment mEditTextFragment;
    private CharBroadcastReceiver mCharBroadcastReceiver;
    private IntentFilter mBroadcastFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextFragment = (EditTextFragment) getSupportFragmentManager().findFragmentById(R.id.edit_text_fragment);
        mCharBroadcastReceiver = new CharBroadcastReceiver(this);
        mBroadcastFilter = new IntentFilter(GeneratingService.BROADCAST_FILTER);

        startService(GeneratingService.newIntent(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mCharBroadcastReceiver, mBroadcastFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mCharBroadcastReceiver);
    }

    @Override
    public void onClick() {
        mEditTextFragment.addText();
    }

    @Override
    public void onCharsReceive(String chars) {
        mEditTextFragment.addChars(chars);
    }
}
