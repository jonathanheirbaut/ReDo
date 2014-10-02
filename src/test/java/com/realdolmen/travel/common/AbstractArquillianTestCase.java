package com.realdolmen.travel.common;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

/**
 * Created by JHRAU70 on 1/10/2014.
 */
public class AbstractArquillianTestCase {
    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addPackages(true, "com.realdolmen.travel")
                .addAsResource("META-INF/test-persistence.xml",
                        "META-INF/persistence.xml")
                .addAsResource("import.sql", "import.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
}
