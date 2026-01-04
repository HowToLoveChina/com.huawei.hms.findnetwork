package com.huawei.android.hicloud.cloudbackup.bean;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class MusicBucketItem implements Comparable<MusicBucketItem>, Serializable {
    private static final long serialVersionUID = 5231134212346077500L;
    private long bucketSize;
    private String displayCount;

    /* renamed from: id */
    private String f11658id;
    private boolean isChecked;
    private String rootPath;
    private int count = -1;
    private String folderName = "";
    private int position = -1;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && compareTo((MusicBucketItem) obj) == 0;
    }

    public long getBucketSize() {
        return this.bucketSize;
    }

    public int getCount() {
        return this.count;
    }

    public String getDisplayCount() {
        return this.displayCount;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public String getId() {
        return this.f11658id;
    }

    public int getPosition() {
        return this.position;
    }

    public String getRootPath() {
        return this.rootPath;
    }

    public int hashCode() {
        int count = getCount();
        String id2 = getId();
        String folderName = getFolderName();
        return ((((count + 31) * 31) + (folderName == null ? 0 : folderName.hashCode())) * 31) + (id2 != null ? id2.hashCode() : 0);
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setBucketSize(long j10) {
        this.bucketSize = j10;
    }

    public void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    public void setCount(int i10) {
        this.count = i10;
    }

    public void setDisplayCount(String str) {
        this.displayCount = str;
    }

    public void setFolderName(String str) {
        this.folderName = str;
    }

    public void setId(String str) {
        this.f11658id = str;
    }

    public void setPosition(int i10) {
        this.position = i10;
    }

    public void setRootPath(String str) {
        this.rootPath = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(MusicBucketItem musicBucketItem) {
        return (int) (musicBucketItem.bucketSize - this.bucketSize);
    }
}
