package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class MediaList extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private List<Media> media;

    @InterfaceC4648p
    private String nextCursor;

    public String getCategory() {
        return this.category;
    }

    public List<Media> getMedia() {
        return this.media;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setMedia(List<Media> list) {
        this.media = list;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }
}
