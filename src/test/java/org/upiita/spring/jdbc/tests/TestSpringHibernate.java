package org.upiita.spring.jdbc.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.upiita.spring.jdbc.daos.UsuarioDAO;
import org.upiita.spring.jdbc.entidades.Usuario;



public class TestSpringHibernate {

	public static void main(String[] args) {
		//creamos el contexto de Spring
		ApplicationContext contexto = new ClassPathXmlApplicationContext("/contexto.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) contexto.getBean("UsuarioDAO");
		
		//Consulta
		List <Usuario> usuarios = usuarioDAO.obtenPorNombre("Juan");
		System.out.println("USUARIO:"+ usuarios);
		
		//ASASASASASASASAASGIIIIITTTTTT
	}

}
