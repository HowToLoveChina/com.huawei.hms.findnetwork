package com.huawei.android.hicloud.sync.contact;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import bd.C1164a;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.security.bean.DataDecryptReq;
import com.huawei.android.hicloud.security.bean.DataEncryptReq;
import com.huawei.android.hicloud.security.bean.EncryptedData;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo;
import com.huawei.android.hicloud.sync.protocol.C2924c;
import com.huawei.android.hicloud.sync.protocol.C2925d;
import com.huawei.android.hicloud.sync.protocol.C2926e;
import com.huawei.android.hicloud.sync.protocol.C2930i;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.sync.service.aidl.Ctag;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible;
import com.huawei.android.hicloud.sync.service.aidl.Etag;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.AssetList;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchDeleteResponse;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchRecordsRequest;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchRecordsResponse;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.ChangeList;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRecord;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.IdList;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Lock;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Resource;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Assets;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Changes;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.CloudSyncBatch;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Locks;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Records;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.Cipher;
import com.huawei.hicloud.base.drive.model.Error;
import com.huawei.hicloud.base.drive.model.ErrorDetail;
import com.huawei.hicloud.base.drive.model.KeyChain;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.request.basic.bean.PostOpDescReq;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.hms.support.sms.common.ReadSmsConstant;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import io.C10582a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import je.C10812z;
import md.C11439b;
import md.C11440c;
import org.json.JSONException;
import org.json.JSONObject;
import p012ab.C0087b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0237v;
import p015ak.C0241z;
import p020ap.C1007b;
import p020ap.C1008c;
import p225dd.C9065a;
import p225dd.C9071g;
import p237du.C9310c;
import p255ed.C9445a;
import p255ed.C9446b;
import p255ed.C9447c;
import p255ed.C9448d;
import p255ed.C9450f;
import p255ed.C9451g;
import p255ed.C9452h;
import p255ed.C9453i;
import p283fa.C9679b;
import p286fd.C9683a;
import p429kk.C11060c;
import p514o9.C11839m;
import p517oc.C11846a;
import p551pc.C12127a;
import p572qb.C12316j0;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p664u0.C13108a;
import p675uc.C13153a;
import p681uj.C13195l;
import p709vj.C13452e;
import p712vm.C13468a;
import p746wn.C13622a;
import p770xc.C13742e;
import p783xp.AbstractC13844b;
import sc.C12770c;
import sc.C12771d;
import tc.C13007b;

/* loaded from: classes3.dex */
public abstract class SyncProcessBase {
    protected static final String ADD_ATTACHMENT_COUNT = "addAttachmentCount";
    protected static final String ADD_FAIL_LIST = "addFailList";
    protected static final String ADD_SUC_LIST = "addSuccessList";
    protected static final String DELETE_ATTACHMENT_COUNT = "deleteAttachmentCount";
    protected static final int ETAG_CLOUD_DELETE = 2;
    protected static final int ETAG_CLOUD_OHTERS = 1;
    protected static final int FILLNUMBER = 100;
    private static final String FROM_SYNC_ACTIVATE = "from_sync_activate_";
    protected static final int FULL_SYNC = 1;
    protected static final int INCREMENTAL_SYNC = 0;
    protected static final String MODIFY_ATTACHMENT_COUNT = "modifyAttachmentCount";
    protected static final String RECORD_MODE_NORMAL = "normal";
    protected static final String RECORD_MODE_TEMP = "temp";
    protected static final int RECYCLE_STATUS_NORMAL = 2;
    protected static final int RECYCLE_STATUS_RECYCLE = -1;
    private static final String REPORT_SYNC_OP_DESC_FINALLY = ",result:ok";
    private static final String REPORT_SYNC_OP_DESC_FRONT = "service:client,action:dataInit,bus:";
    private static final String REPORT_SYNC_OP_DESC_SECOND = ",scene:";
    private static final long SLEEP_INTERVAL_AFTER_STOP = 3000;
    protected static final String S_ADD = "0";
    protected static final String S_DEL = "2";
    protected static final String S_MOD = "1";
    private static final String TAG = "SyncProcessBase";
    protected static final String UPDATE_FAIL_LIST = "updateFailList";
    protected static final String UPDATE_SUC_LIST = "updateSuccessList";
    private static final Map<String, Map<String, String>> UUID_PREFIX_MAP;
    protected String lockToken;
    private Handler.Callback mCallBack;
    protected Context mContext;
    protected String mDataType;
    protected ReportSyncEndInfo mReportEndInfo;
    protected String mSyncModulePackageName;
    protected final String mSyncType;
    protected final String operationType;
    protected final SyncProtocol protocol;
    protected ConcurrentHashMap<String, Boolean> serverFlowControlEffected;
    protected final String traceId;
    private static Map<String, Map<String, C2926e>> mapModifyRsp = new HashMap();
    private static final Map<String, C13742e> KEEP_LOCK_TASK_MAP = new HashMap();
    protected String mModuleName = "";
    protected final ArrayList<CtagInfo> ctagList = new ArrayList<>();
    protected Map<String, Ctag> cloudCtagMap = new HashMap(16);
    protected Map<String, Etag> cloudEtagMap = new HashMap(512);
    protected boolean isQueryEtagIncremental = false;
    protected boolean hasGetAllCloudEtag = false;
    protected Map<String, C2924c> cloudData = null;
    private C2930i postStructDataRspResult = new C2930i();
    protected volatile FailRet needAbortSync = null;
    protected boolean mIsPartialSuc = false;

    public interface MethodFiled {
    }

    /* renamed from: com.huawei.android.hicloud.sync.contact.SyncProcessBase$a */
    public static class C2874a extends AbstractC12367d {

        /* renamed from: a */
        public String f12754a;

        /* renamed from: b */
        public String f12755b;

        public C2874a(String str, String str2) {
            this.f12754a = str;
            this.f12755b = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i(SyncProcessBase.TAG, "BasicSyncReportTask start");
            C10582a c10582a = new C10582a(this.f12754a);
            PostOpDescReq postOpDescReq = new PostOpDescReq();
            postOpDescReq.setOpDesc(this.f12755b);
            postOpDescReq.setStored(false);
            postOpDescReq.setEventTime(System.currentTimeMillis());
            try {
                C11839m.m70688i(SyncProcessBase.TAG, "BasicSyncReportTask result: " + c10582a.m64915P(postOpDescReq).getResult());
            } catch (Exception e10) {
                C11839m.m70687e(SyncProcessBase.TAG, "BasicSyncReportTask error: " + e10.toString());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_FIX;
        }
    }

    /* renamed from: com.huawei.android.hicloud.sync.contact.SyncProcessBase$b */
    public class C2875b extends AbstractC12367d {

        /* renamed from: a */
        public final int f12756a;

        /* renamed from: b */
        public String f12757b;

        /* renamed from: c */
        public final IOException f12758c;

        /* renamed from: d */
        public final String f12759d;

        public C2875b(String str, IOException iOException, int i10, String str2) {
            this.f12759d = str;
            this.f12758c = iOException;
            this.f12756a = i10;
            this.f12757b = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException, C9721b {
            C11839m.m70688i(SyncProcessBase.TAG, "begin clearSyncCache");
            String strM18015y = DriveSyncUtil.m18015y(this.f12758c);
            String strM18016z = DriveSyncUtil.m18016z(this.f12758c);
            if (TextUtils.isEmpty(strM18016z)) {
                C11839m.m70689w(SyncProcessBase.TAG, "clearSyncCache serviceName is empty");
                return;
            }
            C11839m.m70688i(SyncProcessBase.TAG, "clearSyncCache scene = " + strM18015y + ", serviceName = " + strM18016z);
            C11440c.m68542u(this.f12759d, this.f12756a);
            if (strM18015y.equals("2")) {
                Intent intent = new Intent();
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.setAction("com.huawei.hicloud.action.CLOSE_SYNC_SWITCH");
                intent.putExtra("syncType", SyncProcessBase.this.mSyncType);
                C11839m.m70688i(SyncProcessBase.TAG, "reSync close switch syncType = " + SyncProcessBase.this.mSyncType + "scene =" + strM18015y);
                C13108a.m78878b(SyncProcessBase.this.mContext.getApplicationContext()).m78881d(intent);
            }
            if (TextUtils.equals(this.f12759d, "notepad")) {
                C11440c.m68542u(NotifyUtil.HI_NOTE_SYNC_TYPE, this.f12756a);
            }
            SyncProcessBase.this.sleepSeconds();
            int iM18004n = DriveSyncUtil.m18004n(SyncProcessBase.this.mContext, this.f12759d);
            C11839m.m70688i(SyncProcessBase.TAG, "clearSyncCache deleteTagInfo: syncType = " + this.f12759d + ", result = " + iM18004n);
            if (TextUtils.equals(this.f12759d, "notepad")) {
                int iM18004n2 = DriveSyncUtil.m18004n(SyncProcessBase.this.mContext, NotifyUtil.HI_NOTE_SYNC_TYPE);
                C11839m.m70688i(SyncProcessBase.TAG, "clearSyncCache deleteTagInfo: special syncType = hinote, result = " + iM18004n2);
                if (iM18004n2 != 0) {
                    C11839m.m70689w(SyncProcessBase.TAG, "clearSyncCache special deleteTagInfo fail");
                    return;
                }
            }
            if (iM18004n != 0) {
                C11839m.m70689w(SyncProcessBase.TAG, "clearSyncCache deleteTagInfo fail");
            } else {
                C11839m.m70688i(SyncProcessBase.TAG, "clearSyncCache report basic");
                SyncProcessBase.this.reportBasic(strM18016z, strM18015y);
            }
        }
    }

    static {
        HashMap map = new HashMap();
        UUID_PREFIX_MAP = map;
        HashMap map2 = new HashMap();
        map2.put("note", "C");
        map2.put("notetag", "D");
        map2.put("shorthand", "E");
        map.put("notepad", map2);
        HashMap map3 = new HashMap();
        map3.put("calendar", "F");
        map.put("calendar", map3);
        HashMap map4 = new HashMap();
        map4.put("bookmark", CloudBackupConstant.UserPackageInfo.GOLD_MEMBER);
        map4.put("infoflow", "H");
        map4.put(FaqConstants.FAQ_CHANNEL, "I");
        map.put("browser", map4);
        HashMap map5 = new HashMap();
        map5.put(HNConstants.DataType.CONTACT, RequestOptions.AD_CONTENT_CLASSIFICATION_J);
        map5.put("group", "K");
        map.put("addressbook", map5);
        HashMap map6 = new HashMap();
        map6.put("atlastag", "L");
        map6.put("face", "M");
        map.put("atlas", map6);
    }

    public SyncProcessBase(Context context, String str, String str2, String str3, String str4, String str5) {
        this.lockToken = "";
        this.mContext = context;
        this.mSyncType = str;
        this.mDataType = str2;
        this.operationType = str3;
        this.traceId = str4;
        this.mSyncModulePackageName = str5;
        this.lockToken = C13007b.m78205Y(context).m78224J(str, this.mSyncModulePackageName);
        this.protocol = new SyncProtocol(context, str, str2, str3, str4, this.mSyncModulePackageName);
    }

    private static void clearMap() {
        mapModifyRsp.clear();
    }

