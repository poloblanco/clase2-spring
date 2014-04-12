package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upiita.spring.jdbc.entidades.Usuario;

@Component("UsuarioDAO")
public class HibernateUsuarioDAO implements UsuarioDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Usuario buscaUsuarioPorId(Integer usuarioId) {
		
		Session sesion = sessionFactory.openSession();// Creamos una sesion de hibernate
		sesion.beginTransaction();// se abre una transaccion
		
		//Busaca por id en la tabla mapeada por la clase usuario
		//El renglon cuyo id sea igual a usuario id
		//Si no hay nada retorna NULL
		Usuario usuario = (Usuario) sesion.get(Usuario.class,  usuarioId);
		
		//termina la transaccion
		sesion.getTransaction().commit();
		
		//cerramos la sesion de hibernate
		sesion.close();
		
		return usuario;
	}

	public void creaUsuario(Usuario usuario) {
		
		Session sesion = sessionFactory.openSession();// Creamos una sesion de hibernate
		sesion.beginTransaction();// se abre una transaccion
		
		//Busaca por id en la tabla mapeada por la clase usuario
		//El renglon cuyo id sea igual a usuario id
		//Si no hay nada retorna NULL
		
		sesion.save(usuario);
		
		//termina la transaccion
		sesion.getTransaction().commit();
		
		//cerramos la sesion de hibernate
		sesion.close();
		

	}
	
	public Usuario buscaporEmail(String email){
		
		Session sesion = sessionFactory.openSession();// Creamos una sesion de hibernate
		sesion.beginTransaction();// se abre una transaccion
		
		//termina la transaccion
		Criteria criterio = sesion.createCriteria(Usuario.class);
		
		criterio.add(Restrictions.eq("email", email));
		
		//SI SABEN QUE VA A REGRESAR UNA SOLA ENTIDAD
		Usuario usuario = (Usuario) criterio.uniqueResult();
		
		//cerramos la sesion de hibernate
		sesion.close();
		
		return usuario;
		
	}
	
	public List<Usuario> obtenPorNombre(String nombre){
		
		Session sesion = sessionFactory.openSession();// Creamos una sesion de hibernate
		sesion.beginTransaction();// se abre una transaccion
		
		//termina la transaccion
		Criteria criterio = sesion.createCriteria(Usuario.class);
		
		criterio.add(Restrictions.not(Restrictions.like("nombre","%" + nombre + "%")));
		
		//SI SABEN QUE VA A REGRESAR UNA SOLA ENTIDAD
		List<Usuario> usuarios = criterio.list();
		
		//cerramos la sesion de hibernate
		sesion.close();
		
		return usuarios;
		
	}

}
