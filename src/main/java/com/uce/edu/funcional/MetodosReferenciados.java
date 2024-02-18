package com.uce.edu.funcional;

public class MetodosReferenciados {
	
	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula = "465465465";
		cedula = cedula + "Referenciado";
		return cedula;
	}
	
	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("Se proceso la cadena");
	}
	
	public boolean evaluar(String cadena) {
		return "Leonardo".contains(cadena);
	}
	public boolean evaluar(Integer numero) {
		return 8==numero;
	}
	
	public Ciudadano cambiar(Empleado empl) {
		Ciudadano ciud = new Ciudadano();
		String nombreString =empl.getNombreCompleto().split("")[0];
		String apellidoString =empl.getNombreCompleto().split("")[1];
		ciud.setNombre(nombreString);
		ciud.setApellido(apellidoString);
		ciud.setProvincia("chimborazo");
		return ciud;
	}
	
	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto()+" "+empl.getPais());
		empl.setPais(empl.getPais()+" de nacimiento");
		return empl;
	}


}
