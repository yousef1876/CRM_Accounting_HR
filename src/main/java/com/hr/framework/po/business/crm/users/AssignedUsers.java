package com.hr.framework.po.business.crm.users;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.po.business.crm.Accounts;
import com.hr.framework.po.business.crm.aclactions.AclRoles;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "assigned_users")
@Data
public class AssignedUsers extends Auditable<AssignedUsers>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    /*@Column(name = "login" , nullable = false)
    private String login;

    @Column(name  = "password" , nullable = false)
    private String password;*/

    @Column(name  = "first_name" , nullable = false)
    private String firstName;

    @Column(name  = "second_name" , nullable = true)
    private String secondName;

    @Column(name  = "last_name" , nullable = false)
    private String lastName;

    @Column(name  = "pw_last_changed" , nullable = true)
    private Date pwdlastChanged;

    @Column(name  = "auth_id" , nullable = false)
    private String authenticateId;

    @Column(name = "is_admin" , nullable = true)
    private boolean isAdmin;

    @Column(name = "is_deleted" , nullable = true)
    private boolean isDeleted;

    @Column(name  = "super_admin" , nullable = true)
    private boolean superAdmin;

    @Column(name  = "title" , nullable = true)
    private String title;

    @Column(name  = "phone_home" , nullable = true)
    private String phoneHome;

    @Column(name  = "mobile_home" , nullable = true)
    private String mobileHome;

    @Column(name  = "mobile_work" , nullable = true)
    private String mobileWork;

    @Column(name  = "phone_work" , nullable = true)
    private String phoneWork;

    @Column(name  = "is_accessible" , nullable = true)
    private boolean isAccessible;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "account_id" , nullable = false)
    private Accounts accounts;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "acl_role_users",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<AclRoles> users = new ArrayList<>();


}
