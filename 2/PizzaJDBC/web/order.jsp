<%--
  % This Javer Server Page is part of the iX JSP tutorial.
  % The user can give in address information for his order 
 --%>


<%-- Setting up an error page --%>
<%-- @ page errorPage="/jspTutorial/errorpage.jsp" --%>


<HTML>
<HEAD>
	<TITLE>PIZZA SERVICE ONLINE - ORDER</TITLE>
</HEAD>

<BODY BGCOLOR="#FFFFFF" LINK="#406E6E" ALINK="#406E6E" VLINK="#406E6E">

<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
<TR VALIGN="top">
	<TD WIDTH="115"><A HREF="index.jsp"><IMG SRC="logo.gif" WIDTH="115" HEIGHT="115" ALT="" BORDER="0"></A></TD>
	<TD WIDTH="50">&nbsp;</TD>
	<TD WIDTH="500"><FONT FACE="Arial,Helvetica" SIZE="2">
	<FONT SIZE="5" COLOR="#406E6E"><B><I>Pizza bestellen</I></B></FONT><BR>
	<BR>
	Bitte füllen Sie das Bestellformular vollständig aus:
	<BR>
	<FORM ACTION="confirm.jsp" METHOD="get">
	
	<% String[] paramIngredients = request.getParameterValues("ID_INGREDIENTS");  
	   StringBuffer theParamI = new StringBuffer() ;
	   if(paramIngredients != null) {
		   for(int i=0; i<paramIngredients.length;i++) {
	        theParamI.append(paramIngredients[i]) ;
	        if(i+1 <paramIngredients.length)
	          theParamI.append(",") ;
	     }
	   }
	   String paramPizza	   = request.getParameter("ID_PIZZA"); 
	%> 
	
	<INPUT TYPE="hidden" name="ingredientsId" value="<%=theParamI.toString()%>">	
	<INPUT TYPE="hidden" name="pizzaId" value="<%=paramPizza%>">
	
	<FONT COLOR="#406E6E"><B><I>Bestellformular:</I></B></FONT><BR>
	<BR>
	<!-- Table for choice of pizza -->
	<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
	<TR>
		<TD WIDTH="120"><FONT FACE="Arial,Helvetica" SIZE="2">Vorname</TD>
		<TD><INPUT NAME="firstname" TYPE="text" SIZE="30"></TD>
	</TR>
	<TR>
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">Nachname</TD>
		<TD><INPUT NAME="lastname" TYPE="text" SIZE="30"></TD>
	</TR>	
	<TR>
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">Adresse 1</TD>
		<TD><INPUT NAME="address1" TYPE="text" SIZE="30"></TD>
	</TR>	
	<TR>
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">Adresse 2</TD>
		<TD><INPUT NAME="address2" TYPE="text" SIZE="30"></TD>
	</TR>	
	<TR>
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">PLZ</TD>
		<TD><INPUT NAME="zip" TYPE="text" SIZE="5"></TD>
	</TR>	
	<TR>
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">Stadt</TD>
		<TD><INPUT NAME="town" TYPE="text" SIZE="30"></TD>
	</TR>			
	<TR>
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">eMail</TD>
		<TD><INPUT NAME="mail" TYPE="text" SIZE="30"></TD>
	</TR>				
	</TABLE>
	<BR>
	<BR>		
	<INPUT TYPE="submit" VALUE="Bestellen">
	</FORM>
	<%@ include file="/jspTutorial/includes/copyright.html"%>
	</FONT></TD>
</TR>
</TABLE>
</BODY>
</HTML>
