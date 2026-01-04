package com.huawei.android.hicloud.clouddisk.logic.calllogs;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.provider.CallLog;
import android.text.TextUtils;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSRecoverSmsAndCallResp;
import com.huawei.hicloud.request.cbs.bean.CallLogBean;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C10812z;
import ke.C11046a;
import md.C11439b;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0214f0;
import p015ak.C0241z;
import p458lo.C11322a;
import p514o9.C11839m;
import p684un.C13223b;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class BackupCallLogsImp {
    private static final String TAG = "BackupCallLogsImp";
    private Context mContext;
    private SharedPreferences sharedPre;
    private int restoredNum = 0;
    private int noChangeNum = 0;
    private int totalNum = 0;
    private boolean hasExtendParams = false;
    private boolean hasSubScription = false;
    private ArrayList<CallLogBean> localList = new ArrayList<>();

    public BackupCallLogsImp(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.sharedPre = C0214f0.m1382b(context, "cloudbackup", 0);
    }

    private boolean checkBackupCondition(CloudDiskModuleRst cloudDiskModuleRst) {
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

    private boolean consistWithLocalDb() {
        if (this.localList.isEmpty()) {
            return false;
        }
        String string = this.sharedPre.getString(CallLogCons.CALLNUM, "");
        long j10 = this.sharedPre.getLong(CallLogCons.CALLDATE, 0L);
        long j11 = this.sharedPre.getLong(CallLogCons.CALLDURATION, 0L);
        int i10 = this.sharedPre.getInt(CallLogCons.CALLTYPE, 0);
        boolean z10 = this.sharedPre.getBoolean("isEncrypt", false);
        if (!string.isEmpty() && z10) {
            string = C11477c.m68633c(string);
        }
        return string.equals(this.localList.get(0).getNumber()) && j10 == this.localList.get(0).getDate() && this.localList.get(0).getDuration() == j11 && this.localList.get(0).getType() == i10;
    }

    private boolean existInLocal(CallLogBean callLogBean) {
        Iterator<CallLogBean> it = this.localList.iterator();
        while (it.hasNext()) {
            if (it.next().equal(callLogBean)) {
                return true;
            }
        }
        return false;
    }

    private Map<String, String> getCallLogExtParams(Cursor cursor) {
        HashMap map = new HashMap();
        if (cursor.getColumnIndex(CallLogCons.DATAUSAGE) != -1) {
            map.put(CallLogCons.DATAUSAGE, cursor.getString(cursor.getColumnIndex(CallLogCons.DATAUSAGE)));
        }
        if (cursor.getColumnIndex(CallLogCons.FEATURES) != -1) {
            map.put(CallLogCons.FEATURES, cursor.getString(cursor.getColumnIndex(CallLogCons.FEATURES)));
        }
        if (cursor.getColumnIndex(CallLogCons.SUBCOMPONENTNAME) != -1) {
            map.put(CallLogCons.SUBCOMPONENTNAME, cursor.getString(cursor.getColumnIndex(CallLogCons.SUBCOMPONENTNAME)));
        }
        if (cursor.getColumnIndex(CallLogCons.SUBSCRIPTIONID) != -1) {
            map.put(CallLogCons.SUBSCRIPTIONID, cursor.getString(cursor.getColumnIndex(CallLogCons.SUBSCRIPTIONID)));
        }
        if (cursor.getColumnIndex(CallLogCons.SUBID) != -1) {
            map.put(CallLogCons.SUBID, cursor.getString(cursor.getColumnIndex(CallLogCons.SUBID)));
        }
        if (cursor.getColumnIndex(CallLogCons.TRANSCRIPTION) != -1) {
            map.put(CallLogCons.TRANSCRIPTION, cursor.getString(cursor.getColumnIndex(CallLogCons.TRANSCRIPTION)));
        }
        if (cursor.getColumnIndex(CallLogCons.SUBSCRIPTION) != -1) {
            map.put(CallLogCons.SUBSCRIPTION, cursor.getString(cursor.getColumnIndex(CallLogCons.SUBSCRIPTION)));
        }
        if (cursor.getColumnIndex(CallLogCons.RINGTIME) != -1) {
            map.put(CallLogCons.RINGTIME, cursor.getString(cursor.getColumnIndex(CallLogCons.RINGTIME)));
        }
        return map;
    }

    private void getLocalDBList(String str, boolean z10) {
        Context context;
        Uri uri;
        this.localList.clear();
        String[] strArr = {String.valueOf(str)};
        Cursor cursorQuery = null;
        try {
            try {
                context = this.mContext;
                uri = CallLog.Calls.CONTENT_URI;
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "query callLog exception: " + e10.toString());
                if (0 == 0) {
                    return;
                }
            }
            if (!C0209d.m1227Y1(context, uri)) {
                C11839m.m70687e(TAG, "getLocalDBList, TargetApp is not SystemApp");
                return;
            }
            cursorQuery = z10 ? this.mContext.getContentResolver().query(uri, null, "_id= ?", strArr, "_id ASC") : this.mContext.getContentResolver().query(uri, null, "_id > ?", strArr, "_id ASC");
            if (cursorQuery != null) {
                this.hasExtendParams = isHasExtendParams(cursorQuery);
                this.hasSubScription = cursorQuery.getColumnIndex(CallLogCons.SUBSCRIPTION) != -1;
                if (cursorQuery.moveToFirst()) {
                    do {
                        CallLogBean callLogBean = new CallLogBean();
                        int i10 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("number"));
                        long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex(CallLogCons.DATE));
                        long j11 = cursorQuery.getLong(cursorQuery.getColumnIndex("duration"));
                        int i11 = cursorQuery.getInt(cursorQuery.getColumnIndex("type"));
                        callLogBean.setId(String.valueOf(i10));
                        callLogBean.setNumber(string);
                        callLogBean.setDate(j10);
                        callLogBean.setDuration(j11);
                        callLogBean.setType(i11);
                        callLogBean.setExtParams(getCallLogExtParams(cursorQuery));
                        this.localList.add(callLogBean);
                    } while (cursorQuery.moveToNext());
                }
            }
            if (cursorQuery == null) {
                return;
            }
            cursorQuery.close();
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hicloud.base.bean.CloudDiskModuleRst getRestoreRst(com.huawei.hicloud.base.bean.CloudDiskModuleRst r4, android.os.Handler.Callback r5) {
        /*
            r3 = this;
            int r0 = r3.totalNum
            int r1 = r3.restoredNum
            int r0 = r0 - r1
            int r1 = r3.noChangeNum
            int r0 = r0 - r1
            md.b$a r5 = (md.C11439b.a) r5
            boolean r5 = r5.m68523b()
            if (r5 == 0) goto L12
            r5 = 3
            goto L25
        L12:
            int r5 = r3.restoredNum
            r1 = -1
            if (r5 != 0) goto L1d
            int r2 = r3.noChangeNum
            if (r2 != 0) goto L1d
        L1b:
            r5 = r1
            goto L25
        L1d:
            if (r0 == 0) goto L24
            if (r5 != 0) goto L22
            goto L1b
        L22:
            r5 = 2
            goto L25
        L24:
            r5 = 0
        L25:
            r4.setRetCode(r5)
            int r5 = r3.restoredNum
            r4.setSuccessNum(r5)
            int r5 = r3.noChangeNum
            r4.setNochangeNum(r5)
            r4.setFailNum(r0)
            int r3 = r3.totalNum
            r4.setTotalNum(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.clouddisk.logic.calllogs.BackupCallLogsImp.getRestoreRst(com.huawei.hicloud.base.bean.CloudDiskModuleRst, android.os.Handler$Callback):com.huawei.hicloud.base.bean.CloudDiskModuleRst");
    }

    private void insertIntoLocalDB(ArrayList<CallLogBean> arrayList, String str) throws Throwable {
        String str2;
        String str3;
        LinkedHashMap linkedHashMap;
        C11839m.m70688i(TAG, "Calllog insertIntoLocalDB");
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            CallLogBean callLogBean = arrayList.get(i10);
            if (existInLocal(callLogBean)) {
                this.noChangeNum++;
            } else {
                ContentValues contentValues = callLogBean.toContentValues();
                Map<String, String> extParams = callLogBean.getExtParams();
                List listAsList = Arrays.asList(CallLogCons.extParams());
                if (extParams != null) {
                    for (Map.Entry<String, String> entry : extParams.entrySet()) {
                        if (this.hasSubScription && CallLogCons.SUBSCRIPTION.equals(entry.getKey())) {
                            contentValues.put(CallLogCons.SUBSCRIPTION, entry.getValue());
                        } else if (this.hasExtendParams && listAsList.contains(entry.getKey())) {
                            contentValues.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                arrayList2.add(ContentProviderOperation.newInsert(CallLog.Calls.CONTENT_URI).withValues(contentValues).build());
            }
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            str2 = "";
        }
        try {
            try {
                this.restoredNum += this.mContext.getContentResolver().applyBatch("call_log", arrayList2).length;
                if (!TextUtils.isEmpty("")) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("restoredNum", String.valueOf(this.restoredNum));
                    C10812z.m65839h(this.mContext, "callLog", -1, "", "", "03010", "more_data_restore", str, linkedHashMap2, true);
                }
            } catch (OperationApplicationException e10) {
                str3 = "Exceptoin encoutered while inserting CallAction: " + e10.getMessage();
                C11839m.m70687e(TAG, str3);
                if (!TextUtils.isEmpty(str3)) {
                    linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("restoredNum", String.valueOf(this.restoredNum));
                    C10812z.m65839h(this.mContext, "callLog", -1, "", str3, "03010", "more_data_restore", str, linkedHashMap, true);
                }
            } catch (RemoteException e11) {
                str3 = "Exceptoin encoutered while inserting CallAction: " + e11.getMessage();
                C11839m.m70687e(TAG, str3);
                if (!TextUtils.isEmpty(str3)) {
                    linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("restoredNum", String.valueOf(this.restoredNum));
                    C10812z.m65839h(this.mContext, "callLog", -1, "", str3, "03010", "more_data_restore", str, linkedHashMap, true);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str2 = str3;
            if (!TextUtils.isEmpty(str2)) {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("restoredNum", String.valueOf(this.restoredNum));
                C10812z.m65839h(this.mContext, "callLog", -1, "", str2, "03010", "more_data_restore", str, linkedHashMap3, true);
            }
            throw th;
        }
    }

    private boolean isHasExtendParams(Cursor cursor) {
        return (cursor.getColumnIndex(CallLogCons.DATAUSAGE) == -1 && cursor.getColumnIndex(CallLogCons.FEATURES) == -1 && cursor.getColumnIndex(CallLogCons.SUBCOMPONENTNAME) == -1 && cursor.getColumnIndex(CallLogCons.SUBSCRIPTIONID) == -1 && cursor.getColumnIndex(CallLogCons.SUBID) == -1 && cursor.getColumnIndex(CallLogCons.TRANSCRIPTION) == -1 && cursor.getColumnIndex(CallLogCons.RINGTIME) == -1) ? false : true;
    }

    private void sendMsg(Handler.Callback callback, int i10, int i11, int i12) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i10;
        messageObtain.arg1 = i11;
        messageObtain.arg2 = i12;
        messageObtain.obj = "callLog";
        if (callback != null) {
            callback.handleMessage(messageObtain);
        }
    }

    private String setCallLogStartId() {
        String string = this.sharedPre.getString(CallLogCons.CALLID, "0");
        if (!"0".equals(string)) {
            getLocalDBList(string, true);
            if (!consistWithLocalDb()) {
                C11839m.m70688i(TAG, "calllog consist with local db do not has the same.");
                return "0";
            }
        }
        return string;
    }

    public CloudDiskModuleRst doBackup(C11439b.a aVar, String str) throws Throwable {
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        String callLogStartId = setCallLogStartId();
        C11839m.m70688i(TAG, "do callLog backup startId = " + callLogStartId);
        getLocalDBList(callLogStartId, false);
        int size = this.localList.size();
        C11046a.m66594b(aVar, C11046a.m66595c((long) size, "callLog", true));
        C11839m.m70688i(TAG, "total backup callLog number = " + size);
        C13223b.m79473a(this.mContext, "CLOUDBACKUP_BACKUPNUM_ALL_CALLLOG", "" + size);
        UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_BACKUPNUM_ALL_CALLLOG", "value", "" + size);
        String str2 = "0";
        if (size == 0) {
            cloudDiskModuleRst.setRetCode(1);
            cloudDiskModuleRst.setBiCode("0");
            cloudDiskModuleRst.setFailReason("backup callLogs totalNum is 0,noChange occurred");
            C11839m.m70688i(TAG, "backup callLogs totalNum is 0,noChange occurred");
            return cloudDiskModuleRst;
        }
        if (!checkBackupCondition(cloudDiskModuleRst)) {
            return cloudDiskModuleRst;
        }
        int size2 = this.localList.size() / 100;
        cloudDiskModuleRst.setTotalNum(size);
        CallLogBean callLogBean = null;
        int i10 = 0;
        int size3 = 0;
        int iM1685c = 0;
        while (i10 <= size2) {
            if (aVar.m68523b()) {
                cloudDiskModuleRst.setRetCode(3);
                cloudDiskModuleRst.setBiCode("1");
                cloudDiskModuleRst.setSuccessNum(size3);
                cloudDiskModuleRst.setFailNum(size - size3);
                C11839m.m70688i(TAG, "backup callLogs aborted during");
                return cloudDiskModuleRst;
            }
            ArrayList arrayList = new ArrayList();
            int i11 = size2;
            int i12 = i10 * 100;
            CallLogBean callLogBean2 = callLogBean;
            int iMin = Math.min(i12 + 100, this.localList.size());
            iM1685c = iM1685c;
            String str3 = str2;
            int i13 = i12;
            while (i13 < iMin) {
                int i14 = iMin;
                arrayList.add(this.localList.get(i13));
                CallLogBean callLogBean3 = this.localList.get(i13);
                int i15 = i10;
                if (C0241z.m1685c(callLogBean3.getId()) > iM1685c) {
                    callLogBean2 = callLogBean3;
                    iM1685c = C0241z.m1685c(callLogBean3.getId());
                }
                i13++;
                iMin = i14;
                i10 = i15;
            }
            int i16 = i10;
            if (aVar.m68523b()) {
                cloudDiskModuleRst.setRetCode(3);
                cloudDiskModuleRst.setBiCode("1");
                cloudDiskModuleRst.setSuccessNum(size3);
                cloudDiskModuleRst.setFailNum(size - size3);
                C11839m.m70688i(TAG, "backup callLogs aborted Before upload callLog to CBS");
                return cloudDiskModuleRst;
            }
            if (arrayList.isEmpty() || callLogBean2 == null) {
                str2 = str3;
            } else {
                C11839m.m70686d(TAG, "upload callLog data to CBS server");
                try {
                    new C11322a(str).m68019c(arrayList);
                    if (aVar.m68523b()) {
                        cloudDiskModuleRst.setRetCode(3);
                        cloudDiskModuleRst.setBiCode("1");
                        cloudDiskModuleRst.setSuccessNum(size3);
                        cloudDiskModuleRst.setFailNum(size - size3);
                        C11839m.m70688i(TAG, "backup callLogs aborted Before write to SP");
                        return cloudDiskModuleRst;
                    }
                    size3 += arrayList.size();
                    SharedPreferences.Editor editorEdit = this.sharedPre.edit();
                    editorEdit.putString(CallLogCons.CALLID, callLogBean2.getId());
                    editorEdit.putString(CallLogCons.CALLNUM, C11477c.m68636f(callLogBean2.getNumber()));
                    editorEdit.putLong(CallLogCons.CALLDATE, callLogBean2.getDate());
                    editorEdit.putLong(CallLogCons.CALLDURATION, callLogBean2.getDuration());
                    editorEdit.putInt(CallLogCons.CALLTYPE, callLogBean2.getType());
                    editorEdit.putBoolean("isEncrypt", true);
                    editorEdit.commit();
                    str2 = str3;
                } catch (C9721b e10) {
                    sendMsg(aVar, 1102, i12, size);
                    C10812z.m65838g(this.mContext, "callLog", e10.m60663g(), "102", e10.getMessage(), "03009", "local_upload", str);
                    str2 = "C1";
                }
            }
            sendMsg(aVar, 1101, size3, size);
            C13223b.m79473a(this.mContext, "CLOUDBACKUP_BACKUPNUM_SUCESS_CALLLOG", "" + size3);
            UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_BACKUPNUM_SUCESS_CALLLOG", "value", "" + size3);
            i10 = i16 + 1;
            size2 = i11;
            callLogBean = callLogBean2;
        }
        cloudDiskModuleRst.setBiCode(str2);
        cloudDiskModuleRst.setSuccessNum(size3);
        cloudDiskModuleRst.setFailNum(size - size3);
        if (size == size3) {
            cloudDiskModuleRst.setRetCode(0);
        } else if (size3 == 0) {
            cloudDiskModuleRst.setRetCode(-1);
        } else if (size != size3) {
            cloudDiskModuleRst.setRetCode(2);
        }
        return cloudDiskModuleRst;
    }

    public CloudDiskModuleRst doRestore(ModuleItem moduleItem, C11439b.a aVar, String str) throws Throwable {
        CloudDiskModuleRst cloudDiskModuleRst;
        String str2;
        C11839m.m70686d(TAG, "onRestore start!");
        String deviceID = moduleItem.getDeviceID();
        int deviceType = moduleItem.getDeviceType();
        CloudDiskModuleRst cloudDiskModuleRst2 = new CloudDiskModuleRst();
        this.restoredNum = 0;
        this.totalNum = 0;
        this.noChangeNum = 0;
        getLocalDBList("0", false);
        int i10 = 0;
        boolean z10 = false;
        while (!aVar.m68523b()) {
            try {
                int i11 = i10 + 1;
                CBSRecoverSmsAndCallResp cBSRecoverSmsAndCallRespM68007N = new C11322a(str).m68007N(deviceID, deviceType, Long.MAX_VALUE, i11, "callLog");
                if (aVar.m68523b()) {
                    C11839m.m70688i(TAG, "RestoreCallLogTask is Aborted after request");
                    cloudDiskModuleRst2.setRetCode(3);
                    return getRestoreRst(cloudDiskModuleRst2, aVar);
                }
                if (cBSRecoverSmsAndCallRespM68007N.getResult() != 0) {
                    CloudDiskModuleRst cloudDiskModuleRst3 = cloudDiskModuleRst2;
                    cloudDiskModuleRst3.setRetCode(-1);
                    String info = cBSRecoverSmsAndCallRespM68007N.getInfo();
                    cloudDiskModuleRst3.setFailReason(info);
                    C11839m.m70688i(TAG, "RestoreCallLog failed:" + info);
                    return getRestoreRst(cloudDiskModuleRst3, aVar);
                }
                C11839m.m70688i(TAG, "RestoreCallLogTask response ok");
                int more = cBSRecoverSmsAndCallRespM68007N.getMore();
                if (z10) {
                    str2 = deviceID;
                    cloudDiskModuleRst = cloudDiskModuleRst2;
                } else {
                    int total = cBSRecoverSmsAndCallRespM68007N.getTotal();
                    this.totalNum = total;
                    C11046a.m66594b(aVar, C11046a.m66595c(total, "callLog", false));
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("downloadInfo", (moduleItem.getDisplayName() != null ? moduleItem.getDisplayName() : "Other") + ": " + String.valueOf(this.totalNum));
                    str2 = deviceID;
                    cloudDiskModuleRst = cloudDiskModuleRst2;
                    try {
                        C10812z.m65839h(this.mContext, "callLog", 0, "", "", "03010", "more_data_restore", str, linkedHashMap, true);
                        z10 = true;
                    } catch (C9721b e10) {
                        e = e10;
                        C11839m.m70687e(TAG, "restore calllog fail , CException = " + e.getMessage());
                        cloudDiskModuleRst.setFailReason(e.getMessage());
                        return getRestoreRst(cloudDiskModuleRst, aVar);
                    }
                }
                ArrayList<CallLogBean> callLogList = cBSRecoverSmsAndCallRespM68007N.getCallLogList();
                if (callLogList != null && !callLogList.isEmpty()) {
                    C11839m.m70688i(TAG, "RestoreCallLog result list size is " + callLogList.size());
                    insertIntoLocalDB(callLogList, str);
                    sendMsg(aVar, 1103, this.restoredNum + this.noChangeNum, this.totalNum);
                    if (more == 0) {
                        C13223b.m79473a(this.mContext, "CLOUDBACKUP_RESTORENUM_ALL_CALLLOG", "" + this.totalNum);
                        UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_RESTORENUM_ALL_CALLLOG", "value", "" + this.totalNum);
                        C13223b.m79473a(this.mContext, "CLOUDBACKUP_RESTORENUM_SUCESS_CALLLOG", (this.restoredNum + this.noChangeNum) + "");
                        UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_RESTORENUM_SUCESS_CALLLOG", "value", (this.restoredNum + this.noChangeNum) + "");
                        cloudDiskModuleRst.setRetCode(0);
                        C11839m.m70688i(TAG, "RestoreCallLog finished");
                        return getRestoreRst(cloudDiskModuleRst, aVar);
                    }
                    cloudDiskModuleRst2 = cloudDiskModuleRst;
                    i10 = i11;
                    deviceID = str2;
                }
                C13223b.m79473a(this.mContext, "CLOUDBACKUP_RESTORENUM_ALL_CALLLOG", "" + this.totalNum);
                UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_RESTORENUM_ALL_CALLLOG", "value", "" + this.totalNum);
                C13223b.m79473a(this.mContext, "CLOUDBACKUP_RESTORENUM_SUCESS_CALLLOG", (this.restoredNum + this.noChangeNum) + "");
                UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_RESTORENUM_SUCESS_CALLLOG", "value", (this.restoredNum + this.noChangeNum) + "");
                cloudDiskModuleRst.setRetCode(1);
                cloudDiskModuleRst.setFailReason("RestoreCallLog result list is empty,no change occurred");
                C11839m.m70688i(TAG, "RestoreCallLog result list is empty,no change occurred");
                return getRestoreRst(cloudDiskModuleRst, aVar);
            } catch (C9721b e11) {
                e = e11;
                cloudDiskModuleRst = cloudDiskModuleRst2;
            }
        }
        C11839m.m70688i(TAG, "RestoreCallLogTask is Aborted");
        cloudDiskModuleRst2.setRetCode(3);
        return getRestoreRst(cloudDiskModuleRst2, aVar);
    }
}
