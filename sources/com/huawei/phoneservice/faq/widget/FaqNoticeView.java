package com.huawei.phoneservice.faq.widget;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.R$color;
import com.huawei.phoneservice.faq.R$dimen;
import com.huawei.phoneservice.faq.R$drawable;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.R$styleable;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.utils.C8417g;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class FaqNoticeView extends FrameLayout implements View.OnClickListener {

    /* renamed from: F */
    public static Map<CharSequence, Integer> f39325F = new HashMap();

    /* renamed from: A */
    public int f39326A;

    /* renamed from: B */
    public int f39327B;

    /* renamed from: C */
    public boolean f39328C;

    /* renamed from: D */
    public int f39329D;

    /* renamed from: E */
    public boolean f39330E;

    /* renamed from: a */
    public TextView f39331a;

    /* renamed from: b */
    public ImageView f39332b;

    /* renamed from: c */
    public ProgressBar f39333c;

    /* renamed from: d */
    public EnumC8429c f39334d;

    /* renamed from: e */
    public Button f39335e;

    /* renamed from: f */
    public View f39336f;

    /* renamed from: g */
    public View f39337g;

    /* renamed from: h */
    public final Map<FaqConstants.FaqErrorCode, Integer> f39338h;

    /* renamed from: i */
    public FaqConstants.FaqErrorCode f39339i;

    /* renamed from: j */
    public int f39340j;

    /* renamed from: k */
    public int f39341k;

    /* renamed from: l */
    public int f39342l;

    /* renamed from: m */
    public String f39343m;

    /* renamed from: n */
    public float f39344n;

    /* renamed from: o */
    public int f39345o;

    /* renamed from: p */
    public int f39346p;

    /* renamed from: q */
    public final Map<FaqConstants.FaqErrorCode, Integer> f39347q;

    /* renamed from: r */
    public float f39348r;

    /* renamed from: s */
    public final Map<FaqConstants.FaqErrorCode, Integer> f39349s;

    /* renamed from: t */
    public final Map<FaqConstants.FaqErrorCode, Integer> f39350t;

    /* renamed from: u */
    public int f39351u;

    /* renamed from: v */
    public boolean f39352v;

    /* renamed from: w */
    public InterfaceC8428b f39353w;

    /* renamed from: x */
    public int[] f39354x;

    /* renamed from: y */
    public Runnable f39355y;

    /* renamed from: z */
    public int f39356z;

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqNoticeView$a */
    public class RunnableC8427a implements Runnable {
        public RunnableC8427a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            FaqNoticeView faqNoticeView = FaqNoticeView.this;
            faqNoticeView.f39352v = faqNoticeView.m52477v();
            FaqLogger.m51836d("NoticeView", "refreshAction contentSizeEnough:" + FaqNoticeView.this.f39352v);
            FaqNoticeView faqNoticeView2 = FaqNoticeView.this;
            faqNoticeView2.setContentMarginTop(faqNoticeView2.f39334d == EnumC8429c.ERROR ? ((Integer) faqNoticeView2.f39347q.get(FaqNoticeView.this.f39339i)).intValue() : faqNoticeView2.f39351u);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqNoticeView$b */
    public interface InterfaceC8428b {
        /* renamed from: a */
        void mo52087a();
    }

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqNoticeView$c */
    public enum EnumC8429c {
        ERROR,
        PROGRESS
    }

    public FaqNoticeView(Context context) throws Throwable {
        super(context);
        this.f39338h = new HashMap();
        this.f39341k = 0;
        this.f39342l = 0;
        this.f39345o = -1;
        this.f39347q = new HashMap();
        this.f39349s = new HashMap();
        this.f39350t = new HashMap();
        this.f39351u = 0;
        this.f39352v = true;
        this.f39354x = new int[2];
        this.f39355y = new RunnableC8427a();
        this.f39330E = false;
        m52467f(context, null);
    }

    /* renamed from: a */
    public static int m52454a(TextView textView) {
        if (textView.getMeasuredWidth() == 0) {
            return 0;
        }
        String string = textView.getText().toString();
        if (f39325F.containsKey(string)) {
            return f39325F.get(string).intValue();
        }
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f10 = (fontMetrics.bottom - fontMetrics.top) - (fontMetrics.descent - fontMetrics.ascent);
        int i10 = (int) f10;
        if (f10 > i10) {
            i10++;
        }
        int i11 = i10;
        int width = textView.getWidth();
        Layout.Alignment alignment = Layout.Alignment.ALIGN_CENTER;
        StaticLayout staticLayout = new StaticLayout(string, paint, width, alignment, 1.0f, 0.0f, false);
        int[] iArr = new int[2];
        int maxLines = textView.getMaxLines();
        if (staticLayout.getLineCount() <= maxLines) {
            iArr[0] = -1;
            int height = staticLayout.getHeight();
            iArr[1] = height;
            f39325F.put(string, Integer.valueOf(height + i11));
            return iArr[1] + i11;
        }
        int lineStart = staticLayout.getLineStart(maxLines) - 1;
        iArr[0] = lineStart;
        int height2 = new StaticLayout(string.substring(0, lineStart), paint, textView.getWidth(), alignment, 1.0f, 0.0f, false).getHeight();
        iArr[1] = height2;
        f39325F.put(string, Integer.valueOf(height2 + i11));
        return iArr[1] + i11;
    }

    /* renamed from: c */
    public static Integer m52455c(Context context) throws Throwable {
        int identifier = Resources.getSystem().getIdentifier("navigationbar_emui_light", RemoteMessageConst.Notification.COLOR, "androidhwext");
        FaqLogger.m51836d("getColorPrimary", "navigationbar_emui_light : " + identifier);
        Integer num = null;
        if (identifier != 0) {
            int color = context.getResources().getColor(identifier);
            Integer numValueOf = Integer.valueOf(color);
            String str = String.format("#%08X", Integer.valueOf(color));
            int color2 = Color.parseColor("#00000000");
            FaqLogger.m51836d("getColorPrimary", "navigationbarEmuiLight : " + str);
            if (color2 != color) {
                num = numValueOf;
            }
        }
        if (num != null) {
            return num;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        FaqLogger.m51836d("getColorPrimary", "colorPrimary : " + typedValue.data + "  strColor: " + String.format("#%06X", Integer.valueOf(typedValue.data & 16777215)));
        typedValue.data = context.getResources().getColor(Color.parseColor("#f0f0f0") == typedValue.data ? R$color.faq_sdk_notice_view_pad_background : R$color.faq_sdk_notice_view_background);
        return Integer.valueOf(typedValue.data);
    }

    private int getAutoFitContentSize() throws Throwable {
        int iIntValue = this.f39334d == EnumC8429c.ERROR ? this.f39338h.get(this.f39339i).intValue() : this.f39333c.getHeight();
        int iM52454a = m52454a(this.f39331a);
        Resources resources = getResources();
        int i10 = R$dimen.faq_sdk_notice_view_text_margin_top;
        float dimensionPixelSize = iM52454a + resources.getDimensionPixelSize(i10);
        FaqLogger.m51836d("NoticeView", "getAutoFitContentSize:   contentImageOffset:" + iIntValue + "   measureTextViewHeight(noticeTextView):" + m52454a(this.f39331a) + "   DimensionPixelSize" + getResources().getDimensionPixelSize(i10) + "   textView Height :" + this.f39331a.getMeasuredHeight());
        return (int) (iIntValue + dimensionPixelSize + 0.5d);
    }

    /* renamed from: p */
    public static void m52459p(Context context) throws Throwable {
        try {
            Intent intent = new Intent();
            if (FaqCommonUtils.isAboveEmui60()) {
                intent.setAction("android.settings.WIRELESS_SETTINGS");
                intent.putExtra("use_emui_ui", true);
            } else {
                intent.setAction("android.settings.SETTINGS");
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.settings.SETTINGS"));
            FaqLogger.m51840e("NoticeView", "gotoNetworkSettingView ActivityNotFoundException...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentMarginTop(int i10) throws Throwable {
        int i11;
        FaqLogger.m51836d("NoticeView", "setContentMarginTop param contentMarginTop:" + i10);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f39336f.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (!this.f39352v) {
            i10 = getMinContentMarginTop();
            FaqLogger.m51836d("NoticeView", "setContentMarginTop getMinContentMarginTop:" + i10);
        }
        m52465d();
        m52472n();
        if (getResources().getConfiguration().orientation == 2) {
            if (!this.f39352v) {
                this.f39327B = Math.min(i10, this.f39327B);
            }
            i11 = this.f39327B;
            if (i11 <= 0) {
                i11 = 0;
            }
        } else {
            i11 = this.f39329D;
        }
        layoutParams.topMargin = i11;
        if (this.f39352v || this.f39326A >= this.f39356z || this.f39337g.getVisibility() != 0) {
            this.f39331a.setVisibility(0);
        } else {
            this.f39331a.setVisibility(4);
        }
        FaqLogger.m51836d("NoticeView", "setContentMarginTop topMargin:" + layoutParams.topMargin);
        this.f39336f.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    public final EnumC8429c m52464b(int i10) {
        return i10 == 0 ? EnumC8429c.ERROR : EnumC8429c.PROGRESS;
    }

    /* renamed from: d */
    public final void m52465d() throws Throwable {
        Point point = new Point();
        ((WindowManager) getContext().getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealSize(point);
        int iMin = Math.min(point.x, point.y);
        FaqLogger.m51836d("NoticeView", "calculateCenterMarginTop location 0:" + this.f39354x[0] + "   location 1:" + this.f39354x[1]);
        int autoFitContentSize = getAutoFitContentSize();
        int height = this.f39328C ? (getHeight() - autoFitContentSize) / 2 : ((iMin / 2) - this.f39354x[1]) - (autoFitContentSize / 2);
        FaqLogger.m51836d("NoticeView", "calculateCenterMarginTop getHeight:" + getHeight() + "   getAutoFitContentSize:" + autoFitContentSize + "   newCenterMarginTop:" + height);
        if (this.f39327B != height) {
            FaqLogger.m51836d("NoticeView", "calculateCenterMarginTop centerMarginTop != newCenterMarginTop");
            this.f39327B = height;
        }
    }

    /* renamed from: e */
    public final void m52466e(int i10, Drawable drawable, int i11, int i12) throws Throwable {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f39331a.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams.topMargin = i10;
        this.f39331a.setLayoutParams(layoutParams);
        if (drawable != null) {
            this.f39332b.setImageDrawable(drawable);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f39332b.getLayoutParams();
        if (i11 <= 0) {
            i11 = -2;
        }
        if (layoutParams2 == null) {
            layoutParams2 = new LinearLayout.LayoutParams(i11, i11);
        } else {
            layoutParams2.height = i11;
            layoutParams2.width = i11;
        }
        this.f39332b.setLayoutParams(layoutParams2);
        setContentMarginTop(i12);
    }

    /* renamed from: f */
    public final void m52467f(Context context, AttributeSet attributeSet) throws Throwable {
        Map<FaqConstants.FaqErrorCode, Integer> map = this.f39347q;
        FaqConstants.FaqErrorCode faqErrorCode = FaqConstants.FaqErrorCode.DEFAULT;
        map.put(faqErrorCode, Integer.valueOf(getResources().getDimensionPixelOffset(R$dimen.faq_sdk_ui_28_dip)));
        Map<FaqConstants.FaqErrorCode, Integer> map2 = this.f39347q;
        FaqConstants.FaqErrorCode faqErrorCode2 = FaqConstants.FaqErrorCode.INTERNET_ERROR;
        map2.put(faqErrorCode2, Integer.valueOf(getResources().getDimensionPixelOffset(R$dimen.faq_sdk_ui_90_dp)));
        Map<FaqConstants.FaqErrorCode, Integer> map3 = this.f39347q;
        FaqConstants.FaqErrorCode faqErrorCode3 = FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR;
        Resources resources = getResources();
        int i10 = R$dimen.faq_sdk_ui_108_dp;
        map3.put(faqErrorCode3, Integer.valueOf(resources.getDimensionPixelOffset(i10)));
        Map<FaqConstants.FaqErrorCode, Integer> map4 = this.f39347q;
        FaqConstants.FaqErrorCode faqErrorCode4 = FaqConstants.FaqErrorCode.LOAD_DATA_ERROR;
        map4.put(faqErrorCode4, Integer.valueOf(getResources().getDimensionPixelOffset(i10)));
        Map<FaqConstants.FaqErrorCode, Integer> map5 = this.f39347q;
        FaqConstants.FaqErrorCode faqErrorCode5 = FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR;
        map5.put(faqErrorCode5, Integer.valueOf(getResources().getDimensionPixelOffset(i10)));
        Map<FaqConstants.FaqErrorCode, Integer> map6 = this.f39338h;
        Resources resources2 = getResources();
        int i11 = R$dimen.faq_sdk_loading_error_icon_size;
        map6.put(faqErrorCode, Integer.valueOf(resources2.getDimensionPixelOffset(i11)));
        this.f39338h.put(faqErrorCode2, Integer.valueOf(getResources().getDimensionPixelOffset(i11)));
        this.f39338h.put(faqErrorCode3, Integer.valueOf(getResources().getDimensionPixelOffset(i11)));
        this.f39338h.put(faqErrorCode4, Integer.valueOf(getResources().getDimensionPixelOffset(i11)));
        this.f39338h.put(faqErrorCode5, Integer.valueOf(getResources().getDimensionPixelOffset(R$dimen.faq_sdk_loading_empty_icon_size)));
        Map<FaqConstants.FaqErrorCode, Integer> map7 = this.f39349s;
        int i12 = R$drawable.faq_sdk_ic_no_pic_disable;
        map7.put(faqErrorCode, Integer.valueOf(i12));
        Map<FaqConstants.FaqErrorCode, Integer> map8 = this.f39349s;
        int i13 = R$drawable.faq_sdk_ic_no_wifi_disable;
        map8.put(faqErrorCode2, Integer.valueOf(i13));
        this.f39349s.put(faqErrorCode3, Integer.valueOf(i13));
        this.f39349s.put(faqErrorCode4, Integer.valueOf(i12));
        this.f39349s.put(faqErrorCode5, Integer.valueOf(R$drawable.faq_sdk_ic_no_search_result));
        this.f39350t.put(faqErrorCode2, Integer.valueOf(R$string.faq_sdk_common_network_setting));
        this.f39350t.put(faqErrorCode3, Integer.valueOf(R$string.faq_sdk_common_server_disconnected));
        this.f39350t.put(faqErrorCode4, Integer.valueOf(R$string.faq_sdk_data_error_toast));
        this.f39350t.put(faqErrorCode5, Integer.valueOf(R$string.faq_sdk_service_help_prepare));
        this.f39356z = getResources().getDimensionPixelOffset(R$dimen.faq_sdk_ui_16_dip);
        this.f39342l = FaqCommonUtils.getScreenHeight(context) / 3;
        this.f39346p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        LayoutInflater.from(context).inflate(R$layout.faq_sdk_widget_notice_view, this);
        this.f39332b = (ImageView) findViewById(R$id.notice_image_view);
        this.f39331a = (TextView) findViewById(R$id.notice_text_view);
        this.f39333c = (ProgressBar) findViewById(R$id.notice_progress_view);
        this.f39336f = findViewById(R$id.notice_view_container);
        this.f39337g = findViewById(R$id.button_container);
        Button button = (Button) findViewById(R$id.error_button);
        this.f39335e = button;
        button.setOnClickListener(this);
        m52476u(context);
        setBackgroundColor(m52455c(context).intValue());
        m52474q(context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m52468g(com.huawei.phoneservice.faq.base.constants.FaqConstants.FaqErrorCode r7) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.widget.FaqNoticeView.m52468g(com.huawei.phoneservice.faq.base.constants.FaqConstants$FaqErrorCode):void");
    }

    public int getColorPrimary() throws Throwable {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        FaqLogger.m51836d("getColorPrimary", "colorPrimary : " + typedValue.data + "  strColor: " + String.format("#%06X", Integer.valueOf(typedValue.data & 16777215)));
        typedValue.data = getResources().getColor(Color.parseColor("#f0f0f0") == typedValue.data ? R$color.faq_sdk_notice_view_pad_background : R$color.faq_sdk_notice_view_background);
        return typedValue.data;
    }

    public FaqConstants.FaqErrorCode getFaqErrorCode() {
        return this.f39339i;
    }

    public int getMinContentMarginTop() throws Throwable {
        Resources resources = getResources();
        int i10 = R$dimen.faq_sdk_ui_16_dip;
        float dimension = resources.getDimension(i10);
        if (this.f39337g.getVisibility() == 0) {
            dimension = this.f39341k + (getResources().getDimension(i10) * 2.0f);
        }
        EnumC8429c enumC8429c = this.f39334d;
        EnumC8429c enumC8429c2 = EnumC8429c.ERROR;
        float fIntValue = enumC8429c == enumC8429c2 ? this.f39338h.get(this.f39339i).intValue() : this.f39333c.getHeight();
        this.f39326A = (int) ((((getMeasuredHeight() - dimension) - m52454a(this.f39331a)) - getResources().getDimensionPixelSize(R$dimen.faq_sdk_notice_view_text_margin_top)) - fIntValue);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getMinContentMarginTop noticeType：");
        sb2.append(this.f39334d == enumC8429c2 ? "ERROR" : "PROGRESS");
        FaqLogger.m51836d("NoticeView", sb2.toString());
        FaqLogger.m51836d("NoticeView", "getMinContentMarginTop contentMarginTop：" + Math.max(this.f39356z, this.f39326A));
        FaqLogger.m51836d("NoticeView", "getMinContentMarginTop contentImageOffset：" + fIntValue);
        FaqLogger.m51836d("NoticeView", "getMinContentMarginTop getMeasuredHeight：" + getMeasuredHeight());
        FaqLogger.m51836d("NoticeView", "getMinContentMarginTop buttonOffset：" + dimension + "    measureTextViewHeight:" + m52454a(this.f39331a));
        return Math.max(this.f39356z, this.f39326A);
    }

    public TextView getNoticeTextView() {
        return this.f39331a;
    }

    /* renamed from: h */
    public void m52469h(FaqConstants.FaqErrorCode faqErrorCode, int i10) {
        this.f39349s.put(faqErrorCode, Integer.valueOf(i10));
        m52470i(this.f39334d);
    }

    /* renamed from: i */
    public void m52470i(EnumC8429c enumC8429c) {
        FaqLogger.m51836d("NoticeView", "showNoticeType type:" + enumC8429c);
        this.f39334d = enumC8429c;
        if (enumC8429c == EnumC8429c.ERROR) {
            m52468g(this.f39339i);
            return;
        }
        this.f39332b.setVisibility(8);
        this.f39333c.setVisibility(0);
        this.f39337g.setVisibility(4);
        this.f39331a.setText(this.f39343m);
        this.f39352v = m52477v();
        setContentMarginTop(this.f39351u);
        setVisibility(0);
    }

    /* renamed from: k */
    public void m52471k(Throwable th2) {
        FaqLogger.m51836d("NoticeView", "dealWithHttpError error:" + th2);
        if (th2 != null) {
            m52468g(th2 instanceof FaqWebServiceException ? ((FaqWebServiceException) th2).errorCode != 500002 ? FaqConstants.FaqErrorCode.LOAD_DATA_ERROR : FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR : !FaqCommonUtils.isConnectionAvailable(getContext()) ? FaqConstants.FaqErrorCode.INTERNET_ERROR : FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR);
        }
    }

    /* renamed from: n */
    public final void m52472n() throws Throwable {
        Point point = new Point();
        ((WindowManager) getContext().getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealSize(point);
        int iMax = Math.max(point.x, point.y);
        FaqLogger.m51836d("NoticeView", "calculatePortMarginTop location 0:" + this.f39354x[0] + "   location 1:" + this.f39354x[1]);
        int height = ((int) (((double) iMax) * 0.3d)) - this.f39354x[1];
        int autoFitContentSize = getAutoFitContentSize();
        if (this.f39328C || height < 0) {
            height = (getHeight() - autoFitContentSize) / 2;
        }
        FaqLogger.m51836d("NoticeView", "calculatePortMarginTop getHeight:" + getHeight() + "   getAutoFitContentSize:" + autoFitContentSize + "   newCenterMarginTop:" + height);
        if (this.f39329D != height) {
            FaqLogger.m51836d("NoticeView", "calculatePortMarginTop portMarginTop30 != newPortMarginTop");
            this.f39329D = height;
        }
    }

    /* renamed from: o */
    public void m52473o(int i10) {
        if (i10 == 0) {
            this.f39331a.setVisibility(4);
        } else {
            this.f39331a.setVisibility(0);
            this.f39331a.setText(i10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (NoDoubleClickUtil.isDoubleClick(view)) {
            return;
        }
        FaqConstants.FaqErrorCode faqErrorCode = this.f39339i;
        if (faqErrorCode == FaqConstants.FaqErrorCode.INTERNET_ERROR) {
            m52459p(getContext());
        } else if (faqErrorCode == FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR || faqErrorCode == FaqConstants.FaqErrorCode.LOAD_DATA_ERROR) {
            this.f39353w.mo52087a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f39355y);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws Throwable {
        FaqLogger.m51836d("NoticeView", "onLayout changed:" + z10);
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            removeCallbacks(this.f39355y);
            boolean zM52477v = m52477v();
            FaqLogger.m51836d("NoticeView", "onLayout sizeEnough:" + zM52477v + "   contentSizeEnough:" + this.f39352v);
            if (zM52477v != this.f39352v) {
                this.f39352v = zM52477v;
            }
            setContentMarginTop(this.f39334d == EnumC8429c.ERROR ? this.f39347q.get(this.f39339i).intValue() : this.f39351u);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) throws Throwable {
        FaqLogger.m51836d("NoticeView", "onMeasure");
        super.onMeasure(i10, i11);
        if (this.f39333c.getMeasuredHeight() > 0 && this.f39340j == 0) {
            this.f39340j = this.f39333c.getMeasuredWidth();
            int measuredHeight = this.f39333c.getMeasuredHeight();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f39333c.getLayoutParams();
            int iMax = Math.max(measuredHeight, this.f39340j);
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(iMax, iMax);
            } else {
                layoutParams.height = iMax;
                layoutParams.width = iMax;
            }
            FaqLogger.m51836d("NoticeView", "onMeasure noticeProgressBar height:" + layoutParams.height + "   width:" + layoutParams.width);
            this.f39333c.setLayoutParams(layoutParams);
        }
        if (this.f39336f.getMeasuredHeight() <= 0 || this.f39341k != 0) {
            return;
        }
        this.f39341k = this.f39337g.getMeasuredHeight();
        FaqLogger.m51836d("NoticeView", "onMeasure mBtnHeight:" + this.f39341k);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) throws Throwable {
        FaqLogger.m51836d("NoticeView", "onSizeChanged");
        super.onSizeChanged(i10, i11, i12, i13);
        getLocationOnScreen(this.f39354x);
        FaqLogger.m51836d("NoticeView", "onSizeChanged location 0:" + this.f39354x[0] + "   location 1:" + this.f39354x[1]);
        boolean z10 = !(i13 == 0 || i11 == 0 || i11 - i13 <= this.f39342l) || i13 == 0 || i11 == 0 || i13 - i11 <= this.f39342l;
        FaqLogger.m51836d("NoticeView", "onSizeChanged sizeEnough:" + z10 + "   contentSizeEnough:" + this.f39352v);
        if (z10 != this.f39352v) {
            removeCallbacks(this.f39355y);
            if (isAttachedToWindow()) {
                post(this.f39355y);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L4c
            r1 = 1
            r2 = -1
            if (r0 == r1) goto L49
            r1 = 2
            r3 = 3
            if (r0 == r1) goto L13
            if (r0 == r3) goto L49
            goto L5f
        L13:
            int r0 = r4.f39345o
            if (r0 != r2) goto L18
            goto L5f
        L18:
            int r0 = r5.findPointerIndex(r0)
            if (r0 != r2) goto L1f
            goto L5f
        L1f:
            float r1 = r5.getY(r0)
            int r1 = (int) r1
            float r0 = r5.getX(r0)
            int r0 = (int) r0
            float r2 = r4.f39344n
            int r2 = (int) r2
            int r1 = r1 - r2
            int r1 = java.lang.Math.abs(r1)
            float r2 = r4.f39348r
            int r2 = (int) r2
            int r0 = r0 - r2
            int r0 = java.lang.Math.abs(r0)
            int r2 = r4.f39346p
            if (r1 > r2) goto L45
            if (r0 > r2) goto L45
            com.huawei.phoneservice.faq.widget.FaqNoticeView$c r0 = r4.f39334d
            com.huawei.phoneservice.faq.widget.FaqNoticeView$c r1 = com.huawei.phoneservice.faq.widget.FaqNoticeView.EnumC8429c.PROGRESS
            if (r0 != r1) goto L5f
        L45:
            r5.setAction(r3)
            goto L5f
        L49:
            r4.f39345o = r2
            goto L5f
        L4c:
            float r0 = r5.getY()
            r4.f39344n = r0
            float r0 = r5.getX()
            r4.f39348r = r0
            r0 = 0
            int r0 = r5.getPointerId(r0)
            r4.f39345o = r0
        L5f:
            boolean r4 = super.onTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.widget.FaqNoticeView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) throws Throwable {
        FaqLogger.m51836d("NoticeView", "onWindowFocusChanged");
        super.onWindowFocusChanged(z10);
        getLocationOnScreen(this.f39354x);
        FaqLogger.m51836d("NoticeView", "onWindowFocusChanged location 0:" + this.f39354x[0] + "   location 1:" + this.f39354x[1]);
        setContentMarginTop(this.f39334d == EnumC8429c.ERROR ? this.f39347q.get(this.f39339i).intValue() : this.f39351u);
    }

    /* renamed from: q */
    public final void m52474q(Context context, AttributeSet attributeSet) throws Throwable {
        Drawable drawable;
        int dimensionPixelSize;
        int color;
        Drawable drawable2;
        String string;
        int i10;
        Resources resources = context.getResources();
        int i11 = R$dimen.faq_sdk_notice_view_text_size;
        int dimension = (int) resources.getDimension(i11);
        Resources resources2 = context.getResources();
        int i12 = R$color.faq_sdk_notice_view_default_text_color;
        int color2 = resources2.getColor(i12);
        Resources resources3 = context.getResources();
        int i13 = R$dimen.faq_sdk_notice_view_text_margin_top;
        int dimensionPixelOffset = resources3.getDimensionPixelOffset(i13);
        int i14 = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FaqNoticeView);
            drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FaqNoticeView_faqsdknoticeViewBackground);
            this.f39334d = m52464b(typedArrayObtainStyledAttributes.getInt(R$styleable.FaqNoticeView_faqsdkNoticeViewType, 0));
            string = typedArrayObtainStyledAttributes.getString(R$styleable.FaqNoticeView_faqsdknoticeLoadingText);
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FaqNoticeView_faqsdknoticeTextSize, (int) context.getResources().getDimension(i11));
            color = typedArrayObtainStyledAttributes.getColor(R$styleable.FaqNoticeView_faqsdknoticeTextColor, context.getResources().getColor(i12));
            dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FaqNoticeView_faqsdknoticeTextMarginTop, context.getResources().getDimensionPixelOffset(i13));
            int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FaqNoticeView_faqsdknoticeContentMarginTop, getResources().getDimensionPixelOffset(R$dimen.faq_sdk_ui_108_dp));
            drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FaqNoticeView_faqsdknoticeImage);
            int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FaqNoticeView_faqsdknoticeImageSize, -1);
            this.f39328C = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FaqNoticeView_faqsdknoticeAutoFitCenterYInLandScape, false);
            typedArrayObtainStyledAttributes.recycle();
            i14 = dimensionPixelSize2;
            i10 = dimensionPixelSize3;
        } else {
            drawable = null;
            dimensionPixelSize = dimension;
            color = color2;
            drawable2 = null;
            string = null;
            i10 = -1;
        }
        if (drawable2 != null) {
            setBackground(drawable2);
        }
        if (TextUtils.isEmpty(string)) {
            this.f39343m = getResources().getString(R$string.faq_sdk_common_loading);
        } else {
            this.f39343m = string;
        }
        if (this.f39334d == EnumC8429c.ERROR) {
            m52468g(this.f39339i);
        } else {
            this.f39351u = i14;
            this.f39332b.setVisibility(8);
            this.f39333c.setVisibility(0);
            this.f39337g.setVisibility(4);
            this.f39331a.setText(this.f39343m);
        }
        this.f39331a.setTextSize(0, dimensionPixelSize);
        this.f39331a.setTextColor(color);
        m52466e(dimensionPixelOffset, drawable, i10, i14);
    }

    /* renamed from: r */
    public void m52475r(FaqConstants.FaqErrorCode faqErrorCode, int i10) {
        this.f39338h.put(faqErrorCode, Integer.valueOf(i10));
        m52470i(this.f39334d);
    }

    public void setCallback(InterfaceC8428b interfaceC8428b) {
        this.f39353w = interfaceC8428b;
    }

    public void setNoticeImageResource(int i10) {
        this.f39332b.setImageResource(i10);
    }

    public void setNoticeImageViewSize(int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f39332b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i10, i10);
        } else {
            layoutParams.height = i10;
            layoutParams.width = i10;
        }
        this.f39332b.setLayoutParams(layoutParams);
    }

    public void setNoticeLoadingText(String str) {
        this.f39343m = str;
    }

    public void setProgressMarginTop(int i10) {
        this.f39351u = i10;
        m52470i(this.f39334d);
    }

    public void setShouldHideContactUsButton(boolean z10) {
        this.f39330E = z10;
        m52470i(this.f39334d);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (i10 == 8) {
            this.f39339i = FaqConstants.FaqErrorCode.DEFAULT;
        }
    }

    /* renamed from: u */
    public final void m52476u(Context context) {
        this.f39335e.measure(0, 0);
        if (this.f39335e.getMeasuredWidth() < FaqCommonUtils.getScreenWidthHeight(context)) {
            C8417g.m52396b(context, this.f39335e);
        }
    }

    /* renamed from: v */
    public final boolean m52477v() throws Throwable {
        FaqLogger.m51836d("NoticeView", "checkContentSize mBtnHeight:" + this.f39341k);
        if (this.f39341k <= 0) {
            return true;
        }
        EnumC8429c enumC8429c = this.f39334d;
        EnumC8429c enumC8429c2 = EnumC8429c.ERROR;
        float measuredHeight = (((getMeasuredHeight() - m52454a(this.f39331a)) - getResources().getDimensionPixelSize(R$dimen.faq_sdk_notice_view_text_margin_top)) - (this.f39334d == enumC8429c2 ? this.f39338h.get(this.f39339i).intValue() : this.f39333c.getHeight())) - (enumC8429c == enumC8429c2 ? this.f39347q.get(this.f39339i).intValue() : this.f39351u);
        float dimension = this.f39337g.getVisibility() == 0 ? this.f39341k + (getResources().getDimension(R$dimen.faq_sdk_ui_16_dip) * 2.0f) : getResources().getDimension(R$dimen.faq_sdk_ui_16_dip);
        FaqLogger.m51836d("NoticeView", "checkContentSize leftHeight:" + measuredHeight + "   btnHeight:" + dimension);
        return measuredHeight >= dimension;
    }

    public FaqNoticeView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        this.f39338h = new HashMap();
        this.f39341k = 0;
        this.f39342l = 0;
        this.f39345o = -1;
        this.f39347q = new HashMap();
        this.f39349s = new HashMap();
        this.f39350t = new HashMap();
        this.f39351u = 0;
        this.f39352v = true;
        this.f39354x = new int[2];
        this.f39355y = new RunnableC8427a();
        this.f39330E = false;
        m52467f(context, attributeSet);
    }

    public FaqNoticeView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet);
    }
}
