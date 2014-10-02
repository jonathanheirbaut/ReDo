package com.realdolmen.travel.common;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.transaction.*;

/**
 * Created by JHRAU70 on 1/10/2014.
 */
public class AbstractArquillianTestCase {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addPackages(true, "com.realdolmen.travel")
                .addAsResource("META-INF/test-persistence.xml",
                        "META-INF/persistence.xml")
                .addAsResource("import.sql", "import.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
/*    @Resource
    private UserTransaction tx;

    @Before
    public void init() throws SystemException, NotSupportedException {
        tx.begin();
    }

    @After
    public void destroy() throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {
        tx.rollback();
    }*/
}
