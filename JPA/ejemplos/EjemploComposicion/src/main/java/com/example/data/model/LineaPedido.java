package com.example.data.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(LineaPedidoId.class)
public class LineaPedido {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Producto producto;

    private int cantidad;

    private double precioVenta;

    @Id
    @ManyToOne
    private Pedido pedido;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        LineaPedido that = (LineaPedido) o;
        return getId() != null && Objects.equals(getId(), that.getId())
                && getPedido() != null && Objects.equals(getPedido(), that.getPedido());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id, pedido);
    }
}
