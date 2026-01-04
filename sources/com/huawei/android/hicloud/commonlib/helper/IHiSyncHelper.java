package com.huawei.android.hicloud.commonlib.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Switch;
import com.huawei.android.hicloud.commonlib.view.CommonDialogInterface;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import java.util.ArrayList;
import p422k9.AbstractC11020c;
import p709vj.InterfaceC13449b;

/* loaded from: classes3.dex */
public interface IHiSyncHelper {
    /* renamed from: A */
    AlertDialog mo15824A(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnKeyListener onKeyListener);

    /* renamed from: B */
    void mo15825B(Context context);

    /* renamed from: C */
    void mo15826C();

    /* renamed from: D */
    boolean mo15827D(Context context, String str, boolean z10);

    /* renamed from: E */
    void mo15828E(Activity activity, AbstractC11020c abstractC11020c);

    /* renamed from: F */
    void mo15829F(Context context, Handler handler, int i10, boolean z10);

    /* renamed from: G */
    void mo15830G(Context context);

    /* renamed from: H */
    void mo15831H(Context context);

    /* renamed from: I */
    void mo15832I(Context context);

    /* renamed from: J */
    void mo15833J(Context context);

    /* renamed from: K */
    void mo15834K(Context context, Bundle bundle);

    /* renamed from: L */
    void mo15835L(Context context);

    /* renamed from: M */
    void mo15836M(Context context);

    /* renamed from: N */
    void mo15837N(Context context, boolean z10, boolean z11, boolean z12, boolean z13);

    /* renamed from: O */
    void mo15838O(Context context, Handler handler);

    /* renamed from: P */
    boolean mo15839P(int i10);

    /* renamed from: Q */
    void mo15840Q(Context context, boolean z10);

    /* renamed from: R */
    void mo15841R(AlertDialog alertDialog);

    /* renamed from: S */
    boolean mo15842S(int i10);

    /* renamed from: T */
    boolean mo15843T(Context context);

    /* renamed from: U */
    boolean mo15844U(int i10);

    /* renamed from: V */
    CommonDialogInterface mo15845V(Context context);

    /* renamed from: W */
    void mo15846W(Context context);

    /* renamed from: X */
    void mo15847X(Bundle bundle, InterfaceC13449b interfaceC13449b);

    /* renamed from: Y */
    void mo15848Y(Context context, String str, Switch r32, boolean z10);

    /* renamed from: Z */
    void mo15849Z(Context context);

    /* renamed from: a */
    void mo15850a(Context context, String str, boolean z10);

    /* renamed from: a0 */
    BaseAdapter mo15851a0(Context context);

    /* renamed from: b */
    void mo15852b(Context context, String str);

    /* renamed from: b0 */
    ArrayList<SyncConfigService> mo15853b0(Context context);

    /* renamed from: c */
    void mo15854c(Context context, boolean z10);

    /* renamed from: c0 */
    void mo15855c0(ListView listView, BaseAdapter baseAdapter);

    void cloudbackupOpr(boolean z10);

    /* renamed from: d */
    Long mo15856d();

    /* renamed from: d0 */
    boolean mo15857d0();

    /* renamed from: e */
    void mo15858e(Context context, String str, String str2);

    /* renamed from: e0 */
    void mo15859e0(Handler.Callback callback);

    /* renamed from: f */
    void mo15860f();

    /* renamed from: f0 */
    boolean mo15861f0(Context context);

    /* renamed from: g */
    void mo15862g(Context context);

    /* renamed from: g0 */
    LinkMovementMethod mo15863g0();

    /* renamed from: h */
    boolean mo15864h(Context context);

    /* renamed from: h0 */
    void mo15865h0(Context context, String str, boolean z10);

    /* renamed from: i */
    void mo15866i(Handler.Callback callback);

    /* renamed from: i0 */
    void mo15867i0(Context context);

    boolean inBackup();

    boolean inRestore();

    boolean inRestoreFirst();

    boolean isSendPhoneFinderOning();

    boolean isShowGalleryItemView();

    boolean isSupportAntiTheft();

    /* renamed from: j */
    void mo15868j(Boolean bool, Activity activity);

    /* renamed from: j0 */
    String mo15869j0(Context context, String str);

    /* renamed from: k */
    boolean mo15870k(Context context);

    /* renamed from: k0 */
    void mo15871k0(String str, String str2, String str3, int i10, String str4, int i11, boolean z10, boolean z11, boolean z12);

    /* renamed from: l */
    CommonDialogInterface mo15872l(Context context);

    /* renamed from: l0 */
    void mo15873l0(Context context, Activity activity);

    /* renamed from: m */
    Integer mo15874m(int i10);

    /* renamed from: m0 */
    void mo15875m0();

    /* renamed from: n */
    ClickableSpan mo15876n(Context context, int i10);

    /* renamed from: n0 */
    void mo15877n0(Context context, Intent intent);

    /* renamed from: o */
    void mo15878o(Context context);

    /* renamed from: o0 */
    CommonDialogInterface mo15879o0(Context context);

    void openPhoneFinderInBack();

    /* renamed from: p */
    boolean mo15880p(int i10);

    /* renamed from: p0 */
    void mo15881p0(Context context, int i10, String str);

    /* renamed from: q */
    String mo15882q(Context context, String str);

    /* renamed from: q0 */
    void mo15883q0(Context context, Bundle bundle);

    /* renamed from: r */
    boolean mo15884r(Context context);

    /* renamed from: s */
    String mo15885s();

    void setMrGuide(boolean z10);

    /* renamed from: t */
    ArrayList<DriveConfigService> mo15886t(Context context);

    /* renamed from: u */
    LinkMovementMethod mo15887u();

    /* renamed from: v */
    void mo15888v(String str, Bundle bundle);

    /* renamed from: w */
    ClickableSpan mo15889w(Context context, String str);

    void writeUISwitchToFile();

    /* renamed from: x */
    boolean mo15890x(int i10);

    /* renamed from: y */
    String mo15891y(Context context, String str);

    /* renamed from: z */
    void mo15892z(Context context);
}
