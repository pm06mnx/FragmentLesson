package ru.pm06mnx.fragmentlesson.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import ru.pm06mnx.fragmentlesson.ICharReceiveListener;
import ru.pm06mnx.fragmentlesson.services.GeneratingService;

public class CharBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "CharBroadcastReceiver";

    private ICharReceiveListener mCharReceiveListener;

    public CharBroadcastReceiver(ICharReceiveListener charReceiveListener) {
        mCharReceiveListener = charReceiveListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String chars = intent != null ? intent.getStringExtra(GeneratingService.EXTRA_DATA) : null;
        Log.wtf(TAG, "Received char: "+ chars);
        if (chars != null) {
            mCharReceiveListener.onCharsReceive(chars);
        }
    }
}
