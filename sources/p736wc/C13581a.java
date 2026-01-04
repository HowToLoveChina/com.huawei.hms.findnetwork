package p736wc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import bd.C1164a;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicServiceUtil;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Changes;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import je.C10812z;
import p255ed.C9453i;
import p514o9.C11839m;
import p664u0.C13108a;
import tc.C13007b;

/* renamed from: wc.a */
/* loaded from: classes3.dex */
public class C13581a extends SyncProcessBase {

    /* renamed from: a */
    public final Context f61083a;

    /* renamed from: b */
    public List<String> f61084b;

    /* renamed from: c */
    public List<String> f61085c;

    /* renamed from: d */
    public ArrayList<CtagInfo> f61086d;

    /* renamed from: e */
    public boolean f61087e;

    public C13581a(Context context, String str, List<String> list, List<String> list2, List<String> list3, String str2, String str3, String str4, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, null, str2, str3, str4, concurrentHashMap);
        this.f61084b = new ArrayList(10);
        this.f61085c = new ArrayList(10);
        this.f61086d = new ArrayList<>();
        this.f61087e = false;
        this.f61083a = context;
        if (list != null) {
            this.f61084b = list;
        }
        if (list2 != null) {
            this.f61085c = list2;
        }
    }

    /* renamed from: a */
    private void m81584a() {
        C11839m.m70688i("GenEndSyncImpl", "CallBack, value = 0");
        C10812z.m65837f(this.f61083a, this.mSyncType, 0, "", this.operationType, "local_end", this.traceId);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10009);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, 0);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f61086d.size());
        Iterator<CtagInfo> it = this.f61086d.iterator();
        while (it.hasNext()) {
            arrayList.add(new CtagInfoCompatible(it.next(), GenSyncLogicService.getSdkVersion(this.mSyncModulePackageName)));
        }
        bundle.putParcelableArrayList("update_ctag_list", arrayList);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.f61083a).m78881d(intent);
    }

    /* renamed from: c */
    private boolean m81585c() {
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f61083a);
        for (int i10 = 0; i10 < this.f61085c.size(); i10++) {
            String str = this.f61084b.get(i10);
            if (c13007bM78205Y.m78244V(str) && String.valueOf(0).equals(this.f61085c.get(i10))) {
                C11839m.m70686d("GenEndSyncImpl", "syncV2 unlock need update ctag, dataType: " + str);
                return true;
            }
        }
        return false;
    }

    private void unLockV2() throws Throwable {
        try {
            C11839m.m70688i("GenEndSyncImpl", "syncV2 unLockV2");
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
            if (TextUtils.isEmpty(C13007b.m78205Y(this.f61083a).m78224J(this.mSyncType, this.mSyncModulePackageName))) {
                C11839m.m70689w("GenEndSyncImpl", "syncV2 x-hw-lock is null or empty, don't need unlock, syncType = " + this.mSyncType);
                return;
            }
            if (m81585c()) {
                Changes.GetStartCursor startCursor = c9453iM7268d.m59249h().getStartCursor(DriveSyncUtil.m17959D(this.mSyncType));
                DriveSyncUtil.m17994g(startCursor.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                startCursor.setFields2("startCursor");
                String startCursor2 = startCursor.execute().getStartCursor();
                C11839m.m70686d("GenEndSyncImpl", "syncV2 unlock getStartCursor syncType: " + this.mSyncType + ", getStartCursor: " + startCursor2);
                for (int i10 = 0; i10 < this.f61085c.size(); i10++) {
                    String str = this.f61084b.get(i10);
                    if (String.valueOf(0).equals(this.f61085c.get(i10))) {
                        C11839m.m70688i("GenEndSyncImpl", "syncV2 update local Ctag dataType = " + str + ", ctag = " + startCursor2);
                        CtagInfo ctagInfo = new CtagInfo();
                        ctagInfo.setCtagName(str);
                        ctagInfo.setCtagValue(startCursor2);
                        this.f61086d.add(ctagInfo);
                    }
                }
            }
            unlockV2(this.mSyncType);
        } catch (Exception e10) {
            C11839m.m70687e("GenEndSyncImpl", "syncV2 unLockV2 error: " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public void m81586b() {
        C11839m.m70688i("GenEndSyncImpl", "endSync: is download only? " + this.f61087e);
        int i10 = 0;
        try {
            try {
                if (!this.f61087e) {
                    unLockV2();
                }
                GenSyncLogicServiceUtil.syncRemovePowerkit(this.mSyncType);
                m81584a();
                C13007b c13007bM78205Y = C13007b.m78205Y(this.f61083a);
                c13007bM78205Y.m78270l(this.mSyncType, this.mSyncModulePackageName);
                while (i10 < this.f61084b.size()) {
                    c13007bM78205Y.m78280q(this.f61084b.get(i10));
                    i10++;
                }
            } catch (Exception e10) {
                C11839m.m70687e("GenEndSyncImpl", "Exception occurred = " + e10.toString());
                m81584a();
                C13007b c13007bM78205Y2 = C13007b.m78205Y(this.f61083a);
                c13007bM78205Y2.m78270l(this.mSyncType, this.mSyncModulePackageName);
                while (i10 < this.f61084b.size()) {
                    c13007bM78205Y2.m78280q(this.f61084b.get(i10));
                    i10++;
                }
            }
        } catch (Throwable th2) {
            m81584a();
            C13007b c13007bM78205Y3 = C13007b.m78205Y(this.f61083a);
            c13007bM78205Y3.m78270l(this.mSyncType, this.mSyncModulePackageName);
            while (i10 < this.f61084b.size()) {
                c13007bM78205Y3.m78280q(this.f61084b.get(i10));
                i10++;
            }
            throw th2;
        }
    }

    /* renamed from: d */
    public void m81587d(boolean z10) {
        this.f61087e = z10;
    }
}
