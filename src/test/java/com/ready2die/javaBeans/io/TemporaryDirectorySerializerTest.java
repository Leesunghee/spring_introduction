package com.ready2die.javaBeans.io;

import com.ready2die.javaBeans.TemporaryDirectory;
import org.junit.experimental.theories.DataPoint;

public class TemporaryDirectorySerializerTest extends com.cedarsoft.serialization.test.utils.AbstractJsonSerializerTest2<TemporaryDirectory> {
    @org.jetbrains.annotations.NotNull
    @DataPoint
    public static final com.cedarsoft.serialization.test.utils.Entry<? extends TemporaryDirectory> ENTRY1 = com.cedarsoft.serialization.test.utils.AbstractSerializerTest2.create(
            new TemporaryDirectory(
                    99
            ),
            TemporaryDirectorySerializerTest.class.getResource("TemporaryDirectory_1.0.0_1.json"));

    @org.jetbrains.annotations.NotNull
    @Override
    protected com.cedarsoft.serialization.StreamSerializer<TemporaryDirectory> getSerializer() throws Exception {
        return com.google.inject.Guice.createInjector().getInstance(TemporaryDirectorySerializer.class);
    }
}
