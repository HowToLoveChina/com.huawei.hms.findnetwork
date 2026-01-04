package com.huawei.android.hicloud.security.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.request.basic.bean.PostOpDescReq;
import com.huawei.hicloud.request.userk.bean.PublicKeyResp;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hicloud.request.userk.bean.UserKeyResp;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.secure.android.common.util.SafeBase64;
import fk.C9720a;
import fk.C9721b;
import io.C10582a;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.crypto.NoSuchPaddingException;
import lk.C11304a;
import mk.C11476b;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p292fn.C9733f;
import p392jc.C10773a;
import p425kc.C11025a;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p525ok.C11908a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p709vj.C13452e;
import p713vo.C13475c;
import p713vo.InterfaceC13474b;
import p746wn.C13622a;

/* loaded from: classes3.dex */
public class UserKeyUtils {
    private static final String ALIAS = "security_alias";
    public static final int KEY_KEY_TYPE_E_FEK = 1;
    public static final int KEY_KEY_TYPE_SERVER_FEK = 4;
    public static final int KEY_KEY_TYPE_S_FEK = 3;
    public static final int KEY_KEY_TYPE_Z_FEK = 2;
    public static final int KEY_TYPE_BACKUP = 19;
    public static final int KEY_TYPE_CLOUD_ALBUM = 12;
    public static final int KEY_TYPE_DRIVE = 11;
    public static final int KEY_TYPE_PHONE_FINDER = 10;
    public static final int KEY_TYPE_SYNC = 0;
    private static final String SYNC_USER_PRE = "sync_user_data_";
    private static final String TAG = "UserKeyUtils";
    private static final String USER_KEY_GUID_SUFFIX = "_GUID";
    private String trustCircleKey;
    private String trustCircleKeySHA256;
    private static HashMap<String, UserKeyObject> syncUserMap = new HashMap<>();
    private static final Object SYNC_LOCK = new Object();
    private static final Object BACKUP_LOCK = new Object();
    private static final Object PHONE_FINDER_LOCK = new Object();
    private static final Object SHARE_LOCK = new Object();
    private static UserKeyUtils instance = new UserKeyUtils();
    private String currentUserId = null;
    private String currentUserIdSHA256 = null;
    private ReadWriteLock syncReadWriteLock = new ReentrantReadWriteLock();
    private ReadWriteLock backupReadWriteLock = new ReentrantReadWriteLock();
    private ReadWriteLock cloudAlbumReadWriteLock = new ReentrantReadWriteLock();
    String reportTraceId = C11058a.m66627b("07037");

    public static class BasicReportTask extends AbstractC12367d {
        private String errMsg;
        private String reportTraceId;

        public BasicReportTask(String str, String str2) {
            this.reportTraceId = str;
            this.errMsg = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C10582a c10582a = new C10582a(this.reportTraceId);
            PostOpDescReq postOpDescReq = new PostOpDescReq();
            postOpDescReq.setOpDesc(this.errMsg);
            postOpDescReq.setStored(false);
            postOpDescReq.setEventTime(System.currentTimeMillis());
            try {
                C11839m.m70688i(UserKeyUtils.TAG, "BasicReportTask result: " + c10582a.m64915P(postOpDescReq).getResult());
            } catch (Exception e10) {
                C11839m.m70687e(UserKeyUtils.TAG, "BasicReportTask error: " + e10.toString());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.QUERY_KEY;
        }
    }

