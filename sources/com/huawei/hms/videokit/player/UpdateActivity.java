package com.huawei.hms.videokit.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.riemann.location.common.utils.Constant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class UpdateActivity extends Activity {

    /* renamed from: b */
    private static final Map<Integer, Integer> f30253b = new C6535a();

    /* renamed from: a */
    private int f30254a = 9;

    /* renamed from: com.huawei.hms.videokit.player.UpdateActivity$a */
    public class C6535a extends HashMap<Integer, Integer> {
        public C6535a() {
            put(1, 0);
            put(3, 1);
            put(202, 1);
            put(204, 2);
            put(2, 3);
            put(203, 3);
            put(Integer.valueOf(PlayerConstants.EventCode.MEDIA_INFO_METADATA_UPDATE), 4);
            put(210, 5);
            put(201, 6);
            put(Integer.valueOf(Constant.ERROR_ACC_GRAVITY_INVALID), 7);
            put(206, 8);
            put(0, 9);
            put(Integer.valueOf(PlayerConstants.EventCode.VIDEO_FIRST_FRAME), 9);
            put(Integer.valueOf(PlayerConstants.EventCode.VIDEO_DECODE_LAGGING), 9);
        }
    }

    /* renamed from: a */
    private void m37101a() {
        new C6557f0(this).m37365a(this.f30254a);
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C6550c1.m37264c("UpdateActivity", "onActivityResult requestCode:" + i10 + " resultCode:" + i11);
        if (i10 == 1 && i11 == -1) {
            WisePlayerFactory.m37116d(true);
            WisePlayerFactory.m37128p();
            WisePlayerFactory.initFactory(WisePlayerFactory.m37118f(), WisePlayerFactory.m37120h(), WisePlayerFactory.m37117e());
            finish();
            return;
        }
        if (intent != null) {
            int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, PlayerConstants.EventCode.VIDEO_FIRST_FRAME);
            Map<Integer, Integer> map = f30253b;
            if (map.containsKey(Integer.valueOf(intExtra))) {
                this.f30254a = map.get(Integer.valueOf(intExtra)).intValue();
            }
            C6550c1.m37264c("UpdateActivity", "kitUpdateResult:" + intExtra + " upgradeCode:" + this.f30254a);
        }
        m37101a();
        WisePlayerFactory.m37123k();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(C6532R.layout.activity_update);
        C6550c1.m37264c("UpdateActivity", "onCreate");
        try {
            if (getIntent() != null && getIntent().getExtras() != null) {
                Object obj = getIntent().getExtras().get(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                if (obj instanceof Intent) {
                    Intent intent = (Intent) obj;
                    int flags = intent.getFlags();
                    if ((flags & 1) == 0 && (flags & 2) == 0) {
                        startActivityForResult(intent, 1);
                        return;
                    }
                    str = "can't grand URI PERMISSION, flags:" + flags;
                } else {
                    str = "intent is error";
                }
                C6550c1.m37262b("UpdateActivity", str);
            }
            m37101a();
            WisePlayerFactory.m37123k();
        } catch (Exception e10) {
            C6550c1.m37258a("UpdateActivity", "start update components activity error:", e10);
            m37101a();
            WisePlayerFactory.m37123k();
        }
    }
}
