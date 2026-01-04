package com.huawei.android.remotecontrol.offlinelocate;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.remotecontrol.offlinelocate.bean.TrustCircleInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.trustcircle.EnhancedCircleManager;
import fk.C9721b;
import java.util.function.Consumer;
import p336he.C10155f;
import p575qe.C12347f;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p809yg.C13981a;
import sg.C12797b;

/* loaded from: classes4.dex */
public class PhoneFinderTrustCircleManager {
    private static final String DATA_INFO = "dataInfo";
    public static final String TAG = "PhoneFinderTrustCircleManager";
    private final EnhancedCircleManager circleManager;
    private EnhancedCircleManager.EnhancedCircleClient mCircleClient;
    private EnhancedCircleManager.ICircleConnection mCircleClientConn;

    public static class CircleConnection implements EnhancedCircleManager.ICircleConnection {
        private final Consumer<EnhancedCircleManager.EnhancedCircleClient> consumer;

        public CircleConnection(Consumer<EnhancedCircleManager.EnhancedCircleClient> consumer) {
            this.consumer = consumer;
        }

        public void onConnected(EnhancedCircleManager.EnhancedCircleClient enhancedCircleClient) {
            this.consumer.accept(enhancedCircleClient);
            C13981a.m83989i(PhoneFinderTrustCircleManager.TAG, "connected to the F interface");
        }

        public void onDisconnected(int i10) {
            this.consumer.accept(null);
            C13981a.m83989i(PhoneFinderTrustCircleManager.TAG, "disconnected to the F interface, reason: " + i10);
        }
    }

