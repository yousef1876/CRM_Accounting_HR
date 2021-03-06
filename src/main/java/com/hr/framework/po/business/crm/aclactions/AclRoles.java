package com.hr.framework.po.business.crm.aclactions;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name  = "acl_roles")
@Data
@EntityListeners(EntityListener.class)
public class AclRoles extends Auditable<AclRoles>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_name", updatable = false, nullable = false)
    private String roleName;


    @ManyToMany(mappedBy = "acls")
    private List<Actions> actionsList = new ArrayList<>();


    @ManyToMany(mappedBy = "users")
    private List<Actions> users = new ArrayList<>();

}
