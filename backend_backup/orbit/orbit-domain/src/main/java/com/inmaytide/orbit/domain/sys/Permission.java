package com.inmaytide.orbit.domain.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.inmaytide.orbit.domain.basic.BasicEntity;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mybatis.annotations.Entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity(table = "sys_permission")
public class Permission extends BasicEntity {

    private static final long serialVersionUID = -5401749095217234229L;

    @NotBlank
    @Length(max = 32)
    private String code;

    @NotBlank
    @Length(max = 64)
    private String name;

    @Length(max = 256)
    private String action;

    @Length(max = 256)
    private String icon;

    @NotNull
    private String category;

    @Length(max = 256)
    private String description;

    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parent;

    private Integer sort;

    @Transient
    private List<Permission> children;

    @Transient
    private Boolean spread;

    public Permission() {
    }

    public Permission(Long id, Integer sort, int version) {
        this.setId(id);
        this.sort = sort;
        this.setVersion(version);
    }

    public static Permission of(Long id) {
        Permission permission = new Permission();
        permission.setId(id);
        return permission;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public Boolean getSpread() {
        if (spread == null) {
            spread = false;
        }
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !Permission.class.isInstance(obj)) {
            return false;
        }
        Permission other = (Permission) obj;
        return Objects.equals(other.getId(), this.getId());
    }
}
