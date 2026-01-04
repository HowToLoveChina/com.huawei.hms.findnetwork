package com.huawei.android.hicloud.security.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.trustcircle.TrustCircleManager;
import com.hihonor.android.trustcircle.TrustCircleManager;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.request.userk.bean.UserKeyResp;
import com.huawei.secure.android.common.util.SafeBase64;
import fk.C9721b;
import hu.C10343b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0241z;
import p052cb.C1414k;
import p425kc.C11026b;
import p514o9.C11839m;
import p525ok.C11908a;
import p713vo.InterfaceC13474b;

/* loaded from: classes3.dex */
public class TrustCircleUserKey {
    private static final short DEFAULT_TA_VERSION = 1;
    private static final int KA_VERSION_NEW = 1;
    private static final String KEY_TA_VERSION = "TAVersion";
    private static final String KEY_TCISID = "tcisID";
    private static final String TAG = "TrustCircleUserKey";
    private static final String TRUSTCIRCLE_LOGIN_ACTION = "com.huawei.trustcircle.intent.action.TCIS_LOGIN";
    private static final String TRUSTCIRCLE_SEND_PERMISSION = "com.huawei.permission.TRUST_CIRCLE_BROADCAST_SEND";

    public static class TrustCircleManagerCallback implements TrustCircleManager.KaCallback {
        private final int kaVersion;
        private final UserKeyObject key;
        private final CountDownLatch keyAgreementLatch;
        private final byte[] randomByte;
        private final int type;

        public TrustCircleManagerCallback(byte[] bArr, UserKeyObject userKeyObject, CountDownLatch countDownLatch, int i10, int i11) {
            this.randomByte = bArr != null ? (byte[]) bArr.clone() : new byte[0];
            this.key = userKeyObject;
            this.keyAgreementLatch = countDownLatch;
            this.type = i10;
            this.kaVersion = i11;
        }

        public void onKaError(long j10, int i10) {
            C11839m.m70687e(TrustCircleUserKey.TAG, "errorCode = " + i10);
            CountDownLatch countDownLatch = this.keyAgreementLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        public void onKaResult(long j10, int i10, byte[] bArr, byte[] bArr2) {
            CountDownLatch countDownLatch;
            try {
                try {
                    if (this.key != null) {
                        C11839m.m70688i(TrustCircleUserKey.TAG, "onKaResult kaVersion: " + this.kaVersion + " type: " + this.type);
                        if (this.kaVersion == 1) {
                            int i11 = this.type;
                            if (i11 == 1) {
                                this.key.setUserKey(bArr2);
                            } else if (i11 == 2) {
                                this.key.setUserKeySHA256(SafeBase64.encodeToString(bArr2, 2));
                            }
                        } else {
                            byte[] bArrM66470a = C11026b.m66470a(bArr2, this.randomByte, bArr);
                            int i12 = this.type;
                            if (i12 == 1) {
                                this.key.setUserKey(bArrM66470a);
                            } else if (i12 == 2) {
                                this.key.setUserKeySHA256(SafeBase64.encodeToString(bArrM66470a, 2));
                            }
                        }
                    }
                    countDownLatch = this.keyAgreementLatch;
                    if (countDownLatch == null) {
                        return;
                    }
                } catch (Exception unused) {
                    C11839m.m70687e(TrustCircleUserKey.TAG, "requestTrustCircleSyncUser Exception");
                    countDownLatch = this.keyAgreementLatch;
                    if (countDownLatch == null) {
                        return;
                    }
                }
                countDownLatch.countDown();
            } catch (Throwable th2) {
                CountDownLatch countDownLatch2 = this.keyAgreementLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                throw th2;
            }
        }
    }

    public static class TrustCircleManagerCallbackForHonorS implements TrustCircleManager.KaCallback {
        private final UserKeyObject key;
        private final CountDownLatch keyAgreementLatch;
        private final byte[] randomByte;
        private final int type;

        public TrustCircleManagerCallbackForHonorS(byte[] bArr, UserKeyObject userKeyObject, CountDownLatch countDownLatch, int i10) {
            this.randomByte = bArr != null ? (byte[]) bArr.clone() : new byte[0];
            this.key = userKeyObject;
            this.keyAgreementLatch = countDownLatch;
            this.type = i10;
        }

