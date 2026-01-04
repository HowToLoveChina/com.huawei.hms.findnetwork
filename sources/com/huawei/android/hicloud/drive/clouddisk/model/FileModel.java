package com.huawei.android.hicloud.drive.clouddisk.model;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class FileModel implements Serializable {
    private static final long serialVersionUID = 1;
    private String cloudPath;
    private DuplicateFileCategory duplicateFileCategory;
    protected int fileCategory;
    private String fileId;
    protected String fileMD5;
    protected String fileName;
    protected String fileParent;
    private String fileParentName;
    protected long fileSize;
    private boolean isChecked;
    private String isCloudExist;
    private boolean isFirst;
    private boolean isLast;
    protected String modifyTime;
    private String smallThumbnailDownloadLink;
    protected String thumbnailPath;

    public String getCloudPath() {
        return this.cloudPath;
    }

    public DuplicateFileCategory getDuplicateFileCategory() {
        return this.duplicateFileCategory;
    }

    public int getFileCategory() {
        return this.fileCategory;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileMD5() {
        return this.fileMD5;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileParent() {
        return this.fileParent;
    }

    public String getFileParentName() {
        return this.fileParentName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getIsCloudExist() {
        return this.isCloudExist;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public String getSmallThumbnailDownloadLink() {
        return this.smallThumbnailDownloadLink;
    }

    public String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public boolean isVisible() {
        DuplicateFileCategory duplicateFileCategory = this.duplicateFileCategory;
        return duplicateFileCategory != null && duplicateFileCategory.isExpand();
    }

    public boolean noThumbnail() {
        DuplicateFileCategory duplicateFileCategory = this.duplicateFileCategory;
        return duplicateFileCategory != null && duplicateFileCategory.noThumbnail();
    }

    public void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    public void setCloudPath(String str) {
        this.cloudPath = str;
    }

    public void setDuplicateFileCategory(DuplicateFileCategory duplicateFileCategory) {
        this.duplicateFileCategory = duplicateFileCategory;
    }

    public void setFileCategory(int i10) {
        this.fileCategory = i10;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setFileMD5(String str) {
        this.fileMD5 = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileParent(String str) {
        this.fileParent = str;
    }

    public void setFileParentName(String str) {
        this.fileParentName = str;
    }

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public void setFirst(boolean z10) {
        this.isFirst = z10;
    }

    public void setIsCloudExist(String str) {
        this.isCloudExist = str;
    }

    public void setLast(boolean z10) {
        this.isLast = z10;
    }

    public void setModifyTime(String str) {
        this.modifyTime = str;
    }

    public void setSmallThumbnailDownloadLink(String str) {
        this.smallThumbnailDownloadLink = str;
    }

    public void setThumbnailPath(String str) {
        this.thumbnailPath = str;
    }
}
