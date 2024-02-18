package com.uce.edu.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Supplier
		
		System.out.println("****************************SUPPLIER");
		
		// Clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());

		// Lambdas
		
		System.out.println("Lambdas");
		
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "465465465";
			cedula = cedula + "Canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());
		
		IPersonaSupplier<String> supplierLambda2 = () -> "465465465"+"Pais";
		System.out.println(supplierLambda2.getId());
		
		IPersonaSupplier<Integer> supplierLambda3 = ()->{
			Integer valorInteger = Integer.valueOf(100);
			valorInteger = valorInteger*Integer.valueOf(50)/Integer.valueOf(5);
			return valorInteger;
		};
		System.out.println(supplierLambda3.getId());
		
		//Metodos referenciados
		System.out.println("Metodos referenciados");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4 =met::obtenerId;
		System.out.println(supplierLambda4.getId());
		
		// 2. Consumer
		System.out.println("****************************CONSUMER");
		 
		// Clases
		System.out.println("Clases");
		
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		
		// Lambdas
		System.out.println("Lambdas");
		
		IPersonaConsumer<String> consumerLambda = cadena->{
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");
		
		//Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaConsumer<String> consumer2 =met::procesar;
		consumer2.accept("Leonardo Referenciado");
		
		// 3. Predicate
		System.out.println("****************************PREDICATE");
		
		// Lambdas
	    System.out.println("Lambdas");
	    IPersonaPredicate<Integer> predicateLambda= numero -> numero.compareTo(7)==0;
        System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));

        IPersonaPredicate<String> predicateLambda2= letra-> "Leonardo".contains(letra);
        System.out.println(predicateLambda2.evaluar("e"));
        
        //Metodos referenciados
      	System.out.println("Metodos referenciados");
      	IPersonaPredicate<String> predicate2 = met::evaluar;
      	System.out.println(predicate2.evaluar("w"));
      	IPersonaPredicate<Integer> predicate3 = met::evaluar;
      	System.out.println(predicate3.evaluar(3));
        // 4. Function
        System.out.println("****************************FUNCTION");
        // Lambdas
	    System.out.println("Lambdas");
        IPersonaFunction<String, Integer> functionLambda = numero-> {
        	numero = numero + Integer.valueOf(10);
        	String numeroString = numero.toString().concat("-valor");
			return numeroString;
        };
        System.out.println(functionLambda.aplicar(7));
        
        IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano -> {
        	Empleado empl = new Empleado();
        	empl.setNombreCompleto(ciudadano.getNombre()+" "+ciudadano.getApellido());
        	if(ciudadano.getProvincia().compareTo("pichincha")==0) {
        		empl.setPais("Ecuador");
        	}
        	return empl;
        };
        Ciudadano ciud = new Ciudadano();
        ciud.setApellido("Ramirez");
        ciud.setNombre("Leonardo");
        ciud.setProvincia("pichincha");
        
        Empleado empleado = functionLambda1.aplicar(ciud);
        System.out.println(empleado);
        
        //Metodos referenciados
      	System.out.println("Metodos referenciados");
      	Empleado empleado2 = new Empleado();
      	empleado2.setNombreCompleto("Xavier Espinel");
      	empleado2.setPais("Ecuador");
      	IPersonaFunction<Ciudadano, Empleado> function2 = met::cambiar;
      	Ciudadano ciud2=function2.aplicar(empleado2);
      	System.out.println(ciud2);
        // 5. Unary operator
        System.out.println("****************************UNARY OPERATOR");
        // Lambdas
	    System.out.println("Lambdas");
	    
	    IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero*2);
	    
	    System.out.println(unaryOperatorLambda.aplicar(14));
	    
	    IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero +(numero*2);
	   
	    System.out.println(unaryOperatorLambda2.aplicar(10));
     	
        //Metodos referenciados
      	System.out.println("Metodos referenciados");
      	IPersonaUnaryOperatorFunction<Empleado> unary3 = met::procesar;
      	Empleado empl3 = unary3.aplicar(empleado2);
      	System.out.println(empl3);
	}

}
