package com.exzogeni.rssreader.content;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Daniel Serdyukov
 */
@Root(name = "rss", strict = false)
public class Rss {

    @Element(name = "channel")
    Channel mChannel;

    public Channel getChannel() {
        return mChannel;
    }

}
