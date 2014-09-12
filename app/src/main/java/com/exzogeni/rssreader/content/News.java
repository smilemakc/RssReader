package com.exzogeni.rssreader.content;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Daniel Serdyukov
 */
@Root(name = "item", strict = false)
public class News {

    @Element(name = "title")
    private String mTitle;

    @Element(name = "link")
    private String mLink;

    @Element(name = "pubDate")
    private String mPubDate;

}
