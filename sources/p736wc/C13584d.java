package p736wc;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import cd.C1421d;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncutil.C2977f;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.AssetList;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9721b;
import fk.C9722c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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

/* renamed from: wc.d */
/* loaded from: classes3.dex */
public class C13584d extends SyncProcessBase {

    /* renamed from: a */
    public String f61095a;

    /* renamed from: b */
    public List<UnstructData> f61096b;

    /* renamed from: c */
    public ArrayList<UnstructData> f61097c;

    /* renamed from: d */
    public ArrayList<UnstructData> f61098d;

    /* renamed from: e */
    public Map<String, Integer> f61099e;

    public C13584d(Context context, String str, String str2, List<UnstructData> list, String str3, String str4, String str5, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f61095a = null;
        this.f61096b = new ArrayList();
        this.f61097c = new ArrayList<>();
        this.f61098d = new ArrayList<>();
        this.f61099e = new HashMap();
        this.mContext = context;
        if (list != null) {
            this.f61096b = list;
        }
        this.f61095a = this.mContext.getFilesDir() + "/sync/" + this.mDataType + "/sync_download";
        C11839m.m70686d("GenQueryUnstructDataImpl", "SaveResultImpl ,type = " + this.mSyncType + ", dataType = " + this.mDataType + ", downSuc = " + this.f61096b.toString());
    }

    /* renamed from: a */
    private void m81594a(int i10) {
        C11839m.m70688i("GenQueryUnstructDataImpl", "CallBack, value = " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10005);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        if (i10 == 0) {
            bundle.putParcelableArrayList("unstructresult", this.f61097c);
            bundle.putParcelableArrayList("unstructfailresult", this.f61098d);
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(SyncLogicServiceUtil.buildFailErrorCodeMap(this.f61099e));
            bundle.putSerializable("fail_error_code_map", serializableMap);
            C11839m.m70686d("GenQueryUnstructDataImpl", "failIdMap : " + this.f61099e.toString());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("isCharging", String.valueOf(C0209d.m1196O0(this.mContext)));
            C10812z.m65842k(this.mContext, this.mSyncType, this.mDataType, 0, "", "", this.operationType, "batch_of_single_downUnstruct_end", this.traceId, linkedHashMap, false);
        }
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
    }

