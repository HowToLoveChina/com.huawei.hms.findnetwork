package com.huawei.android.remotecontrol.service;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseIntArray;
import bf.C1175a;
import com.huawei.airlink.IFinderTagAidlInterface;
import com.huawei.airlink.IFinderTagCallback;
import com.huawei.android.remotecontrol.bluetooth.AlsDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.android.remotecontrol.service.FinderTagService;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.api.HuaweiMobileServicesUtil;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.activity.SafeService;
import eg.AbstractC9478g;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0226l0;
import p015ak.C0241z;
import p227dg.C9120m0;
import p521og.C11872e;
import p521og.C11877j;
import p575qe.C12347f;
import p616rk.C12515a;
import p709vj.C13452e;
import p738we.InterfaceC13595b;
import p772xe.C13787l;
import p809yg.C13981a;
import se.C12785g;
import sg.C12797b;

/* loaded from: classes4.dex */
public class FinderTagService extends SafeService {

    /* renamed from: b */
    public long f20149b = 0;

    /* renamed from: c */
    public final Binder f20150c = new BinderC4401a();

    /* renamed from: com.huawei.android.remotecontrol.service.FinderTagService$a */
    public class BinderC4401a extends IFinderTagAidlInterface.Stub {

        /* renamed from: com.huawei.android.remotecontrol.service.FinderTagService$a$a */
        public class a extends AbstractC9478g {

            /* renamed from: a */
            public final /* synthetic */ IFinderTagCallback f20152a;

            public a(IFinderTagCallback iFinderTagCallback) {
                this.f20152a = iFinderTagCallback;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                try {
                    C12785g.m76715s().m76723G(true, false, this.f20152a);
                    if (this.f20152a != null) {
                        String strM80950o = C13452e.m80781L().m80950o();
                        C13981a.m83989i("FinderTagService", "startAlarm callback");
                        this.f20152a.onTagBindResult(strM80950o, 0);
                    }
                } catch (Exception e10) {
                    C13981a.m83988e("FinderTagService", "startAlarm e: " + e10.getMessage());
                }
            }
        }

        /* renamed from: com.huawei.android.remotecontrol.service.FinderTagService$a$b */
        public class b extends AbstractC9478g {

            /* renamed from: a */
            public final /* synthetic */ IFinderTagCallback f20154a;

            public b(IFinderTagCallback iFinderTagCallback) {
                this.f20154a = iFinderTagCallback;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws IllegalStateException {
                C12785g.m76715s().m76738p(this.f20154a);
            }
        }

        public BinderC4401a() {
        }

        /* renamed from: i */
        public static /* synthetic */ void m26534i(String str, IFinderTagCallback iFinderTagCallback, String str2, int i10) {
            if (str2 != null) {
                str = str2;
            }
            C13981a.m83989i("FinderTagService", "tag bind result: " + i10);
            if (iFinderTagCallback != null) {
                try {
                    iFinderTagCallback.onTagBindResult(str, i10);
                } catch (Exception e10) {
                    C13981a.m83989i("FinderTagService", "onTagBindResult exception " + e10.getMessage());
                }
            }
        }

