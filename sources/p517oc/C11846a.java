package p517oc;

/* renamed from: oc.a */
/* loaded from: classes3.dex */
public class C11846a {
    private String guid = null;
    private String luid = null;
    private int status = -1;
    private String etag = null;
    private String uuid = null;
    private String hash = null;

    private <T> T commonSetFunction(T t10) {
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public String getEtag() {
        return (String) commonSetFunction(this.etag);
    }

    public String getGuid() {
        return (String) commonSetFunction(this.guid);
    }

    public String getHash() {
        return (String) commonSetFunction(this.hash);
    }

    public String getLuid() {
        return (String) commonSetFunction(this.luid);
    }

    public int getStatus() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.status))).intValue();
    }

    public String getUuid() {
        return (String) commonSetFunction(this.uuid);
    }

    public void setEtag(String str) {
        this.etag = (String) commonSetFunction(str);
    }

    public void setGuid(String str) {
        this.guid = (String) commonSetFunction(str);
    }

    public void setHash(String str) {
        this.hash = (String) commonSetFunction(str);
    }

    public void setLuid(String str) {
        this.luid = (String) commonSetFunction(str);
    }

    public void setStatus(int i10) {
        this.status = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setUuid(String str) {
        this.uuid = (String) commonSetFunction(str);
    }
}
