package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.hwhttp.ClientConfiguration;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.restclient.Converter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.g6 */
/* loaded from: classes8.dex */
public abstract class AbstractC5931g6<T> {

    /* renamed from: a */
    public static final String f26855a = "ParameterBuilder";

    /* renamed from: com.huawei.hms.network.embedded.g6$a */
    public class a extends AbstractC5931g6<Object> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a */
        public void mo34304a(C5970j6 c5970j6, Object obj) throws IOException {
            if (obj == null) {
                Logger.m32145w(AbstractC5931g6.f26855a, "ParameterBuilder.array.build failed, values == null");
                return;
            }
            int length = Array.getLength(obj);
            for (int i10 = 0; i10 < length; i10++) {
                AbstractC5931g6.this.mo34304a(c5970j6, Array.get(obj, i10));
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$b */
    public class b extends AbstractC5931g6<Iterable<T>> {
        public b() {
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo34304a(C5970j6 c5970j6, Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                Logger.m32145w(AbstractC5931g6.f26855a, "ParameterBuilder.iterable.build failed, values == null");
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                AbstractC5931g6.this.mo34304a(c5970j6, it.next());
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$c */
    public static final class c<T> extends AbstractC5931g6<T> {

        /* renamed from: b */
        public final Converter<T, RequestBody> f26858b;

        public c(Converter<T, RequestBody> converter) {
            this.f26858b = converter;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a */
        public void mo34304a(C5970j6 c5970j6, T t10) throws IOException {
            if (t10 == null) {
                AbstractC5931g6.m34302b("Body parameter value must not be null.");
            }
            c5970j6.m34508a(this.f26858b.convert(t10));
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$d */
    public static final class d extends AbstractC5931g6<ClientConfiguration> {
        /* renamed from: a */
        private String m34307a(ClientConfiguration clientConfiguration) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("core_call_timeout", clientConfiguration.getCallTimeout());
                jSONObject.put("core_connect_timeout", clientConfiguration.getConnectTimeout());
                jSONObject.put("core_concurrent_connect_delay", clientConfiguration.getConnectionAttemptDelay());
                jSONObject.put("core_ping_interval", clientConfiguration.getPingInterval());
                jSONObject.put("core_read_timeout", clientConfiguration.getReadTimeout());
                jSONObject.put("core_write_timeout", clientConfiguration.getWriteTimeout());
                jSONObject.put("core_retry_time", clientConfiguration.getRetryTimeOnConnectionFailure());
                return jSONObject.toString();
            } catch (JSONException unused) {
                Logger.m32145w(AbstractC5931g6.f26855a, "JSONException error");
                return "";
            }
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo34304a(C5970j6 c5970j6, ClientConfiguration clientConfiguration) {
            c5970j6.setNetworkParameters(m34307a(clientConfiguration));
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$e */
    public static final class e<T> extends AbstractC5931g6<Map<String, T>> {

        /* renamed from: b */
        public final Converter<T, String> f26859b;

        public e(Converter<T, String> converter) {
            this.f26859b = converter;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo34304a(C5970j6 c5970j6, Map<String, T> map) throws IOException {
            if (map == null) {
                AbstractC5931g6.m34302b("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    AbstractC5931g6.m34302b("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    AbstractC5931g6.m34302b("Field map contained null value for key '" + key + "'.");
                }
                String strConvert = this.f26859b.convert(value);
                if (strConvert == null) {
                    AbstractC5931g6.m34302b("Field map value '" + value + "' converted to null by " + this.f26859b.getClass().getName() + " for key '" + key + "'.");
                }
                c5970j6.m34510a(key, strConvert);
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$f */
    public static final class f<T> extends AbstractC5931g6<T> {

        /* renamed from: b */
        public final String f26860b;

        /* renamed from: c */
        public final Converter<T, String> f26861c;

        public f(String str, Converter<T, String> converter) {
            if (str == null) {
                AbstractC5931g6.m34302b("Field parameter name must be not null.");
            }
            this.f26860b = str;
            this.f26861c = converter;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a */
        public void mo34304a(C5970j6 c5970j6, T t10) throws IOException {
            String strConvert;
            if (t10 == null || (strConvert = this.f26861c.convert(t10)) == null) {
                return;
            }
            c5970j6.m34510a(this.f26860b, strConvert);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$g */
    public static final class g<T> extends AbstractC5931g6<T> {

        /* renamed from: b */
        public final String f26862b;

        /* renamed from: c */
        public final Converter<T, String> f26863c;

        public g(String str, Converter<T, String> converter) {
            if (str == null) {
                AbstractC5931g6.m34302b("Header parameter name must be not null.");
            }
            this.f26862b = str;
            this.f26863c = converter;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a */
        public void mo34304a(C5970j6 c5970j6, T t10) throws IOException {
            String strConvert;
            if (t10 == null || (strConvert = this.f26863c.convert(t10)) == null) {
                return;
            }
            c5970j6.m34512b(this.f26862b, strConvert);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$h */
    public static final class h<T> extends AbstractC5931g6<Map<String, T>> {

        /* renamed from: b */
        public final Converter<T, String> f26864b;

        public h(Converter<T, String> converter) {
            this.f26864b = converter;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo34304a(C5970j6 c5970j6, Map<String, T> map) throws IOException {
            if (map == null) {
                AbstractC5931g6.m34302b("Header map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    AbstractC5931g6.m34302b("Header map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    AbstractC5931g6.m34302b("Header map contained null value for key '" + key + "'.");
                }
                c5970j6.m34512b(key, this.f26864b.convert(value));
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$i */
    public static final class i extends AbstractC5931g6<String> {
        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo34304a(C5970j6 c5970j6, String str) {
            c5970j6.setNetworkParameters(str);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$j */
    public static final class j<T> extends AbstractC5931g6<T> {

        /* renamed from: b */
        public final String f26865b;

        /* renamed from: c */
        public final Converter<T, String> f26866c;

        public j(String str, Converter<T, String> converter) {
            if (str == null) {
                AbstractC5931g6.m34302b("Path parameter name must be not null.");
            }
            this.f26865b = str;
            this.f26866c = converter;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a */
        public void mo34304a(C5970j6 c5970j6, T t10) throws IOException {
            if (t10 == null) {
                AbstractC5931g6.m34302b("Path parameter \"" + this.f26865b + "\" value must not be null.");
            }
            c5970j6.m34513c(this.f26865b, this.f26866c.convert(t10));
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$k */
    public static final class k<T> extends AbstractC5931g6<Map<String, T>> {

        /* renamed from: b */
        public final Converter<T, String> f26867b;

        /* renamed from: c */
        public final boolean f26868c;

        public k(Converter<T, String> converter) {
            this(converter, false);
        }

        public k(Converter<T, String> converter, boolean z10) {
            this.f26867b = converter;
            this.f26868c = z10;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo34304a(C5970j6 c5970j6, Map<String, T> map) throws IOException {
            if (map == null) {
                AbstractC5931g6.m34302b("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    AbstractC5931g6.m34302b("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    AbstractC5931g6.m34302b("Query map contained null value for key '" + key + "'.");
                }
                String strConvert = this.f26867b.convert(value);
                if (strConvert == null) {
                    AbstractC5931g6.m34302b("Query map value '" + value + "' converted to null by " + this.f26867b.getClass().getName() + " for key '" + key + "'.");
                }
                c5970j6.m34511a(key, strConvert, this.f26868c);
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$l */
    public static final class l<T> extends AbstractC5931g6<T> {

        /* renamed from: b */
        public final String f26869b;

        /* renamed from: c */
        public final Converter<T, String> f26870c;

        /* renamed from: d */
        public final boolean f26871d;

        public l(String str, Converter<T, String> converter) {
            this(str, converter, false);
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a */
        public void mo34304a(C5970j6 c5970j6, T t10) throws IOException {
            String strConvert;
            if (t10 == null || (strConvert = this.f26870c.convert(t10)) == null) {
                return;
            }
            c5970j6.m34511a(this.f26869b, strConvert, this.f26871d);
        }

        public l(String str, Converter<T, String> converter, boolean z10) {
            if (str == null) {
                AbstractC5931g6.m34302b("Query parameter name must be not null.");
            }
            this.f26869b = str;
            this.f26870c = converter;
            this.f26871d = z10;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$m */
    public static final class m<T> extends AbstractC5931g6<Map<String, T>> {

        /* renamed from: b */
        public final Converter<T, String> f26872b;

        public m(Converter<T, String> converter) {
            this.f26872b = converter;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo34304a(C5970j6 c5970j6, Map<String, T> map) throws JSONException, IOException {
            if (map == null) {
                AbstractC5931g6.m34302b("Record map was null.");
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key == null) {
                        AbstractC5931g6.m34302b("Record map contained null key.");
                    }
                    T value = entry.getValue();
                    if (value == null) {
                        AbstractC5931g6.m34302b("Record map contained null value for key '" + key + "'.");
                    }
                    String strConvert = this.f26872b.convert(value);
                    if (strConvert == null) {
                        AbstractC5931g6.m34302b("Record map value '" + value + "' converted to null by " + this.f26872b.getClass().getName() + " for key '" + key + "'.");
                    }
                    jSONObject.put(key, strConvert);
                }
                jSONObject2.put("core_metrics_data", jSONObject);
                c5970j6.setMetricsData(jSONObject2.toString());
            } catch (JSONException unused) {
                Logger.m32138e(AbstractC5931g6.f26855a, "parse MetricsData has occurred a JSONException");
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g6$n */
    public static final class n extends AbstractC5931g6<Object> {
        @Override // com.huawei.hms.network.embedded.AbstractC5931g6
        /* renamed from: a */
        public void mo34304a(C5970j6 c5970j6, Object obj) {
            if (obj == null) {
                AbstractC5931g6.m34302b("@Url parameter is null.");
            }
            if (obj instanceof String) {
                c5970j6.m34509a((String) obj);
            } else {
                AbstractC5931g6.m34302b("@Url parameter must be String.");
            }
        }
    }

    /* renamed from: a */
    public final AbstractC5931g6<Object> m34303a() {
        return new a();
    }

    /* renamed from: a */
    public abstract void mo34304a(C5970j6 c5970j6, T t10) throws IOException;

    /* renamed from: b */
    public final AbstractC5931g6<Iterable<T>> m34305b() {
        return new b();
    }

    /* renamed from: b */
    public static void m34302b(String str) {
        throw new IllegalArgumentException(str);
    }
}
