package org.example.expert.domain.log.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.expert.domain.common.entity.Timestamped;
import org.example.expert.domain.manager.entity.Manager;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "logs")
public class Log extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long userId;
    private Long managerId;
    private Long todoId;

    private String message; // 매니저 등록 관련 메세지

    public Log(Manager manager,String message) {
        this.userId = manager.getUser().getId();
        this.managerId = manager.getId();
        this.todoId = manager.getTodo().getId();
        this.message = message;
    }

    public static Log of(Manager manager, String message) {
        return new Log(manager, message);
    }
}