    private boolean canGetKeyByRetryCountAndTime(String str, String str2, int i10, int i11) {
        String userKeyName = getUserKeyName(str, str2, i10, i11);
        Context context = getContext();
        if (context == null) {
            C11839m.m70687e(TAG, "context is null");
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("security_sp", 0);
        if (sharedPreferences == null) {
            C11839m.m70687e(TAG, "sp is null");
            return false;
        }
        int i12 = sharedPreferences.getInt(userKeyName + "_retry_count", 0);
        if (i12 <= 2) {
            C11839m.m70688i(TAG, "get key current retry count: " + i12);
            return true;
        }
        if (System.currentTimeMillis() - sharedPreferences.getLong(userKeyName + "_retry_time", 0L) < C5863b6.g.f26453g) {
            C11839m.m70689w(TAG, "get key no more than 1 hour");
            return false;
        }
        C11839m.m70688i(TAG, "get key more than 1 hour");
        clearRetryCountAndTime(userKeyName);
        return true;
    }

    private void clearRetryCountAndTime(String str) {
        Context context = getContext();
        if (context == null) {
            C11839m.m70687e(TAG, "context is null");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("security_sp", 0);
        if (sharedPreferences == null) {
            C11839m.m70687e(TAG, "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt(str + "_retry_count", 0);
        editorEdit.putLong(str + "_retry_time", 0L);
        editorEdit.commit();
    }

    private void clearUserKeyAndGuid(int i10, String str, int i11) {
        try {
            C11839m.m70688i(TAG, "clearUserKeyAndGuid: " + i10);
            String userIdSHA256 = getUserIdSHA256();
            String userKeyName = getUserKeyName(userIdSHA256, str, i10, i11);
            String userKeyGuidName = getUserKeyGuidName(userIdSHA256, str, i10, i11);
            syncUserMap.clear();
            this.currentUserId = null;
            this.currentUserIdSHA256 = null;
            SharedPreferences.Editor editorEdit = getContext().getSharedPreferences("security_sp", 0).edit();
            editorEdit.remove(userKeyName);
            editorEdit.remove(userKeyGuidName);
            editorEdit.remove(userKeyName + "_sha256");
            editorEdit.remove(userKeyName + "_retry_count");
            editorEdit.remove(userKeyName + "_retry_time");
            editorEdit.commit();
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "clearUserKeyAndGuid error: " + e10.getMessage());
        }
    }

    private Context getContext() {
        return C0213f.m1377a();
    }

    public static UserKeyUtils getInstance() {
        return instance;
    }

    private String getUserIdSHA256() throws C9721b {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C9720a.m60653b(strM80971t0, "current userId is null.");
        if (TextUtils.isEmpty(this.currentUserId) || !this.currentUserId.equals(strM80971t0) || TextUtils.isEmpty(this.currentUserIdSHA256)) {
            C11839m.m70688i(TAG, "getUserIdSHA256");
            this.currentUserId = strM80971t0;
            this.currentUserIdSHA256 = C11476b.m68626h(strM80971t0);
        }
        return this.currentUserIdSHA256;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.huawei.android.hicloud.security.service.UserKeyUtils] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.huawei.android.hicloud.security.bean.UserKeyObject] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    private UserKeyObject getUserKeyByTrustCircleOrOther(InterfaceC13474b interfaceC13474b, String str, int i10, int i11, boolean z10, String str2) throws C9721b {
        try {
            this = C0209d.m1277l1() ? new TrustCircleUserKey().requestTrustCircleSyncUserForHonorS(interfaceC13474b, i11, str, i10, z10) : new TrustCircleUserKey().requestTrustCircleSyncUser(interfaceC13474b, i11, str, i10, z10);
            return this;
        } catch (Throwable th2) {
            C11839m.m70689w(TAG, "requestTrustCircleSyncUser exception: " + th2.toString());
            return this.requestSyncUser(interfaceC13474b, i11, str, i10, z10, str2);
        }
    }

    private UserKeyObject getUserKeyFromMemory(String str) {
        C11839m.m70686d(TAG, "getUserKeyFromMemory:" + str);
        return syncUserMap.get(str);
    }

    private UserKeyObject getUserKeyFromMemoryOrSp(int i10, String str, String str2, String str3, int i11) {
        UserKeyObject userKeyFromMemory = null;
        try {
            try {
                if (i10 == 0) {
                    this.syncReadWriteLock.readLock().lock();
                } else if (i10 == 19) {
                    this.backupReadWriteLock.readLock().lock();
                } else if (i10 == 12) {
                    this.cloudAlbumReadWriteLock.readLock().lock();
                }
                userKeyFromMemory = getUserKeyFromMemory(str);
                if (userKeyFromMemory == null) {
                    userKeyFromMemory = getUserKeyFromSp(str, str2, str3, i10, i11);
                }
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "getUserKeyFromMemoryOrSp error:" + e10.getMessage());
                if (i10 != 0) {
                    if (i10 != 19) {
                        if (i10 == 12) {
                        }
                    }
                }
            }
            if (i10 == 0) {
                this.syncReadWriteLock.readLock().unlock();
            } else if (i10 == 19) {
                this.backupReadWriteLock.readLock().unlock();
            } else if (i10 == 12) {
                this.cloudAlbumReadWriteLock.readLock().unlock();
            }
            return userKeyFromMemory;
        } catch (Throwable th2) {
            if (i10 == 0) {
                this.syncReadWriteLock.readLock().unlock();
            } else if (i10 == 19) {
                this.backupReadWriteLock.readLock().unlock();
            } else if (i10 == 12) {
                this.cloudAlbumReadWriteLock.readLock().unlock();
            }
            throw th2;
        }
    }

    private UserKeyObject getUserKeyFromServer(InterfaceC13474b interfaceC13474b, String str, String str2, int i10, int i11, String str3) throws C9721b {
        UserKeyObject userKeyFromMemory = getUserKeyFromMemory(getUserKeyName(str, str2, i10, i11));
        if (userKeyFromMemory == null) {
            C11839m.m70688i(TAG, "getUserKeyFromServer, businessType: " + i10);
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null) {
                C11839m.m70687e(TAG, "hiCloudSysParamMap is null");
            } else {
                if (hiCloudSysParamMapM60757p.getIsReturnKeySHA256()) {
                    C11839m.m70688i(TAG, "config contain key SHA256");
                    while (canGetKeyByRetryCountAndTime(str, str2, i10, i11)) {
                        userKeyFromMemory = getUserKeyByTrustCircleOrOther(interfaceC13474b, str2, i11, i10, true, str);
                        if (userKeyFromMemory != null) {
                            C11839m.m70688i(TAG, "get user key success");
                            clearRetryCountAndTime(getUserKeyName(str, str2, i10, i11));
                        }
                    }
                    C11839m.m70687e(TAG, "retry 2 times, can't retry within 1 hour");
                    throw new C9721b(4001, "retry 2 times, can't retry within 1 hour");
                }
                saveSyncUser(str, i10, str2, i11, userKeyFromMemory);
            }
            C11839m.m70689w(TAG, "config not contain key SHA256");
            userKeyFromMemory = getUserKeyByTrustCircleOrOther(interfaceC13474b, str2, i11, i10, false, str);
            saveSyncUser(str, i10, str2, i11, userKeyFromMemory);
        }
        return userKeyFromMemory;
    }

