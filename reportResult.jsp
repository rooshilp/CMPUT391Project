<html>
<body> 
	Results for patients with 
		<%
		String iDiag = 	request.getParameter("DiagnosisInput");
		String iDate = 	request.getParameter("DateInput");
		out.print(iDiag);
		%>
	on
		<%
		out.print(iDate);
		%>
	:
</body>
<table border="1">
<tr> <th>Last Name</th> <th> First Name </th> <th>Address</th> <th>Phone Number</th> <th>Testing Date</th> </tr>
<tr> <td>Gates</td> <td> Bill </td> <td>555 Street</td> <td> 555 333 2345</td> <td>05-23-13</td> </tr>
</table> 
</html> 

<!-- SQL: 
select p.last_name, p.first_name, p.address, p.phone, r.test_date
from persons p, radiology_record r
where p.person_id = r.patient_id 
	AND [diagnosis] = r.diagnosis
	AND [date] = r.test_date
ORDER BY p.last_name
 -->