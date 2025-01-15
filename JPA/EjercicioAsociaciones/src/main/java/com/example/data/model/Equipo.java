package com.example.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipo {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "equipo", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private Set<Jugador> jugadores = new HashSet<>();

    //Metodos Helper

    public void addJugador(Jugador j){
        j.setEquipo(this);
        this.getJugadores().add(j);
    }

    public void removeJugador(Jugador j){
        this.getJugadores().remove(j);
        j.setEquipo(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Equipo equipo = (Equipo) o;
        return getId() != null && Objects.equals(getId(), equipo.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