    private UserKeyObject getUserKeyFromSp(String str, String str2, String str3, int i10, int i11) {
        byte[] bArrM66466a;
        C11839m.m70688i(TAG, "getUserKeyFromSp");
        Context context = getContext();
        if (context == null) {
            C11839m.m70687e(TAG, "context is null");
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("security_sp", 0);
        String string = sharedPreferences.getString(str, null);
        String string2 = sharedPreferences.getString(str2, null);
        if (TextUtils.isEmpty(string2)) {
            C11839m.m70688i(TAG, "getUserKeyFromSp keyGuid is null, need request userkey again.");
            return null;
        }
        if (string == null || (bArrM66466a = C11025a.m66466a(ALIAS, string)) == null) {
            return null;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70687e(TAG, "hiCloudSysParamMap is null");
        } else {
            if (hiCloudSysParamMapM60757p.getIsReturnKeySHA256()) {
                return getUserKeyFromSpCompareSHA256(bArrM66466a, str, string2, str3, i10, i11);
            }
            C11839m.m70689w(TAG, "config not contain return key SHA256");
        }
        UserKeyObject userKeyObject = new UserKeyObject();
        userKeyObject.setUserKey(bArrM66466a);
        userKeyObject.setUserKeyGuid(string2);
        syncUserMap.put(str, userKeyObject);
        return userKeyObject;
    }

    private UserKeyObject getUserKeyFromSpCompareSHA256(byte[] bArr, String str, String str2, String str3, int i10, int i11) {
        Context context = getContext();
        if (context == null) {
            C11839m.m70687e(TAG, "context is null");
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("security_sp", 0);
        if (sharedPreferences == null) {
            C11839m.m70687e(TAG, "sp is null");
            return null;
        }
        String string = sharedPreferences.getString(str + "_sha256", "");
        if (TextUtils.isEmpty(string)) {
            C11839m.m70689w(TAG, "sp key SHA256 is empty");
            report("sp key SHA256 is empty", str3, i10, i11);
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        String strM68632b = C11477c.m68632b(string, sb2);
        if (TextUtils.isEmpty(strM68632b)) {
            C11839m.m70687e(TAG, "keystore decrypt sp key SHA256 is empty");
            sb2.append(", error info: ");
            sb2.append("keystore decrypt sp key SHA256 is empty");
            report(sb2.toString(), str3, i10, i11);
            return null;
        }
        byte[] bArrM1594g = C0227m.m1594g(bArr);
        if (bArrM1594g == null || bArrM1594g.length == 0) {
            C11839m.m70687e(TAG, "sp key compute SHA256 error");
            report("sp key compute SHA256 error", str3, i10, i11);
            return null;
        }
        String strEncodeToString = SafeBase64.encodeToString(bArrM1594g, 2);
        if (TextUtils.isEmpty(strEncodeToString)) {
            C11839m.m70687e(TAG, "sp key base64 encode SHA256 error");
            report("sp key base64 encode SHA256 error", str3, i10, i11);
            return null;
        }
        if (!strM68632b.equals(strEncodeToString)) {
            C11839m.m70687e(TAG, "get sp key compare SHA256 fail");
            report("get sp key compare SHA256 fail", str3, i10, i11);
            return null;
        }
        C11839m.m70688i(TAG, "get sp key success");
        UserKeyObject userKeyObject = new UserKeyObject();
        userKeyObject.setUserKeySHA256(strM68632b);
        userKeyObject.setUserKey(bArr);
        userKeyObject.setUserKeyGuid(str2);
        syncUserMap.put(str, userKeyObject);
        return userKeyObject;
    }

    private String getUserKeyGuidName(String str, String str2, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append("_");
        stringBuffer.append(i11);
        stringBuffer.append(str2);
        stringBuffer.append(i10);
        stringBuffer.append(USER_KEY_GUID_SUFFIX);
        return stringBuffer.toString();
    }

    private String getUserKeyName(String str, String str2, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append("_");
        stringBuffer.append(str2);
        stringBuffer.append("_");
        stringBuffer.append(i10);
        stringBuffer.append("_");
        stringBuffer.append(i11);
        return stringBuffer.toString();
    }

    private UserKeyObject getUserKeySHA256(UserKeyResp userKeyResp, C11304a c11304a, byte[] bArr, String str, String str2, int i10, int i11) throws NoSuchPaddingException, C9721b, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String userKeyName = getUserKeyName(str, str2, i10, i11);
        String keySHA256 = userKeyResp.getKeySHA256();
        if (TextUtils.isEmpty(keySHA256)) {
            C11839m.m70687e(TAG, "server SHA256 is empty");
            report("server SHA256 is empty", str2, i10, i11);
            setRetryCountAndTime(userKeyName);
            return null;
        }
        byte[] bArrM67864b = c11304a.m67864b(SafeBase64.decode(keySHA256, 2));
        if (bArrM67864b == null || bArrM67864b.length == 0) {
            C11839m.m70687e(TAG, "decrypt server SHA256 is empty");
            report("decrypt server SHA256 is empty", str2, i10, i11);
            setRetryCountAndTime(userKeyName);
            return null;
        }
        String strEncodeToString = SafeBase64.encodeToString(bArrM67864b, 2);
        if (TextUtils.isEmpty(strEncodeToString)) {
            C11839m.m70687e(TAG, "base 64 encode server SHA256 error");
            report("base 64 encode server SHA256 error", str2, i10, i11);
            setRetryCountAndTime(userKeyName);
            return null;
        }
        byte[] bArrM1594g = C0227m.m1594g(bArr);
        if (bArrM1594g == null || bArrM1594g.length == 0) {
            C11839m.m70687e(TAG, "hash server key SHA256 error");
            report("hash server key SHA256 error", str2, i10, i11);
            setRetryCountAndTime(userKeyName);
            return null;
        }
        String strEncodeToString2 = SafeBase64.encodeToString(bArrM1594g, 2);
        if (TextUtils.isEmpty(strEncodeToString2)) {
            C11839m.m70687e(TAG, "base 64 encode server key SHA256 error");
            report("base 64 encode server key SHA256 error", str2, i10, i11);
            setRetryCountAndTime(userKeyName);
            return null;
        }
        if (!strEncodeToString2.equals(strEncodeToString)) {
            C11839m.m70687e(TAG, "compare server key SHA256 error");
            report("compare server key SHA256 error", str2, i10, i11);
            setRetryCountAndTime(userKeyName);
            return null;
        }
        C11839m.m70688i(TAG, "compare server key SHA256 ok");
        StringBuilder sb2 = new StringBuilder();
        String strM68635e = C11477c.m68635e(strEncodeToString2, sb2);
        if (TextUtils.isEmpty(strM68635e)) {
            C11839m.m70687e(TAG, "keystore encrypt server key SHA256 error");
            sb2.append(", error info: ");
            sb2.append("keystore encrypt server key SHA256 error");
            report(sb2.toString(), str2, i10, i11);
            setRetryCountAndTime(userKeyName);
            return null;
        }
        UserKeyObject userKeyObject = new UserKeyObject();
        userKeyObject.setUserKey(bArr);
        userKeyObject.setUserKeyGuid(userKeyResp.getGuid());
        userKeyObject.setUserKeySHA256(strM68635e);
        C11839m.m70688i(TAG, "get user key success, not by trust circle");
        report("get user key success, not by trust circle", str2, i10, i11);
        if (!TextUtils.isEmpty(this.trustCircleKey) && !this.trustCircleKey.equals(SafeBase64.encodeToString(bArr, 2))) {
            C11839m.m70687e(TAG, "trust circle key not equal");
            report("trust circle key not equal", str2, i10, i11);
        }
        if (!TextUtils.isEmpty(this.trustCircleKeySHA256) && !this.trustCircleKeySHA256.equals(strEncodeToString2)) {
            C11839m.m70687e(TAG, "trust circle key SHA256 not equal");
            report("trust circle key SHA256 not equal", str2, i10, i11);
        }
        this.trustCircleKey = "";
        this.trustCircleKeySHA256 = "";
        return userKeyObject;
    }

    private UserKeyObject requestSyncUser(InterfaceC13474b interfaceC13474b, int i10, String str, int i11, boolean z10, String str2) throws C9721b {
        UserKeyObject userKeyObject = new UserKeyObject();
        try {
            byte[] bArrM71443b = C11908a.m71443b(16);
            try {
                PublicKeyResp publicKeyRespMo684a = interfaceC13474b.mo684a();
                byte[] bArrDecode = SafeBase64.decode(publicKeyRespMo684a.getPublicKey(), 2);
                String version = publicKeyRespMo684a.getVersion();
                C10773a c10773a = new C10773a();
                KeyPair keyPairM65601a = c10773a.m65601a(bArrDecode);
                UserKeyResp userKeyRespMo686c = interfaceC13474b.mo686c(i10, str, i11, String.format(Locale.ENGLISH, "%s:%s", Base64.encodeToString(keyPairM65601a.getPublic().getEncoded(), 2), Base64.encodeToString(new C11304a(c10773a.m65602b(bArrDecode, keyPairM65601a.getPrivate())).m67865c(bArrM71443b), 2)), version);
                String userKey = userKeyRespMo686c.getUserKey();
                C11304a c11304a = new C11304a(bArrM71443b);
                byte[] bArrM67864b = c11304a.m67864b(SafeBase64.decode(userKey, 2));
                if (z10) {
                    return getUserKeySHA256(userKeyRespMo686c, c11304a, bArrM67864b, str2, str, i10, i11);
                }
                userKeyObject.setUserKey(bArrM67864b);
                userKeyObject.setUserKeyGuid(userKeyRespMo686c.getGuid());
                return userKeyObject;
            } catch (Exception e10) {
                throw new C9721b(4001, "Base64 decode Fail." + e10.toString());
            }
        } catch (NoSuchAlgorithmException e11) {
            throw new C9721b(4001, "generateTempKey Fail." + e11.toString());
        }
    }

    private void saveSyncUser(String str, int i10, String str2, int i11, UserKeyObject userKeyObject) {
        if (userKeyObject == null) {
            C11839m.m70687e(TAG, "userKeyObject is null");
            return;
        }
        byte[] userKey = userKeyObject.getUserKey();
        String userKeyName = getUserKeyName(str, str2, i10, i11);
        String userKeyGuidName = getUserKeyGuidName(str, str2, i10, i11);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("security_sp", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70687e(TAG, "hiCloudSysParamMap is null");
        } else if (hiCloudSysParamMapM60757p.getIsReturnKeySHA256()) {
            editorEdit.putString(userKeyName + "_sha256", userKeyObject.getUserKeySHA256());
            editorEdit.commit();
        } else {
            C11839m.m70689w(TAG, "config not contain return key SHA256");
        }
        editorEdit.putString(userKeyName, C11025a.m66467b(ALIAS, userKey));
        if (!TextUtils.isEmpty(sharedPreferences.getString(SYNC_USER_PRE + i11 + i10, null))) {
            editorEdit.remove(SYNC_USER_PRE + i11 + i10);
        }
        editorEdit.commit();
        if (!TextUtils.isEmpty(userKeyObject.getUserKeyGuid())) {
            editorEdit.putString(userKeyGuidName, userKeyObject.getUserKeyGuid());
            editorEdit.commit();
        }
        HashMap<String, UserKeyObject> map = syncUserMap;
        if (map != null) {
            map.put(userKeyName, userKeyObject);
        }
    }

    private void setRetryCountAndTime(String str) {
        Context context = getContext();
        if (context == null) {
            C11839m.m70687e(TAG, "context is null");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("security_sp", 0);
        if (sharedPreferences == null) {
            C11839m.m70687e(TAG, "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        int i10 = sharedPreferences.getInt(str + "_retry_count", 0) + 1;
        C11839m.m70688i(TAG, "setRetryCountAndTime: " + i10);
        editorEdit.putInt(str + "_retry_count", i10);
        if (i10 == 3) {
            editorEdit.putLong(str + "_retry_time", System.currentTimeMillis());
        }
        editorEdit.commit();
    }

    public void clearSyncUser() {
        C11839m.m70686d(TAG, "clearSyncUser");
        syncUserMap.clear();
        this.currentUserId = null;
        this.currentUserIdSHA256 = null;
        this.trustCircleKey = "";
        this.trustCircleKeySHA256 = "";
        getContext().getSharedPreferences("security_sp", 0).edit().clear().commit();
    }

    public void clearUserKeyByBusinessType(int i10) {
        if (i10 == 0) {
            this.syncReadWriteLock.writeLock().lock();
            try {
                clearUserKeyAndGuid(i10, UserKeyBaseReq.KEY_TYPE_AES_128, 1);
                return;
            } finally {
                this.syncReadWriteLock.writeLock().unlock();
            }
        }
        if (i10 == 19) {
            this.backupReadWriteLock.writeLock().lock();
            try {
                clearUserKeyAndGuid(i10, UserKeyBaseReq.KEY_TYPE_AES_128, 1);
                return;
            } finally {
                this.backupReadWriteLock.writeLock().unlock();
            }
        }
        if (i10 == 12) {
            this.cloudAlbumReadWriteLock.writeLock().lock();
            try {
                clearUserKeyAndGuid(i10, UserKeyBaseReq.KEY_TYPE_AES_128, 1);
                clearUserKeyAndGuid(i10, UserKeyBaseReq.KEY_TYPE_AES_256, 3);
            } finally {
                this.cloudAlbumReadWriteLock.writeLock().unlock();
            }
        }
    }

    public UserKeyObject getSyncUser(int i10, String str) throws C9721b {
        return getSyncUser(new C13475c(str), i10, str);
    }

    public String getTrustCircleKey() {
        return this.trustCircleKey;
    }

    public String getTrustCircleKeySHA256() {
        return this.trustCircleKeySHA256;
    }

    public void report(String str, String str2, int i10, int i11) {
        C11060c c11060cM66626a = C11058a.m66626a(this.reportTraceId, "requestSyncUser", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reportInfo", str);
        linkedHashMap.put("encType", str2);
        linkedHashMap.put("businessType", String.valueOf(i10));
        linkedHashMap.put("keyType", String.valueOf(i11));
        C13622a.m81969o(getContext(), c11060cM66626a, linkedHashMap);
        C12515a.m75110o().m75175e(new BasicReportTask(this.reportTraceId, str), false);
    }

    public void setTrustCircleKey(String str) {
        this.trustCircleKey = str;
    }

    public void setTrustCircleKeySHA256(String str) {
        this.trustCircleKeySHA256 = str;
    }

    public UserKeyObject getSyncUser(InterfaceC13474b interfaceC13474b, int i10, String str) throws C9721b {
        return getSyncUser(interfaceC13474b, i10, UserKeyBaseReq.KEY_TYPE_AES_128, 1, str);
    }

    public UserKeyObject getSyncUser(InterfaceC13474b interfaceC13474b, int i10, String str, int i11, String str2) throws C9721b {
        String userIdSHA256 = getUserIdSHA256();
        C9720a.m60653b(userIdSHA256, "current userIdSHA256 is null.");
        UserKeyObject userKeyFromMemoryOrSp = getUserKeyFromMemoryOrSp(i10, getUserKeyName(userIdSHA256, str, i10, i11), getUserKeyGuidName(userIdSHA256, str, i10, i11), str, i11);
        if (userKeyFromMemoryOrSp == null || userKeyFromMemoryOrSp.getUserKey() == null) {
            if (i10 == 19) {
                synchronized (BACKUP_LOCK) {
                    userKeyFromMemoryOrSp = getUserKeyFromServer(interfaceC13474b, userIdSHA256, str, i10, i11, str2);
                }
            } else if (i10 == 10) {
                synchronized (PHONE_FINDER_LOCK) {
                    userKeyFromMemoryOrSp = getUserKeyFromServer(interfaceC13474b, userIdSHA256, str, i10, i11, str2);
                }
            } else if (i10 == 12) {
                synchronized (SHARE_LOCK) {
                    userKeyFromMemoryOrSp = getUserKeyFromServer(interfaceC13474b, userIdSHA256, str, i10, i11, str2);
                }
            } else {
                synchronized (SYNC_LOCK) {
                    userKeyFromMemoryOrSp = getUserKeyFromServer(interfaceC13474b, userIdSHA256, str, i10, i11, str2);
                }
            }
        }
        return userKeyFromMemoryOrSp;
    }
}
