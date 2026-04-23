package com.example;


public class App {

	// metodo que recibe un objeto como parametro y muestra los detalles de dicho
	// objeto
	// utilizando la sentencia if y Pattern Maching con el metodo instanceof y
	// ademas destructure del tipo record que es uno de los record patterns
	static void impremeDetalles(Object obj) {
		// en java 21 CON record pattern, especialmente con destructure

		if (obj instanceof Book(String titulo, String autor)) {
			System.out.println("titulo del libro: " + titulo);
			System.out.println("Autor del libro: " + autor);
		}
	}

	public static void main(String[] args) {
		// crear un objeto de tipo record book

		// Book libro = new Book("java es bueno", "yo mismo");

		Book libro = Book.builder().title("java es bueno").author("yo mismo").build();

		impremeDetalles(libro);

		/**
		 * Record patterns can also be nested, allowing you to destructure complex
		 * object graphs in a single step
		 */
		
		Library library = Library.builder()
				.name("Biblioteca de Mostoles")
				.bestSeller(
						Book.builder()
						.title("Java Programming")
						.author("John Doe")
						.build()
				)
				.build();
		
		if (library instanceof Library(var nombre, Book(var titulo, var autor))) 
			System.out.println("en la biblioteca: " + nombre + ", el bestseller es: " + titulo + 
				", por el autor: " + autor);
		
				
		
		
	}
}
