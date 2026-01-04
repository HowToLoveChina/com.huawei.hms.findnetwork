package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import fk.C9721b;
import gp.C10028c;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import p015ak.C0209d;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p252e9.C9430g;
import p292fn.C9733f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* loaded from: classes3.dex */
public class CheckCloudAlbumReleaseSpaceTask extends AbstractC12367d {

    /* renamed from: a */
    public Context f13077a;

    /* renamed from: b */
    public Timer f13078b;

    /* renamed from: com.huawei.android.hicloud.task.simple.CheckCloudAlbumReleaseSpaceTask$a */
    public static class C3005a extends TimerTask {

        /* renamed from: a */
        public Timer f13079a;

        /* renamed from: b */
        public Context f13080b;

        public C3005a(Timer timer, Context context) {
            this.f13079a = timer;
            this.f13080b = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Timer timer;
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                C11839m.m70687e("CheckCloudAlbumReleaseSpaceTask", "releasespace,cloudAlbumRouter is null");
                return;
            }
            Context context = this.f13080b;
            if (context == null) {
                C11839m.m70687e("CheckCloudAlbumReleaseSpaceTask", "releasespace,context is null");
                return;
            }
            if (!interfaceC9282a.mo58451r(context).isGeneralAlbumOn()) {
                C11839m.m70688i("CheckCloudAlbumReleaseSpaceTask", "generalAlbumOn is false");
                return;
            }
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null) {
                C11839m.m70687e("CheckCloudAlbumReleaseSpaceTask", "releasespace,hiCloudSysParamMap is null");
                return;
            }
            if (!C0209d.m1227Y1(this.f13080b, Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI))) {
                C11839m.m70687e("CheckCloudAlbumReleaseSpaceTask", "is not Target App or System App");
                return;
            }
            try {
                try {
                    float releaseSpaceSize = hiCloudSysParamMapM60757p.getReleaseSpaceSize();
                    int releaseSpaceNoticeFrequency = hiCloudSysParamMapM60757p.getReleaseSpaceNoticeFrequency();
                    int releaseSpaceNoticeLimit = hiCloudSysParamMapM60757p.getReleaseSpaceNoticeLimit();
                    C11839m.m70686d("CheckCloudAlbumReleaseSpaceTask", "releaseSpaceSize:" + releaseSpaceSize + " releaseSpaceNoticeFrequency:" + releaseSpaceNoticeFrequency + " releaseSpaceNoticeLimit:" + releaseSpaceNoticeLimit);
                    C10028c c10028cM62183d0 = C10028c.m62183d0(this.f13080b);
                    int iM62414x0 = c10028cM62183d0.m62414x0(NotifyConstants.CloudAlbumReleaseSpace.NOTICE_TIMES);
                    long jM62247N = c10028cM62183d0.m62247N(NotifyConstants.CloudAlbumReleaseSpace.POP_TIME);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(jM62247N);
                    calendar.add(5, releaseSpaceNoticeFrequency);
                    long timeInMillis = calendar.getTimeInMillis();
                    C11839m.m70688i("CheckCloudAlbumReleaseSpaceTask", "release lasttime:" + jM62247N + " timeInMillis: " + timeInMillis + " currentTime:" + jCurrentTimeMillis + " limitTimes:" + iM62414x0);
                    if (jCurrentTimeMillis > timeInMillis && iM62414x0 < releaseSpaceNoticeLimit) {
                        C11839m.m70688i("CheckCloudAlbumReleaseSpaceTask", "call for check size");
                        C9430g.m59138a().m59140c(this.f13080b);
                        this.f13080b.getContentResolver().call(Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI), NotifyConstants.CloudAlbumReleaseSpace.METHOD_SYNC_CLOUD_DATA, (String) null, (Bundle) null);
                    }
                    timer = this.f13079a;
                    if (timer == null) {
                        return;
                    }
                } catch (Exception e10) {
                    C11839m.m70687e("CheckCloudAlbumReleaseSpaceTask", "releasespacetimertask exception:" + e10.getMessage());
                    C9430g.m59138a().m59143f(this.f13080b);
                    timer = this.f13079a;
                    if (timer == null) {
                        return;
                    }
                }
                timer.cancel();
                this.f13079a = null;
            } catch (Throwable th2) {
                Timer timer2 = this.f13079a;
                if (timer2 != null) {
                    timer2.cancel();
                    this.f13079a = null;
                }
                throw th2;
            }
        }
    }

    public CheckCloudAlbumReleaseSpaceTask(Context context) {
        this.f13077a = context;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        Timer timer = this.f13078b;
        if (timer != null) {
            timer.cancel();
        }
        this.f13078b = new Timer("releasespace");
        this.f13078b.schedule(new C3005a(this.f13078b, this.f13077a), C2783d.m16083G());
    }
}
