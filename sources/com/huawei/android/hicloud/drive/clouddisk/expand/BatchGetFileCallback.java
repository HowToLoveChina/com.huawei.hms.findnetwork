package com.huawei.android.hicloud.drive.clouddisk.expand;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.json.JsonError;
import com.huawei.cloud.services.drive.model.File;
import java.util.HashMap;
import p336he.C10156g;
import p397ji.AbstractC10891a;
import p514o9.C11835i;
import p514o9.C11839m;
import pa.C12123a;

/* loaded from: classes3.dex */
public class BatchGetFileCallback extends AbstractC10891a<File> {
    private static final String TAG = "BatchGetFileCallback";
    private String mFileId;
    private HashMap<String, String> mIdNameMap;
    private int mType;

    public BatchGetFileCallback(int i10, String str, HashMap<String, String> map) {
        this.mType = i10;
        this.mFileId = str;
        this.mIdNameMap = map;
    }

    @Override // p397ji.AbstractC10891a
    public void onFailure(JsonError jsonError, C4609l c4609l) {
        if (jsonError == null) {
            C11839m.m70687e(TAG, "onFailure with null JsonError");
            return;
        }
        C11839m.m70687e(TAG, "onFailure: " + jsonError.toString());
    }

    @Override // p369ii.InterfaceC10510a
    public void onSuccess(File file, C4609l c4609l) {
        C11839m.m70686d(TAG, "success: parent fileId: " + file.getId());
        try {
            C10156g.m63310g(c4609l);
            new C12123a().m72700p(this.mType, this.mFileId, C11835i.m70637a(false, file.getFileName()));
            this.mIdNameMap.put(this.mFileId, file.getFileName());
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "update parent name error: " + e10.getMessage());
        }
    }
}
