package com.huawei.android.backup.service.logic;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.model.BackupFileModuleInfo;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.backup.service.utils.InfoXmlUtils;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p006a5.AbstractC0048c;
import p248e5.C9408a;
import p248e5.C9409b;
import p279f6.C9658a;
import p279f6.C9659b;
import p279f6.C9662e;
import p386j6.C10713c;
import p444l5.C11238f;
import p699v4.C13333b;
import p699v4.C13334c;
import p699v4.C13348q;
import p763x5.C13703a;

/* loaded from: classes.dex */
public abstract class BackupObject extends C2126b {
    protected static final int CREATE_SECURITY_INFO_APK_DATA_FAIL = 10004;
    protected static final int CREATE_SECURITY_INFO_CHECK_MSG_NULL = 10002;
    protected static final int CREATE_SECURITY_INFO_DEFAULT_FAIL = 10005;
    protected static final int CREATE_SECURITY_INFO_ENC_FAIL = 10003;
    protected static final int CREATE_SECURITY_INFO_PARAM_NULL = 10001;
    protected static final int CREATE_SECURITY_INFO_SUCCESS = 10000;
    public static final int FLAG_BACKUP = 1;
    public static final int FLAG_RESTORE = 2;
    private static final int INVALID_NUM = -1;
    private static final long ITEM_SIZE = 1000;
    public static final int MODULE_TYPE_APP_OR_OLD_ITEM = 0;
    protected static final int MODULE_TYPE_SYSTEM_DATA_ITEM = 1;
    protected static final int SLEEP_TIME = 100;
    private static final String TAG = "BackupObject";
    protected BackupFileModuleInfo backupFileModuleInfo;
    protected Bundle backupFilesBundle;
    protected ArrayList<C11238f> contactModuleInfoList;
    protected static final Bundle APP_EXTRA_PARAMETER = new Bundle();
    private static final Bundle EXECUTE_PARAMETER = new Bundle();
    private static final Object EXECUTE_PARAMETER_LOCK = new Object();
    private static final ArrayList<String> MEDIA_MODULE_LIST = new ArrayList<>(Arrays.asList("audio", "doc", "photo", Constants.VIDEO_SUB_DIR, "otherFile", "audio_sd", "doc_sd", "photo_sd", "video_sd", "otherFile_sd", "wechat_record"));
    private static final ArrayList<String> SD_MEDIA_MODULE_LIST = new ArrayList<>(Arrays.asList("audio_sd", "doc_sd", "photo_sd", "video_sd", "otherFile_sd"));
    private static ThreadLocal<List<String>> followingModulesThreadLocal = new ThreadLocal<List<String>>() { // from class: com.huawei.android.backup.service.logic.BackupObject.1
        @Override // java.lang.ThreadLocal
        public List<String> initialValue() {
            return Collections.emptyList();
        }
    };
    private static volatile boolean isAbortDoing = false;
    private static boolean isRestoreWifiComplete = false;
    private static volatile int lastBackupSession = -1;
    private static volatile int lastRestoreSession = -1;
    protected int subKeyTotalNum = 0;
    protected int subKeyCurCount = 0;
    protected final Handler.Callback backupObjectCallback = new Handler.Callback() { // from class: com.huawei.android.backup.service.logic.BackupObject.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return BackupObject.this.handleCallbackMessage(message);
        }
    };
    protected ArrayList<String> backupFliedList = new ArrayList<>();
    protected HashMap<String, HashMap<String, String>> moduleInfo = new HashMap<>();

    public class SubKeyInfo {
        protected String backTable;
        protected ContentValues[] backupValues;
        protected HashMap<String, Integer> fields;
        protected String[] projections;
        protected ContentValues[] restoreValues;
        protected String selection;
        protected String[] selectionArgs;
        protected String sortOrder;
        protected String table;
        protected Uri uri;
        protected boolean isInitSuccess = false;

        /* renamed from: a */
        public boolean f9570a = false;

        public SubKeyInfo(Uri uri, String str, HashMap<String, Integer> map, String str2) {
            this.uri = uri;
            this.table = str2;
            this.backTable = str;
            this.fields = map;
        }

        /* renamed from: a */
        public String[] m12702a(String[] strArr, HashMap<String, Integer> map) {
            ArrayList arrayList = new ArrayList();
            if (strArr == null || map == null) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            for (String str : strArr) {
                if (map.containsKey(str)) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }

        /* renamed from: b */
        public final void m12703b(Handler.Callback callback, Object obj, String str) {
            if (this.f9570a) {
                return;
            }
            this.f9570a = true;
            BackupObject.this.sendMsg(100, C2111d.m12652h(BackupObject.TAG, this.uri.toString(), "doEachBackup", str), callback, obj);
        }

        /* renamed from: c */
        public final void m12704c(Handler.Callback callback, Object obj, String str) {
            if (this.f9570a) {
                return;
            }
            this.f9570a = true;
            BackupObject.this.sendMsg(101, C2111d.m12652h(BackupObject.TAG, this.table, "doEachRestore", str), callback, obj);
        }

        /* renamed from: d */
        public final void m12705d(Handler.Callback callback, Object obj, ContentProviderClient contentProviderClient, ContentValues contentValues) {
            if (C13333b.m79953a(contentProviderClient, this.uri, contentValues)) {
                notifyRestoreOneSuccess(callback, obj);
            } else {
                m12704c(callback, obj, "storeHandler.insert fail");
                notifyRestoreOneFail(callback, obj);
            }
        }

        public int doEachBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
            if (context == null || abstractC0048c == null || this.backupValues == null) {
                return 0;
            }
            this.f9570a = false;
            abstractC0048c.mo169a();
            int i10 = 0;
            for (ContentValues contentValues : this.backupValues) {
                if (BackupObject.isAbort()) {
                    break;
                }
                BackupObject.this.subKeyCurCount++;
                try {
                    if (abstractC0048c.m185A(this.backTable, contentValues) == 1) {
                        notifyBackupOneSuccess(callback, obj);
                        i10++;
                    } else {
                        m12703b(callback, obj, "storeHandler.write fail");
                        notifyBackupOneFail(callback, obj);
                    }
                } catch (SQLException e10) {
                    String str = "write events values SQLException. error: " + e10.getMessage();
                    C2111d.m12648d(BackupObject.TAG, str);
                    m12703b(callback, obj, str);
                    notifyBackupOneFail(callback, obj);
                    BackupObject.this.attachUriInfo(String.valueOf(this.uri), C2126b.MODULE_INFO_ERROR_INFO, str);
                } catch (Exception e11) {
                    String str2 = "write events values failed. error: " + e11.getMessage();
                    C2111d.m12648d(BackupObject.TAG, str2);
                    m12703b(callback, obj, str2);
                    notifyBackupOneFail(callback, obj);
                    BackupObject.this.attachUriInfo(String.valueOf(this.uri), C2126b.MODULE_INFO_ERROR_INFO, str2);
                }
            }
            abstractC0048c.mo171c();
            return i10;
        }

        public void doEachDelete(Context context) {
            if (this.restoreValues == null) {
                C2111d.m12648d(BackupObject.TAG, "Delete error. because values is null.");
                return;
            }
            if (context == null) {
                C2111d.m12648d(BackupObject.TAG, "Delete error. because context is null.");
                return;
            }
            try {
                context.getContentResolver().delete(this.uri, this.selection, null);
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d(BackupObject.TAG, "Delete Failed, IllegalArgumentException");
            } catch (Exception unused2) {
                C2111d.m12648d(BackupObject.TAG, "Delete Failed");
            }
        }

        public void doEachRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
            if (context == null) {
                return;
            }
            this.f9570a = false;
            if (this.restoreValues == null) {
                C2111d.m12648d(BackupObject.TAG, "restore error. because values is null.");
                BackupObject.this.sendMsg(101, C2111d.m12652h(BackupObject.TAG, this.table, "doEachRestore", "restoreValues is null"), callback, obj);
                return;
            }
            ContentProviderClient contentProviderClientM12617c = C2108a.m12617c(context, this.uri);
            try {
                for (ContentValues contentValues : this.restoreValues) {
                    if (BackupObject.isAbort()) {
                        break;
                    }
                    BackupObject.this.subKeyCurCount++;
                    m12705d(callback, obj, contentProviderClientM12617c, contentValues);
                }
                if (contentProviderClientM12617c != null) {
                    contentProviderClientM12617c.close();
                }
                BackupObject.this.attachUriInfo(String.valueOf(this.uri), "count", String.valueOf(BackupObject.this.subKeyCurCount));
            } catch (Throwable th2) {
                if (contentProviderClientM12617c != null) {
                    try {
                        contentProviderClientM12617c.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        /* renamed from: e */
        public String[] m12706e(String[] strArr, AbstractC0048c abstractC0048c, HashMap<String, Integer> map, String str) {
            if (strArr == null || map == null) {
                C2111d.m12648d(BackupObject.TAG, "restoreProjection : colFields or fields is null");
                return new String[0];
            }
            ArrayList arrayList = new ArrayList();
            Set<String> setMo202u = abstractC0048c != null ? abstractC0048c.mo202u(str) : null;
            if (!C13348q.m80082b(setMo202u)) {
                for (String str2 : strArr) {
                    if (map.containsKey(str2) && setMo202u.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }

        public int getBackupCount(Context context) {
            if (!this.isInitSuccess || context == null) {
                return 0;
            }
            C9662e c9662e = new C9662e(this.uri, this.projections, this.selection, this.selectionArgs, this.sortOrder);
            c9662e.m60337g(this.fields);
            ContentValues[] backupValues = BackupObject.getBackupValues(context, c9662e);
            this.backupValues = backupValues;
            return backupValues.length;
        }

        public int getEachModuleNumber(Context context) {
            if (context == null) {
                return 0;
            }
            Cursor cursorM12618d = null;
            try {
                try {
                    cursorM12618d = C2108a.m12618d(context, this.uri, new String[]{"_id"}, this.selection, this.selectionArgs, null);
                    if (cursorM12618d != null) {
                        int count = cursorM12618d.getCount();
                        cursorM12618d.close();
                        return count;
                    }
                    if (cursorM12618d != null) {
                        cursorM12618d.close();
                    }
                    return -1;
                } catch (SQLException unused) {
                    C2111d.m12648d(BackupObject.TAG, "Get backup numbers SQLException");
                    if (cursorM12618d != null) {
                        cursorM12618d.close();
                    }
                    return -1;
                } catch (Exception unused2) {
                    C2111d.m12648d(BackupObject.TAG, "Get backup numbers failed");
                    if (cursorM12618d != null) {
                        cursorM12618d.close();
                    }
                    return -1;
                }
            } catch (Throwable th2) {
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                throw th2;
            }
        }

        public int getRestoreCount(AbstractC0048c abstractC0048c) {
            if (abstractC0048c != null && this.isInitSuccess) {
                ContentValues[] contentValuesArrM200s = abstractC0048c.m200s(this.backTable, this.projections, this.selection, this.selectionArgs, null);
                this.restoreValues = contentValuesArrM200s;
                if (contentValuesArrM200s != null) {
                    return contentValuesArrM200s.length;
                }
            }
            return 0;
        }

        public String getTable() {
            return this.table;
        }

        public Uri getUri() {
            return this.uri;
        }

        public boolean initEach(Context context, int i10, AbstractC0048c abstractC0048c) {
            String[] strArrM12706e;
            if (context == null) {
                return false;
            }
            String[] strArrM13202j = C2157a.m13202j(context, this.uri);
            if (strArrM13202j.length < 1) {
                return false;
            }
            if (i10 == 1) {
                strArrM12706e = m12702a(strArrM13202j, this.fields);
            } else if (i10 != 2 || abstractC0048c == null) {
                C2111d.m12657m(BackupObject.TAG, "init each error");
                strArrM12706e = null;
            } else {
                strArrM12706e = m12706e(strArrM13202j, abstractC0048c, this.fields, this.backTable);
            }
            this.projections = strArrM12706e;
            if (strArrM12706e != null) {
                this.isInitSuccess = true;
                return true;
            }
            this.isInitSuccess = false;
            return false;
        }

        public void notifyBackupOneFail(Handler.Callback callback, Object obj) {
            BackupObject backupObject = BackupObject.this;
            backupObject.sendMsg(2, backupObject.subKeyCurCount, backupObject.subKeyTotalNum, callback, obj);
        }

        public void notifyBackupOneSuccess(Handler.Callback callback, Object obj) {
            BackupObject backupObject = BackupObject.this;
            backupObject.sendMsg(0, backupObject.subKeyCurCount, backupObject.subKeyTotalNum, callback, obj);
        }

        public void notifyRestoreOneFail(Handler.Callback callback, Object obj) {
            BackupObject backupObject = BackupObject.this;
            backupObject.sendMsg(5, backupObject.subKeyCurCount, backupObject.subKeyTotalNum, callback, obj);
        }

        public void notifyRestoreOneSuccess(Handler.Callback callback, Object obj) {
            BackupObject backupObject = BackupObject.this;
            backupObject.sendMsg(3, backupObject.subKeyCurCount, backupObject.subKeyTotalNum, callback, obj);
        }

        public final void setSelection(String str) {
            this.selection = str;
        }

        public final void setSelectionArgs(String[] strArr) {
            this.selectionArgs = strArr != null ? (String[]) strArr.clone() : null;
        }

        public final void setSortOrder(String str) {
            this.sortOrder = str;
        }
    }

    public BackupObject() {
        BackupFileModuleInfo backupFileModuleInfoBuildBackupFileModuleInfo = buildBackupFileModuleInfo();
        this.backupFileModuleInfo = backupFileModuleInfoBuildBackupFileModuleInfo;
        if (backupFileModuleInfoBuildBackupFileModuleInfo != null) {
            backupFileModuleInfoBuildBackupFileModuleInfo.setType(getModuleType());
        }
    }

    public static HashSet<Integer> buildCurrHashSet(Context context, Uri uri, HashMap<String, Integer> map, String str, String[] strArr) {
        Cursor cursorQuery;
        if (context == null) {
            return new HashSet<>(0);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        try {
            cursorQuery = context.getContentResolver().query(uri, strArr, str, null, null);
        } catch (SQLException unused) {
            C2111d.m12648d(TAG, "buildCurrHashSet SQLException");
        } catch (IllegalStateException unused2) {
            C2111d.m12648d(TAG, "buildCurrHashSet IllegalStateException");
        } catch (Exception unused3) {
            C2111d.m12648d(TAG, "buildCurrHashSet fail.");
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    while (!isAbort()) {
                        ContentValues contentValuesM13213u = C2157a.m13213u(cursorQuery, map);
                        if (contentValuesM13213u != null) {
                            StringBuilder sb2 = new StringBuilder();
                            for (String str2 : strArr) {
                                sb2.append(contentValuesM13213u.getAsString(str2));
                                sb2.append(";");
                            }
                            hashSet.add(Integer.valueOf(C2157a.m13214v(sb2.toString())));
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                    }
                    cursorQuery.close();
                    return hashSet;
                }
            } catch (Throwable th2) {
                try {
                    cursorQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return hashSet;
    }

    public static void clearAbort() {
        isAbortDoing = false;
    }

    public static boolean containsKeys(ContentValues contentValues, String[] strArr, HashSet<Integer> hashSet) {
        int hash;
        if (strArr == null || C13348q.m80082b(hashSet) || (hash = getHash(contentValues, strArr)) == -1) {
            return false;
        }
        return hashSet.contains(Integer.valueOf(hash));
    }

    public static ContentValues[] getBackupValues(Context context, C9662e c9662e) {
        if (context == null || c9662e == null) {
            return new ContentValues[0];
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    Cursor cursorM12618d = C2108a.m12618d(context, c9662e.m60336f(), c9662e.m60332b(), c9662e.m60333c(), c9662e.m60334d(), c9662e.m60335e());
                    if (cursorM12618d != null && cursorM12618d.moveToFirst()) {
                        ContentValues[] contentValuesArr = new ContentValues[cursorM12618d.getCount()];
                        int i10 = 0;
                        while (!isAbort()) {
                            int i11 = i10 + 1;
                            contentValuesArr[i10] = C2157a.m13213u(cursorM12618d, c9662e.m60331a());
                            if (!cursorM12618d.moveToNext()) {
                                break;
                            }
                            i10 = i11;
                        }
                        cursorM12618d.close();
                        return contentValuesArr;
                    }
                    C2111d.m12657m(TAG, "uri is null.");
                    ContentValues[] contentValuesArr2 = new ContentValues[0];
                    if (cursorM12618d != null) {
                        cursorM12618d.close();
                    }
                    return contentValuesArr2;
                } catch (Exception unused) {
                    C2111d.m12648d(TAG, "read values failed.");
                    ContentValues[] contentValuesArr3 = new ContentValues[0];
                    if (0 != 0) {
                        cursor.close();
                    }
                    return contentValuesArr3;
                }
            } catch (SQLException unused2) {
                C2111d.m12648d(TAG, "read values SQLException");
                ContentValues[] contentValuesArr4 = new ContentValues[0];
                if (0 != 0) {
                    cursor.close();
                }
                return contentValuesArr4;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public static Bundle getExecuteParameter() {
        Bundle bundle;
        synchronized (EXECUTE_PARAMETER_LOCK) {
            bundle = EXECUTE_PARAMETER;
        }
        return bundle;
    }

    public static List<String> getFollowingRestoreModules() {
        return followingModulesThreadLocal.get() != null ? followingModulesThreadLocal.get() : new ArrayList(0);
    }

    public static int getHash(ContentValues contentValues, String[] strArr) {
        if (strArr == null || contentValues == null) {
            return -1;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : strArr) {
            if (!contentValues.containsKey(str)) {
                return -1;
            }
            sb2.append(contentValues.getAsString(str));
            sb2.append(";");
        }
        return C2157a.m13214v(sb2.toString());
    }

    public static int getLastBackupSession() {
        return lastBackupSession;
    }

    public static int getLastRestoreSession() {
        return lastRestoreSession;
    }

    private Bundle getModuleInfoBundle(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("app_id", str);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, HashMap<String, String>> entry : this.moduleInfo.entrySet()) {
            HashMap<String, String> value = entry.getValue();
            value.put(C2126b.MODULE_INFO_URI, entry.getKey());
            arrayList.add(value);
        }
        bundle.putString(C2126b.MODULE_INFO_LIST, new Gson().toJson(arrayList));
        return bundle;
    }

    public static List<String> getTwinApps() {
        return C10713c.m65401k(getExecuteParameter(), "twinAppList");
    }

    public static long getWeChatDataSize() {
        long jM65397g = C10713c.m65397g(getExecuteParameter(), "wechatMaxDataSize", 0L);
        C2111d.m12654j(TAG, "getWeChatDataSize = ", Long.valueOf(jM65397g));
        return jM65397g;
    }

    private static boolean ignoredByFilesBundle(String str) {
        return isMediaModule(str);
    }

    public static boolean isAbort() {
        return isAbortDoing;
    }

    public static boolean isBothPhoneSupportAppExternalData() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportAppExternalData", false);
        C2111d.m12647c(TAG, "isBothPhoneSupportAppExternalData = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public static boolean isBothSupportSplitTar() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportPmsSplitTar", false);
        C2111d.m12647c(TAG, "[SplitTar] isBothSupportSplitTar = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public static boolean isBothSupportTwinApp() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportTwinApp", false);
        C2111d.m12647c(TAG, "isOtherPhoneSupportTwinApp = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    private static boolean isGalleryDataModule(String str) {
        return "galleryData".equals(str);
    }

    public static boolean isMediaModule(String str) {
        return MEDIA_MODULE_LIST.contains(str);
    }

    public static boolean isMediaModuleExceptWechatRecord(String str) {
        return isMediaModule(str) && !"wechat_record".equals(str);
    }

    public static boolean isMediaRestoreModule(String str) {
        return isGalleryDataModule(str) || isMediaModule(str);
    }

    public static boolean isNewGallery() {
        return C10713c.m65392b(getExecuteParameter(), "isNewGallery", false);
    }

    public static boolean isOldPhoneStorageNotEnough(String str) {
        ArrayList<String> arrayListM65401k = C10713c.m65401k(getExecuteParameter(), "oldPhoneStorageNotEnoughModules");
        return !arrayListM65401k.isEmpty() && arrayListM65401k.contains(str);
    }

    public static boolean isOppositePhoneSupportGms() {
        return C10713c.m65392b(getExecuteParameter(), "isSupportGms", true);
    }

    public static boolean isOtherPhoneSupportAppObb() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportAppObb", false);
        C2111d.m12647c(TAG, "isOtherPhoneSupportAppObb = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public static boolean isOtherPhoneSupportTarRecorder() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportTarRecorder", false);
        C2111d.m12647c(TAG, "isOtherPhoneSupportTarRecorder = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public static boolean isPhotoModule(String str) {
        return "photo".equals(str) || "photo_sd".equals(str);
    }

    public static boolean isRecordModule(String str) {
        return "soundrecorder".equals(str) || "callRecorder".equals(str);
    }

    public static boolean isRestoreWifiComplete() {
        return isRestoreWifiComplete;
    }

    public static boolean isSdCardMediaModule(int i10) {
        return i10 == 512 || i10 == 513 || i10 == 514 || i10 == 515;
    }

    public static boolean isSdCardModule(String str) {
        return SD_MEDIA_MODULE_LIST.contains(str);
    }

    public static boolean isShowTransSysModule(String str) {
        return "sns".equals(str) || "galleryData".equals(str) || "contactFA".equals(str);
    }

    public static boolean isSplitTarModule(String str) {
        if (!isBothSupportSplitTar()) {
            return false;
        }
        ArrayList<String> arrayListM65401k = C10713c.m65401k(getExecuteParameter(), "splitTarModules");
        if (C13348q.m80082b(arrayListM65401k)) {
            return false;
        }
        return arrayListM65401k.contains(str);
    }

    public static boolean isSupportBundleApp() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportBundleApp", false);
        C2111d.m12647c(TAG, "isSupportBundleApp = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public static boolean isSupportSmallFileModule(String str) {
        return BackupConstant.m13148v().contains(str) || isMediaModule(str) || isRecordModule(str);
    }

    public static boolean isTwinApp(String str) {
        return isBothSupportTwinApp() && getTwinApps().contains(str);
    }

    public static boolean isUseDftpTar() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportDftpV2", false);
        C2111d.m12654j(TAG, "[dftpTar] isUseDftpTar = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public static boolean isWechatRecord(String str) {
        return "wechat_record".equals(str);
    }

    public static boolean isWechatRestoreSuccess() {
        return C10713c.m65392b(getExecuteParameter(), "isWechatRestoreSuccess", true);
    }

    public static BackupFileModuleInfo[] readAllModuleInfo(AbstractC0048c abstractC0048c) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        if (abstractC0048c == null) {
            return new BackupFileModuleInfo[0];
        }
        Object[] objArrM13154b = InfoXmlUtils.m13154b(abstractC0048c, BackupFileModuleInfo.class);
        Object[] objArrM13155c = InfoXmlUtils.m13155c(abstractC0048c, BackupFileModuleInfo.class, C9658a.class.getSimpleName());
        Object[] objArrM13155c2 = InfoXmlUtils.m13155c(abstractC0048c, BackupFileModuleInfo.class, C9659b.class.getSimpleName());
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArrM13154b) {
            if (obj instanceof BackupFileModuleInfo) {
                arrayList.add((BackupFileModuleInfo) obj);
            }
        }
        for (Object obj2 : objArrM13155c) {
            if (obj2 instanceof BackupFileModuleInfo) {
                arrayList.add((BackupFileModuleInfo) obj2);
            }
        }
        for (Object obj3 : objArrM13155c2) {
            if (obj3 instanceof BackupFileModuleInfo) {
                arrayList.add((BackupFileModuleInfo) obj3);
            }
        }
        return arrayList.isEmpty() ? new BackupFileModuleInfo[0] : (BackupFileModuleInfo[]) arrayList.toArray(new BackupFileModuleInfo[0]);
    }

    public static void removeFromFollowingRestoreModules(String str) {
        getFollowingRestoreModules().remove(str);
    }

    public static void sendBroadcastToContactAfterRestore(Context context) {
        C2111d.m12653i(TAG, "sendBroadcastToContactAfterRestore");
        if (context != null) {
            context.sendBroadcast(new Intent(BackupConstant.KoBackupIntent.CONTACT_RESTORE_FINISHED_ACTION), BackupConstant.KoBackupIntent.RECEIVER_PERMISSION);
        }
    }

    public static void setAbort() {
        isAbortDoing = true;
    }

    public static void setFollowingRestoreModules(List<String> list) {
        followingModulesThreadLocal.set(list);
    }

    public static void setLastBackupSession(int i10) {
        lastBackupSession = i10;
    }

    public static void setLastRestoreSession(int i10) {
        lastRestoreSession = i10;
    }

    public static void setRestoreWifiComplete(boolean z10) {
        isRestoreWifiComplete = z10;
    }

    public static void updateExecuteParameter(Bundle bundle) {
        if (bundle == null) {
            C2111d.m12648d(TAG, "resetExecuteParameter param is null");
            return;
        }
        synchronized (EXECUTE_PARAMETER_LOCK) {
            Bundle bundle2 = EXECUTE_PARAMETER;
            bundle2.clear();
            bundle2.putAll(bundle);
        }
    }

    private boolean validCheckInfo(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.length() != 0) {
            return true;
        }
        C2111d.m12648d(TAG, "backup file is not exists! Restore fail!");
        return false;
    }

    public void addModuleUriInfo(String str, boolean z10, boolean z11, int i10, int i11) {
        HashMap<String, String> map = new HashMap<>();
        map.put(C2126b.MODULE_INFO_IS_NEED_BACKUP_URI, z10 ? "1" : "0");
        map.put(C2126b.MODULE_INFO_IS_NEED_COUNT_URI, z11 ? "1" : "0");
        map.put(C2126b.MODULE_INFO_PREPARE_COUNT, String.valueOf(i10));
        map.put("count", String.valueOf(i11));
        this.moduleInfo.put(str, map);
    }

    public void attachUriInfo(String str, String str2, String str3) {
        HashMap<String, String> map = this.moduleInfo.get(str);
        if (map != null) {
            map.put(str2, str3);
        }
    }

    public BackupFileModuleInfo buildBackupFileModuleInfo() {
        return new BackupFileModuleInfo();
    }

    public String createCloneSecurityInfo(String str) {
        if (str == null) {
            return null;
        }
        C9408a c9408aM59012f = C9408a.m59012f();
        c9408aM59012f.m59018h(c9408aM59012f.m59014c(c9408aM59012f.m59015d(), str));
        return c9408aM59012f.m59013a();
    }

    public int createSecurityV3Info(Context context, String str) {
        BackupFileModuleInfo backupFileModuleInfo = this.backupFileModuleInfo;
        if (backupFileModuleInfo == null || str == null || context == null) {
            return 10001;
        }
        backupFileModuleInfo.updateMsgV3("checkMsg", null);
        return 10000;
    }

    public long getAppInfoSize(Context context, long j10, int i10) {
        if (context == null) {
            return 0L;
        }
        if (!C2157a.m13177L(context)) {
            return 1000 * i10;
        }
        if (i10 == 0) {
            return 0L;
        }
        return j10;
    }

    public Bundle getBackupFilesBundle() {
        return this.backupFilesBundle;
    }

    public Bundle getExtraInfo(Context context, String str) {
        return null;
    }

    public int getModuleType() {
        return 0;
    }

    public boolean isCloudBackup() {
        int iM65395e = C10713c.m65395e(getExecuteParameter(), CloneService.KEY_ACTION_FLAG, -1);
        C2111d.m12654j(TAG, "actionFlag = ", Integer.valueOf(iM65395e));
        return iM65395e == 10;
    }

    public boolean isOtherPhoneSupportPduFileOptimization() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportPduFileOptimization", false);
        C2111d.m12654j(TAG, "isOtherPhoneSupportPduFileOptimization = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public boolean isOtherPhoneSupportPms() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportPMS", false);
        C2111d.m12647c(TAG, "isOtherPhoneSupportPms = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public boolean isOtherPhoneSupportTar() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isSupportTar", false);
        C2111d.m12647c(TAG, "isOtherPhoneSupportTar = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public boolean isSupportIosSmallFileTar() {
        return C10713c.m65392b(getExecuteParameter(), "isIosSupportTar", false);
    }

    public boolean isSupportSmallFileTar() {
        return C10713c.m65392b(getExecuteParameter(), "isUseDataTrans", false);
    }

    public abstract boolean isSupported(Context context, String str);

    public boolean isUseDataTrans() {
        boolean zM65392b = C10713c.m65392b(getExecuteParameter(), "isUseDataTrans", false);
        if (C10713c.m65392b(getExecuteParameter(), "isPerformanceHidiskService", false)) {
            C2111d.m12646b(TAG, "isUseHidiskService true ");
            return false;
        }
        C2111d.m12647c(TAG, "isUseDataTrans = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    public boolean isWechatTwinUsePmsFile() {
        return C10713c.m65392b(getExecuteParameter(), "isWechatTwinUsePmsFile", false);
    }

    public boolean isWechatUsePmsFile() {
        return C10713c.m65392b(getExecuteParameter(), "isWechatUsePmsFile", false);
    }

    public Bundle notifyModuleStart(Context context, String str, String str2) {
        return null;
    }

    public abstract int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str);

    public abstract Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str);

    public int onBackupPro(Context context, AbstractC0048c abstractC0048c, AbstractC0048c abstractC0048c2, Handler.Callback callback, String str) throws InterruptedException {
        C2111d.m12654j(TAG, "onBackupPro ", str);
        C13703a.m82444c().m82448f(str);
        if (this.backupFileModuleInfo == null) {
            this.backupFileModuleInfo = buildBackupFileModuleInfo(getClass());
        }
        InfoXmlUtils.m13159g(BackupConstant.VersionInfo.getInstance(context).getVersionCode());
        String strM197o = abstractC0048c.m197o();
        int iOnBackup = onBackup(context, abstractC0048c, callback, null, str);
        if (iOnBackup == 17) {
            return -1;
        }
        if (iOnBackup != 1) {
            return this.backupFileModuleInfo.getRecordTotal();
        }
        abstractC0048c.mo170b();
        if (!C13334c.m79980m(strM197o + "-journal")) {
            C2111d.m12648d(TAG, "delete temp journal fail");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e10) {
                C2111d.m12648d(TAG, "waiting for delete journal interrupted: " + e10.toString());
            }
            abstractC0048c.mo170b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delete temp journal again result: ");
            sb2.append(C13334c.m79980m(strM197o + "-journal"));
            C2111d.m12648d(TAG, sb2.toString());
        }
        int iCreateSecurityV3Info = createSecurityV3Info(context, strM197o);
        if (iCreateSecurityV3Info == 10000) {
            this.backupFliedList.add(strM197o);
            Bundle bundle = new Bundle();
            this.backupFilesBundle = bundle;
            bundle.putStringArrayList("module_file_list", this.backupFliedList);
            writeModuleInfo(abstractC0048c2);
            return this.backupFileModuleInfo.getRecordTotal();
        }
        sendMsg(100, C2111d.m12652h(TAG, str, "onBackupPro", "createSecurityV3Info fail! dataFileName = " + strM197o + "errorCode = " + iCreateSecurityV3Info), callback, (Object) null);
        sendMsg(2, 0, 0, callback, null);
        return 0;
    }

    public int onClonePro(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, String str) {
        C2111d.m12654j(TAG, "onClonePro ", str);
        C13703a.m82444c().m82448f(str);
        if (this.backupFileModuleInfo == null) {
            this.backupFileModuleInfo = buildBackupFileModuleInfo(getClass());
        }
        this.backupFilesBundle = new Bundle();
        int iOnBackup = onBackup(context, abstractC0048c, callback, null, str);
        if (iOnBackup == 17) {
            return -1;
        }
        abstractC0048c.mo170b();
        if (!C13334c.m79980m(abstractC0048c.m196n() + "-journal")) {
            C2111d.m12657m(TAG, "delete temp journal fail");
        }
        String strM197o = abstractC0048c.m197o();
        if (!TextUtils.isEmpty(strM197o)) {
            if (iOnBackup == 2 || !ignoredByFilesBundle(this.backupFileModuleInfo.getName())) {
                File file = new File(strM197o);
                if (!file.exists()) {
                    C13334c.m79978k(file);
                }
                this.backupFliedList.add(strM197o);
            } else {
                C13334c.m79980m(strM197o);
            }
        }
        this.backupFilesBundle.putStringArrayList("module_file_list", this.backupFliedList);
        String strCreateCloneSecurityInfo = createCloneSecurityInfo(strM197o);
        if (strCreateCloneSecurityInfo == null) {
            C2111d.m12648d(TAG, "onClonePro encryptInfo is null");
            return -1;
        }
        this.backupFilesBundle.putString("module_encrypt_info", strCreateCloneSecurityInfo);
        return this.backupFileModuleInfo.getRecordTotal();
    }

    public int onCloneRestorePro(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, String str) {
        Bundle bundleM65393c = C10713c.m65393c(APP_EXTRA_PARAMETER, "key_encrypt");
        if (bundleM65393c == null) {
            C2111d.m12648d(TAG, "executeParameter doesn't contain encrypt info.");
            sendMsg(5, 0, 0, callback, null);
            return 0;
        }
        String strM65400j = C10713c.m65400j(bundleM65393c, "module_encrypt_info");
        if (strM65400j == null) {
            C2111d.m12648d(TAG, "encryptInfo is null, restore fail!");
            sendMsg(5, 0, 0, callback, null);
            return 0;
        }
        String strM196n = abstractC0048c.m196n();
        C2111d.m12654j(TAG, "time test --- ", "filePath validateCloneSecurityInfo begin");
        boolean zValidateCloneSecurityInfo = validateCloneSecurityInfo(strM196n, strM65400j);
        C2111d.m12654j(TAG, "time test --- ", "filePath validateCloneSecurityInfo end");
        if (zValidateCloneSecurityInfo) {
            return openAndRestore(context, abstractC0048c, callback, null, str);
        }
        C2111d.m12648d(TAG, "validateCloneSecurityInfo fail!");
        sendMsg(5, 0, 0, callback, null);
        return 0;
    }

    public abstract int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str);

    public int onRestorePro(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (validateRestoreFile(context, callback, obj, abstractC0048c.m196n())) {
            return openAndRestore(context, abstractC0048c, callback, obj, str);
        }
        C2111d.m12649e(TAG, "restoreOneModule validateRestoreFile fail!", str);
        return 0;
    }

    public int openAndRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (!abstractC0048c.mo172d(abstractC0048c.m196n())) {
            sendMsg(22, 0, 0, callback, obj);
            return 0;
        }
        C13703a.m82444c().m82448f(str);
        int iOnRestore = onRestore(context, abstractC0048c, callback, obj, str);
        if (iOnRestore == 5) {
            sendMsg(5, 0, 0, callback, obj);
        }
        return iOnRestore;
    }

    public Bundle reassembleExtra(Bundle bundle) {
        return bundle;
    }

    public Uri reassembleUri(Uri uri) {
        return uri;
    }

    public void reportModuleBackupFinish(String str, Handler.Callback callback, Object obj) {
        sendMsg(102, getModuleInfoBundle(str), callback, obj);
    }

    public void reportModuleRestoreFinish(String str) {
        C2111d.m12653i(TAG, "Restore Finish: " + getModuleInfoBundle(str));
    }

    public void setExtraInfo(Context context, String str) {
    }

    public void setModuleName(String str) {
        if (this.backupFileModuleInfo == null) {
            this.backupFileModuleInfo = buildBackupFileModuleInfo();
        }
        BackupFileModuleInfo backupFileModuleInfo = this.backupFileModuleInfo;
        if (backupFileModuleInfo != null) {
            backupFileModuleInfo.setName(str);
            this.backupFileModuleInfo.setType(getModuleType());
        }
    }

    public void toNewSession(Context context, String str, String str2) {
    }

    public boolean validateCloneSecurityInfo(String str, String str2) {
        if (str == null) {
            C2111d.m12648d(TAG, "validateCloneSecurityInfo filename is null");
            return false;
        }
        if (str2 == null) {
            C2111d.m12648d(TAG, "validateCloneSecurityInfo info is null");
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.length() == 0) {
            C2111d.m12648d(TAG, "backup file is not exists! Restore fail!");
            return false;
        }
        C9408a c9408aM59012f = C9408a.m59012f();
        if (c9408aM59012f == null) {
            C2111d.m12648d(TAG, "validateCloneSecurityInfo cs is null");
            return false;
        }
        if (c9408aM59012f.m59017g(str2)) {
            return c9408aM59012f.m59019i(c9408aM59012f.m59015d(), str, c9408aM59012f.m59016e());
        }
        return false;
    }

    public boolean validateRestoreFile(Context context, Handler.Callback callback, Object obj, String str) {
        if (str == null || context == null) {
            return false;
        }
        boolean zValidateSecurityV3Info = validateSecurityV3Info(context, str);
        if (zValidateSecurityV3Info) {
            return true;
        }
        if (C9409b.m59023d() == 0) {
            zValidateSecurityV3Info = validCheckInfo(str);
        }
        if (!zValidateSecurityV3Info && !isAbort()) {
            C2111d.m12648d(TAG, "check backup file fail, restore fail!");
            sendMsg(22, 0, 0, callback, obj);
        }
        return zValidateSecurityV3Info;
    }

    public boolean validateSecurityV3Info(Context context, String str) {
        if (str == null || context == null || this.backupFileModuleInfo == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.length() != 0) {
            return this.backupFileModuleInfo.getCheckMsgV3() != null;
        }
        C2111d.m12648d(TAG, "backup file is not exists! Restore fail!");
        return false;
    }

    public int writeModuleInfo(AbstractC0048c abstractC0048c) {
        if (abstractC0048c == null) {
            return 2;
        }
        if (this.backupFileModuleInfo.hasRecord()) {
            return this.backupFileModuleInfo.writeInfo(abstractC0048c);
        }
        return 1;
    }

    public void writeNetContactModuleInfo(AbstractC0048c abstractC0048c) {
        if (abstractC0048c == null || C13348q.m80082b(this.contactModuleInfoList)) {
            return;
        }
        Iterator<C11238f> it = this.contactModuleInfoList.iterator();
        while (it.hasNext()) {
            it.next().m67535c(abstractC0048c);
        }
    }

    public BackupFileModuleInfo buildBackupFileModuleInfo(Class<? extends BackupObject> cls) {
        return new BackupFileModuleInfo(cls);
    }

    public void addModuleUriInfo(String str, boolean z10, boolean z11, int i10) {
        addModuleUriInfo(str, z10, z11, i10, 0);
    }
}
