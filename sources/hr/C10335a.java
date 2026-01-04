package hr;

/* renamed from: hr.a */
/* loaded from: classes8.dex */
public final class C10335a {
    /* renamed from: a */
    public static String m63647a(int i10) {
        if (i10 == 0) {
            return "Success";
        }
        if (i10 == -1) {
            return "INVALID";
        }
        if (i10 == 100002 || i10 == 100003) {
            return "The channel requests are too frequent";
        }
        if (i10 == 200001) {
            return "The required parameter is empty or missing";
        }
        if (i10 == 200002) {
            return "Parameter format error";
        }
        if (i10 == 200007) {
            return "Interface authentication failed";
        }
        if (i10 == 200008) {
            return "Log file unique id not found";
        }
        if (i10 == 200009) {
            return "Fragmentation policy is inconsistent";
        }
        if (i10 == 302001) {
            return "The channel does not exist or the channel is illegal";
        }
        if (i10 == 302002) {
            return "The country is not supported";
        }
        if (i10 == 302003) {
            return "The country code does not match the log server site";
        }
        if (i10 == 302004) {
            return "Upload log file is not supported for this mode";
        }
        return "Unknown error:" + i10;
    }
}