    private void closeStream(InputStream inputStream, OutputStream outputStream, AssetFileDescriptor assetFileDescriptor) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "doEachRestore exception:" + e10.toString());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e11) {
                C11839m.m70687e(TAG, "doEachRestore exception:" + e11.toString());
            }
        }
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (Exception e12) {
                C11839m.m70687e(TAG, "doEachRestore exception:" + e12.toString());
            }
        }
    }

    private LinkedHashMap<String, String> commonUploadInfo(int i10, List<FailRet> list, String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("syncType", this.mSyncType);
        linkedHashMap.put("dataType", this.mDataType);
        linkedHashMap.put("sucSize", String.valueOf(i10));
        linkedHashMap.put("failSize", String.valueOf(list.size()));
        linkedHashMap.put("event", str);
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, list.size() > 0 ? list.get(0).getErrMsg() : "");
        linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
        return linkedHashMap;
    }

    private void doEachItemErr(boolean z10, Map<String, String> map, List<FailRet> list, Map<String, Integer> map2, Map<String, Integer> map3, String str) throws C9722c {
        Integer numValueOf;
        int iProcEachItemErr;
        if (list == null) {
            return;
        }
        C9722c e10 = null;
        for (FailRet failRet : list) {
            if (failRet != null && map != null) {
                String str2 = map.get(failRet.getRecordId());
                if (!TextUtils.isEmpty(str2)) {
                    int errCode = failRet.getErrCode();
                    try {
                        iProcEachItemErr = procEachItemErr(failRet, str);
                    } catch (C9722c e11) {
                        e10 = e11;
                        if (z10) {
                            baseRecordUploadFileFail(map2, map3, str2, errCode);
                        } else if (map2 != null) {
                            numValueOf = Integer.valueOf(errCode);
                        }
                    } catch (Throwable th2) {
                        if (z10) {
                            baseRecordUploadFileFail(map2, map3, str2, errCode);
                        } else if (map2 != null) {
                            map2.put(str2, Integer.valueOf(errCode));
                        }
                        throw th2;
                    }
                    if (z10) {
                        baseRecordUploadFileFail(map2, map3, str2, iProcEachItemErr);
                    } else if (map2 != null) {
                        numValueOf = Integer.valueOf(iProcEachItemErr);
                        map2.put(str2, numValueOf);
                    }
                }
            }
        }
        if (e10 == null) {
            return;
        }
        C11839m.m70687e(TAG, "doEachItemErr throw syncException " + e10.m60666c() + ", msg = " + e10.getMessage());
        throw e10;
    }

    private void doUnlock(String str, String str2) throws C9722c {
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
        if (C13452e.m80781L().m80917g1()) {
            throw new C9722c(1102, "cloudsync error st invalid.", this.mSyncType, "locks_delete");
        }
        if (C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1()) {
            throw new C9722c(2201, "cloudsync error force upgrade.", this.mSyncType, "locks_delete");
        }
        try {
            Locks.Delete delete = c9453iM7268d.m59246e().delete(DriveSyncUtil.m17959D(str));
            DriveSyncUtil.m17992f(this.mContext, this.traceId, this.mSyncType, delete.getHeaders());
            DriveSyncUtil.m17994g(delete.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
            if (TextUtils.isEmpty(str2)) {
                str2 = C13007b.m78205Y(this.mContext).m78224J(str, this.mSyncModulePackageName);
            }
            if (TextUtils.isEmpty(str2)) {
                throw new C9722c(2003, "lock is empty", this.mSyncType, "locks_delete");
            }
            delete.addHeader("x-hw-lock", (Object) str2);
            delete.addHeader("x-hw-channel-Id", (Object) C9310c.m58618b(C13452e.m80781L().m80950o() + "10055832"));
            delete.execute();
            this.lockToken = "";
        } catch (IOException e10) {
            procException(e10, "unlock " + e10.getMessage(), "locks_delete");
        }
    }

    private void fillModeInRecord(List<Record> list, String str) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (Record record : list) {
            if (record != null) {
                record.setMode(str);
            }
        }
    }

    private void getAddOrModifyFailedRecordList(String str, String str2, List<FailRecord> list, List<FailRet> list2, List<Record> list3, String str3) throws C9722c {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (FailRecord failRecord : list) {
                String id2 = failRecord.getId();
                Error error = failRecord.getError();
                FailRet failRet = new FailRet();
                failRet.setRecordId(id2);
                if (error != null) {
                    int iIntValue = error.getCode().intValue();
                    C12316j0.m74076d().m74077a(str, str2, id2, iIntValue);
                    List<ErrorDetail> errorDetail = error.getErrorDetail();
                    if (errorDetail != null && errorDetail.size() > 0) {
                        String errorCode = errorDetail.get(0).getErrorCode();
                        C11839m.m70687e(TAG, "syncV2 recordId: " + id2 + " add or update fail,code:" + iIntValue + ",errorCode: " + errorCode);
                        if (iIntValue == 400 && "41084909".equals(errorCode) && list3 != null) {
                            arrayList.add(failRecord.getId());
                        } else {
                            failRet.setErrCode(Integer.parseInt(errorCode));
                            list2.add(failRet);
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            try {
                ArrayList<Record> recordsDataByIdList = getRecordsDataByIdList(this.mSyncType, this.mDataType, arrayList, "records(id,recycled,version)", str3);
                if (recordsDataByIdList == null || recordsDataByIdList.isEmpty()) {
                    throw new C9722c(2267, "syncV2 recordId exists but get empty");
                }
                list3.addAll(recordsDataByIdList);
                C11839m.m70688i(TAG, "syncV2 recordId exists size: " + recordsDataByIdList.size());
            } catch (C9722c e10) {
                C11839m.m70688i(TAG, "syncV2 recordId exists query error: " + e10.getMessage());
                throw e10;
            }
        }
    }

    private void getDeletedFailedRecordList(List<FailRecord> list, List<String> list2, List<FailRet> list3) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (FailRecord failRecord : list) {
            String id2 = failRecord.getId();
            Error error = failRecord.getError();
            FailRet failRet = new FailRet();
            failRet.setRecordId(id2);
            if (error != null) {
                int iIntValue = error.getCode().intValue();
                List<ErrorDetail> errorDetail = error.getErrorDetail();
                if (errorDetail != null && errorDetail.size() > 0) {
                    if (iIntValue == 404 && "41084041".equals(errorDetail.get(0).getErrorCode())) {
                        C11839m.m70688i(TAG, "syncV2 recordId: " + id2 + " delete errorCode: 41084041");
                        list2.add(id2);
                    } else {
                        C11839m.m70687e(TAG, "syncV2 recordId: " + id2 + " delete fail,errorCode: " + errorDetail.get(0).getErrorCode());
                        failRet.setErrCode(Integer.parseInt(errorDetail.get(0).getErrorCode()));
                        list3.add(failRet);
                    }
                }
            }
        }
    }

    public static Map<String, Map<String, C2926e>> getMapModifyRsp() {
        return mapModifyRsp;
    }

    private boolean isAtInvalid(Exception exc) {
        return DriveSyncUtil.m17975T(401, "0401", exc);
    }

    private boolean isExceedLimit(Exception exc) {
        return DriveSyncUtil.m17975T(403, "4945", exc);
    }

    private boolean isForbiddenUploadSync(Exception exc) {
        return DriveSyncUtil.m17975T(403, "4988", exc);
    }

    private boolean isLockConflict(Exception exc) {
        return DriveSyncUtil.m17975T(409, "4091", exc);
    }

    private boolean isLockExpiredConflict(Exception exc) {
        return DriveSyncUtil.m17975T(403, "4037", exc);
    }

    private boolean isNeedClose(Exception exc) {
        return DriveSyncUtil.m17975T(403, "4989", exc);
    }

    private boolean isNeedReSync(Exception exc) {
        return DriveSyncUtil.m17975T(403, "4977", exc);
    }

    private boolean isNeedRefresh(Exception exc) {
        return DriveSyncUtil.m17975T(403, "4933", exc);
    }

    private boolean isServerControl(Exception exc) {
        return DriveSyncUtil.m17975T(429, "4293", exc);
    }

    private boolean isSpaceNotEnough(Exception exc) {
        return DriveSyncUtil.m17975T(403, "4039", exc);
    }

    private boolean isSupportParticalCallback(int i10) {
        return CloudSyncUtil.m16037p0(i10) || (CloudSyncUtil.m16034o0(i10) && isHasPartialSucData());
    }

    public static boolean isSyncTokenProcess(String str) {
        return ("addressbook".equals(str) || "browser".equals(str) || "calendar".equals(str) || "notepad".equals(str) || "wlan".equals(str)) ? false : true;
    }

    public static Resource onRefreshDownloadUrl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) throws C9722c {
        C11839m.m70688i(TAG, "onRefreshDownloadUrl database :" + str + ", kind :" + str2 + ",recordId:" + str3 + ",assetID:" + str4 + ",versionID:" + str5);
        try {
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(str6);
            DriveSyncUtil.m18002l(str6, "local_download_struct");
            Assets.Revisions.Get get = c9453iM7268d.m59242a().revisions().get(str, str2, str3, str4, str5, "resource,cipher,id,version,versionId");
            DriveSyncUtil.m17994g(get.getHeaders(), str8, str6, str7);
            Asset assetExecute = get.execute();
            DriveSyncUtil.m17985b0(2, get.getLastResponseHeaders());
            if (assetExecute == null) {
                return null;
            }
            return assetExecute.getResource();
        } catch (IOException e10) {
            int iM1685c = !(e10 instanceof C4616s) ? (C0209d.m1208S0(C0213f.m1377a()) && C13468a.m81100c().m81101b()) ? CloudSyncUtil.m16054v0(e10) ? 2102 : 2263 : 2028 : C0241z.m1685c(DriveSyncUtil.m17980Y((C4616s) e10));
            String str10 = "onRefreshDownloadUrl err code =" + iM1685c + ", msg = " + e10.getMessage() + ", versionId = " + str5;
            C11839m.m70688i(TAG, "onRefreshDownloadUrl err " + str10);
            throw new C9722c(iM1685c, str10, str6, str9);
        }
    }

    private void procBatchCreateRequest(String str, String str2, C9453i c9453i, List<Record> list, List<Record> list2, List<FailRet> list3, String str3) throws C9722c, IOException {
        fillModeInRecord(list, str2);
        BatchRecordsRequest batchRecordsRequest = new BatchRecordsRequest();
        batchRecordsRequest.setRecords(list);
        Records.BatchCreate batchCreateAddHeader = c9453i.m59247f().batchCreate(str, this.mDataType, batchRecordsRequest).setMode(str2).addHeader("x-hw-lock", (Object) this.lockToken);
        DriveSyncUtil.m17994g(batchCreateAddHeader.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
        batchCreateAddHeader.setFields2("id,recycled,version");
        BatchRecordsResponse batchRecordsResponseExecute = batchCreateAddHeader.execute();
        if (batchRecordsResponseExecute == null) {
            C11839m.m70688i(TAG, "syncV2 records recordsList is null.");
            return;
        }
        C11839m.m70686d(TAG, "syncV2 dataType: " + this.mDataType + ", procBatchCreateRequest list run: " + batchRecordsResponseExecute.toString());
        List<Record> records = batchRecordsResponseExecute.getRecords();
        if (records != null) {
            C11839m.m70688i(TAG, "syncV2 createRecordsNofile records succ size: " + records.size());
            for (Record record : records) {
                if (record == null) {
                    C11839m.m70687e(TAG, "record is null.");
                } else {
                    list2.add(record);
                }
            }
        }
        getAddOrModifyFailedRecordList(str, this.mDataType, batchRecordsResponseExecute.getFailedRecords(), list3, list2, str3);
    }

    private void procBatchDeleteRequest(String str, C9453i c9453i, List<String> list, List<String> list2, List<FailRet> list3) throws IOException {
        IdList idList = new IdList();
        idList.setIds(list);
        Records.BatchDelete batchDeleteAddHeader = c9453i.m59247f().batchDelete(str, this.mDataType, idList).addHeader("x-hw-lock", (Object) this.lockToken);
        DriveSyncUtil.m17994g(batchDeleteAddHeader.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
        BatchDeleteResponse batchDeleteResponseExecute = batchDeleteAddHeader.execute();
        if (batchDeleteResponseExecute == null) {
            C11839m.m70688i(TAG, "syncV2 records recordsList is null.");
            return;
        }
        C11839m.m70686d(TAG, "syncV2 deleteRecords dataType: " + this.mDataType + ", procBatchDeleteRequest list run: " + batchDeleteResponseExecute.toString());
        List<String> ids = batchDeleteResponseExecute.getIds();
        if (ids != null && ids.size() > 0) {
            C11839m.m70688i(TAG, "syncV2 deleteRecords succ size: " + ids.size());
            for (String str2 : ids) {
                if (str2 == null) {
                    C11839m.m70687e(TAG, "record is null.");
                } else {
                    list2.add(str2);
                }
            }
        }
        getDeletedFailedRecordList(batchDeleteResponseExecute.getFailedRecords(), list2, list3);
    }

    private void procBatchRequest(String str, String str2, C9453i c9453i, List<Record> list, List<Record> list2, List<FailRet> list3, String str3) throws C9722c, IOException {
        fillModeInRecord(list, str2);
        BatchRecordsRequest batchRecordsRequest = new BatchRecordsRequest();
        ArrayList arrayList = new ArrayList();
        for (Record record : list) {
            if (C12316j0.m74076d().m74086k(str, this.mDataType, record.getId())) {
                FailRet failRet = new FailRet();
                failRet.setRecordId(record.getId());
                failRet.setErrCode(SNSCode.Status.GET_FRIEND_LIST_FAIL);
                failRet.setErrMsg("update record not exits, over times");
                list3.add(failRet);
            } else {
                arrayList.add(record);
            }
        }
        batchRecordsRequest.setRecords(arrayList);
        Records.BatchUpdate batchUpdateAddHeader = c9453i.m59247f().batchUpdate(str, this.mDataType, batchRecordsRequest).setMode(str2).addHeader("x-hw-lock", (Object) this.lockToken);
        DriveSyncUtil.m17994g(batchUpdateAddHeader.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
        batchUpdateAddHeader.setFields2("id,recycled,version");
        BatchRecordsResponse batchRecordsResponseExecute = batchUpdateAddHeader.execute();
        if (batchRecordsResponseExecute == null) {
            C11839m.m70688i(TAG, "syncV2 records recordsList is null.");
            return;
        }
        List<Record> records = batchRecordsResponseExecute.getRecords();
        if (records != null) {
            C11839m.m70688i(TAG, "syncV2 updateRecords records succ size: " + records.size());
            for (Record record2 : records) {
                if (record2 == null) {
                    C11839m.m70687e(TAG, "record is null.");
                } else {
                    list2.add(record2);
                }
            }
        }
        getAddOrModifyFailedRecordList(str, this.mDataType, batchRecordsResponseExecute.getFailedRecords(), list3, list2, str3);
    }

    private void procItemAssetDelete(int i10, String str, C9453i c9453i, Map<String, List<Attachment>> map, Map<String, List<String>> map2, List<FailRet> list) throws C9722c, IOException {
        int maxBatchNum = getMaxBatchNum();
        CloudSyncBatch cloudSyncBatchM59243b = c9453i.m59243b();
        int i11 = 0;
        CloudSyncBatch cloudSyncBatchM59243b2 = cloudSyncBatchM59243b;
        int i12 = i10;
        for (Map.Entry<String, List<Attachment>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Attachment> value = entry.getValue();
            if (value == null || value.isEmpty()) {
                C11839m.m70689w(TAG, "syncV2 deleteAssets by asset, recordId or attachment is null, recordId = " + key);
            } else {
                String strM17959D = DriveSyncUtil.m17959D(this.mSyncType);
                for (Attachment attachment : value) {
                    String usage = attachment.getUsage();
                    String assetId = attachment.getAssetId();
                    if (TextUtils.isEmpty(usage) || TextUtils.isEmpty(assetId)) {
                        C11839m.m70689w(TAG, "syncV2 createAssets by asset, usage or asset is null, usage = " + usage);
                        i12 += -1;
                    } else {
                        Assets.Delete delete = (Assets.Delete) c9453i.m59242a().delete(strM17959D, this.mDataType, key, assetId).addHeader("x-hw-lock", this.lockToken);
                        DriveSyncUtil.m17994g(delete.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                        delete.queue(cloudSyncBatchM59243b2, new C9450f(key, usage, map2, list));
                        i11++;
                        if (i11 % maxBatchNum == 0 || i12 == i11) {
                            if (cloudSyncBatchM59243b2.size() > 0) {
                                cloudSyncBatchM59243b2.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                                cloudSyncBatchM59243b2 = c9453i.m59243b();
                            }
                        }
                    }
                }
            }
        }
    }

    public static Map<String, SyncData> queryModuleEtag(String str) {
        HashMap map = new HashMap(16);
        ArrayList<SyncData> arrayListM76650l = new C12771d().m76650l(str);
        if (arrayListM76650l.size() == 0) {
            C11839m.m70688i(TAG, "query local etag, data type: " + str + ", size is 0");
            return map;
        }
        Iterator<SyncData> it = arrayListM76650l.iterator();
        while (it.hasNext()) {
            SyncData next = it.next();
            if (next != null) {
                map.put(next.getLuid(), next);
            }
        }
        C11839m.m70688i(TAG, "query local etag, data type: " + str + ", size: " + map.size());
        return map;
    }

    public void reportBasic(String str, String str2) {
        String str3 = REPORT_SYNC_OP_DESC_FRONT + str + REPORT_SYNC_OP_DESC_SECOND + str2 + REPORT_SYNC_OP_DESC_FINALLY;
        C11839m.m70686d(TAG, "clearSyncCache reportBasic= " + str3);
        C12515a.m75110o().m75175e(new C2874a(this.traceId, str3), true);
    }

    private void saveCloudCtag() {
        this.ctagList.clear();
        C13007b c13007bM78205Y = C13007b.m78205Y(this.mContext);
        HashSet hashSet = new HashSet(this.cloudCtagMap.size());
        for (Map.Entry<String, Ctag> entry : this.cloudCtagMap.entrySet()) {
            String key = entry.getKey();
            hashSet.add(key);
            Ctag value = entry.getValue();
            CtagInfo ctagInfo = new CtagInfo();
            ctagInfo.setCtagName(key);
            ctagInfo.setCtagValue(value.getCtag());
            ctagInfo.setStatus(value.getStatus());
            ctagInfo.setExpired(value.isExpired());
            ctagInfo.setSyncToken(value.getSyncToken());
            this.ctagList.add(ctagInfo);
            c13007bM78205Y.m78265i0(key, value.getCtag());
            c13007bM78205Y.m78269k0(key, value.getStatus());
            c13007bM78205Y.m78267j0(key, value.isExpired());
            c13007bM78205Y.m78227K0(key, value.getSyncToken());
            C11839m.m70686d(TAG, "save cloud ctag, dataType = " + key + ", cloud ctag = " + value.getCtag());
        }
        c13007bM78205Y.m78229L0(this.mSyncType, hashSet);
    }

    private static void setMapModifyRsp(Map<String, Map<String, C2926e>> map) {
        mapModifyRsp = map;
    }

    public void sleepSeconds() throws InterruptedException {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e10) {
            C11839m.m70687e(TAG, "sleepSeconds sleep exception:" + e10.toString());
        }
    }

    private void subscribe(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C12515a.m75110o().m75175e(new C9683a(this.mContext, arrayList, "syncReport", this.traceId), false);
    }

    public void appendBundleParamToSaveResult(Bundle bundle, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("isCloudDataParticalSuc") && jSONObject.getBoolean("isCloudDataParticalSuc")) {
                bundle.putBoolean("isCloudDataParticalSuc", true);
                bundle.putInt("cloudDataParticalErrCode", jSONObject.getInt("cloudDataParticalErrCode"));
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "appendBundleParam err " + e10.getMessage());
        }
    }

    public void appendFailMapToQueryCloud(boolean z10, Bundle bundle, Map<String, Integer> map) {
        if (!z10 || map.isEmpty()) {
            return;
        }
        bundle.putBoolean("isCloudDataParticalSuc", true);
        SerializableMap serializableMap = new SerializableMap();
        serializableMap.setMap(SyncLogicServiceUtil.buildFailErrorCodeMap(map));
        bundle.putSerializable("fail_error_code_map", serializableMap);
        C11839m.m70688i(TAG, this.mDataType + " failMap.size(): " + map.size());
    }

    public void baseBeanParseFailList(List<? extends C11846a> list, List<FailRet> list2, String str) throws C9722c {
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        HashMap map = new HashMap();
        if (list != null && list.size() > 0) {
            for (C11846a c11846a : list) {
                if (c11846a != null) {
                    map.put(c11846a.getGuid(), c11846a.getLuid());
                }
            }
        }
        doEachItemErr(false, map, list2, null, null, str);
    }

    public void baseRecordUploadFileFail(Map<String, Integer> map, Map<String, Integer> map2, String str, int i10) {
        CloudSyncUtil.m15986X0(this.mContext, this.mSyncType, true);
        CloudSyncUtil.m15993a1(this.mContext, this.mSyncType, i10);
        if (SyncLogicService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName) && map2 != null) {
            map2.put(str, Integer.valueOf(i10));
        }
        if (map != null) {
            map.put(str, Integer.valueOf(i10));
        }
    }

    public void baseSyncParseFailList(boolean z10, Map<String, Integer> map, Map<String, Integer> map2, List<SyncData> list, List<FailRet> list2, String str) throws C9722c {
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        HashMap map3 = new HashMap();
        for (SyncData syncData : list) {
            if (syncData != null) {
                map3.put(syncData.getGuid(), syncData.getLuid());
            }
        }
        doEachItemErr(z10, map3, list2, map, map2, str);
    }

    public void checkDataAvaliable(String str, String str2, String str3, String str4) throws C9722c {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "syncv2 uploadData guid is null, luid = " + str2 + ", recordId = " + str);
            throw new C9722c(2245, "syncv2 uploadData guid is null, luid = " + str2 + ", recordId = " + str, this.mSyncType, str4);
        }
        if (TextUtils.isEmpty(str3)) {
            C11839m.m70687e(TAG, "syncv2 uploadData data is null, luid = " + str2 + ", recordId = " + str);
            throw new C9722c(2243, "syncv2 uploadData data is null, luid = " + str2 + ", recordId = " + str, this.mSyncType, str4);
        }
    }

    public void checkGuids(List<String> list, int i10, String str) throws C9722c {
        if (list == null || list.isEmpty()) {
            throw new C9722c(2244, "syncV2 generateIds ids is empty.", this.mSyncType, str);
        }
        if (list.size() != i10) {
            throw new C9722c(2210, "syncV2 generateIds ids count error.", this.mSyncType, str);
        }
    }

    public int checkHasGetAllCloudEtag(int i10) {
        if (i10 != 0 || !isSupportIncrementalQuery() || this.isQueryEtagIncremental || this.hasGetAllCloudEtag) {
            return i10;
        }
        String str = "checkHasGetAllCloudEtag flag not permit, dataType = " + this.mDataType;
        C11839m.m70687e(TAG, str);
        C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 2262, str, this.operationType, "local_pre_sync", this.traceId);
        return 2262;
    }

    public void checkIsHasPartialException(String str) throws C9722c {
        int iM17769b = getPostStructDataRspResult().m17769b();
        String strM17770c = getPostStructDataRspResult().m17770c();
        if (CloudSyncUtil.m16058x0(iM17769b)) {
            try {
                if (isSupportParticalCallback(iM17769b)) {
                    throw new C12127a(iM17769b, "103", str + " partial success, parseJsonToResponse: " + strM17770c, this.mDataType, "POST");
                }
            } finally {
                if (isSupportParticalCallback(iM17769b)) {
                    this.mIsPartialSuc = true;
                }
                getPostStructDataRspResult().m17768a();
            }
        }
    }

    public void checkUploadFileException(Context context, String str, String str2, int i10, int i11) {
        if (i11 == 3001) {
            setPartialResult(SNSCode.Status.HWID_UNLOGIN, "space not enough");
            CloudSyncUtil.m15978T0(context, str);
            C0237v.m1661c();
            if (CloudSyncUtil.m15952G0()) {
                setNeedAbortSyncNow("space already full", SNSCode.Status.HWID_UNLOGIN);
            } else {
                CloudSyncUtil.m15969P(context, str, this.mDataType, str2, i10);
            }
        }
        if (i11 == C0241z.m1685c("4037") || i11 == 41084037) {
            setNeedAbortSyncNow("upload file, lock expired", 901);
        }
    }

    public void clearAssetUploadDb(List<Attachment> list) {
        try {
            C9071g c9071g = new C9071g(C9065a.m57166a());
            Iterator<Attachment> it = list.iterator();
            while (it.hasNext()) {
                Asset asset = it.next().getAsset();
                if (asset != null) {
                    c9071g.m57242g(asset.getId());
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "clearAssetUploadDb exception " + e10.getMessage());
        }
    }

    public List<Attachment> createAssetRevision(String str, String str2, Record record, List<Attachment> list, List<FailRet> list2) throws Throwable {
        String str3;
        StringBuilder sb2;
        String str4;
        CloudSyncBatch cloudSyncBatchM59243b;
        Assets.Revisions.Create create;
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
        String str5 = "sync_upload_file";
        DriveSyncUtil.m18002l(this.mSyncType, "sync_upload_file");
        String strM17959D = DriveSyncUtil.m17959D(this.mSyncType);
        int maxBatchNum = getMaxBatchNum();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                try {
                    CloudSyncBatch cloudSyncBatchM59243b2 = c9453iM7268d.m59243b();
                    int size = list.size();
                    String id2 = record.getId();
                    CloudSyncBatch cloudSyncBatch = cloudSyncBatchM59243b2;
                    int i10 = size;
                    int i11 = 0;
                    for (Attachment attachment : list) {
                        String usage = attachment.getUsage();
                        Asset asset = attachment.getAsset();
                        if (asset == null || TextUtils.isEmpty(usage)) {
                            str4 = strM17959D;
                            str3 = str5;
                            cloudSyncBatchM59243b = cloudSyncBatch;
                            C11839m.m70689w(TAG, "syncV2 createAssets by asset, usage or asset is null, usage = " + usage);
                            i10 += -1;
                        } else {
                            str4 = strM17959D;
                            str3 = str5;
                            cloudSyncBatchM59243b = cloudSyncBatch;
                            try {
                                create = (Assets.Revisions.Create) c9453iM7268d.m59242a().revisions().create(strM17959D, this.mDataType, id2, asset.getId(), "attributes,cipher,createdTime,id,mimeType,modifiedTime,resource,state,version,versionId,status", asset).addHeader("x-hw-lock", this.lockToken);
                                DriveSyncUtil.m17994g(create.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                            } catch (IOException e10) {
                                e = e10;
                            }
                            try {
                                create.queue(cloudSyncBatchM59243b, new C9446b(record, usage, arrayList, list2));
                                i11++;
                            } catch (IOException e11) {
                                e = e11;
                                procException(e, "createAssetRevision", str3);
                                sb2 = new StringBuilder();
                                sb2.append("syncV2 createAssetRevision success size = ");
                                sb2.append(arrayList.size());
                                sb2.append(", fail size = ");
                                sb2.append(list2.size());
                                C11839m.m70688i(TAG, sb2.toString());
                                return arrayList;
                            }
                        }
                        int i12 = i10;
                        int i13 = i11;
                        if ((i13 % maxBatchNum == 0 || i12 == i13) && cloudSyncBatchM59243b.size() > 0) {
                            cloudSyncBatchM59243b.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                            cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                        }
                        cloudSyncBatch = cloudSyncBatchM59243b;
                        str5 = str3;
                        i10 = i12;
                        i11 = i13;
                        strM17959D = str4;
                    }
                    sb2 = new StringBuilder();
                } catch (IOException e12) {
                    e = e12;
                    str3 = str5;
                }
                sb2.append("syncV2 createAssetRevision success size = ");
                sb2.append(arrayList.size());
                sb2.append(", fail size = ");
                sb2.append(list2.size());
                C11839m.m70688i(TAG, sb2.toString());
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                C11839m.m70688i(TAG, "syncV2 createAssetRevision success size = " + arrayList.size() + ", fail size = " + list2.size());
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C11839m.m70688i(TAG, "syncV2 createAssetRevision success size = " + arrayList.size() + ", fail size = " + list2.size());
            throw th;
        }
    }

    public List<Attachment> createAssets(String str, String str2, Record record, List<Attachment> list, List<FailRet> list2) throws Throwable {
        ArrayList arrayList;
        StringBuilder sb2;
        String str3;
        String str4;
        CloudSyncBatch cloudSyncBatchM59243b;
        String str5 = ", fail size = ";
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(str);
        DriveSyncUtil.m18002l(this.mSyncType, "create_record_no_file");
        String strM17959D = DriveSyncUtil.m17959D(this.mSyncType);
        int maxBatchNum = getMaxBatchNum();
        ArrayList arrayList2 = new ArrayList();
        try {
            CloudSyncBatch cloudSyncBatchM59243b2 = c9453iM7268d.m59243b();
            int size = list.size();
            String id2 = record.getId();
            CloudSyncBatch cloudSyncBatch = cloudSyncBatchM59243b2;
            int i10 = size;
            int i11 = 0;
            for (Attachment attachment : list) {
                try {
                    isCancel();
                    if (TextUtils.isEmpty(this.lockToken)) {
                        str3 = str5;
                        arrayList = arrayList2;
                        throw new C9722c(SNSCode.Status.GET_GROUP_LIST_FAIL, "lock is empty", this.mSyncType, "create_record_no_file");
                    }
                    String usage = attachment.getUsage();
                    Asset asset = attachment.getAsset();
                    if (TextUtils.isEmpty(usage) || asset == null) {
                        str3 = str5;
                        str4 = strM17959D;
                        cloudSyncBatchM59243b = cloudSyncBatch;
                        arrayList = arrayList2;
                        C11839m.m70689w(TAG, "syncV2 createAssets by asset, usage or asset is null, usage = " + usage);
                        i10 += -1;
                    } else if (C12316j0.m74076d().m74086k(strM17959D, this.mDataType, record.getId())) {
                        try {
                            FailRet failRet = new FailRet();
                            failRet.setRecordId(record.getId());
                            failRet.setErrCode(SNSCode.Status.GET_FRIEND_LIST_FAIL);
                            failRet.setErrMsg("asset create record not exits, over times");
                            list2.add(failRet);
                            i10--;
                            str3 = str5;
                            str4 = strM17959D;
                            cloudSyncBatchM59243b = cloudSyncBatch;
                            arrayList = arrayList2;
                        } catch (IOException e10) {
                            e = e10;
                            arrayList = arrayList2;
                            try {
                                procException(e, "createAssets", "create_record_no_file");
                                sb2 = new StringBuilder();
                                sb2.append("syncV2 createAssets success size = ");
                                sb2.append(arrayList.size());
                                sb2.append(str5);
                                sb2.append(list2.size());
                                C11839m.m70688i(TAG, sb2.toString());
                                return arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                C11839m.m70688i(TAG, "syncV2 createAssets success size = " + arrayList.size() + str5 + list2.size());
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            arrayList = arrayList2;
                            C11839m.m70688i(TAG, "syncV2 createAssets success size = " + arrayList.size() + str5 + list2.size());
                            throw th;
                        }
                    } else {
                        str3 = str5;
                        cloudSyncBatchM59243b = cloudSyncBatch;
                        try {
                            Assets.Create create = (Assets.Create) c9453iM7268d.m59242a().create(strM17959D, this.mDataType, id2, usage, "attributes,cipher,createdTime,id,mimeType,modifiedTime,resource,state,version,versionId,status", asset).addHeader("x-hw-lock", this.lockToken);
                            DriveSyncUtil.m17994g(create.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                            str4 = strM17959D;
                            arrayList = arrayList2;
                            create.queue(cloudSyncBatchM59243b, new C9445a(strM17959D, this.mDataType, record, usage, arrayList2, list2));
                            i11++;
                        } catch (IOException e11) {
                            e = e11;
                            arrayList = arrayList2;
                            str5 = str3;
                            procException(e, "createAssets", "create_record_no_file");
                            sb2 = new StringBuilder();
                            sb2.append("syncV2 createAssets success size = ");
                            sb2.append(arrayList.size());
                            sb2.append(str5);
                            sb2.append(list2.size());
                            C11839m.m70688i(TAG, sb2.toString());
                            return arrayList;
                        } catch (Throwable th4) {
                            th = th4;
                            arrayList = arrayList2;
                            str5 = str3;
                            C11839m.m70688i(TAG, "syncV2 createAssets success size = " + arrayList.size() + str5 + list2.size());
                            throw th;
                        }
                    }
                    int i12 = i10;
                    int i13 = i11;
                    try {
                        if ((i13 % maxBatchNum == 0 || i12 == i13) && cloudSyncBatchM59243b.size() > 0) {
                            cloudSyncBatchM59243b.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                            cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                        }
                        cloudSyncBatch = cloudSyncBatchM59243b;
                        str5 = str3;
                        i10 = i12;
                        i11 = i13;
                        strM17959D = str4;
                        arrayList2 = arrayList;
                    } catch (IOException e12) {
                        e = e12;
                        str5 = str3;
                        procException(e, "createAssets", "create_record_no_file");
                        sb2 = new StringBuilder();
                        sb2.append("syncV2 createAssets success size = ");
                        sb2.append(arrayList.size());
                        sb2.append(str5);
                        sb2.append(list2.size());
                        C11839m.m70688i(TAG, sb2.toString());
                        return arrayList;
                    } catch (Throwable th5) {
                        th = th5;
                        str5 = str3;
                        C11839m.m70688i(TAG, "syncV2 createAssets success size = " + arrayList.size() + str5 + list2.size());
                        throw th;
                    }
                } catch (IOException e13) {
                    e = e13;
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            arrayList = arrayList2;
            sb2 = new StringBuilder();
        } catch (IOException e14) {
            e = e14;
        } catch (Throwable th7) {
            th = th7;
        }
        sb2.append("syncV2 createAssets success size = ");
        sb2.append(arrayList.size());
        sb2.append(str5);
        sb2.append(list2.size());
        C11839m.m70688i(TAG, sb2.toString());
        return arrayList;
    }

    public Map<String, List<Attachment>> createLostAssetRevision(String str, String str2, Map<String, List<Attachment>> map, List<FailRet> list, String str3) throws C9722c {
        StringBuilder sb2;
        String str4;
        CloudSyncBatch cloudSyncBatch;
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
        DriveSyncUtil.m18002l(this.mSyncType, str3);
        String strM17959D = DriveSyncUtil.m17959D(this.mSyncType);
        int maxBatchNum = getMaxBatchNum();
        HashMap map2 = new HashMap();
        try {
            try {
                C11839m.m70688i(TAG, "syncV2 Refund = createLostAssetRevision, syncType = " + str + ", dataType = " + str2 + ", traceID = " + this.traceId);
                CloudSyncBatch cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                int iM16061z = CloudSyncUtil.m16061z(map);
                this.lockToken = C13007b.m78205Y(this.mContext).m78224J(this.mSyncType, this.mSyncModulePackageName);
                int i10 = 0;
                for (Map.Entry<String, List<Attachment>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<Attachment> value = entry.getValue();
                    if (value != null) {
                        CloudSyncBatch cloudSyncBatchM59243b2 = cloudSyncBatchM59243b;
                        int i11 = iM16061z;
                        int i12 = i10;
                        for (Attachment attachment : value) {
                            String usage = attachment.getUsage();
                            Asset asset = attachment.getAsset();
                            if (asset == null || TextUtils.isEmpty(usage)) {
                                str4 = strM17959D;
                                cloudSyncBatch = cloudSyncBatchM59243b2;
                                C11839m.m70689w(TAG, "syncV2 createAssets by asset, usage or asset is null, usage = " + usage);
                                i11 += -1;
                            } else {
                                String str5 = strM17959D;
                                str4 = strM17959D;
                                cloudSyncBatch = cloudSyncBatchM59243b2;
                                Assets.Revisions.Create create = (Assets.Revisions.Create) c9453iM7268d.m59242a().revisions().create(str5, str2, key, asset.getId(), "attributes,cipher,createdTime,id,mimeType,modifiedTime,resource,state,version,versionId,status", asset).addHeader("x-hw-lock", this.lockToken);
                                DriveSyncUtil.m17994g(create.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                                create.queue(cloudSyncBatch, new C9447c(key, usage, map, map2, list));
                                i12++;
                            }
                            int i13 = i11;
                            int i14 = i12;
                            if ((i14 % maxBatchNum == 0 || i13 == i14) && cloudSyncBatch.size() > 0) {
                                cloudSyncBatch.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                                cloudSyncBatchM59243b2 = c9453iM7268d.m59243b();
                            } else {
                                cloudSyncBatchM59243b2 = cloudSyncBatch;
                            }
                            i11 = i13;
                            i12 = i14;
                            strM17959D = str4;
                        }
                        cloudSyncBatchM59243b = cloudSyncBatchM59243b2;
                        iM16061z = i11;
                        i10 = i12;
                        strM17959D = strM17959D;
                    }
                }
                sb2 = new StringBuilder();
            } catch (IOException e10) {
                procException(e10, "createLostAssetRevision", str3);
                sb2 = new StringBuilder();
            }
            sb2.append("syncV2 Refund result: dataType = ");
            sb2.append(str2);
            sb2.append(", success = ");
            sb2.append(map2.size());
            sb2.append(", fail size = ");
            sb2.append(list.size());
            C11839m.m70688i(TAG, sb2.toString());
            return map2;
        } catch (Throwable th2) {
            C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + str2 + ", success = " + map2.size() + ", fail size = " + list.size());
            throw th2;
        }
    }

    public Map<String, List<Attachment>> createLostAssets(String str, String str2, Map<String, List<Attachment>> map, List<FailRet> list) throws Throwable {
        String str3;
        StringBuilder sb2;
        String str4;
        String str5;
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(str);
        String str6 = "create_record_no_file";
        DriveSyncUtil.m18002l(this.mSyncType, "create_record_no_file");
        String strM17959D = DriveSyncUtil.m17959D(this.mSyncType);
        int maxBatchNum = getMaxBatchNum();
        HashMap map2 = new HashMap();
        try {
            try {
                C11839m.m70688i(TAG, "syncV2 Refund = createLostAssets, syncType = " + str + ", dataType = " + str2 + ", traceID = " + this.traceId);
                CloudSyncBatch cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                int iM16061z = CloudSyncUtil.m16061z(map);
                this.lockToken = C13007b.m78205Y(this.mContext).m78224J(this.mSyncType, this.mSyncModulePackageName);
                int i10 = 0;
                for (Map.Entry<String, List<Attachment>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<Attachment> value = entry.getValue();
                    if (value != null) {
                        int i11 = iM16061z;
                        int i12 = i10;
                        for (Attachment attachment : value) {
                            String usage = attachment.getUsage();
                            Asset asset = attachment.getAsset();
                            if (TextUtils.isEmpty(usage) || asset == null) {
                                str4 = key;
                                str5 = strM17959D;
                                str3 = str6;
                                C11839m.m70689w(TAG, "syncV2 createAssets by asset, usage or asset is null, usage = " + usage);
                                i11 += -1;
                            } else if (C12316j0.m74076d().m74086k(strM17959D, str2, key)) {
                                try {
                                    FailRet failRet = new FailRet();
                                    failRet.setRecordId(key);
                                    failRet.setErrCode(SNSCode.Status.GET_FRIEND_LIST_FAIL);
                                    failRet.setErrMsg("asset create record not exits, over times");
                                    list.add(failRet);
                                    i11--;
                                    str4 = key;
                                    str5 = strM17959D;
                                    str3 = str6;
                                } catch (IOException e10) {
                                    e = e10;
                                    str3 = str6;
                                    procException(e, "createLostAssets", str3);
                                    sb2 = new StringBuilder();
                                    sb2.append("syncV2 Refund result: dataType = ");
                                    sb2.append(str2);
                                    sb2.append(", success size = ");
                                    sb2.append(map2.size());
                                    sb2.append(", fail size = ");
                                    sb2.append(list.size());
                                    C11839m.m70688i(TAG, sb2.toString());
                                    return map2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + str2 + ", success size = " + map2.size() + ", fail size = " + list.size());
                                    throw th;
                                }
                            } else {
                                str4 = key;
                                str5 = strM17959D;
                                Assets.Create create = (Assets.Create) c9453iM7268d.m59242a().create(strM17959D, str2, key, usage, "attributes,cipher,createdTime,id,mimeType,modifiedTime,resource,state,version,versionId,status", asset).addHeader("x-hw-lock", this.lockToken);
                                DriveSyncUtil.m17994g(create.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                                str3 = str6;
                                create.queue(cloudSyncBatchM59243b, new C9448d(str4, usage, map, map2, list));
                                i12++;
                            }
                            int i13 = i11;
                            int i14 = i12;
                            try {
                                if ((i14 % maxBatchNum == 0 || i13 == i14) && cloudSyncBatchM59243b.size() > 0) {
                                    cloudSyncBatchM59243b.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                                    cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                                }
                                i11 = i13;
                                i12 = i14;
                                str6 = str3;
                                strM17959D = str5;
                                key = str4;
                            } catch (IOException e11) {
                                e = e11;
                                procException(e, "createLostAssets", str3);
                                sb2 = new StringBuilder();
                                sb2.append("syncV2 Refund result: dataType = ");
                                sb2.append(str2);
                                sb2.append(", success size = ");
                                sb2.append(map2.size());
                                sb2.append(", fail size = ");
                                sb2.append(list.size());
                                C11839m.m70688i(TAG, sb2.toString());
                                return map2;
                            }
                        }
                        iM16061z = i11;
                        i10 = i12;
                    }
                }
                sb2 = new StringBuilder();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e12) {
            e = e12;
        }
        sb2.append("syncV2 Refund result: dataType = ");
        sb2.append(str2);
        sb2.append(", success size = ");
        sb2.append(map2.size());
        sb2.append(", fail size = ");
        sb2.append(list.size());
        C11839m.m70688i(TAG, sb2.toString());
        return map2;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void createRecords(java.lang.String r20, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record> r21, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record> r22, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet> r23, java.lang.String r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.SyncProcessBase.createRecords(java.lang.String, java.util.List, java.util.List, java.util.List, java.lang.String):void");
    }

    public String decryptDataV2(String str, Record record, String str2) throws C9722c {
        Cipher cipher = record.getCipher();
        DataDecryptReq dataDecryptReq = new DataDecryptReq();
        dataDecryptReq.setEdek(cipher.getKeyChains().get(0).getEkey());
        dataDecryptReq.setSrcData(str2);
        try {
            UserKeyObject userKeyObjectM17964I = DriveSyncUtil.m17964I(str, cipher.getKeyChains().get(0));
            return userKeyObjectM17964I != null ? DriveSyncUtil.m18008r(userKeyObjectM17964I, dataDecryptReq) : "";
        } catch (C9721b e10) {
            throw new C9722c(e10.m60659c(), "syncV2 decryptData fail: " + e10.getMessage() + ", recordId = " + record.getId(), this.mSyncType, "local_download_struct");
        } catch (Exception e11) {
            throw new C9722c(2014, "syncV2 decryptData error: " + e11.getMessage() + ", recordId = " + record.getId(), this.mSyncType, "local_download_struct");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteAssets(java.util.Map<java.lang.String, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment>> r36, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r37, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet> r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.SyncProcessBase.deleteAssets(java.util.Map, java.util.Map, java.util.List):void");
    }

    public void deleteRecords(String str, String str2, List<String> list, List<String> list2, List<FailRet> list3, String str3) throws Throwable {
        StringBuilder sb2;
        int size;
        C11839m.m70688i(TAG, "syncV2 deleteRecords.");
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
        DriveSyncUtil.m18002l(this.mSyncType, str3);
        if (list == null || list.size() <= 0) {
            C11839m.m70689w(TAG, "syncV2 delete records guidList is null,  return");
            return;
        }
        String message = "";
        int i10 = 0;
        try {
            try {
                C11839m.m70688i(TAG, "syncV2 Method = deleteRecords, syncType = " + str + ", dataType = " + this.mDataType + ", traceID = " + this.traceId);
                String strM17959D = DriveSyncUtil.m17959D(str);
                if (list.size() > 0) {
                    for (int maxBatchNum = getMaxBatchNum(); list.size() >= maxBatchNum; maxBatchNum = maxBatchNum) {
                        ArrayList arrayList = new ArrayList(list.subList(0, maxBatchNum));
                        procBatchDeleteRequest(strM17959D, c9453iM7268d, arrayList, list2, list3);
                        isCancel();
                        list.removeAll(arrayList);
                    }
                    if (list.size() > 0) {
                        procBatchDeleteRequest(strM17959D, c9453iM7268d, list, list2, list3);
                        isCancel();
                    }
                }
                C11839m.m70686d(TAG, "syncV2 deleteResult deleteSuccessList: " + list2.toString() + " deleteFail: " + list3.toString());
                C11839m.m70688i(TAG, "syncV2 deleteSuccess size: " + list2.size() + " deleteFail size: " + list3.size());
                reportUploadEvet(0, "", list2.size(), list3, str3);
                reportUploadBIEvet(0, "", list2.size(), list3, "mecloud_sync_data_delete_data");
                sb2 = new StringBuilder();
                sb2.append("syncV2 Method result: dataType = ");
                sb2.append(str2);
                sb2.append(", deleteSucSize = ");
                sb2.append(list2.size());
                sb2.append(", deleteFailSize = ");
                size = list3.size();
            } catch (IOException e10) {
                int iM17961F = DriveSyncUtil.m17961F(e10);
                try {
                    message = e10.getMessage();
                    for (String str4 : list) {
                        FailRet failRet = new FailRet();
                        failRet.setRecordId(str4);
                        failRet.setErrCode(iM17961F);
                        failRet.setErrMsg(e10.getMessage());
                        try {
                            list3.add(failRet);
                        } catch (Throwable th2) {
                            th = th2;
                            i10 = iM17961F;
                            int i11 = i10;
                            String str5 = message;
                            reportUploadEvet(i11, str5, list2.size(), list3, str3);
                            reportUploadBIEvet(i11, str5, list2.size(), list3, "mecloud_sync_data_delete_data");
                            C11839m.m70688i(TAG, "syncV2 Method result: dataType = " + str2 + ", deleteSucSize = " + list2.size() + ", deleteFailSize = " + list3.size());
                            throw th;
                        }
                    }
                    procException(e10, "deleteRecords", str3);
                    reportUploadEvet(iM17961F, message, list2.size(), list3, str3);
                    reportUploadBIEvet(iM17961F, message, list2.size(), list3, "mecloud_sync_data_delete_data");
                    sb2 = new StringBuilder();
                    sb2.append("syncV2 Method result: dataType = ");
                    sb2.append(str2);
                    sb2.append(", deleteSucSize = ");
                    sb2.append(list2.size());
                    sb2.append(", deleteFailSize = ");
                    size = list3.size();
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            sb2.append(size);
            C11839m.m70688i(TAG, sb2.toString());
        } catch (Throwable th4) {
            th = th4;
            int i112 = i10;
            String str52 = message;
            reportUploadEvet(i112, str52, list2.size(), list3, str3);
            reportUploadBIEvet(i112, str52, list2.size(), list3, "mecloud_sync_data_delete_data");
            C11839m.m70688i(TAG, "syncV2 Method result: dataType = " + str2 + ", deleteSucSize = " + list2.size() + ", deleteFailSize = " + list3.size());
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public int deleteTag(String str) throws Throwable {
        ?? r42;
        int iM79133s;
        Context context;
        String str2;
        String str3;
        LinkedHashMap linkedHashMap;
        String message = "";
        String str4 = null;
        try {
        } catch (Throwable th2) {
            th = th2;
            r42 = iM79133s;
        }
        try {
            try {
                iM79133s = C13153a.m79133s(str, this.mContext);
                try {
                    C11839m.m70688i(TAG, "syncV2 syncType:" + str + ",deleteTag state: " + iM79133s);
                    context = this.mContext;
                    str2 = this.mDataType;
                    str3 = this.traceId;
                    linkedHashMap = new LinkedHashMap();
                } catch (SQLException e10) {
                    e = e10;
                    C11839m.m70688i(TAG, "syncV2 syncType:" + str + ",deleteTag SQLException: " + e.getMessage());
                    iM79133s = -2;
                    message = e.getMessage();
                    context = this.mContext;
                    str2 = this.mDataType;
                    str3 = this.traceId;
                    linkedHashMap = new LinkedHashMap();
                    str4 = "03001";
                    C10812z.m65847p(context, str, str2, iM79133s, message, "03001", "delete_tag", str3, linkedHashMap, false);
                    return iM79133s;
                } catch (Exception e11) {
                    e = e11;
                    C11839m.m70688i(TAG, "syncV2 syncType:" + str + ",deleteTag Exception: " + e.getMessage());
                    iM79133s = -1;
                    message = e.getMessage();
                    context = this.mContext;
                    str2 = this.mDataType;
                    str3 = this.traceId;
                    linkedHashMap = new LinkedHashMap();
                    str4 = "03001";
                    C10812z.m65847p(context, str, str2, iM79133s, message, "03001", "delete_tag", str3, linkedHashMap, false);
                    return iM79133s;
                }
            } catch (SQLException e12) {
                e = e12;
            } catch (Exception e13) {
                e = e13;
            }
            str4 = "03001";
            C10812z.m65847p(context, str, str2, iM79133s, message, "03001", "delete_tag", str3, linkedHashMap, false);
            return iM79133s;
        } catch (Throwable th3) {
            th = th3;
            r42 = str4;
            C10812z.m65847p(this.mContext, str, this.mDataType, r42, message, "03001", "delete_tag", this.traceId, new LinkedHashMap(), false);
            throw th;
        }
    }

    public void downloadSetExtraParam(SyncData syncData, Record record) throws JSONException {
        Map<String, Object> attributes;
        if (syncData == null || record == null || record.getAttributes() == null || (attributes = record.getAttributes()) == null || !"calendar".equals(this.mSyncType)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (attributes.get("calendarId") == null && attributes.get("uuid") == null && attributes.get(SyncProtocol.Constant.CALENDAR_UUID) == null) {
                return;
            }
            if (attributes.get("calendarId") != null) {
                jSONObject.put("calendarId", attributes.get("calendarId"));
            }
            if (attributes.get("uuid") != null) {
                jSONObject.put("uuid", attributes.get("uuid"));
            }
            if (attributes.get(SyncProtocol.Constant.CALENDAR_UUID) != null) {
                jSONObject.put(SyncProtocol.Constant.CALENDAR_UUID, attributes.get(SyncProtocol.Constant.CALENDAR_UUID));
            }
            syncData.setExtraParam(jSONObject.toString());
        } catch (JSONException e10) {
            C11839m.m70688i(TAG, "downloadSetExtraParam error: " + e10.getMessage());
        }
    }

    public Record encryptDataV2(String str, Record record, String str2, String str3, String str4, String str5, String str6) throws C9722c, C9721b {
        try {
            String strM83106b = AbstractC13844b.m83106b();
            DataEncryptReq dataEncryptReq = new DataEncryptReq();
            dataEncryptReq.setDek(strM83106b);
            dataEncryptReq.setSrcData(str4);
            if (!TextUtils.isEmpty(DriveSyncUtil.m17970O(this.mSyncModulePackageName)) && !TextUtils.isEmpty(str5)) {
                dataEncryptReq.setSrcExtensionData(str5);
            }
            try {
                String strM17962G = DriveSyncUtil.m17962G(str2);
                if (TextUtils.isEmpty(strM17962G)) {
                    C11839m.m70687e(TAG, "syncV2 error getKeyType null, syncType: " + str2);
                    return null;
                }
                C0087b c0087b = new C0087b(C9679b.m60452d().m60455e());
                EncryptedData encryptedDataM18012v = DriveSyncUtil.m18012v(c0087b.m680c(str, Integer.parseInt(strM17962G), UserKeyBaseReq.KEY_TYPE_AES_128), dataEncryptReq);
                EncryptedData encryptedDataM18012v2 = DriveSyncUtil.m18012v(c0087b.m681d(str, Integer.parseInt(strM17962G), UserKeyBaseReq.KEY_TYPE_AES_256), dataEncryptReq);
                Cipher cipher = new Cipher();
                cipher.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL);
                cipher.setDataType(Integer.valueOf(Integer.parseInt(strM17962G)));
                List<KeyChain> arrayList = new ArrayList<>();
                arrayList.add(getKechain(encryptedDataM18012v.getEdek(), 1, encryptedDataM18012v.getKeyGuid(), UserKeyBaseReq.KEY_TYPE_AES_128_FULL));
                arrayList.add(getKechain(encryptedDataM18012v2.getEdek(), 3, encryptedDataM18012v2.getKeyGuid(), UserKeyBaseReq.KEY_TYPE_AES_256_FULL));
                cipher.setKeyChains(arrayList);
                record.setCipher(cipher);
                Map<String, Object> attributes = record.getAttributes();
                if (attributes == null) {
                    attributes = new HashMap<>();
                }
                String data = encryptedDataM18012v.getData();
                if (TextUtils.isEmpty(data)) {
                    throw new C9721b(2220, "syncV2 encryptData data is null", str6);
                }
                attributes.put("#data", "3|" + data);
                if (str3 != null) {
                    attributes.put(SyncProtocol.Constant.LUID, str3);
                }
                record.setAttributes(attributes);
                if (!TextUtils.isEmpty(encryptedDataM18012v.getExtensionData())) {
                    HashMap map = new HashMap();
                    map.put("extensionData", encryptedDataM18012v.getExtensionData());
                    Map<String, Object> map2 = new HashMap<>();
                    map2.put("attributes", map);
                    record.setAppProperties(map2);
                }
                return record;
            } catch (C9721b e10) {
                String str7 = "syncV2 encrypt fail ekey CException, errorCode = " + e10.m60659c() + ", msg = " + e10.getMessage() + ", recordId = " + record.getId();
                C11839m.m70687e(TAG, str7);
                throw new C9722c(e10.m60659c(), str7, str2, str6);
            } catch (Exception e11) {
                String str8 = "syncV2 encrypt err msg = " + e11.getMessage() + ", recordId = " + record.getId();
                C11839m.m70687e(TAG, str8);
                throw new C9722c(2013, str8, str2, str6);
            }
        } catch (NoSuchAlgorithmException e12) {
            C11839m.m70687e(TAG, "getChallenge exception: " + e12.toString());
            return null;
        }
    }

    public void filterSuc(List<Record> list, List<FailRet> list2, String str) throws C9722c {
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FailRet> it = list2.iterator();
        while (it.hasNext()) {
            FailRet next = it.next();
            if (next != null && DriveSyncUtil.m17976U("4909", next.getErrCode())) {
                arrayList.add(next.getRecordId());
                it.remove();
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        try {
            ArrayList<Record> recordsDataByIdList = getRecordsDataByIdList(this.mSyncType, this.mDataType, arrayList, "records(id,recycled,version)", str);
            if (recordsDataByIdList == null || recordsDataByIdList.isEmpty()) {
                throw new C9722c(2267, "syncV2 recordId exists but get empty");
            }
            list.addAll(recordsDataByIdList);
            C11839m.m70688i(TAG, "syncV2 recordId exists size: " + recordsDataByIdList.size());
        } catch (C9722c e10) {
            C11839m.m70688i(TAG, "syncV2 recordId exists error: " + e10.getMessage());
            throw e10;
        }
    }

    public String generateCtag() {
        return "C" + C2879d.m17348e() + String.valueOf(System.currentTimeMillis());
    }

    public List<String> generateGuids(String str, String str2, Integer num) throws C9722c, IOException {
        ArrayList arrayList = new ArrayList();
        try {
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
            DriveSyncUtil.m18002l(this.mSyncType, "general_id");
            String strM17959D = DriveSyncUtil.m17959D(str);
            if (num.intValue() >= 100) {
                while (num.intValue() / 100 > 0) {
                    Records.GenerateIds generateIds = (Records.GenerateIds) c9453iM7268d.m59247f().generateIds(strM17959D, this.mDataType, 100).addHeader("x-hw-lock", this.lockToken);
                    DriveSyncUtil.m17994g(generateIds.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                    IdList idListExecute = generateIds.execute();
                    if (idListExecute != null && idListExecute.getIds() != null) {
                        arrayList.addAll(idListExecute.getIds());
                    }
                    num = Integer.valueOf(num.intValue() - 100);
                }
            }
            if (num.intValue() > 0) {
                Records.GenerateIds generateIds2 = (Records.GenerateIds) c9453iM7268d.m59247f().generateIds(strM17959D, this.mDataType, num).addHeader("x-hw-lock", this.lockToken);
                DriveSyncUtil.m17994g(generateIds2.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                IdList idListExecute2 = generateIds2.execute();
                if (idListExecute2 != null && idListExecute2.getIds() != null) {
                    arrayList.addAll(idListExecute2.getIds());
                }
            }
        } catch (IOException e10) {
            procException(e10, "generalIds", "general_id");
        }
        return arrayList;
    }

    public String generateUnstructUUID() {
        String strM17348e = C2879d.m17348e();
        Map<String, Map<String, String>> map = UUID_PREFIX_MAP;
        if (map.get(this.mSyncType) != null && map.get(this.mSyncType).get(this.mDataType) != null) {
            return map.get(this.mSyncType).get(this.mDataType) + strM17348e;
        }
        return this.mDataType + "/" + strM17348e;
    }

    public AssetList getAssetList(String str, String str2, String str3) throws C9722c {
        String strM17958C = DriveSyncUtil.m17958C(this.mSyncType);
        try {
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
            DriveSyncUtil.m18002l(this.mSyncType, str3);
            if (TextUtils.isEmpty(str2)) {
                throw new C9722c(2003, "getAssetList usage is empty", this.mSyncType, str3);
            }
            if (C12316j0.m74076d().m74086k(strM17958C, this.mDataType, str)) {
                throw new C9722c(SNSCode.Status.GET_FRIEND_LIST_FAIL, "getAssetList record not exits, over times", this.mSyncType, str3);
            }
            Assets.List list = c9453iM7268d.m59242a().list(strM17958C, this.mDataType, str, str2, "assets(cipher,createdTime,id,keepPolicy,mimeType,modifiedTime,resource,state,version,versionId,lastModifyingUser,scaState,properties,status,appVer)");
            AssetList assetListExecute = list.execute();
            DriveSyncUtil.m17985b0(2, list.getLastResponseHeaders());
            return assetListExecute;
        } catch (IOException e10) {
            if (e10 instanceof C4616s) {
                C12316j0.m74076d().m74077a(strM17958C, this.mDataType, str, ((C4616s) e10).m28322f());
            }
            procException(e10, "getAssetList", str3);
            return null;
        }
    }

    public String getBatchGetFields(String str) {
        return !TextUtils.isEmpty(DriveSyncUtil.m17970O(str)) ? "records(attributes,appProperties,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version)" : "records(attributes,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version)";
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0119, code lost:
    
        if (android.text.TextUtils.isEmpty(r15.getNewStartCursor()) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x011b, code lost:
    
        r7.m78265i0(r14, r15.getNewStartCursor());
        r13 = new com.huawei.android.hicloud.sync.service.aidl.Ctag();
        r13.setCtag(r15.getNewStartCursor());
        r12.cloudCtagMap.put(r14, r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Change> getChangesList(java.lang.String r13, java.lang.String r14, java.lang.String r15) throws fk.C9722c, java.io.IOException {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.SyncProcessBase.getChangesList(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public Ctag getCloudCtag(String str, int i10) {
        Map<String, Ctag> map = this.cloudCtagMap;
        if (map == null) {
            return null;
        }
        if (i10 == 1) {
            return map.get(str);
        }
        C13007b c13007bM78205Y = C13007b.m78205Y(this.mContext);
        return new Ctag(c13007bM78205Y.m78288u(str), c13007bM78205Y.m78292w(str), c13007bM78205Y.m78290v(str), c13007bM78205Y.m78241S(str));
    }

    public LinkedHashMap<String, String> getCommonUploadFileReportInfo(String str, String str2, String str3, String str4, int i10, String str5) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("syncType", this.mSyncType);
        linkedHashMap.put("dataType", this.mDataType);
        linkedHashMap.put("thirdPackageName", DriveSyncUtil.m17965J(this.mSyncType, this.mSyncModulePackageName));
        linkedHashMap.put("thirdPackageVersion", DriveSyncUtil.m17971P(this.mSyncType, this.mSyncModulePackageName));
        if (!TextUtils.isEmpty(str)) {
            linkedHashMap.put(SyncProtocol.Constant.LUID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            linkedHashMap.put("recordId", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMap.put("usageName", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            linkedHashMap.put("assetId", str4);
        }
        linkedHashMap.put("returnCode", String.valueOf(i10));
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str5);
        return linkedHashMap;
    }

    public LinkedHashMap<String, String> getCommonUploadReportInfo(String str, String str2, int i10, String str3) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("syncType", this.mSyncType);
        linkedHashMap.put("dataType", this.mDataType);
        linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
        linkedHashMap.put("thirdPackageName", DriveSyncUtil.m17965J(this.mSyncType, this.mSyncModulePackageName));
        linkedHashMap.put("thirdPackageVersion", DriveSyncUtil.m17971P(this.mSyncType, this.mSyncModulePackageName));
        if (!TextUtils.isEmpty(DriveSyncUtil.m17970O(this.mSyncModulePackageName))) {
            linkedHashMap.put("x-hw-3rdapp-appid", DriveSyncUtil.m17970O(this.mSyncModulePackageName));
        }
        if (!TextUtils.isEmpty(str)) {
            linkedHashMap.put(SyncProtocol.Constant.LUID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            linkedHashMap.put("recordId", str2);
        }
        linkedHashMap.put("returnCode", String.valueOf(i10));
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str3);
        return linkedHashMap;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:421:0x0575
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 9 */
    public void getDataVersion(java.lang.String r35, boolean r36) throws fk.C9722c, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.SyncProcessBase.getDataVersion(java.lang.String, boolean):void");
    }

    public String getDecryptData(String str, Record record) throws C9722c {
        Map<String, Object> attributes = record.getAttributes();
        if (attributes == null) {
            throw new C9722c(2211, "syncV2 attributes null, recordId: " + record.getId(), this.mSyncType, "local_download_struct");
        }
        if (attributes.get("data") != null) {
            String str2 = (String) attributes.get("data");
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            C11839m.m70687e(TAG, "syncV2 cloud decryptData is empty, recordId: " + record.getId());
            throw new C9722c(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "syncV2 cloud decryptData is empty, recordId: " + record.getId(), this.mSyncType, "local_download_struct");
        }
        if (attributes.get("#data") == null) {
            return "";
        }
        String str3 = (String) attributes.get("#data");
        String[] strArrSplit = str3.split("\\|");
        if (strArrSplit.length == 2) {
            str3 = strArrSplit[1];
        }
        if (TextUtils.isEmpty(str3)) {
            C11839m.m70687e(TAG, "syncV2 cloud encryptData is empty, recordId: " + record.getId());
            throw new C9722c(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "syncV2 cloud encryptData is empty, recordId: " + record.getId(), this.mSyncType, "local_download_struct");
        }
        String strDecryptDataV2 = decryptDataV2(str, record, str3);
        if (!TextUtils.isEmpty(strDecryptDataV2)) {
            return strDecryptDataV2;
        }
        C11839m.m70687e(TAG, "syncV2 cloud decryptData is empty, recordId: " + record.getId());
        return strDecryptDataV2;
    }

    public String getDecryptExtensionData(String str, Record record) throws C9722c {
        Map map;
        Map<String, Object> appProperties = record.getAppProperties();
        String str2 = (appProperties == null || (map = (Map) appProperties.get("attributes")) == null || map.get("extensionData") == null) ? null : (String) map.get("extensionData");
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String strDecryptDataV2 = decryptDataV2(str, record, str2);
        if (!TextUtils.isEmpty(strDecryptDataV2)) {
            return strDecryptDataV2;
        }
        throw new C9722c(2014, "syncV2 decryptExtensionData error, recordId: " + record.getId(), this.mSyncType, "local_download_struct");
    }

    public int getErrorCode(int i10) {
        C11839m.m70688i(TAG, "getErrorCode : deleteState = " + i10);
        if (i10 == -3) {
            return 2023;
        }
        if (i10 == -2) {
            return ReadSmsConstant.FAIL;
        }
        if (i10 != 0) {
            return FamilyShareConstants.MessageCode.GO_TO_STORAGE_MANAGE;
        }
        return 0;
    }

    public void getEtag(boolean z10, String str) throws C9722c {
        this.cloudEtagMap.clear();
        this.cloudEtagMap = this.protocol.m17732x(this.mSyncType, this.mDataType, z10, str).mapEtag;
    }

    public KeyChain getKechain(String str, Integer num, String str2, String str3) {
        KeyChain keyChain = new KeyChain();
        keyChain.setEkey(str);
        keyChain.setType(num);
        keyChain.setId(str2);
        keyChain.setAlgorithm(str3);
        return keyChain;
    }

    public String getLocalCtag(String str) {
        ArrayList<CtagInfo> arrayListM76641i = new C12770c().m76641i(new String[]{str});
        if (arrayListM76641i == null || arrayListM76641i.size() == 0 || arrayListM76641i.get(0) == null) {
            return null;
        }
        String ctagValue = arrayListM76641i.get(0).getCtagValue();
        C11839m.m70686d(TAG, "local ctag = " + ctagValue);
        return ctagValue;
    }

    public void getLock(ArrayList<CtagInfoCompatible> arrayList) throws C9722c {
        this.cloudCtagMap.clear();
        String syncType = getSyncType();
        SyncProtocol.CtagResponse ctagResponseM17712d = isSyncTokenProcess() ? this.protocol.m17712d(syncType, true, arrayList) : this.protocol.m17712d(syncType, false, null);
        this.cloudCtagMap = ctagResponseM17712d.mapCtag;
        SyncProtocol.KeepLockResponse keepLockResponse = ctagResponseM17712d.keepLockResponse;
        if (keepLockResponse != null) {
            Map<String, C13742e> map = KEEP_LOCK_TASK_MAP;
            C13742e c13742e = map.get(syncType);
            if (c13742e != null) {
                c13742e.m82588j();
                map.remove(syncType);
            }
            C13742e c13742e2 = new C13742e(this.mContext, this.traceId, this.mSyncModulePackageName, this.protocol, keepLockResponse.interval, syncType);
            c13742e2.m82591m();
            map.put(syncType, c13742e2);
        }
        saveCloudCtag();
    }

    public void getLockV2(String str) throws Throwable {
        String str2;
        String message;
        int iM17961F;
        boolean z10;
        LinkedHashMap linkedHashMap;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Context context;
        C9453i c9453iM7268d;
        Lock lockExecute;
        Integer lockInterval;
        String str8;
        String str9 = "locks_get";
        Integer num = -1;
        Lock lock = new Lock();
        try {
            c9453iM7268d = C1164a.m7265f().m7268d(str);
            DriveSyncUtil.m18002l(this.mSyncType, "locks_get");
            String strM17959D = DriveSyncUtil.m17959D(str);
            C11839m.m70688i(TAG, "syncV2 Method = getLock, syncType = " + str + ", traceID = " + this.traceId);
            Locks.Get get = c9453iM7268d.m59246e().get(strM17959D);
            DriveSyncUtil.m17994g(get.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
            lockExecute = get.setFields2("sessionId,x-hw-lock").execute();
            try {
                C11839m.m70688i(TAG, "syncV2 lock run: " + lockExecute.toString());
                lockInterval = lockExecute.getLockInterval();
            } catch (IOException e10) {
                e = e10;
                str2 = "locks_get";
                str9 = TAG;
                lock = lockExecute;
            } catch (Throwable th2) {
                th = th2;
                str9 = TAG;
                message = "";
                iM17961F = 0;
                lock = lockExecute;
            }
        } catch (IOException e11) {
            e = e11;
            str2 = "locks_get";
        } catch (Throwable th3) {
            th = th3;
            str9 = TAG;
            message = "";
            iM17961F = 0;
            C11839m.m70688i(str9, "syncV2 Method result: syncType = " + str + ", lock result = " + lock.toString());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("locksInterval", num.toString());
            linkedHashMap2.put("lockToken", this.lockToken);
            linkedHashMap2.putAll(C10812z.m65833b(this.mSyncModulePackageName));
            C10812z.m65847p(this.mContext, str, this.mDataType, iM17961F, message, "03001", "locks_get", this.traceId, linkedHashMap2, false);
            throw th;
        }
        try {
            try {
                String sessionId = lockExecute.getSessionId();
                if (!TextUtils.isEmpty(sessionId)) {
                    try {
                        C13007b.m78205Y(this.mContext).m78209B0(str, this.mSyncModulePackageName, sessionId);
                        this.lockToken = sessionId;
                    } catch (IOException e12) {
                        e = e12;
                        str2 = "locks_get";
                        lock = lockExecute;
                        num = lockInterval;
                        str9 = TAG;
                        try {
                            message = e.getMessage();
                        } catch (Throwable th4) {
                            th = th4;
                            message = "";
                            iM17961F = 0;
                            C11839m.m70688i(str9, "syncV2 Method result: syncType = " + str + ", lock result = " + lock.toString());
                            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                            linkedHashMap22.put("locksInterval", num.toString());
                            linkedHashMap22.put("lockToken", this.lockToken);
                            linkedHashMap22.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                            C10812z.m65847p(this.mContext, str, this.mDataType, iM17961F, message, "03001", "locks_get", this.traceId, linkedHashMap22, false);
                            throw th;
                        }
                        try {
                            iM17961F = DriveSyncUtil.m17961F(e);
                        } catch (Throwable th5) {
                            th = th5;
                            iM17961F = 0;
                            C11839m.m70688i(str9, "syncV2 Method result: syncType = " + str + ", lock result = " + lock.toString());
                            LinkedHashMap linkedHashMap222 = new LinkedHashMap();
                            linkedHashMap222.put("locksInterval", num.toString());
                            linkedHashMap222.put("lockToken", this.lockToken);
                            linkedHashMap222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                            C10812z.m65847p(this.mContext, str, this.mDataType, iM17961F, message, "03001", "locks_get", this.traceId, linkedHashMap222, false);
                            throw th;
                        }
                        try {
                            procException(e, "lock", str2);
                            C11839m.m70688i(str9, "syncV2 Method result: syncType = " + str + ", lock result = " + lock.toString());
                            linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("locksInterval", num.toString());
                            linkedHashMap.put("lockToken", this.lockToken);
                            linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                            Context context2 = this.mContext;
                            str6 = this.mDataType;
                            str3 = this.traceId;
                            z10 = false;
                            str5 = "03001";
                            str4 = "locks_get";
                            context = context2;
                            str7 = str;
                            C10812z.m65847p(context, str7, str6, iM17961F, message, str5, str4, str3, linkedHashMap, z10);
                        } catch (Throwable th6) {
                            th = th6;
                            C11839m.m70688i(str9, "syncV2 Method result: syncType = " + str + ", lock result = " + lock.toString());
                            LinkedHashMap linkedHashMap2222 = new LinkedHashMap();
                            linkedHashMap2222.put("locksInterval", num.toString());
                            linkedHashMap2222.put("lockToken", this.lockToken);
                            linkedHashMap2222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                            C10812z.m65847p(this.mContext, str, this.mDataType, iM17961F, message, "03001", "locks_get", this.traceId, linkedHashMap2222, false);
                            throw th;
                        }
                    }
                }
                if (lockInterval.intValue() > 0) {
                    try {
                        if ("addressbook".equals(str)) {
                            Map<String, C13742e> map = KEEP_LOCK_TASK_MAP;
                            C13742e c13742e = map.get(str);
                            if (c13742e != null) {
                                c13742e.m82589k();
                                map.remove(str);
                            }
                            Context context3 = this.mContext;
                            String str10 = this.traceId;
                            String str11 = this.mSyncModulePackageName;
                            int iIntValue = lockInterval.intValue();
                            str8 = TAG;
                            C13742e c13742e2 = new C13742e(context3, str10, str11, c9453iM7268d, iIntValue, sessionId, str);
                            c13742e2.m82592n();
                            map.put(str, c13742e2);
                        } else {
                            str8 = TAG;
                            Map<String, C13742e> map2 = KEEP_LOCK_TASK_MAP;
                            C13742e c13742e3 = map2.get(str);
                            if (c13742e3 != null) {
                                c13742e3.m82588j();
                                map2.remove(str);
                            }
                            C13742e c13742e4 = new C13742e(this.mContext, this.traceId, this.mSyncModulePackageName, c9453iM7268d, lockInterval.intValue(), sessionId, str);
                            c13742e4.m82591m();
                            map2.put(str, c13742e4);
                        }
                    } catch (IOException e13) {
                        e = e13;
                        lock = lockExecute;
                        num = lockInterval;
                        message = e.getMessage();
                        iM17961F = DriveSyncUtil.m17961F(e);
                        procException(e, "lock", str2);
                        C11839m.m70688i(str9, "syncV2 Method result: syncType = " + str + ", lock result = " + lock.toString());
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("locksInterval", num.toString());
                        linkedHashMap.put("lockToken", this.lockToken);
                        linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                        Context context22 = this.mContext;
                        str6 = this.mDataType;
                        str3 = this.traceId;
                        z10 = false;
                        str5 = "03001";
                        str4 = "locks_get";
                        context = context22;
                        str7 = str;
                        C10812z.m65847p(context, str7, str6, iM17961F, message, str5, str4, str3, linkedHashMap, z10);
                    } catch (Throwable th7) {
                        th = th7;
                        message = "";
                        iM17961F = 0;
                        lock = lockExecute;
                        num = lockInterval;
                        C11839m.m70688i(str9, "syncV2 Method result: syncType = " + str + ", lock result = " + lock.toString());
                        LinkedHashMap linkedHashMap22222 = new LinkedHashMap();
                        linkedHashMap22222.put("locksInterval", num.toString());
                        linkedHashMap22222.put("lockToken", this.lockToken);
                        linkedHashMap22222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                        C10812z.m65847p(this.mContext, str, this.mDataType, iM17961F, message, "03001", "locks_get", this.traceId, linkedHashMap22222, false);
                        throw th;
                    }
                } else {
                    str8 = TAG;
                }
                C11839m.m70688i(str8, "syncV2 Method result: syncType = " + str + ", lock result = " + lockExecute.toString());
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("locksInterval", lockInterval.toString());
                linkedHashMap.put("lockToken", this.lockToken);
                linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                Context context4 = this.mContext;
                str6 = this.mDataType;
                str3 = this.traceId;
                z10 = false;
                str5 = "03001";
                str4 = "locks_get";
                context = context4;
                str7 = str;
                iM17961F = 0;
                message = "";
            } catch (IOException e14) {
                e = e14;
                str2 = "locks_get";
                str9 = TAG;
            }
            C10812z.m65847p(context, str7, str6, iM17961F, message, str5, str4, str3, linkedHashMap, z10);
        } catch (Throwable th8) {
            th = th8;
            str9 = TAG;
        }
    }

    public int getMaxBatchNum() {
        int iM78226K = C13007b.m78205Y(this.mContext).m78226K(this.mSyncType);
        if (iM78226K <= 0) {
            return 100;
        }
        return iM78226K;
    }

    public ChangeList getParcelChangesList(String str, String str2, String str3) throws C9722c {
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
        DriveSyncUtil.m18002l(this.mSyncType, "getChangeList");
        ChangeList changeList = null;
        try {
            isCancel();
            C11839m.m70688i(TAG, "syncV2 Method = getParcelChangesList, syncType = " + this.mSyncType + ", dataType = " + this.mDataType + ", traceID = " + this.traceId);
            Changes.List listAddHeader = c9453iM7268d.m59249h().list(str2, str, str3).addHeader("x-hw-lock", (Object) this.lockToken);
            DriveSyncUtil.m17994g(listAddHeader.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
            ChangeList changeListExecute = listAddHeader.setFields2("newStartCursor,nextCursor,changes(deleted,id,record(id,recycled,status,version))").execute();
            try {
                C11839m.m70686d(TAG, "syncV2 getParcelChangesList dataType: " + str + ",result: " + changeListExecute.toString());
                return changeListExecute;
            } catch (IOException e10) {
                e = e10;
                changeList = changeListExecute;
                C11839m.m70687e(TAG, "syncV2 exception: " + e.getMessage());
                proChangeListSyncIoException(e);
                return changeList;
            }
        } catch (IOException e11) {
            e = e11;
        }
    }

    public C2930i getPostStructDataRspResult() {
        C2930i c2930i = this.postStructDataRspResult;
        return c2930i == null ? new C2930i() : c2930i;
    }

    public int getRecordList() throws Throwable {
        this.cloudEtagMap.clear();
        C11839m.m70688i(TAG, "syncV2 getRecordsList dataType:" + this.mDataType);
        try {
            ArrayList<Record> recordsList = getRecordsList(this.mSyncType, this.mDataType, "nextCursor,records(id,recycled,version)");
            C11839m.m70688i(TAG, "syncV2 getRecordsList dataType:" + this.mDataType + " end size: " + recordsList.size());
            for (Record record : recordsList) {
                if (record != null) {
                    String id2 = record.getId();
                    Etag etag = new Etag();
                    if (record.getVersion() == null) {
                        throw new C9722c(2223, "getRecordList, record version is null, recordId = " + id2, this.mSyncType, "getRecordList");
                    }
                    if (record.getRecycled() != null) {
                        if (SyncLogicService.isSdkSupportRecycleProcess(this.mSyncModulePackageName) && SyncLogicService.isServiceSupportRecycleProcess(this.mContext, this.mSyncType, this.mDataType)) {
                            if (record.getRecycled().booleanValue()) {
                                etag.setRecycleStatus(-1);
                            } else {
                                etag.setRecycleStatus(2);
                            }
                        } else if (!record.getRecycled().booleanValue()) {
                            etag.setRecycleStatus(2);
                        }
                    }
                    etag.setEtag(record.getVersion().toString());
                    this.cloudEtagMap.put(id2, etag);
                }
            }
            return 0;
        } catch (C9722c e10) {
            C11839m.m70688i(TAG, "getRecordList error code: " + e10.m60666c() + ", msg: " + e10.getMessage());
            throw e10;
        }
    }

    public void getRecordListNotSupportRecycle() throws Throwable {
        this.cloudEtagMap.clear();
        ArrayList<Record> recordsList = getRecordsList(this.mSyncType, this.mDataType, "nextCursor,records(id,recycled,recycledTime,status,version)");
        C11839m.m70688i(TAG, "syncV2 mDataType: " + this.mDataType + ", getRecordListNotSupportRecycle size: " + recordsList.size());
        for (Record record : recordsList) {
            if (record != null) {
                String id2 = record.getId();
                Etag etag = new Etag();
                etag.setEtag(record.getVersion().toString());
                if (record.getStatus() != null && record.getStatus().intValue() == 1) {
                    etag.setStatus(200);
                }
                if (!record.getRecycled().booleanValue()) {
                    etag.setRecycleStatus(2);
                    this.cloudEtagMap.put(id2, etag);
                }
            }
        }
    }

    public ArrayList<Record> getRecordsDataByIdList(String str, String str2, List<String> list, String str3, String str4) throws C9722c {
        StringBuilder sb2;
        String str5 = str;
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(str5);
        DriveSyncUtil.m18002l(this.mSyncType, str4);
        int maxBatchNum = getMaxBatchNum();
        int size = list.size();
        int i10 = size > maxBatchNum ? maxBatchNum : size;
        ArrayList<Record> arrayList = new ArrayList<>();
        int i11 = 0;
        while (true) {
            try {
                try {
                    C11839m.m70688i(TAG, "syncV2 Method = batchGetRecordsData, syncType = " + str5 + ", dataType = " + this.mDataType + ", traceID = " + this.traceId);
                    String strM17959D = DriveSyncUtil.m17959D(str);
                    IdList idList = new IdList();
                    idList.setIds(list.subList(i11, i10));
                    i11 += maxBatchNum;
                    i10 = size - i11 > maxBatchNum ? i11 + maxBatchNum : size;
                    Records.BatchGet batchGetAddHeader = c9453iM7268d.m59247f().batchGet(strM17959D, str2, idList).addHeader("x-hw-lock", (Object) this.lockToken);
                    C9453i c9453i = c9453iM7268d;
                    DriveSyncUtil.m17994g(batchGetAddHeader.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                    batchGetAddHeader.setFields2(str3);
                    isCancel();
                    BatchRecordsResponse batchRecordsResponseExecute = batchGetAddHeader.execute();
                    if (batchRecordsResponseExecute == null) {
                        C11839m.m70688i(TAG, "syncV2 records recordsList is null.");
                    } else {
                        List<Record> records = batchRecordsResponseExecute.getRecords();
                        if (records != null) {
                            C11839m.m70688i(TAG, "syncV2 recordsDataList size: " + records.size());
                            for (Record record : records) {
                                if (record == null) {
                                    C11839m.m70687e(TAG, "record is null.");
                                } else {
                                    arrayList.add(record);
                                }
                            }
                        }
                    }
                    if (i11 >= size) {
                        break;
                    }
                    str5 = str;
                    c9453iM7268d = c9453i;
                } catch (IOException e10) {
                    C11839m.m70687e(TAG, "syncV2 getRecordsDataByIdList: " + e10.getMessage());
                    procException(e10, "getRecordsDataByIdList", "getData");
                    sb2 = new StringBuilder();
                }
            } catch (Throwable th2) {
                C11839m.m70688i(TAG, "syncV2 Method result: dataType = " + str2 + ", recordsDataList = " + arrayList.size());
                throw th2;
            }
        }
        sb2 = new StringBuilder();
        sb2.append("syncV2 Method result: dataType = ");
        sb2.append(str2);
        sb2.append(", recordsDataList = ");
        sb2.append(arrayList.size());
        C11839m.m70688i(TAG, sb2.toString());
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0175, code lost:
    
        p514o9.C11839m.m70688i(com.huawei.android.hicloud.sync.contact.SyncProcessBase.TAG, "syncV2 getRecordsList is null.");
        r0 = new java.util.LinkedHashMap();
        r0.put("beginCursor", r2);
        r0.putAll(je.C10812z.m65833b(r30.mSyncModulePackageName));
        r0.put("timestamp", java.lang.String.valueOf(r16));
        je.C10812z.m65847p(r30.mContext, r30.mSyncType, r30.mDataType, 0, "recordsList null", "03001", "getRecordPageList", r30.traceId, r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01b5, code lost:
    
        p514o9.C11839m.m70688i(com.huawei.android.hicloud.sync.contact.SyncProcessBase.TAG, "syncV2 Method result: dataType = " + r32 + ", avaliableRecordSize = " + r19.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01d1, code lost:
    
        return r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x008b, code lost:
    
        r19 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record> getRecordsList(java.lang.String r31, java.lang.String r32, java.lang.String r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.SyncProcessBase.getRecordsList(java.lang.String, java.lang.String, java.lang.String):java.util.ArrayList");
    }

    public void getStartCursor(String str) throws Throwable {
        int iM17961F;
        LinkedHashMap linkedHashMap;
        String str2;
        String str3;
        boolean z10;
        String str4;
        String str5;
        Context context;
        String str6;
        Changes.GetStartCursor getStartCursorAddHeader;
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(str);
        DriveSyncUtil.m18002l(this.mSyncType, "get_start_cursor");
        String startCursor = "";
        String message = "";
        C11839m.m70688i(TAG, "syncV2 Method = getStartCursor, syncType = " + str + ", traceID = " + this.traceId);
        StringBuilder sb2 = new StringBuilder("ctagInfos: ");
        try {
            getStartCursorAddHeader = c9453iM7268d.m59249h().getStartCursor(DriveSyncUtil.m17959D(str)).addHeader("x-hw-lock", (Object) this.lockToken);
        } catch (IOException e10) {
            e = e10;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            DriveSyncUtil.m17994g(getStartCursorAddHeader.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
            getStartCursorAddHeader.setFields2("startCursor");
            startCursor = getStartCursorAddHeader.execute().getStartCursor();
        } catch (IOException e11) {
            e = e11;
            iM17961F = 0;
            startCursor = "";
            try {
                C11839m.m70687e(TAG, "syncV2 getStartCursor: " + e.getMessage());
                message = e.getMessage();
                iM17961F = DriveSyncUtil.m17961F(e);
                procException(e, "getStartCursor", "get_start_cursor");
                C11839m.m70688i(TAG, "syncV2 Method result: syncType = " + str + ", getStartCursor result = " + startCursor + ", ctagInfos = " + sb2.toString());
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("start_cursor", startCursor);
                linkedHashMap.put("ctagInfos", sb2.toString());
                linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                Context context2 = this.mContext;
                str2 = this.mDataType;
                str3 = this.traceId;
                z10 = true;
                str4 = "03001";
                str5 = "get_start_cursor";
                context = context2;
                str6 = str;
                C10812z.m65847p(context, str6, str2, iM17961F, message, str4, str5, str3, linkedHashMap, z10);
            } catch (Throwable th3) {
                th = th3;
                C11839m.m70688i(TAG, "syncV2 Method result: syncType = " + str + ", getStartCursor result = " + startCursor + ", ctagInfos = " + sb2.toString());
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("start_cursor", startCursor);
                linkedHashMap2.put("ctagInfos", sb2.toString());
                linkedHashMap2.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                C10812z.m65847p(this.mContext, str, this.mDataType, iM17961F, message, "03001", "get_start_cursor", this.traceId, linkedHashMap2, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            iM17961F = 0;
            startCursor = "";
            C11839m.m70688i(TAG, "syncV2 Method result: syncType = " + str + ", getStartCursor result = " + startCursor + ", ctagInfos = " + sb2.toString());
            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
            linkedHashMap22.put("start_cursor", startCursor);
            linkedHashMap22.put("ctagInfos", sb2.toString());
            linkedHashMap22.putAll(C10812z.m65833b(this.mSyncModulePackageName));
            C10812z.m65847p(this.mContext, str, this.mDataType, iM17961F, message, "03001", "get_start_cursor", this.traceId, linkedHashMap22, true);
            throw th;
        }
        try {
            C13007b c13007bM78205Y = C13007b.m78205Y(this.mContext);
            c13007bM78205Y.m78219G0(str, startCursor);
            this.cloudCtagMap.clear();
            for (Iterator<String> it = c13007bM78205Y.m78242T(str).iterator(); it.hasNext(); it = it) {
                String next = it.next();
                Ctag ctag = new Ctag();
                ctag.setCtag(startCursor);
                this.cloudCtagMap.put(next, ctag);
                sb2.append(next);
                sb2.append(" = ");
                sb2.append(ctag);
                sb2.append(". ");
                c13007bM78205Y.m78265i0(next, ctag.getCtag());
            }
            saveCloudCtag();
            C11839m.m70688i(TAG, "syncV2 Method result: syncType = " + str + ", getStartCursor result = " + startCursor + ", ctagInfos = " + sb2.toString());
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("start_cursor", startCursor);
            linkedHashMap.put("ctagInfos", sb2.toString());
            linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
            Context context3 = this.mContext;
            str2 = this.mDataType;
            str3 = this.traceId;
            z10 = true;
            str4 = "03001";
            str5 = "get_start_cursor";
            context = context3;
            str6 = str;
            iM17961F = 0;
        } catch (IOException e12) {
            e = e12;
            iM17961F = 0;
            C11839m.m70687e(TAG, "syncV2 getStartCursor: " + e.getMessage());
            message = e.getMessage();
            iM17961F = DriveSyncUtil.m17961F(e);
            procException(e, "getStartCursor", "get_start_cursor");
            C11839m.m70688i(TAG, "syncV2 Method result: syncType = " + str + ", getStartCursor result = " + startCursor + ", ctagInfos = " + sb2.toString());
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("start_cursor", startCursor);
            linkedHashMap.put("ctagInfos", sb2.toString());
            linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
            Context context22 = this.mContext;
            str2 = this.mDataType;
            str3 = this.traceId;
            z10 = true;
            str4 = "03001";
            str5 = "get_start_cursor";
            context = context22;
            str6 = str;
            C10812z.m65847p(context, str6, str2, iM17961F, message, str4, str5, str3, linkedHashMap, z10);
        } catch (Throwable th5) {
            th = th5;
            iM17961F = 0;
            C11839m.m70688i(TAG, "syncV2 Method result: syncType = " + str + ", getStartCursor result = " + startCursor + ", ctagInfos = " + sb2.toString());
            LinkedHashMap linkedHashMap222 = new LinkedHashMap();
            linkedHashMap222.put("start_cursor", startCursor);
            linkedHashMap222.put("ctagInfos", sb2.toString());
            linkedHashMap222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
            C10812z.m65847p(this.mContext, str, this.mDataType, iM17961F, message, "03001", "get_start_cursor", this.traceId, linkedHashMap222, true);
            throw th;
        }
        C10812z.m65847p(context, str6, str2, iM17961F, message, str4, str5, str3, linkedHashMap, z10);
    }

    public String getSyncType() {
        String str = this.mModuleName;
        str.hashCode();
        String str2 = "addressbook";
        if (!str.equals("addressbook")) {
            str2 = "wlan";
            if (!str.equals("wlan")) {
                str2 = this.mSyncType;
            }
        }
        C11839m.m70686d(TAG, "getSyncType: " + str2);
        return str2;
    }

    public boolean isAbortSyncNowThrowException() {
        return (this.needAbortSync == null || this.needAbortSync.getErrCode() == 0) ? false : true;
    }

    public void isCancel() throws C9722c {
        String str;
        Handler.Callback callback = this.mCallBack;
        if (callback == null || !((C11439b.a) callback).m68523b()) {
            return;
        }
        int iM68522a = ((C11439b.a) this.mCallBack).m68522a();
        if (iM68522a == 2001) {
            str = "Local ST invalid flag is true";
        } else if (iM68522a == 2010) {
            str = "Manual cancel";
        } else if (iM68522a == 2012) {
            str = "Switch is off";
        } else if (iM68522a == 2017) {
            str = "Sync Risk";
        } else if (iM68522a == 2019) {
            str = "Data migrate warn is true";
        } else if (iM68522a != 2027) {
            str = iM68522a != 2029 ? iM68522a != 2201 ? iM68522a != 3003 ? iM68522a != 2024 ? iM68522a != 2025 ? "Others" : "Call APP Timeout" : "No NetWork" : "delete lock, end sync" : "Forced upgrade" : "Server Control Reset";
        } else {
            str = "App Call EndSync, Switch = " + C10028c.m62182c0().m62388s(this.mSyncType);
        }
        C11839m.m70689w(TAG, "isCancel: " + str + ", syncType: " + this.mSyncType);
        throw new C9722c(iM68522a, "SyncProcessBase: " + str, this.mSyncType, "sync_is_cancel");
    }

    public boolean isCloudDataChanged(String str, int i10) {
        return isCloudDataChanged(getCloudCtag(str, i10), getLocalCtag(str));
    }

    public boolean isCursorInvalid(Exception exc) {
        return DriveSyncUtil.m17975T(410, "4100", exc);
    }

    public boolean isCursorParamInvalid(Exception exc) {
        return DriveSyncUtil.m17975T(400, "4002", exc);
    }

    public boolean isHasPartialSucData() {
        return true;
    }

    public boolean isNeedQueryEtagIncremental(Ctag ctag, boolean z10) {
        if (z10) {
            C11839m.m70688i(TAG, "isNeedQueryEtagIncremental, first open switch return false");
            return false;
        }
        if (("atlas".equals(this.mSyncType) || CloudSyncUtil.m16056w0(this.mSyncType)) && ctag != null) {
            return !ctag.isExpired();
        }
        return false;
    }

    public boolean isSupportIncrementalQuery() {
        return false;
    }

    public void modifyData(Map<String, List<C2925d>> map) throws C9722c {
        C11839m.m70686d(TAG, "modifyData request");
        if (C10028c.m62182c0().m62206E1()) {
            throw new C9722c(FamilyShareConstants.MessageCode.GET_FAMILY_IMAGE, "Incremental migration");
        }
        clearMap();
        SyncProtocol.ModifyResponse modifyResponseM17722n = this.protocol.m17722n(this.mSyncType, this.mDataType, map);
        setMapModifyRsp(modifyResponseM17722n.mapModifyRsp);
        setPartialResult(modifyResponseM17722n.result.m17769b(), modifyResponseM17722n.result.m17770c());
        C11839m.m70686d(TAG, "modifyData result, mapModifyRsp = " + mapModifyRsp.size());
    }

    public void proChangeListSyncIoException(IOException iOException) throws C9722c {
        if (isCursorInvalid(iOException)) {
            throw new C9722c(2216, "syncV2 cursor invalid, dataType = " + this.mDataType, this.mSyncType, "getChangeList");
        }
        if (!isCursorParamInvalid(iOException)) {
            procException(iOException, "changeList", "getChangeList");
            return;
        }
        throw new C9722c(2239, "syncV2 cursor invalid, dataType = " + this.mDataType, this.mSyncType, "getChangeList");
    }

    public int procEachItemErr(FailRet failRet, String str) throws C9722c {
        if (DriveSyncUtil.m17976U("4945", failRet.getErrCode())) {
            setPartialResult(90001, failRet.getErrMsg());
            return 90001;
        }
        if (DriveSyncUtil.m17976U("4039", failRet.getErrCode())) {
            setPartialResult(SNSCode.Status.HWID_UNLOGIN, failRet.getErrMsg());
            CloudSyncUtil.m15978T0(this.mContext, this.mSyncType);
            CloudSyncUtil.m15986X0(this.mContext, this.mSyncType, true);
            C0237v.m1661c();
            return SNSCode.Status.HWID_UNLOGIN;
        }
        if (DriveSyncUtil.m17976U("4091", failRet.getErrCode())) {
            throw new C9722c(1001, failRet.getErrMsg(), this.mSyncType, str);
        }
        if (DriveSyncUtil.m17976U("4037", failRet.getErrCode())) {
            throw new C9722c(901, failRet.getErrMsg(), this.mSyncType, str);
        }
        if (DriveSyncUtil.m17976U("0401", failRet.getErrCode())) {
            C13195l.m79272J().m79325o0(C1164a.m7265f().m7269e());
            throw new C9722c(1202, failRet.getErrMsg(), this.mSyncType, str);
        }
        if (DriveSyncUtil.m17976U("4293", failRet.getErrCode())) {
            C11839m.m70688i(TAG, "syncV2 serverFlowControl.");
            C2786g.m16222k(this.mSyncType, this.serverFlowControlEffected);
            throw new C9722c(failRet.getErrCode(), failRet.getErrMsg(), this.mSyncType, str);
        }
        if (!DriveSyncUtil.m17976U("4988", failRet.getErrCode())) {
            throw new C9722c(failRet.getErrCode(), failRet.getErrMsg(), this.mSyncType, str);
        }
        C11839m.m70688i(TAG, "syncV2 grade already change.");
        C1008c.m6035v().m6051P(this.mContext, null, false);
        throw new C9722c(C0241z.m1685c("4988"), failRet.getErrMsg(), this.mSyncType, str);
    }

    public void procException(IOException iOException, String str, String str2) throws C9722c {
        String str3 = this.mDataType + " " + str + " " + iOException.getMessage();
        if (isExceedLimit(iOException)) {
            setPartialResult(90001, iOException.getMessage());
            return;
        }
        if (isSpaceNotEnough(iOException)) {
            setPartialResult(SNSCode.Status.HWID_UNLOGIN, iOException.getMessage());
            CloudSyncUtil.m15978T0(this.mContext, this.mSyncType);
            CloudSyncUtil.m15986X0(this.mContext, this.mSyncType, true);
            C0237v.m1661c();
            throw new C9722c(SNSCode.Status.HWID_UNLOGIN, str3, this.mSyncType, str2);
        }
        if (isLockConflict(iOException)) {
            throw new C9722c(1001, str3, this.mSyncType, str2);
        }
        if (isLockExpiredConflict(iOException)) {
            throw new C9722c(901, str3, this.mSyncType, str2);
        }
        if (isAtInvalid(iOException)) {
            C13195l.m79272J().m79325o0(C1164a.m7265f().m7269e());
            throw new C9722c(1202, str3, this.mSyncType, str2);
        }
        if (DriveSyncUtil.m17972Q(iOException)) {
            C11839m.m70688i(TAG, "syncV2 DATA_MIGRATING clear data version sp.");
            DriveSyncUtil.m18003m(this.mContext, this.mSyncType);
        } else {
            if (isNeedRefresh(iOException)) {
                C11839m.m70688i(TAG, "syncV2 need refresh user state.");
                C1007b.m5980s().m5993M(FROM_SYNC_ACTIVATE + this.mSyncType);
                throw new C9722c(C0241z.m1685c("4933"), str3, this.mSyncType, str2);
            }
            if (isNeedReSync(iOException)) {
                C11839m.m70688i(TAG, "syncV2 need refullsync, clear sync cache and report basic.");
                C12515a.m75110o().m75175e(new C2875b(this.mSyncType, iOException, C0241z.m1685c("4977"), "local_on_data_sync_clear"), true);
                throw new C9722c(C0241z.m1685c("4977"), str3, this.mSyncType, str2);
            }
            if (isForbiddenUploadSync(iOException)) {
                C11839m.m70688i(TAG, "syncV2 grade already change.");
                C1008c.m6035v().m6051P(this.mContext, null, false);
                throw new C9722c(C0241z.m1685c("4988"), str3, this.mSyncType, str2);
            }
            if (isNeedClose(iOException)) {
                C11839m.m70688i(TAG, "syncV2 need close.");
                Intent intent = new Intent();
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.setAction("com.huawei.hicloud.action.CLOSE_SYNC_SWITCH");
                intent.putExtra("syncType", this.mSyncType);
                C13108a.m78878b(this.mContext.getApplicationContext()).m78881d(intent);
            } else if (isServerControl(iOException)) {
                C11839m.m70688i(TAG, "syncV2 serverFlowControl.");
                C2786g.m16222k(this.mSyncType, this.serverFlowControlEffected);
                throw new C9722c(C0241z.m1685c("4293"), str3, this.mSyncType, str2);
            }
        }
        if (iOException instanceof C4616s) {
            throw new C9722c(C0241z.m1685c(DriveSyncUtil.m17980Y((C4616s) iOException)), str3, this.mSyncType, str2);
        }
        if (!C0209d.m1208S0(this.mContext) || !C13468a.m81100c().m81101b()) {
            throw new C9722c(2028, str3, this.mSyncType, str2);
        }
        if (!CloudSyncUtil.m16054v0(iOException)) {
            throw new C9722c(2217, str3, this.mSyncType, str2);
        }
        throw new C9722c(2102, str3, this.mSyncType, str2);
    }

    public void putUpdateRecords(String str, List<Record> list, List<Record> list2, List<FailRet> list3, String str2, String str3) throws C9722c {
        StringBuilder sb2;
        String str4;
        CloudSyncBatch cloudSyncBatch;
        String str5;
        List<FailRet> list4 = list3;
        String str6 = "syncV2 putUpdateRecords attributes is null, recordId = ";
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
        DriveSyncUtil.m18002l(this.mSyncType, str3);
        int maxBatchNum = getMaxBatchNum();
        try {
            try {
                String strM17959D = DriveSyncUtil.m17959D(this.mSyncType);
                CloudSyncBatch cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                C11839m.m70688i(TAG, "syncV2 Method = putUpdateRecords, syncType = " + this.mSyncType + ", dataType = " + this.mDataType + ", traceID = " + this.traceId);
                int size = list.size();
                CloudSyncBatch cloudSyncBatchM59243b2 = cloudSyncBatchM59243b;
                int i10 = size;
                int i11 = 0;
                for (Record record : list) {
                    if (record != null) {
                        if (record.getAttributes() == null) {
                            C11839m.m70689w(TAG, str6 + record.getId());
                            FailRet failRet = new FailRet();
                            failRet.setErrCode(2211);
                            failRet.setRecordId(record.getId());
                            failRet.setErrMsg(str6 + record.getId());
                            list4.add(failRet);
                        } else {
                            String id2 = record.getId();
                            if (C12316j0.m74076d().m74086k(strM17959D, this.mDataType, id2)) {
                                FailRet failRet2 = new FailRet();
                                failRet2.setRecordId(id2);
                                failRet2.setErrCode(SNSCode.Status.GET_FRIEND_LIST_FAIL);
                                failRet2.setErrMsg("update record not exits, over times");
                                list4.add(failRet2);
                            } else {
                                Records.UpdatePatch updatePatchAddHeader = c9453iM7268d.m59247f().updatePatch(strM17959D, this.mDataType, id2, record).addHeader("x-hw-lock", (Object) this.lockToken);
                                str4 = str6;
                                DriveSyncUtil.m17994g(updatePatchAddHeader.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                                updatePatchAddHeader.setMode(str).setFields2(str2);
                                cloudSyncBatch = cloudSyncBatchM59243b2;
                                str5 = strM17959D;
                                updatePatchAddHeader.queue(cloudSyncBatch, new C9451g(strM17959D, this.mDataType, record.getId(), list2, list3));
                                i11++;
                            }
                        }
                        i10--;
                        str4 = str6;
                        cloudSyncBatch = cloudSyncBatchM59243b2;
                        str5 = strM17959D;
                    } else {
                        i10--;
                        str4 = str6;
                        cloudSyncBatch = cloudSyncBatchM59243b2;
                        str5 = strM17959D;
                    }
                    int i12 = i10;
                    int i13 = i11;
                    if ((i13 % maxBatchNum == 0 || i12 == i13) && cloudSyncBatch.size() > 0) {
                        cloudSyncBatch.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                        cloudSyncBatchM59243b2 = c9453iM7268d.m59243b();
                    } else {
                        cloudSyncBatchM59243b2 = cloudSyncBatch;
                    }
                    list4 = list3;
                    i10 = i12;
                    i11 = i13;
                    str6 = str4;
                    strM17959D = str5;
                }
                sb2 = new StringBuilder();
            } catch (IOException e10) {
                procException(e10, "putUpdateRecords", str3);
                sb2 = new StringBuilder();
            }
            sb2.append("syncV2 Method result: dataType = ");
            sb2.append(this.mDataType);
            sb2.append(", putUpdateSucSize = ");
            sb2.append(list2.size());
            sb2.append(", putUpdateFailSize = ");
            sb2.append(list3.size());
            C11839m.m70688i(TAG, sb2.toString());
        } catch (Throwable th2) {
            C11839m.m70688i(TAG, "syncV2 Method result: dataType = " + this.mDataType + ", putUpdateSucSize = " + list2.size() + ", putUpdateFailSize = " + list3.size());
            throw th2;
        }
    }

    public void queryData(List<String> list) throws C9722c {
        C11839m.m70688i(TAG, "queryData request guidList = " + list.size());
        Map<String, C2924c> map = this.protocol.m17731w(this.mSyncType, this.mDataType, list).mapData;
        this.cloudData = map;
        if (map != null) {
            C11839m.m70686d(TAG, "queryData result, cloudData = " + this.cloudData.size());
        }
    }

    public void reportDeleteFileEvent(Map<String, List<String>> map, List<FailRet> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("syncType", this.mSyncType);
        linkedHashMap.put("dataType", this.mDataType);
        linkedHashMap.put("thirdPackageName", DriveSyncUtil.m17965J(this.mSyncType, this.mSyncModulePackageName));
        linkedHashMap.put("thirdPackageVersion", DriveSyncUtil.m17971P(this.mSyncType, this.mSyncModulePackageName));
        if (map != null && map.size() > 0) {
            linkedHashMap.put("successList", map.toString());
        }
        if (list != null && list.size() > 0) {
            linkedHashMap.put("failList", list.toString());
        }
        linkedHashMap.put("returnCode", String.valueOf((list == null || list.size() <= 0) ? 0 : 122));
        C10812z.m65844m("mecloud_sync_data_delete_file", linkedHashMap);
    }

    public void reportPreSync(Map<String, Etag> map, int i10, boolean z10) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isSupportIncrementallyQuery", isSupportIncrementalQuery());
            jSONObject.put("isIncrementallyQuery", z10);
            if (map != null) {
                jSONObject.put("cloudEtagSize", map.size());
            }
            if (map != null && map.size() > 0) {
                int i11 = 0;
                int i12 = 0;
                for (Etag etag : map.values()) {
                    if (etag != null) {
                        if (etag.getRecycleStatus() == -1) {
                            i12++;
                        } else if (etag.getRecycleStatus() == 2) {
                            i11++;
                        }
                    }
                }
                jSONObject.put("normalEtagSize", i11);
                jSONObject.put("recycleEtagSize", i12);
            }
            jSONObject.put("changeDeletedSize", i10);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("extraInfo", jSONObject.toString());
            C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", this.operationType, "local_pre_sync", this.traceId, linkedHashMap, false);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "report pre_sync err " + e10.getMessage());
        }
    }

    public void reportPropfind(String str, String str2, int i10, int i11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dataType", this.mDataType);
        linkedHashMap.put("syncScene", str2);
        linkedHashMap.put("totalSize", String.valueOf(i10));
        if (i11 > 0) {
            linkedHashMap.put("changeDeletedSize", String.valueOf(i11));
        }
        linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", str, this.traceId, linkedHashMap, false);
    }

    public void reportPropfindPage(String str, String str2, int i10, int i11, int i12, String str3, long j10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("beginCursor", str);
        linkedHashMap.put("nextCursor", str2);
        linkedHashMap.put("pageSize", String.valueOf(i10));
        linkedHashMap.put("recycleSize", String.valueOf(i11));
        linkedHashMap.put("timestamp", String.valueOf(j10));
        if (i12 > 0) {
            linkedHashMap.put("exceptionSize", String.valueOf(i12));
            linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str3);
        }
        linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "getRecordPageList", this.traceId, linkedHashMap, false);
    }

    public void reportUploadBIEvet(int i10, String str, int i11, List<FailRet> list, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(commonUploadInfo(i11, list, str2));
        if (TextUtils.isEmpty(str) && list.size() > 0) {
            str = list.get(0).getErrMsg();
        }
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str);
        linkedHashMap.put("returnCode", String.valueOf(i10));
        C10812z.m65844m(str2, linkedHashMap);
    }

    public void reportUploadDataV2(int i10, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dataType", this.mDataType);
        linkedHashMap.put("uploadDetail", str2);
        linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str, "03001", "batch_of_local_upload_end", this.traceId, linkedHashMap, false);
    }

    public void reportUploadEvet(int i10, String str, int i11, List<FailRet> list, String str2) {
        if (TextUtils.isEmpty(str) && list.size() > 0) {
            str = list.get(0).getErrMsg();
        }
        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str, "03001", str2, this.traceId, commonUploadInfo(i11, list, str2), false);
    }

    public void reportUploadFileBIEvent(String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(getCommonUploadFileReportInfo(str, str2, str3, str4, i10, str5));
        if (!TextUtils.isEmpty(str6)) {
            linkedHashMap.put("operationType", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            linkedHashMap.put("bussinessId", str7);
        }
        C10812z.m65844m("mecloud_sync_data_upload_file", linkedHashMap);
    }

    public void reportUploadFileList(int i10, String str, String str2, String str3, int i11, Map<String, String> map, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        linkedHashMap.put("recordId", str2);
        linkedHashMap.put("uploadInfo", str3);
        linkedHashMap.put("attachmentSize", String.valueOf(i11));
        linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
        C10812z.m65847p(C0213f.m1377a(), this.mSyncType, this.mDataType, i10, str, "03001", str4, this.traceId, linkedHashMap, false);
    }

    public void setConfig(String str, Handler.Callback callback, ReportSyncEndInfo reportSyncEndInfo) {
        this.mModuleName = str;
        this.mCallBack = callback;
        this.mReportEndInfo = reportSyncEndInfo;
    }

    public void setDataType(String str) {
        this.mDataType = str;
    }

    public void setNeedAbortSyncNow(String str, int i10) {
        this.needAbortSync = new FailRet();
        this.needAbortSync.setErrMsg(str);
        this.needAbortSync.setErrCode(i10);
    }

    public void setPartialResult(int i10, String str) {
        if (CloudSyncUtil.m16058x0(i10)) {
            C2930i c2930i = new C2930i();
            c2930i.m17771d(i10);
            c2930i.m17772e(str);
            setPostStructDataRspResult(c2930i);
        }
    }

    public void setPostStructDataRspResult(C2930i c2930i) {
        this.postStructDataRspResult = c2930i;
    }

    public boolean startSyncRestoreFile(File file, Uri uri, C11060c c11060c, String str, long j10) throws Throwable {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        FileOutputStream fileOutputStream;
        if (!file.exists()) {
            c11060c.m66665u(String.valueOf(2229));
            c11060c.m66635A("zipPath path not find");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("useTime", String.valueOf(System.currentTimeMillis() - j10));
            C13622a.m81969o(this.mContext, c11060c, linkedHashMap);
            C11839m.m70687e(TAG, "zipPath path not find");
            return false;
        }
        C11839m.m70686d(TAG, "open file restore");
        byte[] bArr = new byte[1024];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                assetFileDescriptorOpenAssetFileDescriptor = this.mContext.getContentResolver().openAssetFileDescriptor(uri, "rwxrwxrwx");
                try {
                    if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                        C11839m.m70688i(TAG, "assetFileDescriptor is nul");
                        closeStream(fileInputStream2, null, assetFileDescriptorOpenAssetFileDescriptor);
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put("useTime", String.valueOf(System.currentTimeMillis() - j10));
                        C13622a.m81969o(this.mContext, c11060c, linkedHashMap2);
                        return false;
                    }
                    fileOutputStream = new FileOutputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                    while (true) {
                        try {
                            int i10 = fileInputStream2.read(bArr);
                            if (i10 == -1) {
                                c11060c.m66665u("0");
                                c11060c.m66635A(str);
                                closeStream(fileInputStream2, fileOutputStream, assetFileDescriptorOpenAssetFileDescriptor);
                                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                                linkedHashMap3.put("useTime", String.valueOf(System.currentTimeMillis() - j10));
                                C13622a.m81969o(this.mContext, c11060c, linkedHashMap3);
                                try {
                                    this.mContext.getContentResolver().update(uri, new ContentValues(), null, null);
                                    return true;
                                } catch (Exception e10) {
                                    C11839m.m70687e(TAG, "startRestoreFile update exception:" + e10.toString());
                                    return true;
                                }
                            }
                            fileOutputStream.write(bArr, 0, i10);
                        } catch (Exception e11) {
                            e = e11;
                            fileInputStream = fileInputStream2;
                            try {
                                String string = e.toString();
                                c11060c.m66665u(String.valueOf(2229));
                                c11060c.m66635A(string);
                                C11839m.m70687e(TAG, "doEachRestore exception:" + string);
                                closeStream(fileInputStream, fileOutputStream, assetFileDescriptorOpenAssetFileDescriptor);
                                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                                linkedHashMap4.put("useTime", String.valueOf(System.currentTimeMillis() - j10));
                                C13622a.m81969o(this.mContext, c11060c, linkedHashMap4);
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                closeStream(fileInputStream, fileOutputStream, assetFileDescriptorOpenAssetFileDescriptor);
                                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                                linkedHashMap5.put("useTime", String.valueOf(System.currentTimeMillis() - j10));
                                C13622a.m81969o(this.mContext, c11060c, linkedHashMap5);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = fileInputStream2;
                            closeStream(fileInputStream, fileOutputStream, assetFileDescriptorOpenAssetFileDescriptor);
                            LinkedHashMap linkedHashMap52 = new LinkedHashMap();
                            linkedHashMap52.put("useTime", String.valueOf(System.currentTimeMillis() - j10));
                            C13622a.m81969o(this.mContext, c11060c, linkedHashMap52);
                            throw th;
                        }
                    }
                } catch (Exception e12) {
                    e = e12;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
            } catch (Exception e13) {
                e = e13;
                assetFileDescriptorOpenAssetFileDescriptor = null;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                assetFileDescriptorOpenAssetFileDescriptor = null;
                fileOutputStream = null;
            }
        } catch (Exception e14) {
            e = e14;
            assetFileDescriptorOpenAssetFileDescriptor = null;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            assetFileDescriptorOpenAssetFileDescriptor = null;
            fileOutputStream = null;
        }
    }

    public void syncV2(String str) throws Throwable {
        subscribe(str);
        getLockV2(str);
        getStartCursor(str);
    }

    public Map<String, CtagInfo> unLock(Map<String, List<C2925d>> map) throws C9722c {
        Map<String, C13742e> map2 = KEEP_LOCK_TASK_MAP;
        C13742e c13742e = map2.get(getSyncType());
        if (c13742e != null) {
            c13742e.m82588j();
            map2.remove(getSyncType());
        }
        return this.protocol.m17733y(getSyncType(), map);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.huawei.android.hicloud.sync.contact.SyncProcessBase] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public void unlockV2(String str) throws Throwable {
        String str2;
        int i10;
        SyncProcessBase syncProcessBase;
        int iM60666c;
        String message;
        LinkedHashMap linkedHashMap;
        ?? r12 = this;
        String str3 = null;
        try {
        } catch (Throwable th2) {
            th = th2;
            str2 = "";
            i10 = 0;
            syncProcessBase = r12;
        }
        try {
            try {
                try {
                    Map<String, C13742e> map = KEEP_LOCK_TASK_MAP;
                    C13742e c13742e = map.get(str);
                    if (c13742e != null) {
                        str3 = c13742e.f61777h;
                        if ("addressbook".equals(str)) {
                            C11839m.m70688i(TAG, "syncV2 keepLockV2 unlock cancelKeepLockV2");
                            c13742e.m82589k();
                        } else {
                            c13742e.m82588j();
                        }
                        map.remove(str);
                    }
                    C11839m.m70688i(TAG, "syncV2 Method = unlock, syncType = " + str + ", dataType = " + r12.mDataType + ", traceID = " + r12.traceId);
                    r12.doUnlock(str, str3);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("syncV2 Method result: locks.delete success, syncType = ");
                    sb2.append(r12.mSyncType);
                    C11839m.m70688i(TAG, sb2.toString());
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("lockToken", str3);
                    linkedHashMap2.putAll(C10812z.m65833b(r12.mSyncModulePackageName));
                    C10812z.m65847p(r12.mContext, r12.mSyncType, r12.mDataType, 0, "", "03001", "locks_delete", r12.traceId, linkedHashMap2, false);
                } catch (C9722c e10) {
                    iM60666c = e10.m60666c();
                    message = e10.getMessage();
                    C11839m.m70688i(TAG, "syncV2 Method result: unlock fail, syncType = " + r12.mSyncType + ", errorMsg = " + e10.getMessage());
                    linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("lockToken", str3);
                    linkedHashMap.putAll(C10812z.m65833b(r12.mSyncModulePackageName));
                    Context context = r12.mContext;
                    String str4 = r12.mSyncType;
                    String str5 = r12.mDataType;
                    r12 = r12.traceId;
                    C10812z.m65847p(context, str4, str5, iM60666c, message, "03001", "locks_delete", r12, linkedHashMap, false);
                } catch (Exception e11) {
                    iM60666c = 5;
                    message = e11.getMessage();
                    C11839m.m70688i(TAG, "syncV2 Method result: unlock error, syncType = " + r12.mSyncType + ", errorMsg = " + e11.getMessage());
                    linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("lockToken", str3);
                    linkedHashMap.putAll(C10812z.m65833b(r12.mSyncModulePackageName));
                    Context context2 = r12.mContext;
                    String str42 = r12.mSyncType;
                    String str52 = r12.mDataType;
                    r12 = r12.traceId;
                    C10812z.m65847p(context2, str42, str52, iM60666c, message, "03001", "locks_delete", r12, linkedHashMap, false);
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = "";
                i10 = iM60666c;
                syncProcessBase = r12;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("lockToken", str3);
                linkedHashMap3.putAll(C10812z.m65833b(syncProcessBase.mSyncModulePackageName));
                C10812z.m65847p(syncProcessBase.mContext, syncProcessBase.mSyncType, syncProcessBase.mDataType, i10, str2, "03001", "locks_delete", syncProcessBase.traceId, linkedHashMap3, false);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            i10 = iM60666c;
            str2 = message;
            syncProcessBase = r12;
            LinkedHashMap linkedHashMap32 = new LinkedHashMap();
            linkedHashMap32.put("lockToken", str3);
            linkedHashMap32.putAll(C10812z.m65833b(syncProcessBase.mSyncModulePackageName));
            C10812z.m65847p(syncProcessBase.mContext, syncProcessBase.mSyncType, syncProcessBase.mDataType, i10, str2, "03001", "locks_delete", syncProcessBase.traceId, linkedHashMap32, false);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x011c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0124 A[Catch: all -> 0x00a6, IOException -> 0x0133, TRY_LEAVE, TryCatch #2 {IOException -> 0x0133, blocks: (B:78:0x0118, B:81:0x011e, B:83:0x0124, B:77:0x010c), top: B:98:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateNormalRecords(java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record> r22, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record> r23, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.SyncProcessBase.updateNormalRecords(java.util.List, java.util.List, java.util.List):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void updateRecordLostStatus(List<String> list, List<String> list2, List<FailRet> list3, String str) throws Throwable {
        String str2;
        int i10;
        String str3;
        String str4;
        boolean z10;
        LinkedHashMap linkedHashMap;
        String str5;
        String str6;
        String str7;
        String str8;
        int i11;
        String str9;
        String str10;
        Context context;
        String str11;
        String str12;
        Records.UpdatePatch updatePatch;
        String str13;
        int i12;
        String str14 = "failSize";
        String str15 = "sucSize";
        if (list == null || list.isEmpty()) {
            return;
        }
        DriveSyncUtil.m18002l(this.mSyncType, str);
        String str16 = "";
        try {
            C11839m.m70688i(TAG, "syncV2 Refund = updateRecordLostStatus, syncType = " + this.mSyncType + ", dataType = " + this.mDataType + ", traceID = " + this.traceId);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateSize = ");
            sb2.append(list.size());
            sb2.append(", detail = ");
            sb2.append(list.toString());
            C11839m.m70686d(TAG, sb2.toString());
            int maxBatchNum = getMaxBatchNum();
            String strM17959D = DriveSyncUtil.m17959D(this.mSyncType);
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
            CloudSyncBatch cloudSyncBatchM59243b = c9453iM7268d.m59243b();
            int size = list.size();
            int i13 = 0;
            for (String str17 : list) {
                try {
                } catch (IOException e10) {
                    e = e10;
                    str11 = str14;
                    str12 = str15;
                    str2 = str16;
                } catch (Throwable th2) {
                    th = th2;
                    str11 = str14;
                    str12 = str15;
                    str2 = str16;
                }
                try {
                    if (str17 == null) {
                        size--;
                        str11 = str14;
                        str12 = str15;
                        str2 = str16;
                    } else {
                        str2 = str16;
                        try {
                            if (C12316j0.m74076d().m74086k(strM17959D, this.mDataType, str17)) {
                                try {
                                    FailRet failRet = new FailRet();
                                    failRet.setRecordId(str17);
                                    failRet.setErrCode(SNSCode.Status.GET_FRIEND_LIST_FAIL);
                                    failRet.setErrMsg("update record not exits, over times");
                                    list3.add(failRet);
                                    size--;
                                    str11 = str14;
                                    str12 = str15;
                                } catch (IOException e11) {
                                    e = e11;
                                    String str18 = str15;
                                    str3 = str14;
                                    str4 = str18;
                                    i10 = 5;
                                    try {
                                        procException(e, "updateRecordLostStatus", str);
                                        C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
                                        linkedHashMap = new LinkedHashMap();
                                        linkedHashMap.put("dataType", this.mDataType);
                                        linkedHashMap.put(str4, String.valueOf(list2.size()));
                                        linkedHashMap.put(str3, String.valueOf(list3.size()));
                                        linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                        Context context2 = this.mContext;
                                        str10 = this.mSyncType;
                                        str9 = this.mDataType;
                                        str5 = this.traceId;
                                        z10 = false;
                                        str7 = "03001";
                                        context = context2;
                                        i11 = 5;
                                        str8 = str2;
                                        str6 = str;
                                        C10812z.m65847p(context, str10, str9, i11, str8, str7, str6, str5, linkedHashMap, z10);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
                                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                        linkedHashMap2.put("dataType", this.mDataType);
                                        linkedHashMap2.put(str4, String.valueOf(list2.size()));
                                        linkedHashMap2.put(str3, String.valueOf(list3.size()));
                                        linkedHashMap2.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str2, "03001", str, this.traceId, linkedHashMap2, false);
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    i10 = 0;
                                    String str19 = str15;
                                    str3 = str14;
                                    str4 = str19;
                                    C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
                                    LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                                    linkedHashMap22.put("dataType", this.mDataType);
                                    linkedHashMap22.put(str4, String.valueOf(list2.size()));
                                    linkedHashMap22.put(str3, String.valueOf(list3.size()));
                                    linkedHashMap22.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str2, "03001", str, this.traceId, linkedHashMap22, false);
                                    throw th;
                                }
                            } else {
                                Record record = new Record();
                                record.setId(str17);
                                record.setStatus(1);
                                str11 = str14;
                                try {
                                    updatePatch = c9453iM7268d.m59247f().updatePatch(strM17959D, this.mDataType, str17, record);
                                    str13 = strM17959D;
                                    str12 = str15;
                                } catch (IOException e12) {
                                    e = e12;
                                    str12 = str15;
                                    str3 = str11;
                                    str4 = str12;
                                    i10 = 5;
                                    procException(e, "updateRecordLostStatus", str);
                                    C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
                                    linkedHashMap = new LinkedHashMap();
                                    linkedHashMap.put("dataType", this.mDataType);
                                    linkedHashMap.put(str4, String.valueOf(list2.size()));
                                    linkedHashMap.put(str3, String.valueOf(list3.size()));
                                    linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                    Context context22 = this.mContext;
                                    str10 = this.mSyncType;
                                    str9 = this.mDataType;
                                    str5 = this.traceId;
                                    z10 = false;
                                    str7 = "03001";
                                    context = context22;
                                    i11 = 5;
                                    str8 = str2;
                                    str6 = str;
                                    C10812z.m65847p(context, str10, str9, i11, str8, str7, str6, str5, linkedHashMap, z10);
                                } catch (Throwable th5) {
                                    th = th5;
                                    str12 = str15;
                                    str3 = str11;
                                    str4 = str12;
                                    i10 = 0;
                                    C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
                                    LinkedHashMap linkedHashMap222 = new LinkedHashMap();
                                    linkedHashMap222.put("dataType", this.mDataType);
                                    linkedHashMap222.put(str4, String.valueOf(list2.size()));
                                    linkedHashMap222.put(str3, String.valueOf(list3.size()));
                                    linkedHashMap222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str2, "03001", str, this.traceId, linkedHashMap222, false);
                                    throw th;
                                }
                                try {
                                    DriveSyncUtil.m17994g(updatePatch.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                                    updatePatch.setFields2("attributes,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version");
                                    updatePatch.queue(cloudSyncBatchM59243b, new C9452h(str17, list2, list3));
                                    i13++;
                                    int i14 = size;
                                    i12 = i13;
                                    if ((i12 % maxBatchNum != 0 || i14 == i12) && cloudSyncBatchM59243b.size() > 0) {
                                        cloudSyncBatchM59243b.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                                        cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                                    }
                                    size = i14;
                                    i13 = i12;
                                    str16 = str2;
                                    str14 = str11;
                                    strM17959D = str13;
                                    str15 = str12;
                                } catch (IOException e13) {
                                    e = e13;
                                    str3 = str11;
                                    str4 = str12;
                                    i10 = 5;
                                    procException(e, "updateRecordLostStatus", str);
                                    C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
                                    linkedHashMap = new LinkedHashMap();
                                    linkedHashMap.put("dataType", this.mDataType);
                                    linkedHashMap.put(str4, String.valueOf(list2.size()));
                                    linkedHashMap.put(str3, String.valueOf(list3.size()));
                                    linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                    Context context222 = this.mContext;
                                    str10 = this.mSyncType;
                                    str9 = this.mDataType;
                                    str5 = this.traceId;
                                    z10 = false;
                                    str7 = "03001";
                                    context = context222;
                                    i11 = 5;
                                    str8 = str2;
                                    str6 = str;
                                    C10812z.m65847p(context, str10, str9, i11, str8, str7, str6, str5, linkedHashMap, z10);
                                } catch (Throwable th6) {
                                    th = th6;
                                    str3 = str11;
                                    str4 = str12;
                                    i10 = 0;
                                    C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
                                    LinkedHashMap linkedHashMap2222 = new LinkedHashMap();
                                    linkedHashMap2222.put("dataType", this.mDataType);
                                    linkedHashMap2222.put(str4, String.valueOf(list2.size()));
                                    linkedHashMap2222.put(str3, String.valueOf(list3.size()));
                                    linkedHashMap2222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str2, "03001", str, this.traceId, linkedHashMap2222, false);
                                    throw th;
                                }
                            }
                        } catch (IOException e14) {
                            e = e14;
                            str11 = str14;
                        } catch (Throwable th7) {
                            th = th7;
                            str11 = str14;
                        }
                    }
                    if (i12 % maxBatchNum != 0) {
                        cloudSyncBatchM59243b.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                        cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                    } else {
                        cloudSyncBatchM59243b.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                        cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                    }
                    size = i14;
                    i13 = i12;
                    str16 = str2;
                    str14 = str11;
                    strM17959D = str13;
                    str15 = str12;
                } catch (IOException e15) {
                    e = e15;
                    str3 = str11;
                    str4 = str12;
                    i10 = 5;
                    procException(e, "updateRecordLostStatus", str);
                    C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
                    linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("dataType", this.mDataType);
                    linkedHashMap.put(str4, String.valueOf(list2.size()));
                    linkedHashMap.put(str3, String.valueOf(list3.size()));
                    linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                    Context context2222 = this.mContext;
                    str10 = this.mSyncType;
                    str9 = this.mDataType;
                    str5 = this.traceId;
                    z10 = false;
                    str7 = "03001";
                    context = context2222;
                    i11 = 5;
                    str8 = str2;
                    str6 = str;
                    C10812z.m65847p(context, str10, str9, i11, str8, str7, str6, str5, linkedHashMap, z10);
                } catch (Throwable th8) {
                    th = th8;
                    str3 = str11;
                    str4 = str12;
                    i10 = 0;
                    C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
                    LinkedHashMap linkedHashMap22222 = new LinkedHashMap();
                    linkedHashMap22222.put("dataType", this.mDataType);
                    linkedHashMap22222.put(str4, String.valueOf(list2.size()));
                    linkedHashMap22222.put(str3, String.valueOf(list3.size()));
                    linkedHashMap22222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str2, "03001", str, this.traceId, linkedHashMap22222, false);
                    throw th;
                }
                str13 = strM17959D;
                int i142 = size;
                i12 = i13;
            }
            C11839m.m70688i(TAG, "syncV2 Refund result: dataType = " + this.mDataType + ", success size = " + list2.size() + ", fail size = " + list3.size());
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("dataType", this.mDataType);
            linkedHashMap.put(str15, String.valueOf(list2.size()));
            linkedHashMap.put(str14, String.valueOf(list3.size()));
            linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
            Context context3 = this.mContext;
            str10 = this.mSyncType;
            str9 = this.mDataType;
            str5 = this.traceId;
            z10 = false;
            str7 = "03001";
            context = context3;
            i11 = 0;
            str8 = str16;
            str6 = str;
        } catch (IOException e16) {
            e = e16;
            str2 = str16;
        } catch (Throwable th9) {
            th = th9;
            str2 = str16;
            i10 = 0;
            String str20 = str15;
            str3 = str14;
            str4 = str20;
        }
        C10812z.m65847p(context, str10, str9, i11, str8, str7, str6, str5, linkedHashMap, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x021e A[Catch: all -> 0x0242, LOOP:1: B:153:0x0218->B:155:0x021e, LOOP_END, TryCatch #1 {all -> 0x0242, blocks: (B:152:0x0214, B:153:0x0218, B:155:0x021e, B:158:0x0244), top: B:165:0x0214 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateRecords(java.lang.String r27, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record> r28, java.util.Map<java.lang.String, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record>> r29, java.util.Map<java.lang.String, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet>> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.SyncProcessBase.updateRecords(java.lang.String, java.util.List, java.util.Map, java.util.Map):void");
    }

    public void updateRecycleRecords(List<Record> list, List<Record> list2, List<FailRet> list3, String str) throws Throwable {
        StringBuilder sb2;
        String str2;
        Iterator<Record> it;
        CloudSyncBatch cloudSyncBatch;
        int i10;
        int i11;
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
        DriveSyncUtil.m18002l(this.mSyncType, str);
        int maxBatchNum = getMaxBatchNum();
        try {
            try {
                C11839m.m70688i(TAG, "syncV2 Method = updateRecycleRecords, syncType = " + this.mSyncType + ", dataType = " + this.mDataType + ", traceID = " + this.traceId);
                String strM17959D = DriveSyncUtil.m17959D(this.mSyncType);
                CloudSyncBatch cloudSyncBatchM59243b = c9453iM7268d.m59243b();
                int size = list.size();
                CloudSyncBatch cloudSyncBatchM59243b2 = cloudSyncBatchM59243b;
                int i12 = size;
                int i13 = 0;
                for (Iterator<Record> it2 = list.iterator(); it2.hasNext(); it2 = it) {
                    Record next = it2.next();
                    if (next == null) {
                        str2 = strM17959D;
                        it = it2;
                        i10 = i12 - 1;
                        i11 = i13;
                        cloudSyncBatch = cloudSyncBatchM59243b2;
                    } else {
                        String id2 = next.getId();
                        if (C12316j0.m74076d().m74086k(strM17959D, this.mDataType, id2)) {
                            try {
                                FailRet failRet = new FailRet();
                                failRet.setRecordId(id2);
                                failRet.setErrCode(SNSCode.Status.GET_FRIEND_LIST_FAIL);
                                failRet.setErrMsg("update record not exits, over times");
                                list3.add(failRet);
                                str2 = strM17959D;
                                it = it2;
                                i10 = i12 - 1;
                                i11 = i13;
                                cloudSyncBatch = cloudSyncBatchM59243b2;
                            } catch (IOException e10) {
                                e = e10;
                                procException(e, "updateRecycleRecords", str);
                                sb2 = new StringBuilder();
                                sb2.append("syncV2 Method result: dataType = ");
                                sb2.append(this.mDataType);
                                sb2.append(", updateRecycleSucSize = ");
                                sb2.append(list2.size());
                                sb2.append(", updateRecycleFailSize = ");
                                sb2.append(list3.size());
                                C11839m.m70688i(TAG, sb2.toString());
                            } catch (Throwable th2) {
                                th = th2;
                                C11839m.m70688i(TAG, "syncV2 Method result: dataType = " + this.mDataType + ", updateRecycleSucSize = " + list2.size() + ", updateRecycleFailSize = " + list3.size());
                                throw th;
                            }
                        } else {
                            Records.UpdatePatch updatePatchAddHeader = c9453iM7268d.m59247f().updatePatch(strM17959D, this.mDataType, id2, next).addHeader("x-hw-lock", (Object) this.lockToken);
                            DriveSyncUtil.m17994g(updatePatchAddHeader.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                            updatePatchAddHeader.setMode("normal").setFields2("attributes,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version");
                            str2 = strM17959D;
                            it = it2;
                            cloudSyncBatch = cloudSyncBatchM59243b2;
                            updatePatchAddHeader.queue(cloudSyncBatch, new C9451g(strM17959D, this.mDataType, next.getId(), list2, list3));
                            i10 = i12;
                            i11 = i13 + 1;
                        }
                    }
                    if ((i11 % maxBatchNum == 0 || i10 == i11) && cloudSyncBatch.size() > 0) {
                        cloudSyncBatch.execute(this.mSyncType, this.mSyncModulePackageName, this.traceId);
                        cloudSyncBatchM59243b2 = c9453iM7268d.m59243b();
                    } else {
                        cloudSyncBatchM59243b2 = cloudSyncBatch;
                    }
                    i12 = i10;
                    i13 = i11;
                    strM17959D = str2;
                }
                sb2 = new StringBuilder();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e11) {
            e = e11;
        }
        sb2.append("syncV2 Method result: dataType = ");
        sb2.append(this.mDataType);
        sb2.append(", updateRecycleSucSize = ");
        sb2.append(list2.size());
        sb2.append(", updateRecycleFailSize = ");
        sb2.append(list3.size());
        C11839m.m70688i(TAG, sb2.toString());
    }

    public Asset updateSingleAssetRevision(String str, String str2, String str3, String str4, String str5, String str6, Asset asset, String str7) throws C9722c {
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(str);
        DriveSyncUtil.m18002l(this.mSyncType, str7);
        Asset asset2 = null;
        try {
            Assets.Revisions.Update updateAddHeader = c9453iM7268d.m59242a().revisions().update(DriveSyncUtil.m17959D(str), str2, str4, str5, str6, "attributes,cipher,createdTime,id,mimeType,modifiedTime,resource,state,version,versionId,status", asset).addHeader("x-hw-lock", (Object) this.lockToken);
            DriveSyncUtil.m17994g(updateAddHeader.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
            Asset assetExecute = updateAddHeader.execute();
            try {
                DriveSyncUtil.m17985b0(1, updateAddHeader.getLastResponseHeaders());
                return assetExecute;
            } catch (IOException e10) {
                e = e10;
                asset2 = assetExecute;
                procException(e, "updateSingleAssetRevision", str7);
                C11839m.m70687e(TAG, "updateSingleAssetRevision error, dataType = " + str2 + ", fileName = " + str3 + ", assetId = " + str5);
                return asset2;
            }
        } catch (IOException e11) {
            e = e11;
        }
    }

    public void uploadSetExtraParam(SyncData syncData, Record record) {
        if (syncData == null || syncData.getExtraParam() == null || record == null || record.getAttributes() == null || !"calendar".equals(this.mSyncType)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(syncData.getExtraParam());
            Map<String, Object> attributes = record.getAttributes();
            if (!TextUtils.isEmpty(jSONObject.optString("calendarId"))) {
                attributes.put("calendarId", jSONObject.optString("calendarId"));
            }
            if (!TextUtils.isEmpty(jSONObject.optString("uuid"))) {
                attributes.put("uuid", jSONObject.optString("uuid"));
            }
            if (TextUtils.isEmpty(jSONObject.optString(SyncProtocol.Constant.CALENDAR_UUID))) {
                return;
            }
            attributes.put(SyncProtocol.Constant.CALENDAR_UUID, jSONObject.optString(SyncProtocol.Constant.CALENDAR_UUID));
        } catch (JSONException e10) {
            C11839m.m70689w(TAG, "setRecordExtraParam error " + e10.getMessage());
        }
    }

    public boolean isCloudDataChanged(Ctag ctag, String str) {
        C11839m.m70688i(TAG, "syncV2 isCloudDataChanged localCtag = " + str);
        if (ctag != null && ctag.getStatus() != 203) {
            if (str != null && str.equals(ctag.getCtag())) {
                C11839m.m70688i(TAG, "Local ctag is equal to cloud ctag");
                return false;
            }
            C11839m.m70686d(TAG, "syncV2 isCloudDataChanged cloudCtag = " + ctag.getCtag());
        }
        return true;
    }

    private boolean isSyncTokenProcess() {
        return isSyncTokenProcess(this.mSyncType);
    }

    public void syncV2(String str, boolean z10) throws Throwable {
        if (z10) {
            C11839m.m70688i(TAG, "syncV2 download mode only, no need to lock.");
            getStartCursor(str);
        } else {
            subscribe(str);
            getLockV2(str);
            getStartCursor(str);
        }
    }

    public SyncProcessBase(Context context, String str, String str2, String str3, String str4, String str5, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        this.lockToken = "";
        this.mContext = context;
        this.mSyncType = str;
        this.mDataType = str2;
        this.operationType = str3;
        this.traceId = str4;
        this.mSyncModulePackageName = str5;
        this.lockToken = C13007b.m78205Y(context).m78224J(str, this.mSyncModulePackageName);
        this.serverFlowControlEffected = concurrentHashMap;
        this.protocol = new SyncProtocol(context, str, str2, str3, str4, this.mSyncModulePackageName);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01e6 A[Catch: all -> 0x020a, LOOP:1: B:112:0x01e0->B:114:0x01e6, LOOP_END, TryCatch #5 {all -> 0x020a, blocks: (B:111:0x01dc, B:112:0x01e0, B:114:0x01e6, B:117:0x020c), top: B:124:0x01dc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void createRecords(java.lang.String r31, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record> r32, java.util.Map<java.lang.String, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record>> r33, java.util.Map<java.lang.String, java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet>> r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.SyncProcessBase.createRecords(java.lang.String, java.util.List, java.util.Map, java.util.Map):void");
    }
}
