package com.huawei.uikit.hwalphaindexerlistview.utils;

import android.icu.text.AlphabeticIndex;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.Character;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes7.dex */
public class HwSectionLocaleUtils {

    /* renamed from: d */
    private static final String f41266d = "HwSectionLocaleUtils";

    /* renamed from: f */
    private static final int f41268f = 0;

    /* renamed from: g */
    private static final int f41269g = 12549;

    /* renamed from: h */
    private static final int f41270h = 12550;

    /* renamed from: i */
    private static final int f41271i = 12573;

    /* renamed from: j */
    private static final int f41272j = 12585;

    /* renamed from: k */
    private static final int f41273k = 1574;

    /* renamed from: l */
    private static final int f41274l = 1569;

    /* renamed from: m */
    private static HwSectionLocaleUtils f41275m;

    /* renamed from: a */
    private final aauaf f41276a;

    /* renamed from: b */
    private final Locale f41277b;

    /* renamed from: c */
    private String f41278c;
    public static final Locale LOCALE_ARABIC = new Locale(Constants.AR_CACHE);
    public static final Locale LOCALE_FARSI = new Locale("fa");
    public static final Locale LOCALE_GREEK = new Locale("el");
    public static final Locale LOCALE_HEBREW = new Locale("he");
    public static final Locale LOCALE_THAI = new Locale("th");
    public static final Locale LOCALE_UKRAINIAN = new Locale("uk");
    public static final Locale LOCALE_HINDI = new Locale("hi");

    /* renamed from: e */
    private static final String f41267e = Locale.JAPANESE.getLanguage();

    public static class aauaf {

        /* renamed from: e */
        private static final String f41279e = "";

        /* renamed from: f */
        private static final String f41280f = "#";

        /* renamed from: g */
        private static final int f41281g = 300;

        /* renamed from: h */
        private static final int f41282h = -1;

        /* renamed from: a */
        protected AlphabeticIndex.ImmutableIndex f41283a;

        /* renamed from: b */
        private final Locale f41284b;

        /* renamed from: c */
        private int f41285c;

        /* renamed from: d */
        private int f41286d;

        public aauaf(Locale locale) {
            this.f41283a = null;
            this.f41285c = 0;
            this.f41286d = 0;
            this.f41284b = locale;
            AlphabeticIndex.ImmutableIndex immutableIndexBuildImmutableIndex = new AlphabeticIndex(locale).setMaxLabelCount(300).addLabels(Locale.ENGLISH).addLabels(Locale.JAPANESE).addLabels(Locale.KOREAN).addLabels(HwSectionLocaleUtils.LOCALE_THAI).addLabels("fa".equals(locale.getLanguage()) ? HwSectionLocaleUtils.LOCALE_FARSI : HwSectionLocaleUtils.LOCALE_ARABIC).addLabels(HwSectionLocaleUtils.LOCALE_HEBREW).addLabels(HwSectionLocaleUtils.LOCALE_GREEK).addLabels(HwSectionLocaleUtils.LOCALE_UKRAINIAN).addLabels(HwSectionLocaleUtils.LOCALE_HINDI).buildImmutableIndex();
            this.f41283a = immutableIndexBuildImmutableIndex;
            int bucketCount = immutableIndexBuildImmutableIndex.getBucketCount();
            this.f41286d = bucketCount;
            this.f41285c = bucketCount - 1;
        }

        /* renamed from: a */
        public int mo53919a(String str) {
            if (str == null) {
                Log.w(HwSectionLocaleUtils.f41266d, "getBucketIndex: displayName is null!");
                return -1;
            }
            int length = str.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iCodePointAt = Character.codePointAt(str, iCharCount);
                if (Character.isDigit(iCodePointAt) || m53917b(iCodePointAt)) {
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            int bucketIndex = this.f41283a.getBucketIndex(str);
            if (bucketIndex < 0) {
                return -1;
            }
            if (bucketIndex >= this.f41285c) {
                return bucketIndex + 1;
            }
            if (!"TW".equals(this.f41284b.getCountry()) || length <= iCharCount) {
                return bucketIndex;
            }
            int iCodePointAt2 = Character.codePointAt(str, iCharCount);
            if (iCodePointAt2 >= HwSectionLocaleUtils.f41269g && iCodePointAt2 <= HwSectionLocaleUtils.f41271i) {
                return iCodePointAt2 - 12548;
            }
            if (iCodePointAt2 >= HwSectionLocaleUtils.f41271i && iCodePointAt2 <= HwSectionLocaleUtils.f41272j) {
                return iCodePointAt2 - HwSectionLocaleUtils.f41269g;
            }
            return bucketIndex;
        }

        /* renamed from: b */
        public String m53921b(String str) {
            return str;
        }

        /* renamed from: b */
        private boolean m53917b(int i10) {
            return (!Character.isSpaceChar(i10) && i10 != 43) && (i10 != 40) && (i10 != 35) && ((i10 != 41 && i10 != 46) & (i10 != 45));
        }

        /* renamed from: a */
        public int mo53918a() {
            return this.f41286d + 1;
        }

        /* renamed from: a */
        public String mo53920a(int i10) {
            if (i10 < 0 || i10 >= mo53918a()) {
                return "";
            }
            if (i10 == 0) {
                return "#";
            }
            if (i10 > this.f41285c) {
                i10--;
            }
            return this.f41283a.getBucket(i10) == null ? "" : this.f41283a.getBucket(i10).getLabel();
        }
    }

