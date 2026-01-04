package p381j1;

/* renamed from: j1.e1 */
/* loaded from: classes.dex */
public enum EnumC10653e1 {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;


    /* renamed from: F */
    public static final EnumC10653e1[] f51220F;

    /* renamed from: G */
    public static final int f51221G;

    /* renamed from: a */
    public final int f51248a = 1 << ordinal();

    static {
        EnumC10653e1 enumC10653e1 = WriteMapNullValue;
        EnumC10653e1 enumC10653e12 = WriteNullListAsEmpty;
        EnumC10653e1 enumC10653e13 = WriteNullStringAsEmpty;
        EnumC10653e1 enumC10653e14 = WriteNullNumberAsZero;
        EnumC10653e1 enumC10653e15 = WriteNullBooleanAsFalse;
        f51220F = new EnumC10653e1[0];
        f51221G = enumC10653e1.m65244b() | enumC10653e15.m65244b() | enumC10653e12.m65244b() | enumC10653e14.m65244b() | enumC10653e13.m65244b();
    }

    EnumC10653e1() {
    }

    /* renamed from: e */
    public static boolean m65241e(int i10, int i11, EnumC10653e1 enumC10653e1) {
        int i12 = enumC10653e1.f51248a;
        return ((i10 & i12) == 0 && (i11 & i12) == 0) ? false : true;
    }

    /* renamed from: f */
    public static boolean m65242f(int i10, EnumC10653e1 enumC10653e1) {
        return (i10 & enumC10653e1.f51248a) != 0;
    }

    /* renamed from: h */
    public static int m65243h(EnumC10653e1[] enumC10653e1Arr) {
        if (enumC10653e1Arr == null) {
            return 0;
        }
        int i10 = 0;
        for (EnumC10653e1 enumC10653e1 : enumC10653e1Arr) {
            i10 |= enumC10653e1.f51248a;
        }
        return i10;
    }

    /* renamed from: b */
    public final int m65244b() {
        return this.f51248a;
    }
}
