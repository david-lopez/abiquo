/**
 * Abiquo community edition
 * cloud management application for hybrid clouds
 * Copyright (C) 2008-2010 - Abiquo Holdings S.L.
 *
 * This application is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC
 * LICENSE as published by the Free Software Foundation under
 * version 3 of the License
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * LESSER GENERAL PUBLIC LICENSE v.3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package com.abiquo.api.resources;

import static com.abiquo.api.common.UriTestResolver.resolvePrivateNetworksURI;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.Random;

import javax.ws.rs.core.MediaType;

import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abiquo.model.enumerator.RemoteServiceType;
import com.abiquo.server.core.cloud.VirtualDatacenter;
import com.abiquo.server.core.enterprise.Enterprise;
import com.abiquo.server.core.enterprise.Role;
import com.abiquo.server.core.enterprise.User;
import com.abiquo.server.core.infrastructure.RemoteService;
import com.abiquo.server.core.infrastructure.network.NetworkConfigurationDto;
import com.abiquo.server.core.infrastructure.network.VLANNetwork;
import com.abiquo.server.core.infrastructure.network.VLANNetworkDto;
import com.abiquo.server.core.infrastructure.network.VLANNetworksDto;

/**
 * Acceptance test for the creation of PrivateNetworks and retrieve of a list of them.
 * 
 * @author jdevesa@abiquo.com
 */
public class PrivateNetworksResourceIT extends AbstractJpaGeneratorIT
{


    private String badURI = resolvePrivateNetworksURI(3);

    VirtualDatacenter vdc;
    RemoteService rs;
    VLANNetwork vlan;
    Enterprise sysEnterprise;

    @BeforeMethod
    public void setUp()
    {
        rs = remoteServiceGenerator.createInstance(RemoteServiceType.DHCP_SERVICE);
        vdc = vdcGenerator.createInstance(rs.getDatacenter());
        sysEnterprise = enterpriseGenerator.createUniqueInstance();
        Role r = roleGenerator.createInstance(Role.Type.SYS_ADMIN);

        User u = userGenerator.createInstance(sysEnterprise, r, "sysadmin", "sysadmin");
        setup(sysEnterprise, r, u, vdc.getDatacenter(), rs, vdc.getEnterprise(), vdc.getNetwork(), vdc);

    }

    @AfterMethod
    public void tearDown()
    {
        tearDown("virtualapp", "ip_pool_management", "rasd_management", "virtualdatacenter",
            "vlan_network", "network_configuration", "dhcp_service", "remote_service",
            "datacenter", "network", "user", "role", "enterprise");
    }

    @Test
    public void getPrivateNetworks()
    {
        Resource resource = client.resource(resolvePrivateNetworksURI(vdc.getId()));

        vlan = vlanGenerator.createInstance(vdc.getNetwork(), rs, "255.255.255.0");
        VLANNetwork vlan2 = vlanGenerator.createInstance(vdc.getNetwork(), rs, "255.255.255.0");

        setup(vlan.getConfiguration().getDhcp(), vlan.getConfiguration(), vlan, vlan2
            .getConfiguration().getDhcp(), vlan2.getConfiguration(), vlan2);

        ClientResponse response = resource.accept(MediaType.APPLICATION_XML).get();
        assertEquals(200, response.getStatusCode());
        VLANNetworksDto entity = response.getEntity(VLANNetworksDto.class);
        assertNotNull(entity);
        assertNotNull(entity.getCollection());
        assertEquals(entity.getCollection().size(), 2);
    }

    @Test
    public void getPrivateNetworksListInvalidVDC() throws Exception
    {
        Resource resource = client.resource(resolvePrivateNetworksURI(new Random().nextInt()));

        ClientResponse response = resource.accept(MediaType.APPLICATION_XML).get();
        assertEquals(404, response.getStatusCode());
    }
    
    @Test
    public void createPrivateNetwork()
    {        
        VLANNetwork vlan2 = vlanGenerator.createInstance(vdc.getNetwork(), rs, "255.255.255.0");
        VLANNetworkDto dto = createValidNetworkDto();
        
        ClientResponse response = post(resolvePrivateNetworksURI(vdc.getId()), dto, "sysadmin", "sysadmin");
        
        assertEquals(201, response.getStatusCode());
        
    }

    private VLANNetworkDto createValidNetworkDto()
    {
       
        NetworkConfigurationDto configDto = new NetworkConfigurationDto();
        configDto.setAddress("192.168.0.0");
        configDto.setDefaultNetwork(true);
        configDto.setFenceMode("bridge");
        configDto.setGateway("192.168.0.1");
        configDto.setMask(24);
        configDto.setNetMask("255.255.255.248");
        configDto.setNetworkName("KVM VLAN");
        configDto.setPrimaryDNS("10.0.0.1");
        configDto.setSecondaryDNS("10.0.0.1");

        VLANNetworkDto networkDto = new VLANNetworkDto();
        networkDto.setName("Default Network");
        networkDto.setDefaultNetwork(Boolean.TRUE);
        networkDto.setNetworkConfiguration(configDto);
        
        return networkDto;
    }
}
