package com.huawei.hicloud.router.data;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class AutoUploadBean {
    private ArrayList<AutoUploadFileInfo> mFilePathList;
    private boolean mIsUploading;
    private String mPackageName;
    private int mPriority;

    public ArrayList<AutoUploadFileInfo> getFilePathList() {
        return this.mFilePathList;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public boolean isUploading() {
        return this.mIsUploading;
    }

    public void setFilePathList(ArrayList<AutoUploadFileInfo> arrayList) {
        this.mFilePathList = arrayList;
    }

    public void setIsUploading(boolean z10) {
        this.mIsUploading = z10;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void setPriority(int i10) {
        this.mPriority = i10;
    }
}
