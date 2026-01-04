package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.MediaFile;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.utils.C7821dn;
import java.io.Serializable;

@OuterVisible
/* loaded from: classes2.dex */
public class PlacementMediaFile implements Serializable {

    /* renamed from: a */
    private String f33651a;

    /* renamed from: b */
    private String f33652b;

    /* renamed from: c */
    private long f33653c;

    /* renamed from: d */
    private int f33654d;

    /* renamed from: e */
    private int f33655e;

    /* renamed from: f */
    private String f33656f;

    /* renamed from: g */
    private String f33657g;

    /* renamed from: h */
    private int f33658h;

    /* renamed from: i */
    private int f33659i;

    /* renamed from: j */
    private int f33660j;

    /* renamed from: k */
    private long f33661k;

    /* renamed from: l */
    private String f33662l;

    /* renamed from: m */
    private int f33663m;

    @OuterVisible
    public PlacementMediaFile() {
        this.f33654d = 0;
        this.f33655e = 0;
        this.f33657g = "y";
        this.f33659i = 0;
        this.f33663m = 0;
    }

    /* renamed from: a */
    public int m44545a() {
        return Constants.VIDEO_SIZE_UPPER_LIMIT;
    }

    /* renamed from: b */
    public String m44549b() {
        return this.f33662l;
    }

    /* renamed from: c */
    public int m44551c() {
        return this.f33663m;
    }

    /* renamed from: d */
    public Float m44552d() {
        int i10;
        int i11 = this.f33654d;
        if (i11 <= 0 || (i10 = this.f33655e) <= 0) {
            return null;
        }
        return Float.valueOf(i11 / i10);
    }

    @OuterVisible
    public int getCheckSha256() {
        return this.f33658h;
    }

    @OuterVisible
    public int getDownloadNetwork() {
        return this.f33659i;
    }

    @OuterVisible
    public long getDuration() {
        return this.f33661k;
    }

    @OuterVisible
    public long getFileSize() {
        return this.f33653c;
    }

    @OuterVisible
    public int getHeight() {
        return this.f33655e;
    }

    @OuterVisible
    public String getMime() {
        return this.f33651a;
    }

    @OuterVisible
    public int getPlayMode() {
        return this.f33660j;
    }

    @OuterVisible
    public String getSha256() {
        return this.f33656f;
    }

    @OuterVisible
    public String getSoundSwitch() {
        return this.f33657g;
    }

    @OuterVisible
    public String getUrl() {
        return this.f33652b;
    }

    @OuterVisible
    public int getWidth() {
        return this.f33654d;
    }

    @OuterVisible
    public boolean isValid(Context context) {
        return C7821dn.m48377a(context, this.f33652b, (long) m44545a());
    }

    @OuterVisible
    public boolean isVideo() {
        return MimeType.MP4.equals(this.f33651a);
    }

    public PlacementMediaFile(MediaFile mediaFile, long j10) {
        this.f33654d = 0;
        this.f33655e = 0;
        this.f33657g = "y";
        this.f33659i = 0;
        this.f33663m = 0;
        this.f33651a = mediaFile.m40243a();
        this.f33652b = mediaFile.m40255e();
        this.f33653c = mediaFile.m40253d();
        this.f33658h = mediaFile.m40258g();
        this.f33659i = mediaFile.m40259h();
        this.f33654d = mediaFile.m40247b();
        this.f33655e = mediaFile.m40250c();
        this.f33656f = mediaFile.m40257f();
        this.f33660j = mediaFile.m40260i();
        this.f33661k = j10;
    }

    /* renamed from: a */
    public void m44546a(int i10) {
        this.f33663m = i10;
    }

    /* renamed from: b */
    public void m44550b(String str) {
        this.f33662l = str;
    }

    /* renamed from: a */
    public void m44547a(String str) {
        this.f33657g = str;
    }

    /* renamed from: a */
    public boolean m44548a(Context context) {
        if (C7821dn.m48377a(context, this.f33662l, m44545a())) {
            return 1 == this.f33658h || C7821dn.m48378a(context, this.f33662l, this.f33656f);
        }
        return false;
    }
}
