package com.hr.framework.po.business.crm;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import com.hr.framework.po.business.crm.users.AssignedUsers;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "accounts_cases")
@Data
@EntityListeners(EntityListener.class)
public class AccountsCases extends Auditable<AccountsCases> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name  = "assigned_user_id" , nullable = false)
    private AssignedUsers assignedUsers;


    private boolean isDeleted;

}
