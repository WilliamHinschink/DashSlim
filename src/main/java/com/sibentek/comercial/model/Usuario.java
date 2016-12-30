package com.sibentek.comercial.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author WILLIAM
 */
@Data
@EqualsAndHashCode
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue
    private Long id;
    
    @NotBlank
    @Column(nullable = false, length = 80)
    private String nome;
    
    @NotBlank
    @Column(nullable = false, length = 255, unique = true)
    private String email;
    
    @NotBlank
    @Column(nullable = false, length = 50)
    private String senha;
    
    @Column(nullable = false, length = 20, unique = true)
    private String nomeLogin;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private List<Grupo> grupos = new ArrayList<>();
}
