package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.inner.C5077a;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7753b;
import java.util.HashMap;

/* renamed from: com.huawei.openalliance.ad.pp */
/* loaded from: classes8.dex */
public class C7582pp {

    /* renamed from: a */
    private static final byte[] f35354a = new byte[0];

    /* renamed from: b */
    private static C7582pp f35355b;

    /* renamed from: c */
    private Context f35356c;

    /* renamed from: d */
    private ContentRecord f35357d;

    /* renamed from: e */
    private InterfaceC7615qq f35358e;

    /* renamed from: f */
    private String f35359f = null;

    /* renamed from: g */
    private String f35360g = null;

    private C7582pp(Context context) {
        this.f35356c = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C7582pp m46808a(Context context) {
        return m46810b(context);
    }

    /* renamed from: b */
    private static C7582pp m46810b(Context context) {
        C7582pp c7582pp;
        synchronized (f35354a) {
            try {
                if (f35355b == null) {
                    f35355b = new C7582pp(context);
                }
                c7582pp = f35355b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7582pp;
    }

    /* renamed from: a */
    public void m46812a(Context context, Bundle bundle, String str) {
        try {
            AbstractC7185ho.m43820b("TemplateActionProcessor", "onEnd");
            long j10 = bundle.getLong("startTime");
            long j11 = bundle.getLong("endTime");
            int i10 = bundle.getInt(ParamConstants.Param.START_PROGRESS);
            int i11 = bundle.getInt(ParamConstants.Param.END_PROGRESS);
            if (bundle.getBoolean(ParamConstants.Param.JUMP_LANDING, false)) {
                HashMap map = new HashMap();
                map.put(MapKeyNames.LINKED_CUSTOM_VIDEO_SOUND_SWITCH, bundle.getString(MapKeyNames.LINKED_CUSTOM_VIDEO_SOUND_SWITCH));
                map.put(MapKeyNames.LINKED_CUSTOM_VIDEO_PROGRESS, String.valueOf(bundle.getInt(MapKeyNames.LINKED_CUSTOM_VIDEO_PROGRESS)));
                map.put(MapKeyNames.USE_TEMPLATE, Boolean.TRUE.toString());
                AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(this.f35356c, this.f35357d, map);
                if (AbstractC7811dd.m48310b(this.f35356c)) {
                    AbstractC7185ho.m43820b("TemplateActionProcessor", "screenLocked onEnd");
                    C5077a.m30321a(context, new C5077a.c(abstractC7687tiM47245a));
                } else {
                    abstractC7687tiM47245a.mo47233a();
                }
            }
            InterfaceC7615qq interfaceC7615qq = this.f35358e;
            if (interfaceC7615qq != null) {
                interfaceC7615qq.mo46621d(j10, j11, i10, i11);
            }
            m46821b(str);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("TemplateActionProcessor", "onEnd err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public void m46821b(String str) {
        ExtensionActionListener extensionActionListener;
        String str2 = this.f35359f;
        if (str2 == null || !str2.equals(str)) {
            this.f35359f = str;
            AbstractC7185ho.m43820b("TemplateActionProcessor", "onDismiss");
            if (HiAd.getInstance(this.f35356c).getExtensionActionListener() == null) {
                return;
            } else {
                extensionActionListener = HiAd.getInstance(this.f35356c).getExtensionActionListener();
            }
        } else {
            if (str != null || HiAd.getInstance(this.f35356c).getExtensionActionListener() == null) {
                return;
            }
            extensionActionListener = HiAd.getInstance(this.f35356c).getExtensionActionListener();
            str = null;
        }
        extensionActionListener.onDismiss(str);
    }

    /* renamed from: b */
    private void m46811b(String str, String str2) {
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a((Long) null).m46873a((Integer) null).m46878b((Integer) 14).m46875a(str).m46885e(str2).m46884d(String.format("%s,%s", 0, 0));
        this.f35358e.mo46593a(aVar.m46877a());
    }

    /* renamed from: a */
    public void m46813a(Context context, String str, Bundle bundle) {
        int i10;
        try {
            if (!bundle.getBoolean(ParamConstants.Param.HAS_PLAYED, true)) {
                AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(this.f35356c, this.f35357d, new HashMap(0));
                if (AbstractC7811dd.m48310b(this.f35356c)) {
                    AbstractC7185ho.m43820b("TemplateActionProcessor", "screenLocked onFail");
                    C5077a.m30321a(context, new C5077a.c(abstractC7687tiM47245a));
                } else {
                    abstractC7687tiM47245a.mo47233a();
                }
            }
            i10 = bundle.getInt(ParamConstants.Param.ERR_CODE);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("TemplateActionProcessor", "get errCode err: %s", th2.getClass().getSimpleName());
            i10 = -1;
        }
        m46816a(str, i10);
    }

    /* renamed from: a */
    public void m46814a(Bundle bundle, String str) {
        try {
            AbstractC7185ho.m43820b("TemplateActionProcessor", "onClose");
            int i10 = bundle.getInt(ParamConstants.Param.X_AXIS);
            int i11 = bundle.getInt(ParamConstants.Param.Y_AXIS);
            InterfaceC7615qq interfaceC7615qq = this.f35358e;
            if (interfaceC7615qq != null) {
                interfaceC7615qq.mo46576a(i10, i11);
            }
            m46821b(str);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("TemplateActionProcessor", "onClose err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public boolean m46822b(Context context, Bundle bundle, String str, String str2) {
        AbstractC7185ho.m43820b("TemplateActionProcessor", "onEasterEggClick");
        return m46809a(context, bundle, str, str2, EventType.EASTEREGGCLICK);
    }

    /* renamed from: a */
    public void m46815a(String str) {
        AbstractC7185ho.m43820b("TemplateActionProcessor", "onPrepare");
        if (HiAd.getInstance(this.f35356c).getExtensionActionListener() != null) {
            HiAd.getInstance(this.f35356c).getExtensionActionListener().onPrepare(str);
        }
    }

    /* renamed from: a */
    public void m46816a(String str, int i10) {
        String str2 = this.f35360g;
        if (str2 == null || !str2.equals(str)) {
            this.f35360g = str;
            AbstractC7185ho.m43820b("TemplateActionProcessor", "onFail");
            if (HiAd.getInstance(this.f35356c).getExtensionActionListener() != null) {
                HiAd.getInstance(this.f35356c).getExtensionActionListener().onFail(str, i10);
            }
        }
    }

    /* renamed from: a */
    public void m46817a(String str, Bundle bundle) {
        m46813a(this.f35356c, str, bundle);
    }

    /* renamed from: a */
    public void m46818a(String str, String str2) {
        AbstractC7185ho.m43820b("TemplateActionProcessor", "onShow");
        C7586a.a aVar = new C7586a.a();
        aVar.m46875a(str);
        aVar.m46884d(Constants.DEF_SLOT_POSITION);
        InterfaceC7615qq interfaceC7615qq = this.f35358e;
        if (interfaceC7615qq != null) {
            interfaceC7615qq.mo46610b(aVar.m46877a());
        }
        if (HiAd.getInstance(this.f35356c).getExtensionActionListener() != null) {
            HiAd.getInstance(this.f35356c).getExtensionActionListener().onShow(str2);
        }
    }

    /* renamed from: a */
    public boolean m46819a(Context context, Bundle bundle, String str, String str2) {
        AbstractC7185ho.m43820b("TemplateActionProcessor", "onClick");
        return m46809a(context, bundle, str, str2, EventType.CLICK);
    }

    /* renamed from: a */
    private boolean m46809a(Context context, Bundle bundle, String str, String str2, EventType eventType) {
        try {
            int i10 = bundle.getInt(ParamConstants.Param.X_AXIS);
            int i11 = bundle.getInt(ParamConstants.Param.Y_AXIS);
            int i12 = bundle.getInt(ParamConstants.Param.CLICK_SOURCE);
            MaterialClickInfo materialClickInfo = (MaterialClickInfo) AbstractC7758be.m47739b(bundle.getString("click_info"), MaterialClickInfo.class, new Class[0]);
            AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(context, this.f35357d, new HashMap(0));
            if (abstractC7687tiM47245a.mo47233a()) {
                if (this.f35358e != null) {
                    if (eventType == EventType.CLICK) {
                        m46811b(C7753b.m47699a(context), (materialClickInfo == null || !AbstractC7806cz.m48187p(materialClickInfo.m44508c())) ? null : materialClickInfo.m44508c());
                    }
                    C7587b.a aVar = new C7587b.a();
                    aVar.m46912a(i10).m46919b(i11).m46920b(abstractC7687tiM47245a.m47250c()).m46915a(Integer.valueOf(i12)).m46914a(materialClickInfo).m46923d(str).m46913a(eventType);
                    this.f35358e.mo46594a(aVar.m46918a());
                }
                if (HiAd.getInstance(this.f35356c).getExtensionActionListener() == null) {
                    return true;
                }
                HiAd.getInstance(this.f35356c).getExtensionActionListener().onClick(str2);
                return true;
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("TemplateActionProcessor", "deal with click err: %s", th2.getClass().getSimpleName());
        }
        return false;
    }

    /* renamed from: a */
    public boolean m46820a(AdContentData adContentData) {
        if (adContentData == null) {
            return false;
        }
        this.f35357d = adContentData.m39276a() == 1 ? C7104et.m43127b(this.f35356c).mo43102a(adContentData.m39290d(), adContentData.m39300i(), adContentData.m39287c()) : C7012db.m41242a().m41245a(adContentData.m39295f());
        ContentRecord contentRecord = this.f35357d;
        if (contentRecord == null) {
            return false;
        }
        contentRecord.m41612v(adContentData.m39295f());
        this.f35357d.m41536c(adContentData.m39283b());
        this.f35357d.m41534c(adContentData.m39293e());
        this.f35357d.m41538c(adContentData.m39299h());
        this.f35357d.m41618y(adContentData.m39297g());
        Context context = this.f35356c;
        this.f35358e = new C7560ou(context, C7662sk.m47225a(context, adContentData.m39276a()), this.f35357d);
        return true;
    }
}
