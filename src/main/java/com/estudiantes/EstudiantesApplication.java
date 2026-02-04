package com.estudiantes;

import com.estudiantes.modelo.Estudiante;
import com.estudiantes.service.EstudianteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();
	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion....");
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada");

	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Ejecutando metodo run de spring");
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir) {
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}
	}

	private void mostrarMenu() {
		System.out.print(nl + """
				**** Sistema de Estudiantes ***
				1. Listar Estudiantes
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. salir
				Elige una opcion:  """);
	}
		private boolean ejecutarOpciones(Scanner consola){
			var opcion = Integer.parseInt(consola.nextLine());
			var salir = false;
			switch (opcion){
				case 1 -> {
					System.out.println(nl + "Listado de Estudiantes: " + nl);
					List<Estudiante> estudiantes = estudianteService.listarEstudiante();
					estudiantes.forEach(estudiante -> System.out.println(estudiante.toString()));
				}
				case 2 -> {
					System.out.println(nl + "Introduce el id estudiante a buscar: " );
					var idEstudiante = Integer.parseInt(consola.nextLine());
					Estudiante estudiante =
							estudianteService.buscarEstudiantePorId(idEstudiante);
					if (estudiante !=null)
						System.out.println("Estudiante Encontrado: " + estudiante + nl);
					else
						System.out.println("Estudiante no encontrado con id: " + idEstudiante + nl);
				}
				case 3 -> {
					System.out.println("*** Agregar estudiante ***");
					System.out.println("nombre: " );
					var nombre = consola.nextLine();
					System.out.println("apellido: ");
					var apellido = consola.nextLine();
					System.out.println("telefono: " );
					var telefono = consola.nextLine();
					System.out.println("email: ");
					var email = consola.nextLine();

					var estudiante = new Estudiante();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteService.guardarEstudiante(estudiante);
					System.out.println("Estudiante agregado: " + estudiante);
				}
				case 4 -> {
					System.out.println("Modificar Estudiante: ");
					System.out.println("Id estudiante");
					var idEstudiante = Integer.parseInt(consola.nextLine());
					// bucamos el estudiante
					Estudiante estudiante = estudianteService.buscarEstudiantePorId(idEstudiante);

					if (estudiante != null){
						System.out.println("nombre: " );
						var nombre = consola.nextLine();
						System.out.println("apellido: ");
						var apellido = consola.nextLine();
						System.out.println("telefono: " );
						var telefono = consola.nextLine();
						System.out.println("email: ");
						var email = consola.nextLine();

						estudiante.setNombre(nombre);
						estudiante.setApellido(apellido);
						estudiante.setTelefono(telefono);
						estudiante.setEmail(email);
						estudianteService.guardarEstudiante(estudiante);
						System.out.println("Estudiante Actualizado: " + estudiante);
				}else{

						System.out.println("Estudiante no encontrado: " + idEstudiante);
					}
				}
				case 5 -> {
					System.out.println("Eliminar Estudiante: ");
					System.out.println("id Estudiante: ");
					var idEstudiante = Integer.parseInt(consola.nextLine());
					Estudiante estudiante = estudianteService.buscarEstudiantePorId(idEstudiante);

					if (estudiante != null){
						estudianteService.eliminarEstudiante(estudiante);
						System.out.println("Estudiante eliminado " + estudiante);


					}else {
						System.out.println("Estudiante no encontrado ");
					}
				}
				case 6 -> {
					System.out.println("Saliendo del sistema....");
					salir = true;
				}
				default -> System.out.println("Opcion invalida");
			}
			return salir;
		}
	}
