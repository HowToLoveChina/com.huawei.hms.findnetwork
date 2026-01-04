package org.chromium.net.impl;

import android.content.Context;
import android.util.Base64;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.IDN;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.chromium.net.CronetEngine;
import org.chromium.net.ICronetEngineBuilder;
import org.chromium.net.impl.VersionSafeCallbacks;

/* loaded from: classes9.dex */
public abstract class CronetEngineBuilderImpl extends ICronetEngineBuilder {
    private static final Pattern INVALID_PKP_HOST_NAME = Pattern.compile("^[0-9\\.]*$");
    private static final int INVALID_THREAD_PRIORITY = 20;
    private final Context mApplicationContext;
    private boolean mBrotiEnabled;
    private String mExperimentalOptions;
    private boolean mHttp2Enabled;
    protected long mMockCertVerifier;
    private boolean mNetworkQualityEstimatorEnabled;
    private boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    private boolean mQuicEnabled;
    private String mStoragePath;
    private boolean mTextTransmissionEnabled;
    private String mUserAgent;
    private final List<QuicHint> mQuicHints = new LinkedList();
    private final List<Pkp> mPkps = new LinkedList();
    private int mThreadPriority = 20;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpCacheSetting {
    }

    public static class Pkp {
        final Date mExpirationDate;
        final byte[][] mHashes;
        final String mHost;
        final boolean mIncludeSubdomains;

        public Pkp(String str, byte[][] bArr, boolean z10, Date date) {
            this.mHost = str;
            this.mHashes = bArr;
            this.mIncludeSubdomains = z10;
            this.mExpirationDate = date;
        }
    }

    public static class QuicHint {
        final int mAlternatePort;
        final String mHost;
        final int mPort;

        public QuicHint(String str, int i10, int i11) {
            this.mHost = str;
            this.mPort = i10;
            this.mAlternatePort = i11;
        }
    }

    public CronetEngineBuilderImpl(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        enableQuic(true);
        enableHttp2(true);
        enableBrotli(false);
        enableNetworkQualityEstimator(false);
        enablePublicKeyPinningBypassForLocalTrustAnchors(true);
    }

    private static String validateHostNameForPinningAndConvert(String str) throws IllegalArgumentException {
        if (INVALID_PKP_HOST_NAME.matcher(str).matches()) {
            throw new IllegalArgumentException("Hostname " + str + " is illegal. A hostname should not consist of digits and/or dots only.");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("Hostname " + str + " is too long. The name of the host does not comply with RFC 1122 and RFC 1123.");
        }
        try {
            return IDN.toASCII(str, 2);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Hostname " + str + " is illegal. The name of the host does not comply with RFC 1122 and RFC 1123.");
        }
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addPublicKeyPins(String str, Set set, boolean z10, Date date) {
        return addPublicKeyPins(str, (Set<byte[]>) set, z10, date);
    }

    public boolean brotliEnabled() {
        return this.mBrotiEnabled;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpCache(int i10, long j10) {
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableSdch(boolean z10) {
        return this;
    }

    public String experimentalOptions() {
        return this.mExperimentalOptions;
    }

    public Context getContext() {
        return this.mApplicationContext;
    }

    public String getDefaultQuicUserAgentId() {
        return this.mQuicEnabled ? UserAgent.getQuicUserAgentIdFrom(this.mApplicationContext) : "";
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public String getDefaultUserAgent() {
        return UserAgent.from(this.mApplicationContext);
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public boolean http2Enabled() {
        return this.mHttp2Enabled;
    }

    public VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return null;
    }

    public long mockCertVerifier() {
        return this.mMockCertVerifier;
    }

    public boolean networkQualityEstimatorEnabled() {
        return this.mNetworkQualityEstimatorEnabled;
    }

    public boolean publicKeyPinningBypassForLocalTrustAnchorsEnabled() {
        return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    }

    public List<Pkp> publicKeyPins() {
        return this.mPkps;
    }

    public boolean quicEnabled() {
        return this.mQuicEnabled;
    }

    public List<QuicHint> quicHints() {
        return this.mQuicHints;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
        return this;
    }

    public CronetEngineBuilderImpl setMockCertVerifierForTesting(long j10) {
        this.mMockCertVerifier = j10;
        return this;
    }

    public String storagePath() {
        return this.mStoragePath;
    }

    public boolean textTransmissionEnabled() {
        return this.mTextTransmissionEnabled;
    }

    public int threadPriority(int i10) {
        int i11 = this.mThreadPriority;
        return i11 == 20 ? i10 : i11;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addPublicKeyPins(String str, Set<byte[]> set, boolean z10, Date date) throws IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException("The hostname cannot be null");
        }
        if (set == null) {
            throw new NullPointerException("The set of SHA256 pins cannot be null");
        }
        if (date == null) {
            throw new NullPointerException("The pin expiration date cannot be null");
        }
        String strValidateHostNameForPinningAndConvert = validateHostNameForPinningAndConvert(str);
        HashMap map = new HashMap();
        for (byte[] bArr : set) {
            if (bArr == null || bArr.length != 32) {
                throw new IllegalArgumentException("Public key pin is invalid");
            }
            map.put(Base64.encodeToString(bArr, 0), bArr);
        }
        this.mPkps.add(new Pkp(strValidateHostNameForPinningAndConvert, (byte[][]) map.values().toArray(new byte[map.size()][]), z10, date));
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addQuicHint(String str, int i10, int i11) {
        if (!str.contains("/")) {
            this.mQuicHints.add(new QuicHint(str, i10, i11));
            return this;
        }
        throw new IllegalArgumentException("Illegal QUIC Hint Host: " + str);
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBrotli(boolean z10) {
        this.mBrotiEnabled = z10;
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttp2(boolean z10) {
        this.mHttp2Enabled = z10;
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableNetworkQualityEstimator(boolean z10) {
        this.mNetworkQualityEstimatorEnabled = z10;
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z10) {
        this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = z10;
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableQuic(boolean z10) {
        this.mQuicEnabled = z10;
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableTextTransmission(boolean z10) {
        this.mTextTransmissionEnabled = z10;
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setExperimentalOptions(String str) {
        this.mExperimentalOptions = str;
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoragePath(String str) {
        if (!new File(str).isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.mStoragePath = str;
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadPriority(int i10) {
        if (i10 > 19 || i10 < -20) {
            throw new IllegalArgumentException("Thread priority invalid");
        }
        this.mThreadPriority = i10;
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setUserAgent(String str) {
        this.mUserAgent = str;
        return this;
    }
}
