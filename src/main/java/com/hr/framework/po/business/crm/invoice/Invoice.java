package com.hr.framework.po.business.crm.invoice;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name  = "invoice")
@Data
@EntityListeners(EntityListener.class)
public class Invoice extends Auditable<Invoice>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
}
