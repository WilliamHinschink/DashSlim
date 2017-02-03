package com.sibentek.comercial.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author WILLIAM
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "usuario_id", nullable = false)
    private Long usuario_id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Email
    @NotBlank
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String senha;

    @Column(name = "nome_login",nullable = false, length = 20, unique = true)
    private String nomeLogin;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_grupo", joinColumns = {
        @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id", nullable = false, updatable = false)})
    private Set<Grupo> grupos = new HashSet<Grupo>();
}
