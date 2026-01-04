package com.huawei.uikit.hwadvancednumberpicker.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Scroller;
import android.widget.TextView;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwadvancednumberpicker.C8692R;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwFormatter;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwUtils;
import com.huawei.uikit.hwadvancednumberpicker.widget.HwAdvancedNumberPicker;
import com.huawei.uikit.hwclickanimation.anim.HwSpringBackHelper;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwcommon.utils.HwVibrateUtil;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import java.lang.reflect.Method;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes7.dex */
public class PickerHelper {
    public static final int ACCESSIBILITY_ANNOUNCE_DELAY = 100;
    public static final int ADJUST_SCROLL_CENTER_DURATION = 100;
    public static final int ADJUST_TYPE_ABSOLUTE = 0;
    public static final int ADJUST_TYPE_SMOOTH = 1;
    public static final float ALPHA_ENABLED = 1.0f;
    public static final float CONTROL_POINT_X = 0.2f;
    public static final int DISPLAY_ITEM_MAX_NUM = 7;
    public static final int DOUBLE_NUM = 2;
    public static final float DOUBLE_NUM_FLOAT = 2.0f;
    public static final int INDEX_OFFSET_ONE = 1;
    public static final float INTERPOLATOR_CONTROL_POINT_Y2 = 1.0f;
    public static final long KEEP_ALIVE_TIME = 0;
    public static final int MAX_FLING_VELOCITY_PARAM = 4;
    public static final int MINUS_ONE_NUM = -1;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final float OFFSET_ADJUST_DISTANCE_FACTOR_CAR_ONE = 10.0f;
    public static final float OFFSET_ADJUST_DISTANCE_FACTOR_CAR_TWO = 5.0f;
    public static final float OFFSET_ADJUST_DISTANCE_FACTOR_ONE = 6.0f;
    public static final float OFFSET_ADJUST_DISTANCE_FACTOR_THREE = -4.0f;
    public static final float OFFSET_ADJUST_DISTANCE_FACTOR_TWO = 1.0f;
    public static final float OFFSET_SIGN_NEGATIVE = -1.0f;
    public static final float OFFSET_SIGN_POSITIVE = 1.0f;
    public static final int PICKER_INDEX_FIVE = 5;
    public static final int PICKER_INDEX_FOUR = 4;
    public static final int PICKER_INDEX_ONE = 1;
    public static final int PICKER_INDEX_THREE = 3;
    public static final int PICKER_INDEX_TWO = 2;
    public static final int PICKER_MOUSE_SCROLL_DURATION = 5;
    public static final float PICKER_MOUSE_SCROLL_MAX_VECTORITY = 4800.0f;
    public static final int PICKER_MOUSE_SCROLL_VECTORITY = 960;
    public static final int POINTER_COUNT_SINGLE = 1;
    public static final int SCROLL_CENTER_THRESHOLD = 1;
    public static final int SELECTOR_POSITION_FIRST = 1;
    public static final float SELECTOR_SCROLL_THRESHOLD = 10.0f;
    public static final int SOUND_POOL_PRIORITY = 1;
    public static final int STEP_SCROLL_DURATION = 150;
    public static final String STRING_DRAW_END = "";
    public static final int SUPPORTED_TYPES = 15;
    public static final String TAG = "HwAdvancedNumberPicker";
    public static final float TEXT_COLOR_MAX_FRACTION = 1.0f;
    public static final float TEXT_SIZE_MAX_SCALE = 1.0f;
    public static final int THREAD_POOL_CORE_POOL_SIZE = 1;
    public static final int THREAD_POOL_MAXIMUM_POOL_SIZE = 1;
    public static final float VELOCITY_STAGE_1 = 0.1f;
    public static final float VELOCITY_STAGE_2 = 0.25f;
    public static final float VELOCITY_STAGE_3 = 0.55f;
    public static final float VELOCITY_STAGE_4 = 0.8f;

    /* renamed from: a */
    private static final float f41222a = 1.0f;

    /* renamed from: b */
    private static final int f41223b = 9;

    /* renamed from: c */
    private static final String f41224c = "%02d";

    /* renamed from: d */
    private static final int f41225d = 3;

    /* renamed from: e */
    private static final int f41226e = 0;

    /* renamed from: f */
    private static final int f41227f = 1;

    /* renamed from: g */
    private static final int f41228g = 2;

    /* renamed from: h */
    private static final int f41229h = 4;

    /* renamed from: i */
    private static final int f41230i = 5;

    /* renamed from: j */
    private static final int f41231j = 6;

    /* renamed from: k */
    private static final int f41232k = 1;

    /* renamed from: l */
    private static final int f41233l = 2;

