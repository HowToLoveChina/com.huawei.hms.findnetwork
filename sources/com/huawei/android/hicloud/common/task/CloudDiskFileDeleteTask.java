package com.huawei.android.hicloud.common.task;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.SyncDriveRequest;
import com.huawei.android.hicloud.drive.clouddisk.model.BatchFilesRequest;
import com.huawei.android.hicloud.drive.clouddisk.model.BatchFilesResponse;
import com.huawei.android.hicloud.drive.clouddisk.model.FailFile;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.drive.clouddisk.model.FileUpdate;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.cloud.services.drive.model.File;
import com.huawei.hms.push.constant.RemoteMessageConst;
import fk.C9721b;
import gl.C9961b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import p252e9.C9427d;
import p252e9.C9428e;
import p336he.C10156g;
import p363ia.C10463a;
import p369ii.C10511b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import sa.C12766a;

/* loaded from: classes3.dex */
public class CloudDiskFileDeleteTask extends AbstractC12367d {

    /* renamed from: a */
    public List<FileModel> f12004a;

    /* renamed from: c */
    public boolean f12006c;

    /* renamed from: j */
    public WeakReference<Callback> f12013j;

    /* renamed from: b */
    public HashMap<String, FileModel> f12005b = new HashMap<>();

    /* renamed from: d */
    public volatile boolean f12007d = false;

    /* renamed from: e */
    public long f12008e = 0;

    /* renamed from: f */
    public int f12009f = 0;

    /* renamed from: g */
    public long f12010g = 0;

    /* renamed from: h */
    public int f12011h = 0;

    /* renamed from: i */
    public String f12012i = "";

    public interface Callback {
        /* renamed from: a */
        void mo15806a();

        /* renamed from: b */
        void mo15807b(int i10);
    }

    public CloudDiskFileDeleteTask(List<FileModel> list, boolean z10) {
        this.f12004a = list;
        this.f12006c = z10;
    }

    /* renamed from: c */
    public final void m15794c(ArrayList<FileModel> arrayList) {
        Iterator<FileModel> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f12008e += it.next().getFileSize();
        }
        this.f12009f = arrayList.size();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        List<FileModel> list;
        try {
            try {
                C11839m.m70688i("CloudDiskFileDeleteTask", "run task start" + this.f12006c);
                list = this.f12004a;
            } catch (Exception e10) {
                C11839m.m70688i("CloudDiskFileDeleteTask", "run task error: " + e10.toString());
                this.f12012i = e10.toString();
            }
            if (list == null || list.size() == 0) {
                C11839m.m70687e("CloudDiskFileDeleteTask", "run task list is null");
                this.f12012i = "list is null.";
            } else {
                DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
                if (driveExpandM64282d != null) {
                    m15797f();
                    m15800j();
                    if (this.f12006c) {
                        m15799h(driveExpandM64282d);
                    } else {
                        m15805o(driveExpandM64282d);
                    }
                    C11839m.m70688i("CloudDiskFileDeleteTask", "run task end");
                    return;
                }
                C11839m.m70687e("CloudDiskFileDeleteTask", "run task driveExpand null");
                this.f12012i = "driveExpand is null.";
            }
        } finally {
            this.f12007d = true;
            m15796e();
            report();
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        C11839m.m70688i("CloudDiskFileDeleteTask", "task cancel.");
        this.f12012i = "task is cancel.";
        this.f12007d = true;
        return super.cancel();
    }

    /* renamed from: d */
    public final void m15795d(BatchFilesResponse batchFilesResponse) {
        if (batchFilesResponse == null) {
            C11839m.m70688i("CloudDiskFileDeleteTask", "dealSoftDeleteBatchResponse batchReponse is null.");
            return;
        }
        List<File> files = batchFilesResponse.getFiles();
        if (files != null) {
            C11839m.m70688i("CloudDiskFileDeleteTask", "dealSoftDeleteBatchResponse succ size: " + files.size());
            for (File file : files) {
                if (file != null && !TextUtils.isEmpty(file.getId())) {
                    this.f12008e += this.f12005b.get(file.getId()).getFileSize();
                    this.f12009f++;
                    C9428e.m59118h().m59123d(file.getId());
                }
            }
        }
        List<FailFile> failedFiles = batchFilesResponse.getFailedFiles();
        if (failedFiles != null) {
            C11839m.m70688i("CloudDiskFileDeleteTask", "dealSoftDeleteBatchResponse fail size: " + failedFiles.size());
            for (FailFile failFile : failedFiles) {
                if (failFile != null && !TextUtils.isEmpty(failFile.getId())) {
                    if (C12766a.m76617f(404, "4041", failFile.getError().toString())) {
                        this.f12008e += this.f12005b.get(failFile.getId()).getFileSize();
                        this.f12009f++;
                        C9428e.m59118h().m59123d(failFile.getId());
                    } else {
                        this.f12012i = failFile.getError().toString();
                    }
                }
            }
        }
    }

    /* renamed from: e */
    public final void m15796e() {
        WeakReference<Callback> weakReference = this.f12013j;
        if (weakReference == null) {
            C11839m.m70688i("CloudDiskFileDeleteTask", "dealTaskEnd callback is null.");
            return;
        }
        Callback callback = weakReference.get();
        if (callback == null) {
            C11839m.m70688i("CloudDiskFileDeleteTask", "dealTaskEnd callback is null.");
        } else {
            callback.mo15807b(this.f12011h - this.f12009f);
        }
    }

