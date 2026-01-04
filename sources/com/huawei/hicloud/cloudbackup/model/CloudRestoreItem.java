package com.huawei.hicloud.cloudbackup.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.cloudbackup.progress.C2660a;
import com.huawei.android.hicloud.cloudbackup.progress.C2661b;
import com.huawei.fastengine.fastview.NavigationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p848zl.C14333b;

/* loaded from: classes6.dex */
public class CloudRestoreItem extends RestoreStatus implements Cloneable {
    public static final Parcelable.Creator<CloudRestoreItem> CREATOR = new C4864a();

    /* renamed from: a */
    public List<CloudRestoreItem> f22243a;

    /* renamed from: b */
    public String f22244b;

    /* renamed from: c */
    public boolean f22245c = false;

    /* renamed from: d */
    public List<CloudRestoreItem> f22246d = new ArrayList();

    /* renamed from: com.huawei.hicloud.cloudbackup.model.CloudRestoreItem$a */
    public class C4864a implements Parcelable.Creator<CloudRestoreItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CloudRestoreItem createFromParcel(Parcel parcel) {
            CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
            cloudRestoreItem.setAppId(parcel.readString());
            cloudRestoreItem.setAppName(parcel.readString());
            cloudRestoreItem.setAppType(parcel.readInt());
            cloudRestoreItem.setAction(parcel.readInt());
            cloudRestoreItem.setStatus(parcel.readInt());
            cloudRestoreItem.setType(parcel.readInt());
            cloudRestoreItem.setCurrent(parcel.readInt());
            cloudRestoreItem.setCount(parcel.readInt());
            cloudRestoreItem.setSize(parcel.readLong());
            cloudRestoreItem.setAsize(parcel.readLong());
            cloudRestoreItem.setUid(parcel.readInt());
            cloudRestoreItem.setCombineUid(parcel.readString());
            cloudRestoreItem.setSubStatus(parcel.readString());
            cloudRestoreItem.setBytesDownloadedFiles(parcel.readLong());
            cloudRestoreItem.setBytesDownloadedApp(parcel.readLong());
            cloudRestoreItem.setPmsAlreadyBytes(parcel.readLong());
            cloudRestoreItem.setBmAppDataType(parcel.readInt());
            cloudRestoreItem.setSplitApkType(parcel.readString());
            cloudRestoreItem.setOriBackupAppName(parcel.readString());
            cloudRestoreItem.m29213z0(parcel.readString());
            cloudRestoreItem.f22243a = new ArrayList();
            parcel.readList(cloudRestoreItem.f22243a, getClass().getClassLoader());
            cloudRestoreItem.f22246d = new ArrayList();
            parcel.readList(cloudRestoreItem.f22246d, getClass().getClassLoader());
            return cloudRestoreItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CloudRestoreItem[] newArray(int i10) {
            return new CloudRestoreItem[i10];
        }
    }

