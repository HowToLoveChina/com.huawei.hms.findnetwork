package com.huawei.openalliance.p169ad.beans.vast;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class VastContent {
    private String adSystem;
    private String adSystemVersion;
    private String adTile;
    private String advertiser;
    private String description;

    /* renamed from: id */
    private String f32020id;
    private String version;
    private List<Impression> impressions = new ArrayList();
    private List<Creative> creatives = new ArrayList();
    private Boolean isWrapper = Boolean.FALSE;

    /* renamed from: a */
    public String m41008a() {
        return this.f32020id;
    }

    /* renamed from: b */
    public String m41012b() {
        return this.adTile;
    }

    /* renamed from: c */
    public String m41014c() {
        return this.description;
    }

    /* renamed from: d */
    public List<Impression> m41016d() {
        return this.impressions;
    }

    /* renamed from: e */
    public List<Creative> m41018e() {
        return this.creatives;
    }

    /* renamed from: f */
    public String m41020f() {
        return this.advertiser;
    }

    /* renamed from: g */
    public Boolean m41022g() {
        return this.isWrapper;
    }

    /* renamed from: a */
    public void m41009a(Impression impression) {
        if (this.impressions.contains(impression)) {
            return;
        }
        this.impressions.add(impression);
    }

    /* renamed from: b */
    public void m41013b(String str) {
        this.adSystem = str;
    }

    /* renamed from: c */
    public void m41015c(String str) {
        this.adSystemVersion = str;
    }

    /* renamed from: d */
    public void m41017d(String str) {
        this.adTile = str;
    }

    /* renamed from: e */
    public void m41019e(String str) {
        this.description = str;
    }

    /* renamed from: f */
    public void m41021f(String str) {
        this.advertiser = str;
    }

    /* renamed from: a */
    public void m41010a(String str) {
        this.f32020id = str;
    }

    /* renamed from: a */
    public void m41011a(List<Creative> list) {
        this.creatives = list;
    }
}
