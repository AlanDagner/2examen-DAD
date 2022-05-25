package pe.edu.upeu.casoexamen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Post{
   private int idpost;
   private String titulo;
   private String descripcion;
}

