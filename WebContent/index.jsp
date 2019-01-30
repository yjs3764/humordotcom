<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<%@ page import="java.util.*" %>
<%@ page import="util.Test" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
안녕하세요
<% try{out.println(InetAddress.getLocalHost().getHostAddress());}catch(Exception e){} %>
<%
String clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");

if(null == clientIp || clientIp.length() == 0
|| clientIp.toLowerCase().equals("unknown")){
clientIp = request.getHeader("REMOTE_ADDR");
}

if(null == clientIp || clientIp.length() == 0
|| clientIp.toLowerCase().equals("unknown")){
clientIp = request.getRemoteAddr();
}

out.println(clientIp);

out.print("<p>Remote Addr: " + request.getRemoteAddr() + "</p>");
out.print("<p>Remote Host: " + request.getRemoteHost() + "</p>");
out.print("<p>X-Forwarded-For: " + request.getHeader("x-forwarded-for") + "</p>");
		
System.out.println("Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
for (; n.hasMoreElements();)
{
        NetworkInterface e = n.nextElement();
        out.println("Interface: " + e.getName());
        Enumeration<InetAddress> a = e.getInetAddresses();
        for (; a.hasMoreElements();)
        {
                InetAddress addr = a.nextElement();
                out.println("  " + addr.getHostAddress());
        }
}
 %>
 
 <br>
 
 <%
 
 	out.println(Test.getCurrentIp().getHostAddress());
 
 %>
<jsp:include page="/footer.jsp"/>
</body>
</html>