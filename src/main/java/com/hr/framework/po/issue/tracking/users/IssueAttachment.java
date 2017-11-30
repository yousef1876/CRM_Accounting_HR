package com.hr.framework.po.issue.tracking.users;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name  = "issue_attachment")
@Data
@EntityListeners(EntityListener.class)
public class IssueAttachment extends Auditable<IssueAttachment>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String attachmentTitle;

    private String attachmentFileName;

    private String fileType;

    private byte[] body;

    /*Issue FK*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "issue_id" , nullable = false)
    private Issue issues;

}
