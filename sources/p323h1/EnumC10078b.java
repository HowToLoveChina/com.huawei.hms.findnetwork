package p323h1;

/* renamed from: h1.b */
/* loaded from: classes.dex */
public enum EnumC10078b {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch,
    SupportAutoType,
    NonStringKeyAsString,
    CustomMapDeserializer,
    ErrorOnEnumNotMatch,
    SafeMode,
    TrimStringFieldValue,
    UseNativeJavaObject;


    /* renamed from: a */
    public final int f49196a = 1 << ordinal();

    EnumC10078b() {
    }

    /* renamed from: e */
    public static boolean m62749e(int i10, EnumC10078b enumC10078b) {
        return (i10 & enumC10078b.f49196a) != 0;
    }

    /* renamed from: f */
    public static int m62750f(EnumC10078b[] enumC10078bArr) {
        if (enumC10078bArr == null) {
            return 0;
        }
        int i10 = 0;
        for (EnumC10078b enumC10078b : enumC10078bArr) {
            i10 |= enumC10078b.f49196a;
        }
        return i10;
    }

    /* renamed from: b */
    public final int m62751b() {
        return this.f49196a;
    }
}
