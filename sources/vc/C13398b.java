package vc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import bd.C1164a;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.syncutil.C2981j;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Changes;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import je.C10812z;
import p255ed.C9453i;
import p514o9.C11839m;
import p664u0.C13108a;
import sc.C12770c;
import tc.C13007b;

/* renamed from: vc.b */
/* loaded from: classes3.dex */
public class C13398b extends SyncProcessBase {

    /* renamed from: a */
    public final Context f60412a;

    /* renamed from: b */
    public List<String> f60413b;

    /* renamed from: c */
    public List<String> f60414c;

    /* renamed from: d */
    public List<String> f60415d;

    /* renamed from: e */
    public ArrayList<CtagInfo> f60416e;

    /* renamed from: f */
    public Map<String, String> f60417f;

    public C13398b(Context context, String str, List<String> list, List<String> list2, List<String> list3, String str2, String str3, String str4, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, null, str2, str3, str4, concurrentHashMap);
        this.f60413b = new ArrayList(10);
        this.f60414c = new ArrayList(10);
        this.f60415d = new ArrayList(10);
        this.f60416e = new ArrayList<>();
        this.f60417f = new HashMap();
        this.f60412a = context;
        if (list != null) {
            this.f60413b = list;
        }
        if (list2 != null) {
            this.f60414c = list2;
        }
        if (list3 != null) {
            this.f60415d = list3;
        }
    }

    private void unLockV2() throws Throwable {
        try {
            C11839m.m70688i("EndSyncImpl", "syncV2 unLockV2");
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
            if (c9453iM7268d == null) {
                C11839m.m70687e("EndSyncImpl", "syncV2 unLockV2 drive builder is null.");
                return;
            }
            C13007b c13007bM78205Y = C13007b.m78205Y(this.f60412a);
            if (TextUtils.isEmpty(c13007bM78205Y.m78224J(this.mSyncType, this.mSyncModulePackageName))) {
                C11839m.m70689w("EndSyncImpl", "syncV2 x-hw-lock is null or empty, don't need unlock, syncType = " + this.mSyncType);
                return;
            }
            if (m80501c()) {
                Changes.GetStartCursor startCursor = c9453iM7268d.m59249h().getStartCursor(DriveSyncUtil.m17959D(this.mSyncType));
                DriveSyncUtil.m17994g(startCursor.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                startCursor.setFields2("startCursor");
                String startCursor2 = startCursor.execute().getStartCursor();
                C11839m.m70686d("EndSyncImpl", "syncV2 unlock getStartCursor syncType: " + this.mSyncType + ", getStartCursor: " + startCursor2);
                for (int i10 = 0; i10 < this.f60414c.size(); i10++) {
                    String str = this.f60413b.get(i10);
                    if ("notepad".equals(this.mSyncType)) {
                        if (String.valueOf(0).equals(this.f60414c.get(i10)) && c13007bM78205Y.m78244V(str)) {
                            C11839m.m70688i("EndSyncImpl", "syncV2 update local Ctag dataType = " + str + ", ctag = " + startCursor2);
                            CtagInfo ctagInfo = new CtagInfo();
                            ctagInfo.setCtagName(str);
                            ctagInfo.setCtagValue(startCursor2);
                            this.f60416e.add(ctagInfo);
                        }
                    } else if (String.valueOf(0).equals(this.f60414c.get(i10))) {
                        C11839m.m70688i("EndSyncImpl", "syncV2 update local Ctag dataType = " + str + ", ctag = " + startCursor2);
                        CtagInfo ctagInfo2 = new CtagInfo();
                        ctagInfo2.setCtagName(str);
                        ctagInfo2.setCtagValue(startCursor2);
                        this.f60416e.add(ctagInfo2);
                    }
                }
                if (!SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName) && this.f60416e.size() > 0) {
                    m80502d(this.f60416e);
                }
            }
            unlockV2(this.mSyncType);
        } catch (Exception e10) {
            C11839m.m70687e("EndSyncImpl", "syncV2 unLockV2 error: " + e10.getMessage());
        }
    }

    /* renamed from: a */
    public final void m80499a() {
        C11839m.m70688i("EndSyncImpl", "CallBack, value = 0");
        C10812z.m65837f(this.f60412a, this.mSyncType, 0, "", this.operationType, "local_end", this.traceId);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10009);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, 0);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        if (SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName)) {
            if (SyncLogicService.isSdkSupportIncrementalProcess(this.mSyncModulePackageName)) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f60416e.size());
                Iterator<CtagInfo> it = this.f60416e.iterator();
                while (it.hasNext()) {
                    arrayList.add(new CtagInfoCompatible(it.next(), SyncLogicService.getSdkVersion(this.mSyncModulePackageName)));
                }
                bundle.putParcelableArrayList("update_ctag_list", arrayList);
            } else {
                bundle.putParcelableArrayList("update_ctag_list", this.f60416e);
            }
        }
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.f60412a).m78881d(intent);
    }

    /* renamed from: b */
    public void m80500b() {
        C11839m.m70688i("EndSyncImpl", "endSync");
        int i10 = 0;
        try {
            try {
                unLockV2();
                SyncLogicServiceUtil.syncRemovePowerkit(this.mSyncType);
                C2981j.m17895i(this.mSyncModulePackageName);
                m80499a();
                C13007b c13007bM78205Y = C13007b.m78205Y(this.f60412a);
                c13007bM78205Y.m78270l(this.mSyncType, this.mSyncModulePackageName);
                while (i10 < this.f60413b.size()) {
                    c13007bM78205Y.m78280q(this.f60413b.get(i10));
                    i10++;
                }
            } catch (Exception e10) {
                C11839m.m70687e("EndSyncImpl", "Exception occurred = " + e10.toString());
                m80499a();
                C13007b c13007bM78205Y2 = C13007b.m78205Y(this.f60412a);
                c13007bM78205Y2.m78270l(this.mSyncType, this.mSyncModulePackageName);
                while (i10 < this.f60413b.size()) {
                    c13007bM78205Y2.m78280q(this.f60413b.get(i10));
                    i10++;
                }
            }
        } catch (Throwable th2) {
            m80499a();
            C13007b c13007bM78205Y3 = C13007b.m78205Y(this.f60412a);
            c13007bM78205Y3.m78270l(this.mSyncType, this.mSyncModulePackageName);
            while (i10 < this.f60413b.size()) {
                c13007bM78205Y3.m78280q(this.f60413b.get(i10));
                i10++;
            }
            throw th2;
        }
    }

    /* renamed from: c */
    public final boolean m80501c() {
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f60412a);
        for (int i10 = 0; i10 < this.f60414c.size(); i10++) {
            String str = this.f60413b.get(i10);
            if (c13007bM78205Y.m78244V(str) && String.valueOf(0).equals(this.f60414c.get(i10))) {
                C11839m.m70686d("EndSyncImpl", "syncV2 unlock need update ctag, dataType: " + str);
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public final void m80502d(List<CtagInfo> list) throws Exception {
        C11839m.m70686d("EndSyncImpl", "UpdateLocalCtag, list size = " + list.size());
        new C12770c().m76642j(list);
    }
}
