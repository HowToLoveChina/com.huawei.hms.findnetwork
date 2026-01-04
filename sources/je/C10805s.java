package je;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import p514o9.C11839m;

/* renamed from: je.s */
/* loaded from: classes3.dex */
public class C10805s {

    /* renamed from: a */
    public static Method f51579a = null;

    /* renamed from: b */
    public static Method f51580b = null;

    /* renamed from: c */
    public static String f51581c = "android.intent.action.MEDIA_SCANNER_SCAN_FOLDER";

    static {
        try {
            Class<?> cls = Class.forName("android.os.StrictMode");
            f51579a = cls.getMethod("disableDeathOnFileUriExposure", new Class[0]);
            f51580b = cls.getMethod("enableDeathOnFileUriExposure", new Class[0]);
        } catch (ClassNotFoundException unused) {
            C11839m.m70687e("MediaScanUtils", "ClassNotFoundException");
        } catch (NoSuchMethodException unused2) {
            C11839m.m70687e("MediaScanUtils", "NoSuchMethodException");
        } catch (SecurityException e10) {
            C11839m.m70687e("MediaScanUtils", "SecurityException: " + e10.toString());
        }
    }

    /* renamed from: a */
    public static boolean m65770a(Context context) {
        if (m65771b(context, "android.intent.action.MEDIA_SCANNER_SCAN_FOLDER")) {
            C11839m.m70688i("MediaScanUtils", "SupportScanFolder action = android.intent.action.MEDIA_SCANNER_SCAN_FOLDER");
            f51581c = "android.intent.action.MEDIA_SCANNER_SCAN_FOLDER";
            return true;
        }
        if (!m65771b(context, "huawei.intent.action.MEDIA_SCANNER_SCAN_FOLDER")) {
            return false;
        }
        C11839m.m70688i("MediaScanUtils", "SupportScanFolder action = huawei.intent.action.MEDIA_SCANNER_SCAN_FOLDER");
        f51581c = "huawei.intent.action.MEDIA_SCANNER_SCAN_FOLDER";
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* renamed from: b */
    public static boolean m65771b(Context context, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i10 = 0;
        i10 = 0;
        i10 = 0;
        i10 = 0;
        i10 = 0;
        i10 = 0;
        i10 = 0;
        i10 = 0;
        i10 = 0;
        i10 = 0;
        if (f51579a == null || f51580b == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setData(Uri.parse("file://"));
        synchronized (C10805s.class) {
            String str8 = null;
            try {
                try {
                    try {
                        f51579a.invoke(null, new Object[0]);
                        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
                        try {
                            try {
                                f51580b.invoke(null, new Object[0]);
                            } catch (IllegalArgumentException unused) {
                                str8 = "queryBroadcastReceivers IllegalArgumentException ";
                                C11839m.m70687e("MediaScanUtils", "queryBroadcastReceivers IllegalArgumentException ");
                            } catch (InvocationTargetException unused2) {
                                str8 = "queryBroadcastReceivers InvocationTargetException ";
                                C11839m.m70687e("MediaScanUtils", "queryBroadcastReceivers InvocationTargetException ");
                            }
                        } catch (IllegalAccessException unused3) {
                            str8 = "queryBroadcastReceivers IllegalAccessException ";
                            C11839m.m70687e("MediaScanUtils", "queryBroadcastReceivers IllegalAccessException ");
                        }
                        if (listQueryBroadcastReceivers != null) {
                            i10 = !listQueryBroadcastReceivers.isEmpty();
                        }
                    } catch (IllegalAccessException unused4) {
                        C11839m.m70687e("MediaScanUtils", "queryBroadcastReceivers IllegalAccessException ");
                        try {
                            f51580b.invoke(null, new Object[0]);
                        } catch (IllegalAccessException unused5) {
                            str6 = "MediaScanUtils";
                            str7 = "queryBroadcastReceivers IllegalAccessException ";
                            C11839m.m70687e(str6, str7);
                            return i10;
                        } catch (IllegalArgumentException unused6) {
                            str4 = "MediaScanUtils";
                            str5 = "queryBroadcastReceivers IllegalArgumentException ";
                            C11839m.m70687e(str4, str5);
                            return i10;
                        } catch (InvocationTargetException unused7) {
                            str2 = "MediaScanUtils";
                            str3 = "queryBroadcastReceivers InvocationTargetException ";
                            C11839m.m70687e(str2, str3);
                            return i10;
                        }
                    } catch (InvocationTargetException unused8) {
                        C11839m.m70687e("MediaScanUtils", "queryBroadcastReceivers InvocationTargetException ");
                        try {
                            f51580b.invoke(null, new Object[0]);
                        } catch (IllegalAccessException unused9) {
                            str6 = "MediaScanUtils";
                            str7 = "queryBroadcastReceivers IllegalAccessException ";
                            C11839m.m70687e(str6, str7);
                            return i10;
                        } catch (IllegalArgumentException unused10) {
                            str4 = "MediaScanUtils";
                            str5 = "queryBroadcastReceivers IllegalArgumentException ";
                            C11839m.m70687e(str4, str5);
                            return i10;
                        } catch (InvocationTargetException unused11) {
                            str2 = "MediaScanUtils";
                            str3 = "queryBroadcastReceivers InvocationTargetException ";
                            C11839m.m70687e(str2, str3);
                            return i10;
                        }
                    }
                } catch (RuntimeException unused12) {
                    C11839m.m70687e("MediaScanUtils", "queryBroadcastReceivers RuntimeException ");
                    try {
                        f51580b.invoke(null, new Object[0]);
                    } catch (IllegalAccessException unused13) {
                        str6 = "MediaScanUtils";
                        str7 = "queryBroadcastReceivers IllegalAccessException ";
                        C11839m.m70687e(str6, str7);
                        return i10;
                    } catch (IllegalArgumentException unused14) {
                        str4 = "MediaScanUtils";
                        str5 = "queryBroadcastReceivers IllegalArgumentException ";
                        C11839m.m70687e(str4, str5);
                        return i10;
                    } catch (InvocationTargetException unused15) {
                        str2 = "MediaScanUtils";
                        str3 = "queryBroadcastReceivers InvocationTargetException ";
                        C11839m.m70687e(str2, str3);
                        return i10;
                    }
                }
            } finally {
            }
        }
        return i10;
    }

    /* renamed from: c */
    public static void m65772c(Context context, String str, boolean z10) {
        if (context == null || str == null) {
            return;
        }
        Intent intent = new Intent();
        if (z10) {
            intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        } else {
            m65770a(context);
            intent.setAction(f51581c);
        }
        intent.setData(Uri.parse("file://" + str));
        m65773d(context, intent);
    }

    /* renamed from: d */
    public static void m65773d(Context context, Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (f51579a == null || f51580b == null) {
            return;
        }
        synchronized (C10805s.class) {
            try {
                try {
                    f51579a.invoke(null, new Object[0]);
                    context.sendBroadcast(intent);
                } catch (IllegalAccessException unused) {
                    C11839m.m70687e("MediaScanUtils", "sendRealBroadcast IllegalAccessException ");
                    try {
                        f51580b.invoke(null, new Object[0]);
                    } catch (IllegalAccessException unused2) {
                        str5 = "MediaScanUtils";
                        str6 = "sendRealBroadcast invoke IllegalAccessException ";
                        C11839m.m70687e(str5, str6);
                    } catch (IllegalArgumentException unused3) {
                        str3 = "MediaScanUtils";
                        str4 = "sendRealBroadcast invoke IllegalArgumentException ";
                        C11839m.m70687e(str3, str4);
                    } catch (InvocationTargetException unused4) {
                        str = "MediaScanUtils";
                        str2 = "sendRealBroadcast invoke InvocationTargetException ";
                        C11839m.m70687e(str, str2);
                    }
                } catch (RuntimeException unused5) {
                    C11839m.m70687e("MediaScanUtils", "sendRealBroadcast RuntimeException ");
                    try {
                        f51580b.invoke(null, new Object[0]);
                    } catch (IllegalAccessException unused6) {
                        str5 = "MediaScanUtils";
                        str6 = "sendRealBroadcast invoke IllegalAccessException ";
                        C11839m.m70687e(str5, str6);
                    } catch (IllegalArgumentException unused7) {
                        str3 = "MediaScanUtils";
                        str4 = "sendRealBroadcast invoke IllegalArgumentException ";
                        C11839m.m70687e(str3, str4);
                    } catch (InvocationTargetException unused8) {
                        str = "MediaScanUtils";
                        str2 = "sendRealBroadcast invoke InvocationTargetException ";
                        C11839m.m70687e(str, str2);
                    }
                } catch (InvocationTargetException unused9) {
                    C11839m.m70687e("MediaScanUtils", "sendRealBroadcast InvocationTargetException ");
                    try {
                        f51580b.invoke(null, new Object[0]);
                    } catch (IllegalAccessException unused10) {
                        str5 = "MediaScanUtils";
                        str6 = "sendRealBroadcast invoke IllegalAccessException ";
                        C11839m.m70687e(str5, str6);
                    } catch (IllegalArgumentException unused11) {
                        str3 = "MediaScanUtils";
                        str4 = "sendRealBroadcast invoke IllegalArgumentException ";
                        C11839m.m70687e(str3, str4);
                    } catch (InvocationTargetException unused12) {
                        str = "MediaScanUtils";
                        str2 = "sendRealBroadcast invoke InvocationTargetException ";
                        C11839m.m70687e(str, str2);
                    }
                }
                try {
                    f51580b.invoke(null, new Object[0]);
                } catch (IllegalAccessException unused13) {
                    str5 = "MediaScanUtils";
                    str6 = "sendRealBroadcast invoke IllegalAccessException ";
                    C11839m.m70687e(str5, str6);
                } catch (IllegalArgumentException unused14) {
                    str3 = "MediaScanUtils";
                    str4 = "sendRealBroadcast invoke IllegalArgumentException ";
                    C11839m.m70687e(str3, str4);
                } catch (InvocationTargetException unused15) {
                    str = "MediaScanUtils";
                    str2 = "sendRealBroadcast invoke InvocationTargetException ";
                    C11839m.m70687e(str, str2);
                }
            } finally {
            }
        }
    }
}
