package com.pr_dm.eco.User.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pr_dm.eco.User.model.Role;
import com.pr_dm.eco.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String nickname;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User (Long userId, String name, String nickname, String email, Role role){
        this.userId =userId;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.role = role;
    }

    public User update(String name, String nickname){
        this.name = name;
        this.nickname = nickname;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

    /*@JsonManagedReference
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public void writeComment(Comment comment){
        this.comments.add(comment);
        comment.writeUser(this);
    }*/

}
