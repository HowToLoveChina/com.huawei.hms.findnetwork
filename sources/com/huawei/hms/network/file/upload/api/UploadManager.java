package com.huawei.hms.network.file.upload.api;

import android.content.Context;
import com.huawei.hms.network.file.api.Callback;
import com.huawei.hms.network.file.api.RequestManager;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.p136b.C6217d;
import com.huawei.hms.network.file.upload.api.PostRequest;
import com.huawei.hms.network.file.upload.api.PutRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public final class UploadManager extends RequestManager<BodyRequest> {
    private static final String TAG = "UploadManager";
    private static volatile RequestManager singleInstance;
    private static Map<String, RequestManager> managerMap = new ConcurrentHashMap();
    private static final Object LOCK = new Object();

    public static final class Builder extends RequestManager.Builder<Builder> {
        public Builder() {
        }

        public Builder(String str) {
            super(str);
        }

        @Override // com.huawei.hms.network.file.api.RequestManager.Builder
        public UploadManager build(Context context) {
            return new UploadManager(this, context);
        }
    }

    public UploadManager(Builder builder, Context context) {
        super(builder, context);
        if (!Utils.isBlank(builder.getTag())) {
            if (managerMap.containsKey(builder.getTag())) {
                FLogger.m36355w(TAG, "this tag " + builder.getTag() + " is exist", new Object[0]);
            }
            managerMap.put(builder.getTag(), this);
        }
        FLogger.m36353i(TAG, "UploadManager TAG:" + builder.getTag(), new Object[0]);
        injectRequestHandler(new C6217d(context, getTag(), this.globalConfig));
    }

    public static UploadManager getInstance(Context context) {
        if (singleInstance == null) {
            synchronized (LOCK) {
                try {
                    if (singleInstance == null) {
                        singleInstance = new Builder().build(context);
                    }
                } finally {
                }
            }
        }
        return (UploadManager) singleInstance;
    }

    public static PostRequest.Builder newPostRequestBuilder() {
        return new PostRequest.Builder();
    }

    public static PutRequest.Builder newPutRequestBuilder() {
        return new PutRequest.Builder();
    }

    public static UploadManager getInstance(Context context, String str) {
        if (Utils.isBlank(str)) {
            return getInstance(context);
        }
        if (!managerMap.containsKey(str)) {
            synchronized (LOCK) {
                try {
                    if (!managerMap.containsKey(str)) {
                        managerMap.put(str, new Builder(str).build(context));
                    }
                } finally {
                }
            }
        }
        return (UploadManager) managerMap.get(str);
    }

    @Override // com.huawei.hms.network.file.api.RequestManager, com.huawei.hms.network.file.api.IRequestManager
    public Result start(BodyRequest bodyRequest, Callback callback) {
        return super.start((UploadManager) bodyRequest, callback);
    }
}