    /* renamed from: m */
    private static final float f41234m = 0.75f;

    /* renamed from: n */
    private static final int f41235n = 1;

    /* renamed from: o */
    private static final int f41236o = 2;

    /* renamed from: p */
    private static final int f41237p = 1;

    /* renamed from: q */
    private static final int f41238q = -1;

    /* renamed from: r */
    private static final int f41239r = 500;
    public static final HwFormatter TWO_DIGIT_FORMATTER = new bzrwd();
    public static final LruCache<String, Bitmap> SELECTOR_CACHES = new LruCache<>(62);
    public static final LruCache<String, Bitmap> SECONDARY_CACHES = new LruCache<>(62);

    public class aauaf extends View.AccessibilityDelegate {

        /* renamed from: a */
        final /* synthetic */ View f41240a;

        /* renamed from: b */
        final /* synthetic */ Context f41241b;

        /* renamed from: c */
        final /* synthetic */ HwAdvancedNumberPicker f41242c;

        /* renamed from: d */
        final /* synthetic */ HashMap f41243d;

        /* renamed from: e */
        final /* synthetic */ int f41244e;

        public aauaf(View view, Context context, HwAdvancedNumberPicker hwAdvancedNumberPicker, HashMap map, int i10) {
            this.f41240a = view;
            this.f41241b = context;
            this.f41242c = hwAdvancedNumberPicker;
            this.f41243d = map;
            this.f41244e = i10;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            if (accessibilityNodeInfo == null || this.f41240a == null || view == null || view.getId() != this.f41240a.getId()) {
                return;
            }
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(true);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            HashMap map;
            if (view == null || accessibilityEvent == null || this.f41241b == null || this.f41242c == null || this.f41240a == null || (map = this.f41243d) == null || map.size() == 0) {
                return;
            }
            if (accessibilityEvent.getEventType() == 65536) {
                PickerHelper.m53916b(view, this.f41244e, this.f41243d, this.f41240a);
            } else if (accessibilityEvent.getEventType() == 32768) {
                PickerHelper.m53915b(this.f41241b, this.f41242c);
            } else {
                Log.i(PickerHelper.TAG, "nothing to do");
            }
            super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    public static class akxao {

        /* renamed from: a */
        public String f41245a;

        /* renamed from: b */
        public int f41246b;

        /* renamed from: c */
        public int f41247c;

        /* renamed from: d */
        public int f41248d;
    }

    public class bqmxo implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f41249a;

        public bqmxo(View view) {
            this.f41249a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f41249a.isAccessibilityFocused()) {
                return;
            }
            this.f41249a.sendAccessibilityEvent(8);
        }
    }

    public class bzrwd implements HwFormatter {

        /* renamed from: a */
        final StringBuffer f41250a;

        /* renamed from: b */
        final Formatter f41251b;

        /* renamed from: c */
        final Object[] f41252c;

        public bzrwd() {
            StringBuffer stringBuffer = new StringBuffer(10);
            this.f41250a = stringBuffer;
            this.f41251b = new Formatter(stringBuffer, Locale.ENGLISH);
            this.f41252c = new Object[1];
        }

        @Override // com.huawei.uikit.hwadvancednumberpicker.utils.HwFormatter
        public String format(int i10) {
            this.f41252c[0] = Integer.valueOf(i10);
            if (this.f41250a.length() > 0) {
                StringBuffer stringBuffer = this.f41250a;
                stringBuffer.delete(0, stringBuffer.length());
            }
            this.f41251b.format(PickerHelper.f41224c, this.f41252c);
            return this.f41251b.toString();
        }
    }

    private PickerHelper() {
    }

    public static void abortScrollAnimation(HwSpringBackHelper hwSpringBackHelper, HwSpringBackHelper hwSpringBackHelper2) {
        hwSpringBackHelper.abortAnimation();
        hwSpringBackHelper2.abortAnimation();
    }

    public static void adjustAccessibilityFocus(HashMap<Integer, String> map, View view, View view2) {
        if (map == null || view == null || view2 == null || map.size() <= 6) {
            return;
        }
        if (TextUtils.isEmpty(map.get(0)) && TextUtils.isEmpty(map.get(1)) && TextUtils.isEmpty(map.get(2))) {
            view.setImportantForAccessibility(2);
        } else {
            view.setImportantForAccessibility(1);
        }
        if (TextUtils.isEmpty(map.get(4)) && TextUtils.isEmpty(map.get(5)) && TextUtils.isEmpty(map.get(6))) {
            view2.setImportantForAccessibility(2);
        } else {
            view2.setImportantForAccessibility(1);
        }
    }

