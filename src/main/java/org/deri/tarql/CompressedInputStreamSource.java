package org.deri.tarql;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;


/**
 * Add compressed input functionality to InputStreamSource
 */
public abstract class CompressedInputStreamSource extends InputStreamSource {

    public static InputStreamSource fromCompressedBytes(final byte[] buffer) {
        return new InputStreamSource() {
            public InputStream open() throws IOException {
                return new GZIPInputStream(new ByteArrayInputStream(buffer));
            }
        };
    }
}
