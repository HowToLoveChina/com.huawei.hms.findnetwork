package com.huawei.phoneservice.feedback.widget;

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
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedback.R$color;
import com.huawei.phoneservice.feedback.R$dimen;
import com.huawei.phoneservice.feedback.R$drawable;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.R$styleable;
import com.huawei.phoneservice.feedback.photolibrary.internal.utils.C8510b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class FeedbackNoticeView extends FrameLayout implements View.OnClickListener {

    /* renamed from: E */
    public static Map<CharSequence, Integer> f39978E = new HashMap();

    /* renamed from: A */
    public int f39979A;

    /* renamed from: B */
    public int f39980B;

    /* renamed from: C */
    public int f39981C;

    /* renamed from: D */
    public boolean f39982D;

    /* renamed from: a */
    public TextView f39983a;

    /* renamed from: b */
    public ImageView f39984b;

    /* renamed from: c */
    public ProgressBar f39985c;

    /* renamed from: d */
    public EnumC8597c f39986d;

    /* renamed from: e */
    public View f39987e;

    /* renamed from: f */
    public View f39988f;

    /* renamed from: g */
    public Button f39989g;

    /* renamed from: h */
    public FaqConstants.FaqErrorCode f39990h;

    /* renamed from: i */
    public String f39991i;

    /* renamed from: j */
    public int f39992j;

    /* renamed from: k */
    public int f39993k;

    /* renamed from: l */
    public int f39994l;

    /* renamed from: m */
    public float f39995m;

    /* renamed from: n */
    public float f39996n;

    /* renamed from: o */
    public int f39997o;

    /* renamed from: p */
    public int f39998p;

    /* renamed from: q */
    public final Map<FaqConstants.FaqErrorCode, Integer> f39999q;

    /* renamed from: r */
    public final Map<FaqConstants.FaqErrorCode, Integer> f40000r;

    /* renamed from: s */
    public final Map<FaqConstants.FaqErrorCode, Integer> f40001s;

    /* renamed from: t */
    public final Map<FaqConstants.FaqErrorCode, Integer> f40002t;

    /* renamed from: u */
    public int f40003u;

    /* renamed from: v */
    public boolean f40004v;

    /* renamed from: w */
    public InterfaceC8596b f40005w;

    /* renamed from: x */
    public int[] f40006x;

    /* renamed from: y */
    public Runnable f40007y;

    /* renamed from: z */
    public int f40008z;

    /* renamed from: com.huawei.phoneservice.feedback.widget.FeedbackNoticeView$a */
    public class RunnableC8595a implements Runnable {
        public RunnableC8595a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            FeedbackNoticeView feedbackNoticeView = FeedbackNoticeView.this;
            feedbackNoticeView.f40004v = feedbackNoticeView.m53153w();
            FaqLogger.m51836d("FeedbackNoticeView", "refreshAction contentSizeEnough:" + FeedbackNoticeView.this.f40004v);
            FeedbackNoticeView feedbackNoticeView2 = FeedbackNoticeView.this;
            feedbackNoticeView2.setContentMarginTop(feedbackNoticeView2.f39986d == EnumC8597c.ERROR ? ((Integer) feedbackNoticeView2.f39999q.get(FeedbackNoticeView.this.f39990h)).intValue() : feedbackNoticeView2.f40003u);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.widget.FeedbackNoticeView$b */
    public interface InterfaceC8596b {
        /* renamed from: a */
        void mo52976a();
    }

    /* renamed from: com.huawei.phoneservice.feedback.widget.FeedbackNoticeView$c */
    public enum EnumC8597c {
        ERROR,
        PROGRESS
    }

    public FeedbackNoticeView(Context context) throws Throwable {
        super(context);
        this.f39993k = 0;
        this.f39994l = 0;
        this.f39997o = -1;
        this.f39999q = new HashMap();
        this.f40000r = new HashMap();
        this.f40001s = new HashMap();
        this.f40002t = new HashMap();
        this.f40003u = 0;
        this.f40004v = true;
        this.f40006x = new int[2];
        this.f40007y = new RunnableC8595a();
        m53142f(context, null);
    }

    /* renamed from: a */
    public static int m53129a(TextView textView) {
        if (textView.getMeasuredWidth() == 0) {
            return 0;
        }
        String string = textView.getText().toString();
        if (f39978E.containsKey(string)) {
            return f39978E.get(string).intValue();
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
            f39978E.put(string, Integer.valueOf(height + i11));
            return iArr[1] + i11;
        }
        int lineStart = staticLayout.getLineStart(maxLines) - 1;
        iArr[0] = lineStart;
        int height2 = new StaticLayout(string.substring(0, lineStart), paint, textView.getWidth(), alignment, 1.0f, 0.0f, false).getHeight();
        iArr[1] = height2;
        f39978E.put(string, Integer.valueOf(height2 + i11));
        return iArr[1] + i11;
    }

    /* renamed from: c */
    public static Integer m53130c(Context context) throws Throwable {
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
        typedValue.data = context.getResources().getColor(Color.parseColor("#f0f0f0") == typedValue.data ? R$color.feedback_sdk_notice_view_pad_background : R$color.feedback_sdk_notice_view_background);
        return Integer.valueOf(typedValue.data);
    }

    private int getAutoFitContentSize() throws Throwable {
        int iIntValue = this.f39986d == EnumC8597c.ERROR ? this.f40000r.get(this.f39990h).intValue() : this.f39985c.getHeight();
        int iM53129a = m53129a(this.f39983a);
        Resources resources = getResources();
        int i10 = R$dimen.feedback_sdk_notice_view_text_margin_top;
        float dimensionPixelSize = iM53129a + resources.getDimensionPixelSize(i10);
        FaqLogger.m51836d("FeedbackNoticeView", "getAutoFitContentSize:   contentImageOffset:" + iIntValue + "   measureTextViewHeight(noticeTextView):" + m53129a(this.f39983a) + "   DimensionPixelSize" + getResources().getDimensionPixelSize(i10) + "   textView Height :" + this.f39983a.getMeasuredHeight());
        return (int) (iIntValue + dimensionPixelSize + 0.5d);
    }

    /* renamed from: q */
    public static void m53134q(Context context) throws Throwable {
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
            FaqLogger.m51840e("FeedbackNoticeView", "gotoNetworkSettingView ActivityNotFoundException...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentMarginTop(int i10) throws Throwable {
        int i11;
        FaqLogger.m51836d("FeedbackNoticeView", "setContentMarginTop param contentMarginTop:" + i10);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f39987e.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (!this.f40004v) {
            i10 = getMinContentMarginTop();
            FaqLogger.m51836d("FeedbackNoticeView", "setContentMarginTop getMinContentMarginTop:" + i10);
        }
        m53140d();
        m53148o();
        if (getResources().getConfiguration().orientation == 2) {
            if (!this.f40004v) {
                this.f39980B = Math.min(i10, this.f39980B);
            }
            i11 = this.f39980B;
            if (i11 <= 0) {
                i11 = 0;
            }
        } else {
            i11 = this.f39981C;
        }
        layoutParams.topMargin = i11;
        if (this.f40004v || this.f39979A >= this.f40008z || this.f39988f.getVisibility() != 0) {
            this.f39983a.setVisibility(0);
        } else {
            this.f39983a.setVisibility(4);
        }
        FaqLogger.m51836d("FeedbackNoticeView", "setContentMarginTop topMargin:" + layoutParams.topMargin);
        this.f39987e.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    public final EnumC8597c m53139b(int i10) {
        return i10 == 0 ? EnumC8597c.ERROR : EnumC8597c.PROGRESS;
    }

    /* renamed from: d */
    public final void m53140d() throws Throwable {
        Point point = new Point();
        ((WindowManager) getContext().getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealSize(point);
        int iMin = Math.min(point.x, point.y);
        FaqLogger.m51836d("FeedbackNoticeView", "calculateCenterMarginTop location 0:" + this.f40006x[0] + "   location 1:" + this.f40006x[1]);
        int autoFitContentSize = getAutoFitContentSize();
        int height = this.f39982D ? (getHeight() - autoFitContentSize) / 2 : ((iMin / 2) - this.f40006x[1]) - (autoFitContentSize / 2);
        FaqLogger.m51836d("FeedbackNoticeView", "calculateCenterMarginTop getHeight:" + getHeight() + "   getAutoFitContentSize:" + autoFitContentSize + "   newCenterMarginTop:" + height);
        if (this.f39980B != height) {
            FaqLogger.m51836d("FeedbackNoticeView", "calculateCenterMarginTop centerMarginTop != newCenterMarginTop");
            this.f39980B = height;
        }
    }

    /* renamed from: e */
    public final void m53141e(int i10, int i11, int i12, Drawable drawable) throws Throwable {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f39983a.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams.topMargin = i11;
        this.f39983a.setLayoutParams(layoutParams);
        if (drawable != null) {
            this.f39984b.setImageDrawable(drawable);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f39984b.getLayoutParams();
        if (i12 <= 0) {
            i12 = -2;
        }
        if (layoutParams2 == null) {
            layoutParams2 = new LinearLayout.LayoutParams(i12, i12);
        } else {
            layoutParams2.height = i12;
            layoutParams2.width = i12;
        }
        this.f39984b.setLayoutParams(layoutParams2);
        setContentMarginTop(i10);
    }

    /* renamed from: f */
    public final void m53142f(Context context, AttributeSet attributeSet) throws Throwable {
        Map<FaqConstants.FaqErrorCode, Integer> map = this.f39999q;
        FaqConstants.FaqErrorCode faqErrorCode = FaqConstants.FaqErrorCode.DEFAULT;
        map.put(faqErrorCode, Integer.valueOf(getResources().getDimensionPixelOffset(R$dimen.feedback_sdk_common_28_dp)));
        Map<FaqConstants.FaqErrorCode, Integer> map2 = this.f39999q;
        FaqConstants.FaqErrorCode faqErrorCode2 = FaqConstants.FaqErrorCode.INTERNET_ERROR;
        map2.put(faqErrorCode2, Integer.valueOf(getResources().getDimensionPixelOffset(R$dimen.feedback_sdk_common_90_dip)));
        Map<FaqConstants.FaqErrorCode, Integer> map3 = this.f39999q;
        FaqConstants.FaqErrorCode faqErrorCode3 = FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR;
        Resources resources = getResources();
        int i10 = R$dimen.feedback_sdk_common_108_dp;
        map3.put(faqErrorCode3, Integer.valueOf(resources.getDimensionPixelOffset(i10)));
        Map<FaqConstants.FaqErrorCode, Integer> map4 = this.f39999q;
        FaqConstants.FaqErrorCode faqErrorCode4 = FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR;
        map4.put(faqErrorCode4, Integer.valueOf(getResources().getDimensionPixelOffset(i10)));
        Map<FaqConstants.FaqErrorCode, Integer> map5 = this.f39999q;
        FaqConstants.FaqErrorCode faqErrorCode5 = FaqConstants.FaqErrorCode.DIFFERENT_SITE;
        map5.put(faqErrorCode5, Integer.valueOf(getResources().getDimensionPixelOffset(i10)));
        Map<FaqConstants.FaqErrorCode, Integer> map6 = this.f40000r;
        Resources resources2 = getResources();
        int i11 = R$dimen.feedback_sdk_loading_error_icon_size;
        map6.put(faqErrorCode, Integer.valueOf(resources2.getDimensionPixelOffset(i11)));
        this.f40000r.put(faqErrorCode2, Integer.valueOf(getResources().getDimensionPixelOffset(i11)));
        this.f40000r.put(faqErrorCode3, Integer.valueOf(getResources().getDimensionPixelOffset(i11)));
        Map<FaqConstants.FaqErrorCode, Integer> map7 = this.f40000r;
        Resources resources3 = getResources();
        int i12 = R$dimen.feedback_sdk_loading_empty_icon_size;
        map7.put(faqErrorCode4, Integer.valueOf(resources3.getDimensionPixelOffset(i12)));
        this.f40000r.put(faqErrorCode5, Integer.valueOf(getResources().getDimensionPixelOffset(i12)));
        this.f40001s.put(faqErrorCode, Integer.valueOf(R$drawable.feedback_sdk_ic_no_pic_disable));
        Map<FaqConstants.FaqErrorCode, Integer> map8 = this.f40001s;
        int i13 = R$drawable.feedback_sdk_ic_no_wifi_disable;
        map8.put(faqErrorCode2, Integer.valueOf(i13));
        this.f40001s.put(faqErrorCode3, Integer.valueOf(i13));
        this.f40001s.put(faqErrorCode4, Integer.valueOf(R$drawable.feedback_sdk_ic_no_search_result));
        this.f40001s.put(faqErrorCode5, Integer.valueOf(R$drawable.ic_icon_tips_disable));
        this.f40002t.put(faqErrorCode2, Integer.valueOf(R$string.feedback_sdk_common_network_setting));
        this.f40002t.put(faqErrorCode3, Integer.valueOf(R$string.faq_sdk_common_server_disconnected));
        this.f40002t.put(faqErrorCode4, Integer.valueOf(R$string.feedback_sdk_service_help_prepare));
        this.f40002t.put(faqErrorCode5, Integer.valueOf(R$string.feedback_sdk_inconsistent));
        this.f40008z = getResources().getDimensionPixelOffset(R$dimen.feedback_sdk_common_16_dip);
        this.f39994l = FaqCommonUtils.getScreenHeight(context) / 3;
        this.f39998p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        LayoutInflater.from(context).inflate(R$layout.feedback_sdk_widget_notice_view, this);
        this.f39984b = (ImageView) findViewById(R$id.notice_image_view);
        this.f39983a = (TextView) findViewById(R$id.notice_text_view);
        this.f39985c = (ProgressBar) findViewById(R$id.notice_progress_view);
        this.f39987e = findViewById(R$id.notice_view_container);
        this.f39988f = findViewById(R$id.button_container);
        Button button = (Button) findViewById(R$id.error_button);
        this.f39989g = button;
        button.setOnClickListener(this);
        m53152v(context);
        setBackgroundColor(m53130c(context).intValue());
        m53150r(context, attributeSet);
    }

    /* renamed from: g */
    public void m53143g(FaqConstants.FaqErrorCode faqErrorCode) throws Throwable {
        FaqLogger.m51836d("FeedbackNoticeView", "showErrorCode errorCode:" + faqErrorCode);
        this.f39984b.setVisibility(0);
        this.f39985c.setVisibility(8);
        int iIntValue = this.f40001s.get(faqErrorCode).intValue();
        int iIntValue2 = this.f40002t.get(faqErrorCode).intValue();
        setNoticeImageViewSize(this.f40000r.get(faqErrorCode).intValue());
        setNoticeImageResource(iIntValue);
        m53149p(iIntValue2);
        this.f39988f.setVisibility(4);
        m53145i(faqErrorCode, iIntValue, iIntValue2);
        if (faqErrorCode != FaqConstants.FaqErrorCode.DEFAULT) {
            setVisibility(0);
        }
        this.f39990h = faqErrorCode;
        this.f39986d = EnumC8597c.ERROR;
        this.f40004v = m53153w();
        setContentMarginTop(this.f39999q.get(faqErrorCode).intValue());
    }

    public int getColorPrimary() throws Throwable {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        FaqLogger.m51836d("getColorPrimary", "colorPrimary : " + typedValue.data + "  strColor: " + String.format("#%06X", Integer.valueOf(typedValue.data & 16777215)));
        typedValue.data = getResources().getColor(Color.parseColor("#f0f0f0") == typedValue.data ? R$color.feedback_sdk_notice_view_pad_background : R$color.feedback_sdk_notice_view_background);
        return typedValue.data;
    }

    public FaqConstants.FaqErrorCode getFaqErrorCode() {
        return this.f39990h;
    }

    public int getMinContentMarginTop() throws Throwable {
        Resources resources = getResources();
        int i10 = R$dimen.feedback_sdk_common_16_dip;
        float dimension = resources.getDimension(i10);
        if (this.f39988f.getVisibility() == 0) {
            dimension = this.f39993k + (getResources().getDimension(i10) * 2.0f);
        }
        EnumC8597c enumC8597c = this.f39986d;
        EnumC8597c enumC8597c2 = EnumC8597c.ERROR;
        float fIntValue = enumC8597c == enumC8597c2 ? this.f40000r.get(this.f39990h).intValue() : this.f39985c.getHeight();
        this.f39979A = (int) ((((getMeasuredHeight() - dimension) - m53129a(this.f39983a)) - getResources().getDimensionPixelSize(R$dimen.feedback_sdk_notice_view_text_margin_top)) - fIntValue);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getMinContentMarginTop noticeType：");
        sb2.append(this.f39986d == enumC8597c2 ? "ERROR" : "PROGRESS");
        FaqLogger.m51836d("FeedbackNoticeView", sb2.toString());
        FaqLogger.m51836d("FeedbackNoticeView", "getMinContentMarginTop contentMarginTop：" + Math.max(this.f40008z, this.f39979A));
        FaqLogger.m51836d("FeedbackNoticeView", "getMinContentMarginTop contentImageOffset：" + fIntValue);
        FaqLogger.m51836d("FeedbackNoticeView", "getMinContentMarginTop getMeasuredHeight：" + getMeasuredHeight());
        FaqLogger.m51836d("FeedbackNoticeView", "getMinContentMarginTop buttonOffset：" + dimension + "    measureTextViewHeight:" + m53129a(this.f39983a));
        return Math.max(this.f40008z, this.f39979A);
    }

    public TextView getNoticeTextView() {
        return this.f39983a;
    }

    /* renamed from: h */
    public void m53144h(FaqConstants.FaqErrorCode faqErrorCode, int i10) throws Throwable {
        this.f40001s.put(faqErrorCode, Integer.valueOf(i10));
        m53146j(this.f39986d);
    }

    /* renamed from: i */
    public final void m53145i(FaqConstants.FaqErrorCode faqErrorCode, int i10, int i11) throws Throwable {
        Context context;
        Resources resources;
        int i12;
        if (faqErrorCode == FaqConstants.FaqErrorCode.INTERNET_ERROR) {
            if (i10 != 0 || i11 != 0) {
                this.f39988f.setVisibility(0);
                this.f39989g.setText(getResources().getString(R$string.feedback_sdk_common_set_network));
            }
            if (this.f39990h != faqErrorCode && (i10 != 0 || i11 != 0)) {
                return;
            }
            context = getContext();
            resources = getResources();
            i12 = R$string.feedback_sdk_no_network_toast;
        } else {
            if (faqErrorCode != FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR) {
                if (faqErrorCode == FaqConstants.FaqErrorCode.DIFFERENT_SITE) {
                    if (i10 == 0 && i11 == 0) {
                        return;
                    }
                    this.f39988f.setVisibility(0);
                    this.f39989g.setText(getResources().getString(R$string.feedback_sdk_back));
                    return;
                }
                return;
            }
            if (this.f39990h != faqErrorCode && (i10 != 0 || i11 != 0)) {
                return;
            }
            context = getContext();
            resources = getResources();
            i12 = R$string.feedback_sdk_common_server_disconnected_toast;
        }
        FaqToastUtils.makeText(context, resources.getString(i12));
    }

    /* renamed from: j */
    public void m53146j(EnumC8597c enumC8597c) throws Throwable {
        FaqLogger.m51836d("FeedbackNoticeView", "showNoticeType type:" + enumC8597c);
        this.f39986d = enumC8597c;
        if (enumC8597c == EnumC8597c.ERROR) {
            m53143g(this.f39990h);
            return;
        }
        this.f39984b.setVisibility(8);
        this.f39985c.setVisibility(0);
        this.f39988f.setVisibility(4);
        this.f39983a.setText(this.f39991i);
        this.f40004v = m53153w();
        setContentMarginTop(this.f40003u);
        setVisibility(0);
    }

    /* renamed from: l */
    public void m53147l(Throwable th2) throws Throwable {
        Logger.m32137d("FeedbackNoticeView", "dealWithHttpError error:%s", th2);
        if (th2 != null) {
            if ((th2 instanceof FaqWebServiceException) && ((FaqWebServiceException) th2).errorCode == 500002) {
                m53143g(FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR);
            } else {
                m53154y();
            }
        }
    }

    /* renamed from: o */
    public final void m53148o() throws Throwable {
        Point point = new Point();
        ((WindowManager) getContext().getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealSize(point);
        int iMax = Math.max(point.x, point.y);
        FaqLogger.m51836d("FeedbackNoticeView", "calculatePortMarginTop location 0:" + this.f40006x[0] + "   location 1:" + this.f40006x[1]);
        int height = ((int) (((double) iMax) * 0.3d)) - this.f40006x[1];
        int autoFitContentSize = getAutoFitContentSize();
        if (this.f39982D || height < 0) {
            height = (getHeight() - autoFitContentSize) / 2;
        }
        FaqLogger.m51836d("FeedbackNoticeView", "calculatePortMarginTop getHeight:" + getHeight() + "   getAutoFitContentSize:" + autoFitContentSize + "   newCenterMarginTop:" + height);
        if (this.f39981C != height) {
            FaqLogger.m51836d("FeedbackNoticeView", "calculatePortMarginTop portMarginTop30 != newPortMarginTop");
            this.f39981C = height;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        InterfaceC8596b interfaceC8596b;
        if (NoDoubleClickUtil.isDoubleClick(view)) {
            return;
        }
        FaqConstants.FaqErrorCode faqErrorCode = this.f39990h;
        if (faqErrorCode == FaqConstants.FaqErrorCode.INTERNET_ERROR) {
            m53134q(getContext());
        } else {
            if (faqErrorCode != FaqConstants.FaqErrorCode.DIFFERENT_SITE || (interfaceC8596b = this.f40005w) == null) {
                return;
            }
            interfaceC8596b.mo52976a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f40007y);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws Throwable {
        FaqLogger.m51836d("FeedbackNoticeView", "onLayout changed:" + z10);
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            removeCallbacks(this.f40007y);
            boolean zM53153w = m53153w();
            FaqLogger.m51836d("FeedbackNoticeView", "onLayout sizeEnough:" + zM53153w + "   contentSizeEnough:" + this.f40004v);
            if (zM53153w != this.f40004v) {
                this.f40004v = zM53153w;
            }
            setContentMarginTop(this.f39986d == EnumC8597c.ERROR ? this.f39999q.get(this.f39990h).intValue() : this.f40003u);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) throws Throwable {
        FaqLogger.m51836d("FeedbackNoticeView", "onMeasure");
        super.onMeasure(i10, i11);
        if (this.f39985c.getMeasuredHeight() > 0 && this.f39992j == 0) {
            this.f39992j = this.f39985c.getMeasuredWidth();
            int measuredHeight = this.f39985c.getMeasuredHeight();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f39985c.getLayoutParams();
            int iMax = Math.max(measuredHeight, this.f39992j);
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(iMax, iMax);
            } else {
                layoutParams.height = iMax;
                layoutParams.width = iMax;
            }
            FaqLogger.m51836d("FeedbackNoticeView", "onMeasure noticeProgressBar height:" + layoutParams.height + "   width:" + layoutParams.width);
            this.f39985c.setLayoutParams(layoutParams);
        }
        if (this.f39987e.getMeasuredHeight() <= 0 || this.f39993k != 0) {
            return;
        }
        this.f39993k = this.f39988f.getMeasuredHeight();
        FaqLogger.m51836d("FeedbackNoticeView", "onMeasure mBtnHeight:" + this.f39993k);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) throws Throwable {
        FaqLogger.m51836d("FeedbackNoticeView", "onSizeChanged");
        super.onSizeChanged(i10, i11, i12, i13);
        getLocationOnScreen(this.f40006x);
        FaqLogger.m51836d("FeedbackNoticeView", "onSizeChanged location 0:" + this.f40006x[0] + "   location 1:" + this.f40006x[1]);
        boolean z10 = !(i13 == 0 || i11 == 0 || i11 - i13 <= this.f39994l) || i13 == 0 || i11 == 0 || i13 - i11 <= this.f39994l;
        FaqLogger.m51836d("FeedbackNoticeView", "onSizeChanged sizeEnough:" + z10 + "   contentSizeEnough:" + this.f40004v);
        if (z10 != this.f40004v) {
            removeCallbacks(this.f40007y);
            if (isAttachedToWindow()) {
                post(this.f40007y);
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
            int r0 = r4.f39997o
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
            float r2 = r4.f39995m
            int r2 = (int) r2
            int r1 = r1 - r2
            int r1 = java.lang.Math.abs(r1)
            float r2 = r4.f39996n
            int r2 = (int) r2
            int r0 = r0 - r2
            int r0 = java.lang.Math.abs(r0)
            int r2 = r4.f39998p
            if (r1 > r2) goto L45
            if (r0 > r2) goto L45
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView$c r0 = r4.f39986d
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView$c r1 = com.huawei.phoneservice.feedback.widget.FeedbackNoticeView.EnumC8597c.PROGRESS
            if (r0 != r1) goto L5f
        L45:
            r5.setAction(r3)
            goto L5f
        L49:
            r4.f39997o = r2
            goto L5f
        L4c:
            float r0 = r5.getY()
            r4.f39995m = r0
            float r0 = r5.getX()
            r4.f39996n = r0
            r0 = 0
            int r0 = r5.getPointerId(r0)
            r4.f39997o = r0
        L5f:
            boolean r4 = super.onTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedback.widget.FeedbackNoticeView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) throws Throwable {
        FaqLogger.m51836d("FeedbackNoticeView", "onWindowFocusChanged");
        super.onWindowFocusChanged(z10);
        getLocationOnScreen(this.f40006x);
        FaqLogger.m51836d("FeedbackNoticeView", "onWindowFocusChanged location 0:" + this.f40006x[0] + "   location 1:" + this.f40006x[1]);
        setContentMarginTop(this.f39986d == EnumC8597c.ERROR ? this.f39999q.get(this.f39990h).intValue() : this.f40003u);
    }

    /* renamed from: p */
    public void m53149p(int i10) {
        if (i10 == 0) {
            this.f39983a.setVisibility(4);
        } else {
            this.f39983a.setVisibility(0);
            this.f39983a.setText(i10);
        }
    }

    /* renamed from: r */
    public final void m53150r(Context context, AttributeSet attributeSet) throws Throwable {
        Drawable drawable;
        int dimensionPixelSize;
        int color;
        Drawable drawable2;
        String string;
        int i10;
        Resources resources = context.getResources();
        int i11 = R$dimen.feedback_sdk_notice_view_text_size;
        int dimension = (int) resources.getDimension(i11);
        Resources resources2 = context.getResources();
        int i12 = R$color.feedback_sdk_notice_view_default_text_color;
        int color2 = resources2.getColor(i12);
        Resources resources3 = context.getResources();
        int i13 = R$dimen.feedback_sdk_notice_view_text_margin_top;
        int dimensionPixelOffset = resources3.getDimensionPixelOffset(i13);
        int i14 = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FeedbackNoticeView);
            drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FeedbackNoticeView_fbsdknoticeViewBackground);
            this.f39986d = m53139b(typedArrayObtainStyledAttributes.getInt(R$styleable.FeedbackNoticeView_fbsdknoticeViewType, 0));
            string = typedArrayObtainStyledAttributes.getString(R$styleable.FeedbackNoticeView_fbsdknoticeLoadingText);
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FeedbackNoticeView_fbsdknoticeTextSize, (int) context.getResources().getDimension(i11));
            color = typedArrayObtainStyledAttributes.getColor(R$styleable.FeedbackNoticeView_fbsdknoticeTextColor, context.getResources().getColor(i12));
            dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FeedbackNoticeView_fbsdknoticeTextMarginTop, context.getResources().getDimensionPixelOffset(i13));
            int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FeedbackNoticeView_fbsdknoticeContentMarginTop, getResources().getDimensionPixelOffset(R$dimen.feedback_sdk_common_108_dp));
            drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FeedbackNoticeView_fbsdknoticeImage);
            int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FeedbackNoticeView_fbsdknoticeImageSize, -1);
            this.f39982D = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FeedbackNoticeView_fbsdknoticeAutoFitCenterYInLandScape, false);
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
            this.f39991i = getResources().getString(R$string.feedback_sdk_common_loading);
        } else {
            this.f39991i = string;
        }
        if (this.f39986d == EnumC8597c.ERROR) {
            m53143g(this.f39990h);
        } else {
            this.f40003u = i14;
            this.f39984b.setVisibility(8);
            this.f39985c.setVisibility(0);
            this.f39988f.setVisibility(4);
            this.f39983a.setText(this.f39991i);
        }
        this.f39983a.setTextSize(0, dimensionPixelSize);
        this.f39983a.setTextColor(color);
        m53141e(i14, dimensionPixelOffset, i10, drawable);
    }

    /* renamed from: s */
    public void m53151s(FaqConstants.FaqErrorCode faqErrorCode, int i10) throws Throwable {
        this.f40000r.put(faqErrorCode, Integer.valueOf(i10));
        m53146j(this.f39986d);
    }

    public void setCallback(InterfaceC8596b interfaceC8596b) {
        this.f40005w = interfaceC8596b;
    }

    public void setNoticeImageResource(int i10) {
        this.f39984b.setImageResource(i10);
    }

    public void setNoticeImageViewSize(int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f39984b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i10, i10);
        } else {
            layoutParams.height = i10;
            layoutParams.width = i10;
        }
        this.f39984b.setLayoutParams(layoutParams);
    }

    public void setNoticeLoadingText(String str) {
        this.f39991i = str;
    }

    public void setProgressMarginTop(int i10) throws Throwable {
        this.f40003u = i10;
        m53146j(this.f39986d);
    }

    public void setShouldHideContactUsButton(boolean z10) throws Throwable {
        m53146j(this.f39986d);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (i10 == 8) {
            this.f39990h = FaqConstants.FaqErrorCode.DEFAULT;
        }
    }

    /* renamed from: v */
    public final void m53152v(Context context) {
        this.f39989g.measure(0, 0);
        if (this.f39989g.getMeasuredWidth() < FaqCommonUtils.getScreenWidthHeight(context)) {
            C8510b.m52864a(context, this.f39989g);
        }
    }

    /* renamed from: w */
    public final boolean m53153w() throws Throwable {
        FaqLogger.m51836d("FeedbackNoticeView", "checkContentSize mBtnHeight:" + this.f39993k);
        if (this.f39993k <= 0) {
            return true;
        }
        EnumC8597c enumC8597c = this.f39986d;
        EnumC8597c enumC8597c2 = EnumC8597c.ERROR;
        float measuredHeight = (((getMeasuredHeight() - m53129a(this.f39983a)) - getResources().getDimensionPixelSize(R$dimen.feedback_sdk_notice_view_text_margin_top)) - (this.f39986d == enumC8597c2 ? this.f40000r.get(this.f39990h).intValue() : this.f39985c.getHeight())) - (enumC8597c == enumC8597c2 ? this.f39999q.get(this.f39990h).intValue() : this.f40003u);
        float dimension = this.f39988f.getVisibility() == 0 ? this.f39993k + (getResources().getDimension(R$dimen.feedback_sdk_common_16_dip) * 2.0f) : getResources().getDimension(R$dimen.feedback_sdk_common_16_dip);
        FaqLogger.m51836d("FeedbackNoticeView", "checkContentSize leftHeight:" + measuredHeight + "   btnHeight:" + dimension);
        return measuredHeight >= dimension;
    }

    /* renamed from: y */
    public final void m53154y() throws Throwable {
        m53143g(!FaqCommonUtils.isConnectionAvailable(getContext()) ? FaqConstants.FaqErrorCode.INTERNET_ERROR : FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR);
    }

    public FeedbackNoticeView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        this.f39993k = 0;
        this.f39994l = 0;
        this.f39997o = -1;
        this.f39999q = new HashMap();
        this.f40000r = new HashMap();
        this.f40001s = new HashMap();
        this.f40002t = new HashMap();
        this.f40003u = 0;
        this.f40004v = true;
        this.f40006x = new int[2];
        this.f40007y = new RunnableC8595a();
        m53142f(context, attributeSet);
    }

    public FeedbackNoticeView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet);
    }
}
