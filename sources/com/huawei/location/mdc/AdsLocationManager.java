package com.huawei.location.mdc;

import android.location.Location;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.adsdataservice.Entity;
import com.huawei.adsdataservice.Receiver;
import com.huawei.adsdataservice.ResultListener;
import com.huawei.hmiuikitsdk.adsdata.agent.AdsLocationAgent;
import com.huawei.hmiuikitsdk.adsdata.agent.IAdsLocationListener;
import com.huawei.hmiuikitsdk.adsdata.receiver.EgoTfSd;
import com.huawei.hmiuikitsdk.comm.AdsDataServiceSdk;
import java.util.concurrent.TimeUnit;
import p531or.C11991a;
import p784xq.C13850f;

/* loaded from: classes8.dex */
public class AdsLocationManager {
    private static final long MDC_TIME_THRESHOLD = 990;
    private static final String TAG = "AdsLocationManager";
    private static volatile AdsLocationManager instance;
    private Entity adsEntity;
    AdsLocationAgent adsLocationAgent;
    IAdsLocationListener iAdsLocationListener;
    private volatile long lastMdcReportTime = 0;
    private volatile int mdcReportCount = 0;
    private static final byte[] VDR_SYNC_LOCK = new byte[0];
    private static final byte[] ENTITY_LOCK = new byte[0];

    private AdsLocationManager() {
    }

    private boolean checkShouldReport() {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (jElapsedRealtimeNanos - this.lastMdcReportTime < TimeUnit.MILLISECONDS.toNanos(MDC_TIME_THRESHOLD)) {
            return false;
        }
        this.lastMdcReportTime = jElapsedRealtimeNanos;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealAdsLocation(EgoTfSd egoTfSd) {
        this.mdcReportCount++;
        if (!checkShouldReport()) {
            C1016d.m6181a(TAG, "dealAdsLocation frequently, return here");
            return;
        }
        C13850f.m83120a(new StringBuilder("dealAdsLocation for 1hz, receive mdc report count: "), this.mdcReportCount, TAG);
        this.mdcReportCount = 0;
        try {
            Location location = AdsLocationHelper.getLocation(egoTfSd);
            if (location == null) {
                return;
            }
            AdsLocationCallbackManager.getInstance().onAdsLocationChanged(location);
        } catch (Exception unused) {
            C1016d.m6183c(TAG, "dealAdsLocation exception.");
        }
    }

    public static AdsLocationManager getInstance() {
        if (instance == null) {
            synchronized (VDR_SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new AdsLocationManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private boolean initAdsEntity() {
        C1016d.m6186f(TAG, "initAdsEntity");
        boolean z10 = true;
        if (isAdsStart()) {
            C1016d.m6186f(TAG, "adsEntity has been started, return here");
            return true;
        }
        synchronized (ENTITY_LOCK) {
            try {
                this.adsEntity = AdsDataServiceSdk.create(C11991a.m72145a(), new ResultListener() { // from class: com.huawei.location.mdc.AdsLocationManager.1
                    public void onFailure(String str) {
                        C1016d.m6183c(AdsLocationManager.TAG, "bindToAdsService on fail: " + str);
                    }

                    public void onSuccess(Receiver receiver) {
                        C1016d.m6186f(AdsLocationManager.TAG, "bindToAdsService onSuccess");
                        AdsLocationManager.this.registerAdsLocation();
                    }
                });
            } catch (Exception e10) {
                C1016d.m6183c(TAG, "initAdsEntity exception: " + e10.getMessage());
            }
            if (this.adsEntity == null) {
                z10 = false;
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerAdsLocation() {
        synchronized (ENTITY_LOCK) {
            try {
                C1016d.m6186f(TAG, "registerAdsLocation");
                try {
                    if (this.iAdsLocationListener == null) {
                        this.iAdsLocationListener = new IAdsLocationListener() { // from class: com.huawei.location.mdc.AdsLocationManager.2
                            public void onEgoTfSd(EgoTfSd egoTfSd) {
                                AdsLocationManager.this.dealAdsLocation(egoTfSd);
                            }
                        };
                    }
                    AdsLocationAgent adsLocationAgent = new AdsLocationAgent(this.adsEntity, this.iAdsLocationListener);
                    this.adsLocationAgent = adsLocationAgent;
                    adsLocationAgent.subscribe();
                } catch (Exception unused) {
                    C1016d.m6183c(TAG, "registerAdsLocation exception");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void unregisterAdsLocation() {
        try {
            AdsLocationAgent adsLocationAgent = this.adsLocationAgent;
            if (adsLocationAgent != null) {
                adsLocationAgent.unsubscribe();
            }
            Entity entity = this.adsEntity;
            if (entity != null) {
                AdsDataServiceSdk.destroy(entity);
            }
        } catch (Exception unused) {
            C1016d.m6183c(TAG, "unregisterAdsLocation exception");
        }
    }

    public boolean isAdsStart() {
        Entity entity = this.adsEntity;
        return entity != null && entity.isStarted();
    }

    public synchronized void removeLocationUpdates(String str) {
        C1016d.m6186f(TAG, "removeLocationUpdates");
        AdsLocationCallbackManager.getInstance().removeAdsLocationListener(str);
    }

    public synchronized boolean requestLocationUpdates(IMdcLocationListener iMdcLocationListener) {
        C1016d.m6186f(TAG, "requestLocationUpdates");
        AdsLocationCallbackManager.getInstance().addAdsLocationListener(iMdcLocationListener);
        if (isAdsStart()) {
            C1016d.m6186f(TAG, "adsEntity has been init, return here");
            return true;
        }
        C1016d.m6186f(TAG, "adsEntity not init, init here");
        return initAdsEntity();
    }
}
