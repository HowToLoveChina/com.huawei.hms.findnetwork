package p736wc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import cd.C1421d;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.Usage;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncutil.C2977f;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.AssetList;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9721b;
import fk.C9722c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import je.C10812z;
import p015ak.C0209d;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p664u0.C13108a;
import p709vj.C13452e;
import p746wn.C13622a;
import sb.C12767a;
import vc.C13404h;

/* renamed from: wc.e */
/* loaded from: classes3.dex */
public class C13585e extends SyncProcessBase {

    /* renamed from: k */
    public static long f61100k;

    /* renamed from: a */
    public List<String> f61101a;

    /* renamed from: b */
    public List<SyncData> f61102b;

    /* renamed from: c */
    public boolean f61103c;

    /* renamed from: d */
    public String f61104d;

    /* renamed from: e */
    public CopyOnWriteArrayList<UnstructData> f61105e;

    /* renamed from: f */
    public ArrayList<UnstructData> f61106f;

    /* renamed from: g */
    public ArrayList<UnstructData> f61107g;

    /* renamed from: h */
    public Map<String, Integer> f61108h;

    /* renamed from: i */
    public ExecutorService f61109i;

    /* renamed from: j */
    public final String f61110j;

    /* renamed from: wc.e$a */
    public class a implements Callable<Boolean> {

        /* renamed from: a */
        public Usage f61111a;

        public a(Usage usage) {
            this.f61111a = usage;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            if (this.f61111a == null) {
                return Boolean.FALSE;
            }
            C11839m.m70688i("GenSaveResultImpl", "syncV2 SyncDownLoadFileTask download file, RecordId: " + this.f61111a.getRecordId() + ", name: " + this.f61111a.getUsage());
            return C13585e.this.m81605d(this.f61111a);
        }
    }

    public C13585e(Context context, String str, String str2, List<SyncData> list, List<String> list2, boolean z10, String str3, String str4, String str5, String str6, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f61101a = new ArrayList(10);
        this.f61102b = new ArrayList(10);
        this.f61103c = false;
        this.f61104d = null;
        this.f61105e = new CopyOnWriteArrayList<>();
        this.f61106f = new ArrayList<>();
        this.f61107g = new ArrayList<>();
        this.f61108h = new HashMap();
        this.mContext = context;
        if (list2 != null) {
            this.f61101a = list2;
        }
        if (list != null) {
            this.f61102b = list;
        }
        this.f61103c = z10;
        this.f61110j = str6;
        this.f61104d = this.mContext.getFilesDir() + "/sync/" + this.mDataType + "/sync_download";
        C11839m.m70688i("GenSaveResultImpl", "Sync type = " + this.mSyncType + ", dataType = " + this.mDataType + ", save size = " + this.f61102b.size() + " delete size = " + this.f61101a.size() + ", isUpload = " + z10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mDataType);
        sb2.append(" Save list: ");
        sb2.append(this.f61102b.toString());
        sb2.append("delete list: ");
        sb2.append(this.f61101a.toString());
        C11839m.m70686d("GenSaveResultImpl", sb2.toString());
    }

