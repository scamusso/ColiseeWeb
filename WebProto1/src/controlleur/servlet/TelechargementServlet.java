package controlleur.servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet de telechargement du fichier XML a partir du serveur
 * 
 * @author Stephane Camusso
 *
 */
public class TelechargementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String filename = "xmlSortie.xml";
		String filepath = "C:\\temp";
		
		resp.setContentType("APPLICATION/OCTET-STREAM");
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		FileInputStream fileInputStream = new FileInputStream(filepath + File.separator + filename);
 
		
		


		
		
		
		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}
	
}


