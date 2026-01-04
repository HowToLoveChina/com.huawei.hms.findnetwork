package com.huawei.android.hicloud.cloudbackup.model;

import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import p815ym.AbstractC14026a;

/* loaded from: classes2.dex */
public class RestoreCache {
    private static final RestoreCache CACHE = new RestoreCache();
    private static final Object LOCK = new Object();
    private static final String TAG = "RestoreCache";
    private String entranceOfRestore;
    private int index;
    private boolean isRefurbishment;
    private int recordCount;
    private ArrayList<CloudRestoreItem> itemList = new ArrayList<>();
    private ArrayList<CloudRestoreItem> restoreItems = new ArrayList<>();

    private RestoreCache() {
    }

    private List<CloudRestoreItem> getChildList(String str, List<CloudRestoreItem> list) {
        for (CloudRestoreItem cloudRestoreItem : list) {
            List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
            if (listM29202r != null && !listM29202r.isEmpty()) {
                if (cloudRestoreItem.getAppId().equals(str)) {
                    return listM29202r;
                }
                List<CloudRestoreItem> childList = getChildList(str, listM29202r);
                if (!childList.isEmpty()) {
                    return childList;
                }
            }
        }
        return new ArrayList();
    }

    public static RestoreCache getInstance() {
        return CACHE;
    }

    public RestoreCache addItem(CloudRestoreItem cloudRestoreItem) {
        synchronized (LOCK) {
            try {
                if (this.itemList.contains(cloudRestoreItem)) {
                    C11839m.m70688i(TAG, "restoreItem already exists " + cloudRestoreItem.getAppName());
                } else {
                    this.itemList.add(cloudRestoreItem);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this;
    }

    public void clear() {
        synchronized (LOCK) {
            this.itemList.clear();
        }
    }

    public void clearRestoreItems() {
        synchronized (LOCK) {
            this.itemList.clear();
            this.restoreItems.clear();
        }
    }

    public List<CloudRestoreItem> get3rdAppDataStatusList() {
        List<CloudRestoreItem> list;
        synchronized (LOCK) {
            list = get3rdAppDataStatusList(this.itemList);
        }
        return list;
    }

    public String getEntranceOfRestore() {
        return this.entranceOfRestore;
    }

    public int getIndex() {
        return this.index;
    }

    public CloudRestoreItem getItem(String str) {
        CloudRestoreItem item;
        synchronized (LOCK) {
            item = getItem(str, this.itemList);
        }
        return item;
    }

    public ArrayList<CloudRestoreItem> getItemList() {
        return this.itemList;
    }

    public int getRecordCount() {
        return this.recordCount;
    }

    public ArrayList<CloudRestoreItem> getRestoreItems() {
        if (AbstractC14026a.m84159a(this.restoreItems)) {
            C11839m.m70688i(TAG, "The restoreItems is empty. the itemList size is:" + this.itemList);
            return this.itemList;
        }
        C11839m.m70688i(TAG, "The restoreItems size is:" + this.restoreItems.size());
        return this.restoreItems;
    }

    public List<CloudRestoreItem> getStatusList(String str) {
        List<CloudRestoreItem> childList;
        synchronized (LOCK) {
            childList = getChildList(str, this.itemList);
        }
        return childList;
    }

    public boolean isRefurbishment() {
        return this.isRefurbishment;
    }

    public void setEntranceOfRestore(String str) {
        this.entranceOfRestore = str;
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setItemList(ArrayList<CloudRestoreItem> arrayList) {
        this.itemList = arrayList;
    }

    public void setRecordCount(int i10) {
        this.recordCount = i10;
    }

    public void setRefurbishment(boolean z10) {
        this.isRefurbishment = z10;
    }

    public void setRestoreItems(ArrayList<CloudRestoreItem> arrayList) {
        this.restoreItems = arrayList;
    }

    private List<CloudRestoreItem> get3rdAppDataStatusList(List<CloudRestoreItem> list) {
        ArrayList arrayList = new ArrayList();
        for (CloudRestoreItem cloudRestoreItem : list) {
            if (cloudRestoreItem.m29187M()) {
                arrayList.add(cloudRestoreItem);
            }
        }
        return arrayList;
    }

    private CloudRestoreItem getItem(String str, List<CloudRestoreItem> list) {
        CloudRestoreItem item;
        for (CloudRestoreItem cloudRestoreItem : list) {
            if (cloudRestoreItem.getAppId().equals(str)) {
                return cloudRestoreItem;
            }
            List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
            if (listM29202r != null && !listM29202r.isEmpty() && (item = getItem(str, listM29202r)) != null) {
                return item;
            }
        }
        return null;
    }
}
