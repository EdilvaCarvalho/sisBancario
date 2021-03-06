package commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public class PegaConta implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String numeroConta = request.getParameter("numeroConta");
        try {
            request.setAttribute("numeroConta", numeroConta);
            request.getRequestDispatcher("transferencia.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PegaConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
