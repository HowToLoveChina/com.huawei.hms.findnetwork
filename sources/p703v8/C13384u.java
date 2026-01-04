package p703v8;

import com.huawei.android.hicloud.cloudspace.bean.TotalStorageInfo;
import com.huawei.hicloud.base.bean.CloudSpace;
import fk.C9721b;
import p052cb.C1414k;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import to.C13049a;

/* renamed from: v8.u */
/* loaded from: classes2.dex */
public class C13384u {

    /* renamed from: a */
    public long f60327a = -1;

    /* renamed from: a */
    public void m80363a() {
        this.f60327a = -1L;
    }

    /* renamed from: b */
    public TotalStorageInfo m80364b() throws C1414k {
        TotalStorageInfo totalStorageInfo = null;
        try {
            CloudSpace cloudSpaceM78743j = new C13049a(EnumC12999a.CLOUD_MORE, null).m78743j();
            if (cloudSpaceM78743j == null) {
                throw new C1414k("space null");
            }
            long total = cloudSpaceM78743j.getTotal();
            long used = cloudSpaceM78743j.getUsed();
            long j10 = total - used;
            if (j10 < 0) {
                j10 = 0;
            }
            C11839m.m70688i("UsedStorageRequestor", "total=" + total + ",used=" + used + ",available=" + j10);
            TotalStorageInfo totalStorageInfo2 = new TotalStorageInfo();
            try {
                totalStorageInfo2.setTotalSize(total);
                totalStorageInfo2.setUsedSize(used);
                totalStorageInfo2.setAvailableSize(j10);
                return totalStorageInfo2;
            } catch (Exception e10) {
                e = e10;
                totalStorageInfo = totalStorageInfo2;
                C11839m.m70687e("UsedStorageRequestor", "getTotal error:" + e.toString());
                return totalStorageInfo;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* renamed from: c */
    public long m80365c() throws NumberFormatException {
        m80363a();
        try {
            long j10 = Long.parseLong(new C13049a(EnumC12999a.CLOUD_MORE, null).m78707F());
            this.f60327a = j10;
            if (j10 < 0) {
                j10 = 0;
            }
            this.f60327a = j10;
            C11839m.m70688i("UsedStorageRequestor", "userUsedSize = " + this.f60327a);
        } catch (C9721b unused) {
            C11839m.m70689w("UsedStorageRequestor", "get user used space failed.");
            this.f60327a = -1L;
        } catch (NumberFormatException unused2) {
            C11839m.m70689w("UsedStorageRequestor", "checkUserSpace format error.");
            this.f60327a = -1L;
        }
        return this.f60327a;
    }
}
