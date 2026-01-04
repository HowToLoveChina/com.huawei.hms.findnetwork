package com.huawei.openalliance.p169ad;

import android.media.AudioManager;

/* renamed from: com.huawei.openalliance.ad.md */
/* loaded from: classes8.dex */
public class C7422md {
    /* renamed from: a */
    public static float m45678a(AudioManager audioManager, boolean z10) {
        if (audioManager != null) {
            float streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(1);
            int streamVolume2 = audioManager.getStreamVolume(3);
            if (streamVolume != 0 && !z10 && streamMaxVolume > 1.0E-8f) {
                return streamVolume2 / streamMaxVolume;
            }
        }
        return 0.0f;
    }
}
