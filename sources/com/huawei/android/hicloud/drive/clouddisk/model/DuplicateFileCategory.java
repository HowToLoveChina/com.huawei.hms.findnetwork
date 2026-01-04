package com.huawei.android.hicloud.drive.clouddisk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class DuplicateFileCategory implements Serializable {
    private static final String TAG = "DuplicateFileCategory";
    private List<DuplicateFileCard> cardList;
    private boolean checked;
    private volatile boolean expand;
    private int fileCategory;
    private boolean isLastCategory;
    private List<Object> cardAndFileList = new ArrayList();
    private volatile Set<FileModel> categorySelectedFiles = new HashSet();
    private volatile Set<FileModel> defaultSelectedFiles = new HashSet();

    public DuplicateFileCategory(int i10, boolean z10, List<DuplicateFileCard> list) {
        this.fileCategory = i10;
        this.checked = z10;
        this.cardList = list;
        initFiles();
    }

    private void initFiles() {
        this.cardAndFileList.clear();
        this.categorySelectedFiles.clear();
        this.defaultSelectedFiles.clear();
        List<DuplicateFileCard> list = this.cardList;
        if (list == null) {
            C11839m.m70688i(TAG, "duplicate file initFiles cardList is null, category = " + this.fileCategory);
            return;
        }
        for (DuplicateFileCard duplicateFileCard : list) {
            List<FileModel> fileModelList = duplicateFileCard.getFileModelList();
            if (fileModelList != null && fileModelList.size() != 0) {
                duplicateFileCard.setFileCategory(this);
                fileModelList.get(0).setFirst(true);
                fileModelList.get(fileModelList.size() - 1).setLast(true);
                if (noThumbnail()) {
                    this.cardAndFileList.add(duplicateFileCard);
                }
                this.cardAndFileList.addAll(fileModelList);
            }
        }
        for (Object obj : this.cardAndFileList) {
            if (obj instanceof FileModel) {
                FileModel fileModel = (FileModel) obj;
                fileModel.setDuplicateFileCategory(this);
                if (!fileModel.isFirst()) {
                    this.defaultSelectedFiles.add(fileModel);
                }
            }
        }
    }

    public boolean existFiles() {
        return this.cardAndFileList.size() > 0;
    }

    public List<Object> getCardAndFileList() {
        return this.cardAndFileList;
    }

    public List<DuplicateFileCard> getCardList() {
        return this.cardList;
    }

    public long getCategorySize() {
        List<DuplicateFileCard> list = this.cardList;
        long size = 0;
        if (list != null) {
            for (DuplicateFileCard duplicateFileCard : list) {
                if (duplicateFileCard.getFileModelList() != null) {
                    size += duplicateFileCard.getSize() * duplicateFileCard.getFileModelList().size();
                }
            }
        }
        return size;
    }

    public boolean getChecked() {
        return this.checked && existFiles();
    }

    public int getFileCategory() {
        return this.fileCategory;
    }

    public boolean isExpand() {
        return this.expand && existFiles();
    }

    public boolean isLastCategory() {
        return this.isLastCategory;
    }

    public boolean noThumbnail() {
        int i10 = this.fileCategory;
        return (i10 == 0 || i10 == 2) ? false : true;
    }

    public void setCardList(List<DuplicateFileCard> list) {
        this.cardList = list;
        initFiles();
    }

    public void setChecked(boolean z10) {
        this.checked = z10;
    }

    public void setExpand(boolean z10) {
        this.expand = z10;
    }

    public void setFileCategory(int i10) {
        this.fileCategory = i10;
    }

    public void setLastCategory(boolean z10) {
        this.isLastCategory = z10;
    }

    public boolean updateCheckStatus(FileModel fileModel, boolean z10) {
        if (fileModel == null) {
            return false;
        }
        if (z10) {
            this.categorySelectedFiles.add(fileModel);
        } else {
            this.categorySelectedFiles.remove(fileModel);
        }
        if (this.categorySelectedFiles.size() < this.defaultSelectedFiles.size()) {
            return false;
        }
        if (!z10 && this.defaultSelectedFiles.contains(fileModel)) {
            return false;
        }
        Iterator<FileModel> it = this.defaultSelectedFiles.iterator();
        while (it.hasNext()) {
            if (!this.categorySelectedFiles.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void updateSelectedFiles(boolean z10) {
        if (z10) {
            this.categorySelectedFiles.addAll(this.defaultSelectedFiles);
        } else {
            this.categorySelectedFiles.clear();
        }
    }
}
