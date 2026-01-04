package com.huawei.android.hicloud.clouddisk.logic.media.model;

import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import hk.C10278a;
import java.io.File;

/* loaded from: classes2.dex */
public class RemoteFile {

    /* renamed from: a */
    public File f11810a;

    /* renamed from: b */
    public String f11811b;

    /* renamed from: c */
    public String f11812c;

    /* renamed from: d */
    public String f11813d;

    /* renamed from: e */
    public String f11814e;

    /* renamed from: f */
    public String f11815f;

    /* renamed from: g */
    public long f11816g;

    /* renamed from: h */
    public long f11817h;

    /* renamed from: i */
    public String f11818i;

    /* renamed from: j */
    public String f11819j;

    /* renamed from: k */
    public OnProgressUpdateListener f11820k;

    /* renamed from: l */
    public int f11821l = 0;

    public interface OnProgressUpdateListener {
        /* renamed from: a */
        void mo15475a(RemoteFile remoteFile, long j10);
    }

    /* renamed from: a */
    public void m15456a(long j10) {
        long j11 = this.f11817h;
        long j12 = j11 + j10;
        long j13 = this.f11816g;
        if (j12 > j13) {
            j10 = j13 - j11;
        }
        this.f11817h = j11 + j10;
        OnProgressUpdateListener onProgressUpdateListener = this.f11820k;
        if (onProgressUpdateListener != null) {
            onProgressUpdateListener.mo15475a(this, j10);
        }
    }

    /* renamed from: b */
    public UploadReq m15457b() {
        UploadReq uploadReq = new UploadReq();
        uploadReq.setFile(C10278a.m63442h(m15459d()));
        uploadReq.setServer(m15461f() + "/" + m15460e());
        return uploadReq;
    }

    /* renamed from: c */
    public File m15458c() {
        return this.f11810a;
    }

    /* renamed from: d */
    public String m15459d() {
        return this.f11815f;
    }

    /* renamed from: e */
    public String m15460e() {
        return this.f11813d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RemoteFile remoteFile = (RemoteFile) obj;
        String str = this.f11813d;
        if (str == null) {
            if (remoteFile.f11813d != null) {
                return false;
            }
        } else if (!str.equalsIgnoreCase(remoteFile.f11813d)) {
            return false;
        }
        return this.f11816g == remoteFile.f11816g;
    }

    /* renamed from: f */
    public String m15461f() {
        return this.f11812c;
    }

    /* renamed from: g */
    public long m15462g() {
        return this.f11816g;
    }

    /* renamed from: h */
    public String m15463h() {
        return this.f11811b;
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public void m15464i() {
        long j10 = this.f11817h;
        long j11 = this.f11816g;
        if (j10 > j11) {
            throw new IllegalStateException("completedSize bigger than the fileSize");
        }
        m15456a(j11 - j10);
    }

    /* renamed from: j */
    public void m15465j(OnProgressUpdateListener onProgressUpdateListener) {
        this.f11820k = onProgressUpdateListener;
    }

    /* renamed from: k */
    public void m15466k(File file) {
        this.f11810a = file;
    }

    /* renamed from: l */
    public void m15467l(File file, String str, String str2) {
        this.f11810a = file;
        this.f11813d = str;
        this.f11815f = str2;
    }

    /* renamed from: m */
    public void m15468m(String str) {
        this.f11815f = str;
    }

    /* renamed from: n */
    public void m15469n(String str) {
        this.f11813d = str;
    }

    /* renamed from: o */
    public void m15470o(String str) {
        this.f11818i = str;
    }

    /* renamed from: p */
    public void m15471p(String str) {
        this.f11812c = str;
    }

    /* renamed from: q */
    public void m15472q(long j10) {
        this.f11816g = j10;
    }

    /* renamed from: r */
    public void m15473r(String str) {
        this.f11811b = str;
    }

    /* renamed from: s */
    public void m15474s(String str) {
        this.f11814e = str;
    }

    public String toString() {
        return "MediaFile [file=" + this.f11810a + ", type=" + this.f11811b + ", serverAbPath=" + this.f11812c + ", name=" + this.f11813d + ", url=" + this.f11814e + ", localPath=" + this.f11815f + ", size=" + this.f11816g + ", md5=" + this.f11818i + ", createTime=" + this.f11819j + "]";
    }
}
