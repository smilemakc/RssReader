package com.exzogeni.rssreader.activity;

import android.app.Activity;
import android.os.Bundle;

import com.exzogeni.rssreader.R;
import com.exzogeni.rssreader.fragment.ChannelList;

/**
 * @author Daniel Serdyukov
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame, new ChannelList())
                    .commit();
        }
    }

}
