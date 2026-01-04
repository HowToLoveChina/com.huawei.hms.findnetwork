package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.constant.MimeType;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class MediaFile implements Serializable {
    private static final long serialVersionUID = 30422300;
    private long fileSize;
    private int height;
    private String sha256;

    @InterfaceC6929a
    private String url;
    private int width;
    private String mime = MimeType.MP4;
    private int checkSha256Flag = 0;
    private int downloadNetwork = 0;
    private int playMode = 1;

    /* renamed from: a */
    public String m40243a() {
        return this.mime;
    }

    /* renamed from: b */
    public int m40247b() {
        return this.width;
    }

    /* renamed from: c */
    public int m40250c() {
        return this.height;
    }

    /* renamed from: d */
    public long m40253d() {
        return this.fileSize;
    }

    /* renamed from: e */
    public String m40255e() {
        return this.url;
    }

    /* renamed from: f */
    public String m40257f() {
        return this.sha256;
    }

    /* renamed from: g */
    public int m40258g() {
        return this.checkSha256Flag;
    }

    /* renamed from: h */
    public int m40259h() {
        return this.downloadNetwork;
    }

    /* renamed from: i */
    public int m40260i() {
        return this.playMode;
    }

    /* renamed from: j */
    public boolean m40261j() {
        if (TextUtils.isEmpty(this.mime)) {
            return false;
        }
        return MimeType.JPEG.equals(this.mime) || MimeType.JPG.equals(this.mime) || MimeType.PNG.equals(this.mime) || MimeType.GIF.equals(this.mime);
    }

    /* renamed from: k */
    public boolean m40262k() {
        if (TextUtils.isEmpty(this.mime)) {
            return false;
        }
        return MimeType.MP4.equals(this.mime);
    }

    /* renamed from: l */
    public int m40263l() {
        if (MimeType.JPEG.equals(this.mime) || MimeType.JPG.equals(this.mime) || MimeType.PNG.equals(this.mime)) {
            return 2;
        }
        return MimeType.GIF.equals(this.mime) ? 4 : 100;
    }

    /* renamed from: a */
    public void m40244a(int i10) {
        this.width = i10;
    }

    /* renamed from: b */
    public void m40248b(int i10) {
        this.height = i10;
    }

    /* renamed from: c */
    public void m40251c(int i10) {
        this.checkSha256Flag = i10;
    }

    /* renamed from: d */
    public void m40254d(int i10) {
        this.downloadNetwork = i10;
    }

    /* renamed from: e */
    public void m40256e(int i10) {
        this.playMode = i10;
    }

    /* renamed from: a */
    public void m40245a(long j10) {
        this.fileSize = j10;
    }

    /* renamed from: b */
    public void m40249b(String str) {
        this.url = str;
    }

    /* renamed from: c */
    public void m40252c(String str) {
        this.sha256 = str;
    }

    /* renamed from: a */
    public void m40246a(String str) {
        this.mime = str;
    }
}
