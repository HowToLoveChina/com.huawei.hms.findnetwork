package org.chromium.net.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
import org.chromium.net.UrlResponseInfo;

/* loaded from: classes9.dex */
public final class UrlResponseInfoImpl extends UrlResponseInfo {
    private final HeaderBlockImpl mHeaders;
    private final int mHttpStatusCode;
    private final String mHttpStatusText;
    private final String mNegotiatedProtocol;
    private final String mProxyServer;
    private final AtomicLong mReceivedByteCount;
    private final List<String> mResponseInfoUrlChain;
    private final boolean mWasCached;
    private String quicStats;

    public static final class HeaderBlockImpl extends UrlResponseInfo.HeaderBlock {
        private final List<Map.Entry<String, String>> mAllHeadersList;
        private Map<String, List<String>> mHeadersMap;

        public HeaderBlockImpl(List<Map.Entry<String, String>> list) {
            this.mAllHeadersList = list;
        }

        @Override // org.chromium.net.UrlResponseInfo.HeaderBlock
        public List<Map.Entry<String, String>> getAsList() {
            return this.mAllHeadersList;
        }

        @Override // org.chromium.net.UrlResponseInfo.HeaderBlock
        public Map<String, List<String>> getAsMap() {
            Map<String, List<String>> map = this.mHeadersMap;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, String> entry : this.mAllHeadersList) {
                ArrayList arrayList = new ArrayList();
                if (treeMap.containsKey(entry.getKey())) {
                    arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                }
                arrayList.add(entry.getValue());
                treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
            }
            Map<String, List<String>> mapUnmodifiableMap = Collections.unmodifiableMap(treeMap);
            this.mHeadersMap = mapUnmodifiableMap;
            return mapUnmodifiableMap;
        }
    }

    public UrlResponseInfoImpl(List<String> list, int i10, String str, List<Map.Entry<String, String>> list2, boolean z10, String str2, String str3, long j10) {
        this.mResponseInfoUrlChain = Collections.unmodifiableList(list);
        this.mHttpStatusCode = i10;
        this.mHttpStatusText = str;
        this.mHeaders = new HeaderBlockImpl(Collections.unmodifiableList(list2));
        this.mWasCached = z10;
        this.mNegotiatedProtocol = str2;
        this.mProxyServer = str3;
        this.mReceivedByteCount = new AtomicLong(j10);
    }

    @Override // org.chromium.net.UrlResponseInfo
    public Map<String, List<String>> getAllHeaders() {
        return this.mHeaders.getAsMap();
    }

    @Override // org.chromium.net.UrlResponseInfo
    public List<Map.Entry<String, String>> getAllHeadersAsList() {
        return this.mHeaders.getAsList();
    }

    @Override // org.chromium.net.UrlResponseInfo
    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    @Override // org.chromium.net.UrlResponseInfo
    public String getHttpStatusText() {
        return this.mHttpStatusText;
    }

    @Override // org.chromium.net.UrlResponseInfo
    public String getNegotiatedProtocol() {
        return this.mNegotiatedProtocol;
    }

    @Override // org.chromium.net.UrlResponseInfo
    public String getProxyServer() {
        return this.mProxyServer;
    }

    @Override // org.chromium.net.UrlResponseInfo
    public String getQuicStats() {
        return this.quicStats;
    }

    @Override // org.chromium.net.UrlResponseInfo
    public long getReceivedByteCount() {
        return this.mReceivedByteCount.get();
    }

    @Override // org.chromium.net.UrlResponseInfo
    public String getUrl() {
        return this.mResponseInfoUrlChain.get(r1.size() - 1);
    }

    @Override // org.chromium.net.UrlResponseInfo
    public List<String> getUrlChain() {
        return this.mResponseInfoUrlChain;
    }

    public void setQuicStats(String str) {
        this.quicStats = str;
    }

    public void setReceivedByteCount(long j10) {
        this.mReceivedByteCount.set(j10);
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), getUrlChain().toString(), Integer.valueOf(getHttpStatusCode()), getHttpStatusText(), getAllHeadersAsList().toString(), Boolean.valueOf(wasCached()), getNegotiatedProtocol(), getProxyServer(), Long.valueOf(getReceivedByteCount()));
    }

    @Override // org.chromium.net.UrlResponseInfo
    public boolean wasCached() {
        return this.mWasCached;
    }

    @Deprecated
    public UrlResponseInfoImpl(List<String> list, int i10, String str, List<Map.Entry<String, String>> list2, boolean z10, String str2, String str3) {
        this(list, i10, str, list2, z10, str2, str3, 0L);
    }
}
