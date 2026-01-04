package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes2.dex */
public class ContentResource extends C7013a {
    public static final String CACHE_TYPE = "cacheType";
    public static final String CONTENT_ID = "contentId";
    public static final String FILE_NAME = "fileName";
    public static final String PRIORITY = "priority";
    public static final String SLOT_ID = "slotId";
    public static final String UPDATE_TIME = "updateTime";
    private int adType;
    private String cacheType;
    private String contentId;
    private int downloadSource;
    private String fileName;
    private int isPreload;
    private int priority;
    private String resType;
    private String slotId;
    private int unzipStatus;
    private long updateTime;
    private int useCount;

    public ContentResource() {
        this.adType = -1;
        this.downloadSource = 2;
    }

    /* renamed from: a */
    public String m41621a() {
        return this.fileName;
    }

    /* renamed from: b */
    public String m41625b() {
        return this.slotId;
    }

    /* renamed from: c */
    public String m41628c() {
        return this.contentId;
    }

    /* renamed from: d */
    public int m41631d() {
        return this.adType;
    }

    /* renamed from: e */
    public int m41634e() {
        return this.priority;
    }

    /* renamed from: f */
    public int m41637f() {
        return this.isPreload;
    }

    /* renamed from: g */
    public int m41639g() {
        return this.downloadSource;
    }

    /* renamed from: h */
    public int m41640h() {
        return this.useCount;
    }

    /* renamed from: i */
    public String m41641i() {
        return this.resType;
    }

    /* renamed from: j */
    public String m41642j() {
        return this.cacheType;
    }

    public ContentResource(ContentRecord contentRecord) {
        this.adType = -1;
        this.downloadSource = 2;
        this.contentId = contentRecord.m41588n();
        this.slotId = contentRecord.m41585m();
        this.adType = contentRecord.m41552f();
    }

    /* renamed from: a */
    public void m41622a(int i10) {
        this.adType = i10;
    }

    /* renamed from: b */
    public void m41626b(int i10) {
        this.priority = i10;
    }

    /* renamed from: c */
    public void m41629c(int i10) {
        this.isPreload = i10;
    }

    /* renamed from: d */
    public void m41632d(int i10) {
        this.downloadSource = i10;
    }

    /* renamed from: e */
    public void m41635e(int i10) {
        this.useCount = i10;
    }

    /* renamed from: f */
    public void m41638f(int i10) {
        this.unzipStatus = i10;
    }

    /* renamed from: a */
    public void m41623a(long j10) {
        this.updateTime = j10;
    }

    /* renamed from: b */
    public void m41627b(String str) {
        this.slotId = str;
    }

    /* renamed from: c */
    public void m41630c(String str) {
        this.contentId = str;
    }

    /* renamed from: d */
    public void m41633d(String str) {
        this.resType = str;
    }

    /* renamed from: e */
    public void m41636e(String str) {
        this.cacheType = str;
    }

    /* renamed from: a */
    public void m41624a(String str) {
        this.fileName = str;
    }
}
