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
		
		// 2. Predicate
		System.out.println("****************************PREDICATE");
		
		// Lambdas
	    System.out.println("Lambdas");
	    IPersonaPredicate<Integer> predicateLambda= numero -> numero.compareTo(7)==0;
        System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));

        IPersonaPredicate<String> predicateLambda2= letra-> "Leonardo".contains(letra);
        System.out.println(predicateLambda2.evaluar("e"));
	}

}
