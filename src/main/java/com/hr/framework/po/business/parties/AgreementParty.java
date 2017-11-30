package com.hr.framework.po.business.parties;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import com.hr.framework.po.business.agreements.AgreementRoleType;
import com.hr.framework.po.business.agreements.Agreements;
import com.hr.framework.po.business.crm.users.AssignedUsers;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name  = "agreement_party")
@Data
@EntityListeners(EntityListener.class)
public class AgreementParty extends Auditable<AgreementParty>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name  = "party_id" , nullable = false)
    private String partyId;

    @Column(name  = "first_name" , nullable = false)
    private String firstName;

    @Column(name  = "second_name" , nullable = false)
    private String secondName;

    @Column(name  = "shortcut" , nullable = false)
    private String shortcut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "user_id" , nullable = false)
    private AssignedUsers assignedUsers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "agreement_id" , nullable = false)
    private Agreements agreements;

    @Column(name  = "group_name" , nullable = false)
    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "role_type" , nullable = false)
    private AgreementRoleType roles;

}
