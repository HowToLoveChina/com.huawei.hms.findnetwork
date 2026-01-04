package com.huawei.phoneservice.faq.p174ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.phoneservice.faq.AbstractC8274a;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqDialogUtil;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSharePrefUtil;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.response.C8349i;
import com.huawei.phoneservice.faq.response.C8350j;
import com.huawei.phoneservice.faq.utils.C8411a;
import com.huawei.phoneservice.faq.utils.C8414d;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.FaqAutoNextLineLinearLayout;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import com.huawei.phoneservice.faqcommon.utils.SdkFaqCommonManager;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.phoneservice.faq.ui.c */
/* loaded from: classes4.dex */
public class ViewOnClickListenerC8408c extends AbstractC8274a implements View.OnClickListener {

    /* renamed from: u0 */
    public static final String f39202u0 = "com.huawei.phoneservice.faq.ui.c";

    /* renamed from: e0 */
    public boolean f39203e0;

    /* renamed from: f0 */
    public FaqAutoNextLineLinearLayout f39204f0;

    /* renamed from: g0 */
    public FaqAutoNextLineLinearLayout f39205g0;

    /* renamed from: h0 */
    public ScrollView f39206h0;

    /* renamed from: i0 */
    public FaqNoticeView f39207i0;

    /* renamed from: j0 */
    public TextView f39208j0;

    /* renamed from: k0 */
    public TextView f39209k0;

    /* renamed from: l0 */
    public TextView f39210l0;

    /* renamed from: m0 */
    public RelativeLayout f39211m0;

    /* renamed from: n0 */
    public g f39212n0;

    /* renamed from: o0 */
    public int f39213o0 = 10;

    /* renamed from: p0 */
    public int f39214p0 = 5;

    /* renamed from: q0 */
    public boolean f39215q0 = false;

    /* renamed from: r0 */
    public boolean f39216r0 = false;

    /* renamed from: s0 */
    public boolean f39217s0;

    /* renamed from: t0 */
    public AlertDialog f39218t0;

    /* renamed from: com.huawei.phoneservice.faq.ui.c$a */
    public class a extends FaqCallback<C8350j> {

        /* renamed from: com.huawei.phoneservice.faq.ui.c$a$a */
        public class C14486a extends TypeToken<List<C8349i>> {
            public C14486a() {
            }
        }

