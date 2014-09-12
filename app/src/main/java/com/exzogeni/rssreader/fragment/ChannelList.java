package com.exzogeni.rssreader.fragment;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.exzogeni.rssreader.R;
import com.exzogeni.rssreader.content.Channel;
import com.exzogeni.rssreader.loader.RssLoader;

import java.util.List;

/**
 * @author Daniel Serdyukov
 */
public class ChannelList extends ListFragment implements LoaderManager.LoaderCallbacks<List<Channel>> {

    private ArrayAdapter<Channel> mListAdapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
        setListAdapter(mListAdapter);
        setListShownNoAnimation(false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(R.id.rss_loader, Bundle.EMPTY, this);
    }

    @Override
    public Loader<List<Channel>> onCreateLoader(int id, Bundle args) {
        if (R.id.rss_loader == id) {
            setListShown(false);
            return new RssLoader(getActivity().getApplicationContext());
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<Channel>> loader, List<Channel> channels) {
        if (R.id.rss_loader == loader.getId()) {
            mListAdapter.clear();
            mListAdapter.addAll(channels);
            setListShown(true);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Channel>> loader) {
        if (R.id.rss_loader == loader.getId()) {
            mListAdapter.clear();
        }
    }

}
