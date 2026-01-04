package p220d8;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.request.response.GetFileUrlsResponse;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.android.hicloud.album.service.logic.callable.SDKDownloadTaskCallable;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileDownloadStatus;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.album.service.report.OpsReport;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractC2324e;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p031b7.C1120a;
import p031b7.C1122c;
import p511o6.C11820b;
import p511o6.C11821c;
import p511o6.C11822d;
import p635s7.C12748o;
import p701v6.C13359f;
import p801y7.C13914b;

/* renamed from: d8.c */
/* loaded from: classes2.dex */
public class C9049c {

    /* renamed from: c */
    public static final int[] f45718c = {1, 2, 4, 8, 16, 32};

    /* renamed from: a */
    public Context f45719a;

    /* renamed from: b */
    public CallbackHandler f45720b;

    /* renamed from: d8.c$a */
    public class a extends AbstractC2324e {

        /* renamed from: a */
        public final /* synthetic */ ShareReceiverData f45721a;

        /* renamed from: b */
        public final /* synthetic */ String f45722b;

        /* renamed from: c */
        public final /* synthetic */ String f45723c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, ShareReceiverData shareReceiverData, String str, String str2) {
            super(obj);
            this.f45721a = shareReceiverData;
            this.f45722b = str;
            this.f45723c = str2;
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2324e
        public void handle(Object obj) {
            if (obj != null) {
                C1120a.m6677i("SDKDownloadServiceLogic", "HandleCallable downloadAvatar result: " + obj.toString() + ", currentThread id: " + Thread.currentThread().getId());
                HashMap map = (HashMap) obj;
                Bundle bundle = new Bundle();
                if (String.valueOf(0).equals(map.get("code"))) {
                    C9049c.this.m57066k(this.f45721a, this.f45722b, this.f45723c);
                    bundle.putParcelable("ShareReceiver", this.f45721a);
                    bundle.putInt("Code", 0);
                    C9049c.this.f45720b.sendMessage(9045, bundle);
                    return;
                }
                this.f45721a.setHeadPictureLocalPath("");
                bundle.putParcelable("ShareReceiver", this.f45721a);
                bundle.putInt("Code", 1);
                bundle.putParcelable("HttpResult", new HttpResult(200, map.containsKey("DownloadFailReason") ? ((Integer) map.get("DownloadFailReason")).intValue() : 101, null));
                C9049c.this.f45720b.sendMessage(9145, bundle);
            }
        }
    }

    public C9049c(Context context, CallbackHandler callbackHandler) {
        this.f45719a = context;
        this.f45720b = callbackHandler;
    }

    /* renamed from: c */
    public static void m57053c(int i10, boolean z10, boolean z11) {
        C2332m.m14608s().m14622O(3, i10, z10, z11);
        C2332m.m14608s().m14616I(0);
    }

    /* renamed from: f */
    public static void m57054f(Context context, int i10, boolean z10) {
        C1120a.m6677i("SDKDownloadServiceLogic", "cancelDownloadTaskAll, errCode: " + i10);
        m57055g(context, i10, z10);
        m57056h(context, i10, z10);
        C13914b.m83361t();
    }

    /* renamed from: g */
    public static void m57055g(Context context, int i10, boolean z10) {
        C1120a.m6677i("SDKDownloadServiceLogic", "cancelGeneralDownloadTask, errCode: " + i10);
        C2332m.m14608s().m14622O(0, i10, false, z10);
        C2332m.m14608s().m14616I(0);
    }

    /* renamed from: h */
    public static void m57056h(Context context, int i10, boolean z10) {
        C1120a.m6677i("SDKDownloadServiceLogic", "cancelShareDownloadTask, errCode: " + i10);
        C2332m.m14608s().m14622O(0, i10, true, z10);
        C2332m.m14608s().m14616I(0);
    }

