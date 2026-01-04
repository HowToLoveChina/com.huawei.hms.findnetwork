package cn.com.miaozhen.mobile.tracking.viewability.origin.p059e;

import android.content.Context;
import android.view.View;
import cn.com.miaozhen.mobile.tracking.api.C1480d;
import cn.com.miaozhen.mobile.tracking.viewability.origin.C1499d;
import cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.riemann.location.common.utils.Constant;
import ijiami_release01.NCall;
import java.io.Serializable;
import java.util.List;

/* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.e.h */
/* loaded from: classes.dex */
public class C1507h implements Serializable {

    /* renamed from: a */
    private String f6430a;

    /* renamed from: b */
    private String f6431b;

    /* renamed from: c */
    private transient View f6432c;

    /* renamed from: d */
    private String f6433d;

    /* renamed from: e */
    private MzCallBack f6434e;

    /* renamed from: f */
    private C1480d.a f6435f;

    /* renamed from: h */
    public C1508i f6437h;

    /* renamed from: i */
    private C1506g f6438i;

    /* renamed from: m */
    private List<EnumC1503d> f6442m;

    /* renamed from: r */
    private C1499d f6447r;

    /* renamed from: s */
    private int f6448s;

    /* renamed from: j */
    private boolean f6439j = false;

    /* renamed from: k */
    private boolean f6440k = false;

    /* renamed from: l */
    private boolean f6441l = true;

    /* renamed from: n */
    private String f6443n = null;

    /* renamed from: o */
    private boolean f6444o = false;

    /* renamed from: p */
    private boolean f6445p = false;

    /* renamed from: q */
    private transient InterfaceC1500a f6446q = null;

    /* renamed from: t */
    private boolean f6449t = false;

    /* renamed from: g */
    private EnumC1502c f6436g = EnumC1502c.f6399a;

    public C1507h(String str, String str2, View view, String str3, C1506g c1506g, C1499d c1499d, MzCallBack mzCallBack, C1480d.a aVar) {
        this.f6437h = null;
        this.f6430a = str;
        this.f6431b = str2;
        this.f6432c = view;
        this.f6433d = str3;
        this.f6438i = c1506g;
        this.f6447r = c1499d;
        this.f6434e = mzCallBack;
        this.f6435f = aVar;
        this.f6437h = new C1508i(c1499d.m8526h(), c1506g.m8554e(), c1499d.m8518d() > 0.0f ? 1.0f - this.f6447r.m8518d() : c1506g.m8545a());
        m8557b();
    }

    /* renamed from: b */
    private void m8557b() {
        NCall.m64618IV(new Object[]{201, this});
    }

    /* renamed from: d */
    private void m8558d() {
        NCall.m64618IV(new Object[]{202, this});
    }

    /* renamed from: e */
    private void m8559e() {
        NCall.m64618IV(new Object[]{203, this});
    }

    /* renamed from: a */
    public EnumC1502c m8560a() {
        return (EnumC1502c) NCall.m64616IL(new Object[]{204, this});
    }

    /* renamed from: c */
    public void m8565c() {
        NCall.m64618IV(new Object[]{Integer.valueOf(PlayerConstants.EventCode.MEDIA_INFO_METADATA_UPDATE), this});
    }

    public String toString() {
        return (String) NCall.m64616IL(new Object[]{210, this});
    }

    /* renamed from: a */
    public void m8561a(Context context) {
        NCall.m64618IV(new Object[]{Integer.valueOf(Constant.ERROR_ACC_GRAVITY_INVALID), this, context});
    }

    /* renamed from: a */
    public void m8562a(MzCallBack mzCallBack, C1480d.a aVar) {
        NCall.m64618IV(new Object[]{206, this, mzCallBack, aVar});
    }

    /* renamed from: a */
    public void m8563a(InterfaceC1500a interfaceC1500a) {
        NCall.m64618IV(new Object[]{Integer.valueOf(PlayerConstants.EventCode.VIDEO_FIRST_FRAME), this, interfaceC1500a});
    }

    /* renamed from: a */
    public void m8564a(boolean z10) {
        NCall.m64618IV(new Object[]{Integer.valueOf(PlayerConstants.EventCode.VIDEO_DECODE_LAGGING), this, Boolean.valueOf(z10)});
    }
}