    /* renamed from: f */
    public final void m15797f() {
        WeakReference<Callback> weakReference = this.f12013j;
        if (weakReference == null) {
            C11839m.m70688i("CloudDiskFileDeleteTask", "dealTaskStart callback is null.");
            return;
        }
        Callback callback = weakReference.get();
        if (callback == null) {
            C11839m.m70688i("CloudDiskFileDeleteTask", "dealTaskStart callback is null.");
        } else {
            callback.mo15806a();
        }
    }

    /* renamed from: g */
    public String mo15798g() {
        throw null;
    }

    /* renamed from: h */
    public final void m15799h(DriveExpand driveExpand) {
        C11839m.m70687e("CloudDiskFileDeleteTask", "hardDeleteFile start.");
        ArrayList<FileModel> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        C10511b c10511bBatch = driveExpand.batch();
        int i10 = 0;
        for (FileModel fileModel : this.f12004a) {
            try {
                Drive.Files.Delete delete = driveExpand.files().delete(fileModel.getFileId());
                m15804n(delete.getHeaders());
                C10156g.m63307d(delete.getHeaders(), delete.buildHttpRequestUrl());
                delete.queue(c10511bBatch, new C9427d(fileModel, arrayList, arrayList2));
                i10++;
                if (m15801k(i10, 20, this.f12004a.size())) {
                    c10511bBatch.m64597a();
                    c10511bBatch = driveExpand.batch();
                }
            } catch (Exception e10) {
                C11839m.m70688i("CloudDiskFileDeleteTask", "softDeleteFile start.");
                this.f12012i = e10.toString();
            }
        }
        m15794c(arrayList);
    }

    /* renamed from: j */
    public final void m15800j() {
        this.f12011h = this.f12004a.size();
        for (FileModel fileModel : this.f12004a) {
            if (!TextUtils.isEmpty(fileModel.getFileId())) {
                this.f12005b.put(fileModel.getFileId(), fileModel);
                this.f12010g += fileModel.getFileSize();
            }
        }
    }

    /* renamed from: k */
    public final boolean m15801k(int i10, int i11, int i12) {
        return i10 % i11 == 0 || i10 == i12;
    }

    /* renamed from: l */
    public boolean m15802l() {
        return this.f12007d;
    }

    /* renamed from: m */
    public void m15803m(Callback callback) {
        this.f12013j = new WeakReference<>(callback);
    }

    /* renamed from: n */
    public final void m15804n(C4609l c4609l) {
        c4609l.set("x-hw-client-mode", "frontend");
    }

    /* renamed from: o */
    public final void m15805o(DriveExpand driveExpand) {
        C11839m.m70688i("CloudDiskFileDeleteTask", "softDeleteFile start.");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (FileModel fileModel : this.f12004a) {
            try {
            } catch (Exception e10) {
                C11839m.m70688i("CloudDiskFileDeleteTask", "softDeleteFile exception: " + e10.toString());
                this.f12012i = e10.toString();
            }
            if (this.f12007d) {
                C11839m.m70688i("CloudDiskFileDeleteTask", "softDeleteFile task cancel.");
                return;
            }
            C4644l c4644l = new C4644l(new Date(), TimeZone.getTimeZone("UTC"));
            FileUpdate fileUpdate = new FileUpdate();
            fileUpdate.setId(fileModel.getFileId());
            fileUpdate.setRecycled(true);
            fileUpdate.setEditTime(c4644l);
            fileUpdate.setRecycledTime(c4644l);
            arrayList.add(fileUpdate);
            i10++;
            if (m15801k(i10, 100, this.f12004a.size())) {
                BatchFilesRequest batchFilesRequest = new BatchFilesRequest();
                batchFilesRequest.setBatchReq(arrayList);
                DriveExpand.BatchUpdate batchUpdate = driveExpand.batchUpdate(batchFilesRequest);
                m15804n(batchUpdate.getHeaders());
                m15795d((BatchFilesResponse) new SyncDriveRequest(batchUpdate).execute());
                arrayList.clear();
            }
        }
    }

    public final void report() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("total_size", String.valueOf(this.f12010g));
        linkedHashMap.put("total_count", String.valueOf(this.f12011h));
        linkedHashMap.put("success_size", String.valueOf(this.f12008e));
        linkedHashMap.put("success_count", String.valueOf(this.f12009f));
        linkedHashMap.put("fail_size", String.valueOf(this.f12010g - this.f12008e));
        linkedHashMap.put("fail_count", String.valueOf(this.f12011h - this.f12009f));
        linkedHashMap.put("is_hard_delete", String.valueOf(this.f12006c));
        linkedHashMap.put("error_reason", this.f12012i);
        linkedHashMap.put(RemoteMessageConst.FROM, mo15798g());
        linkedHashMap.put("user_grade_code", C13452e.m80781L().m80790C());
        linkedHashMap.put("user_space_available", String.valueOf(C9961b.m61788i().m61794f(this.f12006c ? this.f12008e : 0L)));
        C9428e.m59118h().m59134q("cloud_space_file_delete", linkedHashMap);
    }
}
