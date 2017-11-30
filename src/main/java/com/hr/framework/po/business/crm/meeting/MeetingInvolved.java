package com.hr.framework.po.business.crm.meeting;


import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import com.hr.framework.po.business.crm.users.AssignedUsers;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name  = "meeting_invloved")
@Data
@EntityListeners(EntityListener.class)
public class MeetingInvolved extends Auditable<MeetingInvolved>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private AssignedUsers assignedUsers;

    private Rooms rooms;


    private boolean isleads;


    private boolean isDeleted;





}
