package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import java.util.concurrent.Callable;
import p031b7.C1120a;
import p251e8.C9423b;
import p850zo.InterfaceC14352c;

/* loaded from: classes2.dex */
public class QueryUnSavedOriginalsCallable implements Callable {
    private static final String TAG = "QueryUnSavedOriginalsCallable";
    private Context context;
    private InterfaceC14352c queryListener;
    private QueryType queryType;

    public enum QueryType {
        UNSAVED_NUM,
        UNSAVED_SIZE
    }

    public QueryUnSavedOriginalsCallable(Context context, QueryType queryType, InterfaceC14352c interfaceC14352c) {
        this.context = context;
        this.queryListener = interfaceC14352c;
        this.queryType = queryType;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        if (this.queryListener == null) {
            throw new IllegalArgumentException("the queryListener can not be null");
        }
        if (this.context == null) {
            throw new IllegalArgumentException("Context can not be null");
        }
        int iM59100h = -1;
        long jM59101i = -1;
        if (CloudAlbumSettings.m14363h().m14385u()) {
            QueryType queryType = this.queryType;
            if (queryType == QueryType.UNSAVED_NUM) {
                iM59100h = C9423b.m59100h(this.context);
            } else if (queryType == QueryType.UNSAVED_SIZE) {
                jM59101i = C9423b.m59101i(this.context);
            }
        } else {
            C1120a.m6676e(TAG, "queryRealPathEmptyCount version error");
        }
        this.queryListener.mo13561a(iM59100h, jM59101i);
        return null;
    }
}