    /* renamed from: A */
    public List<CloudRestoreItem> m29172A() {
        return this.f22246d;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: A0 */
    public CloudRestoreItem setHarmonyNext(boolean z10) {
        return (CloudRestoreItem) super.setHarmonyNext(z10);
    }

    /* renamed from: B0 */
    public void m29174B0(boolean z10) {
        this.f22245c = z10;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: C0 */
    public CloudRestoreItem setSize(long j10) {
        return (CloudRestoreItem) super.setSize(j10);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: D0 */
    public CloudRestoreItem setStatus(int i10) {
        return (CloudRestoreItem) super.setStatus(i10);
    }

    /* renamed from: E0 */
    public void m29177E0(List<CloudRestoreItem> list) {
        this.f22246d.clear();
        this.f22246d.addAll(list);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: F0 */
    public CloudRestoreItem setType(int i10) {
        return (CloudRestoreItem) super.setType(i10);
    }

    /* renamed from: G0 */
    public void m29179G0() {
        if (!isCompatible()) {
            super.setAction(2);
        }
        List<CloudRestoreItem> list = this.f22243a;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<CloudRestoreItem> it = this.f22243a.iterator();
        while (it.hasNext()) {
            it.next().m29179G0();
        }
        this.f22243a.forEach(new C2660a());
    }

    /* renamed from: H0 */
    public void m29180H0() {
        List<CloudRestoreItem> list = this.f22243a;
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            setCompatible(false);
            return;
        }
        if (getAppId().equals("com.huawei.hmos.photos")) {
            Iterator<CloudRestoreItem> it = this.f22243a.iterator();
            while (it.hasNext()) {
                if (it.next().isCompatible()) {
                    setCompatible(true);
                    m29174B0(false);
                    return;
                }
            }
            return;
        }
        Iterator<CloudRestoreItem> it2 = this.f22243a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (!it2.next().isCompatible()) {
                setCompatible(false);
                m29174B0(true);
                break;
            }
        }
        if (isCompatible()) {
            return;
        }
        Iterator<CloudRestoreItem> it3 = this.f22243a.iterator();
        while (it3.hasNext()) {
            it3.next().setCompatible(false);
        }
    }

    /* renamed from: I0 */
    public void m29181I0() {
        List<CloudRestoreItem> list;
        if (("thirdApp".equals(getAppId()) || "sysdata".equals(getAppId()) || "thirdAppData".equals(getAppId()) || "bmBaseData".equals(getAppId())) && (list = this.f22243a) != null) {
            if (list.isEmpty()) {
                setCompatible(false);
                return;
            }
            int i10 = 0;
            for (CloudRestoreItem cloudRestoreItem : this.f22243a) {
                if (cloudRestoreItem.f22243a != null && !this.f22243a.isEmpty()) {
                    cloudRestoreItem.m29181I0();
                }
                if (!cloudRestoreItem.isCompatible()) {
                    i10++;
                    m29174B0(true);
                }
            }
            if (i10 == this.f22243a.size()) {
                setCompatible(false);
            }
        }
    }

    /* renamed from: J0 */
    public void m29182J0() {
        m29184K0(this);
    }

    /* renamed from: K */
    public boolean m29183K() {
        return this.f22245c;
    }

    /* renamed from: K0 */
    public final void m29184K0(CloudRestoreItem cloudRestoreItem) {
        long asize;
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r == null || listM29202r.isEmpty()) {
            return;
        }
        int iM29208v = 0;
        long j10 = 0;
        long size = 0;
        for (CloudRestoreItem cloudRestoreItem2 : listM29202r) {
            m29184K0(cloudRestoreItem2);
            int action = cloudRestoreItem2.getAction();
            if (action == 0) {
                if (cloudRestoreItem2.isCompatible()) {
                    iM29208v = cloudRestoreItem2.isSystemShowModule() ? iM29208v + m29208v(cloudRestoreItem2) : iM29208v + 1;
                }
                size += cloudRestoreItem2.getSize();
                asize = cloudRestoreItem2.getAsize();
            } else if (action == 1) {
                iM29208v = cloudRestoreItem2.isSystemShowModule() ? iM29208v + m29208v(cloudRestoreItem2) : iM29208v + 1;
                size += cloudRestoreItem2.is3rdAppType() ? 0L : cloudRestoreItem2.getSize();
                asize = cloudRestoreItem2.getAsize();
            } else if (cloudRestoreItem2.isSystemShowModule() || cloudRestoreItem2.m29190O()) {
                iM29208v += m29208v(cloudRestoreItem2);
                size += cloudRestoreItem2.getSize();
                asize = cloudRestoreItem2.getAsize();
            }
            j10 += asize;
        }
        cloudRestoreItem.setCount(iM29208v);
        if (!"thirdAppData".equals(cloudRestoreItem.getAppId())) {
            cloudRestoreItem.setAsize(j10);
        }
        if ("thirdApp".equals(cloudRestoreItem.getAppId())) {
            return;
        }
        cloudRestoreItem.setSize(size);
    }

    /* renamed from: L */
    public final boolean m29185L(CloudRestoreItem cloudRestoreItem) {
        return "thirdApp".equals(cloudRestoreItem.getAppId());
    }

    /* renamed from: L0 */
    public void m29186L0() {
        m29188M0(this);
    }

    /* renamed from: M */
    public boolean m29187M() {
        return getSize() > 0 && getAsize() > 0 && !"sysdata".equals(getAppId());
    }

    /* renamed from: M0 */
    public final void m29188M0(CloudRestoreItem cloudRestoreItem) {
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r == null || listM29202r.isEmpty()) {
            return;
        }
        C4865b c4865b = new C4865b(null);
        for (CloudRestoreItem cloudRestoreItem2 : listM29202r) {
            if (cloudRestoreItem2 != null) {
                m29188M0(cloudRestoreItem2);
                m29194S(cloudRestoreItem, cloudRestoreItem2, c4865b);
            }
        }
        m29195T(cloudRestoreItem, c4865b, listM29202r.size());
        if (cloudRestoreItem.isShowChildList()) {
            cloudRestoreItem.setCurrent(c4865b.f22252f);
            return;
        }
        int count = 0;
        int count2 = 0;
        for (CloudRestoreItem cloudRestoreItem3 : listM29202r) {
            if (cloudRestoreItem3 != null) {
                count += (cloudRestoreItem3.getType() == 1 && cloudRestoreItem3.getStatus() == 8) ? cloudRestoreItem3.getCount() : cloudRestoreItem3.getCurrent();
                count2 += cloudRestoreItem3.getCount();
            }
        }
        if (count > cloudRestoreItem.getCurrent()) {
            if (count >= count2) {
                count = count2;
            }
            cloudRestoreItem.setCurrent(count);
        }
        cloudRestoreItem.setCount(count2);
    }

