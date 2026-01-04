package com.huawei.android.p069cg.request.callable;

import android.content.Context;
import android.media.MediaScannerConnection;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import com.huawei.hicloud.request.opengw.bean.MakeFileReq;
import com.huawei.hicloud.request.opengw.bean.Result;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1125f;
import p037bp.C1270a;
import p232dp.InterfaceC9284c;
import p581qk.AbstractC12367d;
import p606r9.C12478a;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p704v9.C13387c;
import to.C13049a;

/* loaded from: classes2.dex */
public class EuropeUploadAsyncCallable extends BaseUploadCallable {
    private static final String TAG = "EuropeUploadAsyncCallable";
    protected C13049a openGWService;
    protected String unstrGuid;
    protected C12478a uploadService;

    public static class NotifyUserKeyErrorTask extends AbstractC12367d {
        private NotifyUserKeyErrorTask() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (interfaceC9284c != null) {
                interfaceC9284c.mo17152u(708);
            }
        }
    }

    public EuropeUploadAsyncCallable(Context context, Object obj) {
        super(obj);
        this.unstrGuid = "";
        this.context = context;
        this.preFileInfo = (FileInfo) obj;
        String strM6755Z0 = C1122c.m6755Z0("04005");
        this.traceId = strM6755Z0;
        EnumC12999a enumC12999a = EnumC12999a.CLOUD_ALBUM;
        this.uploadService = new C12478a(enumC12999a, strM6755Z0);
        this.openGWService = new C13049a(enumC12999a, this.traceId);
    }

    @Override // com.huawei.android.p069cg.request.callable.BaseUploadCallable, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    @Deprecated
    public Object call() throws Exception {
        C1120a.m6677i(TAG, "come into upload thread: " + C1122c.m6818p0(this.preFileInfo.getFileName()));
        return null;
    }

    public boolean checkFileType() {
        int fileType = this.preFileInfo.getFileType();
        if (-1 == fileType) {
            fileType = C1125f.m6892m(this.preFileInfo.getLocalRealPath());
            C1120a.m6677i(TAG, "checkFileType FILE_TYPE_UNKONWN(-1) recheck to " + fileType);
            this.preFileInfo.setFileType(fileType);
        }
        return -1 != fileType;
    }

    public List<String> exitNames(UploadReq uploadReq) {
        ArrayList arrayList = new ArrayList();
        String server = uploadReq.getServer();
        LsRequest lsRequest = new LsRequest();
        lsRequest.setServerPath(server.substring(0, server.lastIndexOf("/")));
        lsRequest.setFields(new String[]{"name", "md5"});
        lsRequest.setType(1);
        lsRequest.setRecursive(1);
        List<Map<String, Object>> arrayList2 = new ArrayList<>();
        try {
            arrayList2 = this.openGWService.m78718T(lsRequest);
        } catch (C9721b e10) {
            C1120a.m6676e(TAG, "exitNames exception:" + e10.toString());
        }
        Iterator<Map<String, Object>> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get("name").toString());
        }
        return arrayList;
    }

    public boolean handleNameRepeated(UploadReq uploadReq, C13387c c13387c) throws Throwable {
        if (isEquals(uploadReq, c13387c)) {
            C1120a.m6677i(TAG, "already exist");
            return true;
        }
        String server = uploadReq.getServer();
        String strSubstring = server.substring(server.lastIndexOf("/") + 1);
        String strRenamePath = renamePath(server, 1);
        String strSubstring2 = strRenamePath.substring(strRenamePath.lastIndexOf("/") + 1);
        List<String> listExitNames = exitNames(uploadReq);
        int i10 = 1;
        while (listExitNames.contains(strSubstring2)) {
            C1120a.m6675d(TAG, "contains retryName");
            i10++;
            strSubstring2 = renamePath(strSubstring, i10);
            strRenamePath = renamePath(server, i10);
        }
        C1120a.m6677i(TAG, "retryName is :" + strSubstring2);
        this.preFileInfo.setFileName(strSubstring2);
        String localRealPath = this.preFileInfo.getLocalRealPath();
        File fileM63442h = C10278a.m63442h(localRealPath);
        if (!fileM63442h.exists()) {
            C1120a.m6676e(TAG, "orgFile not exist");
            return false;
        }
        int iLastIndexOf = localRealPath.lastIndexOf("/");
        if (iLastIndexOf < 0) {
            C1120a.m6676e(TAG, "orgFilePath error");
            return false;
        }
        String strSubstring3 = localRealPath.substring(0, iLastIndexOf + 1);
        String str = strSubstring3 + strSubstring2;
        File fileM63442h2 = C10278a.m63442h(str);
        if (fileM63442h2.exists()) {
            C1120a.m6676e(TAG, "renameFile already exist");
            return false;
        }
        if (!fileM63442h.renameTo(fileM63442h2)) {
            C1120a.m6676e(TAG, "rename orgFile error");
            return false;
        }
        MediaScannerConnection.scanFile(this.context, new String[]{str, localRealPath}, null, null);
        this.preFileInfo.setLocalRealPath(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("scan path:");
        sb2.append(strSubstring3);
        sb2.append(", oldName: " + strSubstring);
        C1120a.m6677i(TAG, sb2.toString());
        MakeFileReq makeFileReq = new MakeFileReq(this.preFileInfo.getHash(), strRenamePath);
        if (uploadReq.getAttribute() != null) {
            makeFileReq.setAttribute(uploadReq.getAttribute());
        }
        try {
            this.openGWService.m78720V(Collections.singletonList(makeFileReq), null);
            return true;
        } catch (C9721b e10) {
            C1120a.m6675d(TAG, "remkfiles error: " + e10.getMessage());
            return false;
        }
    }

    public boolean isEquals(UploadReq uploadReq, C13387c c13387c) {
        Result resultM78709H;
        Object obj;
        String server = uploadReq.getServer();
        if (c13387c == null) {
            return false;
        }
        try {
            resultM78709H = new C13049a(EnumC12999a.CLOUD_ALBUM, this.traceId).m78709H(new String[]{server}, new String[]{"md5"});
        } catch (C9721b e10) {
            C1120a.m6676e(TAG, "isEquals exception:" + e10.toString());
            resultM78709H = null;
        }
        if (resultM78709H == null || resultM78709H.getFailList().isEmpty()) {
            if (resultM78709H == null || resultM78709H.getSuccessList().isEmpty() || (obj = resultM78709H.getSuccessList().get(0).get("md5")) == null) {
                return false;
            }
            return obj.toString().equals(c13387c.m80423h());
        }
        C1120a.m6676e(TAG, "MkRetryCallback " + resultM78709H.getFailList().get(0).toString());
        return false;
    }

    public String renamePath(String str, int i10) {
        int iLastIndexOf = str.lastIndexOf(".");
        return (str.substring(0, iLastIndexOf) + "_" + i10) + str.substring(iLastIndexOf);
    }

    public boolean resetUserKeyAndMakefile(UploadReq uploadReq) {
        UserKeyUtils.getInstance().clearUserKeyByBusinessType(0);
        C12515a.m75110o().m75172d(new NotifyUserKeyErrorTask());
        try {
            TreeMap treeMap = new TreeMap();
            treeMap.put("merge", Boolean.TRUE);
            uploadReq.setAttribute(treeMap);
            this.uploadService.m74908d(uploadReq);
            this.unstrGuid = uploadReq.getBackupStatus().m80419d();
            return true;
        } catch (C9721b e10) {
            C1120a.m6676e(TAG, "resetUserKeyAndMakefile exception:" + e10.toString());
            return false;
        }
    }
}
