package p213d1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;
import p213d1.AbstractC8975a;
import p213d1.AbstractC8980f;

/* renamed from: d1.h */
/* loaded from: classes.dex */
public class C8982h {

    /* renamed from: a */
    public static final AbstractC8975a.b f45554a = new AbstractC8975a.b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");

    /* renamed from: b */
    public static final AbstractC8975a.b f45556b = new AbstractC8975a.b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");

    /* renamed from: c */
    public static final AbstractC8975a.e f45558c = new AbstractC8975a.e("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");

    /* renamed from: d */
    public static final AbstractC8975a.c f45559d = new AbstractC8975a.c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");

    /* renamed from: e */
    public static final AbstractC8975a.f f45560e = new AbstractC8975a.f("START_SAFE_BROWSING", "START_SAFE_BROWSING");

    /* renamed from: f */
    @Deprecated
    public static final AbstractC8975a.f f45561f = new AbstractC8975a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");

    /* renamed from: g */
    @Deprecated
    public static final AbstractC8975a.f f45562g = new AbstractC8975a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");

    /* renamed from: h */
    public static final AbstractC8975a.f f45563h = new AbstractC8975a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");

    /* renamed from: i */
    public static final AbstractC8975a.f f45564i = new AbstractC8975a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");

    /* renamed from: j */
    public static final AbstractC8975a.f f45565j = new AbstractC8975a.f("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");

    /* renamed from: k */
    public static final AbstractC8975a.c f45566k = new AbstractC8975a.c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");

    /* renamed from: l */
    public static final AbstractC8975a.c f45567l = new AbstractC8975a.c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");

    /* renamed from: m */
    public static final AbstractC8975a.c f45568m = new AbstractC8975a.c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");

    /* renamed from: n */
    public static final AbstractC8975a.c f45569n = new AbstractC8975a.c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");

    /* renamed from: o */
    public static final AbstractC8975a.c f45570o = new AbstractC8975a.c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");

    /* renamed from: p */
    public static final AbstractC8975a.c f45571p = new AbstractC8975a.c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");

    /* renamed from: q */
    public static final AbstractC8975a.b f45572q = new AbstractC8975a.b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");

    /* renamed from: r */
    public static final AbstractC8975a.b f45573r = new AbstractC8975a.b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");

    /* renamed from: s */
    public static final AbstractC8975a.c f45574s = new AbstractC8975a.c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");

    /* renamed from: t */
    public static final AbstractC8975a.f f45575t = new AbstractC8975a.f("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");

    /* renamed from: u */
    public static final AbstractC8975a.c f45576u = new AbstractC8975a.c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");

    /* renamed from: v */
    public static final AbstractC8975a.b f45577v = new AbstractC8975a.b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");

    /* renamed from: w */
    public static final AbstractC8975a.b f45578w = new AbstractC8975a.b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");

    /* renamed from: x */
    public static final AbstractC8975a.f f45579x = new AbstractC8975a.f("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");

    /* renamed from: y */
    public static final AbstractC8975a.f f45580y = new AbstractC8975a.f("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");

    /* renamed from: z */
    public static final AbstractC8975a.f f45581z = new AbstractC8975a.f("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");

    /* renamed from: A */
    public static final AbstractC8975a.b f45528A = new AbstractC8975a.b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");

    /* renamed from: B */
    public static final AbstractC8975a.b f45529B = new AbstractC8975a.b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");

    /* renamed from: C */
    public static final AbstractC8975a.d f45530C = new AbstractC8975a.d("WEB_MESSAGE_GET_MESSAGE_PAYLOAD", "WEB_MESSAGE_GET_MESSAGE_PAYLOAD");

    /* renamed from: D */
    public static final AbstractC8975a.b f45531D = new AbstractC8975a.b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");

    /* renamed from: E */
    public static final AbstractC8975a.b f45532E = new AbstractC8975a.b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");

    /* renamed from: F */
    public static final AbstractC8975a.b f45533F = new AbstractC8975a.b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");

    /* renamed from: G */
    public static final AbstractC8975a.b f45534G = new AbstractC8975a.b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");

    /* renamed from: H */
    public static final AbstractC8975a.e f45535H = new AbstractC8975a.e("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");

    /* renamed from: I */
    public static final AbstractC8975a.e f45536I = new AbstractC8975a.e("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");

    /* renamed from: J */
    public static final AbstractC8975a.h f45537J = new AbstractC8975a.h("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");

    /* renamed from: K */
    public static final AbstractC8975a.h f45538K = new AbstractC8975a.h("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");

    /* renamed from: L */
    public static final AbstractC8975a.g f45539L = new AbstractC8975a.g("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");

    /* renamed from: M */
    public static final AbstractC8980f.b f45540M = new AbstractC8980f.b("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");

    /* renamed from: N */
    public static final AbstractC8980f.a f45541N = new AbstractC8980f.a("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");

    /* renamed from: O */
    public static final AbstractC8975a.h f45542O = new AbstractC8975a.h("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");

    /* renamed from: P */
    public static final AbstractC8975a.i f45543P = new a("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");

    /* renamed from: Q */
    public static final AbstractC8975a.d f45544Q = new AbstractC8975a.d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");

    /* renamed from: R */
    public static final AbstractC8975a.d f45545R = new AbstractC8975a.d("SUPPRESS_ERROR_PAGE", "SUPPRESS_ERROR_PAGE");

    /* renamed from: S */
    public static final AbstractC8975a.d f45546S = new AbstractC8975a.d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");

    /* renamed from: T */
    public static final AbstractC8975a.h f45547T = new AbstractC8975a.h("FORCE_DARK", "FORCE_DARK");

    /* renamed from: U */
    public static final AbstractC8975a.d f45548U = new AbstractC8975a.d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");

    /* renamed from: V */
    public static final AbstractC8975a.d f45549V = new AbstractC8975a.d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");

    /* renamed from: W */
    public static final AbstractC8975a.d f45550W = new AbstractC8975a.d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");

    /* renamed from: X */
    public static final AbstractC8975a.d f45551X = new AbstractC8975a.d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");

    /* renamed from: Y */
    public static final AbstractC8975a.d f45552Y = new AbstractC8975a.d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");

    /* renamed from: Z */
    public static final AbstractC8975a.d f45553Z = new AbstractC8975a.d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");

    /* renamed from: a0 */
    public static final AbstractC8975a.d f45555a0 = new AbstractC8975a.d("GET_COOKIE_INFO", "GET_COOKIE_INFO");

    /* renamed from: b0 */
    public static final AbstractC8975a.d f45557b0 = new AbstractC8975a.d("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");

    /* renamed from: d1.h$a */
    public class a extends AbstractC8975a.i {

        /* renamed from: d */
        public final Pattern f45582d;

        public a(String str, String str2) {
            super(str, str2);
            this.f45582d = Pattern.compile("\\A\\d+");
        }

        @Override // p213d1.AbstractC8975a
        /* renamed from: d */
        public boolean mo56789d() {
            return super.mo56789d();
        }
    }

    /* renamed from: a */
    public static UnsupportedOperationException m56806a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    /* renamed from: b */
    public static boolean m56807b(String str) {
        return m56808c(str, AbstractC8975a.m56785e());
    }

    /* renamed from: c */
    public static <T extends InterfaceC8978d> boolean m56808c(String str, Collection<T> collection) {
        HashSet hashSet = new HashSet();
        for (T t10 : collection) {
            if (t10.mo56786a().equals(str)) {
                hashSet.add(t10);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature " + str);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((InterfaceC8978d) it.next()).mo56787b()) {
                return true;
            }
        }
        return false;
    }
}