    /* renamed from: N */
    public boolean m29189N() {
        return "bmBaseData".equals(getAppId());
    }

    /* renamed from: O */
    public boolean m29190O() {
        return isHarmonyNext() && getAppShowType() >= 4 && !"com.huawei.hmos.filemanager".equals(getAppId());
    }

    /* renamed from: P */
    public final boolean m29191P(String str) {
        return NavigationUtils.SMS_SCHEMA_PREF.equals(str) || "chatSms".equals(str);
    }

    /* renamed from: Q */
    public final boolean m29192Q(CloudRestoreItem cloudRestoreItem) {
        String appId = cloudRestoreItem.getAppId();
        return NavigationUtils.SMS_SCHEMA_PREF.equals(appId) || "soundrecorder".equals(appId);
    }

    /* renamed from: R */
    public final boolean m29193R(CloudRestoreItem cloudRestoreItem) {
        String appId = cloudRestoreItem.getAppId();
        return "soundrecorder".equals(appId) || "callRecorder".equals(appId);
    }

    /* renamed from: S */
    public final void m29194S(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2, C4865b c4865b) {
        int status = cloudRestoreItem2.getStatus();
        int type = cloudRestoreItem2.getType();
        if (status != -8) {
            if (status != -6) {
                switch (status) {
                    case -2:
                        c4865b.f22255i++;
                        break;
                    case 0:
                    case 3:
                        c4865b.f22248b++;
                        break;
                    case 1:
                        c4865b.f22250d++;
                        break;
                    case 2:
                        c4865b.f22249c++;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        if (!m29193R(cloudRestoreItem2) && !m29191P(cloudRestoreItem2.getAppId()) && !m29190O()) {
                            c4865b.f22251e++;
                            break;
                        } else {
                            c4865b.f22254h++;
                            break;
                        }
                        break;
                    case 7:
                        if (!m29185L(cloudRestoreItem)) {
                            c4865b.f22251e++;
                            break;
                        } else {
                            c4865b.f22252f++;
                            break;
                        }
                }
            }
            c4865b.f22247a++;
            return;
        }
        if (type == 1) {
            c4865b.f22252f++;
        } else {
            c4865b.f22253g++;
        }
    }

    /* renamed from: T */
    public final void m29195T(CloudRestoreItem cloudRestoreItem, C4865b c4865b, int i10) {
        int i11 = c4865b.f22247a;
        if (i11 == i10) {
            cloudRestoreItem.setStatus(-1);
            return;
        }
        int i12 = i10 - i11;
        if (c4865b.f22248b == i12) {
            cloudRestoreItem.setStatus(0);
            return;
        }
        if (c4865b.f22249c == i12) {
            cloudRestoreItem.setStatus(2);
            return;
        }
        if (c4865b.f22250d > 0) {
            cloudRestoreItem.setStatus(1);
            return;
        }
        if (c4865b.f22254h > 0) {
            cloudRestoreItem.setStatus(4);
        } else if (c4865b.f22251e > 0) {
            cloudRestoreItem.setStatus(7);
        } else {
            m29196U(cloudRestoreItem, c4865b, i10);
        }
    }

