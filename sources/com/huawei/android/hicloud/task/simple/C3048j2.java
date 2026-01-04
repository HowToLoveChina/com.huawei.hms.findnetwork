package com.huawei.android.hicloud.task.simple;

import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.util.Iterator;
import java.util.List;
import p581qk.AbstractC12368e;
import p684un.C13225d;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.task.simple.j2 */
/* loaded from: classes3.dex */
public class C3048j2 extends AbstractC12368e {

    /* renamed from: a */
    public String f13302a;

    /* renamed from: b */
    public boolean f13303b;

    /* renamed from: c */
    public int f13304c;

    /* renamed from: d */
    public boolean f13305d;

    /* renamed from: e */
    public long f13306e;

    /* renamed from: f */
    public List<BackupOptionItem> f13307f;

    /* renamed from: g */
    public boolean f13308g;

    public C3048j2(String str, boolean z10, int i10, boolean z11, long j10, boolean z12, List<BackupOptionItem> list) {
        this.f13302a = str;
        this.f13303b = z10;
        this.f13304c = i10;
        this.f13305d = z11;
        this.f13306e = j10;
        this.f13307f = list;
        this.f13308g = z12;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        int i10;
        List<BackupOptionItem> list;
        if (!C13452e.m80781L().m80887a1() || (list = this.f13307f) == null) {
            i10 = -1;
        } else {
            Iterator<BackupOptionItem> it = list.iterator();
            i10 = 0;
            while (it.hasNext()) {
                i10 += it.next().getBackupSwitch() ? 1 : 0;
            }
        }
        C13225d.m79490f1().m79554G0(this.f13302a, this.f13303b, this.f13304c, this.f13308g, this.f13305d, this.f13306e, i10);
    }
}