        public a(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8350j c8350j) throws Throwable {
            if (ViewOnClickListenerC8408c.this.f39205g0 != null) {
                ViewOnClickListenerC8408c.this.f39205g0.removeAllViews();
            }
            List<String> listM52380b = C8414d.m52380b(ViewOnClickListenerC8408c.this.m4400f());
            if (listM52380b != null && listM52380b.size() > 0 && ModuleConfigUtils.searchHistoryEnabled()) {
                ViewOnClickListenerC8408c.this.f39215q0 = true;
            }
            if (ModuleConfigUtils.searchHotEnabled()) {
                ViewOnClickListenerC8408c.this.f39216r0 = true;
            }
            Gson gson = new Gson();
            if (th2 == null) {
                ViewOnClickListenerC8408c.this.m52351I1(c8350j, gson);
                return;
            }
            List list = (List) gson.fromJson(ViewOnClickListenerC8408c.this.m51687E1().getSharedPreferences("HOTSEARCH", 0).getString("HOTSEARCH_LIST", ""), new C14486a().getType());
            if (list != null) {
                ViewOnClickListenerC8408c.this.m52358Z1();
                ViewOnClickListenerC8408c.this.m52343N1(list);
                return;
            }
            if (ViewOnClickListenerC8408c.this.f39215q0) {
                ViewOnClickListenerC8408c.this.m52358Z1();
                ViewOnClickListenerC8408c.this.f39207i0.setVisibility(8);
            } else {
                ViewOnClickListenerC8408c.this.f39207i0.m52471k(th2);
            }
            ViewOnClickListenerC8408c.this.m52356U1(false);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.c$b */
    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ String f39221a;

        public b(String str) {
            this.f39221a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FaqTrack.event("+SDK+Search", "Click on hot search", String.format(Locale.getDefault(), "%1$s", this.f39221a));
            ViewOnClickListenerC8408c.this.f39212n0.mo52076a(this.f39221a, "hotSearch");
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.c$c */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws Throwable {
            ViewOnClickListenerC8408c.this.m52349W1();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.c$d */
    public class d implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ String f39224a;

        public d(String str) {
            this.f39224a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FaqTrack.event("+SDK+Search", "Click on history search", String.format(Locale.getDefault(), "%1$s", this.f39224a));
            ViewOnClickListenerC8408c.this.f39212n0.mo52076a(this.f39224a, "historyClick");
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.c$e */
    public static class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.c$f */
    public static class f extends TypeToken<List<String>> {
        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.c$g */
    public interface g {
        /* renamed from: a */
        void mo52076a(String str, String str2);
    }

    /* renamed from: N1 */
    public void m52343N1(List<C8349i> list) throws Throwable {
        if (m51687E1() == null || m51687E1().isFinishing()) {
            FaqLogger.print(f39202u0, "hotResultSuccess activity is null or is finishing...");
            return;
        }
        this.f39207i0.setVisibility(8);
        this.f39203e0 = true;
        if (list == null || list.size() == 0) {
            FaqLogger.print(f39202u0, "hotResultSuccess topSearchList is null or size is 0...");
            m52356U1(false);
            return;
        }
        m52356U1(this.f39216r0);
        for (int i10 = 0; i10 < list.size() && i10 <= this.f39214p0 - 1; i10++) {
            String strM52010a = list.get(i10).m52010a() == null ? "" : list.get(i10).m52010a();
            TextView textView = (TextView) LayoutInflater.from(m51687E1()).inflate(R$layout.faq_hot_sub_tab_text_layout, (ViewGroup) this.f39205g0, false);
            textView.setTextDirection(6);
            textView.setText(C8411a.m52364c(strM52010a, this.f39213o0));
            textView.setOnClickListener(new b(strM52010a));
            this.f39205g0.addView(textView);
        }
    }

    /* renamed from: W1 */
    public void m52349W1() throws Throwable {
        List list = (List) FaqSharePrefUtil.getModuleListBeanList(m51687E1(), "SEARCH_FILE_NAME", C8414d.m52379a(), new f(null).getType());
        if (FaqCommonUtils.isEmpty(list)) {
            m52355Q1(false);
            return;
        }
        list.clear();
        FaqSharePrefUtil.save(m51687E1(), "SEARCH_FILE_NAME", C8414d.m52379a(), new Gson().toJson(list));
        m52358Z1();
    }

    @Override // com.huawei.phoneservice.faq.AbstractC8274a
    /* renamed from: C1 */
    public int mo51685C1() {
        return R$layout.faq_search_history_layout;
    }

    @Override // com.huawei.phoneservice.faq.AbstractC8274a
    /* renamed from: D1 */
    public void mo51686D1(View view) {
        this.f39204f0 = (FaqAutoNextLineLinearLayout) view.findViewById(R$id.ll_search_history);
        this.f39205g0 = (FaqAutoNextLineLinearLayout) view.findViewById(R$id.ll_hot_search);
        this.f39206h0 = (ScrollView) view.findViewById(R$id.sv_search_history);
        TextView textView = (TextView) view.findViewById(R$id.iv_search_delete);
        this.f39208j0 = textView;
        textView.getPaint().setFakeBoldText(true);
        this.f39211m0 = (RelativeLayout) view.findViewById(R$id.rl_search_delete);
        this.f39210l0 = (TextView) view.findViewById(R$id.search_history_text);
        this.f39209k0 = (TextView) view.findViewById(R$id.hot_search_text);
        this.f39210l0.getPaint().setFakeBoldText(true);
        this.f39209k0.getPaint().setFakeBoldText(true);
        this.f39206h0.setOverScrollMode(2);
        FaqNoticeView faqNoticeView = (FaqNoticeView) view.findViewById(R$id.notice_view);
        this.f39207i0 = faqNoticeView;
        faqNoticeView.setBackground(null);
    }

    @Override // com.huawei.phoneservice.faq.AbstractC8274a
    /* renamed from: F1 */
    public void mo51688F1() throws Throwable {
        String str;
        if (!FaqCommonUtils.isConnectionAvailable(m4426p())) {
            this.f39207i0.m52468g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            this.f39206h0.setVisibility(8);
            return;
        }
        this.f39206h0.setVisibility(0);
        this.f39207i0.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
        if (FaqConstants.CHANNEL_HICARE.equals(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL))) {
            str = FaqConstants.APP_HICARE;
        } else {
            str = "App_" + SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL);
        }
        Activity activityM51687E1 = m51687E1();
        FaqLogger.m51840e(f39202u0, "activity>>>>>>" + activityM51687E1);
        m52353M1(str, SdkFaqManager.getSdk().getSdk("country"), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LANGUAGE));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: G0 */
    public void mo4348G0() throws Throwable {
        super.mo4348G0();
        if (ModuleConfigUtils.searchHistoryEnabled()) {
            this.f39215q0 = true;
            m52358Z1();
        }
    }

    @Override // com.huawei.phoneservice.faq.AbstractC8274a
    /* renamed from: G1 */
    public void mo51689G1() {
        this.f39208j0.setOnClickListener(this);
        this.f39207i0.setOnClickListener(this);
    }

    /* renamed from: I1 */
    public final void m52351I1(C8350j c8350j, Gson gson) throws Throwable {
        if (c8350j != null) {
            SharedPreferences.Editor editorEdit = m51687E1().getSharedPreferences("HOTSEARCH", 0).edit();
            editorEdit.putString("HOTSEARCH_LIST", gson.toJson(c8350j.m52011a()));
            editorEdit.apply();
            m52358Z1();
            m52343N1(c8350j.m52011a());
            return;
        }
        if (this.f39215q0) {
            m52358Z1();
            this.f39207i0.setVisibility(8);
        } else {
            this.f39207i0.m52471k(null);
        }
        m52356U1(false);
    }

    /* renamed from: J1 */
    public void m52352J1(g gVar) {
        this.f39212n0 = gVar;
    }

    /* renamed from: M1 */
    public final void m52353M1(String str, String str2, String str3) {
        SdkFaqCommonManager.INSTANCE.searchHotWord(m51687E1(), str, str2, str3, new a(C8350j.class, m51687E1()));
    }

    /* renamed from: O1 */
    public void m52354O1(boolean z10) {
        this.f39217s0 = z10;
    }

    /* renamed from: Q1 */
    public void m52355Q1(boolean z10) {
        RelativeLayout relativeLayout;
        int i10;
        this.f39215q0 = z10;
        if (z10) {
            relativeLayout = this.f39211m0;
            i10 = 0;
        } else {
            relativeLayout = this.f39211m0;
            i10 = 8;
        }
        relativeLayout.setVisibility(i10);
        this.f39204f0.setVisibility(i10);
    }

    /* renamed from: U1 */
    public void m52356U1(boolean z10) {
        TextView textView;
        int i10;
        if (z10) {
            textView = this.f39209k0;
            i10 = 0;
        } else {
            textView = this.f39209k0;
            i10 = 8;
        }
        textView.setVisibility(i10);
        this.f39205g0.setVisibility(i10);
    }

    /* renamed from: Y1 */
    public boolean m52357Y1() {
        return this.f39217s0;
    }

    /* renamed from: Z1 */
    public void m52358Z1() throws Throwable {
        FaqAutoNextLineLinearLayout faqAutoNextLineLinearLayout = this.f39204f0;
        if (faqAutoNextLineLinearLayout == null) {
            FaqLogger.print(f39202u0, "refreshDeleteHistory searchHistoryLl is null...");
            return;
        }
        faqAutoNextLineLinearLayout.removeAllViews();
        List<String> listM52380b = C8414d.m52380b(m4400f());
        if (listM52380b == null || listM52380b.size() == 0) {
            FaqLogger.print(f39202u0, "refreshDeleteHistory history is null or size is 0...");
            m52355Q1(false);
            return;
        }
        m52355Q1(this.f39215q0);
        for (int i10 = 0; i10 < listM52380b.size(); i10++) {
            String str = listM52380b.get(i10);
            if (str != null) {
                TextView textView = (TextView) LayoutInflater.from(m51687E1()).inflate(R$layout.faq_history_sub_tab_text_layout, (ViewGroup) this.f39204f0, false);
                textView.setTextDirection(6);
                textView.setText(C8411a.m52364c(str, this.f39213o0));
                textView.setOnClickListener(new d(str));
                this.f39204f0.addView(textView);
            }
        }
    }

    /* renamed from: a2 */
    public void m52359a2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(m51687E1());
        View viewInflate = LayoutInflater.from(m4400f()).inflate(R$layout.faq_sdk_common_dialog_message, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R$id.dialog_common_msg_txt)).setText(m4354K().getString(R$string.faq_sdk_search_clear));
        builder.setView(viewInflate).setCancelable(false).setPositiveButton(m4354K().getString(R$string.faq_sdk_fill_dialog_ok), new c()).setNegativeButton(m4354K().getString(R$string.faq_sdk_common_cancel), new e(null));
        AlertDialog alertDialogCreate = builder.create();
        this.f39218t0 = alertDialogCreate;
        FaqDialogUtil.showDialog(alertDialogCreate);
        this.f39218t0.getButton(-1).setTextColor(-65536);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (NoDoubleClickUtil.isDoubleClick(view)) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.iv_search_delete) {
            m52359a2();
        } else if (id2 == R$id.notice_view) {
            mo51688F1();
        }
    }

    @Override // com.huawei.phoneservice.faq.AbstractC8274a, androidx.fragment.app.Fragment
    /* renamed from: q0 */
    public void mo4430q0() {
        super.mo4430q0();
        AlertDialog alertDialog = this.f39218t0;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }
}