        /* renamed from: j */
        public static /* synthetic */ void m26535j() {
            C4375j.m26397K(C12347f.m74285n().m74301m());
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void antiStalkingNotify(int i10) throws RemoteException {
            String str = "antiStalkingNotify, tagNum = " + i10;
            C13981a.m83989i("FinderTagService", str);
            new C12797b().m76784j(FinderTagService.this.getApplicationContext(), "FinderTagService", "", str, "", "tag_local_find", "", "tag_local_find", false);
            C11872e.m71165c(FinderTagService.this.getApplicationContext(), 0);
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public boolean isSupportAlarm() {
            return true;
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void notifyTagBinded(Bundle bundle, final IFinderTagCallback iFinderTagCallback) throws JSONException, RemoteException {
            C13981a.m83989i("FinderTagService", "notifyTagBinded");
            final String string = bundle.getString("deviceId");
            String string2 = bundle.getString("deviceName");
            String string3 = bundle.getString("goodsType");
            String string4 = bundle.getString("productId");
            String string5 = bundle.getString("subProductId");
            int i10 = bundle.getInt("componentType");
            int i11 = bundle.getInt(VastAttribute.SEQUENCE);
            String string6 = bundle.getString("deviceSn");
            String string7 = bundle.getString("deviceList");
            C13981a.m83989i("FinderTagService", "notifyTagBinded deviceId:" + C9120m0.m57351R(string) + " deviceName:" + string2 + " goodsType:" + string3 + " productId:" + string4 + " subProductId:" + string5 + " componentType:" + i10 + " sequence:" + i11 + " deviceSn:" + C9120m0.m57351R(string6));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" deviceList:");
            sb2.append(C9120m0.m57353S(string7));
            C13981a.m83989i("FinderTagService", sb2.toString());
            boolean z10 = 1 != i10 && TextUtils.isEmpty(string2);
            if (TextUtils.isEmpty(string) || z10 || TextUtils.isEmpty(string3)) {
                C13981a.m83988e("FinderTagService", "notifyTagBinded get param empty");
                if (iFinderTagCallback != null) {
                    iFinderTagCallback.onTagBindResult(string, 3);
                    return;
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("deviceId", string);
                jSONObject.put("productId", string4);
                jSONObject.put("componentType", i10);
                jSONObject.put("deviceList", C9120m0.m57353S(string7));
                C9120m0.m57389g1(FinderTagService.this.getApplicationContext(), "mecloud_findmyphone_FN_active_device", "", jSONObject, 0);
            } catch (JSONException unused) {
                C13981a.m83988e("FinderTagService", "notifyTagBinded JSONException");
            }
            AncillaryDeviceInfo ancillaryDeviceInfo = new AncillaryDeviceInfo();
            ancillaryDeviceInfo.setDeviceID(string);
            ancillaryDeviceInfo.setDeviceName(string2);
            ancillaryDeviceInfo.setGoodsType(string3);
            ancillaryDeviceInfo.setPerDeviceType("3");
            ancillaryDeviceInfo.setSubDeviceType("1");
            ancillaryDeviceInfo.setModelId(string4);
            ancillaryDeviceInfo.setSubModelId(string5);
            ancillaryDeviceInfo.setComponentType(i10);
            ancillaryDeviceInfo.setSequence(i11);
            ancillaryDeviceInfo.setDeviceSn(string6);
            if (!TextUtils.isEmpty(string7)) {
                try {
                    ancillaryDeviceInfo.setDeviceList(new JSONArray(string7));
                } catch (JSONException e10) {
                    C13981a.m83988e("FinderTagService", "parse deviceList fail " + e10.getMessage() + " : " + string7);
                }
            }
            ancillaryDeviceInfo.setCallback(new InterfaceC13595b() { // from class: uf.a
                @Override // p738we.InterfaceC13595b
                public final void onTagBindResult(String str, int i12) {
                    FinderTagService.BinderC4401a.m26534i(string, iFinderTagCallback, str, i12);
                }
            });
            AncillaryDeviceManager.m26080y().m26108w(ancillaryDeviceInfo);
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void notifyTagStatusChange(String str, boolean z10) throws JSONException, RemoteException {
            FinderTagService.m26531c(FinderTagService.this.getApplicationContext(), str, z10, null, "");
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface.Stub, android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str;
            if (i10 == 3) {
                C13981a.m83989i("FinderTagService", "onTransact, notifyTagStatusChange call");
            }
            String[] packagesForUid = FinderTagService.this.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            boolean z10 = false;
            try {
                str = packagesForUid.length > 0 ? packagesForUid[0] : null;
                C13981a.m83989i("FinderTagService", "onTransact, packageName: " + str);
            } catch (Exception e10) {
                C13981a.m83989i("FinderTagService", "onTransact, Exception: " + e10.getMessage());
                C12797b c12797b = new C12797b();
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("exceptionExtra", e10.getMessage());
                c12797b.m76785k(FinderTagService.this.getApplicationContext(), "FinderTagService", "-1", "onTransact exception", null, "tag_local_find", null, "finderTagNotifyStatus", true, linkedHashMap);
            }
            if (!StringUtil.equals(str, "com.huawei.hwid")) {
                return false;
            }
            int iCheckCallingPermission = FinderTagService.this.checkCallingPermission("com.huawei.remotocontrol.permission.REMOTECALL");
            if (HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(FinderTagService.this.getApplicationContext(), 601000300) == 0 && iCheckCallingPermission == 0 && super.onTransact(i10, parcel, parcel2, i11)) {
                z10 = true;
            }
            C13981a.m83989i("FinderTagService", "onTransact, result: " + z10);
            return z10;
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public boolean queryOfflineLocateStatus() throws RemoteException {
            C13981a.m83989i("FinderTagService", "queryOfflineLocateStatus");
            Context contextM74301m = C12347f.m74285n().m74301m();
            if (!C13452e.m80781L().m80842P0()) {
                C13981a.m83989i("FinderTagService", "cloud not login");
                return false;
            }
            if (!C1175a.m7389k(contextM74301m)) {
                C13981a.m83989i("FinderTagService", "phoneFinder switch off");
                return false;
            }
            boolean zM71246Z = C11877j.m71246Z(contextM74301m);
            C11877j.m71239V0(C12347f.m74285n().m74301m(), zM71246Z);
            boolean z10 = System.currentTimeMillis() - FinderTagService.this.f20149b > 60000;
            if (zM71246Z && z10) {
                FinderTagService.this.f20149b = System.currentTimeMillis();
                new C12797b().m76785k(C12347f.m74285n().m74301m(), "FinderTagService", "", JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN, "success", "notify_nearby", "", "mecloud_findmyphone_notify_nearby_status", true, null);
                UBAAnalyze.m29946G("CKP", "mecloud_findmyphone_notify_nearby_status", JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN, "success", C13452e.m80781L().m80790C());
            }
            boolean zM26424z = C4375j.m26424z(contextM74301m);
            C13981a.m83989i("FinderTagService", "isOfflineLocateSwitchOpen:" + zM26424z);
            if (zM26424z) {
                C0226l0.m1585e(new Runnable() { // from class: uf.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        FinderTagService.BinderC4401a.m26535j();
                    }
                }, 1000L);
            }
            return zM71246Z;
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void startAlarm(IFinderTagCallback iFinderTagCallback) {
            C13981a.m83989i("FinderTagService", "startAlarm");
            C12515a.m75110o().m75172d(new a(iFinderTagCallback));
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void stopAlarm(IFinderTagCallback iFinderTagCallback) {
            C13981a.m83989i("FinderTagService", "stopAlarm");
            C12515a.m75110o().m75172d(new b(iFinderTagCallback));
        }
    }

    /* renamed from: c */
    public static void m26531c(Context context, String str, boolean z10, String str2, String str3) throws JSONException {
        LinkedHashMap<String, String> linkedHashMap;
        AlsDeviceInfo alsDeviceInfo;
        String strM57351R = C9120m0.m57351R(str);
        String strM57355T = C9120m0.m57355T(str2);
        C13981a.m83989i("FinderTagService", "notifyTagStatusChange, status: " + z10 + ", tagId: " + strM57351R + ", standByDevice: " + strM57355T + ", productId: " + str3);
        C12797b c12797b = new C12797b();
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
        linkedHashMap2.put("perDeviceId", strM57351R);
        linkedHashMap2.put("mStandbyDevice", strM57355T);
        try {
            linkedHashMap = linkedHashMap2;
            try {
                c12797b.m76785k(context, "FinderTagService", "0", "notifyTagStatusChange, status: " + z10, null, z10 ? "01053" : "01054", null, "finderTagNotifyStatus", true, linkedHashMap);
                alsDeviceInfo = new AlsDeviceInfo();
                alsDeviceInfo.setDeviceID(str);
                alsDeviceInfo.setPerDeviceType("3");
                SparseIntArray sparseIntArray = new SparseIntArray(1);
                sparseIntArray.put(0, C0241z.m1685c(z10 ? "2" : "0"));
                alsDeviceInfo.setConnectStatus(sparseIntArray);
            } catch (Exception e10) {
                e = e10;
            }
            try {
                C13787l.m82769o1(context, alsDeviceInfo, z10, str2, str3);
            } catch (Exception e11) {
                e = e11;
                C13981a.m83988e("FinderTagService", "notifyTagStatusChange, exception: " + e.getMessage());
                linkedHashMap.put("exceptionExtra", e.getMessage());
                c12797b.m76785k(context, "FinderTagService", "-1", "notifyTagStatusChange exception, status " + z10, null, z10 ? "01053" : "01054", null, "finderTagNotifyStatus", true, linkedHashMap);
            }
        } catch (Exception e12) {
            e = e12;
            linkedHashMap = linkedHashMap2;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f20150c;
    }
}
