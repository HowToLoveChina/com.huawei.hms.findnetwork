package com.baidu.geocoder.p064a;

import java.io.PrintStream;
import java.util.ArrayList;

/* renamed from: com.baidu.geocoder.a.g */
/* loaded from: classes.dex */
public class C1523g {

    /* renamed from: a */
    public static final String f6542a = "bd09ll";

    /* renamed from: b */
    public static double f6543b = 3.141592653589793d;

    /* renamed from: c */
    public static double f6544c = 52.35987755982988d;

    /* renamed from: d */
    public static double f6545d = 6378245.0d;

    /* renamed from: e */
    public static double f6546e = 0.006693421622965943d;

    /* renamed from: a */
    public static C1521e m8648a(double d10, double d11) {
        if (m8654f(d10, d11)) {
            return null;
        }
        double d12 = d11 - 105.0d;
        double d13 = d10 - 35.0d;
        double dM8656h = m8656h(d12, d13);
        double dM8657i = m8657i(d12, d13);
        double d14 = (d10 / 180.0d) * f6543b;
        double dSin = Math.sin(d14);
        double d15 = 1.0d - ((f6546e * dSin) * dSin);
        double dSqrt = Math.sqrt(d15);
        double d16 = f6545d;
        return new C1521e(d10 + ((dM8656h * 180.0d) / ((((1.0d - f6546e) * d16) / (d15 * dSqrt)) * f6543b)), d11 + ((dM8657i * 180.0d) / (((d16 / dSqrt) * Math.cos(d14)) * f6543b)));
    }

    /* renamed from: b */
    public static C1521e m8650b(double d10, double d11) {
        C1521e c1521eM8655g = m8655g(d10, d11);
        return new C1521e((d10 * 2.0d) - c1521eM8655g.m8642a(), (d11 * 2.0d) - c1521eM8655g.m8644b());
    }

    /* renamed from: c */
    public static C1521e m8651c(double d10, double d11) {
        double dSqrt = Math.sqrt((d11 * d11) + (d10 * d10)) + (Math.sin(f6544c * d10) * 2.0E-5d);
        double dAtan2 = Math.atan2(d10, d11) + (Math.cos(d11 * f6544c) * 3.0E-6d);
        return new C1521e((dSqrt * Math.sin(dAtan2)) + 0.006d, (Math.cos(dAtan2) * dSqrt) + 0.0065d);
    }

    /* renamed from: d */
    public static C1521e m8652d(double d10, double d11) {
        double d12 = d11 - 0.0065d;
        double d13 = d10 - 0.006d;
        double dSqrt = Math.sqrt((d12 * d12) + (d13 * d13)) - (Math.sin(f6544c * d13) * 2.0E-5d);
        double dAtan2 = Math.atan2(d13, d12) - (Math.cos(d12 * f6544c) * 3.0E-6d);
        return new C1521e(dSqrt * Math.sin(dAtan2), Math.cos(dAtan2) * dSqrt);
    }

    /* renamed from: e */
    public static C1521e m8653e(double d10, double d11) {
        C1521e c1521eM8652d = m8652d(d10, d11);
        return m8650b(c1521eM8652d.m8642a(), c1521eM8652d.m8644b());
    }

    /* renamed from: f */
    public static boolean m8654f(double d10, double d11) {
        return d11 < 72.004d || d11 > 137.8347d || d10 < 0.8293d || d10 > 55.8271d;
    }

    /* renamed from: g */
    public static C1521e m8655g(double d10, double d11) {
        if (m8654f(d10, d11)) {
            return new C1521e(d10, d11);
        }
        double d12 = d11 - 105.0d;
        double d13 = d10 - 35.0d;
        double dM8656h = m8656h(d12, d13);
        double dM8657i = m8657i(d12, d13);
        double d14 = (d10 / 180.0d) * f6543b;
        double dSin = Math.sin(d14);
        double d15 = 1.0d - ((f6546e * dSin) * dSin);
        double dSqrt = Math.sqrt(d15);
        double d16 = f6545d;
        return new C1521e(d10 + ((dM8656h * 180.0d) / ((((1.0d - f6546e) * d16) / (d15 * dSqrt)) * f6543b)), d11 + ((dM8657i * 180.0d) / (((d16 / dSqrt) * Math.cos(d14)) * f6543b)));
    }

