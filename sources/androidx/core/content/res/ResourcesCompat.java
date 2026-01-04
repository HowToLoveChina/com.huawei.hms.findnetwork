package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;
import p243e0.C9368c;
import p243e0.C9373h;

/* loaded from: classes.dex */
public final class ResourcesCompat {
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    private static final Object sColorStateCacheLock = new Object();

    public static class Api15Impl {
        private Api15Impl() {
        }

        public static Drawable getDrawableForDensity(Resources resources, int i10, int i11) {
            return resources.getDrawableForDensity(i10, i11);
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Drawable getDrawable(Resources resources, int i10, Resources.Theme theme) {
            return resources.getDrawable(i10, theme);
        }

        public static Drawable getDrawableForDensity(Resources resources, int i10, int i11, Resources.Theme theme) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static int getColor(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        public static ColorStateList getColorStateList(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static float getFloat(Resources resources, int i10) {
            return resources.getFloat(i10);
        }
    }

    public static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        public ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
            this.mThemeHash = theme == null ? 0 : theme.hashCode();
        }
    }

    public static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        public ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            return this.mResources.equals(colorStateListCacheKey.mResources) && C9368c.m58729a(this.mTheme, colorStateListCacheKey.mTheme);
        }

        public int hashCode() {
            return C9368c.m58730b(this.mResources, this.mTheme);
        }
    }

    public static abstract class FontCallback {
        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void callbackFailAsync(final int i10, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3429a.lambda$callbackFailAsync$1(i10);
                }
            });
        }

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3427a.lambda$callbackSuccessAsync$0(typeface);
                }
            });
        }

        /* renamed from: onFontRetrievalFailed */
        public abstract void lambda$callbackFailAsync$1(int i10);

        /* renamed from: onFontRetrieved */
        public abstract void lambda$callbackSuccessAsync$0(Typeface typeface);
    }

    public static final class ThemeCompat {

        public static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = new Object();

            private Api23Impl() {
            }

            /* JADX WARN: Removed duplicated region for block: B:52:0x003a A[Catch: all -> 0x0019, DONT_GENERATE, TryCatch #1 {, blocks: (B:35:0x0003, B:39:0x0009, B:45:0x0023, B:44:0x001c, B:46:0x0025, B:48:0x0029, B:52:0x003a, B:51:0x0030), top: B:58:0x0003, inners: #0, #2 }] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @android.annotation.SuppressLint({"BanUncheckedReflection"})
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static void rebase(android.content.res.Resources.Theme r6) {
                /*
                    java.lang.Object r0 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethodLock
                    monitor-enter(r0)
                    boolean r1 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethodFetched     // Catch: java.lang.Throwable -> L19
                    r2 = 0
                    if (r1 != 0) goto L25
                    r1 = 1
                    java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                    java.lang.String r4 = "rebase"
                    java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L19 java.lang.NoSuchMethodException -> L1b
                    java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Throwable -> L19 java.lang.NoSuchMethodException -> L1b
                    androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethod = r3     // Catch: java.lang.Throwable -> L19 java.lang.NoSuchMethodException -> L1b
                    r3.setAccessible(r1)     // Catch: java.lang.Throwable -> L19 java.lang.NoSuchMethodException -> L1b
                    goto L23
                L19:
                    r6 = move-exception
                    goto L3c
                L1b:
                    r3 = move-exception
                    java.lang.String r4 = "ResourcesCompat"
                    java.lang.String r5 = "Failed to retrieve rebase() method"
                    android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L19
                L23:
                    androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethodFetched = r1     // Catch: java.lang.Throwable -> L19
                L25:
                    java.lang.reflect.Method r1 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethod     // Catch: java.lang.Throwable -> L19
                    if (r1 == 0) goto L3a
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L2f
                    r1.invoke(r6, r2)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L2f
                    goto L3a
                L2f:
                    r6 = move-exception
                    java.lang.String r1 = "ResourcesCompat"
                    java.lang.String r2 = "Failed to invoke rebase() method via reflection"
                    android.util.Log.i(r1, r2, r6)     // Catch: java.lang.Throwable -> L19
                    r6 = 0
                    androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethod = r6     // Catch: java.lang.Throwable -> L19
                L3a:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                    return
                L3c:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.rebase(android.content.res.Resources$Theme):void");
            }
        }

        public static class Api29Impl {
            private Api29Impl() {
            }

            public static void rebase(Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(Resources.Theme theme) {
            Api29Impl.rebase(theme);
        }
    }

    private ResourcesCompat() {
    }

    private static void addColorStateListToCache(ColorStateListCacheKey colorStateListCacheKey, int i10, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
                SparseArray<ColorStateListCacheEntry> sparseArray = weakHashMap.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    weakHashMap.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i10, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void clearCachesForTheme(Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                Iterator<ColorStateListCacheKey> it = sColorStateCaches.keySet().iterator();
                while (it.hasNext()) {
                    ColorStateListCacheKey next = it.next();
                    if (next != null && theme.equals(next.mTheme)) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x003c, code lost:
    
        if (r2.mThemeHash == r5.hashCode()) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.res.ColorStateList getCachedColorStateList(androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey r5, int r6) {
        /*
            java.lang.Object r0 = androidx.core.content.res.ResourcesCompat.sColorStateCacheLock
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, android.util.SparseArray<androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry>> r1 = androidx.core.content.res.ResourcesCompat.sColorStateCaches     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry r2 = (androidx.core.content.res.ResourcesCompat.ColorStateListCacheEntry) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.mConfiguration     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.mResources     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.mTheme     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.mThemeHash     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.mThemeHash     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.mValue     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.getCachedColorStateList(androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, int):android.content.res.ColorStateList");
    }

    public static Typeface getCachedFont(Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i10, new TypedValue(), 0, null, null, false, true);
    }

    public static int getColor(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        return Api23Impl.getColor(resources, i10, theme);
    }

    public static ColorStateList getColorStateList(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList cachedColorStateList = getCachedColorStateList(colorStateListCacheKey, i10);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList colorStateListInflateColorStateList = inflateColorStateList(resources, i10, theme);
        if (colorStateListInflateColorStateList == null) {
            return Api23Impl.getColorStateList(resources, i10, theme);
        }
        addColorStateListToCache(colorStateListCacheKey, i10, colorStateListInflateColorStateList, theme);
        return colorStateListInflateColorStateList;
    }

    public static Drawable getDrawable(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawable(resources, i10, theme);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i10, int i11, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawableForDensity(resources, i10, i11, theme);
    }

    public static float getFloat(Resources resources, int i10) {
        return Api29Impl.getFloat(resources, i10);
    }

    public static Typeface getFont(Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i10, new TypedValue(), 0, null, null, false, false);
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList inflateColorStateList(Resources resources, int i10, Resources.Theme theme) {
        if (isColorInt(resources, i10)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.w(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    private static boolean isColorInt(Resources resources, int i10) throws Resources.NotFoundException {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i10, typedValue, true);
        int i11 = typedValue.type;
        return i11 >= 28 && i11 <= 31;
    }

    private static Typeface loadFont(Context context, int i10, TypedValue typedValue, int i11, FontCallback fontCallback, Handler handler, boolean z10, boolean z11) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        Typeface typefaceLoadFont = loadFont(context, resources, typedValue, i10, i11, fontCallback, handler, z10, z11);
        if (typefaceLoadFont != null || fontCallback != null || z11) {
            return typefaceLoadFont;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    public static void getFont(Context context, int i10, FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        C9373h.m58745f(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i10, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface loadFont(android.content.Context r16, android.content.res.Resources r17, android.util.TypedValue r18, int r19, int r20, androidx.core.content.res.ResourcesCompat.FontCallback r21, android.os.Handler r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    public static Typeface getFont(Context context, int i10, TypedValue typedValue, int i11, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i10, typedValue, i11, fontCallback, null, true, false);
    }
}
