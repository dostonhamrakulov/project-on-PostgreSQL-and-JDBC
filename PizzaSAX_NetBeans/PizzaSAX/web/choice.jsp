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
<%@ page import="de.ix.jspTutorial.model.Ingredient" %>
<%@ page import="de.ix.jspTutorial.model.IngredientList" %>


<%-- initialize pizza list --%>
<jsp:useBean
     id="pizzaList"
     class="de.ix.jspTutorial.model.PizzaList"
	 scope="session"
   >

   <%
     pizzaList.readXMLList(application);
   %>
 </jsp:useBean>


<%-- initialize ingredient list --%>
<jsp:useBean
     id="ingredientList"
     class="de.ix.jspTutorial.model.IngredientList"
	 scope="session"
   >

   <%
     ingredientList.readList(application);
   %>
 </jsp:useBean>
 
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
	<TITLE>PIZZA SERVICE ONLINE - CHOICE</TITLE>
</HEAD>

<BODY BGCOLOR="#FFFFFF" LINK="#406E6E" ALINK="#406E6E" VLINK="#406E6E">
<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
<TR VALIGN="top">
	<TD WIDTH="115"><A HREF="index.jsp"><IMG SRC="logo.gif" WIDTH="115" HEIGHT="115" ALT="" BORDER="0"></A></TD>
	<TD WIDTH="50">&nbsp;</TD>
	<TD WIDTH="500"><FONT FACE="Arial,Helvetica" SIZE="2">
	<FONT SIZE="5" COLOR="#406E6E"><B><I>Pizza auswählen</I></B></FONT><BR>
	<BR>
	Bitte wählen Sie aus unserem reichhaltigen Angebot eine Pizza und gewünschte Beilagen aus.<BR>
	<BR>
	<FORM ACTION="order.jsp" METHOD="post">
	<FONT COLOR="#406E6E"><B><I>Grundpizza:</I></B></FONT><BR>
	<BR>
	
	<!-- Table for choice of pizza -->
	<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
	<TR BGCOLOR="#406E6E">
		<TD WIDTH="150"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;Name</TD>
		<TD WIDTH="150"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;Größe</TD>
		<TD WIDTH="100"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;Preis</TD>
		<TD WIDTH="75"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;</TD>		
	</TR>
	
	
	
	<%
	
    Set<Map.Entry<Long, Pizza>> entrySet = pizzaList.getPizzas().entrySet();


    for (Map.Entry<Long, Pizza> entry : entrySet) {
      Pizza pizza = entry.getValue();
	%>
		<TR>
			<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;<%=pizza.getName()%></TD>
			<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;<%=pizza.getSize()%></TD>
			<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;DM&nbsp;<%=formatCurrency(pizza.getBasePrice())%></TD>
			<TD><FONT FACE="Arial,Helvetica" SIZE="2"><INPUT NAME="ID_PIZZA" TYPE="radio" VALUE="<%=pizza.getId()%>"></TD>
		</TR>
	<%	
    }
	%>
	
	
	</TABLE>
	<BR>
	<BR>
	<FONT COLOR="#406E6E"><B><I>Zutaten:</I></B></FONT><BR>
	<BR>
	<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
	<TR VALIGN="top">
		<TD>
			<!-- Table for choice of ingrediens -->	

 			<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
			
			<TR BGCOLOR="#406E6E">
				<TD WIDTH="150"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;Name</TD>
				<TD WIDTH="100"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;Preis</TD>
				<TD WIDTH="50"><FONT FACE="Arial,Helvetica" SIZE="2" COLOR="#FFFFFF">&nbsp;</TD>		
			</TR>
			
			
			<%
			
			    Set entrySet2 = ingredientList.getIngredients().entrySet();


			    for (Iterator iter2 = entrySet2.iterator(); iter2.hasNext();) {
      				Map.Entry entry2 = (Map.Entry)iter2.next();
      				Ingredient ingredient = (Ingredient)entry2.getValue();		
			%>			
				<TR>
					<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;<%=ingredient.getName()%></TD>
					<TD><FONT FACE="Arial,Helvetica" SIZE="2">&nbsp;DM&nbsp;<%=formatCurrency(ingredient.getPrice())%></TD>
					<TD><FONT FACE="Arial,Helvetica" SIZE="2"><INPUT NAME="ID_INGREDIENTS" TYPE="checkbox" VALUE="<%=ingredient.getId()%>"></TD>	
				</TR>
			<%
				}	
			%>		
				
			</TR>		
			</TABLE>		
			<BR>
			<BR>
			<INPUT TYPE="submit" VALUE="Weiter &gt;&gt;">
		</TD>
		<TD WIDTH="25">&nbsp;</TD>
		<TD><IMG SRC="pizza.jpg" WIDTH="152" HEIGHT="141" ALT="Pizza" BORDER="0"></TD>		
	</TR>
	</TABLE>
	</FORM>
	<%@ include file="/jspTutorial/includes/copyright.html"%>
	</FONT></TD>
</TR>
</TABLE>
</BODY>
</HTML>
