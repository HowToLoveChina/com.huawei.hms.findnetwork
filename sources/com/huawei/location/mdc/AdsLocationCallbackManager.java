package com.huawei.location.mdc;

import android.location.Location;
import as.C1016d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class AdsLocationCallbackManager {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "AdsLocationCallbackManager";
    private static volatile AdsLocationCallbackManager instance;
    private List<IMdcLocationListener> adsLocationListenerList = new ArrayList(10);

    private void addOrReplaceMdcLocationListener(IMdcLocationListener iMdcLocationListener) {
        synchronized (SYNC_LOCK) {
            try {
                if (isAdsLocationListenerEmpty()) {
                    this.adsLocationListenerList.add(iMdcLocationListener);
                    C1016d.m6186f(TAG, "adsLocationListenerList is empty, add uuid here, uuid is: " + iMdcLocationListener.getUuid());
                    return;
                }
                for (int i10 = 0; i10 < this.adsLocationListenerList.size(); i10++) {
                    if (this.adsLocationListenerList.get(i10).getUuid().equals(iMdcLocationListener.getUuid())) {
                        this.adsLocationListenerList.set(i10, iMdcLocationListener);
                        C1016d.m6186f(TAG, "replace uuid here, uuid is: " + iMdcLocationListener.getUuid());
                        return;
                    }
                }
                this.adsLocationListenerList.add(iMdcLocationListener);
                C1016d.m6186f(TAG, "new add uuid here, uuid is: " + iMdcLocationListener.getUuid());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static AdsLocationCallbackManager getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new AdsLocationCallbackManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void addAdsLocationListener(IMdcLocationListener iMdcLocationListener) {
        synchronized (SYNC_LOCK) {
            try {
                if (iMdcLocationListener == null) {
                    return;
                }
                if (this.adsLocationListenerList == null) {
                    this.adsLocationListenerList = new ArrayList();
                }
                addOrReplaceMdcLocationListener(iMdcLocationListener);
                C1016d.m6186f(TAG, "add iMdcLocationListener to adsLocationListenerList, size is : " + this.adsLocationListenerList.size());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean isAdsLocationListenerEmpty() {
        boolean z10;
        synchronized (SYNC_LOCK) {
            try {
                List<IMdcLocationListener> list = this.adsLocationListenerList;
                z10 = list == null || list.size() == 0;
            } finally {
            }
        }
        return z10;
    }

    public void onAdsLocationChanged(Location location) {
        synchronized (SYNC_LOCK) {
            try {
                List<IMdcLocationListener> list = this.adsLocationListenerList;
                if (list != null && list.size() != 0) {
                    for (int i10 = 0; i10 < this.adsLocationListenerList.size(); i10++) {
                        if (this.adsLocationListenerList.get(i10) != null) {
                            this.adsLocationListenerList.get(i10).onMdcLocationChanged(location);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public boolean removeAdsLocationListener(String str) {
        synchronized (SYNC_LOCK) {
            if (str != null) {
                try {
                    List<IMdcLocationListener> list = this.adsLocationListenerList;
                    if (list != null && list.size() != 0) {
                        for (IMdcLocationListener iMdcLocationListener : this.adsLocationListenerList) {
                            if (str.equals(iMdcLocationListener.getUuid())) {
                                this.adsLocationListenerList.remove(iMdcLocationListener);
                                C1016d.m6186f(TAG, "remove iMdcLocationListener from adsLocationListenerList, size is : " + this.adsLocationListenerList.size());
                                return true;
                            }
                        }
                        return false;
                    }
                } finally {
                }
            }
            return false;
        }
    }
}