    /* renamed from: r */
    public static int m57057r(Context context, FileInfo fileInfo, int i10, boolean z10, String str, CallbackHandler callbackHandler, boolean z11) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fileInfo);
        return m57059t(context, arrayList, i10, z10, str, callbackHandler, z11);
    }

    /* renamed from: s */
    public static int m57058s(Context context, FileInfo fileInfo, int i10, boolean z10, String str, boolean z11) {
        return m57057r(context, fileInfo, i10, z10, str, null, z11);
    }

    /* renamed from: t */
    public static int m57059t(Context context, ArrayList<FileInfo> arrayList, int i10, boolean z10, String str, CallbackHandler callbackHandler, boolean z11) throws Throwable {
        String str2;
        String strM6713L0;
        String string;
        String str3;
        C12748o c12748o = new C12748o(context, arrayList, i10, z10, str, callbackHandler, z11);
        String strM6713L02 = "0:1";
        String string2 = "OK";
        int code = 101;
        try {
        } catch (Throwable th2) {
            th = th2;
            str2 = strM6713L0;
        }
        try {
            try {
                GetFileUrlsResponse getFileUrlsResponseM80113o = c12748o.m80113o(GetFileUrlsResponse.class);
                code = getFileUrlsResponseM80113o.getCode();
                if (code == 0) {
                    code = c12748o.m76574v(arrayList, getFileUrlsResponseM80113o, i10);
                }
                if (code != 0) {
                    strM6713L02 = C1122c.m6713L0(String.valueOf(code), false);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getDownloadUrl error:");
                    if (arrayList.size() <= 0) {
                        str3 = "empty files";
                    } else {
                        str3 = "original:" + arrayList.get(0).getFileId() + " info:" + getFileUrlsResponseM80113o.getInfo();
                    }
                    sb2.append(str3);
                    string2 = sb2.toString();
                }
                strM6713L0 = strM6713L02;
                string = string2;
            } catch (C13359f e10) {
                C1120a.m6676e("SDKDownloadServiceLogic", "GetFileUrlsRequest ReportException:" + e10.toString());
                strM6713L0 = C1122c.m6713L0(e10.m80149b(), false);
                string = e10.getMessage();
                C1122c.m6750X1(context, strM6713L0, string, "04004", OpsReport.m15253b("cloudphoto.file.geturl"), str, true);
                return code;
            } catch (Exception e11) {
                C1120a.m6676e("SDKDownloadServiceLogic", "Run GetFileUrlsRequest error, message: " + e11.toString());
                strM6713L0 = "001_1007:1";
                string = e11.toString();
                C1122c.m6750X1(context, strM6713L0, string, "04004", OpsReport.m15253b("cloudphoto.file.geturl"), str, true);
                return code;
            }
            C1122c.m6750X1(context, strM6713L0, string, "04004", OpsReport.m15253b("cloudphoto.file.geturl"), str, true);
            return code;
        } catch (Throwable th3) {
            th = th3;
            str2 = strM6713L02;
            C1122c.m6750X1(context, str2, "OK", "04004", OpsReport.m15253b("cloudphoto.file.geturl"), str, true);
            throw th;
        }
    }

    /* renamed from: u */
    public static int m57060u(Context context, ArrayList<FileInfo> arrayList, int i10, boolean z10, String str, boolean z11) {
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        return m57059t(context, arrayList, i10, z10, str, null, z11);
    }

    /* renamed from: A */
    public final void m57061A(FileInfo fileInfo) {
        if (fileInfo == null) {
            C1120a.m6676e("SDKDownloadServiceLogic", "updateFileInfo(): fileInfo is null");
            return;
        }
        if (TextUtils.isEmpty(fileInfo.getLocalRealPath())) {
            fileInfo.setLocalRealPath("");
        }
        if (TextUtils.isEmpty(fileInfo.getLocalBigThumbPath())) {
            fileInfo.setLocalBigThumbPath("");
        }
        if (TextUtils.isEmpty(fileInfo.getLocalThumbPath())) {
            fileInfo.setLocalThumbPath("");
        }
        if (fileInfo.getVideoThumbId() == null) {
            fileInfo.setVideoThumbId("");
        }
        if (TextUtils.isEmpty(fileInfo.getExpand())) {
            fileInfo.setExpand("");
        }
        if (TextUtils.isEmpty(fileInfo.getLpath())) {
            fileInfo.setLpath("");
        }
    }

    /* renamed from: d */
    public int m57062d(List<FileInfo> list) {
        boolean z10;
        C1120a.m6677i("SDKDownloadServiceLogic", "cancelDownloadTask");
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("SDKDownloadServiceLogic", "param error, cancelDownloadTask failed");
            return 1;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            FileInfo fileInfo = list.get(i10);
            if (TextUtils.isEmpty(fileInfo.getUniqueId())) {
                fileInfo.setShareId(fileInfo.getAlbumId());
                fileInfo.setAlbumId("");
                z10 = true;
            } else {
                fileInfo.setShareId("");
                z10 = false;
            }
            C11821c.m70412b(this.f45719a, fileInfo, 0, z10);
        }
        return 0;
    }

    /* renamed from: e */
    public int m57063e() {
        C1120a.m6677i("SDKDownloadServiceLogic", "cancelDownloadTaskAll");
        DownloadPhotoBase.m14412g();
        C13914b.m83360s();
        C11822d.m70439c(this.f45719a, 0, 115);
        return 0;
    }

    /* renamed from: i */
    public int m57064i(List<FileInfo> list) {
        boolean z10;
        C1120a.m6677i("SDKDownloadServiceLogic", "deleteDownloadHistory");
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("SDKDownloadServiceLogic", "param error, deleteDownloadHistory failed");
            return 1;
        }
        C1120a.m6677i("SDKDownloadServiceLogic", "deleteDownloadHistory size:" + list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            FileInfo fileInfo = list.get(i10);
            if (fileInfo == null) {
                C1120a.m6676e("SDKDownloadServiceLogic", "deleteDownloadHistory fileInfo is null");
            } else {
                if (TextUtils.isEmpty(fileInfo.getUniqueId())) {
                    String albumId = fileInfo.getAlbumId();
                    fileInfo.setAlbumId("");
                    fileInfo.setShareId(albumId);
                    z10 = true;
                } else {
                    fileInfo.setShareId("");
                    z10 = false;
                }
                C11821c.m70412b(this.f45719a, fileInfo, 0, z10);
            }
        }
        return 0;
    }

    /* renamed from: j */
    public int m57065j(int i10) {
        C1120a.m6677i("SDKDownloadServiceLogic", "deleteDownloadHistoryAll fileStatus:" + i10);
        if (i10 >= 1) {
            return 0;
        }
        C1120a.m6676e("SDKDownloadServiceLogic", "param error, deleteDownloadHistoryAll failed");
        return 1;
    }

    /* renamed from: k */
    public final void m57066k(ShareReceiverData shareReceiverData, String str, String str2) {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && (fileArrListFiles = fileM63442h.getParentFile().listFiles()) != null && fileArrListFiles.length >= 1) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                if (!TextUtils.isEmpty(name) && name.startsWith(shareReceiverData.getReceiverId()) && !str2.equals(name)) {
                    C1122c.m6694F(C10279b.m63452a(file));
                }
            }
        }
    }

    /* renamed from: l */
    public int m57067l(ShareReceiverData shareReceiverData, String str, String str2) {
        if (shareReceiverData == null) {
            C1120a.m6676e("SDKDownloadServiceLogic", "downloadAvatar shareReceiverData is null");
            return 1002;
        }
        String headPictureURL = shareReceiverData.getHeadPictureURL();
        if (TextUtils.isEmpty(shareReceiverData.getReceiverId()) || TextUtils.isEmpty(headPictureURL)) {
            C1120a.m6676e("SDKDownloadServiceLogic", "downloadAvatar: Invalid params!");
            shareReceiverData.setHeadPictureLocalPath("");
            Bundle bundle = new Bundle();
            bundle.putParcelable("ShareReceiver", shareReceiverData);
            bundle.putInt("Code", 2);
            this.f45720b.sendMessage(9145, bundle);
            return 1002;
        }
        int iLastIndexOf = headPictureURL.lastIndexOf(".");
        String str3 = shareReceiverData.getReceiverId() + "_" + System.currentTimeMillis() + (iLastIndexOf > 0 ? headPictureURL.substring(iLastIndexOf) : CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT);
        String str4 = str + "/headPic/" + shareReceiverData.getReceiverId() + "/" + str3;
        shareReceiverData.setHeadPictureLocalPath(str4);
        C2332m.m14608s().m14634a0(new SDKDownloadTaskCallable(this.f45719a, this.f45720b, str4, shareReceiverData.getHeadPictureURL(), null, str4, 1, str2), new a("", shareReceiverData, str4, str3), true);
        return 0;
    }

    /* renamed from: m */
    public int m57068m(List<FileInfo> list, int i10, int i11, boolean z10, boolean z11, String str) {
        boolean z12;
        boolean z13;
        C1120a.m6677i("SDKDownloadServiceLogic", "downloadGeneralFiles thumbType:" + i10 + ", operationType:" + i11 + ", forceDownload:" + z10 + ", needProgressEvent:" + z11);
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("SDKDownloadServiceLogic", "param error, downloadGeneralFiles failed");
            return 102;
        }
        Map<String, Map<String, Long>> mapM15189m = SyncSessionManager.m15153t().m15189m();
        if (mapM15189m.containsKey(str)) {
            C1120a.m6676e("SDKDownloadServiceLogic", "download rate,traceId already exists :" + str);
        } else {
            HashMap map = new HashMap();
            map.put("downloadStartTime", Long.valueOf(System.currentTimeMillis()));
            mapM15189m.put(str, map);
        }
        C1120a.m6677i("SDKDownloadServiceLogic", "downloadGeneralFiles,traceId:" + str + ",thumbType:" + i10);
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        m57073v(list, arrayList, i10, i11);
        if (!Version.isDropDownloadFileInfo() && !arrayList.isEmpty()) {
            arrayList.sort(C11820b.m70396a());
        }
        if (i10 != 0) {
            m57074w(arrayList, false);
        }
        C13914b c13914b = new C13914b(this.f45719a, this.f45720b);
        if (i10 == 1 || i10 == 2) {
            z12 = i11 != 2;
            z13 = i11 != 2;
        } else {
            z12 = false;
            z13 = false;
        }
        boolean z14 = (i10 == 0 && i11 == 0) ? true : z12;
        if (i10 != 0) {
            for (int i12 = 0; i12 < arrayList.size(); i12 += 100) {
                ArrayList<FileInfo> arrayList2 = new ArrayList<>();
                for (int i13 = i12; i13 < arrayList.size() && i13 < i12 + 100; i13++) {
                    arrayList2.add(arrayList.get(i13));
                }
                c13914b.m83374v(arrayList2, i10, z14, z11, false, z13, z10, str);
            }
        } else {
            c13914b.m83374v(arrayList, i10, z14, z11, false, z13, z10, str);
        }
        return 0;
    }

    /* renamed from: n */
    public int m57069n(List<FileInfo> list, int i10, int i11, boolean z10, boolean z11, String str) {
        boolean z12;
        boolean z13;
        C1120a.m6677i("SDKDownloadServiceLogic", "downloadShareFiles thumbType: " + i10);
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("SDKDownloadServiceLogic", "param error, downloadShareThumb failed");
            return 102;
        }
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        m57075x(list, arrayList, i10, i11);
        if (!Version.isDropDownloadFileInfo() && !arrayList.isEmpty()) {
            arrayList.sort(C11820b.m70396a());
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                C1120a.m6677i("SDKDownloadServiceLogic", "downloadShareFiles fileList sorted result, i = " + i12 + ",fileName:" + C1122c.m6818p0(arrayList.get(i12).getFileName()));
            }
        }
        if (i10 != 0) {
            m57074w(arrayList, true);
        }
        if (i10 == 1 || i10 == 2) {
            z12 = i11 != 2;
            z13 = i11 != 2;
        } else {
            z12 = false;
            z13 = false;
        }
        new C13914b(this.f45719a, this.f45720b).m83374v(arrayList, i10, (i10 == 0 && i11 == 0) ? true : z12, z11, true, z13, z10, str);
        return 0;
    }

    /* renamed from: o */
    public int m57070o(int i10) {
        return 0;
    }

    /* renamed from: p */
    public List<FileDownloadStatus> m57071p(List<FileInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            return arrayList;
        }
        C1120a.m6676e("SDKDownloadServiceLogic", "param error, getDownloadFileStatus failed");
        return arrayList;
    }

    /* renamed from: q */
    public List<FileDownloadStatus> m57072q(int i10, int i11, int i12) {
        C1120a.m6677i("SDKDownloadServiceLogic", "getDownloadFileStatusLimit");
        ArrayList arrayList = new ArrayList();
        if (i10 < 1) {
            C1120a.m6676e("SDKDownloadServiceLogic", "param error, getDownloadFileStatusLimit failed");
        }
        return arrayList;
    }

    /* renamed from: v */
    public final void m57073v(List<FileInfo> list, ArrayList<FileInfo> arrayList, int i10, int i11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (FileInfo fileInfo : list) {
            if (TextUtils.isEmpty(fileInfo.getAlbumId()) || TextUtils.isEmpty(fileInfo.getHash())) {
                C1120a.m6676e("SDKDownloadServiceLogic", "processDownloadFileList AlbumId or hash is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
                C13914b.m83352H(this.f45720b, fileInfo, i10, 123, false);
            } else if (TextUtils.isEmpty(fileInfo.getShareId()) && TextUtils.isEmpty(fileInfo.getUniqueId())) {
                C1120a.m6676e("SDKDownloadServiceLogic", "processDownloadFileList uniqueId is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
                C13914b.m83352H(this.f45720b, fileInfo, i10, 123, false);
            } else {
                String uniqueId = fileInfo.getUniqueId() != null ? fileInfo.getUniqueId() : fileInfo.getFileId();
                if (C1122c.m6815o1(uniqueId)) {
                    C1120a.m6676e("SDKDownloadServiceLogic", "processDownloadFileList mediaId is invalid, which file is: " + C1122c.m6818p0(fileInfo.getFileName()) + ", mediaId: " + uniqueId);
                    C13914b.m83352H(this.f45720b, fileInfo, i10, 123, false);
                } else if (TextUtils.isEmpty(fileInfo.getLocalRealPath()) && TextUtils.isEmpty(fileInfo.getLocalBigThumbPath()) && TextUtils.isEmpty(fileInfo.getLocalThumbPath())) {
                    C1120a.m6676e("SDKDownloadServiceLogic", "processDownloadFileList download path is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
                    C13914b.m83352H(this.f45720b, fileInfo, i10, 124, false);
                } else {
                    fileInfo.setShareId("");
                    fileInfo.setAddTime(jCurrentTimeMillis);
                    fileInfo.setFileStatus(4);
                    m57061A(fileInfo);
                    arrayList.add(fileInfo);
                    jCurrentTimeMillis = 1 + jCurrentTimeMillis;
                }
            }
        }
    }

    /* renamed from: w */
    public final void m57074w(ArrayList<FileInfo> arrayList, boolean z10) {
        String str;
        HashMap map = new HashMap();
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            String uniqueId = next.getUniqueId();
            String fileName = next.getFileName();
            if (z10) {
                str = uniqueId + "_" + next.getShareId() + "_" + fileName;
            } else {
                str = uniqueId + "_" + next.getAlbumId() + "_" + fileName;
            }
            if (map.containsKey(str)) {
                it.remove();
            } else {
                map.put(str, str);
            }
        }
    }

    /* renamed from: x */
    public final void m57075x(List<FileInfo> list, ArrayList<FileInfo> arrayList, int i10, int i11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (FileInfo fileInfo : list) {
            if (TextUtils.isEmpty(fileInfo.getShareId()) || TextUtils.isEmpty(fileInfo.getHash())) {
                C1120a.m6676e("SDKDownloadServiceLogic", "processShareDownloadFileList shareId or hash is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
                C13914b.m83352H(this.f45720b, fileInfo, i10, 123, true);
            } else if (TextUtils.isEmpty(fileInfo.getUserID())) {
                C1120a.m6676e("SDKDownloadServiceLogic", "userId is null, which file is:" + C1122c.m6818p0(fileInfo.getFileName()));
                C13914b.m83352H(this.f45720b, fileInfo, i10, 123, true);
            } else if (TextUtils.isEmpty(fileInfo.getLocalRealPath()) && TextUtils.isEmpty(fileInfo.getLocalBigThumbPath()) && TextUtils.isEmpty(fileInfo.getLocalThumbPath())) {
                C1120a.m6676e("SDKDownloadServiceLogic", "processShareDownloadFileList download path is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
                C13914b.m83352H(this.f45720b, fileInfo, i10, 124, true);
            } else {
                fileInfo.setAlbumId("");
                fileInfo.setAddTime(jCurrentTimeMillis);
                fileInfo.setFileStatus(4);
                m57061A(fileInfo);
                fileInfo.setUniqueId("");
                arrayList.add(fileInfo);
                jCurrentTimeMillis = 1 + jCurrentTimeMillis;
            }
        }
    }

    /* renamed from: y */
    public int m57076y(List<FileInfo> list, boolean z10) {
        C1120a.m6677i("SDKDownloadServiceLogic", "startDownload");
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("SDKDownloadServiceLogic", "param error, startDownloadTask failed");
            return 1;
        }
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < list.size(); i10++) {
            FileInfo fileInfo = list.get(i10);
            if (fileInfo != null && fileInfo.getHash() != null && (fileInfo.getShareId() != null || fileInfo.getAlbumId() != null)) {
                if (TextUtils.isEmpty(fileInfo.getUniqueId())) {
                    fileInfo.setShareId(fileInfo.getAlbumId());
                    fileInfo.setAlbumId("");
                    arrayList.add(fileInfo);
                } else {
                    fileInfo.setShareId("");
                    arrayList.add(fileInfo);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                C1120a.m6677i("SDKDownloadServiceLogic", "startDownload fileList sorted, i = " + i11 + ",fileName:" + C1122c.m6818p0(arrayList.get(i11).getFileName()));
            }
        }
        new C13914b(this.f45719a, this.f45720b).m83375w(arrayList, false, true, null, z10);
        return 1;
    }

    /* renamed from: z */
    public int m57077z() {
        C1120a.m6677i("SDKDownloadServiceLogic", "startDownloadTaskAlls");
        return 1;
    }
}