    /* renamed from: U */
    public final void m29196U(CloudRestoreItem cloudRestoreItem, C4865b c4865b, int i10) {
        int i11;
        int i12;
        if (c4865b.f22248b > 0) {
            cloudRestoreItem.setStatus(0);
            return;
        }
        if (c4865b.f22249c > 0) {
            cloudRestoreItem.setStatus(2);
            return;
        }
        cloudRestoreItem.setStatus(8);
        if (cloudRestoreItem.isShowChildList()) {
            i11 = c4865b.f22253g + c4865b.f22250d + c4865b.f22247a;
            i12 = c4865b.f22255i;
        } else {
            i11 = c4865b.f22253g;
            i12 = c4865b.f22250d;
        }
        cloudRestoreItem.setType(i11 + i12 > 0 ? 2 : 1);
        if ((m29192Q(cloudRestoreItem) || cloudRestoreItem.m29190O()) && c4865b.f22247a > 0 && i10 > 1) {
            cloudRestoreItem.setStatus(8);
            cloudRestoreItem.setType(2);
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: V */
    public CloudRestoreItem setAction(int i10) {
        return !isCompatible() ? this : (CloudRestoreItem) super.setAction(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: W */
    public CloudRestoreItem setAggVirtualAppId(String str) {
        return (CloudRestoreItem) super.setAggVirtualAppId(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: Y */
    public CloudRestoreItem setAppId(String str) {
        return (CloudRestoreItem) super.setAppId(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public boolean isSystemShowModule() {
        return C14333b.m85476k().contains(getAppId()) && !C14333b.m85482q().contains(getAppId());
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: p0 */
    public CloudRestoreItem setAppName(String str) {
        return (CloudRestoreItem) super.setAppName(str);
    }

    /* renamed from: q */
    public CloudRestoreItem clone() {
        try {
            return (CloudRestoreItem) super.clone();
        } catch (CloneNotSupportedException unused) {
            return new CloudRestoreItem();
        }
    }

    /* renamed from: r */
    public List<CloudRestoreItem> m29202r() {
        return this.f22243a;
    }

    /* renamed from: s */
    public String m29203s() {
        return this.f22244b;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: s0 */
    public CloudRestoreItem setAppShowType(int i10) {
        return (CloudRestoreItem) super.setAppShowType(i10);
    }

    /* renamed from: t */
    public int m29205t() {
        List<CloudRestoreItem> list = this.f22243a;
        if (list == null) {
            return 0;
        }
        return list.size() - ((int) this.f22243a.stream().filter(new C2661b()).count());
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: t0 */
    public CloudRestoreItem setAppType(int i10) {
        return (CloudRestoreItem) super.setAppType(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: u0 */
    public CloudRestoreItem setAsize(long j10) {
        return (CloudRestoreItem) super.setAsize(j10);
    }

    /* renamed from: v */
    public final int m29208v(CloudRestoreItem cloudRestoreItem) {
        if (cloudRestoreItem == null) {
            return 0;
        }
        if (isSystemShowModule() && cloudRestoreItem.isUnSupport()) {
            return 0;
        }
        return cloudRestoreItem.getCount();
    }

    /* renamed from: v0 */
    public CloudRestoreItem m29209v0(List<CloudRestoreItem> list) {
        this.f22243a = list;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: w0 */
    public CloudRestoreItem setCompatible(boolean z10) {
        return (CloudRestoreItem) super.setCompatible(z10);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f22244b);
        parcel.writeList(this.f22243a);
        parcel.writeList(this.f22246d);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: x0 */
    public CloudRestoreItem setCount(int i10) {
        return (CloudRestoreItem) super.setCount(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: y0 */
    public CloudRestoreItem setCurrent(int i10) {
        return (CloudRestoreItem) super.setCurrent(i10);
    }

    /* renamed from: z0 */
    public void m29213z0(String str) {
        this.f22244b = str;
    }

    /* renamed from: com.huawei.hicloud.cloudbackup.model.CloudRestoreItem$b */
    public static class C4865b {

        /* renamed from: a */
        public int f22247a;

        /* renamed from: b */
        public int f22248b;

        /* renamed from: c */
        public int f22249c;

        /* renamed from: d */
        public int f22250d;

        /* renamed from: e */
        public int f22251e;

        /* renamed from: f */
        public int f22252f;

        /* renamed from: g */
        public int f22253g;

        /* renamed from: h */
        public int f22254h;

        /* renamed from: i */
        public int f22255i;

        public C4865b() {
            this.f22247a = 0;
            this.f22248b = 0;
            this.f22249c = 0;
            this.f22250d = 0;
            this.f22251e = 0;
            this.f22252f = 0;
            this.f22253g = 0;
            this.f22254h = 0;
            this.f22255i = 0;
        }

        public /* synthetic */ C4865b(C4864a c4864a) {
            this();
        }
    }
}
