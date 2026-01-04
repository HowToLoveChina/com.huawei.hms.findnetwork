package com.huawei.location.gwi.listener;

import android.location.Location;
import as.C1016d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class CarVdrListenerManager {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "CarVdrListenerManager";
    private static volatile CarVdrListenerManager instance;
    private List<ICarVdrLocationListener> carVdrListenerList = new ArrayList(10);

    public static CarVdrListenerManager getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new CarVdrListenerManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void addVdrLocationListener(ICarVdrLocationListener iCarVdrLocationListener) {
        synchronized (SYNC_LOCK) {
            try {
                if (iCarVdrLocationListener == null) {
                    return;
                }
                if (this.carVdrListenerList == null) {
                    this.carVdrListenerList = new ArrayList();
                }
                if (!this.carVdrListenerList.contains(iCarVdrLocationListener)) {
                    this.carVdrListenerList.add(iCarVdrLocationListener);
                }
                C1016d.m6186f(TAG, "add vdrLocationListener to carVdrListenerList, size is : " + this.carVdrListenerList.size());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void clearVdrLocationListener() {
        synchronized (SYNC_LOCK) {
            C1016d.m6186f(TAG, "clearVdrLocationListener");
            this.carVdrListenerList = null;
        }
    }

    public void onVdrError(int i10, String str) {
        List<ICarVdrLocationListener> list;
        synchronized (SYNC_LOCK) {
            try {
                list = this.carVdrListenerList;
            } catch (Exception e10) {
                C1016d.m6183c(TAG, "on vdr error exception, error: " + e10.getMessage());
            }
            if (list != null && list.size() != 0) {
                for (int i11 = 0; i11 < this.carVdrListenerList.size(); i11++) {
                    this.carVdrListenerList.get(i11).onVdrError(i10, str);
                }
            }
        }
    }

    public void onVdrLocationChanged(Location location) {
        List<ICarVdrLocationListener> list;
        synchronized (SYNC_LOCK) {
            try {
                list = this.carVdrListenerList;
            } catch (Exception e10) {
                C1016d.m6183c(TAG, "onVdrLocationChanged exception, error: " + e10.getMessage());
            }
            if (list != null && list.size() != 0) {
                for (int i10 = 0; i10 < this.carVdrListenerList.size(); i10++) {
                    this.carVdrListenerList.get(i10).onLocationChanged(new Location(location));
                }
            }
        }
    }

    public void removeVdrLocationListener(ICarVdrLocationListener iCarVdrLocationListener) {
        synchronized (SYNC_LOCK) {
            if (iCarVdrLocationListener != null) {
                try {
                    List<ICarVdrLocationListener> list = this.carVdrListenerList;
                    if (list != null && list.size() != 0) {
                        for (ICarVdrLocationListener iCarVdrLocationListener2 : this.carVdrListenerList) {
                            if (iCarVdrLocationListener2.equals(iCarVdrLocationListener)) {
                                this.carVdrListenerList.remove(iCarVdrLocationListener2);
                                C1016d.m6186f(TAG, "remove vdrLocationListener from carVdrListenerList, size is : " + this.carVdrListenerList.size());
                                return;
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }
}
