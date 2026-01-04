package com.huawei.android.hicloud.sync.contact;

import android.content.Context;
import com.huawei.android.hicloud.sync.service.aidl.ModuleRst;
import com.huawei.android.hicloud.sync.syncutil.C2974c;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9722c;
import p514o9.C11839m;
import tc.C13007b;

/* renamed from: com.huawei.android.hicloud.sync.contact.p */
/* loaded from: classes3.dex */
public class C2891p extends C2877b {

    /* renamed from: a0 */
    public final Context f12929a0;

    /* renamed from: b0 */
    public ModuleRst f12930b0;

    public C2891p(Context context, String str, String str2) {
        super(context, "addressbook", null, str, str2);
        this.f12930b0 = null;
        this.f12929a0 = context;
    }

    /* renamed from: A0 */
    public final void m17689A0() throws Exception {
        C11839m.m70686d("SyncAddressImp", "begin processContactSync");
        m17248D(HNConstants.DataType.CONTACT);
        setDataType(HNConstants.DataType.CONTACT);
        m17313q0();
        if (isNeedQueryCloudDataV2()) {
            C11839m.m70686d("SyncAddressImp", "Contact ctag not equal");
            isCancel();
            getRecordListNotSupportRecycle();
            C13007b c13007bM78205Y = C13007b.m78205Y(this.f12929a0);
            if (c13007bM78205Y.m78298z(this.mSyncType, this.mDataType)) {
                C11839m.m70688i("SyncAddressImp", "syncV2 isNeedFullSync dataType:" + this.mDataType);
                c13007bM78205Y.m78279p0(this.mSyncType, this.mDataType, false);
            }
            if (m17259e()) {
                processCloudData();
            }
            if (this.f12791e) {
                m17252H(false);
            }
        }
        if (new C2974c(this.f12929a0, this.mSyncType, "", this.mDataType, this.f12795i.size(), this.f12797k.size(), this.f12796j.size(), this.traceId).m17833f()) {
            throw new C9722c(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED, "risk management effective");
        }
        m17294X();
        if (!this.f12791e) {
            m17252H(false);
        }
        this.f12930b0.setNumbers(this.f12777Q, this.f12779S, this.f12778R - this.f12780T, this.f12774N, this.f12776P, this.f12775O);
        m17283M();
    }

    /* renamed from: B0 */
    public final void m17690B0() throws Exception {
        C11839m.m70686d("SyncAddressImp", "begin processGroupSync");
        m17248D("group");
        setDataType("group");
        m17276v();
        m17314r0();
        if (isNeedQueryCloudDataV2()) {
            C11839m.m70686d("SyncAddressImp", "Group ctag not equal");
            isCancel();
            getRecordList();
            C13007b c13007bM78205Y = C13007b.m78205Y(this.f12929a0);
            if (c13007bM78205Y.m78298z(this.mSyncType, this.mDataType)) {
                C11839m.m70688i("SyncAddressImp", "syncV2 isNeedFullSync dataType:" + this.mDataType);
                c13007bM78205Y.m78279p0(this.mSyncType, this.mDataType, false);
            }
            if (m17264j()) {
                processCloudData();
            }
            if (this.f12791e) {
                m17252H(false);
            }
        }
        m17303g0();
        if (!this.f12791e) {
            m17252H(false);
        }
        m17284N();
    }

    /* renamed from: C0 */
    public final void m17691C0() throws Exception {
        C11839m.m70686d("SyncAddressImp", "syncV2 contact Begin prepare get lock mSyncMode: " + this.f12785Y);
        isCancel();
        syncV2(this.mSyncType);
        m17689A0();
        m17690B0();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0240  */
    /* renamed from: z0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.android.hicloud.sync.service.aidl.ModuleRst m17692z0(android.os.Handler.Callback r23, com.huawei.android.hicloud.sync.service.aidl.SyncType r24, com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.C2891p.m17692z0(android.os.Handler$Callback, com.huawei.android.hicloud.sync.service.aidl.SyncType, com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo):com.huawei.android.hicloud.sync.service.aidl.ModuleRst");
    }
}