    public static void adjustClickAccuracy(HwSpringBackHelper hwSpringBackHelper, int i10) {
        if (Math.abs(i10) >= 1) {
            if (i10 < 0) {
                hwSpringBackHelper.springBack(0, 0, i10);
            } else {
                hwSpringBackHelper.springBack(0, i10, 0);
            }
        }
    }

    public static int autoWidth(View view, Paint paint, akxao akxaoVar, int i10) {
        int i11 = akxaoVar.f41246b;
        paint.setTextSize(i11);
        int iMeasureText = (int) paint.measureText(akxaoVar.f41245a);
        int width = ((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight()) - i10;
        while (i11 > akxaoVar.f41247c && iMeasureText > width) {
            i11 -= akxaoVar.f41248d;
            paint.setTextSize(i11);
            iMeasureText = (int) paint.measureText(akxaoVar.f41245a);
        }
        return i11;
    }

    /* renamed from: b */
    public static void m53916b(View view, int i10, HashMap<Integer, String> map, View view2) {
        int i11;
        if (view.getId() == C8692R.id.hwadvancednumberpicker_decrement) {
            i11 = i10 + 1;
        } else if (view.getId() == C8692R.id.hwadvancednumberpicker_increment) {
            i11 = i10 - 1;
        } else {
            Log.i(TAG, "nothing to do");
            i11 = -1;
        }
        if (i11 < 0 || i11 >= map.size() || !TextUtils.isEmpty(map.get(Integer.valueOf(i11)))) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(8);
        view2.onInitializeAccessibilityEvent(accessibilityEventObtain);
        ViewParent parent = view2.getParent();
        if (parent != null) {
            parent.requestSendAccessibilityEvent(view2, accessibilityEventObtain);
        }
        view2.postDelayed(new bqmxo(view2), 500L);
    }

    public static SoundPool buildSoundPool() {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setUsage(13);
        AudioAttributes audioAttributesBuild = builder.build();
        SoundPool.Builder builder2 = new SoundPool.Builder();
        builder2.setAudioAttributes(audioAttributesBuild);
        builder2.setMaxStreams(7);
        return builder2.build();
    }

    public static String[] calculateDisplayedValues(HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        int minValue = hwAdvancedNumberPicker.getMinValue();
        int maxValue = hwAdvancedNumberPicker.getMaxValue();
        if (maxValue < minValue) {
            Log.e(TAG, "error get displayed values");
            return new String[0];
        }
        int i10 = (maxValue - minValue) + 1;
        String[] strArr = new String[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = Integer.toString(i11 + minValue);
        }
        return (String[]) strArr.clone();
    }

    public static int calculateMaxTextWidth(Paint paint, String[] strArr, int i10) {
        if (strArr == null) {
            float f10 = 0.0f;
            for (int i11 = 0; i11 <= 9; i11++) {
                float fMeasureText = paint.measureText(String.valueOf(i11));
                f10 = fMeasureText > f10 ? fMeasureText : 0;
            }
            return (int) (String.valueOf(Math.abs(i10)).length() * f10);
        }
        int i12 = 0;
        for (String str : strArr) {
            int iMeasureText = (int) paint.measureText(str);
            if (iMeasureText > i12) {
                i12 = iMeasureText;
            }
        }
        return i12;
    }

    public static void computeScroller(HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        hwAdvancedNumberPicker.m53903d();
        hwAdvancedNumberPicker.m53905f();
    }

    public static boolean dispatchKeyEvent(KeyEvent keyEvent, HwAdvancedNumberPicker hwAdvancedNumberPicker, HwAdvancedNumberPicker.avpbg avpbgVar) {
        if (keyEvent == null) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 23 || keyCode == 66) {
            removeAllCallbacks(hwAdvancedNumberPicker, avpbgVar);
        } else if (keyCode == 19 && keyEvent.getAction() == 0) {
            if (hwAdvancedNumberPicker != null) {
                hwAdvancedNumberPicker.stepUp();
                return true;
            }
        } else if (keyCode != 20 || keyEvent.getAction() != 0) {
            Log.i(TAG, "No keycode match.");
        } else if (hwAdvancedNumberPicker != null) {
            hwAdvancedNumberPicker.stepDown();
            return true;
        }
        return false;
    }

