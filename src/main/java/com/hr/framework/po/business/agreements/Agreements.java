package com.hr.framework.po.business.agreements;

import com.enums.AgreementType;
import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import com.hr.framework.po.business.crm.meeting.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "agreements")
@Data
@EntityListeners(EntityListener.class)
public class Agreements extends Auditable<Agreements>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name  = "name" , nullable = false)
    private String name;

    @Column(name  = "title" , nullable = false)
    private String titla;

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "note" , nullable = true)
    private String note;

    @Column(name  = "deleted" , nullable = false)
    private boolean isDeleted;

    @Column(name  = "from_date" , nullable = false)
    private Date fromDate;

    @Column(name = "to_date" , nullable = false)
    private Date toDate;

    @Column(name  = "type" , nullable = false)
    private AgreementType type;
}
