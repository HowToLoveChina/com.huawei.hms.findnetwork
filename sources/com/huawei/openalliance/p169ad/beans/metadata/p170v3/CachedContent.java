package com.huawei.openalliance.p169ad.beans.metadata.p170v3;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class CachedContent implements Serializable {
    private static final long serialVersionUID = 3809421214062903233L;
    private Integer apiVer;
    private String contentId;
    private List<String> templateIds;

    public CachedContent() {
        this.apiVer = 2;
    }

    /* renamed from: a */
    public String m40521a() {
        return this.contentId;
    }

    /* renamed from: b */
    public Integer m40522b() {
        return this.apiVer;
    }

    /* renamed from: c */
    public List<String> m40523c() {
        return this.templateIds;
    }

    public CachedContent(String str, Integer num, List<String> list) {
        this.contentId = str;
        this.apiVer = num;
        this.templateIds = list;
    }
}
