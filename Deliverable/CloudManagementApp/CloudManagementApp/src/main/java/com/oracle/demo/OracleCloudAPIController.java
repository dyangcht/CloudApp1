package com.oracle.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class OracleCloudAPIController extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String iDomain = request.getParameter("iDomain");
        String requestType = request.getParameter("requestType");
        HttpSession s = request.getSession();
        s.setAttribute("login", login);
        s.setAttribute("password", password);
        s.setAttribute("iDomain", iDomain);
        if (requestType != null) {
            if (requestType.equalsIgnoreCase("login")) {
                RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/cloudmgmt.jsp" );
                dispatcher.forward( request, response );
            }
        }
    }
    //deleteCoherenceDataTierCluster
    //addCoherenceDataTierCluster
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String returnResult = "";
        String serviceID = null;
        String clusterName = null;
        String scalingUnitCount = null;
        String clusterType = null;
        String scalingUnitName = null;
        String url = "";
        response.setContentType(CONTENT_TYPE);
        String requestType = request.getParameter("requestType");
        OracleCloudAPIs api = new OracleCloudAPIs();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String iDomain = request.getParameter("iDomain");
        System.out.println("requestType: " + requestType);
        System.out.println(userName + ":" + password + ":" + iDomain);
        if (requestType != null) {
            if (requestType.equalsIgnoreCase("login")) {
                RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "WEB-INF/cloudmgmt.jsp" );
                dispatcher.forward( request, response );
            } else if (requestType.equalsIgnoreCase("getAllInstances")) {
                response.setContentType("application/json");
                returnResult = api.viewAllServiceInstances(userName, password, iDomain);
            } else if (requestType.equalsIgnoreCase("getSingleInstances")) {
                response.setContentType("application/json");
                serviceID = request.getParameter("serviceID");
                returnResult = api.viewServiceInstance(userName, password, iDomain, serviceID);
            } else if (requestType.equalsIgnoreCase("getStatus")) {
                response.setContentType("application/json");
                url = request.getParameter("responseURL");
                returnResult = api.viewStatus(userName, password, iDomain, url);
            } else if (requestType.equalsIgnoreCase("deleteCoherenceDataTier")) {
                response.setContentType("application/text");
                serviceID = request.getParameter("serviceID");
                clusterName = request.getParameter("clusterName");
                returnResult = api.deleteCoherenceDataTierCluster(userName, password, iDomain, serviceID, clusterName);
            } else if (requestType.equalsIgnoreCase("addCoherenceDataTier")) {
                response.setContentType("application/text");
                serviceID = request.getParameter("serviceID");
                clusterName = request.getParameter("clusterName");
                scalingUnitCount = request.getParameter("scalingUnitCount");
                clusterType = request.getParameter("clusterType");
                scalingUnitName = request.getParameter("scalingUnitName");
                returnResult = api.addCoherenceDataTierCluster(userName, password, iDomain, serviceID, clusterType, scalingUnitCount, clusterName, scalingUnitName);
            } else if (requestType.equalsIgnoreCase("deleteSingleInstance")) {
                System.out.println(111);
                response.setContentType("application/text");
                serviceID = request.getParameter("serviceID");
                String dbaName = request.getParameter("dbausername");
                String dbpwd = request.getParameter("dbapwd");
                System.out.println(222);
                returnResult = api.deleteServiceInstance(userName, password, iDomain, serviceID, dbaName, dbpwd);
            } else {
                response.setContentType("application/json");
                returnResult = "{'error':'Not Supported'}";
            }
        }
        response.getWriter().println(returnResult);
    }
}
