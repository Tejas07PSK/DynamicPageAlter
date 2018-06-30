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
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.net.InetAddress;
import java.net.UnknownHostException;

import hsl.test.dynamicpagealter.pojos.Table;

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

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
        {

                response.setContentType("text");
                response.setCharacterEncoding("UTF-8");
                response.setBufferSize(8192);
                PrintWriter out = response.getWriter();
                StringBuilder query = new StringBuilder();
                query.append("SELECT table_name FROM information_schema.tables where table_schema=\'");
                query.append(request.getParameter("sch_nme"));
                query.append("\'");

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
        {

                response.setContentType("text");
                response.setCharacterEncoding("UTF-8");
                response.setBufferSize(8192);
                PrintWriter out = response.getWriter();
                Table tab = Table.getSing_obj();
                tab.setTableName(request.getParameter("tab_nme"));
                tab.fillHashMap((request.getParameter("tab_type_inf")).split(","));
                StringBuilder query = new StringBuilder();
                query.append("CREATE TABLE ");
                query.append(request.getParameter("tab_nme"));
                query.append(" (");
                Iterator i = (tab.getEntries()).iterator();
                while (i.hasNext())
                {

                        Map.Entry me = (Map.Entry)i.next();
                        query.append(me.getKey());
                        query.append(me.getValue());
                        query.append(",");

                }
                query.append("PRIMARY KEY ( id ))");
                if (createTable(query.toString()))
                        out.print ("Table successfully created!!");
                else
                        out.print ("Failed to create table!!");
                out.flush ();
                out.close ();

        }

        private String retrieveTableNamesFromSchema(String sql)
        {

                StringBuilder result = "";
                boolean stat = false;
                Statement smt = null;
                ResultSet rs = null;
                try
                {

                        smt = conn.createStatement();
                        rs = smt.executeQuery(sql);
                        if (rs.isBeforeFirst())
                        {

                                while(rs.next())
                                {

                                        result.append(rs.getString("table_name"));
                                        if (rs.isLast())
                                        {

                                                break;

                                        }
                                        else
                                        {

                                                result.append("-");

                                        }

                                }

                        }
                        System.out.println("Created table in given database...");
                        stat = true;

                }
                catch(SQLException se)
                {

                        se.printStackTrace();
                        System.out.println("ERROR!!!");

                }
                catch(Exception e)
                {

                        e.printStackTrace();
                        System.out.println("ERROR!!!");

                }
                finally
                {

                        try
                        {

                                if(smt!=null)
                                        smt.close();

                        }
                        catch(SQLException se2)
                        {

                                se2.printStackTrace();

                        }

                }
                return (stat);

        }

        private boolean createTable(String sql)
        {

                boolean stat = false;
                Statement smt = null;
                try
                {

                        smt = conn.createStatement();
                        smt.executeUpdate(sql);
                        System.out.println("Created table in given database...");
                        stat = true;

                }
                catch(SQLException se)
                {

                        se.printStackTrace();
                        System.out.println("ERROR!!!");

                }
                catch(Exception e)
                {

                        e.printStackTrace();
                        System.out.println("ERROR!!!");

                }
                finally
                {

                        try
                        {

                                if(smt!=null)
                                   smt.close();

                        }
                        catch(SQLException se2)
                        {

                                se2.printStackTrace();

                        }

                }
                return (stat);

        }

        private static void startDBConnection()
        {

                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                final String DB_URL = "jdbc:mysql://"+ipadd+":3306/coudApp";

                final String USER = "palashsarkaradmin";
                final String PASS = "tejas!!";

                try
                {

                        Class.forName(JDBC_DRIVER).newInstance();
                        System.out.println("Connecting to database...");
                        conn = DriverManager.getConnection(DB_URL,USER,PASS);

                }
                catch(SQLException se)
                {

                        se.printStackTrace();
                        conn = null;

                }
                catch(Exception e)
                {

                        e.printStackTrace();
                        conn = null;

                }
                finally
                {

                        if(conn != null)
                                System.out.println("Connection Successful!!");
                        else
                        {

                                System.out.println("Connection Unsuccessful!!");
                                stopDBConnection();

                        }

                }

        }

        private static void stopDBConnection()
        {

                try
                {

                        conn.close();

                }catch(SQLException se)
                {

                        se.printStackTrace();

                }
                conn = null;

        }

}
