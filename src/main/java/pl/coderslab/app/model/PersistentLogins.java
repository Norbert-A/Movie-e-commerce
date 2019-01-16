package pl.coderslab.app.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class PersistentLogins {

    @Id
    private String series;
    @NotNull
    private String username;
    @NotNull
    private String token;
    @CreationTimestamp
    @NotNull
    private LocalDateTime lastUsed;
}

