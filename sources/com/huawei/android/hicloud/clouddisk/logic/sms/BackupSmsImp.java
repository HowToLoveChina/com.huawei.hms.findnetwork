package com.huawei.android.hicloud.clouddisk.logic.sms;

import android.app.AppOpsManager;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSRecoverSmsAndCallResp;
import com.huawei.hicloud.request.cbs.bean.SmsBean;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.network.p129ai.C5799g0;
import fk.C9721b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C10812z;
import ke.C11046a;
import md.C11439b;
import p015ak.C0209d;
import p015ak.C0214f0;
import p015ak.C0241z;
import p458lo.C11322a;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12338d;
import p684un.C13223b;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class BackupSmsImp {
    private static final String TAG = "BackupSmsImp";
    private static final long TIME = 1800000;
    private Context mContext;
    private SharedPreferences sharedPre;
    private int restoredNum = 0;
    private int noChangeNum = 0;
    private int totalNum = 0;
    private int addressNullNum = 0;
    private int msgId = 0;
    private Map<String, Long> threadIdMap = new HashMap();
    private boolean hasNetWorkType = false;
    private boolean hasSubID = false;
    private boolean isSupportBulkinsert = false;
    private Uri outSMSUri = Uri.parse("content://sms/");

    public static class MyPrivilegedAction implements PrivilegedAction {
        private Method setMode;

        public MyPrivilegedAction(Method method) {
            this.setMode = method;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.setMode.setAccessible(true);
            return null;
        }
    }

    public BackupSmsImp(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.sharedPre = C0214f0.m1382b(context, "cloudbackupsms", 0);
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x00a6: MOVE (r26 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:23:0x00a6 */
    private ContentProviderResult[] applyBatchAndListClear(Context context, ArrayList<ContentProviderOperation> arrayList, String str) throws Throwable {
        String str2;
        String str3;
        try {
        } catch (Throwable th2) {
            th = th2;
            str2 = "";
        }
        try {
            try {
                try {
                    ContentProviderResult[] contentProviderResultArrApplyBatch = context.getContentResolver().applyBatch(NavigationUtils.SMS_SCHEMA_PREF, arrayList);
                    arrayList.clear();
                    if (!TextUtils.isEmpty("")) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("restoredNum", String.valueOf(this.restoredNum));
                        C10812z.m65839h(this.mContext, NavigationUtils.SMS_SCHEMA_PREF, -1, "", "", "03010", "more_data_restore", str, linkedHashMap, true);
                    }
                    return contentProviderResultArrApplyBatch;
                } catch (OperationApplicationException e10) {
                    C11839m.m70687e(TAG, "operation error: " + e10.toString());
                    String str4 = "operation error: " + e10.getMessage();
                    ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[0];
                    if (!TextUtils.isEmpty(str4)) {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put("restoredNum", String.valueOf(this.restoredNum));
                        C10812z.m65839h(this.mContext, NavigationUtils.SMS_SCHEMA_PREF, -1, "", str4, "03010", "more_data_restore", str, linkedHashMap2, true);
                    }
                    return contentProviderResultArr;
                } catch (Exception e11) {
                    C11839m.m70687e(TAG, "applyBatchAndListClear  Exception : " + e11.toString());
                    String str5 = "applyBatchAndListClear  Exception : " + e11.getMessage();
                    ContentProviderResult[] contentProviderResultArr2 = new ContentProviderResult[0];
                    if (!TextUtils.isEmpty(str5)) {
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        linkedHashMap3.put("restoredNum", String.valueOf(this.restoredNum));
                        C10812z.m65839h(this.mContext, NavigationUtils.SMS_SCHEMA_PREF, -1, "", str5, "03010", "more_data_restore", str, linkedHashMap3, true);
                    }
                    return contentProviderResultArr2;
                }
            } catch (RemoteException e12) {
                C11839m.m70687e(TAG, "remote error: " + e12.toString());
                String str6 = "remote error: " + e12.getMessage();
                ContentProviderResult[] contentProviderResultArr3 = new ContentProviderResult[0];
                if (!TextUtils.isEmpty(str6)) {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    linkedHashMap4.put("restoredNum", String.valueOf(this.restoredNum));
                    C10812z.m65839h(this.mContext, NavigationUtils.SMS_SCHEMA_PREF, -1, "", str6, "03010", "more_data_restore", str, linkedHashMap4, true);
                }
                return contentProviderResultArr3;
            }
        } catch (Throwable th3) {
            th = th3;
            str2 = str3;
            if (!TextUtils.isEmpty(str2)) {
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                linkedHashMap5.put("restoredNum", String.valueOf(this.restoredNum));
                C10812z.m65839h(this.mContext, NavigationUtils.SMS_SCHEMA_PREF, -1, "", str2, "03010", "more_data_restore", str, linkedHashMap5, true);
            }
            throw th;
        }
    }

    private boolean checkBackupCondition(int i10, CloudDiskModuleRst cloudDiskModuleRst) {
        if (i10 == 0) {
            cloudDiskModuleRst.setRetCode(1);
            cloudDiskModuleRst.setFailReason("totalNum is 0,no change occurred");
            C11839m.m70688i(TAG, "totalNum is 0,no change occurred");
            setTimer();
            return false;
        }
        if (C13452e.m80781L().m80927i1()) {
            C11839m.m70687e(TAG, "Sync risk");
            cloudDiskModuleRst.setRetCode(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED);
            cloudDiskModuleRst.setFailReason("Sync risk");
            return false;
        }
        if (!C13452e.m80781L().m80917g1()) {
            return true;
        }
        C11839m.m70687e(TAG, "Local ST invalid flag is true");
        cloudDiskModuleRst.setRetCode(2001);
        cloudDiskModuleRst.setFailReason("Local ST invalid flag is true");
        return false;
    }

    private void dealWithEDSN(String str, String str2, String str3, String str4, ContentValues contentValues) {
        if (str != null && !"null".equals(str)) {
            putExtRestoreResult(contentValues, "error_code", str, false);
        }
        if (str2 != null && !"null".equals(str2)) {
            putExtRestoreResult(contentValues, "date_sent", str2, true);
        }
        if (this.hasSubID && str3 != null && !"null".equals(str3)) {
            putExtRestoreResult(contentValues, CallLogCons.SUBID, str3, false);
        }
        if (!this.hasNetWorkType || str4 == null || "null".equals(str4)) {
            return;
        }
        putExtRestoreResult(contentValues, "network_type", str4, false);
    }

    private void dealWithSSPL(String str, String str2, String str3, String str4, ContentValues contentValues) {
        if (str != null && !"null".equals(str)) {
            putExtRestoreResult(contentValues, "seen", str, false);
        }
        if (str2 != null && !"null".equals(str2)) {
            putExtRestoreResult(contentValues, "status", str2, false);
        }
        if (str3 != null && !"null".equals(str3)) {
            putExtRestoreResult(contentValues, "protocol", str3, false);
        }
        if (str4 == null || "null".equals(str4)) {
            return;
        }
        putExtRestoreResult(contentValues, "locked", str4, false);
    }

    private void doBulkinsert(ArrayList<ContentValues> arrayList, Context context, String str) {
        int iBulkInsert;
        if (arrayList == null || context == null || arrayList.isEmpty()) {
            return;
        }
        if (!C0209d.m1227Y1(this.mContext, this.outSMSUri)) {
            C11839m.m70687e(TAG, "TargetApp is not SystemApp");
            return;
        }
        try {
            iBulkInsert = context.getContentResolver().bulkInsert(this.outSMSUri, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]));
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "queryProvider error = " + e10.toString());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("restoredNum", String.valueOf(this.restoredNum));
            C10812z.m65839h(this.mContext, NavigationUtils.SMS_SCHEMA_PREF, -1, "", "queryProvider error = " + e10.getMessage(), "03010", "more_data_restore", str, linkedHashMap, true);
            iBulkInsert = 0;
        }
        this.restoredNum += iBulkInsert;
    }

    private boolean existInLocal(SmsBean smsBean, List<SmsBean> list) {
        Iterator<SmsBean> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equal(smsBean)) {
                return true;
            }
        }
        return false;
    }

    private List<SmsBean> getLocalSmsList(String str, String str2, int i10) {
        String[] strArr;
        String str3;
        String[] strArr2;
        String str4;
        ArrayList arrayList;
        long jCurrentTimeMillis = System.currentTimeMillis() - 1800000;
        Cursor cursorQuery = null;
        String str5 = "_id ASC";
        if (i10 == 0) {
            strArr = new String[]{String.valueOf(str)};
            str3 = "_id = ?";
        } else if (i10 == 1) {
            strArr = new String[]{String.valueOf(str), String.valueOf(jCurrentTimeMillis)};
            str3 = "_id > ? and date < ?";
        } else {
            if (i10 != 2) {
                str4 = null;
                strArr2 = null;
                String str6 = str5;
                arrayList = new ArrayList();
                if (str4 != null || strArr2 == null) {
                    return arrayList;
                }
                this.threadIdMap.clear();
                if (!C0209d.m1227Y1(this.mContext, this.outSMSUri)) {
                    C11839m.m70687e(TAG, "TargetApp is not SystemApp");
                    return arrayList;
                }
                try {
                    try {
                        cursorQuery = this.mContext.getContentResolver().query(this.outSMSUri, null, str4, strArr2, str6);
                        if (cursorQuery != null) {
                            toSmsBeans(cursorQuery, arrayList);
                        }
                    } catch (Exception e10) {
                        C11839m.m70687e(TAG, "query sms exception: " + e10.toString());
                        if (cursorQuery != null) {
                        }
                    }
                    return arrayList;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            strArr = new String[]{String.valueOf(str), String.valueOf(str2)};
            str3 = "_id >= ? and _id <= ?";
            str5 = "_id DESC";
        }
        strArr2 = strArr;
        str4 = str3;
        String str62 = str5;
        arrayList = new ArrayList();
        if (str4 != null) {
        }
        return arrayList;
    }

    private CloudDiskModuleRst getRestoreRst(CloudDiskModuleRst cloudDiskModuleRst, Handler.Callback callback) {
        int i10;
        int i11 = (this.totalNum - this.restoredNum) - this.noChangeNum;
        if (((C11439b.a) callback).m68523b()) {
            C11839m.m70688i(TAG, "RestoreSms is aborted");
            i10 = 3;
        } else {
            if (this.restoredNum == 0 && i11 == 0 && this.noChangeNum == 0) {
                C11839m.m70688i(TAG, "RestoreSms fail");
                i10 = -1;
            } else {
                i10 = 0;
            }
            if (this.restoredNum == 0 && i11 != 0) {
                C11839m.m70688i(TAG, "RestoreSms fail");
                i10 = -1;
            }
            if ((this.restoredNum != 0 || this.noChangeNum != 0) && i11 != 0) {
                C11839m.m70688i(TAG, "RestoreSms succeed partly, successNum is " + this.restoredNum + ",failNum is " + i11 + ",totalNum is " + this.totalNum);
                i10 = 2;
            }
        }
        cloudDiskModuleRst.setRetCode(i10);
        cloudDiskModuleRst.setSuccessNum(this.restoredNum);
        cloudDiskModuleRst.setNochangeNum(this.noChangeNum);
        cloudDiskModuleRst.setFailNum(i11);
        cloudDiskModuleRst.setTotalNum(this.totalNum);
        return cloudDiskModuleRst;
    }

    private List<SmsSpBean> getSmsSpBeans() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 10; i10++) {
            String string = this.sharedPre.getString("_id" + i10, "0");
            String string2 = this.sharedPre.getString("md5" + i10, "");
            if (string2.isEmpty()) {
                break;
            }
            arrayList.add(new SmsSpBean(string, string2));
        }
        return arrayList;
    }

    private void insertToDB(List<SmsBean> list, List<SmsBean> list2, String str) throws Throwable {
        C11839m.m70688i(TAG, "SMS insertIntoLocalDB");
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        ArrayList<ContentValues> arrayList3 = new ArrayList<>();
        int i10 = 0;
        for (SmsBean smsBean : list) {
            String address = smsBean.getAddress();
            if (address == null || address.isEmpty() || "null".equals(address)) {
                this.addressNullNum++;
                this.noChangeNum++;
            } else if (existInLocal(smsBean, list2)) {
                this.noChangeNum++;
            } else if (this.isSupportBulkinsert) {
                arrayList3.add(smsBeanToContentValue(smsBean));
            } else if (i10 < 50) {
                arrayList.add(ContentProviderOperation.newInsert(this.outSMSUri).withValues(smsBeanToContentValue(smsBean)).build());
                i10++;
            } else {
                arrayList2.add(ContentProviderOperation.newInsert(this.outSMSUri).withValues(smsBeanToContentValue(smsBean)).build());
            }
        }
        C11839m.m70688i(TAG, "addressNullNum: " + this.addressNullNum + ",noChangeNum: " + this.noChangeNum);
        if (this.isSupportBulkinsert) {
            doBulkinsert(arrayList3, this.mContext, str);
            arrayList3.clear();
            return;
        }
        if (arrayList.size() > 0) {
            ContentProviderResult[] contentProviderResultArrApplyBatchAndListClear = applyBatchAndListClear(this.mContext, arrayList, str);
            arrayList.clear();
            this.restoredNum += contentProviderResultArrApplyBatchAndListClear.length;
        }
        if (arrayList2.size() > 0) {
            ContentProviderResult[] contentProviderResultArrApplyBatchAndListClear2 = applyBatchAndListClear(this.mContext, arrayList2, str);
            arrayList2.clear();
            this.restoredNum += contentProviderResultArrApplyBatchAndListClear2.length;
        }
    }

    private boolean isNeedTimer() {
        String smsStartId = setSmsStartId();
        C11839m.m70688i(TAG, "isNeedTimer  startId: " + smsStartId);
        int size = getLocalSmsList(smsStartId, null, 3).size();
        C11839m.m70688i(TAG, "isNeedTimer  total size: " + size);
        return size > 0;
    }

    private boolean isSupportBulkinsert(Context context) {
        Bundle bundleM1243d = C0209d.m1243d(context, this.outSMSUri, "METHOD_BULKINSERT_SUPPORT", null, null);
        return bundleM1243d != null && bundleM1243d.getBoolean("HW_KOBACKUP_BULKINSERT");
    }

    private void putExtRestoreResult(ContentValues contentValues, String str, String str2, boolean z10) {
        if (z10) {
            contentValues.put(str, Long.valueOf(C0241z.m1688f(str2)));
        } else {
            contentValues.put(str, Integer.valueOf(C0241z.m1685c(str2)));
        }
    }

    private void sendMsg(Handler.Callback callback, int i10, int i11, int i12) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i10;
        messageObtain.arg1 = i11;
        messageObtain.arg2 = i12;
        messageObtain.obj = NavigationUtils.SMS_SCHEMA_PREF;
        if (callback != null) {
            callback.handleMessage(messageObtain);
        }
    }

    private void setMode(Context context) throws IllegalAccessException, NoSuchMethodException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        PackageManager packageManager = context.getPackageManager();
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            PackageInfo packageInfo = packageManager.getPackageInfo("com.huawei.hidisk", 8192);
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("setMode", cls2, cls2, String.class, cls2);
            AccessController.doPrivileged(new MyPrivilegedAction(declaredMethod));
            declaredMethod.invoke(appOpsManager, 15, Integer.valueOf(packageInfo.applicationInfo.uid), "com.huawei.hidisk", 0);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "setMode failed :" + e10.toString());
        }
    }

    private void setSmsBackupRetCode(CloudDiskModuleRst cloudDiskModuleRst, int i10, int i11) {
        if (i11 == i10) {
            cloudDiskModuleRst.setRetCode(0);
            C11839m.m70688i(TAG, "backup sms success");
            return;
        }
        if (i10 == 0) {
            cloudDiskModuleRst.setRetCode(-1);
            C11839m.m70688i(TAG, "backup sms fail");
        } else if (i11 != i10) {
            cloudDiskModuleRst.setRetCode(2);
            C11839m.m70688i(TAG, "backup sms done,total：" + i11 + ",successNum:" + i10);
        }
    }

    private String setSmsStartId() {
        List<SmsSpBean> smsSpBeans = getSmsSpBeans();
        if (smsSpBeans.isEmpty()) {
            return "0";
        }
        List<SmsBean> localSmsList = getLocalSmsList(smsSpBeans.get(smsSpBeans.size() - 1).getId(), smsSpBeans.get(0).getId(), 2);
        for (SmsSpBean smsSpBean : smsSpBeans) {
            C11839m.m70688i(TAG, "sp id = " + smsSpBean.getId());
            Iterator<SmsBean> it = localSmsList.iterator();
            while (true) {
                if (it.hasNext()) {
                    SmsBean next = it.next();
                    C11839m.m70688i(TAG, "local db id = " + next.getId());
                    if (next.getId().equals(smsSpBean.getId())) {
                        if (smsSpBean.getSmsStr().equals(next.getSmsStr())) {
                            return next.getId();
                        }
                    }
                }
            }
        }
        return "0";
    }

    private void setTimer() {
        if (C11829c.m70611r0() || !isNeedTimer()) {
            return;
        }
        C11839m.m70688i(TAG, "backup sms NeedTimer");
        C12338d.m74195s().m74258x0();
        C12338d.m74195s().m74225c0();
    }

    private ContentValues smsBeanToContentValue(SmsBean smsBean) {
        ContentValues contentValues = smsBean.toContentValues();
        String address = smsBean.getAddress();
        Long lValueOf = this.threadIdMap.get(address);
        if (lValueOf == null) {
            lValueOf = Long.valueOf(SmsThreadsHandle.getOrCreateThreadId(this.mContext, address));
            this.threadIdMap.put(address, lValueOf);
        }
        contentValues.put(CrashHianalyticsData.THREAD_ID, lValueOf);
        if (smsBean.getExtParams() != null) {
            String str = smsBean.getExtParams().get("seen");
            String str2 = smsBean.getExtParams().get("status");
            String str3 = smsBean.getExtParams().get("protocol");
            String str4 = smsBean.getExtParams().get("locked");
            String str5 = smsBean.getExtParams().get("error_code");
            String str6 = smsBean.getExtParams().get("date_sent");
            String str7 = smsBean.getExtParams().get(CallLogCons.SUBID);
            String str8 = smsBean.getExtParams().get("network_type");
            dealWithSSPL(str, str2, str3, str4, contentValues);
            dealWithEDSN(str5, str6, str7, str8, contentValues);
        } else {
            contentValues.put("seen", (Integer) 1);
        }
        if (this.isSupportBulkinsert) {
            contentValues.put("HW_KOBACKUP_BULKINSERT_END", Boolean.FALSE);
        }
        return contentValues;
    }

    private void toSmsBeans(Cursor cursor, List<SmsBean> list) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        this.hasNetWorkType = cursor.getColumnIndex("network_type") != -1;
        this.hasSubID = cursor.getColumnIndex(CallLogCons.SUBID) != -1;
        do {
            long j10 = cursor.getInt(cursor.getColumnIndex("_id"));
            String string = cursor.getString(cursor.getColumnIndex(CrashHianalyticsData.THREAD_ID));
            String string2 = cursor.getString(cursor.getColumnIndex(C5799g0.f25867g));
            long j11 = cursor.getLong(cursor.getColumnIndex(CallLogCons.DATE));
            int i10 = cursor.getInt(cursor.getColumnIndex("read"));
            int i11 = cursor.getInt(cursor.getColumnIndex("type"));
            String string3 = cursor.getString(cursor.getColumnIndex("body"));
            if (string2 != null && !string2.isEmpty()) {
                this.threadIdMap.put(string2, Long.valueOf(C0241z.m1688f(string)));
            }
            if (4 == i11 || 6 == i11) {
                i11 = 2;
            }
            SmsBean smsBean = new SmsBean();
            smsBean.setId(String.valueOf(j10));
            smsBean.setThreadId(string);
            smsBean.setAddress(string2);
            smsBean.setDate(j11);
            smsBean.setRead(i10);
            smsBean.setType(i11);
            smsBean.setBody(string3);
            String string4 = cursor.getString(cursor.getColumnIndex("seen"));
            String string5 = cursor.getString(cursor.getColumnIndex("status"));
            String string6 = cursor.getString(cursor.getColumnIndex("protocol"));
            String string7 = cursor.getString(cursor.getColumnIndex("locked"));
            String string8 = cursor.getString(cursor.getColumnIndex("error_code"));
            int i12 = i11;
            long j12 = cursor.getLong(cursor.getColumnIndex("date_sent"));
            HashMap map = new HashMap();
            map.put("seen", string4);
            map.put("status", string5);
            map.put("protocol", string6);
            map.put("locked", string7);
            map.put("error_code", string8);
            map.put("date_sent", String.valueOf(j12));
            if (this.hasNetWorkType) {
                map.put("network_type", cursor.getString(cursor.getColumnIndex("network_type")));
            }
            if (this.hasSubID) {
                map.put(CallLogCons.SUBID, cursor.getString(cursor.getColumnIndex(CallLogCons.SUBID)));
            }
            smsBean.setExtParams(map);
            if (3 != i12) {
                list.add(smsBean);
            }
        } while (cursor.moveToNext());
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x01cf, code lost:
    
        r0 = "C" + java.lang.String.valueOf(r4.getResult());
        sendMsg(r32, 1104, r14, r8);
        r3.setFailReason(r4.getInfo());
        p514o9.C11839m.m70688i(com.huawei.android.hicloud.clouddisk.logic.sms.BackupSmsImp.TAG, "backup sms fail,reason is " + r4.getInfo());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hicloud.base.bean.CloudDiskModuleRst onBackup(md.C11439b.a r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 677
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.clouddisk.logic.sms.BackupSmsImp.onBackup(md.b$a, java.lang.String):com.huawei.hicloud.base.bean.CloudDiskModuleRst");
    }

    public CloudDiskModuleRst onRestore(ModuleItem moduleItem, C11439b.a aVar, String str) throws Throwable {
        String str2;
        String str3;
        String str4;
        CloudDiskModuleRst cloudDiskModuleRst;
        String str5;
        String str6;
        String str7;
        CloudDiskModuleRst cloudDiskModuleRst2;
        String str8;
        LinkedHashMap linkedHashMap;
        int i10;
        int i11;
        List<SmsBean> list;
        String str9 = str;
        String str10 = "CLOUDBACKUP_RESTORENUM_SUCESS_SMS";
        String str11 = "CLOUDBACKUP_RESTORENUM_ALL_SMS";
        String str12 = "";
        String deviceID = moduleItem.getDeviceID();
        int deviceType = moduleItem.getDeviceType();
        setMode(this.mContext);
        String str13 = TAG;
        C11839m.m70688i(TAG, "onRestore start!");
        CloudDiskModuleRst cloudDiskModuleRst3 = new CloudDiskModuleRst();
        this.restoredNum = 0;
        this.totalNum = 0;
        this.noChangeNum = 0;
        this.msgId = 0;
        int i12 = 1;
        List<SmsBean> localSmsList = getLocalSmsList("0", null, 1);
        this.isSupportBulkinsert = isSupportBulkinsert(this.mContext);
        int i13 = 0;
        while (!aVar.m68523b()) {
            try {
                C11322a c11322a = new C11322a(str9);
                int i14 = this.msgId + i12;
                this.msgId = i14;
                List<SmsBean> list2 = localSmsList;
                String str14 = str11;
                int i15 = i12;
                try {
                    CBSRecoverSmsAndCallResp cBSRecoverSmsAndCallRespM68007N = c11322a.m68007N(deviceID, deviceType, Long.MAX_VALUE, i14, NavigationUtils.SMS_SCHEMA_PREF);
                    if (this.msgId == i15) {
                        try {
                            this.totalNum = cBSRecoverSmsAndCallRespM68007N.getTotal();
                            linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("downloadInfo", (moduleItem.getDisplayName() != null ? moduleItem.getDisplayName() : "Other") + ": " + String.valueOf(this.totalNum));
                            cloudDiskModuleRst2 = cloudDiskModuleRst3;
                            str8 = str13;
                            str6 = str12;
                            i10 = i15;
                            str7 = str10;
                            str4 = str14;
                        } catch (C9721b e10) {
                            e = e10;
                            cloudDiskModuleRst2 = cloudDiskModuleRst3;
                            str8 = str13;
                            str6 = str12;
                            str7 = str10;
                            str4 = str14;
                            str3 = str7;
                            cloudDiskModuleRst = cloudDiskModuleRst2;
                            str5 = str8;
                            str2 = str6;
                            C11839m.m70687e(str5, "restore sms fail: " + e.toString());
                            cloudDiskModuleRst.setRetCode(e.m60659c());
                            cloudDiskModuleRst.setFailReason(e.getMessage());
                            CloudDiskModuleRst restoreRst = getRestoreRst(cloudDiskModuleRst, aVar);
                            this.threadIdMap.clear();
                            C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                            UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                            C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                            UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                            return restoreRst;
                        } catch (Throwable th2) {
                            th = th2;
                            str6 = str12;
                            str7 = str10;
                            str4 = str14;
                            str3 = str7;
                            str2 = str6;
                            this.threadIdMap.clear();
                            C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                            UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                            C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                            UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                            throw th;
                        }
                        try {
                            try {
                                C10812z.m65839h(this.mContext, NavigationUtils.SMS_SCHEMA_PREF, 0, "", "", "03010", "more_data_restore", str, linkedHashMap, true);
                            } catch (C9721b e11) {
                                e = e11;
                                str3 = str7;
                                cloudDiskModuleRst = cloudDiskModuleRst2;
                                str5 = str8;
                                str2 = str6;
                                C11839m.m70687e(str5, "restore sms fail: " + e.toString());
                                cloudDiskModuleRst.setRetCode(e.m60659c());
                                cloudDiskModuleRst.setFailReason(e.getMessage());
                                CloudDiskModuleRst restoreRst2 = getRestoreRst(cloudDiskModuleRst, aVar);
                                this.threadIdMap.clear();
                                C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                                UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                                C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                                UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                                return restoreRst2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str3 = str7;
                            str2 = str6;
                            this.threadIdMap.clear();
                            C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                            UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                            C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                            UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                            throw th;
                        }
                    } else {
                        cloudDiskModuleRst2 = cloudDiskModuleRst3;
                        str8 = str13;
                        str6 = str12;
                        i10 = i15;
                        str7 = str10;
                        str4 = str14;
                    }
                    if (aVar.m68523b()) {
                        str5 = str8;
                        try {
                            C11839m.m70688i(str5, "RestoreSmsTask is aborted after request");
                            cloudDiskModuleRst = cloudDiskModuleRst2;
                            try {
                                cloudDiskModuleRst.setRetCode(3);
                                CloudDiskModuleRst restoreRst3 = getRestoreRst(cloudDiskModuleRst, aVar);
                                this.threadIdMap.clear();
                                Context context = this.mContext;
                                StringBuilder sb2 = new StringBuilder();
                                String str15 = str6;
                                sb2.append(str15);
                                sb2.append(this.totalNum);
                                C13223b.m79473a(context, str4, sb2.toString());
                                UBAAnalyze.m29949J("CKC", str4, "value", str15 + this.totalNum);
                                String str16 = str7;
                                C13223b.m79473a(this.mContext, str16, (this.restoredNum + this.noChangeNum) + str15);
                                UBAAnalyze.m29949J("CKC", str16, "value", (this.restoredNum + this.noChangeNum) + str15);
                                return restoreRst3;
                            } catch (C9721b e12) {
                                e = e12;
                                str3 = str7;
                                str2 = str6;
                                C11839m.m70687e(str5, "restore sms fail: " + e.toString());
                                cloudDiskModuleRst.setRetCode(e.m60659c());
                                cloudDiskModuleRst.setFailReason(e.getMessage());
                                CloudDiskModuleRst restoreRst22 = getRestoreRst(cloudDiskModuleRst, aVar);
                                this.threadIdMap.clear();
                                C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                                UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                                C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                                UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                                return restoreRst22;
                            }
                        } catch (C9721b e13) {
                            e = e13;
                            str3 = str7;
                            cloudDiskModuleRst = cloudDiskModuleRst2;
                        }
                    } else {
                        str3 = str7;
                        cloudDiskModuleRst = cloudDiskModuleRst2;
                        str5 = str8;
                        str2 = str6;
                        if (i13 == 0) {
                            try {
                                try {
                                    i11 = 0;
                                    C11046a.m66594b(aVar, C11046a.m66595c(this.totalNum, NavigationUtils.SMS_SCHEMA_PREF, false));
                                    i13 = i10;
                                } catch (C9721b e14) {
                                    e = e14;
                                    C11839m.m70687e(str5, "restore sms fail: " + e.toString());
                                    cloudDiskModuleRst.setRetCode(e.m60659c());
                                    cloudDiskModuleRst.setFailReason(e.getMessage());
                                    CloudDiskModuleRst restoreRst222 = getRestoreRst(cloudDiskModuleRst, aVar);
                                    this.threadIdMap.clear();
                                    C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                                    UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                                    C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                                    UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                                    return restoreRst222;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                this.threadIdMap.clear();
                                C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                                UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                                C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                                UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                                throw th;
                            }
                        } else {
                            i11 = 0;
                        }
                        int more = cBSRecoverSmsAndCallRespM68007N.getMore();
                        if (cBSRecoverSmsAndCallRespM68007N.getResult() != 0) {
                            sendMsg(aVar, 1106, this.restoredNum + this.noChangeNum, this.totalNum);
                            cloudDiskModuleRst.setRetCode(-1);
                            cloudDiskModuleRst.setFailReason(cBSRecoverSmsAndCallRespM68007N.getInfo());
                            C11839m.m70688i(str5, "RestoreSms succeed partly,succeedNum is " + this.restoredNum + ",failedNum is" + ((this.totalNum - this.restoredNum) - this.noChangeNum));
                            CloudDiskModuleRst restoreRst4 = getRestoreRst(cloudDiskModuleRst, aVar);
                            this.threadIdMap.clear();
                            C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                            UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                            C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                            UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                            return restoreRst4;
                        }
                        C11839m.m70688i(str5, "RestoreSmsTask response ok");
                        int i16 = this.totalNum;
                        if (i16 == 0) {
                            sendMsg(aVar, 1106, this.restoredNum + this.noChangeNum, i16);
                            C11839m.m70688i(str5, "list is empty,no change occurred");
                            cloudDiskModuleRst.setRetCode(i10);
                            cloudDiskModuleRst.setFailReason("list is empty,no change occurred");
                            CloudDiskModuleRst restoreRst5 = getRestoreRst(cloudDiskModuleRst, aVar);
                            this.threadIdMap.clear();
                            C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                            UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                            C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                            UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                            return restoreRst5;
                        }
                        ArrayList<SmsBean> smsList = cBSRecoverSmsAndCallRespM68007N.getSmsList();
                        if (smsList == null || smsList.isEmpty()) {
                            list = list2;
                            str9 = str;
                        } else {
                            C11839m.m70688i(str5, "RestoreSms result list size is " + smsList.size());
                            list = list2;
                            str9 = str;
                            insertToDB(smsList, list, str9);
                        }
                        sendMsg(aVar, 1106, this.restoredNum + this.noChangeNum, this.totalNum);
                        if (more == 0) {
                            C11839m.m70688i(str5, "RestoreSms finished");
                            cloudDiskModuleRst.setRetCode(i11);
                            CloudDiskModuleRst restoreRst6 = getRestoreRst(cloudDiskModuleRst, aVar);
                            this.threadIdMap.clear();
                            C13223b.m79473a(this.mContext, str4, str2 + this.totalNum);
                            UBAAnalyze.m29949J("CKC", str4, "value", str2 + this.totalNum);
                            C13223b.m79473a(this.mContext, str3, (this.restoredNum + this.noChangeNum) + str2);
                            UBAAnalyze.m29949J("CKC", str3, "value", (this.restoredNum + this.noChangeNum) + str2);
                            return restoreRst6;
                        }
                        cloudDiskModuleRst3 = cloudDiskModuleRst;
                        str12 = str2;
                        i12 = 1;
                        str13 = str5;
                        String str17 = str4;
                        str10 = str3;
                        localSmsList = list;
                        str11 = str17;
                    }
                } catch (C9721b e15) {
                    e = e15;
                    cloudDiskModuleRst = cloudDiskModuleRst3;
                    str5 = str13;
                    str2 = str12;
                    str3 = str10;
                    str4 = str14;
                } catch (Throwable th5) {
                    th = th5;
                    str2 = str12;
                    str3 = str10;
                    str4 = str14;
                }
            } catch (C9721b e16) {
                e = e16;
                cloudDiskModuleRst = cloudDiskModuleRst3;
                str5 = str13;
                str2 = str12;
                str3 = str10;
                str4 = str11;
            } catch (Throwable th6) {
                th = th6;
                str2 = str12;
                str3 = str10;
                str4 = str11;
            }
        }
        cloudDiskModuleRst3.setRetCode(3);
        C11839m.m70688i(str13, "RestoreSmsTask is aborted");
        CloudDiskModuleRst restoreRst7 = getRestoreRst(cloudDiskModuleRst3, aVar);
        this.threadIdMap.clear();
        C13223b.m79473a(this.mContext, str11, str12 + this.totalNum);
        UBAAnalyze.m29949J("CKC", str11, "value", str12 + this.totalNum);
        C13223b.m79473a(this.mContext, str10, (this.restoredNum + this.noChangeNum) + str12);
        UBAAnalyze.m29949J("CKC", str10, "value", (this.restoredNum + this.noChangeNum) + str12);
        return restoreRst7;
    }
}