        public void onKaError(long j10, int i10) {
            C11839m.m70687e(TrustCircleUserKey.TAG, "errorCode = " + i10);
            CountDownLatch countDownLatch = this.keyAgreementLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        public void onKaResult(long j10, int i10, byte[] bArr, byte[] bArr2) {
            CountDownLatch countDownLatch;
            try {
                try {
                    byte[] bArrM66470a = C11026b.m66470a(bArr2, this.randomByte, bArr);
                    UserKeyObject userKeyObject = this.key;
                    if (userKeyObject != null) {
                        int i11 = this.type;
                        if (i11 == 1) {
                            userKeyObject.setUserKey(bArrM66470a);
                        } else if (i11 == 2) {
                            userKeyObject.setUserKeySHA256(SafeBase64.encodeToString(bArrM66470a, 2));
                        }
                    }
                    countDownLatch = this.keyAgreementLatch;
                    if (countDownLatch == null) {
                        return;
                    }
                } catch (Exception unused) {
                    C11839m.m70687e(TrustCircleUserKey.TAG, "requestTrustCircleSyncUser Exception");
                    countDownLatch = this.keyAgreementLatch;
                    if (countDownLatch == null) {
                        return;
                    }
                }
                countDownLatch.countDown();
            } catch (Throwable th2) {
                CountDownLatch countDownLatch2 = this.keyAgreementLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                throw th2;
            }
        }
    }

    public static class TrustcircleBroadcastReceiver extends BroadcastReceiver {
        private final CountDownLatch loginLatch;

        public TrustcircleBroadcastReceiver(CountDownLatch countDownLatch) {
            this.loginLatch = countDownLatch;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TrustCircleUserKey.TRUSTCIRCLE_LOGIN_ACTION.equalsIgnoreCase(new HiCloudSafeIntent(intent).getAction())) {
                C11839m.m70688i(TrustCircleUserKey.TAG, "Receive trustcircle login broadcast");
                CountDownLatch countDownLatch = this.loginLatch;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }
    }

    public static final class Type {
        public static final int KEY = 1;
        public static final int SHA256 = 2;

        private Type() {
        }
    }

    private static String bytes2Hex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append("0");
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    private void decryptTrustUserKey(android.trustcircle.TrustCircleManager trustCircleManager, UserKeyResp userKeyResp, UserKeyObject userKeyObject, long j10, int i10, String str, int i11, boolean z10) throws Exception {
        byte[] bArrM66472c;
        String[] strArrSplit = userKeyResp.getUserKey().split(":");
        int iM1685c = C0241z.m1685c(strArrSplit[0]);
        String str2 = strArrSplit[1];
        String keySHA256 = userKeyResp.getKeySHA256();
        if (z10) {
            if (TextUtils.isEmpty(keySHA256)) {
                C11839m.m70687e(TAG, "responseKeySHA256 is empty");
                UserKeyUtils.getInstance().report("responseKeySHA256 is empty", str, i10, i11);
                throw new C9721b(4001, "responseKeySHA256 is empty");
            }
            if (keySHA256.length() < 2) {
                C11839m.m70687e(TAG, "splitResponseKeySHA256 length not ok");
                UserKeyUtils.getInstance().report("splitResponseKeySHA256 length not ok", str, i10, i11);
                throw new C9721b(4001, "splitResponseKeySHA256 length not ok");
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        byte[] bArr = new byte[256];
        boolean zM1257g1 = C0209d.m1257g1();
        byte[] bArrM71443b = null;
        if (z10) {
            countDownLatch = new CountDownLatch(2);
            String[] strArrSplit2 = keySHA256.split(":");
            int iM1685c2 = C0241z.m1685c(strArrSplit2[0]);
            String str3 = strArrSplit2[1];
            if (iM1685c2 == 1 || zM1257g1) {
                trustCircleManager.initKeyAgreement(new TrustCircleManagerCallback(null, userKeyObject, countDownLatch, 2, 1), 1, j10, bArr, str3);
                bArrM66472c = null;
            } else {
                bArrM71443b = C11908a.m71443b(16);
                bArrM66472c = C11026b.m66472c(bArrM71443b);
                trustCircleManager.initKeyAgreement(new TrustCircleManagerCallback(bArrM71443b, userKeyObject, countDownLatch, 2, iM1685c2), iM1685c2, j10, bArrM66472c, str3);
            }
        } else {
            bArrM66472c = null;
        }
        if (iM1685c == 1 || zM1257g1) {
            trustCircleManager.initKeyAgreement(new TrustCircleManagerCallback(null, userKeyObject, countDownLatch, 1, 1), 1, j10, bArr, str2);
        } else {
            byte[] bArrM71443b2 = bArrM71443b == null ? C11908a.m71443b(16) : bArrM71443b;
            trustCircleManager.initKeyAgreement(new TrustCircleManagerCallback(bArrM71443b2, userKeyObject, countDownLatch, 1, iM1685c), iM1685c, j10, bArrM66472c == null ? C11026b.m66472c(bArrM71443b2) : bArrM66472c, str2);
        }
        try {
            if (countDownLatch.await(5L, TimeUnit.SECONDS)) {
                return;
            }
            C11839m.m70689w(TAG, "requestTrustCircleSyncUser await failed");
        } catch (InterruptedException unused) {
            C11839m.m70687e(TAG, "initKeyAgreement InterruptedException");
        }
    }

    private static String getApkSignatureHash(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hidisk", 64);
            if (packageInfo == null) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder(packageInfo.packageName);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null) {
                for (Signature signature : signatureArr) {
                    sb2.append(":");
                    sb2.append(bytes2Hex(signature.toByteArray()));
                }
            }
            return getSHA256(sb2.toString().toLowerCase(Locale.US));
        } catch (Exception unused) {
            C11839m.m70687e(TAG, "getApkSignatureHash Exception");
            return "";
        }
    }

