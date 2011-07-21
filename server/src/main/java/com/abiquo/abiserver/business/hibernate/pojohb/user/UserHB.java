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

package com.abiquo.abiserver.business.hibernate.pojohb.user;

// Generated 16-oct-2008 16:52:14 by Hibernate Tools 3.2.1.GA

import com.abiquo.abiserver.business.hibernate.pojohb.IPojoHB;
import com.abiquo.abiserver.pojo.user.User;
import com.abiquo.server.core.enterprise.User.AuthType;

/**
 * User generated by hbm2java
 */
public class UserHB implements java.io.Serializable, IPojoHB<User>
{

    private static final long serialVersionUID = 6655290980964418462L;

    private Integer idUser;

    private RoleHB roleHB;

    private String user;

    private String name;

    private String surname;

    private String description;

    private String email;

    private String locale;

    private String password;

    private Integer active;

    private EnterpriseHB enterpriseHB;

    private String availableVirtualDatacenters;

    private String authType;

    public String getAvailableVirtualDatacenters()
    {
        return availableVirtualDatacenters;
    }

    public void setAvailableVirtualDatacenters(String availableVirtualDatacenters)
    {
        this.availableVirtualDatacenters = availableVirtualDatacenters;
    }

    public Integer getIdUser()
    {
        return idUser;
    }

    public void setIdUser(Integer idUser)
    {
        this.idUser = idUser;
    }

    public RoleHB getRoleHB()
    {
        return roleHB;
    }

    public void setRoleHB(RoleHB roleHB)
    {
        this.roleHB = roleHB;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLocale()
    {
        return locale;
    }

    public void setLocale(String locale)
    {
        this.locale = locale;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getActive()
    {
        return active;
    }

    public void setActive(Integer active)
    {
        this.active = active;
    }

    public EnterpriseHB getEnterpriseHB()
    {
        return enterpriseHB;
    }

    public void setEnterpriseHB(EnterpriseHB enterpriseHB)
    {
        this.enterpriseHB = enterpriseHB;
    }

    public String getAuthType()
    {
        return authType;
    }

    public void setAuthType(String authType)
    {
        this.authType = authType;
    }

    public User toPojo()
    {
        User user = new User();

        user.setId(idUser);
        user.setRole(roleHB.toPojo());
        user.setUser(this.user);
        user.setName(name);
        user.setSurname(surname);
        user.setDescription(description);
        user.setEmail(email);
        user.setPass(password);
        user.setActive(active == 1 ? true : false);
        user.setAuthType(AuthType.valueOf(authType));
        user.setLocale(locale);
        if (enterpriseHB != null)
        {
            user.setEnterprise(enterpriseHB.toPojo());
        }
        else
        {
            user.setEnterprise(null);
        }

        return user;
    }

}
