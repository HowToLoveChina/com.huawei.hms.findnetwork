package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.C7821dn;
import java.io.Serializable;

@OuterVisible
/* loaded from: classes2.dex */
public class ImageInfo implements Serializable {

    /* renamed from: a */
    private String f33619a;

    /* renamed from: b */
    private String f33620b;

    /* renamed from: c */
    private int f33621c;

    /* renamed from: d */
    private int f33622d;

    /* renamed from: e */
    private int f33623e;

    /* renamed from: f */
    private String f33624f;

    /* renamed from: g */
    private boolean f33625g;

    /* renamed from: h */
    private String f33626h;

    @OuterVisible
    public ImageInfo() {
        this.f33621c = 0;
        this.f33622d = 0;
    }

    /* renamed from: a */
    public int m44470a() {
        return 52428800;
    }

    /* renamed from: b */
    public void m44475b(int i10) {
        this.f33621c = i10;
    }

    /* renamed from: c */
    public void m44478c(int i10) {
        this.f33623e = i10;
    }

    /* renamed from: d */
    public void m44480d(String str) {
        this.f33620b = str;
    }

    @OuterVisible
    public int getFileSize() {
        return this.f33623e;
    }

    @OuterVisible
    public int getHeight() {
        return this.f33622d;
    }

    @OuterVisible
    public String getImageType() {
        return this.f33626h;
    }

    @OuterVisible
    public String getOriginalUrl() {
        return this.f33620b;
    }

    @OuterVisible
    public String getSha256() {
        return this.f33624f;
    }

    @OuterVisible
    public String getUrl() {
        return this.f33619a;
    }

    @OuterVisible
    public int getWidth() {
        return this.f33621c;
    }

    @OuterVisible
    public boolean isCheckSha256() {
        return this.f33625g;
    }

    public ImageInfo(com.huawei.openalliance.p169ad.beans.metadata.ImageInfo imageInfo) {
        this.f33621c = 0;
        this.f33622d = 0;
        if (imageInfo != null) {
            this.f33619a = imageInfo.m40180c();
            this.f33620b = imageInfo.m40180c();
            this.f33621c = imageInfo.m40183d();
            this.f33622d = imageInfo.m40185e();
            this.f33624f = imageInfo.m40174a();
            this.f33626h = imageInfo.m40177b();
            this.f33623e = imageInfo.m40186f();
            this.f33625g = imageInfo.m40187g() == 0;
        }
    }

    /* renamed from: a */
    public void m44471a(int i10) {
        this.f33622d = i10;
    }

    /* renamed from: b */
    public void m44476b(String str) {
        this.f33624f = str;
    }

    /* renamed from: c */
    public void m44479c(String str) {
        this.f33619a = str;
    }

    /* renamed from: a */
    public void m44472a(String str) {
        this.f33626h = str;
    }

    /* renamed from: b */
    public boolean m44477b(Context context) {
        return C7821dn.m48377a(context, this.f33619a, (long) m44470a()) && (!this.f33625g || C7821dn.m48378a(context, this.f33619a, this.f33624f));
    }

    /* renamed from: a */
    public void m44473a(boolean z10) {
        this.f33625g = z10;
    }

    /* renamed from: a */
    public boolean m44474a(Context context) {
        return C7821dn.m48377a(context, this.f33619a, m44470a());
    }
}
