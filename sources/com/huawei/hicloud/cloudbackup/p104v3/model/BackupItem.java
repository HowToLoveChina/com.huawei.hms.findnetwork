package com.huawei.hicloud.cloudbackup.p104v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class BackupItem extends BackupStatus {
    public static final Parcelable.Creator<BackupItem> CREATOR = new C4884a();

    /* renamed from: B */
    public boolean f22550B;

    /* renamed from: E */
    public float f22553E;

    /* renamed from: F */
    public int f22554F;

    /* renamed from: z */
    public volatile List<BackupItem> f22555z;

    /* renamed from: A */
    public int f22549A = 1;

    /* renamed from: C */
    public boolean f22551C = true;

    /* renamed from: D */
    public String f22552D = "";

    /* renamed from: com.huawei.hicloud.cloudbackup.v3.model.BackupItem$a */
    public class C4884a implements Parcelable.Creator<BackupItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackupItem createFromParcel(Parcel parcel) {
            BackupItem backupItem = new BackupItem();
            backupItem.mo29313Y(parcel.readString());
            backupItem.mo29316a0(parcel.readString());
            backupItem.mo29318b0(parcel.readInt());
            backupItem.mo29338z0(parcel.readInt());
            backupItem.mo29289A0(parcel.readInt());
            backupItem.mo29310W(parcel.readInt());
            backupItem.mo29325f0(parcel.readInt());
            backupItem.mo29327g0(parcel.readInt());
            backupItem.mo29308V(parcel.readLong());
            backupItem.mo29395c0(parcel.readLong());
            backupItem.mo29323e0(parcel.readLong());
            backupItem.mo29321d0(parcel.readLong());
            backupItem.m29847f1(parcel.readInt());
            backupItem.f22555z = new ArrayList();
            parcel.readList(backupItem.f22555z, getClass().getClassLoader());
            return backupItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackupItem[] newArray(int i10) {
            return new BackupItem[i10];
        }
    }

    /* renamed from: G0 */
    public void m29822G0(BackupItem backupItem) {
        mo29338z0(backupItem.m29859L());
        mo29310W(backupItem.m29869c());
        mo29289A0(backupItem.m29860M());
        mo29327g0(backupItem.m29877l());
        mo29308V(backupItem.m29868a());
        m29838W0(backupItem.m29824I0());
        mo29395c0(backupItem.m29873g());
        mo29323e0(backupItem.m29875i());
        mo29321d0(backupItem.m29874h());
        mo29325f0(backupItem.m29876j());
        mo29413k0(backupItem.mo29421n());
        mo29452y0(backupItem.mo29357K());
        if (backupItem.m29827L0() == -1.0f) {
            m29846e1(0.0f);
            backupItem.m29846e1(0.0f);
        }
        if (m29860M() == 0) {
            C11839m.m70686d("BackupItem", "updateItem appId = " + m29870d() + " uid = " + m29861N());
            m29846e1(0.0f);
        }
    }

    /* renamed from: H0 */
    public final void m29823H0(BackupItem backupItem, BackupItem backupItem2) {
        switch (backupItem2.m29860M()) {
            case 0:
            case 1:
            case 2:
            case 3:
                mo29289A0(4).mo29310W(backupItem.m29877l()).mo29308V(backupItem.m29875i()).mo29323e0(backupItem.m29875i() + backupItem2.m29875i()).mo29325f0(backupItem.m29877l() + backupItem2.m29877l()).mo29327g0(backupItem.m29877l() + backupItem2.m29877l());
                break;
            case 4:
                mo29289A0(4).mo29310W(backupItem.m29877l() + backupItem2.m29869c()).mo29308V(backupItem.m29875i() + backupItem2.m29868a()).mo29323e0(backupItem.m29875i() + backupItem2.m29875i()).mo29325f0(backupItem.m29877l() + backupItem2.m29877l()).mo29327g0(backupItem.m29877l() + backupItem2.m29877l());
                break;
            case 5:
                mo29289A0(5).mo29310W(backupItem2.m29869c()).mo29325f0(backupItem2.m29876j()).mo29308V(backupItem2.m29868a() + backupItem.m29875i()).mo29395c0(backupItem2.m29873g()).mo29327g0(backupItem.m29877l() + backupItem2.m29877l()).mo29323e0(backupItem.m29875i() + backupItem2.m29875i());
                break;
            case 6:
                mo29289A0(6).mo29327g0(backupItem.m29877l() + backupItem2.m29877l()).mo29323e0(backupItem.m29875i() + backupItem2.m29875i());
                break;
            case 7:
                mo29289A0(7).mo29327g0(backupItem.m29877l() + backupItem2.m29877l()).mo29323e0(backupItem.m29875i() + backupItem2.m29875i());
                break;
        }
    }

    /* renamed from: I0 */
    public List<BackupItem> m29824I0() {
        return this.f22555z;
    }

    /* renamed from: J0 */
    public int m29825J0() {
        return this.f22549A;
    }

    /* renamed from: K0 */
    public String m29826K0() {
        return this.f22552D;
    }

    /* renamed from: L0 */
    public float m29827L0() {
        return this.f22553E;
    }

    /* renamed from: M0 */
    public int m29828M0() {
        return this.f22554F;
    }

    /* renamed from: N0 */
    public boolean m29829N0() {
        return this.f22550B;
    }

    /* renamed from: O0 */
    public boolean m29830O0() {
        return "music".equals(m29870d()) || HNConstants.DataType.MEDIA.equals(m29870d());
    }

    /* renamed from: P0 */
    public final /* synthetic */ void m29831P0(BackupItem backupItem) {
        mo29338z0(backupItem.m29859L()).mo29289A0(backupItem.m29860M()).mo29310W(backupItem.m29869c()).mo29325f0(backupItem.m29876j()).mo29327g0(backupItem.m29877l()).mo29308V(backupItem.m29868a()).mo29395c0(backupItem.m29873g()).mo29323e0(backupItem.m29875i()).mo29321d0(backupItem.m29874h());
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29308V(long j10) {
        return (BackupItem) super.mo29308V(j10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29310W(int i10) {
        return (BackupItem) super.mo29310W(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29313Y(String str) {
        return (BackupItem) super.mo29313Y(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29316a0(String str) {
        return (BackupItem) super.mo29316a0(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29318b0(int i10) {
        return (BackupItem) super.mo29318b0(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29395c0(long j10) {
        return (BackupItem) super.mo29395c0(j10);
    }

    /* renamed from: W0 */
    public BackupItem m29838W0(List<BackupItem> list) {
        this.f22555z = list;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29321d0(long j10) {
        return (BackupItem) super.mo29321d0(j10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29323e0(long j10) {
        return (BackupItem) super.mo29323e0(j10);
    }

    /* renamed from: Z0 */
    public void m29841Z0(boolean z10) {
        this.f22550B = z10;
    }

    /* renamed from: a1 */
    public void m29842a1(int i10) {
        this.f22549A = i10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29325f0(int i10) {
        return (BackupItem) super.mo29325f0(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29327g0(int i10) {
        return (BackupItem) super.mo29327g0(i10);
    }

    /* renamed from: d1 */
    public void m29845d1(String str) {
        this.f22552D = str;
    }

    /* renamed from: e1 */
    public void m29846e1(float f10) {
        this.f22553E = f10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f1 */
    public void m29847f1(int i10) {
        this.f22554F = i10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29338z0(int i10) {
        return (BackupItem) super.mo29338z0(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public BackupItem mo29289A0(int i10) {
        return (BackupItem) super.mo29289A0(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i1 */
    public void m29850i1(boolean z10) {
        this.f22551C = z10;
    }

    /* renamed from: j1 */
    public void m29851j1() {
        String strM29870d = m29870d();
        if (NavigationUtils.SMS_SCHEMA_PREF.equals(strM29870d) || "soundrecorder".equals(strM29870d)) {
            m29853l1();
        } else {
            m29852k1(m29824I0());
        }
    }

    /* renamed from: k1 */
    public final void m29852k1(List<BackupItem> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        long jM29875i = 0;
        long jM29873g = 0;
        long jM29874h = 0;
        int i10 = 0;
        int i11 = 0;
        for (BackupItem backupItem : list) {
            if (backupItem != null) {
                m29852k1(backupItem.m29824I0());
                if (!"thirdApp".equals(backupItem.m29870d())) {
                    jM29875i += backupItem.m29875i();
                    jM29874h += backupItem.m29874h();
                }
                jM29873g += backupItem.m29873g();
                int iM29860M = backupItem.m29860M();
                if (iM29860M == 0) {
                    i10++;
                } else if (iM29860M == 7) {
                    i11++;
                }
            }
        }
        mo29289A0(i10 != size ? i11 == size ? 7 : 4 : 0).mo29310W(i11).mo29325f0(size).mo29327g0(size).mo29323e0(jM29875i).mo29395c0(jM29873g).mo29321d0(jM29874h);
    }

    /* renamed from: l1 */
    public final void m29853l1() {
        List<BackupItem> listM29824I0 = m29824I0();
        if (listM29824I0 == null || listM29824I0.isEmpty()) {
            return;
        }
        if (listM29824I0.size() == 1) {
            listM29824I0.forEach(new Consumer() { // from class: nm.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f54227a.m29831P0((BackupItem) obj);
                }
            });
            return;
        }
        BackupItem backupItem = listM29824I0.get(0);
        BackupItem backupItem2 = listM29824I0.get(1);
        int iM29860M = backupItem.m29860M();
        if (iM29860M == 0) {
            mo29289A0(0).mo29310W(0).mo29325f0(0).mo29327g0(0).mo29308V(0L).mo29323e0(0L);
            return;
        }
        if (iM29860M == 4) {
            mo29310W(backupItem.m29869c()).mo29308V(backupItem.m29868a()).mo29323e0(backupItem.m29875i() + backupItem2.m29875i()).mo29325f0(backupItem.m29877l() + backupItem2.m29877l()).mo29327g0(backupItem.m29877l() + backupItem2.m29877l());
        } else if (iM29860M != 7) {
            mo29289A0(4).mo29327g0(backupItem.m29877l() + backupItem2.m29877l());
        } else {
            m29823H0(backupItem, backupItem2);
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    public String toString() {
        return "BackupItem{appId='" + m29870d() + "', appName='" + m29871e() + "', appType=" + m29872f() + ", status=" + m29859L() + ", type=" + m29860M() + ", alreadyCount=" + m29869c() + ", itemCount=" + m29876j() + ", itemTotal=" + m29877l() + ", alreadyBytes=" + m29868a() + ", attachBytes=" + m29873g() + ", dataBytes=" + m29875i() + ", codeBytes=" + m29874h() + ", floor=" + this.f22549A + ", expand=" + this.f22550B + ", visibility=" + this.f22551C + ", parentAppId='" + this.f22552D + ", uid='" + m29861N() + "} ";
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeList(this.f22555z);
    }
}
