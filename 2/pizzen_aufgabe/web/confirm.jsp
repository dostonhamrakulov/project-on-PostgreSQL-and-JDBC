<%--
  % This Javer Server Page is part of the iX JSP tutorial.
  % The user can choose a pizza plus some additional 
  % ingredients
 --%>


<%-- Setting up an error page --%>
<%-- @ page errorPage="/jspTutorial/errorpage.jsp" --%>


<%-- import needed java classes --%>	 
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="de.ix.jspTutorial.model.Pizza" %>
<%@ page import="de.ix.jspTutorial.model.PizzaList" %>
<%@ page import="de.ix.jspTutorial.model.PersonalPizza" %>
<%@ page import="de.ix.jspTutorial.model.Ingredient" %>
<%@ page import="de.ix.jspTutorial.model.IngredientList" %>


<jsp:useBean id="order" class="de.ix.jspTutorial.model.Order" scope="session"/>

<%! 
public String formatCurrency(double aCurrencyValue) {
	DecimalFormat theFormat = new DecimalFormat();
	theFormat.setGroupingUsed(true);
	theFormat.setMinimumFractionDigits(2);
  theFormat.setMaximumFractionDigits(2);
  return theFormat.format(aCurrencyValue) ;
}
%>

<HTML>
<HEAD>
	<TITLE>PIZZA SERVICE ONLINE - CONFIRM</TITLE>
</HEAD>

<BODY BGCOLOR="#FFFFFF" LINK="#406E6E" ALINK="#406E6E" VLINK="#406E6E">

<jsp:setProperty name="order" property="*" />

<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
<TR VALIGN="top">
	<TD WIDTH="115"><A HREF="index.jsp"><IMG SRC="logo.gif" WIDTH="115" HEIGHT="115" ALT="" BORDER="0"></A></TD>
	<TD WIDTH="50">&nbsp;</TD>
	<TD WIDTH="500"><FONT FACE="Arial,Helvetica" SIZE="2">
	<FONT SIZE="5" COLOR="#406E6E"><B><I>Bestätigung</I></B></FONT><BR>
	<BR>
	Vielen Dank für Ihre Bestellung.<BR>
	<BR>
	Folgende Bestellung ist bei uns eingegangen:<BR>
	<BR> 
	
	<%
	
	String pizzaId 			= request.getParameter("pizzaId");
	String ingredientsId 	= request.getParameter("ingredientsId");
		
	PersonalPizza personalPizza = new PersonalPizza(request,pizzaId, ingredientsId); 
	
	%>
	<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
	<TR BGCOLOR="#406E6E">
		<TD WIDTH="280"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;Position</TD>
		<TD WIDTH="20"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;</TD>
		<TD WIDTH="100"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;Preis</TD>
	</TR>
	<TR VALIGN="top">
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;Pizza: <%=personalPizza.getName() %>, <%=personalPizza.getSize() %></TD>
		<TD WIDTH="20">&nbsp;</TD>
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;DM <%=formatCurrency(personalPizza.getBasePrice()) %></TD>
	</TR>
	<%
	
    Set entrySet = personalPizza.getIngredients().entrySet();
	

    for (Iterator iter = entrySet.iterator(); iter.hasNext();) {
		Map.Entry entry = (Map.Entry)iter.next();
		Ingredient ingredient = (Ingredient)entry.getValue();
	%>
	<TR VALIGN="top">
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;Extra <%=ingredient.getName()%></TD>
		<TD WIDTH="20">&nbsp;</TD>
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;DM <%=formatCurrency(ingredient.getPrice())%></TD>
	</TR>	
	<%
	}
	%>	
	<TR VALIGN="top" BGCOLOR="#406E6E">
		<TD COLSPAN="3"><IMG SRC="blank.gif" WIDTH="1" HEIGHT="1"></TD>
	</TR>	
	<TR VALIGN="top">
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;<B>Gesamtbetrag</B></TD>
		<TD WIDTH="20">&nbsp;</TD>
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;<B>DM <%=formatCurrency(personalPizza.calcTotalPrice())%></B></TD>
	</TR>			
	</TABLE>		
	<BR>
	<BR>
	Die Bestellung wird an folgende Adresse geliefert:<BR>
	<BR>	
	<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
	<TR BGCOLOR="#406E6E">
		<TD WIDTH="350"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;Lieferadresse</TD>		
	</TR>
	<TR VALIGN="top">
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;<jsp:getProperty name="order" property="firstname"/>&nbsp;<jsp:getProperty name="order" property="lastname"/></TD>
	</TR>	
	<TR VALIGN="top">
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;<jsp:getProperty name="order" property="address1"/></TD>
	</TR>	
	<TR VALIGN="top">
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;<jsp:getProperty name="order" property="address2"/></TD>
	</TR>	
	<TR VALIGN="top">
		<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;<jsp:getProperty name="order" property="zip"/>&nbsp;<jsp:getProperty name="order" property="town"/></TD>
	</TR>	
	</TABLE>
	<BR>
	<BR>
	Leider bekommen Sie nur eine <i>virtuelle Pizza</i> geschickt, da dies lediglich ein JSP-Tutorial ist.
	<BR>
	<BR>
	<BR>
	<%@ include file="/jspTutorial/includes/copyright.html"%>
	</FONT></TD>
</TR>
</TABLE>
</BODY>
</HTML>
