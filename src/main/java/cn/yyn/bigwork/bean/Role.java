package cn.yyn.bigwork.bean;

/**
 * @author 杨以诺
 * by 2020-06-27 20:57
 */
public class Role {
    private Integer roleId;     //角色id
    private String roleName;    //角色名称
    private String comment;     //角色名称注释

    public Role() {
    }

    public Role(Integer roleId, String roleName, String comment) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
