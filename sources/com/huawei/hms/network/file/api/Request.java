package com.huawei.hms.network.file.api;

import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.p136b.C6214a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class Request {
    static final int MAX_BYTES = 1073741824;
    protected final List<String> backupUrls;
    protected final RequestConfig config;
    protected final Converter converter;
    protected final Map<String, String> headers;

    /* renamed from: id */
    protected long f29341id;
    protected final String name;
    protected final Map<String, String> params;
    protected final Map<String, String> reportInfos;
    protected int speedLimit;
    protected final String url;

    public static abstract class Builder<T extends Builder> {
        private List<String> backupUrls;
        private RequestConfig config;
        protected Converter converter;
        private Map<String, String> headers;

        /* renamed from: id */
        private long f29342id;
        private String name;
        private Map<String, String> params;
        private Map<String, String> reportInfos;
        private int speedLimit;
        private String url;

        public Builder() {
            this.backupUrls = new ArrayList();
            this.headers = new HashMap();
            this.params = new HashMap();
            this.reportInfos = new HashMap();
            this.name = "defaultName";
            this.f29342id = Utils.getLongId();
            this.converter = new C6214a();
            this.config = new RequestConfig.RequestConfBuilder().build();
        }

        public T backupUrls(List<String> list) {
            if (list != null) {
                this.backupUrls.addAll(list);
            }
            return this;
        }

        public abstract Request build();

        public T config(RequestConfig requestConfig) {
            this.config = requestConfig;
            return this;
        }

        public T converter(Converter converter) {
            this.converter = converter;
            return this;
        }

        public T headers(Map<String, String> map) {
            this.headers = Request.cloneMaps(map);
            return this;
        }

        /* renamed from: id */
        public T m36137id(long j10) {
            this.f29342id = j10;
            return this;
        }

        public T name(String str) {
            this.name = str;
            return this;
        }

        public T params(Map<String, String> map) {
            this.params = Request.cloneMaps(map);
            return this;
        }

        public T reportInfos(Map<String, String> map) {
            this.reportInfos = Request.cloneMaps(map);
            return this;
        }

        public T speedLimit(int i10) {
            if (i10 <= 0 || i10 > Request.MAX_BYTES) {
                i10 = 0;
            }
            this.speedLimit = i10;
            return this;
        }

        public T url(String str) {
            this.url = str;
            return this;
        }

        public Builder(Request request) {
            this();
            if (request != null) {
                this.f29342id = request.f29341id;
                this.url = request.url;
                ArrayList arrayList = new ArrayList();
                this.backupUrls = arrayList;
                arrayList.addAll(request.backupUrls);
                this.config = request.config;
                this.headers = Request.cloneMaps(request.headers);
                this.params = Request.cloneMaps(request.params);
                this.reportInfos = Request.cloneMaps(request.reportInfos);
                this.name = request.name;
                this.converter = request.converter;
                this.speedLimit = request.speedLimit;
            }
        }
    }

    public Request(Builder builder) {
        this.f29341id = builder.f29342id;
        this.url = builder.url;
        ArrayList arrayList = new ArrayList();
        this.backupUrls = arrayList;
        arrayList.addAll(builder.backupUrls);
        this.config = builder.config;
        this.headers = cloneMaps(builder.headers);
        this.params = cloneMaps(builder.params);
        this.reportInfos = cloneMaps(builder.reportInfos);
        this.name = builder.name;
        this.converter = builder.converter;
        this.speedLimit = builder.speedLimit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> cloneMaps(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    public List<String> getBackupUrls() {
        return Collections.unmodifiableList(this.backupUrls);
    }

    public RequestConfig getConfig() {
        return this.config;
    }

    public Converter getConverter() {
        return this.converter;
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    public long getId() {
        return this.f29341id;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, String> getParams() {
        return Collections.unmodifiableMap(this.params);
    }

    public Map<String, String> getReportInfos() {
        return Collections.unmodifiableMap(this.reportInfos);
    }

    public int getSpeedLimit() {
        return this.speedLimit;
    }

    public String getUrl() {
        return this.url;
    }

    public abstract Builder newBuilder();

    public String toString() {
        return "Request{config=" + this.config + ", name='" + this.name + "', id=" + this.f29341id + ", speedLimit=" + this.speedLimit + '}';
    }
}