    public PhoneFinderTrustCircleManager(Context context) {
        this.circleManager = EnhancedCircleManager.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCircleStatus(final Consumer<TrustCircleInfo> consumer, final long j10, String str) {
        C13981a.m83989i(TAG, "checkCircleStatus from:" + str);
        EnhancedCircleManager.EnhancedCircleClient enhancedCircleClient = this.mCircleClient;
        if (enhancedCircleClient == null) {
            C13981a.m83988e(TAG, "checkCircleStatus circle client is empty");
        } else {
            enhancedCircleClient.requestEnhancedRegStatus(new Bundle(), new EnhancedCircleManager.IResultListener() { // from class: com.huawei.android.remotecontrol.offlinelocate.PhoneFinderTrustCircleManager.2
                public void onResult(Bundle bundle) {
                    int i10 = bundle.getInt("error_code");
                    int i11 = bundle.getInt("mk_version");
                    C13981a.m83989i(PhoneFinderTrustCircleManager.TAG, "checkTrustCircleStatus errorCode = " + i10 + ",mkVersion:" + i11);
                    consumer.accept(new TrustCircleInfo(6 == i10, i11));
                    new C12797b().m76784j(C12347f.m74285n().m74301m(), PhoneFinderTrustCircleManager.TAG, "", "checkTrustCircleStatus errorCode = " + i10 + ",mkVersion:" + i11 + ", duringTime: " + (System.currentTimeMillis() - j10), "", "call_trust_circle_result", "", "call_trust_circle_result", true);
                    PhoneFinderTrustCircleManager.this.circleManager.disconnect(PhoneFinderTrustCircleManager.this.mCircleClientConn);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCircleStatusByMk(Consumer<TrustCircleInfo> consumer, long j10) {
        C13981a.m83989i(TAG, "checkCircleStatus");
        EnhancedCircleManager.EnhancedCircleClient enhancedCircleClient = this.mCircleClient;
        if (enhancedCircleClient == null) {
            C13981a.m83988e(TAG, "checkCircleStatus circle client is empty");
            return;
        }
        try {
            Bundle bundleWrapData = enhancedCircleClient.wrapData(DATA_INFO.getBytes("utf-8"), "com.huawei.hidisk");
            C13981a.m83989i(TAG, "checkCircleStatus wrapData result:" + bundleWrapData.getInt("error_code", -1));
            if (bundleWrapData.getInt("error_code") == 1) {
                checkCircleStatus(consumer, j10, "mk");
            } else {
                this.circleManager.disconnect(this.mCircleClientConn);
            }
        } catch (Exception e10) {
            C13981a.m83988e(TAG, "checkCircleStatusByMk error:" + e10.getMessage());
            consumer.accept(new TrustCircleInfo(false, -1));
            this.circleManager.disconnect(this.mCircleClientConn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void joinCircle(final Consumer<TrustCircleInfo> consumer) {
        C13981a.m83989i(TAG, "joinCircle");
        if (this.mCircleClient == null) {
            C13981a.m83988e(TAG, "joinCircle circle client is empty");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("scene_id", 2);
        this.mCircleClient.createOrJoinCircle(bundle, new EnhancedCircleManager.IResultListener() { // from class: com.huawei.android.remotecontrol.offlinelocate.PhoneFinderTrustCircleManager.4
            public void onResult(Bundle bundle2) {
                int i10 = bundle2.getInt("error_code");
                int i11 = bundle2.getInt("mk_version");
                C13981a.m83989i(PhoneFinderTrustCircleManager.TAG, "joinCircle errorCode = " + i10 + ",mkVersion:" + i11);
                Consumer consumer2 = consumer;
                boolean z10 = true;
                if (6 != i10 && 1 != i10) {
                    z10 = false;
                }
                consumer2.accept(new TrustCircleInfo(z10, i11));
                new C12797b().m76784j(C12347f.m74285n().m74301m(), PhoneFinderTrustCircleManager.TAG, "", "joinTrustCircle errorCode = " + i10 + ",mkVersion:" + i11, "", "call_trust_circle_result", "", "call_trust_circle_result", true);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("joinTrustCircle errorCode = ");
                sb2.append(i10);
                C13981a.m83989i(PhoneFinderTrustCircleManager.TAG, sb2.toString());
                PhoneFinderTrustCircleManager.this.circleManager.disconnect(PhoneFinderTrustCircleManager.this.mCircleClientConn);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkTrustCircleStatus$0(final boolean z10, final Consumer consumer, final long j10, final EnhancedCircleManager.EnhancedCircleClient enhancedCircleClient) {
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.remotecontrol.offlinelocate.PhoneFinderTrustCircleManager.1
            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                C13981a.m83989i(PhoneFinderTrustCircleManager.TAG, "checkTrustCircleStatus, CircleConnection callback");
                PhoneFinderTrustCircleManager.this.mCircleClient = enhancedCircleClient;
                if (z10) {
                    PhoneFinderTrustCircleManager.this.checkCircleStatusByMk(consumer, j10);
                } else {
                    PhoneFinderTrustCircleManager.this.checkCircleStatus(consumer, j10, Constants.NORMAL_CACHE);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$joinTrustCircle$1(final Consumer consumer, final EnhancedCircleManager.EnhancedCircleClient enhancedCircleClient) {
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.remotecontrol.offlinelocate.PhoneFinderTrustCircleManager.3
            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                C13981a.m83989i(PhoneFinderTrustCircleManager.TAG, "joinTrustCircle, CircleConnection callback");
                PhoneFinderTrustCircleManager.this.mCircleClient = enhancedCircleClient;
                PhoneFinderTrustCircleManager.this.joinCircle(consumer);
            }
        });
    }

    public void checkTrustCircleStatus(final boolean z10, final Consumer<TrustCircleInfo> consumer) {
        C13981a.m83989i(TAG, "checkTrustCircleStatus isJudgeByMk:" + z10);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (!C10155f.m63259L(C12347f.m74285n().m74301m())) {
            C13981a.m83988e(TAG, "checkTrustCircleStatus CE unlock");
            consumer.accept(new TrustCircleInfo(false, -1));
        } else if (this.mCircleClient == null) {
            this.mCircleClientConn = new CircleConnection(new Consumer() { // from class: com.huawei.android.remotecontrol.offlinelocate.l
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f20013a.lambda$checkTrustCircleStatus$0(z10, consumer, jCurrentTimeMillis, (EnhancedCircleManager.EnhancedCircleClient) obj);
                }
            });
            C13981a.m83989i(TAG, "circle connection");
            this.circleManager.connect(this.mCircleClientConn);
        } else if (z10) {
            checkCircleStatusByMk(consumer, jCurrentTimeMillis);
        } else {
            checkCircleStatus(consumer, jCurrentTimeMillis, Constants.NORMAL_CACHE);
        }
    }

    public boolean isSupportTrustCircle() {
        boolean zIsFeatureSupported = this.circleManager.isFeatureSupported();
        new C12797b().m76784j(C12347f.m74285n().m74301m(), TAG, "", "isSupportTrustCircle:" + zIsFeatureSupported, "", "call_trust_circle_result", "", "call_trust_circle_result", true);
        return zIsFeatureSupported;
    }

    public void joinTrustCircle(final Consumer<TrustCircleInfo> consumer) {
        C13981a.m83989i(TAG, "joinTrustCircle");
        if (this.mCircleClient != null) {
            joinCircle(consumer);
            return;
        }
        CircleConnection circleConnection = new CircleConnection(new Consumer() { // from class: com.huawei.android.remotecontrol.offlinelocate.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f20017a.lambda$joinTrustCircle$1(consumer, (EnhancedCircleManager.EnhancedCircleClient) obj);
            }
        });
        this.mCircleClientConn = circleConnection;
        this.circleManager.connect(circleConnection);
    }
}
