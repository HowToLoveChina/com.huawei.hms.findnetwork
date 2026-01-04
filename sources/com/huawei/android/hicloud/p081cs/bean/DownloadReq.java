package com.huawei.android.hicloud.p081cs.bean;

import com.huawei.android.hicloud.connect.progress.ICallback;
import java.util.Map;

/* loaded from: classes3.dex */
public class DownloadReq {
    private ICallback callback;
    private String hash;
    private long length;
    private String local;
    private Map<String, String> params;
    private String url;

    public DownloadReq(String str, String str2, String str3, long j10, ICallback iCallback) {
        this.url = str;
        this.local = str2;
        this.hash = str3;
        this.length = j10;
        this.callback = iCallback;
    }

    private <T> T commonSetFunction(T t10) {
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public ICallback getCallback() {
        return (ICallback) commonSetFunction(this.callback);
    }

    public String getHash() {
        return (String) commonSetFunction(this.hash);
    }

    public long getLength() {
        return ((Long) commonSetFunction(Long.valueOf(this.length))).longValue();
    }

    public String getLocal() {
        return (String) commonSetFunction(this.local);
    }

    public Map<String, String> getParams() {
        return (Map) commonSetFunction(this.params);
    }

    public String getUrl() {
        return (String) commonSetFunction(this.url);
    }

    public void setCallback(ICallback iCallback) {
        this.callback = (ICallback) commonSetFunction(iCallback);
    }

    public void setHash(String str) {
        this.hash = (String) commonSetFunction(str);
    }

    public void setLength(long j10) {
        this.length = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setLocal(String str) {
        this.local = (String) commonSetFunction(str);
    }

    public void setParams(Map<String, String> map) {
        this.params = (Map) commonSetFunction(map);
    }

    public void setUrl(String str) {
        this.url = (String) commonSetFunction(str);
    }
}
