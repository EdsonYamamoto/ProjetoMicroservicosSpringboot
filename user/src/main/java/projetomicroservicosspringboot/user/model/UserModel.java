package projetomicroservicosspringboot.user.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserModel implements AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    //@NotNull
    @Column(nullable = false)
    private String name;

    @Override
    public Long getId() {
        return id;
    }
}
