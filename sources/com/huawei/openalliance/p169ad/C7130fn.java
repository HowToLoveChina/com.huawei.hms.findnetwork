package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.UserCloseRecord;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.fn */
/* loaded from: classes8.dex */
public class C7130fn extends AbstractC7100ep implements InterfaceC7150gg {

    /* renamed from: c */
    private static C7130fn f32920c;

    /* renamed from: d */
    private static final byte[] f32921d = new byte[0];

    private C7130fn(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static C7130fn m43543a(Context context) {
        C7130fn c7130fn;
        synchronized (f32921d) {
            try {
                if (f32920c == null) {
                    f32920c = new C7130fn(context);
                }
                c7130fn = f32920c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7130fn;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7100ep
    /* renamed from: e */
    public void mo42990e() {
        super.mo42990e();
        m42979a(UserCloseRecord.class, (EnumC7125fi) null, (String[]) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7150gg
    /* renamed from: a */
    public List<UserCloseRecord> mo43544a(long j10, long j11) {
        return m42984a(UserCloseRecord.class, null, EnumC7125fi.USER_CLOSE_QUERY_BY_TIME_WHERE, new String[]{String.valueOf(j10), String.valueOf(j11)}, null, null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7150gg
    /* renamed from: a */
    public void mo43545a(long j10) {
        m42979a(UserCloseRecord.class, EnumC7125fi.USER_CLOSE_DELETE_EXPIRE_WHERE, new String[]{String.valueOf(j10)});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7150gg
    /* renamed from: a */
    public void mo43546a(UserCloseRecord userCloseRecord) {
        m42981a(UserCloseRecord.class, userCloseRecord.m41863d(this.f32709a));
    }
}
