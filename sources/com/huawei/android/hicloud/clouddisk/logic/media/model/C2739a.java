package com.huawei.android.hicloud.clouddisk.logic.media.model;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.clouddisk.logic.media.model.RemoteFile;
import java.util.Collection;

/* renamed from: com.huawei.android.hicloud.clouddisk.logic.media.model.a */
/* loaded from: classes2.dex */
public class C2739a {

    /* renamed from: a */
    public RemoteFile f11822a;

    /* renamed from: b */
    public Collection<RemoteFile> f11823b;

    /* renamed from: c */
    public Handler.Callback f11824c;

    /* renamed from: d */
    public boolean f11825d;

    /* renamed from: e */
    public long f11826e;

    /* renamed from: f */
    public long f11827f;

    /* renamed from: g */
    public long f11828g;

    /* renamed from: com.huawei.android.hicloud.clouddisk.logic.media.model.a$a */
    public class a implements RemoteFile.OnProgressUpdateListener {
        public a() {
        }

        @Override // com.huawei.android.hicloud.clouddisk.logic.media.model.RemoteFile.OnProgressUpdateListener
        /* renamed from: a */
        public void mo15475a(RemoteFile remoteFile, long j10) {
            C2739a.this.m15482g(remoteFile, j10);
        }
    }

    public C2739a(Collection<RemoteFile> collection, boolean z10) {
        m15477b(collection, z10);
    }

    /* renamed from: a */
    public long m15476a() {
        return this.f11826e;
    }

    /* renamed from: b */
    public void m15477b(Collection<RemoteFile> collection, boolean z10) {
        this.f11826e = 0L;
        this.f11827f = 0L;
        this.f11828g = 0L;
        this.f11822a = null;
        this.f11823b = collection;
        this.f11825d = z10;
        if (collection != null) {
            for (RemoteFile remoteFile : collection) {
                this.f11826e += remoteFile.m15462g();
                remoteFile.m15465j(new a());
            }
        }
    }

    /* renamed from: c */
    public void m15478c() {
        m15477b(null, true);
        this.f11824c = null;
    }

    /* renamed from: d */
    public final void m15479d(RemoteFile remoteFile) {
        if (this.f11824c != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 99813;
            Bundle bundle = new Bundle();
            bundle.putLong("completedSize", this.f11827f);
            bundle.putLong("totalSize", this.f11826e);
            bundle.putBoolean("isBackupOpr", this.f11825d);
            bundle.putString("moduleName", remoteFile.m15463h());
            messageObtain.setData(bundle);
            this.f11824c.handleMessage(messageObtain);
        }
    }

    /* renamed from: e */
    public void m15480e(Handler.Callback callback) {
        this.f11824c = callback;
    }

    /* renamed from: f */
    public void m15481f(RemoteFile remoteFile) {
        if (this.f11822a == remoteFile) {
            return;
        }
        if (!this.f11823b.contains(remoteFile)) {
            throw new IllegalStateException("the file is not in the collecion");
        }
        this.f11822a = remoteFile;
        m15479d(remoteFile);
        this.f11828g = this.f11827f;
    }

    /* renamed from: g */
    public void m15482g(RemoteFile remoteFile, long j10) {
        if (remoteFile != this.f11822a) {
            throw new IllegalStateException("Try to update others than currentFile");
        }
        long j11 = this.f11827f + j10;
        this.f11827f = j11;
        if (j11 - this.f11828g > 102400) {
            m15479d(remoteFile);
            this.f11828g = this.f11827f;
        }
    }
}
