<%--
  % This Javer Server Page is part of the iX JSP tutorial.
  % Error Pages 
 --%>


<%-- Setting up page as error page --%>
<%-- @ page isErrorPage="true" --%>



<HTML>
<HEAD>
	<TITLE>PIZZA SERVICE ONLINE - ERROR</TITLE>
</HEAD>

<BODY BGCOLOR="#FFFFFF" LINK="#406E6E" ALINK="#406E6E" VLINK="#406E6E">
<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
<TR VALIGN="top">
	<TD WIDTH="115"><A HREF="index.jsp"><IMG SRC="logo.gif" WIDTH="115" HEIGHT="115" ALT="" BORDER="0"></A></TD>
	<TD WIDTH="50">&nbsp;</TD>
	<TD WIDTH="500"><FONT FACE="Arial,Helvetica" SIZE="2">
	<FONT SIZE="5" COLOR="#406E6E"><B><I>Fehler</I></B></FONT><BR>
	<BR>
	Leider ist ein Fehler aufgetreten.
	<BR>
	<BR>
	<A HREF="index.jsp">Startseite</A>
	<BR>
	<BR>
	<BR>
	<%@ include file="/jspTutorial/includes/copyright.html"%>
	</FONT></TD>
</TR>
</TABLE>
</BODY>
</HTML>
