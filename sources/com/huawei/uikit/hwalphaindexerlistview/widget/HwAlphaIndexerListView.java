package com.huawei.uikit.hwalphaindexerlistview.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.uikit.animations.animator.HwHoverAnimationUtils;
import com.huawei.uikit.hwalphaindexerlistview.C8700R;
import com.huawei.uikit.hwalphaindexerlistview.utils.HwSectionLocaleUtils;
import com.huawei.uikit.hwcommon.utils.HwVibrateUtil;
import com.huawei.uikit.hwgraphiceffect.widget.HwShadowEngine;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes7.dex */
public class HwAlphaIndexerListView extends View {
    public static final String BULLET_CHAR = "•";
    protected static final int DEFAULT_COLLECT_LENGTH = 10;
    public static final String DIGIT_LABEL = "#";
    protected static final int HELP_ALPHABET = 2;
    protected static final int INVALID_INDEX_POSITION = -1;
    public static final int POPUP_POSITION_LEFT = 1;
    public static final int POPUP_POSITION_RIGHT = 2;
    public static final int TOO_FEW_ALPHA_COUNT = 6;

    /* renamed from: f0 */
    private static final String f41313f0 = "HwAlphaIndexerListView";

    /* renamed from: g0 */
    private static final int f41314g0 = 1;

    /* renamed from: h0 */
    private static final float f41315h0 = 2.0f;

    /* renamed from: i0 */
    private static final int f41316i0 = 26;

    /* renamed from: j0 */
    private static final int f41317j0 = 18;

    /* renamed from: k0 */
    private static final int f41318k0 = 14;

    /* renamed from: l0 */
    private static final int f41319l0 = 10;

    /* renamed from: m0 */
    private static final int f41320m0 = 2;

    /* renamed from: n0 */
    private static final long f41321n0 = 800;

    /* renamed from: A */
    private OnItemClickListener f41322A;

    /* renamed from: B */
    private PopupWindow f41323B;

    /* renamed from: C */
    private TextView f41324C;

    /* renamed from: D */
    private Drawable f41325D;

    /* renamed from: E */
    private int f41326E;

    /* renamed from: F */
    private Paint f41327F;

    /* renamed from: G */
    private Handler f41328G;

    /* renamed from: H */
    private Map<String, String> f41329H;

    /* renamed from: I */
    private boolean f41330I;

    /* renamed from: J */
    private int f41331J;

    /* renamed from: K */
    private Drawable f41332K;

    /* renamed from: L */
    private Drawable f41333L;

    /* renamed from: M */
    private Drawable f41334M;

    /* renamed from: N */
    private int f41335N;

    /* renamed from: O */
    private boolean f41336O;

    /* renamed from: P */
    private boolean f41337P;

    /* renamed from: Q */
    private int f41338Q;

    /* renamed from: R */
    private int f41339R;

    /* renamed from: S */
    private int f41340S;

    /* renamed from: T */
    private akxao[] f41341T;

    /* renamed from: U */
    private int f41342U;

    /* renamed from: V */
    private int f41343V;

    /* renamed from: W */
    private int f41344W;

    /* renamed from: a */
    Runnable f41345a;

    /* renamed from: a0 */
    private Paint f41346a0;

    /* renamed from: b */
    private int f41347b;

    /* renamed from: b0 */
    private int f41348b0;

    /* renamed from: c */
    private String[] f41349c;

    /* renamed from: c0 */
    private boolean f41350c0;

    /* renamed from: d */
    private String[] f41351d;

    /* renamed from: d0 */
    private ValueAnimator f41352d0;

    /* renamed from: e */
    private String f41353e;

    /* renamed from: e0 */
    private boolean f41354e0;

    /* renamed from: f */
    private String f41355f;

    /* renamed from: g */
    private String f41356g;

    /* renamed from: h */
    private String f41357h;

    /* renamed from: i */
    private String f41358i;

    /* renamed from: j */
    private List<String> f41359j;

    /* renamed from: k */
    private int f41360k;

    /* renamed from: l */
    private int f41361l;

    /* renamed from: m */
    private int f41362m;
    protected List<String> mAlphabets;
    protected int mBottomGap;
    protected int mGapBetweenAlpha;
    protected ListView mListView;
    protected float mOffset;
    protected int mPopupGravity;
    protected int mPopupY;
    protected int mTopGap;

    /* renamed from: n */
    private int f41363n;

    /* renamed from: o */
    private int f41364o;

    /* renamed from: p */
    private int f41365p;

    /* renamed from: q */
    private int f41366q;

    /* renamed from: r */
    private float f41367r;

    /* renamed from: s */
    private float f41368s;

    /* renamed from: t */
    private boolean f41369t;

    /* renamed from: u */
    private boolean f41370u;

    /* renamed from: v */
    private boolean f41371v;

    /* renamed from: w */
    private boolean f41372w;

    /* renamed from: x */
    private boolean f41373x;

    /* renamed from: y */
    private boolean f41374y;

    /* renamed from: z */
    private Context f41375z;

    public interface OnItemClickListener {
        void onItemClick(String str, int i10);
    }

    public class aauaf implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ int f41376a;