    public static class bqmxo extends aauaf {
        public bqmxo(Locale locale) {
            super(locale);
        }
    }

    private HwSectionLocaleUtils(Locale locale) {
        if (locale == null) {
            this.f41277b = Locale.getDefault();
        } else {
            this.f41277b = locale;
        }
        String language = this.f41277b.getLanguage();
        this.f41278c = language;
        if (language.equals(f41267e)) {
            this.f41276a = new bzrwd(this.f41277b);
        } else if (this.f41277b.equals(Locale.CHINA)) {
            this.f41276a = new bqmxo(this.f41277b);
        } else {
            this.f41276a = new aauaf(this.f41277b);
        }
    }

    public static synchronized HwSectionLocaleUtils getInstance() {
        try {
            HwSectionLocaleUtils hwSectionLocaleUtils = f41275m;
            if (hwSectionLocaleUtils == null || !hwSectionLocaleUtils.isLocale(Locale.getDefault())) {
                f41275m = new HwSectionLocaleUtils(null);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f41275m;
    }

    public static synchronized void setLocale(Locale locale) {
        try {
            HwSectionLocaleUtils hwSectionLocaleUtils = f41275m;
            if (hwSectionLocaleUtils == null || !hwSectionLocaleUtils.isLocale(locale)) {
                f41275m = new HwSectionLocaleUtils(locale);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public int getBucketIndex(String str) {
        return this.f41276a.mo53919a(str);
    }

    public String getBucketLabel(int i10) {
        return this.f41276a.mo53920a(i10);
    }

    public String getLabel(String str) {
        char cCharAt;
        char cCharAt2;
        if (!TextUtils.isEmpty(str)) {
            if ("TW".equals(this.f41277b.getCountry()) && (cCharAt2 = getSortKey(str).charAt(0)) >= f41269g && cCharAt2 <= f41272j) {
                return String.valueOf(cCharAt2);
            }
            if (Constants.AR_CACHE.equals(this.f41277b.getLanguage()) && (cCharAt = getSortKey(str).charAt(0)) < f41273k && cCharAt > f41274l) {
                return "آ";
            }
        }
        return getBucketLabel(getBucketIndex(getSortKey(str)));
    }

    public String getSortKey(String str) {
        return this.f41276a.m53921b(str);
    }

    public boolean isLocale(Locale locale) {
        return this.f41277b.equals(locale);
    }

    public static class bzrwd extends aauaf {

        /* renamed from: j */
        private static final String f41287j = "他";

        /* renamed from: k */
        private static final Set<Character.UnicodeBlock> f41288k;

        /* renamed from: i */
        private final int f41289i;

        static {
            HashSet hashSet = new HashSet();
            hashSet.add(Character.UnicodeBlock.HIRAGANA);
            hashSet.add(Character.UnicodeBlock.KATAKANA);
            hashSet.add(Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
            hashSet.add(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
            hashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
            hashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
            hashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
            hashSet.add(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
            hashSet.add(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
            f41288k = Collections.unmodifiableSet(hashSet);
        }

        public bzrwd(Locale locale) {
            super(locale);
            this.f41289i = super.mo53919a("日");
        }

        /* renamed from: c */
        private static boolean m53922c(int i10) {
            return f41288k.contains(Character.UnicodeBlock.of(i10));
        }

        @Override // com.huawei.uikit.hwalphaindexerlistview.utils.HwSectionLocaleUtils.aauaf
        /* renamed from: a */
        public int mo53919a(String str) {
            int iMo53919a = super.mo53919a(str);
            return ((iMo53919a != this.f41289i || m53922c(Character.codePointAt(str, 0))) && iMo53919a <= this.f41289i) ? iMo53919a : iMo53919a + 1;
        }

        @Override // com.huawei.uikit.hwalphaindexerlistview.utils.HwSectionLocaleUtils.aauaf
        /* renamed from: a */
        public int mo53918a() {
            return super.mo53918a() + 1;
        }

        @Override // com.huawei.uikit.hwalphaindexerlistview.utils.HwSectionLocaleUtils.aauaf
        /* renamed from: a */
        public String mo53920a(int i10) {
            int i11 = this.f41289i;
            if (i10 == i11) {
                return f41287j;
            }
            if (i10 > i11) {
                i10--;
            }
            return super.mo53920a(i10);
        }
    }
}
