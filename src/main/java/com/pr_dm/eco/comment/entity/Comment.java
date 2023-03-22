package com.pr_dm.eco.comment.entity;

import com.pr_dm.eco.User.entity.User;
import com.pr_dm.eco.post.entity.Post;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

//    private Long userId;
    @ManyToOne //(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private String text;

    @CreationTimestamp
    private LocalDateTime registerDate = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime modifyDate;

    @ManyToOne //(fetch=FetchType.LAZY)
    @JoinColumn(name="post_id", nullable=false)
    private Post post;


    @Builder
    public Comment(User user, String text, Post post){
        this.user = user;
        this.text = text;
        this.post = post;
    }

    /*private void writtenPost(Post post){
        this.post = post;
        post.getComments().add(this);
    }

    public void writeUser(User user){
        this.userId = userId;
    }*/
}
