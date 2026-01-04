package p381j1;

import com.huawei.hms.network.p129ai.C5799g0;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p244e1.C9381e;
import p244e1.C9383g;
import p244e1.InterfaceC9386j;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;
import p481n1.C11595g;
import p481n1.C11603o;

/* renamed from: j1.q0 */
/* loaded from: classes.dex */
public class C10680q0 implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: c */
    public static Method f51319c;

    /* renamed from: b */
    public static final C10680q0 f51318b = new C10680q0();

    /* renamed from: d */
    public static boolean f51320d = false;

    /* renamed from: a */
    public static boolean f51317a = FaqConstants.DISABLE_HA_REPORT.equals(C11595g.m69213h("fastjson.deserializer.fileRelativePathSupport"));

    /* renamed from: f */
    public static String m65312f(Node node) throws TransformerException {
        try {
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            DOMSource dOMSource = new DOMSource(node);
            StringWriter stringWriter = new StringWriter();
            transformerNewTransformer.transform(dOMSource, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerException e10) {
            throw new C9380d("xml node to string error", e10);
        }
    }

    /* JADX WARN: Type inference failed for: r9v34, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        Object objM62712G;
        String str;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        InetAddress inetAddress = null;
        int i10 = 0;
        if (type != InetSocketAddress.class) {
            if (c10077a.f49158k == 2) {
                c10077a.f49158k = 0;
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
            if (objM62712G == null) {
                str = null;
            } else {
                if (!(objM62712G instanceof String)) {
                    if (!(objM62712G instanceof C9381e)) {
                        throw new C9380d("expect string");
                    }
                    C9381e c9381e = (C9381e) objM62712G;
                    if (type == Currency.class) {
                        String strM58794N = c9381e.m58794N(HwPayConstant.KEY_CURRENCY);
                        if (strM58794N != null) {
                            return (T) Currency.getInstance(strM58794N);
                        }
                        String strM58794N2 = c9381e.m58794N("currencyCode");
                        if (strM58794N2 != null) {
                            return (T) Currency.getInstance(strM58794N2);
                        }
                    }
                    return type == Map.Entry.class ? (T) c9381e.entrySet().iterator().next() : (T) c9381e.m58777D(type);
                }
                str = (String) objM62712G;
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return (T) UUID.fromString(str);
            }
            if (type == URI.class) {
                return (T) URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return (T) new URL(str);
                } catch (MalformedURLException e10) {
                    throw new C9380d("create url error", e10);
                }
            }
            if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            }
            if (type == Locale.class) {
                return (T) C11603o.m69268N0(str);
            }
            if (type == SimpleDateFormat.class) {
                ?? r92 = (T) new SimpleDateFormat(str, interfaceC10079c.mo62791z0());
                r92.setTimeZone(interfaceC10079c.mo62764V());
                return r92;
            }
            if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                try {
                    return (T) InetAddress.getByName(str);
                } catch (UnknownHostException e11) {
                    throw new C9380d("deserialize inet adress error", e11);
                }
            }
            if (type == File.class) {
                if (str.indexOf("..") < 0 || f51317a) {
                    return (T) new File(str);
                }
                throw new C9380d("file relative path not support.");
            }
            if (type == TimeZone.class) {
                return (T) TimeZone.getTimeZone(str);
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            }
            if (type == Class.class) {
                return (T) C11603o.m69244B0(str, c10077a.m62737s().m62865n(), false);
            }
            if (type == Charset.class) {
                return (T) Charset.forName(str);
            }
            if (type == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (type == C9383g.class) {
                return (T) new C9383g(str);
            }
            if (!(type instanceof Class)) {
                throw new C9380d("MiscCodec not support " + type.toString());
            }
            String name = ((Class) type).getName();
            if (name.equals("java.nio.file.Path")) {
                try {
                    if (f51319c == null && !f51320d) {
                        f51319c = C11603o.m69333z0("java.nio.file.Paths").getMethod("get", String.class, String[].class);
                    }
                    Method method = f51319c;
                    if (method != null) {
                        return (T) method.invoke(null, str, new String[0]);
                    }
                    throw new C9380d("Path deserialize erorr");
                } catch (IllegalAccessException e12) {
                    throw new C9380d("Path deserialize erorr", e12);
                } catch (NoSuchMethodException unused) {
                    f51320d = true;
                } catch (InvocationTargetException e13) {
                    throw new C9380d("Path deserialize erorr", e13);
                }
            }
            throw new C9380d("MiscCodec not support " + name);
        }
        if (interfaceC10079c.mo62768a0() == 8) {
            interfaceC10079c.mo62790z();
            return null;
        }
        c10077a.m62723d(12);
        while (true) {
            String strMo62763J = interfaceC10079c.mo62763J();
            interfaceC10079c.mo62756D(17);
            if (strMo62763J.equals(C5799g0.f25867g)) {
                c10077a.m62723d(17);
                inetAddress = (InetAddress) c10077a.m62721b0(InetAddress.class);
            } else if (strMo62763J.equals("port")) {
                c10077a.m62723d(17);
                if (interfaceC10079c.mo62768a0() != 2) {
                    throw new C9380d("port is not int");
                }
                int iMo62753B = interfaceC10079c.mo62753B();
                interfaceC10079c.mo62790z();
                i10 = iMo62753B;
            } else {
                c10077a.m62723d(17);
                c10077a.m62712G();
            }
            if (interfaceC10079c.mo62768a0() != 16) {
                c10077a.m62723d(13);
                return (T) new InetSocketAddress(inetAddress, i10);
            }
            interfaceC10079c.mo62790z();
        }
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 4;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws TransformerException, IOException {
        String strM65312f;
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65222a0();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            strM65312f = ((SimpleDateFormat) obj).toPattern();
            if (c10650d1.m65237w(EnumC10653e1.WriteClassName) && obj.getClass() != type) {
                c10650d1.write(123);
                c10650d1.m65209B(AbstractC9377a.f46780c);
                c10664i0.m65263H(obj.getClass().getName());
                c10650d1.m65214G(',', "val", strM65312f);
                c10650d1.write(125);
                return;
            }
        } else if (cls == Class.class) {
            strM65312f = ((Class) obj).getName();
        } else {
            if (cls == InetSocketAddress.class) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                InetAddress address = inetSocketAddress.getAddress();
                c10650d1.write(123);
                if (address != null) {
                    c10650d1.m65209B(C5799g0.f25867g);
                    c10664i0.m65262G(address);
                    c10650d1.write(44);
                }
                c10650d1.m65209B("port");
                c10650d1.m65219X(inetSocketAddress.getPort());
                c10650d1.write(125);
                return;
            }
            if (obj instanceof File) {
                strM65312f = ((File) obj).getPath();
            } else if (obj instanceof InetAddress) {
                strM65312f = ((InetAddress) obj).getHostAddress();
            } else if (obj instanceof TimeZone) {
                strM65312f = ((TimeZone) obj).getID();
            } else if (obj instanceof Currency) {
                strM65312f = ((Currency) obj).getCurrencyCode();
            } else {
                if (obj instanceof InterfaceC9386j) {
                    ((InterfaceC9386j) obj).mo58778b(c10650d1);
                    return;
                }
                if (obj instanceof Iterator) {
                    m65313g(c10664i0, c10650d1, (Iterator) obj);
                    return;
                }
                if (obj instanceof Iterable) {
                    m65313g(c10664i0, c10650d1, ((Iterable) obj).iterator());
                    return;
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (key instanceof String) {
                        String str = (String) key;
                        if (value instanceof String) {
                            c10650d1.m65216I('{', str, (String) value);
                        } else {
                            c10650d1.write(123);
                            c10650d1.m65209B(str);
                            c10664i0.m65262G(value);
                        }
                    } else {
                        c10650d1.write(123);
                        c10664i0.m65262G(key);
                        c10650d1.write(58);
                        c10664i0.m65262G(value);
                    }
                    c10650d1.write(125);
                    return;
                }
                if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
                    c10650d1.m65222a0();
                    return;
                } else {
                    if (!(obj instanceof Node)) {
                        throw new C9380d("not support class : " + cls);
                    }
                    strM65312f = m65312f((Node) obj);
                }
            }
        }
        c10650d1.m65228g0(strM65312f);
    }

    /* renamed from: g */
    public void m65313g(C10664i0 c10664i0, C10650d1 c10650d1, Iterator<?> it) {
        c10650d1.write(91);
        int i10 = 0;
        while (it.hasNext()) {
            if (i10 != 0) {
                c10650d1.write(44);
            }
            c10664i0.m65262G(it.next());
            i10++;
        }
        c10650d1.write(93);
    }
}
