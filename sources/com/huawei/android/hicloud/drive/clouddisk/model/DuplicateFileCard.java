package com.huawei.android.hicloud.drive.clouddisk.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DuplicateFileCard implements Serializable {
    private DuplicateFileCategory fileCategory;
    private List<FileModel> fileModelList;
    private volatile FileModel fistFile;
    private String md5;
    private long size;

    private void initFirstFile() {
        List<FileModel> list = this.fileModelList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.fistFile = this.fileModelList.get(0);
    }

    public long getCardSize() {
        List<FileModel> list = this.fileModelList;
        long fileSize = 0;
        if (list != null) {
            Iterator<FileModel> it = list.iterator();
            while (it.hasNext()) {
                fileSize += it.next().getFileSize();
            }
        }
        return fileSize;
    }

    public int getCount() {
        List<FileModel> list = this.fileModelList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public DuplicateFileCategory getFileCategory() {
        return this.fileCategory;
    }

    public List<FileModel> getFileModelList() {
        return this.fileModelList;
    }

    public FileModel getFistFile() {
        return this.fistFile;
    }

    public String getMd5() {
        return this.md5;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isVisible() {
        DuplicateFileCategory duplicateFileCategory = this.fileCategory;
        return duplicateFileCategory != null && duplicateFileCategory.isExpand();
    }

    public void setFileCategory(DuplicateFileCategory duplicateFileCategory) {
        this.fileCategory = duplicateFileCategory;
    }

    public void setFileModelList(List<FileModel> list) {
        this.fileModelList = list;
        initFirstFile();
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setSize(long j10) {
        this.size = j10;
    }
}
