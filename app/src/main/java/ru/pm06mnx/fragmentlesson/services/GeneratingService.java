package ru.pm06mnx.fragmentlesson.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Сервис для генерации рандомных символов и отправки их через Broadcast
 */
public class GeneratingService extends IntentService {

    public static final String BROADCAST_FILTER = "ru.pm06mnx.fragmentlesson.CHAR_BROADCAST";
    public static final String EXTRA_DATA = "DATA";

    private static final String TAG = "GenerationService";

    private final char[] chars;

    public GeneratingService() {
        super(TAG);
        chars = new char[26];
        int pos = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            chars[pos++] = ch;
        }
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        while (true) {
            safeSleep(3000);
            String generatedChar = getRandomChar();
            Log.wtf(TAG, "Generated char: "+generatedChar);
            sendCharBroadcast(generatedChar);
        }
    }

    private void safeSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Log.w(TAG, "Interrupted!");
        }
    }

    private String getRandomChar() {
        int pos = (int) Math.floor(Math.random() * chars.length);
        return String.valueOf(chars[pos]);
    }


    private void sendCharBroadcast(String generatedChar) {
        Intent intent = new Intent(BROADCAST_FILTER);
        intent.putExtra(EXTRA_DATA, generatedChar);
        intent.setFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }


    public static Intent newIntent(Context context) {
        return new Intent(context, GeneratingService.class);
    }
}