    /* renamed from: h */
    public static double m8656h(double d10, double d11) {
        double d12 = d10 * 2.0d;
        return (-100.0d) + d12 + (d11 * 3.0d) + (d11 * 0.2d * d11) + (0.1d * d10 * d11) + (Math.sqrt(Math.abs(d10)) * 0.2d) + ((((Math.sin((d10 * 6.0d) * f6543b) * 20.0d) + (Math.sin(d12 * f6543b) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f6543b * d11) * 20.0d) + (Math.sin((d11 / 3.0d) * f6543b) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d11 / 12.0d) * f6543b) * 160.0d) + (Math.sin((d11 * f6543b) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    /* renamed from: i */
    public static double m8657i(double d10, double d11) {
        double d12 = d10 * 0.1d;
        return d10 + 300.0d + (d11 * 2.0d) + (d12 * d10) + (d12 * d11) + (Math.sqrt(Math.abs(d10)) * 0.1d) + ((((Math.sin((6.0d * d10) * f6543b) * 20.0d) + (Math.sin((d10 * 2.0d) * f6543b) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f6543b * d10) * 20.0d) + (Math.sin((d10 / 3.0d) * f6543b) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d10 / 12.0d) * f6543b) * 150.0d) + (Math.sin((d10 / 30.0d) * f6543b) * 300.0d)) * 2.0d) / 3.0d);
    }

    /* renamed from: a */
    public static void m8649a(String[] strArr) {
        C1521e c1521e = new C1521e(31.426896d, 119.496145d);
        PrintStream printStream = System.out;
        printStream.println("gps :" + c1521e);
        C1521e c1521eM8648a = m8648a(c1521e.m8642a(), c1521e.m8644b());
        printStream.println("gcj :" + c1521eM8648a);
        printStream.println("star:" + m8650b(c1521eM8648a.m8642a(), c1521eM8648a.m8644b()));
        C1521e c1521eM8651c = m8651c(c1521eM8648a.m8642a(), c1521eM8648a.m8644b());
        printStream.println("bd  :" + c1521eM8651c);
        printStream.println("gcj :" + m8652d(c1521eM8651c.m8642a(), c1521eM8651c.m8644b()));
        ArrayList arrayList = new ArrayList();
        C1521e c1521e2 = new C1521e(40.045689d, 116.298454d);
        C1521e c1521e3 = new C1521e(40.045718d, 116.298532d);
        C1521e c1521e4 = new C1521e(40.04574d, 116.298588d);
        C1521e c1521e5 = new C1521e(40.045767d, 116.298661d);
        C1521e c1521e6 = new C1521e(40.045797d, 116.298741d);
        C1521e c1521e7 = new C1521e(40.045829d, 116.298825d);
        C1521e c1521e8 = new C1521e(40.04586d, 116.298912d);
        C1521e c1521e9 = new C1521e(40.045888d, 116.298984d);
        arrayList.add(c1521e2);
        arrayList.add(c1521e3);
        arrayList.add(c1521e4);
        arrayList.add(c1521e5);
        arrayList.add(c1521e6);
        arrayList.add(c1521e7);
        arrayList.add(c1521e8);
        arrayList.add(c1521e9);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            C1521e c1521e10 = (C1521e) arrayList.get(i10);
            C1521e c1521eM8648a2 = m8648a(c1521e10.m8642a(), c1521e10.m8644b());
            System.out.println(c1521eM8648a2.m8644b() + " " + c1521eM8648a2.m8642a());
        }
    }
}
