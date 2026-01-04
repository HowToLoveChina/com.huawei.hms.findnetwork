package p232dp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.commonlib.space.QuotaInfoRsp;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: dp.d */
/* loaded from: classes.dex */
public interface InterfaceC9285d {
    /* renamed from: A */
    int mo17164A(Context context, int i10, String str);

    /* renamed from: B */
    void mo17165B(Context context, String str, int i10);

    /* renamed from: C */
    void mo17166C();

    /* renamed from: a */
    void mo17168a();

    void activeCloud(String str);

    /* renamed from: b */
    void mo17169b(Context context, long j10, String str);

    /* renamed from: c */
    void mo17170c(String str);

    /* renamed from: d */
    void mo17171d(Context context);

    /* renamed from: e */
    void mo17172e();

    /* renamed from: f */
    void mo17173f(Context context);

    /* renamed from: g */
    void mo17174g(Context context, String str, boolean z10);

    String getParam(String str, String str2, String str3);

    /* renamed from: h */
    QuotaSpaceInfo mo17175h();

    /* renamed from: i */
    void mo17176i(String str);

    /* renamed from: j */
    boolean mo17177j(List<String> list, List<String> list2, String str, int i10, LinkedHashMap<String, String> linkedHashMap);

    /* renamed from: k */
    void mo17178k(Context context, ArrayList<String> arrayList, String str, String str2);

    /* renamed from: l */
    void mo17179l();

    /* renamed from: m */
    void mo17180m();

    /* renamed from: n */
    void mo17181n(Activity activity);

    /* renamed from: o */
    QuotaInfoRsp mo17182o();

    /* renamed from: p */
    void mo17183p();

    /* renamed from: q */
    boolean mo17184q();

    /* renamed from: r */
    void mo17185r(Activity activity);

    /* renamed from: s */
    void mo17186s(AppStatus appStatus);

    /* renamed from: t */
    void mo17187t(Activity activity, int i10, int i11, Intent intent);

    /* renamed from: u */
    int mo17188u();

    /* renamed from: v */
    int mo17189v();

    /* renamed from: w */
    int mo17190w();

    /* renamed from: x */
    boolean mo17191x(Context context);

    /* renamed from: y */
    void mo17192y(Context context, String str, int i10, long j10);

    /* renamed from: z */
    void mo17193z(Context context, String str);
}
