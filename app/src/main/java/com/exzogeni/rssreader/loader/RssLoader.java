package com.exzogeni.rssreader.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.exzogeni.rssreader.api.RssService;
import com.exzogeni.rssreader.content.Channel;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.SimpleXMLConverter;

/**
 * @author Daniel Serdyukov
 */
public class RssLoader extends AsyncTaskLoader<List<Channel>> {

    private List<Channel> mChannel;

    public RssLoader(Context context) {
        super(context);
    }

    @Override
    public List<Channel> loadInBackground() {
        final ArrayList<Channel> channels = new ArrayList<Channel>();
        // RestAdapter adapter = new RestAdapter.Builder()
        //      .setEndpoint("http://news.yandex.ru/")
        //      .setConverter(new SimpleXMLConverter())
        //      .build();
        // RssService service = adapter.create(RssService.class);
        // Channel channel = service.feed("index.rss");
        // channels.add(channel);
        channels.add(new RestAdapter.Builder()
                .setEndpoint("http://news.yandex.ru/")
                .setConverter(new SimpleXMLConverter())
                .build()
                .create(RssService.class)
                .feed("index.rss")
                .getChannel());
        return channels;
    }


    @Override
    public void deliverResult(List<Channel> data) {
        mChannel = data;
        super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {
        if (mChannel == null) {
            forceLoad();
        } else {
            deliverResult(mChannel);
        }
    }

}