        public aauaf(int i10) {
            this.f41376a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HwAlphaIndexerListView.this.f41341T[this.f41376a].f41378a = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            HwAlphaIndexerListView.this.invalidate();
        }
    }

    public class avpbg extends View.AccessibilityDelegate {
        private avpbg() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (view == null || accessibilityEvent == null) {
                return;
            }
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            if (HwAlphaIndexerListView.this.f41356g == null) {
                return;
            }
            String str = (String) HwAlphaIndexerListView.this.f41329H.get(HwAlphaIndexerListView.this.f41356g);
            accessibilityEvent.getText().add(HwAlphaIndexerListView.this.f41356g);
            accessibilityEvent.setContentDescription(str);
        }

        public /* synthetic */ avpbg(HwAlphaIndexerListView hwAlphaIndexerListView, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bqmxo implements ValueAnimator.AnimatorUpdateListener {
        public bqmxo() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HwAlphaIndexerListView.this.f41348b0 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            HwAlphaIndexerListView.this.invalidate();
        }
    }

    public class bzrwd implements Runnable {
        public bzrwd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HwAlphaIndexerListView.this.f41323B != null) {
                HwAlphaIndexerListView.this.f41323B.dismiss();
            }
        }
    }

    public HwAlphaIndexerListView(Context context) {
        this(context, null);
    }

    private int getHighlightPos() {
        if (this.f41356g == null) {
            return -1;
        }
        int size = this.mAlphabets.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (equalsChar(this.mAlphabets.get(i10), this.f41356g, i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getSizeNum() {
        int i10;
        if (this.mGapBetweenAlpha == 0) {
            return 0;
        }
        int paddingBottom = (((this.f41362m - (this.f41347b * 2)) - getPaddingBottom()) - getPaddingTop()) / this.mGapBetweenAlpha;
        int i11 = 1;
        int iFloor = (int) Math.floor(this.f41369t ? paddingBottom - 2 : paddingBottom - 1);
        if (iFloor >= 26) {
            return iFloor;
        }
        int[] iArr = {26, 18, 14, 10, 6};
        while (true) {
            if (i11 < 5) {
                if (iFloor < iArr[i11 - 1] && iFloor >= (i10 = iArr[i11])) {
                    iFloor = i10;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        if (iFloor > 6) {
            return iFloor;
        }
        return 6;
    }

    public static HwAlphaIndexerListView instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwAlphaIndexerListView.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwAlphaIndexerListView.class);
        if (objInstantiate instanceof HwAlphaIndexerListView) {
            return (HwAlphaIndexerListView) objInstantiate;
        }
        return null;
    }

    public void actionDown(MotionEvent motionEvent, int i10) {
        if (i10 >= 0 && i10 < this.mAlphabets.size()) {
            m53953b(i10);
        }
        if (isHapticFeedbackEnabled()) {
            this.f41368s = motionEvent.getY();
        }
    }

    public void actionMove(MotionEvent motionEvent, int i10) {
        if (i10 < 0 || i10 >= this.mAlphabets.size()) {
            return;
        }
        m53953b(i10);
        if (isHapticFeedbackEnabled()) {
            String str = this.f41357h;
            if (str == null || !str.equals(this.f41358i)) {
                HwVibrateUtil.vibrator(this, 7, 0);
                this.f41357h = this.f41358i;
            }
        }
    }

    public void actionUp(MotionEvent motionEvent, int i10) {
        dismissPopup();
        this.f41361l = -1;
        invalidate();
    }

    public void buildIndexer(boolean z10, boolean z11) {
        String[] strArr = (String[]) HwAlphaIndexResourceManager.getInstance().getPortraitDisplayAlphaIndex().toArray(new String[0]);
        String[] strArrM53950a = m53950a(strArr);
        String[] strArr2 = (String[]) HwAlphaIndexResourceManager.getInstance().getLandscapeDisplayAlphaIndex().toArray(new String[0]);
        int sizeNum = getSizeNum();
        if (this.f41369t) {
            m53948a(z10, z11, sizeNum, strArr, strArr2);
        } else {
            if (sizeNum >= 26 && z10 && !this.f41330I) {
                strArrM53950a = strArr2;
            } else if (strArrM53950a.length > sizeNum) {
                strArrM53950a = (String[]) m53940a(HwAlphaIndexResourceManager.populateBulletAlphaIndex(sizeNum, Arrays.asList(strArrM53950a))).toArray(new String[0]);
            }
            int length = strArrM53950a.length;
            String[] strArr3 = new String[length + 1];
            this.f41351d = strArr3;
            if (z11) {
                strArr3[length] = "#";
                System.arraycopy(strArrM53950a, 0, strArr3, 0, strArrM53950a.length);
            } else {
                strArr3[0] = "#";
                System.arraycopy(strArrM53950a, 0, strArr3, 1, strArrM53950a.length);
            }
        }
        if (!this.f41369t || this.f41370u) {
            this.mAlphabets = new ArrayList(Arrays.asList(this.f41351d));
        } else {
            this.mAlphabets = new ArrayList(Arrays.asList(this.f41349c));
        }
        this.f41371v = z10;
        m53952b();
        invalidate();
    }

    public void dismissPopup() {
        if (this.f41374y) {
            this.f41328G.postDelayed(this.f41345a, f41321n0);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        float y10 = motionEvent.getY();
        boolean z10 = ((float) this.mTopGap) > y10 || ((float) (getHeight() - this.mBottomGap)) < y10;
        if ((action == 0 || action == 2) && z10) {
            return true;
        }
        int iM53934a = m53934a(y10);
        if (action == 0) {
            actionDown(motionEvent, iM53934a);
        } else if (action == 1) {
            actionUp(motionEvent, iM53934a);
        } else if (action == 2) {
            actionMove(motionEvent, iM53934a);
        } else if (action == 3) {
            dismissPopup();
            return false;
        }
        return true;
    }

    public void drawBackground(Canvas canvas, int i10, int i11, int i12, int i13) {
        if (i10 == i11) {
            this.f41327F.setColor(this.f41365p);
            this.f41327F.setTypeface(Typeface.create(getResources().getString(C8700R.string.hwalphaindexerlistview_text_medium), 0));
            if (isFocused() && hasWindowFocus()) {
                m53946a(canvas, this.f41333L, i12, i13);
            } else {
                m53946a(canvas, this.f41334M, i12, i13);
            }
        }
        int i14 = this.f41331J;
        if (i14 == i10 && i14 != i11) {
            this.f41327F.setTypeface(Typeface.create(getResources().getString(C8700R.string.hwalphaindexerlistview_text_medium), 0));
        }
        if (i10 != i11) {
            drawHoveredItemBackground(i10, canvas, i12, i13);
        }
    }

    public void drawHoveredBackground(Canvas canvas, int i10, int i11) {
        Drawable drawable = this.f41332K;
        if (drawable == null || this.f41348b0 == 0) {
            return;
        }
        int i12 = this.f41347b;
        int i13 = this.mTopGap;
        int i14 = this.mGapBetweenAlpha;
        drawable.setBounds(i11 - i12, i13 - i12, i11 + i14 + i12, i13 + (i10 * i14) + i12);
        this.f41332K.setAlpha(this.f41348b0);
        this.f41332K.draw(canvas);
    }

    public void drawHoveredItemBackground(int i10, Canvas canvas, int i11, int i12) {
        int i13;
        akxao[] akxaoVarArr = this.f41341T;
        if (akxaoVarArr == null || i10 >= akxaoVarArr.length || (i13 = akxaoVarArr[i10].f41378a) == 0) {
            return;
        }
        this.f41346a0.setAlpha(i13);
        int i14 = this.mGapBetweenAlpha;
        RectF rectF = new RectF(i11, i12, i11 + i14, i12 + i14);
        float f10 = this.f41342U;
        canvas.drawRoundRect(rectF, f10, f10, this.f41346a0);
    }

    public boolean equalsChar(String str, String str2) {
        if (str == null || str2 == null) {
            Log.w(f41313f0, "equalsChar: indexer or section is null!");
            return false;
        }
        if (str.length() != str2.length()) {
            return false;
        }
        Collator collator = Collator.getInstance();
        collator.setStrength(0);
        return collator.equals(str, str2);
    }

    public Drawable getFocusDrawable() {
        return this.f41333L;
    }

    public int getGravity() {
        return this.f41335N;
    }

    public boolean getLabelShadowClip() {
        return this.f41337P;
    }

    public int getLabelShadowColor() {
        return this.f41340S;
    }

    public int getLabelShadowSize() {
        return this.f41339R;
    }

    public int getLabelShadowStyle() {
        return this.f41338Q;
    }

    public int getPopupGravity() {
        return this.mPopupGravity;
    }

    public int getPopupPosition() {
        return this.f41326E;
    }

    public Drawable getPopupWindowBgDrawable() {
        return this.f41325D;
    }

    public int getPopupY() {
        return this.mPopupY;
    }

    public int getPositionBySection(String str) {
        if (str == null) {
            return -1;
        }
        int size = this.mAlphabets.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (equalsChar(this.mAlphabets.get(i10), str, i10)) {
                return i10;
            }
        }
        return -1;
    }

    public Object[] getSections() {
        ListView listView = this.mListView;
        if (listView != null) {
            ListAdapter adapter = listView.getAdapter();
            if (adapter instanceof HwSortedTextListAdapter) {
                return ((HwSortedTextListAdapter) adapter).getSections();
            }
        }
        return new String[0];
    }

    public Drawable getSelectedDrawable() {
        return this.f41334M;
    }

    public boolean hasNativeIndexer() {
        return this.f41369t;
    }

    public boolean ifShowPopup() {
        return this.f41374y;
    }

    public boolean isLabelShadowEnabled() {
        return this.f41336O;
    }

    public boolean isListViewScroll() {
        return this.f41354e0;
    }

    public boolean isNativeIndexerShow() {
        return this.f41370u;
    }

    public boolean isSupportCompactMode() {
        return this.f41330I;
    }

    public boolean needSwitchIndexer(int i10) {
        if (!this.f41369t) {
            return false;
        }
        if (i10 != this.f41360k || this.f41370u) {
            return i10 == (this.f41373x ? this.mAlphabets.size() + (-2) : this.mAlphabets.size() - 1) && this.f41370u;
        }
        return true;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PopupWindow popupWindow = this.f41323B;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            Log.w(f41313f0, "onDraw: canvas is null!");
            return;
        }
        super.onDraw(canvas);
        m53941a();
        int size = this.mAlphabets.size();
        int highlightPos = this.f41361l;
        if (highlightPos == -1) {
            highlightPos = getHighlightPos();
        }
        int width = (int) ((getWidth() - this.mGapBetweenAlpha) / 2.0f);
        drawHoveredBackground(canvas, size, width);
        for (int i10 = 0; i10 < size; i10++) {
            this.f41327F.setColor(this.f41364o);
            this.f41327F.setTypeface(Typeface.create(getResources().getString(C8700R.string.hwalphaindexerlistview_text_regular), 0));
            int i11 = (this.mGapBetweenAlpha * i10) + this.mTopGap;
            drawBackground(canvas, i10, highlightPos, width, i11);
            String strReplace = this.mAlphabets.get(i10).replace("劃", "");
            float fMeasureText = width + ((this.mGapBetweenAlpha - this.f41327F.measureText(strReplace)) / 2.0f);
            Paint.FontMetrics fontMetrics = this.f41327F.getFontMetrics();
            float f10 = (fontMetrics.ascent + fontMetrics.descent) / 2.0f;
            this.mOffset = f10;
            canvas.drawText(strReplace, fMeasureText, (i11 + (this.mGapBetweenAlpha / 2.0f)) - f10, this.f41327F);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            m53942a(m53934a(motionEvent.getY()));
        } else if (action == 10) {
            m53942a(-1);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (keyEvent == null || this.mAlphabets == null || this.mListView == null) {
            return false;
        }
        Object[] sections = getSections();
        if (!(sections instanceof String[])) {
            return false;
        }
        String[] strArr = (String[]) sections;
        int highlightPos = this.f41361l;
        if (highlightPos == -1) {
            highlightPos = getHighlightPos();
        }
        if (i10 == 19) {
            m53953b(m53951b(strArr, highlightPos));
        } else if (i10 == 20) {
            m53953b(m53937a(strArr, highlightPos));
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 == 20 || i10 == 19) {
            dismissPopup();
            this.f41361l = -1;
            invalidate();
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            size = this.f41363n;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f41362m = getMeasuredHeight();
        buildIndexer(this.f41371v, this.f41373x);
    }

    public void setFocusDrawable(Drawable drawable) {
        this.f41333L = drawable;
    }

    public void setGravity(int i10) {
        this.f41335N = i10;
    }

    public void setInactiveAlphaColor(int i10) {
        this.f41364o = i10;
    }

    public void setIsListViewScroll(boolean z10) {
        this.f41354e0 = z10;
    }

    public void setLabelShadowClip(boolean z10) {
        this.f41337P = z10;
    }

    public void setLabelShadowColor(int i10) {
        this.f41340S = i10;
    }

    public void setLabelShadowEnabled(boolean z10) {
        this.f41336O = z10;
    }

    public void setLabelShadowSize(int i10) {
        this.f41339R = i10;
    }

    public void setLabelShadowStyle(int i10) {
        this.f41338Q = i10;
    }

    public void setListViewAttachTo(ListView listView) {
        this.mListView = listView;
        if (listView == null || this.f41372w) {
            return;
        }
        ListAdapter adapter = listView.getAdapter();
        if (adapter instanceof HwSortedTextListAdapter) {
            this.f41373x = ((HwSortedTextListAdapter) adapter).isDigitLast();
        }
        buildIndexer(this.f41371v, this.f41373x);
        this.f41372w = true;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f41322A = onItemClickListener;
    }

    public void setOverLayInfo(String str) throws Resources.NotFoundException {
        if (str == null) {
            Log.w(f41313f0, "setOverLayInfo: sectionName is null!");
            return;
        }
        if ("".equals(str)) {
            this.f41356g = SplitAppUtil.SPLIT_APP_SUFFIX;
            return;
        }
        if (str.equals(this.f41356g)) {
            this.f41356g = str;
        } else {
            this.f41356g = str;
            sendAccessibilityEvent(16384);
        }
        m53959d();
    }

    public void setPopupGravity(int i10) {
        this.mPopupGravity = i10;
    }

    public void setPopupPosition(int i10) {
        this.f41326E = i10;
    }

    public void setPopupTextColor(int i10) {
        this.f41366q = i10;
    }

    public void setPopupWindowBgDrawable(Drawable drawable) {
        this.f41325D = drawable;
    }

    public void setPopupY(int i10) {
        this.mPopupY = i10;
    }

    public void setSectionText(String str) throws Resources.NotFoundException {
        if (str == null) {
            Log.w(f41313f0, "setSectionText: sectionName is null!");
        } else if ("".equals(str)) {
            this.f41356g = SplitAppUtil.SPLIT_APP_SUFFIX;
        } else {
            this.f41356g = str;
            m53959d();
        }
    }

    public void setSelectedAlphaColor(int i10) {
        this.f41365p = i10;
    }

    public void setSelectedDrawable(Drawable drawable) {
        this.f41334M = drawable;
    }

    public void setShowPopup(boolean z10) {
        this.f41374y = z10;
    }

    public void setSupportCompactMode(boolean z10) {
        this.f41330I = z10;
    }

    public void showPopup() throws Resources.NotFoundException {
        showPopup(this.f41356g);
    }

    public class akxao {

        /* renamed from: a */
        int f41378a;

        /* renamed from: b */
        ValueAnimator f41379b;

        private akxao() {
            this.f41378a = 0;
        }

        public /* synthetic */ akxao(HwAlphaIndexerListView hwAlphaIndexerListView, bzrwd bzrwdVar) {
            this();
        }
    }

    public HwAlphaIndexerListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8700R.attr.hwAlphaIndexerListViewStyle);
    }

    /* renamed from: b */
    private void m53952b() {
        int size = this.mAlphabets.size();
        this.f41341T = new akxao[size];
        for (int i10 = 0; i10 < size; i10++) {
            this.f41341T[i10] = new akxao(this, null);
        }
    }

    /* renamed from: c */
    private void m53956c(int i10) {
        List<String> list;
        if (this.f41332K == null || (list = this.mAlphabets) == null) {
            return;
        }
        boolean z10 = i10 >= 0 && i10 < list.size();
        if (z10 != this.f41350c0) {
            ValueAnimator valueAnimator = this.f41352d0;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f41352d0.cancel();
            }
            this.f41350c0 = z10;
            ValueAnimator alphaAnimator = HwHoverAnimationUtils.getAlphaAnimator(this.f41348b0, !z10);
            this.f41352d0 = alphaAnimator;
            alphaAnimator.addUpdateListener(new bqmxo());
            this.f41352d0.start();
        }
    }

    /* renamed from: d */
    private void m53959d() throws Resources.NotFoundException {
        if (this.f41369t) {
            if (m53957c()) {
                if (this.f41370u) {
                    return;
                }
                m53947a(false);
            } else if (this.f41370u) {
                m53947a(true);
            }
        }
    }

    public void showPopup(String str) throws Resources.NotFoundException {
        this.f41357h = this.f41358i;
        this.f41358i = str;
        if (this.f41374y) {
            this.f41328G.removeCallbacks(this.f41345a);
            int dimensionPixelSize = getResources().getDimensionPixelSize(C8700R.dimen.hwalphaindexerlistview_popup_height);
            if (this.f41323B == null) {
                TextView textView = new TextView(getContext());
                this.f41324C = textView;
                textView.setTextSize(0, getResources().getDimensionPixelSize(C8700R.dimen.hwalphaindexerlistview_popup_text_size));
                Drawable drawable = this.f41325D;
                if (drawable != null) {
                    this.f41324C.setBackground(drawable);
                }
                this.f41324C.setTextColor(this.f41366q);
                this.f41324C.setTypeface(Typeface.create(getResources().getString(C8700R.string.hwalphaindexerlistview_text_medium), 0));
                this.f41324C.setGravity(17);
                PopupWindow popupWindow = new PopupWindow(this.f41324C, dimensionPixelSize, dimensionPixelSize);
                this.f41323B = popupWindow;
                popupWindow.setAnimationStyle(C8700R.style.Animation_Emui_HwAlphaIndexerListView_PopupWindow);
                HwShadowEngine hwShadowEngine = new HwShadowEngine(this.f41375z, this.f41324C, this.f41339R, this.f41338Q);
                hwShadowEngine.setShadowEnabled(this.f41336O);
                this.f41324C.setOutlineSpotShadowColor(this.f41340S);
                hwShadowEngine.setInsideShadowClip(this.f41337P);
            }
            int i10 = this.f41361l;
            boolean z10 = i10 == -1 && str != null;
            boolean z11 = i10 != -1 && i10 < this.mAlphabets.size() && equalsChar(this.mAlphabets.get(this.f41361l), str, this.f41361l);
            if (z10 || z11) {
                this.f41324C.setText(str);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(C8700R.dimen.hwalphaindexerlistview_popup_horizontal_offset);
                int[] iArr = new int[2];
                getLocationInWindow(iArr);
                int i11 = iArr[0];
                this.f41323B.showAtLocation(getRootView(), getPopupGravity(), m53935a(dimensionPixelSize, dimensionPixelSize2, i11, this.f41363n + i11), getPopupY());
            }
        }
    }

    public HwAlphaIndexerListView(Context context, AttributeSet attributeSet, int i10) {
        super(m53938a(context, i10), attributeSet, i10);
        this.mAlphabets = new ArrayList(10);
        this.mOffset = 0.0f;
        this.mPopupGravity = 8388627;
        this.mPopupY = 0;
        this.f41345a = new bzrwd();
        this.f41353e = "A";
        this.f41355f = "Z";
        this.f41359j = new ArrayList(10);
        this.f41360k = -1;
        this.f41361l = -1;
        this.f41366q = -1;
        this.f41368s = 0.0f;
        this.f41371v = false;
        this.f41372w = false;
        this.f41373x = false;
        this.f41374y = true;
        this.f41327F = new Paint();
        this.f41328G = new Handler();
        this.f41329H = new HashMap();
        this.f41331J = -1;
        this.f41343V = 0;
        this.f41344W = 0;
        this.f41346a0 = new Paint();
        this.f41348b0 = 0;
        this.f41350c0 = false;
        m53945a(super.getContext(), attributeSet, i10);
        setDefaultFocusHighlightEnabled(false);
    }

    /* renamed from: a */
    private static Context m53938a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8700R.style.Theme_Emui_HwAlphaIndexerListView);
    }

    /* renamed from: a */
    private void m53945a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8700R.styleable.HwAlphaIndexerListView, i10, C8700R.style.Widget_Emui_HwAlphaIndexerListView);
        this.f41366q = typedArrayObtainStyledAttributes.getColor(C8700R.styleable.HwAlphaIndexerListView_hwPopupTextColor, -16777216);
        this.f41325D = typedArrayObtainStyledAttributes.getDrawable(C8700R.styleable.HwAlphaIndexerListView_hwPopupBgDrawable);
        this.f41326E = typedArrayObtainStyledAttributes.getInt(C8700R.styleable.HwAlphaIndexerListView_hwPopupPosition, 1);
        this.f41364o = typedArrayObtainStyledAttributes.getColor(C8700R.styleable.HwAlphaIndexerListView_hwInactiveAlphaColor, -16777216);
        this.f41365p = typedArrayObtainStyledAttributes.getColor(C8700R.styleable.HwAlphaIndexerListView_hwSelectedAlphaColor, -16776961);
        this.f41332K = typedArrayObtainStyledAttributes.getDrawable(C8700R.styleable.HwAlphaIndexerListView_hwHoveredBgDrawable);
        this.f41333L = typedArrayObtainStyledAttributes.getDrawable(C8700R.styleable.HwAlphaIndexerListView_hwFocusedDrawable);
        this.f41334M = typedArrayObtainStyledAttributes.getDrawable(C8700R.styleable.HwAlphaIndexerListView_hwSelectedDrawable);
        this.f41330I = typedArrayObtainStyledAttributes.getBoolean(C8700R.styleable.HwAlphaIndexerListView_hwSupportCompactMode, false);
        this.f41335N = typedArrayObtainStyledAttributes.getInt(C8700R.styleable.HwAlphaIndexerListView_android_gravity, 17);
        this.f41336O = typedArrayObtainStyledAttributes.getBoolean(C8700R.styleable.HwAlphaIndexerListView_hwLabelShadowEnabled, false);
        this.f41338Q = typedArrayObtainStyledAttributes.getInt(C8700R.styleable.HwAlphaIndexerListView_hwWidgetStyle, 0);
        this.f41339R = typedArrayObtainStyledAttributes.getInt(C8700R.styleable.HwAlphaIndexerListView_hwLabelShadowSize, 3);
        this.f41340S = typedArrayObtainStyledAttributes.getColor(C8700R.styleable.HwAlphaIndexerListView_hwLabelShadowColor, -16777216);
        int color = typedArrayObtainStyledAttributes.getColor(C8700R.styleable.HwAlphaIndexerListView_hwHoveredDrawableColor, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f41346a0.setColor(color);
        this.f41343V = Color.alpha(color);
        try {
            this.f41342U = getResources().getDimensionPixelSize(C8700R.dimen.hwalphaindexerlistview_text_bg_radius);
        } catch (Resources.NotFoundException unused) {
            Log.d(f41313f0, "initHoverStatus: resource radius not found");
        }
        this.f41375z = context;
        Resources resources = context.getResources();
        this.f41369t = HwSectionLocaleUtils.getInstance().getBucketIndex(this.f41353e) != 1;
        this.f41371v = resources.getConfiguration().orientation == 2;
        this.f41347b = resources.getDimensionPixelSize(C8700R.dimen.hwalphaindexerlistview_less_bottom_gap);
        this.f41363n = resources.getDimensionPixelSize(C8700R.dimen.hwalphaindexerlistview_view_width);
        this.mGapBetweenAlpha = resources.getDimensionPixelSize(C8700R.dimen.hwalphaindexerlistview_text_gap);
        this.f41367r = resources.getDimensionPixelSize(C8700R.dimen.hwalphaindexerlistview_text_size);
        this.f41327F.setAntiAlias(true);
        this.f41327F.setTextSize(this.f41367r);
        setContentDescription(getContext().getResources().getString(C8700R.string.hwalphaindexerlistview_label));
        setAccessibilityDelegate(new avpbg(this, null));
        for (String str : HwAlphaIndexResourceManager.getRootPortraitDisplayAlphaIndex()) {
            this.f41329H.put(str, str.toLowerCase(Locale.ENGLISH));
        }
    }

    /* renamed from: b */
    private int m53951b(String[] strArr, int i10) {
        int i11;
        if (i10 == -1) {
            return -1;
        }
        for (int i12 = 1; i12 <= i10; i12++) {
            for (int length = strArr.length - 1; length >= 0; length--) {
                int i13 = i10 - i12;
                if (this.mAlphabets.get(i13).equals(strArr[length])) {
                    return i13;
                }
                if (BULLET_CHAR.equals(this.mAlphabets.get(i13)) && i13 - 1 >= 0 && this.mAlphabets.get(i11).compareTo(strArr[length]) < 0 && this.mAlphabets.get(i13 + 1).compareTo(strArr[length]) > 0) {
                    return i13;
                }
            }
        }
        return -1;
    }

    public boolean equalsChar(String str, String str2, int i10) {
        boolean z10 = str == null || str2 == null;
        boolean z11 = i10 < 0 || i10 >= this.mAlphabets.size();
        if (!z10 && !z11) {
            if (!str.equals(BULLET_CHAR)) {
                return equalsChar(str, str2);
            }
            this.f41359j.clear();
            if (!this.f41373x) {
                this.f41359j.add("#");
            }
            List<String> portraitCompleteAlphaIndex = HwAlphaIndexResourceManager.getInstance().getPortraitCompleteAlphaIndex();
            List<String> rootPortraitDisplayAlphaIndex = HwAlphaIndexResourceManager.getRootPortraitDisplayAlphaIndex();
            List<String> landscapeCompleteAlphaIndex = HwAlphaIndexResourceManager.getInstance().getLandscapeCompleteAlphaIndex();
            int sizeNum = getSizeNum();
            if (this.f41369t) {
                m53944a(sizeNum, portraitCompleteAlphaIndex, rootPortraitDisplayAlphaIndex, landscapeCompleteAlphaIndex);
            } else if ((sizeNum >= 26 && this.f41371v) || sizeNum == 18) {
                this.f41359j.addAll(landscapeCompleteAlphaIndex);
            } else {
                this.f41359j.addAll(HwAlphaIndexResourceManager.populateBulletAlphaIndex(sizeNum, portraitCompleteAlphaIndex));
            }
            if (this.f41373x) {
                this.f41359j.add("#");
            }
            for (String str3 : this.f41359j.get(i10).split(" ")) {
                if (equalsChar(str3, str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setOverLayInfo(int i10, String str) throws Resources.NotFoundException {
        this.f41361l = i10;
        setOverLayInfo(str);
    }

    /* renamed from: b */
    private void m53953b(int i10) {
        List<String> list;
        if (this.f41322A == null || (list = this.mAlphabets) == null || i10 < 0 || i10 >= list.size()) {
            return;
        }
        this.f41322A.onItemClick(this.mAlphabets.get(i10), i10);
        invalidate();
    }

    /* renamed from: c */
    private boolean m53957c() {
        if (this.f41356g == null) {
            return false;
        }
        Object[] sections = getSections();
        String str = this.f41356g;
        if (sections != null && "#".equals(str)) {
            if (this.f41373x) {
                return false;
            }
            if (sections.length > 1) {
                Object obj = sections[1];
                if (obj instanceof String) {
                    str = (String) obj;
                }
            }
        }
        return Collator.getInstance().compare(str, this.f41353e) < 0;
    }

    /* renamed from: a */
    private void m53948a(boolean z10, boolean z11, int i10, String[] strArr, String[] strArr2) {
        String[] strArr3 = (String[]) HwAlphaIndexResourceManager.getRootLandscapeDisplayAlphaIndex().toArray(new String[0]);
        String[] strArr4 = (String[]) HwAlphaIndexResourceManager.getRootPortraitDisplayAlphaIndex().toArray(new String[0]);
        String[] strArrM53950a = m53950a(strArr);
        String[] strArrM53950a2 = m53950a(strArr4);
        if (i10 < 26 || !z10 || this.f41330I) {
            List<String> listPopulateBulletAlphaIndex = HwAlphaIndexResourceManager.populateBulletAlphaIndex(i10, Arrays.asList(strArrM53950a));
            List<String> listPopulateBulletAlphaIndex2 = HwAlphaIndexResourceManager.populateBulletAlphaIndex(i10, Arrays.asList(strArrM53950a2));
            String[] strArr5 = (String[]) m53940a(listPopulateBulletAlphaIndex).toArray(new String[0]);
            strArr3 = (String[]) m53940a(listPopulateBulletAlphaIndex2).toArray(new String[0]);
            strArr2 = i10 >= strArrM53950a.length ? strArrM53950a : strArr5;
            if (i10 >= strArrM53950a2.length) {
                strArr3 = strArrM53950a2;
            }
        }
        m53949a(z11, strArr, strArr2, strArr3);
    }

    /* renamed from: a */
    private void m53949a(boolean z10, String[] strArr, String[] strArr2, String[] strArr3) {
        int length = strArr2.length;
        String[] strArr4 = new String[length + 2];
        this.f41351d = strArr4;
        int length2 = strArr3.length;
        String[] strArr5 = new String[length2 + 2];
        this.f41349c = strArr5;
        if (z10) {
            strArr4[length + 1] = "#";
            strArr5[length2 + 1] = "#";
            System.arraycopy(strArr2, 0, strArr4, 0, strArr2.length);
            this.f41360k = 0;
            String[] strArr6 = this.f41349c;
            strArr6[0] = strArr[0];
            System.arraycopy(strArr3, 0, strArr6, 1, strArr3.length);
            String[] strArr7 = this.f41351d;
            int length3 = strArr7.length - 2;
            String[] strArr8 = this.f41349c;
            strArr7[length3] = strArr8[strArr8.length - 2];
            return;
        }
        strArr4[0] = "#";
        strArr5[0] = "#";
        System.arraycopy(strArr2, 0, strArr4, 1, strArr2.length);
        this.f41360k = 1;
        String[] strArr9 = this.f41349c;
        strArr9[1] = strArr[0];
        System.arraycopy(strArr3, 0, strArr9, 2, strArr3.length);
        String[] strArr10 = this.f41351d;
        int length4 = strArr10.length - 1;
        String[] strArr11 = this.f41349c;
        strArr10[length4] = strArr11[strArr11.length - 1];
    }

    /* renamed from: a */
    private String[] m53950a(String[] strArr) {
        Object[] sections = getSections();
        if (!this.f41330I || !(sections instanceof String[])) {
            return strArr;
        }
        String[] strArr2 = (String[]) sections;
        ArrayList arrayList = new ArrayList(10);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            for (String str : strArr2) {
                if (strArr[i10].equals(str)) {
                    arrayList.add(strArr[i10]);
                }
            }
        }
        return arrayList.size() > 0 ? (String[]) arrayList.toArray(new String[0]) : strArr;
    }

    /* renamed from: a */
    private List<String> m53940a(List<String> list) {
        ArrayList arrayList = new ArrayList(10);
        for (String str : list) {
            if (str.split(" ").length > 1) {
                arrayList.add(BULLET_CHAR);
            } else {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m53946a(Canvas canvas, Drawable drawable, int i10, int i11) {
        if (drawable != null) {
            if (HwWidgetInstantiator.getCurrnetType(this.f41375z) == 4) {
                if (isListViewScroll()) {
                    dismissPopup();
                    this.f41361l = -1;
                    this.f41356g = null;
                    this.f41327F.setColor(this.f41364o);
                    this.f41327F.setTypeface(Typeface.create(getResources().getString(C8700R.string.hwalphaindexerlistview_text_regular), 0));
                    return;
                }
                int i12 = this.mGapBetweenAlpha;
                drawable.setBounds(i10, i11, i10 + i12, i12 + i11);
                drawable.draw(canvas);
                this.f41327F.setColor(this.f41365p);
                this.f41327F.setTypeface(Typeface.create(getResources().getString(C8700R.string.hwalphaindexerlistview_text_medium), 0));
                return;
            }
            int i13 = this.mGapBetweenAlpha;
            drawable.setBounds(i10, i11, i10 + i13, i13 + i11);
            drawable.draw(canvas);
        }
    }

    /* renamed from: a */
    private void m53941a() {
        int size = this.mAlphabets.size();
        int i10 = this.f41362m;
        int i11 = size * this.mGapBetweenAlpha;
        if (i10 <= i11) {
            int i12 = this.f41347b;
            this.mTopGap = i12;
            this.mBottomGap = i12;
            return;
        }
        int i13 = this.f41335N;
        if (i13 == 48) {
            int i14 = this.f41347b;
            this.mTopGap = i14;
            this.mBottomGap = (i10 - i11) - i14;
        } else if (i13 != 80) {
            int i15 = (int) ((i10 - i11) / 2.0f);
            this.mBottomGap = i15;
            this.mTopGap = i15;
        } else {
            int i16 = this.f41347b;
            this.mBottomGap = i16;
            this.mTopGap = (i10 - i11) - i16;
        }
    }

    /* renamed from: a */
    private int m53937a(String[] strArr, int i10) {
        int i11;
        if (i10 == -1) {
            return -1;
        }
        for (int i12 = 1; i12 < this.mAlphabets.size() - i10; i12++) {
            for (int i13 = 0; i13 < strArr.length; i13++) {
                int i14 = i10 + i12;
                if (this.mAlphabets.get(i14).equals(strArr[i13])) {
                    return i14;
                }
                if (BULLET_CHAR.equals(this.mAlphabets.get(i14)) && (i11 = i14 + 1) < this.mAlphabets.size() && this.mAlphabets.get(i14 - 1).compareTo(strArr[i13]) < 0 && this.mAlphabets.get(i11).compareTo(strArr[i13]) > 0) {
                    return i14;
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    private void m53942a(int i10) {
        if (i10 != this.f41331J) {
            m53943a(i10, this.f41343V);
            m53943a(this.f41331J, this.f41344W);
            this.f41331J = i10;
            m53956c(i10);
        }
    }

    /* renamed from: a */
    private void m53943a(int i10, int i11) {
        akxao[] akxaoVarArr;
        if (i10 < 0 || i10 >= this.mAlphabets.size() || (akxaoVarArr = this.f41341T) == null || i10 >= akxaoVarArr.length) {
            return;
        }
        ValueAnimator valueAnimator = akxaoVarArr[i10].f41379b;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        ValueAnimator alphaAnimator = HwHoverAnimationUtils.getAlphaAnimator(this.f41341T[i10].f41378a, i11);
        alphaAnimator.addUpdateListener(new aauaf(i10));
        this.f41341T[i10].f41379b = alphaAnimator;
        alphaAnimator.start();
    }

    /* renamed from: a */
    private int m53934a(float f10) {
        int height = getHeight();
        int i10 = this.mTopGap;
        int i11 = (height - i10) - this.mBottomGap;
        if (i11 == 0) {
            return 0;
        }
        return (int) (((f10 - i10) * this.mAlphabets.size()) / i11);
    }

    /* renamed from: a */
    private void m53947a(boolean z10) throws Resources.NotFoundException {
        Animation animationLoadAnimation;
        this.mAlphabets.clear();
        this.mAlphabets = z10 ? new ArrayList(Arrays.asList(this.f41349c)) : new ArrayList(Arrays.asList(this.f41351d));
        this.f41370u = !z10;
        if (z10) {
            animationLoadAnimation = AnimationUtils.loadAnimation(this.f41375z, C8700R.anim.hwalphaindexerlistview_translate_bottom2top);
        } else {
            animationLoadAnimation = AnimationUtils.loadAnimation(this.f41375z, C8700R.anim.hwalphaindexerlistview_translate_top2bottom);
        }
        setAnimation(animationLoadAnimation);
        m53941a();
        startAnimation(animationLoadAnimation);
    }

    /* renamed from: a */
    private int m53935a(int i10, int i11, int i12, int i13) {
        return (getParent().getLayoutDirection() != 1 ? this.f41326E != 1 : this.f41326E == 1) ? i13 + i11 : (i12 - i11) - i10;
    }

    /* renamed from: a */
    private void m53944a(int i10, List<String> list, List<String> list2, List<String> list3) {
        if (this.f41370u) {
            if ((i10 >= 26 && this.f41371v) || i10 == 18) {
                this.f41359j.addAll(list3);
            } else {
                this.f41359j.addAll(HwAlphaIndexResourceManager.populateBulletAlphaIndex(i10, list));
            }
            this.f41359j.add(this.f41355f);
            return;
        }
        int i11 = this.f41360k;
        if (i11 >= 0) {
            String[] strArr = this.f41351d;
            if (i11 < strArr.length) {
                this.f41359j.add(strArr[i11]);
            }
        }
        if (i10 >= 26 && this.f41371v) {
            this.f41359j.addAll(HwAlphaIndexResourceManager.getRootLandscapeCompleteAlphaIndex());
        } else if (i10 == 18) {
            this.f41359j.addAll(HwAlphaIndexResourceManager.getRootLandscapeCompleteAlphaIndex());
        } else {
            this.f41359j.addAll(HwAlphaIndexResourceManager.populateBulletAlphaIndex(i10, list2));
        }
    }
}