    private Context getContext() {
        return C0213f.m1377a();
    }

    private Bundle getDataFromTrustCircle(android.trustcircle.TrustCircleManager trustCircleManager) throws Exception {
        Bundle tcisInfo = trustCircleManager.getTcisInfo();
        if (tcisInfo == null) {
            throw new C1414k("getTcisInfo bundle is null");
        }
        if (TextUtils.isEmpty(new C10343b(tcisInfo).m63694p("hwUserId"))) {
            waitForTrustCircleLogin();
        }
        Bundle tcisInfo2 = trustCircleManager.getTcisInfo();
        if (tcisInfo2 == null) {
            throw new C1414k("getTcisInfo bundle is null");
        }
        if (TextUtils.isEmpty(new C10343b(tcisInfo2).m63694p("hwUserId"))) {
            throw new C1414k("hwUserId is null, use old interface");
        }
        return tcisInfo2;
    }

    private Bundle getDataFromTrustCircleForHonorS(com.hihonor.android.trustcircle.TrustCircleManager trustCircleManager) throws Exception {
        Bundle tcisInfo = trustCircleManager.getTcisInfo();
        if (tcisInfo == null) {
            throw new C1414k("getTcisInfo bundle is null");
        }
        if (TextUtils.isEmpty(new C10343b(tcisInfo).m63694p("hwUserId"))) {
            waitForTrustCircleLogin();
        }
        Bundle tcisInfo2 = trustCircleManager.getTcisInfo();
        if (tcisInfo2 == null) {
            throw new C1414k("getTcisInfo bundle is null");
        }
        if (TextUtils.isEmpty(new C10343b(tcisInfo2).m63694p("hwUserId"))) {
            throw new C1414k("hwUserId is null, use old interface");
        }
        return tcisInfo2;
    }

    private UserKeyObject getKeySHA256(UserKeyObject userKeyObject, String str, int i10, int i11) throws C9721b {
        String userKeySHA256 = userKeyObject.getUserKeySHA256();
        if (TextUtils.isEmpty(userKeySHA256)) {
            C11839m.m70687e(TAG, "decrypt trust circle SHA256 is empty");
            UserKeyUtils.getInstance().report("decrypt trust circle SHA256 is empty", str, i10, i11);
            throw new C9721b(4001, "decrypt trust circle SHA256 is empty");
        }
        UserKeyUtils.getInstance().setTrustCircleKeySHA256(userKeySHA256);
        byte[] userKey = userKeyObject.getUserKey();
        if (userKey == null || userKey.length == 0) {
            C11839m.m70687e(TAG, "decrypt trust circle key is empty");
            UserKeyUtils.getInstance().report("decrypt trust circle key is empty", str, i10, i11);
            throw new C9721b(4001, "decrypt trust circle key is empty");
        }
        UserKeyUtils.getInstance().setTrustCircleKey(SafeBase64.encodeToString(userKey, 2));
        byte[] bArrM1594g = C0227m.m1594g(userKey);
        if (bArrM1594g == null || bArrM1594g.length == 0) {
            C11839m.m70687e(TAG, "hash trust circle key SHA256 error");
            UserKeyUtils.getInstance().report("hash trust circle key SHA256 error", str, i10, i11);
            throw new C9721b(4001, "hash trust circle key SHA256 error");
        }
        String strEncodeToString = SafeBase64.encodeToString(bArrM1594g, 2);
        if (TextUtils.isEmpty(strEncodeToString)) {
            C11839m.m70687e(TAG, "base 64 encode trust circle key SHA256 error");
            UserKeyUtils.getInstance().report("base 64 encode trust circle key SHA256 error", str, i10, i11);
            throw new C9721b(4001, "base 64 encode trust circle key SHA256 error");
        }
        if (!strEncodeToString.equals(userKeySHA256)) {
            C11839m.m70687e(TAG, "compare trust circle key SHA256 error");
            UserKeyUtils.getInstance().report("compare trust circle key SHA256 error", str, i10, i11);
            throw new C9721b(4001, "compare trust circle key SHA256 error");
        }
        C11839m.m70688i(TAG, "compare trust circle key SHA256 ok");
        StringBuilder sb2 = new StringBuilder();
        String strM68635e = C11477c.m68635e(strEncodeToString, sb2);
        if (!TextUtils.isEmpty(strM68635e)) {
            userKeyObject.setUserKeySHA256(strM68635e);
            C11839m.m70688i(TAG, "get user key success, by trust circle");
            UserKeyUtils.getInstance().report("get user key success, by trust circle", str, i10, i11);
            return userKeyObject;
        }
        C11839m.m70687e(TAG, "keystore encrypt trust circle key SHA256 error");
        sb2.append(", error info: ");
        sb2.append("keystore encrypt trust circle key SHA256 error");
        UserKeyUtils.getInstance().report(sb2.toString(), str, i10, i11);
        throw new C9721b(4001, "keystore encrypt trust circle key SHA256 error");
    }

