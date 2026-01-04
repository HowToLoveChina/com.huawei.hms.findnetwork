package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;

/* renamed from: com.huawei.openalliance.ad.views.aj */
/* loaded from: classes2.dex */
public class C8075aj extends AbstractC8078b {

    /* renamed from: y */
    private final int f37516y;

    /* renamed from: z */
    private SurfaceHolder.Callback f37517z;

    public C8075aj(Context context) {
        super(context);
        this.f37516y = hashCode();
        this.f37517z = new SurfaceHolder.Callback() { // from class: com.huawei.openalliance.ad.views.aj.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
                C8075aj.this.m50083b(i11, i12);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                AbstractC7185ho.m43820b(C8075aj.this.getLogTag(), "surfaceCreated");
                C8075aj.this.m50081a(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                C8075aj.this.m50084e();
            }
        };
        m50000b(context);
    }

    /* renamed from: b */
    private void m50000b(Context context) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_surfaceview_video, this);
        ((SurfaceView) findViewById(C6849R.id.hiad_id_video_surface_view)).getHolder().addCallback(this.f37517z);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8078b
    public String getLogTag() {
        return "SurfaceVideoView" + this.f37516y;
    }
}
