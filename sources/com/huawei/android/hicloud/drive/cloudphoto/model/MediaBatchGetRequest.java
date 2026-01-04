package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class MediaBatchGetRequest extends C11707b {

    @InterfaceC4648p
    private List<String> ids;

    public List<String> getIds() {
        return this.ids;
    }

    public void setIds(List<String> list) {
        this.ids = list;
    }
}