    private static String getSHA256(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return bytes2Hex(MessageDigest.getInstance("SHA256").digest(str.getBytes("utf-8")));
            } catch (UnsupportedEncodingException unused) {
                C11839m.m70687e(TAG, "Unsupported utf-8 Encoding.");
            } catch (GeneralSecurityException unused2) {
                C11839m.m70687e(TAG, "messageDigest GeneralSecurityException.");
            }
        }
        return "";
    }

    private boolean isTrustCircleExist() throws PackageManager.NameNotFoundException {
        try {
            getContext().getPackageManager().getPackageInfo("com.huawei.trustcircle", 1);
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return false;
        }
    }

    private void waitForTrustCircleLogin() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        TrustcircleBroadcastReceiver trustcircleBroadcastReceiver = new TrustcircleBroadcastReceiver(countDownLatch);
        getContext().registerReceiver(trustcircleBroadcastReceiver, new IntentFilter(TRUSTCIRCLE_LOGIN_ACTION), TRUSTCIRCLE_SEND_PERMISSION, null);
        try {
            if (!countDownLatch.await(4L, TimeUnit.SECONDS)) {
                C11839m.m70689w(TAG, "waitForTrustCircleLogin await failed");
            }
        } catch (InterruptedException unused) {
            C11839m.m70687e(TAG, "waitForTrustCircleLogin InterruptedException");
        }
        getContext().unregisterReceiver(trustcircleBroadcastReceiver);
    }

    public UserKeyObject requestTrustCircleSyncUser(InterfaceC13474b interfaceC13474b, int i10, String str, int i11, boolean z10) throws Exception {
        if (!isTrustCircleExist()) {
            throw new C1414k("TrustCircle doesn't exist, use old interface");
        }
        UserKeyObject userKeyObject = new UserKeyObject();
        android.trustcircle.TrustCircleManager trustCircleManager = android.trustcircle.TrustCircleManager.getInstance();
        Bundle dataFromTrustCircle = getDataFromTrustCircle(trustCircleManager);
        String string = dataFromTrustCircle.getString(KEY_TCISID);
        short s10 = dataFromTrustCircle.getShort(KEY_TA_VERSION, (short) -1);
        long jM1688f = C0241z.m1688f(dataFromTrustCircle.getString("hwUserId"));
        if (TextUtils.isEmpty(string) || s10 < 1) {
            throw new C1414k("tcisID is empty or TA not support, use old interface");
        }
        UserKeyResp userKeyRespMo685b = interfaceC13474b.mo685b(i10, str, i11, string, s10, getApkSignatureHash(getContext()));
        userKeyObject.setUserKeyGuid(userKeyRespMo685b.getGuid());
        decryptTrustUserKey(trustCircleManager, userKeyRespMo685b, userKeyObject, jM1688f, i10, str, i11, z10);
        if (userKeyObject.getUserKey() == null) {
            throw new C1414k("requestTrustCircleSyncUser failed, use old interface");
        }
        C11839m.m70688i(TAG, "requestTrustCircleSyncUser succeed");
        return z10 ? getKeySHA256(userKeyObject, str, i10, i11) : userKeyObject;
    }

    public UserKeyObject requestTrustCircleSyncUserForHonorS(InterfaceC13474b interfaceC13474b, int i10, String str, int i11, boolean z10) throws Exception {
        String str2;
        byte[] bArr;
        CountDownLatch countDownLatch;
        if (!isTrustCircleExist()) {
            throw new C1414k("TrustCircle doesn't exist, use old interface");
        }
        UserKeyObject userKeyObject = new UserKeyObject();
        com.hihonor.android.trustcircle.TrustCircleManager trustCircleManager = com.hihonor.android.trustcircle.TrustCircleManager.getInstance();
        Bundle dataFromTrustCircleForHonorS = getDataFromTrustCircleForHonorS(trustCircleManager);
        String string = dataFromTrustCircleForHonorS.getString(KEY_TCISID);
        short s10 = dataFromTrustCircleForHonorS.getShort(KEY_TA_VERSION, (short) -1);
        long jM1688f = C0241z.m1688f(dataFromTrustCircleForHonorS.getString("hwUserId"));
        if (TextUtils.isEmpty(string) || s10 < 1) {
            throw new C1414k("tcisID is empty or TA not support, use old interface");
        }
        UserKeyResp userKeyRespMo685b = interfaceC13474b.mo685b(i10, str, i11, string, s10, getApkSignatureHash(getContext()));
        userKeyObject.setUserKeyGuid(userKeyRespMo685b.getGuid());
        String[] strArrSplit = userKeyRespMo685b.getUserKey().split(":");
        int iM1685c = C0241z.m1685c(strArrSplit[0]);
        String str3 = strArrSplit[1];
        byte[] bArrM71443b = C11908a.m71443b(16);
        byte[] bArrM66472c = C11026b.m66472c(bArrM71443b);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        if (z10) {
            String keySHA256 = userKeyRespMo685b.getKeySHA256();
            if (TextUtils.isEmpty(keySHA256)) {
                C11839m.m70687e(TAG, "responseKeySHA256 is empty");
                UserKeyUtils.getInstance().report("responseKeySHA256 is empty", str, i10, i11);
                throw new C9721b(4001, "responseKeySHA256 is empty");
            }
            String[] strArrSplit2 = keySHA256.split(":");
            if (keySHA256.length() < 2) {
                C11839m.m70687e(TAG, "splitResponseKeySHA256 length not ok");
                UserKeyUtils.getInstance().report("splitResponseKeySHA256 length not ok", str, i10, i11);
                throw new C9721b(4001, "splitResponseKeySHA256 length not ok");
            }
            int iM1685c2 = C0241z.m1685c(strArrSplit2[0]);
            String str4 = strArrSplit2[1];
            CountDownLatch countDownLatch3 = new CountDownLatch(2);
            TrustCircleManagerCallbackForHonorS trustCircleManagerCallbackForHonorS = new TrustCircleManagerCallbackForHonorS(bArrM71443b, userKeyObject, countDownLatch3, 2);
            str2 = TAG;
            bArr = bArrM71443b;
            trustCircleManager.initKeyAgreement(trustCircleManagerCallbackForHonorS, iM1685c2, jM1688f, bArrM66472c, str4);
            countDownLatch = countDownLatch3;
        } else {
            str2 = TAG;
            bArr = bArrM71443b;
            countDownLatch = countDownLatch2;
        }
        TrustCircleManagerCallbackForHonorS trustCircleManagerCallbackForHonorS2 = new TrustCircleManagerCallbackForHonorS(bArr, userKeyObject, countDownLatch, 1);
        CountDownLatch countDownLatch4 = countDownLatch;
        trustCircleManager.initKeyAgreement(trustCircleManagerCallbackForHonorS2, iM1685c, jM1688f, bArrM66472c, str3);
        try {
            if (!countDownLatch4.await(5L, TimeUnit.SECONDS)) {
                C11839m.m70689w(str2, "requestTrustCircleSyncUser await failed");
            }
        } catch (InterruptedException unused) {
            C11839m.m70687e(str2, "initKeyAgreement InterruptedException");
        }
        if (userKeyObject.getUserKey() == null) {
            throw new C1414k("requestTrustCircleSyncUser failed, use old interface");
        }
        C11839m.m70688i(str2, "requestTrustCircleSyncUser succeed");
        return z10 ? getKeySHA256(userKeyObject, str, i10, i11) : userKeyObject;
    }
}
