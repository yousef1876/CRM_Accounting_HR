package com.hr.framework.po.business.crm.contact;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "contacts")
@Data
@EntityListeners(EntityListener.class)
public class Contact extends Auditable<Contact>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


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

}
