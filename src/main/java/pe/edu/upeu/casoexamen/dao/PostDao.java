package pe.edu.upeu.casoexamen.dao;

import java.util.List;
import pe.edu.upeu.casoexamen.model.Post;
/**
*
*@author admin
*/
public interface PostDao{
    int create(Post post);
    int update(Post post);
    int delete(int id);
    Post read(int id);
    List<Post>readAll();
}