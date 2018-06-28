/*  -> Designed for testing and development purposes.
 *  -> Project to design a DynamicPageAlter webapp prototype.
 *  -> Development Phase  -- Premature.
 *  -> Project Type  -- Educational.
 *  -> Organization -- HSL.
 *  -> Owner/Code file Designer :
 *             @ Name - Palash Sarkar.
 *             @ Email - palashsarkar0007@gmail.com.
 *  -> Copyright Norms - Every piece of code given below
 *                       has been written by 'Palash Sarkar (Tj07)'©,
 *                       and he holds the rights to the file. Not meant to be
 *                       copied or tampered without prior permission from the author.
 *  -> Guide -
 */

package hsl.test.dynamicpagealter.servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.net.InetAddress;
import java.net.UnknownHostException;

@WebServlet(description = "Servlet for managing tables on RDBMS", urlPatterns = { "/relServlet" })
public class RelationServlet extends HttpServlet
{

        private static final long serialVersionUID = 1L;
        private static Connection conn = null;
        private static InetAddress ip ;

        @SuppressWarnings("unused")
        private static String ipadd = "" ;

        @Override
        public void init()
        {

                if(conn == null)
                        startDBConnection();
                try
                {
                        System.setProperty("java.net.preferIPv4Stack", "true");
                        ip = InetAddress.getLocalHost();
                        ipadd = ip.getHostAddress();
                }catch (UnknownHostException e)
                {
                        e.printStackTrace();
                }

        }

        

}