package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.IAdEvent;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7753b;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ok */
/* loaded from: classes8.dex */
public class C7543ok implements IAdEvent {

    /* renamed from: a */
    private C7302e f35000a;

    /* renamed from: b */
    private InterfaceC7615qq f35001b;

    /* renamed from: c */
    private ContentRecord f35002c;

    /* renamed from: e */
    private String f35004e;

    /* renamed from: d */
    private int f35003d = 0;

    /* renamed from: f */
    private final byte[] f35005f = new byte[0];

    public C7543ok(Context context, C7302e c7302e) {
        this.f35000a = c7302e;
        this.f35001b = new C7560ou(context, C7662sk.m47225a(context, c7302e.m44632e()));
        ContentRecord contentRecordM46698a = C7570pd.m46698a(c7302e);
        this.f35002c = contentRecordM46698a;
        contentRecordM46698a.m41536c(c7302e.getShowId());
        this.f35001b.mo46590a(this.f35002c);
    }

    /* renamed from: a */
    private boolean m46276a() {
        if (this.f35000a == null || this.f35002c == null) {
            AbstractC7185ho.m43820b("IAdEventProcessor", "  ad is not valid");
            return false;
        }
        synchronized (this.f35005f) {
            try {
                String showId = this.f35000a.getShowId();
                if (TextUtils.isEmpty(showId)) {
                    showId = String.valueOf(AbstractC7741ao.m47566c());
                }
                this.f35004e = showId;
                this.f35002c.m41536c(showId);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }

    /* renamed from: b */
    private int m46278b(View view) {
        String str;
        if (view == null) {
            str = " ad view is null";
        } else if (view.isShown()) {
            int width = view.getWidth() * view.getHeight();
            if (width <= 0) {
                str = " ad viewArea is zero";
            } else {
                Rect rect = new Rect();
                if (view.getLocalVisibleRect(rect)) {
                    int iWidth = rect.width() * rect.height();
                    if (iWidth > 0) {
                        return (iWidth * 100) / width;
                    }
                    str = " ad view is not visible, visibleArea is zero";
                } else {
                    str = " ad view is not visible";
                }
            }
        } else {
            str = " ad view is not shown";
        }
        AbstractC7185ho.m43820b("IAdEventProcessor", str);
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAdEvent
    public void onAdClosed(List<String> list) {
        if (this.f35000a == null || this.f35002c == null) {
            AbstractC7185ho.m43820b("IAdEventProcessor", "  ad is not valid");
        } else if (m46276a()) {
            this.f35001b.mo46577a(0, 0, list);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAdEvent
    public void onAdShowed(View view) {
        if (this.f35000a == null || this.f35002c == null) {
            AbstractC7185ho.m43820b("IAdEventProcessor", " ad is not valid");
            return;
        }
        if (!m46277a(view)) {
            AbstractC7185ho.m43820b("IAdEventProcessor", " ad view is not visible!");
            return;
        }
        synchronized (this.f35005f) {
            try {
                String strValueOf = !TextUtils.isEmpty(this.f35004e) ? this.f35004e : String.valueOf(AbstractC7741ao.m47566c());
                this.f35000a.m44642h(strValueOf);
                this.f35002c.m41536c(strValueOf);
                ContentRecord contentRecord = this.f35002c;
                int i10 = this.f35003d + 1;
                this.f35003d = i10;
                contentRecord.m41540d(i10);
                this.f35004e = null;
                this.f35001b.mo46606b();
                int iM46278b = m46278b(view);
                this.f35001b.mo46581a(this.f35000a.getMinEffectiveShowTime(), iM46278b);
                C7586a.a aVar = new C7586a.a();
                String strM48325e = AbstractC7811dd.m48325e(view);
                C7302e c7302e = this.f35000a;
                if (c7302e != null) {
                    AbstractC7185ho.m43818a("IAdEventProcessor", "slotId: %s, contentId: %s, slot pos: %s", c7302e.getSlotId(), this.f35000a.getContentId(), strM48325e);
                }
                if (!AbstractC7806cz.m48165b(strM48325e)) {
                    aVar.m46884d(strM48325e);
                }
                aVar.m46874a(Long.valueOf(this.f35000a.getMinEffectiveShowTime())).m46873a(Integer.valueOf(iM46278b)).m46878b((Integer) 7).m46875a(C7753b.m47699a(view.getContext())).m46885e(C8190vl.m50727b(view)).m46881c((Integer) 0);
                this.f35001b.mo46593a(aVar.m46877a());
            } finally {
            }
        }
    }

    /* renamed from: a */
    private boolean m46277a(View view) {
        String str;
        if (view == null) {
            str = " ad view is null";
        } else {
            if (view.isShown()) {
                return true;
            }
            str = " ad view is not shown";
        }
        AbstractC7185ho.m43820b("IAdEventProcessor", str);
        return false;
    }
}
