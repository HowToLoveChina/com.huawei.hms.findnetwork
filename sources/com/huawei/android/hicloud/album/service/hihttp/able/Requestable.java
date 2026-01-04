package com.huawei.android.hicloud.album.service.hihttp.able;

import com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener;
import p701v6.AbstractC13354a;
import p731w7.AbstractC13540g;

/* loaded from: classes2.dex */
public interface Requestable {
    <T> void request(int i10, String str, AbstractC13540g<T> abstractC13540g, AbstractC13354a abstractC13354a, OnResponseListener<T> onResponseListener);

    <T> void requestSingle(int i10, AbstractC13540g<T> abstractC13540g, AbstractC13354a abstractC13354a, OnResponseListener<T> onResponseListener);
}
