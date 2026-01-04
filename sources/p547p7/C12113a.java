package p547p7;

import com.huawei.android.hicloud.drive.cloudphoto.model.Media;

/* renamed from: p7.a */
/* loaded from: classes2.dex */
public class C12113a {

    /* renamed from: a */
    public String f56175a;

    /* renamed from: b */
    public String f56176b;

    /* renamed from: c */
    public String f56177c;

    /* renamed from: d */
    public String f56178d;

    /* renamed from: e */
    public String f56179e;

    public C12113a() {
    }

    /* renamed from: a */
    public String m72548a() {
        return this.f56176b;
    }

    /* renamed from: b */
    public String m72549b() {
        return this.f56177c;
    }

    /* renamed from: c */
    public String m72550c() {
        return this.f56178d;
    }

    /* renamed from: d */
    public String m72551d() {
        return this.f56175a;
    }

    /* renamed from: e */
    public String m72552e() {
        return this.f56179e;
    }

    /* renamed from: f */
    public void m72553f(String str) {
        this.f56176b = str;
    }

    /* renamed from: g */
    public void m72554g(String str) {
        this.f56177c = str;
    }

    /* renamed from: h */
    public void m72555h(String str) {
        this.f56178d = str;
    }

    /* renamed from: i */
    public void m72556i(String str) {
        this.f56175a = str;
    }

    /* renamed from: j */
    public void m72557j(String str) {
        this.f56179e = str;
    }

    public C12113a(Media media) {
        if (media == null) {
            return;
        }
        this.f56175a = media.getId();
        this.f56176b = media.getAlbumId();
        this.f56177c = media.getFileName();
        this.f56178d = media.getHashId();
        this.f56179e = media.getSha256();
    }
}
