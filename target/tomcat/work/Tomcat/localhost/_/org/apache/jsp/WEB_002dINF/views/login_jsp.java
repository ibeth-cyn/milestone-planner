/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-25 00:39:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/style/login_style.css", Long.valueOf(1556088956486L));
    _jspx_dependants.put("/WEB-INF/views/style/style.css", Long.valueOf(1556088967386L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>MileStone Planner Login Page</title>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Raleway:400,500,600,700\" rel=\"stylesheet\">\r\n");
      out.write("    <style>");
      out.write("body{\r\n");
      out.write("    background-color: #475BBF;\r\n");
      out.write("    background-image: url(images/bg1.png);\r\n");
      out.write("    background-size: cover;\r\n");
      out.write("    color: #fff;\r\n");
      out.write("    /*background-image: url(https://picsum.photos/2048/1365/?random);*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button{\r\n");
      out.write("    background-color: #475BBF;\r\n");
      out.write("    border: none;\r\n");
      out.write("    color: #fff;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    width: 40%;\r\n");
      out.write("    margin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form_input{\r\n");
      out.write("    padding: 20px;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#form_button{\r\n");
      out.write("    margin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("input[type=\"submit\"]{\r\n");
      out.write("    background-color: inherit;\r\n");
      out.write("    border: none;\r\n");
      out.write("    color: inherit;\r\n");
      out.write("    margin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"text\"], input[type=\"password\"]{\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login_card{\r\n");
      out.write("    background-color: #fff;\r\n");
      out.write("    color: #000;\r\n");
      out.write("    width: 35%;\r\n");
      out.write("    margin: auto;\r\n");
      out.write("    padding: 50px;\r\n");
      out.write("    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);\r\n");
      out.write("    transition: 0.3s;\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("    position: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login_text{\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    padding: 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("    <style>");
      out.write("body{\r\n");
      out.write("    font-family: 'Raleway', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1{\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    padding-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1{\r\n");
      out.write("    font-size: 24px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    padding-left: inherit;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h3{\r\n");
      out.write("    font-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h4{\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"login_text\">\r\n");
      out.write("<h1>Registration Successful!</h1>\r\n");
      out.write("<p>Log in to view your Milestones.</p>\r\n");
      out.write("    <!--We can have the paragraphs below appear after a user logs in. How do we figure that out? Debbie?-->\r\n");
      out.write("    <!--p>Registration Successful!</p>\r\n");
      out.write("    <p>Log in to view your Milestones</p-->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--Create webApp.login form for user-->\r\n");
      out.write("\r\n");
      out.write("<div class=\"login_card\">\r\n");
      out.write("    <form action=\"/webApp.login.do\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"form_input\">\r\n");
      out.write("    Name:<br> <input type=\"text\" name=\"name\"/>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"form_input\">\r\n");
      out.write("    Password:<br> <input type=\"password\" name=\"password\"/>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form_input\" id=\"form_button\">\r\n");
      out.write("            <button><input type=\"submit\" value=\"Login\"/></button>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
