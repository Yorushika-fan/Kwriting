package top.kristina.model.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import top.kristina.model.vo.RoleVo;

/**
 * @TableName tb_user
 */
@TableName(value = "tb_user")
@Data
public class User implements Serializable {
    /**
     * 用户主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户邮箱
     */
    private String email;

    @TableField(exist = false)
    private List<RoleVo> roles;

    /**
     * 用户状态,0 正常，1 禁用
     */
    private Integer status;

    /**
     * 逻辑删除 ,0不删除，1删除
     */
    private Integer isDeleted;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(avatar, user.avatar) && Objects.equals(email, user.email) && Objects.equals(roles, user.roles) && Objects.equals(status, user.status) && Objects.equals(isDeleted, user.isDeleted) && Objects.equals(createBy, user.createBy) && Objects.equals(createTime, user.createTime) && Objects.equals(updateBy, user.updateBy) && Objects.equals(updateTime, user.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, avatar, email, roles, status, isDeleted, createBy, createTime, updateBy, updateTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", status=" + status +
                ", isDeleted=" + isDeleted +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}