    /* renamed from: b */
    private void m81603b(int i10) {
        C11839m.m70688i("GenSaveResultImpl", this.mDataType + " CallBack, value = " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        if (this.f61103c) {
            intent.putExtra("msgID", 10003);
        } else {
            intent.putExtra("msgID", 10004);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        appendBundleParamToSaveResult(bundle, this.f61110j);
        if (!this.f61103c && i10 == 0) {
            if (!this.f61107g.isEmpty()) {
                CloudSyncUtil.m15988Y0(this.mContext, this.mSyncType, true);
            }
            this.f61106f.addAll(this.f61105e);
            bundle.putParcelableArrayList("unstructresult", this.f61106f);
            bundle.putParcelableArrayList("unstructfailresult", this.f61107g);
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(SyncLogicServiceUtil.buildFailErrorCodeMap(this.f61108h));
            bundle.putSerializable("fail_error_code_map", serializableMap);
            C11839m.m70688i("GenSaveResultImpl", this.mDataType + " failIdMap size: " + this.f61108h.size());
        }
        if (i10 == 0) {
            C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 0, "", this.operationType, "batch_of_local_download_unstruct", this.traceId);
        }
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
        CloudSyncUtil.m15993a1(this.mContext, this.mSyncType, i10);
    }

    /* renamed from: c */
    private void m81604c(List<UnstructData> list, List<Usage> list2) throws C9722c {
        C11839m.m70688i("GenSaveResultImpl", "syncV2 Enter downAndRestoreAssetFile data");
        File file = new File(this.f61104d);
        if (!C13582b.m81588a(file)) {
            C11839m.m70688i("GenSaveResultImpl", "syncV2 delete dir fail");
            this.f61107g.addAll(list);
        } else if (file.exists() || file.mkdirs()) {
            m81606e(list2);
            m81609h();
        } else {
            C11839m.m70688i("GenSaveResultImpl", "syncV2 create file fail");
            this.f61107g.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Boolean m81605d(Usage usage) throws C9722c {
        if (usage == null) {
            C11839m.m70689w("GenSaveResultImpl", "syncV2 downLoadAssetFile usage is null ");
            return Boolean.FALSE;
        }
        String str = this.f61104d + "/" + usage.getUsage();
        C11839m.m70686d("GenSaveResultImpl", "syncV2 downLoadAssetFile localPath: " + str);
        try {
            isCancel();
            String strM17958C = DriveSyncUtil.m17958C(this.mSyncType);
            if (!C0209d.m1208S0(this.mContext)) {
                C11839m.m70689w("GenSaveResultImpl", "downLoadAssetFile network not connect error ");
                throw new C9722c(2028, "network not connect error", this.mSyncType, "local_download_struct");
            }
            AssetList assetList = getAssetList(usage.getRecordId(), usage.getUsage(), "assets(cipher,createdTime,id,keepPolicy,mimeType,modifiedTime,resource,state,version,versionId,lastModifyingUser,scaState,properties,status,appVer)");
            if (assetList == null) {
                C11839m.m70689w("GenSaveResultImpl", "syncV2 downAndRestoreAssetFile Cloud no file : guid:" + usage.getRecordId() + ",name:" + usage.getUsage());
                m81607f(usage, 3207);
                return Boolean.FALSE;
            }
            List<Asset> assets = assetList.getAssets();
            if (assets == null || assets.size() <= 0) {
                C11839m.m70689w("GenSaveResultImpl", "syncV2 downAndRestoreAssetFile Cloud no file: guid:" + usage.getRecordId() + ",name:" + usage.getUsage());
                m81607f(usage, 3207);
                return Boolean.FALSE;
            }
            Asset asset = assets.get(0);
            new C1421d(CloudSyncUtil.m15961L(this.mSyncType), this.traceId, this.mDataType, usage.getRecordId(), strM17958C).m8268a(asset, str, new C13404h(), usage.getUsage(), this.mSyncType, this.mSyncModulePackageName, "local_download_struct");
            if (asset.getResource() != null) {
                f61100k += asset.getResource().getLength().longValue();
            }
            C12767a.m76619c().m76622d(this.mSyncType);
            UnstructData unstructData = usage.getUnstructData();
            if (unstructData != null) {
                this.f61105e.add(unstructData);
            }
            C11839m.m70688i("GenSaveResultImpl", "syncV2 downLoadAssetFile downSuc : " + this.f61105e.size());
            return Boolean.TRUE;
        } catch (C9721b e10) {
            C11839m.m70687e("GenSaveResultImpl", "syncV2 downLoadAssetFile CException : " + e10.getMessage() + ", error code : " + e10.m60659c() + ", recordId: " + usage.getRecordId() + ", fileName: " + usage.getUsage());
            m81607f(usage, e10.m60659c());
            return Boolean.FALSE;
        } catch (C9722c e11) {
            C11839m.m70687e("GenSaveResultImpl", "syncV2 downLoadAssetFile Syncexception: " + e11.getMessage() + ", error code: " + e11.m60666c() + ", recordId: " + usage.getRecordId() + ", fileName: " + usage.getUsage());
            m81607f(usage, e11.m60666c());
            return Boolean.FALSE;
        } catch (Exception e12) {
            C11839m.m70687e("GenSaveResultImpl", "syncV2 downLoadAssetFile error message:" + e12.getMessage() + ", recordId: " + usage.getRecordId() + ", fileName: " + usage.getUsage());
            m81607f(usage, C0209d.m1208S0(this.mContext) ? 2263 : 2028);
            return Boolean.FALSE;
        }
    }

    /* renamed from: e */
    private void m81606e(List<Usage> list) throws C9722c {
        ExecutorService executorService;
        if (list == null || list.isEmpty()) {
            C11839m.m70689w("GenSaveResultImpl", "syncV2 downLoadAssetFileList: downDataList.size is 0 or null");
            return;
        }
        C11839m.m70688i("GenSaveResultImpl", "syncV2 downLoadAssetFileList: downDataList.size = " + list.size());
        if (!C0209d.m1208S0(this.mContext)) {
            C11839m.m70689w("GenSaveResultImpl", "downLoadAssetFileList network not connect error ");
            throw new C9722c(2028, "network not connect error", this.mSyncType, "local_download_struct");
        }
        int iM17960E = 0;
        try {
            try {
                if (this.f61109i == null) {
                    iM17960E = DriveSyncUtil.m17960E();
                    C11839m.m70689w("GenSaveResultImpl", "syncV2 downExecutor null, syncType: " + this.mSyncType + ",dataType: " + this.mDataType + ",create threadsNum: " + iM17960E);
                    this.f61109i = Executors.newFixedThreadPool(iM17960E);
                }
                ArrayList arrayList = new ArrayList();
                for (Usage usage : list) {
                    isCancel();
                    arrayList.add(this.f61109i.submit(new a(usage)));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((Future) it.next()).get();
                    } catch (InterruptedException | ExecutionException e10) {
                        C11839m.m70687e("GenSaveResultImpl", "syncV2 downLoadFileList: " + e10.toString());
                    }
                }
                C11839m.m70686d("GenSaveResultImpl", "syncV2 mDownloadAssetExecutor shutdown");
                executorService = this.f61109i;
                if (executorService == null) {
                    return;
                }
            } catch (Exception e11) {
                C11839m.m70687e("GenSaveResultImpl", "syncV2 downLoadFile error: " + e11.toString());
                C11839m.m70686d("GenSaveResultImpl", "syncV2 mDownloadAssetExecutor shutdown");
                executorService = this.f61109i;
                if (executorService == null) {
                    return;
                }
            }
            executorService.shutdown();
            DriveSyncUtil.m17989d0(iM17960E);
        } catch (Throwable th2) {
            C11839m.m70686d("GenSaveResultImpl", "syncV2 mDownloadAssetExecutor shutdown");
            ExecutorService executorService2 = this.f61109i;
            if (executorService2 != null) {
                executorService2.shutdown();
                DriveSyncUtil.m17989d0(iM17960E);
            }
            throw th2;
        }
    }

    /* renamed from: f */
    private void m81607f(Usage usage, int i10) {
        UnstructData unstructData = usage.getUnstructData();
        if (unstructData != null) {
            this.f61108h.put(unstructData.getId(), Integer.valueOf(i10));
            this.f61107g.add(unstructData);
        }
    }

    /* renamed from: g */
    private void m81608g() throws C9722c {
        C11839m.m70688i("GenSaveResultImpl", "syncV2 Enter processAsset");
        List<SyncData> list = this.f61102b;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<UnstructData> arrayList2 = new ArrayList<>();
        List<Usage> arrayList3 = new ArrayList<>();
        for (SyncData syncData : this.f61102b) {
            C11839m.m70686d("GenSaveResultImpl", "syncV2 processAsset guid :" + syncData.getGuid() + ", data id = " + syncData.getLuid() + ", deleteFileList = " + syncData.getDeleteFileList() + ", downFileList = " + syncData.getDownFileList());
            arrayList.addAll(syncData.getDeleteFileList());
            List<UnstructData> downFileList = syncData.getDownFileList();
            arrayList2.addAll(downFileList);
            for (UnstructData unstructData : downFileList) {
                arrayList3.add(new Usage(syncData.getGuid(), unstructData.getName(), unstructData));
            }
        }
        C11839m.m70688i("GenSaveResultImpl", "syncV2 processAsset deleteFileList size " + arrayList.size() + ", downFileList size " + arrayList2.size() + ",usagesArrayList size :" + arrayList3.size());
        try {
            isCancel();
            if (arrayList2.size() > 0) {
                C2980i.m17882q(this.mReportEndInfo, true);
                m81604c(arrayList2, arrayList3);
            }
        } catch (C9722c e10) {
            C11839m.m70687e("GenSaveResultImpl", "syncV2 processAsset error code: " + e10.m60666c() + " message:" + e10.getMessage());
            throw new C9722c(e10.m60666c(), "GenSaveResultImpl processAsset result fail " + e10.getMessage(), this.mSyncType, "local_download_struct");
        } catch (Exception e11) {
            C11839m.m70687e("GenSaveResultImpl", "syncV2 processAsset exception message:" + e11.getMessage());
            throw new C9722c(2263, "GenSaveResultImpl processAsset result fail " + e11.getMessage(), this.mSyncType, "local_download_struct");
        }
    }

    /* renamed from: h */
    private void m81609h() {
        C11839m.m70688i("GenSaveResultImpl", "Enter restoreAndSaveData");
        try {
            C11839m.m70688i("GenSaveResultImpl", "restoreResult = " + m81610i());
        } catch (Exception e10) {
            C11839m.m70687e("GenSaveResultImpl", "restoreAndSaveData error message:" + e10.getMessage());
        }
    }

    /* renamed from: i */
    private boolean m81610i() throws Exception {
        C11839m.m70686d("GenSaveResultImpl", "Enter restoreFile");
        boolean zM17861d = C2977f.m17861d(this.f61104d, this.traceId, this.mContext);
        C11839m.m70686d("GenSaveResultImpl", "file to zip result = " + zM17861d);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C11060c c11060cM66626a = C11058a.m66626a(this.traceId, "restoreFile_begin", strM80971t0);
        c11060cM66626a.m66665u("0");
        C13622a.m81968n(this.mContext, c11060cM66626a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11060c c11060cM66626a2 = C11058a.m66626a(this.traceId, "restoreFile_end", strM80971t0);
        if (!zM17861d) {
            c11060cM66626a2.m66665u(String.valueOf(2228));
            c11060cM66626a2.m66635A("file to zip result false");
            C13622a.m81968n(this.mContext, c11060cM66626a2);
            return false;
        }
        Uri providerUri = GenSyncLogicServiceUtil.getProviderUri(2, this.mSyncType, this.mDataType, null, this.mSyncModulePackageName);
        if (providerUri == null) {
            c11060cM66626a2.m66665u(String.valueOf(2229));
            c11060cM66626a2.m66635A("destUri is nul");
            C13622a.m81968n(this.mContext, c11060cM66626a2);
            C11839m.m70688i("GenSaveResultImpl", "destUri is nul");
            return false;
        }
        if (NotifyUtil.isTargetAppInWhitelist(this.mContext, providerUri, this.mSyncType)) {
            return startSyncRestoreFile(new File(this.f61104d + "/sync_download.zip"), providerUri, c11060cM66626a2, "restoreFile Success", jCurrentTimeMillis);
        }
        c11060cM66626a2.m66665u(String.valueOf(2229));
        c11060cM66626a2.m66635A("TargetApp is not valid.");
        C13622a.m81968n(this.mContext, c11060cM66626a2);
        C11839m.m70687e("GenSaveResultImpl", "TargetApp is not valid.");
        return false;
    }

    /* renamed from: j */
    public int m81611j() {
        File file;
        String message = "";
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iM60666c = 0;
        try {
            try {
                isCancel();
                if (!this.f61103c) {
                    isCancel();
                    m81608g();
                }
                isCancel();
                m81603b(0);
                file = new File(this.f61104d);
            } catch (C9722c e10) {
                iM60666c = e10.m60666c();
                message = e10.getMessage();
                C10812z.m65841j(this.mContext, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
                m81603b(iM60666c);
                file = new File(this.f61104d);
            } catch (Exception e11) {
                iM60666c = 5;
                message = e11.getMessage();
                C11839m.m70687e("GenSaveResultImpl", this.mDataType + " Exception occurred = " + e11.toString());
                C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 5, e11.toString(), this.operationType, "local_download_struct", this.traceId);
                m81603b(5);
                file = new File(this.f61104d);
            }
            C13582b.m81588a(file);
            C2980i.m17879n(this.mReportEndInfo, iM60666c, message);
            C2980i.m17873h(this.mReportEndInfo, this.mDataType, f61100k);
            C2980i.m17874i(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
            return iM60666c;
        } catch (Throwable th2) {
            m81603b(0);
            C13582b.m81588a(new File(this.f61104d));
            C2980i.m17879n(this.mReportEndInfo, 0, "");
            C2980i.m17873h(this.mReportEndInfo, this.mDataType, f61100k);
            C2980i.m17874i(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
            throw th2;
        }
    }
}
