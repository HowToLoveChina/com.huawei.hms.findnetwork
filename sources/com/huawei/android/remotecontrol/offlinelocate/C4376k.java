package com.huawei.android.remotecontrol.offlinelocate;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.remotecontrol.trustchange.SelectResult;
import com.huawei.hms.findnetwork.comm.request.option.OfflineBroadcastParam;
import com.huawei.security.hwassetmanager.HwAssetManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p227dg.C9120m0;
import p575qe.C12347f;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;

/* renamed from: com.huawei.android.remotecontrol.offlinelocate.k */
/* loaded from: classes4.dex */
public class C4376k {

    /* renamed from: a */
    public static final HwAssetManager f20011a = HwAssetManager.getInstance();

    /* renamed from: b */
    public static final String f20012b = String.valueOf(805318380);

    /* renamed from: a */
    public static String m26425a(Context context, byte[] bArr, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(HwAssetManager.BUNDLE_ASSETTYPE, 6);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_ALGO_TYPE, 6);
        bundle.putString(HwAssetManager.BUNDLE_ALIAS, str);
        bundle.putByteArray(HwAssetManager.BUNDLE_SRC_DATA, bArr);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_PURPOSE, 2);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_DIGEST_ALGO, 4);
        HwAssetManager.AssetResult assetResultAssetOperate = f20011a.assetOperate(context, bundle);
        C12797b c12797b = new C12797b();
        if (assetResultAssetOperate.resultCode == 0) {
            C13981a.m83989i("PhoneFinderAssetManager", "AssertDecryptData success");
            c12797b.m76784j(context, "PhoneFinderAssetManager", "", "AssetDecryptData success", "", "call_asset_api_result", "", "call_asset_api_result", true);
            return C4375j.m26411m(((String) assetResultAssetOperate.resultInfo.get(0)).getBytes(StandardCharsets.ISO_8859_1));
        }
        C13981a.m83988e("PhoneFinderAssetManager", "AssertDecryptData fail resultCode = " + assetResultAssetOperate.resultCode);
        c12797b.m76784j(context, "PhoneFinderAssetManager", "", "AssertDecryptData fail resultCode=" + assetResultAssetOperate.resultCode, "", "call_asset_api_result", "", "call_asset_api_result", true);
        return "";
    }

    /* renamed from: b */
    public static boolean m26426b(Context context, byte[] bArr, byte[] bArr2, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(HwAssetManager.BUNDLE_ASSETTYPE, 6);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_WRAP_TYPE, 6);
        bundle.putString(HwAssetManager.BUNDLE_TARGET_ALIAS, str);
        bundle.putByteArray(HwAssetManager.BUNDLE_CLOUD_SYNC_ACCOUNT_UID, bArr2);
        bundle.putByteArray(HwAssetManager.BUNDLE_SRC_DATA, bArr);
        HwAssetManager.AssetResult assetResultAssetUnwrap = f20011a.assetUnwrap(context, bundle);
        C13981a.m83989i("PhoneFinderAssetManager", "assetUnwrapPrivateKey resultCode is:" + assetResultAssetUnwrap.resultCode);
        return assetResultAssetUnwrap.resultCode == 0;
    }

    /* renamed from: c */
    public static void m26427c(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(HwAssetManager.BUNDLE_ASSETTYPE, 6);
        bundle.putByteArray(HwAssetManager.BUNDLE_TARGET_ALIAS, str.getBytes(StandardCharsets.ISO_8859_1));
        bundle.putInt(HwAssetManager.BUNDLE_IS_SYNC_APP_DATA, 1);
        C13981a.m83989i("PhoneFinderAssetManager", "deleteKey result = " + f20011a.assetDelete(context, bundle).resultCode);
    }

    /* renamed from: d */
    public static void m26428d(String str, Context context) {
        try {
            m26427c(context, str);
        } catch (Exception e10) {
            C13981a.m83988e("PhoneFinderAssetManager", "deleteOtherDeviceRootKeyAlias error:" + e10.getMessage());
        }
    }

    /* renamed from: e */
    public static void m26429e(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(HwAssetManager.BUNDLE_ASSETTYPE, 6);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_ALGO_TYPE, 5);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_LENGTH, 256);
        bundle.putString(HwAssetManager.BUNDLE_TARGET_ALIAS, "FindPhoneMasterKey");
        bundle.putInt(HwAssetManager.BUNDLE_KEY_OUTGOING_TYPE, 1);
        bundle.putString(HwAssetManager.BUNDLE_CLOUD_SYNC_ACCOUNT_UID, str);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_PURPOSE, 9);
        C13981a.m83989i("PhoneFinderAssetManager", "deriveRootKey result:" + f20011a.assetGenerate(context, bundle).resultCode);
    }

    /* renamed from: f */
    public static void m26430f(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        String str3 = HwAssetManager.BUNDLE_TARGET_ALIAS;
        Charset charset = StandardCharsets.ISO_8859_1;
        bundle.putByteArray(str3, str.getBytes(charset));
        bundle.putByteArray(HwAssetManager.BUNDLE_KEY_GEN_ALIAS, str2.getBytes(charset));
        bundle.putInt(HwAssetManager.BUNDLE_ASSETTYPE, 6);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_GEN_TYPE, 1);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_PURPOSE, 3);
        bundle.putInt(HwAssetManager.BUNDLE_TEE_STORAGE, 1);
        bundle.putInt(HwAssetManager.BUNDLE_DERIVE_KEY_ALG, 1);
        bundle.putByteArray(HwAssetManager.BUNDLE_KEY_DERIVE_SALT, str.getBytes(charset));
        bundle.putByteArray(HwAssetManager.BUNDLE_KEY_DERIVE_LABEL, str.getBytes(charset));
        bundle.putInt(f20012b, 10000);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_ALGO_TYPE, 5);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_BLOCKMODE, 31);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_PADDING, 64);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_LENGTH, 256);
        C13981a.m83989i("PhoneFinderAssetManager", "deriveTempKey result:" + f20011a.assetGenerate(context, bundle).resultCode);
    }

    /* renamed from: g */
    public static byte[] m26431g(Context context, String str, String str2) {
        byte[] bArr = new byte[0];
        try {
            m26430f(context, str, str2);
            byte[] bArr2 = (byte[]) m26436l(context, str).clone();
            try {
                m26427c(context, str);
                return bArr2;
            } catch (Exception e10) {
                e = e10;
                bArr = bArr2;
                C13981a.m83988e("PhoneFinderAssetManager", "generatePublicKey error:" + e.getMessage());
                return bArr;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* renamed from: h */
    public static byte[] m26432h(Context context, String str) {
        boolean zM26434j = m26434j();
        C13981a.m83989i("PhoneFinderAssetManager", "generateRootKey huksHasKey:" + zM26434j);
        if (!zM26434j) {
            m26429e(context, str);
        }
        return m26437m(context, str);
    }

    /* renamed from: i */
    public static List<OfflineBroadcastParam> m26433i(Context context, String str, String str2, String str3, String str4) {
        int i10;
        C12797b c12797b;
        int i11;
        ArrayList arrayList;
        C13981a.m83989i("PhoneFinderAssetManager", "getOtherDevicePk deviceId: " + C9120m0.m57351R(str2));
        C12797b c12797b2 = new C12797b();
        byte[] bArrM26409k = C4375j.m26409k(str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || bArrM26409k.length == 0) {
            C13981a.m83988e("PhoneFinderAssetManager", "getOtherDevicePk params is empty");
            c12797b2.m76784j(context, "PhoneFinderAssetManager", "", "getOtherDevicePk params is empty", "", "call_asset_api_result", "", "call_asset_api_result", true);
            return new ArrayList();
        }
        if (!C4375j.m26423y()) {
            C13981a.m83990w("PhoneFinderAssetManager", "getOtherDevicePk huks not support");
            c12797b2.m76784j(context, "PhoneFinderAssetManager", "", "requestPublicKey huks not support", "", "call_asset_api_result", "", "call_asset_api_result", true);
            return new ArrayList();
        }
        if (!m26426b(context, bArrM26409k, str3.getBytes(StandardCharsets.ISO_8859_1), str4)) {
            C13981a.m83988e("PhoneFinderAssetManager", "getOtherDevicePk assetUnwrapPrivateKey failed");
            c12797b2.m76784j(context, "PhoneFinderAssetManager", "", "getOtherDevicePk assetUnwrapPrivateKey failed", "", "call_asset_api_result", "", "call_asset_api_result", true);
            return new ArrayList();
        }
        ArrayList arrayList2 = new ArrayList();
        if (C0209d.m1277l1()) {
            return arrayList2;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i12 = 0;
        int i13 = 0;
        while (i13 < 14) {
            OfflineBroadcastParam offlineBroadcastParam = new OfflineBroadcastParam();
            String strM26416r = C4375j.m26416r(jCurrentTimeMillis + (i13 * 86400000));
            offlineBroadcastParam.setPubKeyDate(strM26416r);
            byte[] bArrM26431g = m26431g(context, str2 + strM26416r, str4);
            if (bArrM26431g.length <= 0) {
                C13981a.m83988e("PhoneFinderAssetManager", "generatePublicKey is empty");
                C12797b c12797b3 = c12797b2;
                i10 = i13;
                c12797b = c12797b2;
                i11 = i12;
                c12797b3.m76784j(context, "PhoneFinderAssetManager", "", "setPubKeysToNearby generatePublicKey failed", "", "KEY_CALL_ASSET_API_RESULT", "", "", true);
                arrayList = arrayList2;
            } else {
                i10 = i13;
                c12797b = c12797b2;
                i11 = i12;
                offlineBroadcastParam.setPublicKey(bArrM26431g);
                offlineBroadcastParam.setmDeviceId(str2);
                offlineBroadcastParam.setMac(new byte[i11]);
                arrayList = arrayList2;
                arrayList.add(offlineBroadcastParam);
            }
            i13 = i10 + 1;
            arrayList2 = arrayList;
            i12 = i11;
            c12797b2 = c12797b;
        }
        ArrayList arrayList3 = arrayList2;
        m26428d(str4, context);
        C13981a.m83989i("PhoneFinderAssetManager", "getOtherDevicePk deviceId: " + C9120m0.m57351R(str2) + ", listSize: " + arrayList3.size());
        return arrayList3;
    }

    /* renamed from: j */
    public static boolean m26434j() {
        boolean zM26435k;
        try {
            Context contextM74301m = C12347f.m74285n().m74301m();
            String userID = AbstractC12139d.m72766e(contextM74301m).getUserID();
            Bundle bundle = new Bundle();
            bundle.putInt(HwAssetManager.BUNDLE_ASSETTYPE, 6);
            bundle.putString(HwAssetManager.BUNDLE_TARGET_ALIAS, "FindPhoneMasterKey");
            bundle.putInt(HwAssetManager.BUNDLE_SELECTFLAG, 3);
            zM26435k = m26435k(userID, f20011a.assetSelect(contextM74301m, bundle));
        } catch (Exception e10) {
            C13981a.m83988e("PhoneFinderAssetManager", "huksHasRootKey Exception: " + e10.getMessage());
            zM26435k = false;
        }
        C13981a.m83989i("PhoneFinderAssetManager", "huksHasRootKey hasRootKey: " + zM26435k);
        return zM26435k;
    }

    /* renamed from: k */
    public static boolean m26435k(String str, HwAssetManager.AssetResult assetResult) {
        boolean z10 = false;
        z10 = false;
        if (assetResult == null || assetResult.resultInfo == null) {
            C13981a.m83989i("PhoneFinderAssetManager", "isMatch input error");
            return false;
        }
        if (assetResult.resultCode == 0 && assetResult.resultInfo.size() > 0) {
            boolean zIsMatchKey = false;
            for (int i10 = 0; i10 < assetResult.resultInfo.size() && !(zIsMatchKey = ((SelectResult) new Gson().fromJson((String) assetResult.resultInfo.get(i10), SelectResult.class)).isMatchKey(str)); i10++) {
                try {
                } catch (Exception e10) {
                    C13981a.m83988e("PhoneFinderAssetManager", "isMatch error:" + e10.getMessage());
                }
            }
            z10 = zIsMatchKey;
        }
        C13981a.m83989i("PhoneFinderAssetManager", "isMatch resultCode:" + assetResult.resultCode + " size:" + assetResult.resultInfo.size() + " isMatch:" + z10);
        return z10;
    }

    /* renamed from: l */
    public static byte[] m26436l(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(HwAssetManager.BUNDLE_ASSETTYPE, 6);
        String str2 = HwAssetManager.BUNDLE_TARGET_ALIAS;
        Charset charset = StandardCharsets.ISO_8859_1;
        bundle.putByteArray(str2, str.getBytes(charset));
        bundle.putInt(HwAssetManager.BUNDLE_IS_SYNC_APP_DATA, 1);
        bundle.putInt(HwAssetManager.BUNDLE_SELECTFLAG, 7);
        HwAssetManager.AssetResult assetResultAssetSelect = f20011a.assetSelect(context, bundle);
        C13981a.m83987d("PhoneFinderAssetManager", "selectTempKey result:" + assetResultAssetSelect.resultCode);
        return assetResultAssetSelect.resultCode == 0 ? ((String) assetResultAssetSelect.resultInfo.get(0)).getBytes(charset) : new byte[0];
    }

    /* renamed from: m */
    public static byte[] m26437m(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(HwAssetManager.BUNDLE_ASSETTYPE, 6);
        bundle.putInt(HwAssetManager.BUNDLE_KEY_WRAP_TYPE, 6);
        String str2 = HwAssetManager.BUNDLE_TARGET_ALIAS;
        Charset charset = StandardCharsets.ISO_8859_1;
        bundle.putByteArray(str2, "FindPhoneMasterKey".getBytes(charset));
        bundle.putString(HwAssetManager.BUNDLE_CLOUD_SYNC_ACCOUNT_UID, str);
        HwAssetManager.AssetResult assetResultAssetWrap = f20011a.assetWrap(context, bundle);
        C13981a.m83989i("PhoneFinderAssetManager", "wrapRootKey result:" + assetResultAssetWrap.resultCode);
        return assetResultAssetWrap.resultCode == 0 ? ((String) assetResultAssetWrap.resultInfo.get(0)).getBytes(charset) : new byte[0];
    }
}