    public static void dispatchTrackballEvent(MotionEvent motionEvent, HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 1) {
            hwAdvancedNumberPicker.m53901C();
        }
    }

    public static float dp2px(Context context, float f10) {
        return TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static String ellipsizeSelectorValue(HwAdvancedNumberPicker hwAdvancedNumberPicker, String str, Paint paint, boolean z10) {
        return z10 ? TextUtils.ellipsize(str, new TextPaint(paint), (hwAdvancedNumberPicker.getWidth() - hwAdvancedNumberPicker.getPaddingLeft()) - hwAdvancedNumberPicker.getPaddingRight(), TextUtils.TruncateAt.END).toString() : str;
    }

    public static String formatDisplayedValue(int i10) {
        String strValueOf = String.valueOf(i10);
        if (i10 >= 10) {
            return strValueOf;
        }
        return "0" + strValueOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String formatScrollSelectorValue(com.huawei.uikit.hwadvancednumberpicker.utils.HwFormatter r3, java.lang.String r4, boolean r5, boolean r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "HwAdvancedNumberPicker"
            if (r3 != 0) goto L3b
            int r3 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> Lf
            if (r3 == 0) goto L14
            java.lang.String r3 = com.huawei.uikit.hwadvancednumberpicker.utils.HwUtils.formatNumberWithLocale(r3)     // Catch: java.lang.NumberFormatException -> Lf
            goto L15
        Lf:
            java.lang.String r3 = "number format exception"
            android.util.Log.w(r0, r3)
        L14:
            r3 = r4
        L15:
            if (r6 == 0) goto L3a
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L3a
            boolean r5 = r4.endsWith(r7)
            if (r5 != 0) goto L3a
            java.lang.String r5 = "-- --"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L3a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
        L3a:
            return r3
        L3b:
            r1 = 0
            int r2 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L5e
            java.lang.String r4 = com.huawei.uikit.hwadvancednumberpicker.utils.HwUtils.formatNumberWithLocale(r2)     // Catch: java.lang.NumberFormatException -> L5f
            if (r6 == 0) goto L64
            if (r4 == 0) goto L64
            boolean r6 = r4.endsWith(r7)     // Catch: java.lang.NumberFormatException -> L5f
            if (r6 != 0) goto L64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L5f
            r6.<init>()     // Catch: java.lang.NumberFormatException -> L5f
            r6.append(r4)     // Catch: java.lang.NumberFormatException -> L5f
            r6.append(r7)     // Catch: java.lang.NumberFormatException -> L5f
            java.lang.String r4 = r6.toString()     // Catch: java.lang.NumberFormatException -> L5f
            goto L64
        L5e:
            r2 = r1
        L5f:
            java.lang.String r6 = "number format Exception"
            android.util.Log.w(r0, r6)
        L64:
            java.lang.String r3 = m53912a(r3, r2, r4)
            if (r5 == 0) goto L83
            int r4 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L7e
            java.lang.String r5 = "%02d"
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.NumberFormatException -> L7e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.NumberFormatException -> L7e
            r6[r1] = r4     // Catch: java.lang.NumberFormatException -> L7e
            java.lang.String r3 = java.lang.String.format(r5, r6)     // Catch: java.lang.NumberFormatException -> L7e
            goto L83
        L7e:
            java.lang.String r4 = "flag branch -> number format Exception"
            android.util.Log.w(r0, r4)
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwadvancednumberpicker.widget.PickerHelper.formatScrollSelectorValue(com.huawei.uikit.hwadvancednumberpicker.utils.HwFormatter, java.lang.String, boolean, boolean, java.lang.String):java.lang.String");
    }

    public static String formatValue(int i10, HwFormatter hwFormatter) {
        return hwFormatter != null ? hwFormatter.format(i10) : String.valueOf(i10);
    }

    public static Bitmap getBitmapFromCache(LruCache<String, Bitmap> lruCache, String str, Paint paint) {
        String str2 = str + "$" + paint.getColor() + "$" + paint.getTextSize();
        Bitmap bitmap = lruCache.get(str2);
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmapTextToBitmap = textToBitmap(str, paint);
        lruCache.put(str2, bitmapTextToBitmap);
        return bitmapTextToBitmap;
    }

    public static int getDimenInt(Context context, int i10) {
        return (int) context.getResources().getDimension(i10);
    }

    public static double getDistanceRatio(int i10, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18 = i10 * 2;
        int i19 = i10 + i11;
        int i20 = i19 - i18;
        if (i13 >= 0) {
            i17 = i19 - i12;
            int i21 = i14 - i17;
            i15 = i21 >= 0 ? i21 : 0;
            i16 = i11 - i20;
        } else {
            i14 = -i14;
            int i22 = i12 - i20;
            int i23 = i14 - i22;
            i15 = i23 >= 0 ? i23 : 0;
            i16 = i19 - i11;
            i17 = i22;
        }
        if (i18 == 0 || i14 == 0) {
            return 0.0d;
        }
        return ((((i15 / i18) * i18) + i17) + i16) / i14;
    }

    public static Drawable getDrawableByResId(Context context, int i10) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        try {
            return resources.getDrawable(i10);
        } catch (Resources.NotFoundException unused) {
            Log.w(TAG, "Get resource error.");
            return null;
        }
    }

    public static void getFocus(HwAdvancedNumberPicker hwAdvancedNumberPicker, boolean z10) {
        if (!z10 || hwAdvancedNumberPicker == null || hwAdvancedNumberPicker.isFocused()) {
            return;
        }
        hwAdvancedNumberPicker.requestFocus();
    }

    public static View.AccessibilityDelegate getFocusedStatusMonitor(Context context, HwAdvancedNumberPicker hwAdvancedNumberPicker, View view, HashMap<Integer, String> map, int i10) {
        return new aauaf(view, context, hwAdvancedNumberPicker, map, i10);
    }

    public static String getLongText(String[] strArr) {
        String str = null;
        if (strArr != null && strArr.length != 0) {
            int length = 0;
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (!TextUtils.isEmpty(strArr[i10]) && strArr[i10].length() > length) {
                    str = strArr[i10];
                    length = str.length();
                }
            }
        }
        return str;
    }

    public static float getOffsetCoordinateY(float f10, float f11, float f12, float f13, float f14) {
        return f10 + (f11 * f13 * f14) + (f12 * f41234m);
    }

    public static int getScreenWidthHeightMinValue(Context context) {
        Object systemService = context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        if (!(systemService instanceof WindowManager)) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.heightPixels;
        int i11 = displayMetrics.widthPixels;
        return i10 > i11 ? i10 : i11;
    }

    public static Paint getSecondaryWheelPaint(Context context, int i10, float f10) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        HwUtils.setTypeface(HwUtils.getRegularTypeface(context), paint);
        paint.setColor(i10);
        paint.setTextSize(f10);
        return paint;
    }

    public static Paint getSelectorWheelPaint(Context context, int i10, float f10) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        HwUtils.setTypeface(HwUtils.getMediumTypeface(context), paint);
        paint.setColor(i10);
        paint.setTextSize(f10);
        return paint;
    }

    public static float getSensitivityByMode(int i10) {
        return i10 == 0 ? 1.0f : 0.6f;
    }

    public static float getWheelAverageX(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10) {
        if (i10 == 3) {
            return 0.0f;
        }
        return i10 == 5 ? hwAdvancedNumberPicker.getWidth() : hwAdvancedNumberPicker.getWidth() / 2.0f;
    }

    public static float getWheelCanvasLeft(Bitmap bitmap, int i10, float f10, int i11) {
        float width;
        if (i10 == 3) {
            return f10 + i11;
        }
        if (i10 == 5) {
            f10 -= bitmap.getWidth();
            width = i11;
        } else {
            width = bitmap.getWidth() / 2.0f;
        }
        return f10 - width;
    }

    public static int getWrappedSelectorIndex(int i10, int i11, int i12) {
        return i11 == i12 ? i12 : i10 > i11 ? (i12 + ((i10 - i11) % (i11 - i12))) - 1 : i10 < i12 ? (i11 - ((i12 - i10) % (i11 - i12))) + 1 : i10;
    }

    public static boolean handleUpDownEvent(HwAdvancedNumberPicker hwAdvancedNumberPicker, View view, HashMap<Integer, String> map, int i10) {
        if (hwAdvancedNumberPicker != null && view != null && map != null) {
            if (view.getId() == C8692R.id.hwadvancednumberpicker_decrement) {
                int i11 = i10 + 1;
                if (i11 >= 0 && i11 < map.size() && !TextUtils.isEmpty(map.get(Integer.valueOf(i11)))) {
                    hwAdvancedNumberPicker.stepDown();
                    return true;
                }
            } else if (view.getId() == C8692R.id.hwadvancednumberpicker_increment) {
                int i12 = i10 - 1;
                if (i12 >= 0 && i12 < map.size() && !TextUtils.isEmpty(map.get(Integer.valueOf(i12)))) {
                    hwAdvancedNumberPicker.stepUp();
                    return true;
                }
            } else {
                Log.w(TAG, "nothing to do.");
            }
        }
        return false;
    }

    public static HwAdvancedNumberPicker instantiateObject(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwAdvancedNumberPicker.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwAdvancedNumberPicker.class);
        if (objInstantiate instanceof HwAdvancedNumberPicker) {
            return (HwAdvancedNumberPicker) objInstantiate;
        }
        return null;
    }

    public static void invalidateSelectorWheel(HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        if (hwAdvancedNumberPicker == null) {
            return;
        }
        SELECTOR_CACHES.evictAll();
        SECONDARY_CACHES.evictAll();
        hwAdvancedNumberPicker.invalidate();
    }

    public static boolean isAccessibilityEnabled(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("accessibility");
        if (systemService instanceof AccessibilityManager) {
            return ((AccessibilityManager) systemService).isTouchExplorationEnabled();
        }
        return false;
    }

    public static boolean isAdjustScrollerInThreshold(int i10, int i11) {
        return Math.abs(i10 - i11) <= 1;
    }

    public static boolean isFinishedScroller(HwSpringBackHelper hwSpringBackHelper, HwSpringBackHelper hwSpringBackHelper2) {
        return hwSpringBackHelper.isFinished() && hwSpringBackHelper2.isFinished();
    }

    public static boolean isMultiTouchCenterArea(Context context, HwAdvancedNumberPicker hwAdvancedNumberPicker, MotionEvent motionEvent) {
        double dimension = context.getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_min_height_half);
        int[] iArr = new int[2];
        hwAdvancedNumberPicker.getLocationOnScreen(iArr);
        double rawY = motionEvent.getRawY(motionEvent.getActionIndex());
        int i10 = iArr[1];
        return rawY > ((double) ((hwAdvancedNumberPicker.getHeight() / 2) + i10)) - dimension && rawY < ((double) (i10 + (hwAdvancedNumberPicker.getHeight() / 2))) + dimension;
    }

    public static boolean isNeedStartFling(HwSpringBackHelper hwSpringBackHelper, float f10) {
        if (hwSpringBackHelper == null) {
            return true;
        }
        boolean zIsFinished = hwSpringBackHelper.isFinished();
        float currVelocity = hwSpringBackHelper.getCurrVelocity();
        return zIsFinished || !(Float.compare(currVelocity * f10, 0.0f) >= 0) || Math.abs(f10) > Math.abs(currVelocity);
    }

    public static boolean isTouchCenterArea(Context context, HwAdvancedNumberPicker hwAdvancedNumberPicker, MotionEvent motionEvent) throws Resources.NotFoundException {
        float dimension = context.getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_min_height_half);
        int[] iArr = new int[2];
        hwAdvancedNumberPicker.getLocationOnScreen(iArr);
        float rawY = motionEvent.getRawY();
        int i10 = iArr[1];
        return rawY > ((float) ((hwAdvancedNumberPicker.getHeight() / 2) + i10)) - dimension && rawY < ((float) (i10 + (hwAdvancedNumberPicker.getHeight() / 2))) + dimension;
    }

    public static void layoutAndInvalidate(HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        hwAdvancedNumberPicker.requestLayout();
        hwAdvancedNumberPicker.invalidate();
    }

    public static void layoutInputText(TextView textView, HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        int measuredWidth = (hwAdvancedNumberPicker.getMeasuredWidth() - textView.getMeasuredWidth()) / 2;
        int measuredHeight = (hwAdvancedNumberPicker.getMeasuredHeight() - textView.getMeasuredHeight()) / 2;
        textView.layout(measuredWidth, measuredHeight, textView.getMeasuredWidth() + measuredWidth, textView.getMeasuredHeight() + measuredHeight);
    }

    public static int makeMeasureSpec(int i10, int i11) {
        return i11 == -1 ? i10 : m53911a(i10, i11);
    }

    public static void performHapticVibrate(HwAdvancedNumberPicker hwAdvancedNumberPicker, String str, long j10) {
        if (hwAdvancedNumberPicker == null || hwAdvancedNumberPicker.getContext() == null || !hwAdvancedNumberPicker.isHapticFeedbackEnabled() || TextUtils.isEmpty(str)) {
            return;
        }
        HwUtils.vibrator(str, j10);
    }

    public static void performVibrate(HwAdvancedNumberPicker hwAdvancedNumberPicker, View view, int i10) {
        if (hwAdvancedNumberPicker.isHapticFeedbackEnabled()) {
            HwVibrateUtil.vibrator(view, i10, 0);
        }
    }

    public static boolean populateAccessibilityEvent(HwAdvancedNumberPicker hwAdvancedNumberPicker, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent == null) {
            return true;
        }
        hwAdvancedNumberPicker.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public static void postAdjustScroller(Context context, HwAdvancedNumberPicker hwAdvancedNumberPicker, MotionEvent motionEvent) {
        if (motionEvent == null || isTouchCenterArea(context, hwAdvancedNumberPicker, motionEvent) || !hwAdvancedNumberPicker.isScrollCenterInThreshold()) {
            hwAdvancedNumberPicker.postAdjustScrollerCommand(0);
        } else {
            hwAdvancedNumberPicker.postAdjustScrollerCommand(HwConstants.SHOW_INPUT_CONTROLS_DELAY_MILLIS);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0064 A[Catch: IOException -> 0x0068, TRY_LEAVE, TryCatch #3 {IOException -> 0x0068, blocks: (B:87:0x005f, B:89:0x0064), top: B:98:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readHeJson(android.content.Context r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "File read fail."
            java.lang.String r1 = "HwAdvancedNumberPicker"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            android.content.res.Resources r7 = r7.getResources()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            int r4 = com.huawei.uikit.hwadvancednumberpicker.C8692R.raw.hwadvancednumberpickerrichtap     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.io.InputStream r7 = r7.openRawResource(r4)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L46
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L46
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L46
            r5.<init>(r7, r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L46
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L46
        L20:
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L3d
            if (r3 == 0) goto L2c
            r2.append(r3)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L3d
            goto L20
        L2a:
            r2 = move-exception
            goto L5d
        L2c:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L3d
            r4.close()     // Catch: java.io.IOException -> L39
            if (r7 == 0) goto L3c
            r7.close()     // Catch: java.io.IOException -> L39
            goto L3c
        L39:
            android.util.Log.w(r1, r0)
        L3c:
            return r2
        L3d:
            r3 = r4
            goto L46
        L3f:
            r2 = move-exception
            goto L5c
        L41:
            r7 = move-exception
            r2 = r7
            r7 = r3
            goto L5c
        L45:
            r7 = r3
        L46:
            java.lang.String r2 = "loadAllMonth has an Exception."
            android.util.Log.e(r1, r2)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = ""
            if (r3 == 0) goto L52
            r3.close()     // Catch: java.io.IOException -> L58
        L52:
            if (r7 == 0) goto L5b
            r7.close()     // Catch: java.io.IOException -> L58
            goto L5b
        L58:
            android.util.Log.w(r1, r0)
        L5b:
            return r2
        L5c:
            r4 = r3
        L5d:
            if (r4 == 0) goto L62
            r4.close()     // Catch: java.io.IOException -> L68
        L62:
            if (r7 == 0) goto L6b
            r7.close()     // Catch: java.io.IOException -> L68
            goto L6b
        L68:
            android.util.Log.w(r1, r0)
        L6b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwadvancednumberpicker.widget.PickerHelper.readHeJson(android.content.Context):java.lang.String");
    }

    public static void removeAllCallbacks(HwAdvancedNumberPicker hwAdvancedNumberPicker, HwAdvancedNumberPicker.avpbg avpbgVar) {
        if (hwAdvancedNumberPicker == null || avpbgVar == null) {
            return;
        }
        hwAdvancedNumberPicker.removeCallbacks(avpbgVar);
    }

    public static void removeClickNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        accessibilityNodeInfo.setClickable(false);
        accessibilityNodeInfo.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
        accessibilityNodeInfo.setSelected(true);
    }

    public static int resolveSizeAndStateRespectingMinSize(int i10, int i11, int i12, HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        if (i10 == -1) {
            return i11;
        }
        if (i10 <= i11) {
            i10 = i11;
        }
        return View.resolveSizeAndState(i10, i12, 0);
    }

    public static void sendAccessibilityAnnounceEvent(HwAdvancedNumberPicker hwAdvancedNumberPicker, AccessibilityManager accessibilityManager, boolean z10) {
        if (!z10 || hwAdvancedNumberPicker == null || accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        hwAdvancedNumberPicker.sendAccessibilityEvent(16384);
    }

    public static void sendAccessibilityEvent(MotionEvent motionEvent, HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        if (motionEvent == null || motionEvent.getAction() == 10) {
            return;
        }
        hwAdvancedNumberPicker.sendAccessibilityEvent(C5914f2.f26733f);
    }

    public static void setAccessibilityEventDescription(AccessibilityEvent accessibilityEvent, Scroller scroller, String str) {
        accessibilityEvent.setClassName(HwAdvancedNumberPicker.class.getSimpleName());
        accessibilityEvent.getText().clear();
        if (scroller.isFinished()) {
            accessibilityEvent.setContentDescription(str);
        } else {
            accessibilityEvent.setContentDescription(null);
        }
    }

    public static void setButtonContentDescription(int i10, String str, View view, View view2, int i11) {
        if (str == null || view == null || view2 == null) {
            return;
        }
        if (i10 == i11 + 1) {
            view.setContentDescription(str);
        }
        if (i10 == i11 - 1) {
            view2.setContentDescription(str);
        }
    }

    public static void setFadingEdge(Context context, View view) {
        int measuredHeight = view.getMeasuredHeight();
        float dimension = context.getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_max_height);
        float dimension2 = context.getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_min_height);
        float dimension3 = context.getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_middle_height);
        float dimension4 = context.getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_fading_edge_length);
        float f10 = measuredHeight;
        if (f10 > dimension2) {
            view.setVerticalFadingEdgeEnabled(true);
            if (f10 < dimension3) {
                view.setFadingEdgeLength((int) (dimension4 - ((dimension3 - f10) / 2.0f)));
            } else if (f10 > dimension) {
                view.setFadingEdgeLength((int) (((f10 - dimension) / 2.0f) + dimension4));
            } else {
                view.setFadingEdgeLength((int) dimension4);
            }
        }
    }

    public static void setPickerAlpha(HwAdvancedNumberPicker hwAdvancedNumberPicker, boolean z10, float f10) {
        if (z10) {
            hwAdvancedNumberPicker.setAlpha(1.0f);
        } else if (Float.compare(f10, 0.0f) != 0) {
            hwAdvancedNumberPicker.setAlpha(f10);
        }
    }

    public static void setValueFromPlume(Context context, HwAdvancedNumberPicker hwAdvancedNumberPicker, boolean z10) {
        Method method = HwReflectUtil.getMethod("getBoolean", new Class[]{Context.class, View.class, String.class, Boolean.TYPE}, "huawei.android.widget.HwPlume");
        if (method == null) {
            hwAdvancedNumberPicker.setExtendScrollEnabled(z10);
            return;
        }
        Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{context, hwAdvancedNumberPicker, "pickerScrollEnabled", Boolean.valueOf(z10)});
        if (objInvokeMethod instanceof Boolean) {
            hwAdvancedNumberPicker.setExtendScrollEnabled(((Boolean) objInvokeMethod).booleanValue());
        } else {
            hwAdvancedNumberPicker.setExtendScrollEnabled(z10);
        }
    }

    public static void setViewEnabled(View view, boolean z10) {
        if (view != null) {
            view.setEnabled(z10);
        }
    }

    public static float sp2px(Context context, float f10) {
        return TypedValue.applyDimension(2, f10, context.getResources().getDisplayMetrics());
    }

    public static Bitmap textToBitmap(String str, Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float fCeil = (float) Math.ceil(paint.measureText(str));
        float fCeil2 = (float) Math.ceil(fontMetrics.bottom - fontMetrics.top);
        if (Float.compare(fCeil, 1.0f) < 0) {
            fCeil = 1.0f;
        }
        if (Float.compare(fCeil2, 1.0f) < 0) {
            fCeil2 = 1.0f;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) fCeil, (int) fCeil2, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawText(str, fCeil / 2.0f, -fontMetrics.top, paint);
        return bitmapCreateBitmap;
    }

    public static void updatePicker(HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        hwAdvancedNumberPicker.initializeSelectorWheelIndices();
        hwAdvancedNumberPicker.m53902G();
        hwAdvancedNumberPicker.m53904e();
    }

    public static boolean isFinishedScroller(HwSpringBackHelper hwSpringBackHelper, HwSpringBackHelper hwSpringBackHelper2, Scroller scroller) {
        return hwSpringBackHelper.isFinished() && hwSpringBackHelper2.isFinished() && scroller.isFinished();
    }

    /* renamed from: a */
    private static String m53912a(HwFormatter hwFormatter, int i10, String str) {
        return (hwFormatter == null || hwFormatter != TWO_DIGIT_FORMATTER || str.length() >= 3 || str.length() <= 0) ? str : String.format(f41224c, Integer.valueOf(i10));
    }

    /* renamed from: a */
    private static int m53911a(int i10, int i11) throws IllegalArgumentException {
        int mode = View.MeasureSpec.getMode(i10);
        int iMin = Math.min(View.MeasureSpec.getSize(i10), i11);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        if (mode == 1073741824) {
            return i10;
        }
        throw new IllegalArgumentException("Unknown measure mode: " + mode);
    }

    public static String getLongText(String[] strArr, Paint paint) {
        String str = null;
        if (strArr != null && strArr.length != 0 && paint != null) {
            float f10 = 0.0f;
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (!TextUtils.isEmpty(strArr[i10])) {
                    float fMeasureText = paint.measureText(strArr[i10]);
                    if (Float.compare(fMeasureText, f10) > 0) {
                        str = strArr[i10];
                        f10 = fMeasureText;
                    }
                }
            }
        }
        return str;
    }

    /* renamed from: b */
    public static void m53915b(Context context, HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        Resources resources = context.getResources();
        if (resources == null || resources.getInteger(C8692R.integer.emui_device_type) != 8) {
            return;
        }
        hwAdvancedNumberPicker.setFocusableInTouchMode(true);
        hwAdvancedNumberPicker.requestFocus();
    }
}
