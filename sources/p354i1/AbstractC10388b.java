package p354i1;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.C10082f;
import p323h1.EnumC10078b;
import p323h1.InterfaceC10079c;
import p481n1.C11603o;

/* renamed from: i1.b */
/* loaded from: classes.dex */
public abstract class AbstractC10388b extends AbstractC10393e implements InterfaceC10408t {
    @Override // p354i1.AbstractC10393e, p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        return (T) mo63893f(c10077a, type, obj, null, 0);
    }

    @Override // p354i1.AbstractC10393e
    /* renamed from: f */
    public <T> T mo63893f(C10077a c10077a, Type type, Object obj, String str, int i10) throws ParseException {
        Object objM62712G;
        SimpleDateFormat simpleDateFormat;
        Date date;
        SimpleDateFormat simpleDateFormat2;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 2) {
            long jMo62783u = interfaceC10079c.mo62783u();
            interfaceC10079c.mo62756D(16);
            if ("unixtime".equals(str)) {
                jMo62783u *= 1000;
            }
            objM62712G = Long.valueOf(jMo62783u);
        } else {
            Date date2 = null;
            if (interfaceC10079c.mo62768a0() == 4) {
                String strMo62763J = interfaceC10079c.mo62763J();
                if (str != null) {
                    if ("yyyy-MM-dd HH:mm:ss.SSSSSSSSS".equals(str) && (type instanceof Class) && ((Class) type).getName().equals("java.sql.Timestamp")) {
                        return (T) C11603o.m69241A(strMo62763J);
                    }
                    try {
                        simpleDateFormat = new SimpleDateFormat(str, c10077a.f49153f.mo62791z0());
                    } catch (IllegalArgumentException e10) {
                        if (str.contains(CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER)) {
                            try {
                                simpleDateFormat = new SimpleDateFormat(str.replaceAll(CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER, "'T'"), c10077a.f49153f.mo62791z0());
                            } catch (IllegalArgumentException unused) {
                                throw e10;
                            }
                        } else {
                            simpleDateFormat = null;
                        }
                    }
                    if (AbstractC9377a.f46778a != null) {
                        simpleDateFormat.setTimeZone(c10077a.f49153f.mo62764V());
                    }
                    try {
                        date = simpleDateFormat.parse(strMo62763J);
                    } catch (ParseException unused2) {
                        date = null;
                    }
                    if (date == null && AbstractC9377a.f46779b == Locale.CHINA) {
                        try {
                            simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
                        } catch (IllegalArgumentException e11) {
                            simpleDateFormat2 = simpleDateFormat;
                            if (str.contains(CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER)) {
                                try {
                                    simpleDateFormat2 = new SimpleDateFormat(str.replaceAll(CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER, "'T'"), c10077a.f49153f.mo62791z0());
                                } catch (IllegalArgumentException unused3) {
                                    throw e11;
                                }
                            }
                        }
                        simpleDateFormat2.setTimeZone(c10077a.f49153f.mo62764V());
                        try {
                            date = simpleDateFormat2.parse(strMo62763J);
                        } catch (ParseException unused4) {
                            date = null;
                        }
                    }
                    if (date != null) {
                        date2 = date;
                    } else if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && strMo62763J.length() == 19) {
                        try {
                            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", AbstractC9377a.f46779b);
                            simpleDateFormat3.setTimeZone(AbstractC9377a.f46778a);
                            date2 = simpleDateFormat3.parse(strMo62763J);
                        } catch (ParseException unused5) {
                        }
                    }
                }
                if (date2 == null) {
                    interfaceC10079c.mo62756D(16);
                    Object obj2 = strMo62763J;
                    if (interfaceC10079c.mo62788x0(EnumC10078b.AllowISO8601DateFormat)) {
                        C10082f c10082f = new C10082f(strMo62763J);
                        Object time = strMo62763J;
                        if (c10082f.m62837t1()) {
                            time = c10082f.m62795G0().getTime();
                        }
                        c10082f.close();
                        obj2 = time;
                    }
                    objM62712G = obj2;
                } else {
                    objM62712G = date2;
                }
            } else if (interfaceC10079c.mo62768a0() == 8) {
                interfaceC10079c.mo62790z();
                objM62712G = date2;
            } else if (interfaceC10079c.mo62768a0() == 12) {
                interfaceC10079c.mo62790z();
                if (interfaceC10079c.mo62768a0() != 4) {
                    throw new C9380d("syntax error");
                }
                if (AbstractC9377a.f46780c.equals(interfaceC10079c.mo62763J())) {
                    interfaceC10079c.mo62790z();
                    c10077a.m62723d(17);
                    Class<?> clsM62861j = c10077a.m62737s().m62861j(interfaceC10079c.mo62763J(), null, interfaceC10079c.mo62770c0());
                    if (clsM62861j != null) {
                        type = clsM62861j;
                    }
                    c10077a.m62723d(4);
                    c10077a.m62723d(16);
                }
                interfaceC10079c.mo62762I(2);
                if (interfaceC10079c.mo62768a0() != 2) {
                    throw new C9380d("syntax error : " + interfaceC10079c.mo62782t0());
                }
                long jMo62783u2 = interfaceC10079c.mo62783u();
                interfaceC10079c.mo62790z();
                objM62712G = Long.valueOf(jMo62783u2);
                c10077a.m62723d(13);
            } else if (c10077a.m62708C() == 2) {
                c10077a.m62746x0(0);
                c10077a.m62723d(16);
                if (interfaceC10079c.mo62768a0() != 4) {
                    throw new C9380d("syntax error");
                }
                if (!"val".equals(interfaceC10079c.mo62763J())) {
                    throw new C9380d("syntax error");
                }
                interfaceC10079c.mo62790z();
                c10077a.m62723d(17);
                objM62712G = c10077a.m62712G();
                c10077a.m62723d(13);
            } else {
                objM62712G = c10077a.m62712G();
            }
        }
        return (T) mo63894g(c10077a, type, obj, objM62712G);
    }

    /* renamed from: g */
    public abstract <T> T mo63894g(C10077a c10077a, Type type, Object obj, Object obj2);
}
