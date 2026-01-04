package com.huawei.android.hicloud.p088ui.uiextend;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.HiCloudRoundRectImageView;
import com.huawei.android.hicloud.p088ui.uilistener.RecommendTextLinkTouchListener;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.BannerPictureType;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.Locale;
import p015ak.C0209d;
import p273f0.ViewTreeObserverOnPreDrawListenerC9595e0;
import p329h7.C10121i;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p651t8.C12997e;
import p684un.C13227f;
import p709vj.C13452e;
import p805yb.C13933c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RecommendItemView extends LinearLayout {
    private static final String TAG = "RecommendItemView";
    protected RecommendCard card;
    private int cardsNum;
    private float fontScale;
    protected HiCloudRoundRectImageView imageView;
    private boolean isShowTwoCards;
    protected LinearLayout llContent;
    protected View mView;
    private int maxLength;
    protected Context myContext;
    protected TextView recommendButton;
    protected TextView subTitle;
    private RecommendTextLinkTouchListener textLinkTouchListener;
    protected TextView title;

    public class LinkTouchMovementMethod extends LinkMovementMethod {
        private RecommendLinkSpan mClickSpan;

        private LinkTouchMovementMethod() {
        }

        private RecommendLinkSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int x10 = (int) motionEvent.getX();
            int y10 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
            int scrollY = y10 + textView.getScrollY();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            RecommendLinkSpan[] recommendLinkSpanArr = (RecommendLinkSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, RecommendLinkSpan.class);
            if (recommendLinkSpanArr.length > 0) {
                return recommendLinkSpanArr[0];
            }
            return null;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            C11839m.m70686d(RecommendItemView.TAG, "LinkTouchMovementMethod onTouchEvent: " + motionEvent.getAction());
            if (2 == motionEvent.getAction()) {
                RecommendLinkSpan pressedSpan = getPressedSpan(textView, spannable, motionEvent);
                RecommendLinkSpan recommendLinkSpan = this.mClickSpan;
                if (recommendLinkSpan != null && pressedSpan != recommendLinkSpan) {
                    recommendLinkSpan.setPressed(false);
                    this.mClickSpan = null;
                    Selection.removeSelection(spannable);
                }
            } else if (motionEvent.getAction() == 0) {
                RecommendLinkSpan pressedSpan2 = getPressedSpan(textView, spannable, motionEvent);
                this.mClickSpan = pressedSpan2;
                if (pressedSpan2 != null) {
                    pressedSpan2.setPressed(true);
                    if (RecommendItemView.this.textLinkTouchListener != null) {
                        RecommendItemView.this.textLinkTouchListener.mo24192a(motionEvent);
                    }
                    Selection.setSelection(spannable, spannable.getSpanStart(this.mClickSpan), spannable.getSpanEnd(this.mClickSpan));
                }
            } else {
                Selection.removeSelection(spannable);
                RecommendLinkSpan recommendLinkSpan2 = this.mClickSpan;
                if (recommendLinkSpan2 != null) {
                    recommendLinkSpan2.setPressed(false);
                    this.mClickSpan = null;
                }
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    public static class RecommendLinkSpan extends ClickableSpan {
        private RecommendCard card;
        SpanClickText.ISpanColorChange colorChangeListener = new SpanClickText.ISpanColorChange() { // from class: com.huawei.android.hicloud.ui.uiextend.RecommendItemView.RecommendLinkSpan.1
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanColorChange
            public void onColorChange(TextPaint textPaint, boolean z10) {
                textPaint.bgColor = RecommendLinkSpan.this.myContext.getColor(z10 ? R$color.emui9_list_seletor_color : R$color.transparent);
            }
        };
        private boolean isPressed;
        private Context myContext;

        public RecommendLinkSpan(Context context, RecommendCard recommendCard) {
            this.myContext = context;
            this.card = recommendCard;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            RecommendCard recommendCard = this.card;
            if (recommendCard != null) {
                NotifyTypeAndUriGoto textLinkGoto = recommendCard.getTextLinkGoto();
                if (textLinkGoto == null) {
                    C11839m.m70687e(RecommendItemView.TAG, "uriGoto is null");
                    return;
                }
                String notifyType = textLinkGoto.getNotifyType();
                String notifyUri = textLinkGoto.getNotifyUri();
                C11839m.m70688i(RecommendItemView.TAG, "notifyType: " + notifyType + ", notifyUri: " + notifyUri);
                if (TextUtils.equals(notifyType, "nps")) {
                    RecommendItemView.gotoNpsWebView(this.myContext);
                    return;
                }
                if (TextUtils.equals(notifyType, NotifyConstants.HICLOUD_KA)) {
                    RecommendItemView.gotoKa(notifyUri, this.card, this.myContext);
                    return;
                }
                if (TextUtils.equals(notifyType, NotifyConstants.HICLOUD_PPS)) {
                    return;
                }
                Intent intentM70543S = C11829c.m70543S(notifyType, notifyUri, false, this.card);
                if (intentM70543S == null) {
                    C11839m.m70687e(RecommendItemView.TAG, "intent is null");
                    return;
                }
                try {
                    intentM70543S.putExtra("recommend_card_activity_id", this.card.getActivityId());
                    intentM70543S.putExtra("recommend_card_activity_type", this.card.getActivityType());
                    intentM70543S.putExtra("recommend_card_entrance", this.card.getEntrance());
                    RecommendItemView.buildAgdParam(intentM70543S, notifyType, C10121i.m63035a());
                    this.myContext.startActivity(intentM70543S);
                    C2783d.m16102P0(this.card);
                } catch (Exception e10) {
                    C11839m.m70687e(RecommendItemView.TAG, "startActivity exception: " + e10.getMessage());
                    C11842p.m70808f(C12997e.m78015h(), notifyType, notifyUri, R$string.upgrade_filemanager_tip);
                }
            }
        }

        public void setPressed(boolean z10) {
            this.isPressed = z10;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.myContext.getColor(R$color.main_upgrade_color));
            this.colorChangeListener.onColorChange(textPaint, this.isPressed);
            textPaint.setUnderlineText(false);
        }
    }

    public RecommendItemView(Context context, RecommendCard recommendCard, int i10, boolean z10) {
        super(context);
        this.myContext = context;
        this.card = recommendCard;
        this.cardsNum = i10;
        this.isShowTwoCards = z10;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bindingLineCount(int i10, final String str) {
        int lineCount = this.subTitle.getLineCount();
        NotifyLogger.m29915i(TAG, "bindingLineCount lineCount: " + lineCount);
        if (lineCount <= i10 || this.subTitle.getMaxLines() == i10) {
            processTextLink(str, this.card);
            return true;
        }
        this.subTitle.setMaxLines(i10);
        NotifyLogger.m29915i(TAG, "subTitle.setMaxLines: " + i10);
        ViewTreeObserverOnPreDrawListenerC9595e0.m59820a(this.subTitle, new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f19293a.lambda$bindingLineCount$0(str);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void buildAgdParam(Intent intent, String str, AdParametersExt adParametersExt) {
        if (!NotifyConstants.HICLOUD_DLAPP.equals(str)) {
            C11839m.m70688i(TAG, "not dlApp type");
        } else {
            if (adParametersExt == null) {
                C11839m.m70688i(TAG, "adParameters is null");
                return;
            }
            intent.putExtra("agd_resource_enable", adParametersExt.getEnabled());
            intent.putExtra("agd_resource_slot_id", adParametersExt.getAgdAdid());
            intent.putExtra("pps_threshold", adParametersExt.getThreshold());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gotoKa(String str, RecommendCard recommendCard, Context context) {
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setData(uri);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.addFlags(C5914f2.f26733f);
        try {
            context.startActivity(intent);
            C2783d.m16086H0(recommendCard, false);
            C11841o.m70708d(context, context.getString(R$string.main_jump_third_party), 0);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "startActivity ka exception: " + e10.getMessage());
            C2783d.m16084G0(recommendCard, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gotoNpsWebView(Context context) {
        try {
            C13227f.m79492i1().m79585f0("nps_banner_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "nps_banner_click", "1", "66");
            RecommendCardManager.getInstance().removeNpsRecommandCard(RecommendCardConstants.Entrance.HOMEPAGE, false);
            context.startActivity(C13933c.m83668n().m83684q());
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "gotoNpsWebView exception: " + e10.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindingLineCount$0(String str) {
        processTextLink(str, this.card);
    }

    private void processTextLink(String str, RecommendCard recommendCard) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29913d(TAG, "processTextLink textLink is empty");
            return;
        }
        try {
            Layout layout = this.subTitle.getLayout();
            if (layout == null) {
                NotifyLogger.m29916w(TAG, "processTextLink: layout is null");
                return;
            }
            int lineCount = layout.getLineCount();
            NotifyLogger.m29913d(TAG, "processTextLink: layout lineCount: " + lineCount);
            int i10 = lineCount + (-1);
            int ellipsisCount = layout.getEllipsisCount(i10);
            NotifyLogger.m29913d(TAG, "processTextLink: layout ellipsisCount: " + ellipsisCount);
            int lineEnd = layout.getLineEnd(i10);
            NotifyLogger.m29913d(TAG, "processTextLink: layout lineEnd: " + lineEnd);
            if (ellipsisCount == 0) {
                NotifyLogger.m29913d(TAG, "processTextLink no ellipsize");
                this.subTitle.setMovementMethod(new LinkTouchMovementMethod());
                this.subTitle.setHighlightColor(this.myContext.getColor(R.color.transparent));
                return;
            }
            String strTrim = this.subTitle.getText().toString().trim();
            NotifyLogger.m29913d(TAG, "processTextLink: layout sub: " + strTrim);
            int length = ((lineEnd - ellipsisCount) - str.length()) + (-1);
            NotifyLogger.m29915i(TAG, "processTextLink endIndex: " + length);
            if (length < 0) {
                return;
            }
            String strSubstring = strTrim.substring(0, length);
            NotifyLogger.m29913d(TAG, "processTextLink: layout substring: " + strSubstring);
            SpannableString spannableString = new SpannableString(strSubstring + "..." + str);
            spannableString.setSpan(new RecommendLinkSpan(this.myContext, recommendCard), spannableString.length() - str.length(), spannableString.length(), 33);
            this.subTitle.setText(spannableString);
            this.subTitle.setMovementMethod(new LinkTouchMovementMethod());
            this.subTitle.setHighlightColor(this.myContext.getColor(R.color.transparent));
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "processTextLink error: " + e10);
        }
    }

    private void setAutoLineCount(final String str) {
        this.subTitle.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.huawei.android.hicloud.ui.uiextend.RecommendItemView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                RecommendItemView recommendItemView = RecommendItemView.this;
                TextView textView = recommendItemView.subTitle;
                if (textView == null || recommendItemView.title == null) {
                    NotifyLogger.m29916w(RecommendItemView.TAG, "subtitle is null ? " + RecommendItemView.this.subTitle);
                    return true;
                }
                textView.getViewTreeObserver().removeOnPreDrawListener(this);
                Layout layout = RecommendItemView.this.title.getLayout();
                int lineCount = layout != null ? layout.getLineCount() : RecommendItemView.this.title.getLineCount();
                NotifyLogger.m29913d(RecommendItemView.TAG, "setAutoLineCount onPreDraw mainTitleLineCount: " + lineCount);
                if (lineCount <= 1) {
                    return "bo".equalsIgnoreCase(Locale.getDefault().getLanguage()) ? RecommendItemView.this.bindingLineCount(2, str) : RecommendItemView.this.bindingLineCount(3, str);
                }
                if (lineCount <= 2) {
                    return RecommendItemView.this.bindingLineCount(1, str);
                }
                return true;
            }
        });
    }

    public RecommendTextLinkTouchListener getTextLinkTouchListener() {
        return this.textLinkTouchListener;
    }

    public void initView() {
        float fM1195O = C0209d.m1195O(this.myContext);
        this.fontScale = fM1195O;
        if (fM1195O >= 1.75f) {
            this.mView = LayoutInflater.from(this.myContext).inflate(R$layout.main_recommend_item_font_scale, this);
        } else {
            this.mView = LayoutInflater.from(this.myContext).inflate(R$layout.main_recommend_item, this);
        }
        this.llContent = (LinearLayout) C12809f.m76831d(this.mView, R$id.recommend_content);
        this.imageView = (HiCloudRoundRectImageView) C12809f.m76831d(this.mView, R$id.recommend_item_bg);
        this.title = (TextView) C12809f.m76831d(this.mView, R$id.recommend_title);
        this.subTitle = (TextView) C12809f.m76831d(this.mView, R$id.recommend_intrudation);
        this.recommendButton = (TextView) C12809f.m76831d(this.mView, R$id.recommend_button);
    }

    public void resetContentView() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.llContent.getLayoutParams();
        if (C12809f.m76836i(this.recommendButton)) {
            layoutParams.addRule(6, -1);
        } else {
            layoutParams.addRule(15, -1);
            this.llContent.setLayoutParams(layoutParams);
        }
    }

    public void setBackground(Bitmap bitmap, BannerPictureType bannerPictureType) {
        HiCloudRoundRectImageView hiCloudRoundRectImageView = this.imageView;
        if (hiCloudRoundRectImageView != null) {
            if (bannerPictureType == BannerPictureType.PICTURE_SECOND) {
                hiCloudRoundRectImageView.setRotationY(C11842p.m70765S0() ? 180.0f : 0.0f);
            }
            this.imageView.setImageBitmap(bitmap);
        }
    }

    public void setButton(String str) {
        TextView textView = this.recommendButton;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setButtonVisible(boolean z10) {
        TextView textView = this.recommendButton;
        if (textView != null) {
            if (z10) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void setImageViewTag(int i10) {
        this.imageView.setTag(Integer.valueOf(i10));
    }

    public void setSubTitle(String str, String str2, RecommendCard recommendCard) {
        NotifyLogger.m29915i(TAG, "setSubTitle sub: " + str + "textLink:" + str2);
        TextView textView = this.subTitle;
        if (textView == null) {
            return;
        }
        if (this.fontScale >= 1.75f) {
            textView.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            this.subTitle.setText(str);
        } else {
            SpannableString spannableString = new SpannableString(String.format("%1$s %2$s", str, str2));
            spannableString.setSpan(new RecommendLinkSpan(this.myContext, recommendCard), spannableString.length() - str2.length(), spannableString.length(), 33);
            this.subTitle.setText(spannableString);
        }
        setAutoLineCount(str2);
        this.subTitle.setVisibility(0);
    }

    public void setSubTitleVisible(boolean z10) {
        TextView textView = this.subTitle;
        if (textView != null) {
            if (!z10 || this.fontScale >= 1.75f) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
    }

    public void setTextLinkTouchListener(RecommendTextLinkTouchListener recommendTextLinkTouchListener) {
        this.textLinkTouchListener = recommendTextLinkTouchListener;
    }

    public void setTitle(String str) {
        TextView textView = this.title;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitleVisible(boolean z10) {
        TextView textView = this.title;
        if (textView != null) {
            if (z10) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        HiCloudRoundRectImageView hiCloudRoundRectImageView = this.imageView;
        if (hiCloudRoundRectImageView != null) {
            hiCloudRoundRectImageView.setImageBitmap(null);
            this.imageView.setImageDrawable(drawable);
        }
    }
}
