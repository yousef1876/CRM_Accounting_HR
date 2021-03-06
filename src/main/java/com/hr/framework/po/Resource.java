package com.hr.framework.po;

import com.hr.framework.enums.ValidFlag;
import com.hr.framework.listener.PersistentListener;
import com.hr.framework.listener.ValidFlagListener;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "resources")
@EntityListeners({PersistentListener.class, ValidFlagListener.class})
@NamedEntityGraph(name = "Resource.roles", attributeNodes = @NamedAttributeNode("roles"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "roles")
@ToString(exclude = "roles")
public class Resource implements GrantedAuthority, Serializable {

  private static final long serialVersionUID = 6298843159549723556L;

  /*public Resource(){
	  
  }*/
  
  @GenericGenerator(
      name = "resourceSequenceGenerator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
          @Parameter(name = "sequence_name", value = "resources_seq"),
          @Parameter(name = "initial_value", value = "1"),
          @Parameter(name = "increment_size", value = "1")
      }
  )
  @Id
  @GeneratedValue(generator = "resourceSequenceGenerator")
  @Column(updatable = false)
  private long id;

  @NotEmpty
  @Column(unique = true, nullable = false, length = 20)
  private String name;

  @Column(length = 500)
  private String description;

  @Column(nullable = false)
  @Builder.Default
  private ValidFlag validFlag = ValidFlag.VALID;

  @Column(nullable = false, updatable = false)
  private long createdAt;

  @Column(nullable = false, updatable = false)
  private long createdBy;

  @Column(nullable = false)
  private long lastModifiedAt;

  @Column(nullable = false)
  private long lastModifiedBy;

  @Version
  @Column(nullable = false)
  private int version;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "resources", cascade = CascadeType.REFRESH)
  private Set<Role> roles;

  @PreRemove
  private void removeResourcesFromRoles() {
    roles.forEach(role -> role.getResources().remove(this));
  }

  public Resource(Long id) {
    this.id = id;
  }

  public Resource(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public String getAuthority() {
    return name;
  }

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public ValidFlag getValidFlag() {
	return validFlag;
}

public void setValidFlag(ValidFlag validFlag) {
	this.validFlag = validFlag;
}

public long getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(long createdAt) {
	this.createdAt = createdAt;
}

public long getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(long createdBy) {
	this.createdBy = createdBy;
}

public long getLastModifiedAt() {
	return lastModifiedAt;
}

public void setLastModifiedAt(long lastModifiedAt) {
	this.lastModifiedAt = lastModifiedAt;
}

public long getLastModifiedBy() {
	return lastModifiedBy;
}

public void setLastModifiedBy(long lastModifiedBy) {
	this.lastModifiedBy = lastModifiedBy;
}

public int getVersion() {
	return version;
}

public void setVersion(int version) {
	this.version = version;
}

public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}


}
