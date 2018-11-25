package com.ready2die.javaBeans.io;

import com.ready2die.javaBeans.TemporaryDirectory;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;

public class TemporaryDirectorySerializerVersionTest extends com.cedarsoft.serialization.test.utils.AbstractJsonVersionTest2<TemporaryDirectory> {
    @org.jetbrains.annotations.NotNull
    @DataPoint
    public static final com.cedarsoft.serialization.test.utils.VersionEntry ENTRY1 = com.cedarsoft.serialization.test.utils.AbstractJsonVersionTest2.create(
            com.cedarsoft.version.Version.valueOf(1, 0, 0), TemporaryDirectorySerializerVersionTest.class.getResource("TemporaryDirectory_1.0.0_1.json"));

    @org.jetbrains.annotations.NotNull
    @Override
    protected com.cedarsoft.serialization.StreamSerializer<TemporaryDirectory> getSerializer() throws Exception {
        return com.google.inject.Guice.createInjector().getInstance(TemporaryDirectorySerializer.class);
    }

    @Override
    protected void verifyDeserialized(@org.jetbrains.annotations.NotNull TemporaryDirectory deserialized, @org.jetbrains.annotations.NotNull com.cedarsoft.version.Version version) {
        Assert.assertNotNull(deserialized.getSerialVersionUID());
    }
}
