package com.abiquo.server.core.appslibrary;

import javax.persistence.EntityManager;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abiquo.server.core.common.persistence.DefaultDAOTestBase;
import com.abiquo.server.core.common.persistence.TestDataAccessManager;
import com.softwarementors.bzngine.engines.jpa.test.configuration.EntityManagerFactoryForTesting;
import com.softwarementors.bzngine.entities.test.PersistentInstanceTester;

public class OVFPackageDAOTest extends DefaultDAOTestBase<OVFPackageDAO, OVFPackage>
{

    @BeforeMethod
    protected void methodSetUp()
    {
        super.methodSetUp();
        
        // FIXME: Remember to add all entities that have to be removed during tearDown in the method:
        // com.abiquo.server.core.common.persistence.TestDataAccessManager.initializePersistentInstanceRemovalSupport
    }

    @Override
    protected OVFPackageDAO createDao(EntityManager entityManager)
    {
        return new OVFPackageDAO(entityManager);
    }

    @Override
    protected PersistentInstanceTester<OVFPackage> createEntityInstanceGenerator()
    {
        return new OVFPackageGenerator(getSeed());
    }

    @Override
    protected EntityManagerFactoryForTesting getFactory()
    {
        return TestDataAccessManager.getFactory();
    }

    @Override
    public OVFPackageGenerator eg()
    {
        return (OVFPackageGenerator) super.eg();
    }

    
}