    /* renamed from: b */
    private void m81595b(InputStream inputStream, AssetFileDescriptor assetFileDescriptor, OutputStream outputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e10) {
                C11839m.m70687e("GenQueryUnstructDataImpl", "doEachRestore exception: " + e10.toString());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e11) {
                C11839m.m70687e("GenQueryUnstructDataImpl", "doEachRestore exception: " + e11.toString());
            }
        }
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (Exception e12) {
                C11839m.m70687e("GenQueryUnstructDataImpl", "doEachRestore exception: " + e12.toString());
            }
        }
    }

    /* renamed from: c */
    private void m81596c(List<UnstructData> list) throws C9722c {
        String str;
        String strM17958C;
        List<Asset> assets;
        Asset asset;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (UnstructData unstructData : list) {
            try {
                str = this.f61095a + "/" + unstructData.getName();
                C11839m.m70686d("GenQueryUnstructDataImpl", "syncV2 localPath = " + str);
                isCancel();
                strM17958C = DriveSyncUtil.m17958C(this.mSyncType);
            } catch (C9721b e10) {
                C11839m.m70687e("GenQueryUnstructDataImpl", "syncV2 downAndRestoreAssetFile CException : " + e10.toString() + ", error code : " + e10.m60659c() + ", recordId = " + unstructData.getUnstructUuid() + ", fileName: " + unstructData.getName());
                m81597d(unstructData, e10.m60659c());
            } catch (C9722c e11) {
                C11839m.m70687e("GenQueryUnstructDataImpl", "syncV2 downAndRestoreAssetFile syncException : " + e11.toString() + ", error code : " + e11.m60666c() + ", recordId = " + unstructData.getUnstructUuid() + ", fileName: " + unstructData.getName());
                m81597d(unstructData, e11.m60666c());
            } catch (Exception e12) {
                C11839m.m70687e("GenQueryUnstructDataImpl", "syncV2 downAndRestoreAssetFile error message:" + e12.getMessage() + ", recordId = " + unstructData.getUnstructUuid() + ", fileName: " + unstructData.getName());
                m81597d(unstructData, C0209d.m1208S0(this.mContext) ? 2263 : 2028);
            }
            if (!C0209d.m1208S0(this.mContext)) {
                C11839m.m70689w("GenQueryUnstructDataImpl", "downAndRestoreAssetFile network not connect error ");
                throw new C9722c(2028, "network not connect error", this.mSyncType, "single_download_struct");
            }
            AssetList assetList = getAssetList(unstructData.getUnstructUuid(), unstructData.getName(), "assets(cipher,createdTime,id,keepPolicy,mimeType,modifiedTime,resource,state,version,versionId,lastModifyingUser,scaState,properties,status,appVer)");
            if (assetList == null || (assets = assetList.getAssets()) == null || assets.size() <= 0 || (asset = assets.get(0)) == null) {
                C11839m.m70687e("GenQueryUnstructDataImpl", "syncV2 downAndRestoreAssetFile Cloud no file: guid:" + unstructData.getUnstructUuid() + ",name:" + unstructData.getName());
                m81597d(unstructData, 3207);
            } else {
                new C1421d(CloudSyncUtil.m15961L(this.mSyncType), this.traceId, this.mDataType, unstructData.getUnstructUuid(), strM17958C).m8268a(asset, str, new C13404h(), unstructData.getName(), this.mSyncType, this.mSyncModulePackageName, "single_download_struct");
                C12767a.m76619c().m76622d(this.mSyncType);
                this.f61097c.add(unstructData);
            }
        }
        m81598f();
    }

    /* renamed from: d */
    private void m81597d(UnstructData unstructData, int i10) {
        if (unstructData != null) {
            this.f61099e.put(unstructData.getId(), Integer.valueOf(i10));
            this.f61098d.add(unstructData);
        }
    }

    /* renamed from: f */
    private void m81598f() {
        C11839m.m70688i("GenQueryUnstructDataImpl", "Enter restoreAndSaveData");
        try {
            C11839m.m70688i("GenQueryUnstructDataImpl", "restoreResult = " + m81599g());
        } catch (Exception e10) {
            C11839m.m70687e("GenQueryUnstructDataImpl", "restoreAndSaveData error message:" + e10.getMessage());
        }
    }

    /* renamed from: g */
    private boolean m81599g() throws Exception {
        C11839m.m70686d("GenQueryUnstructDataImpl", "Enter restoreFile");
        boolean zM17861d = C2977f.m17861d(this.f61095a, this.traceId, this.mContext);
        C11839m.m70686d("GenQueryUnstructDataImpl", "file to zip result = " + zM17861d);
        String str = this.traceId;
        String strM66627b = (str == null || str.isEmpty()) ? C11058a.m66627b("00000") : this.traceId;
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "restoreFile_begin", strM80971t0);
        c11060cM66626a.m66665u("0");
        C13622a.m81968n(this.mContext, c11060cM66626a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11060c c11060cM66626a2 = C11058a.m66626a(strM66627b, "restoreFile_end", strM80971t0);
        c11060cM66626a2.m66665u("0");
        if (!zM17861d) {
            return false;
        }
        Uri providerUri = GenSyncLogicServiceUtil.getProviderUri(2, this.mSyncType, this.mDataType, null, this.mSyncModulePackageName);
        if (providerUri == null) {
            c11060cM66626a2.m66665u(String.valueOf(2229));
            c11060cM66626a2.m66635A("destUri is nul");
            C11839m.m70688i("GenQueryUnstructDataImpl", "destUri is nul");
            return false;
        }
        if (!NotifyUtil.isTargetAppInWhitelist(this.mContext, providerUri, this.mSyncType)) {
            c11060cM66626a2.m66665u(String.valueOf(2229));
            c11060cM66626a2.m66635A("TargetApp is not in om config.");
            C11839m.m70687e("GenQueryUnstructDataImpl", "TargetApp is not in om config.");
            return false;
        }
        return m81600h(new File(this.f61095a + "/sync_download.zip"), providerUri, c11060cM66626a2, "restoreFile Success", jCurrentTimeMillis);
    }

    /* renamed from: h */
    private boolean m81600h(File file, Uri uri, C11060c c11060c, String str, long j10) throws Throwable {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            C11839m.m70686d("GenQueryUnstructDataImpl", "open file restore");
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    assetFileDescriptorOpenAssetFileDescriptor = this.mContext.getContentResolver().openAssetFileDescriptor(uri, "rwxrwxrwx");
                    if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                        m81595b(fileInputStream2, assetFileDescriptorOpenAssetFileDescriptor, null);
                        return false;
                    }
                    try {
                        fileOutputStream = new FileOutputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                        while (true) {
                            try {
                                int i10 = fileInputStream2.read(bArr);
                                if (i10 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i10);
                            } catch (Exception e10) {
                                e = e10;
                                fileInputStream = fileInputStream2;
                                try {
                                    String string = e.toString();
                                    c11060c.m66665u(String.valueOf(2229));
                                    c11060c.m66635A(string);
                                    C11839m.m70687e("GenQueryUnstructDataImpl", "doEachRestore exception:" + string);
                                    m81595b(fileInputStream, assetFileDescriptorOpenAssetFileDescriptor, fileOutputStream);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    m81595b(fileInputStream, assetFileDescriptorOpenAssetFileDescriptor, fileOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream2;
                                m81595b(fileInputStream, assetFileDescriptorOpenAssetFileDescriptor, fileOutputStream);
                                throw th;
                            }
                        }
                        c11060c.m66665u("0");
                        c11060c.m66635A(str);
                        m81595b(fileInputStream2, assetFileDescriptorOpenAssetFileDescriptor, fileOutputStream);
                        try {
                            this.mContext.getContentResolver().update(uri, new ContentValues(), null, null);
                        } catch (Exception e11) {
                            C11839m.m70687e("GenQueryUnstructDataImpl", "startRestoreFile update exception:" + e11.toString());
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
        } else {
            c11060c.m66665u(String.valueOf(2229));
            c11060c.m66635A("zipPath path not find");
            C11839m.m70687e("GenQueryUnstructDataImpl", "zipPath path not find");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("useTime", String.valueOf(System.currentTimeMillis() - j10));
        C13622a.m81969o(this.mContext, c11060c, linkedHashMap);
        return true;
    }

    /* renamed from: e */
    public int m81601e() throws Throwable {
        File file;
        C11839m.m70688i("GenQueryUnstructDataImpl", "Begin saveResult");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("downloadSize", String.valueOf(this.f61096b.size()));
        linkedHashMap.put("isCharging", String.valueOf(C0209d.m1196O0(this.mContext)));
        C10812z.m65842k(this.mContext, this.mSyncType, this.mDataType, 0, "", "", this.operationType, "batch_of_single_downUnstruct_begin", this.traceId, linkedHashMap, false);
        int iM60666c = 0;
        try {
            try {
                isCancel();
                m81596c(this.f61096b);
                file = new File(this.f61095a);
            } catch (C9722c e10) {
                iM60666c = e10.m60666c();
                C10812z.m65841j(this.mContext, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
                file = new File(this.f61095a);
            } catch (Exception e11) {
                try {
                    C11839m.m70687e("GenQueryUnstructDataImpl", "Exception occurred = " + e11.toString());
                    C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 5, e11.toString(), this.operationType, "single_download_struct", this.traceId);
                    C13582b.m81588a(new File(this.f61095a));
                    m81594a(5);
                    iM60666c = 5;
                } catch (Throwable th2) {
                    th = th2;
                    iM60666c = 5;
                    C13582b.m81588a(new File(this.f61095a));
                    m81594a(iM60666c);
                    throw th;
                }
            }
            C13582b.m81588a(file);
            m81594a(iM60666c);
            C11839m.m70688i("GenQueryUnstructDataImpl", "End saveResult , value = " + iM60666c);
            return iM60666c;
        } catch (Throwable th3) {
            th = th3;
            C13582b.m81588a(new File(this.f61095a));
            m81594a(iM60666c);
            throw th;
        }
    }
}
