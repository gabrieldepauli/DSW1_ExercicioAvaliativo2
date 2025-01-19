package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Interface Command que está sendo implementada pelos métodos do sistema
public interface Command {

	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
