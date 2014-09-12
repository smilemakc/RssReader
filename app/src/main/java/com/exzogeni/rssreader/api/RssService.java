package com.exzogeni.rssreader.api;

import com.exzogeni.rssreader.content.Rss;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * @author Daniel Serdyukov
 */
public interface RssService {

    @GET("/{id}")
    Rss feed(@Path("id") String id);

}
