function validation() {
	no= parseInt(document.getElementById("number").value);
	
	if( !isNaN(no) && no>0 ) {	
		query = "";
		query += "<table  id='table' width=500px align='center' >";
		query += "<tr><td>Name</td><td>Min</td><td>Max</td></tr>";
		for(i=0;i<no;i++) {
			query += "<tr>";
			for(j=0;j<3;j++) {
				if(j==0){
					query += "<td><input id = 'cell"+i+""+j+"' type='text'></td>";
				}
				else {
					query += "<td><input id = 'cell"+i+""+j+"' type='number' min='1' max='10' step='1'></td>";
				}
				
			}
			query += "</tr>";
		}
		query += "<tr><td colspan='3' style=' text-align: center;'> <button  onclick='my()' style ='margin: 0 auto; position:relative;'>OK</button> </td> </tr> </table>";
		document.getElementById("tableInput").innerHTML = query;
		}
		else{
			alert("Please enter number");
		}
	}
	
	function my() {
		no = document.getElementById("number").value;
		var max = new Array(no);
		var min = new Array(no);
		var name = new Array(no);
		j=0;
		
		for(i=0;i<no;i++){
			na = document.getElementById("cell"+i+"0").value;
			if(!na) {
				alert("Please fill name in row "+(i+1));
				return;
			}
			name[i] = na;
			mi = parseInt(document.getElementById("cell"+i+"1").value);
			if(!mi || (mi<1 || mi>10)) {
				alert("Please fill min value in row "+(i+1)+" (between 1 to 10)");
				return;
			}
			min[i] = mi;
			var ma = parseInt(document.getElementById("cell"+i+"2").value);
			if(!ma || (ma<1 || ma>10)) {
				alert("Please fill max value in row "+(i+1)+" (between 1 to 10)");
				return;
			}
			max[i] =ma; 
			if(ma<mi) {
				alert("Please enter min less than max in"+(i+1)+"th row"+" min = "+mi+" max = "+ma);
				return;
			}
		}
	
		
		for(i=0;i<no;i++){
			j=i+1;
			alert("done!");
			newTableQuery = "";
			newTableQuery += "<br/><br/><table align='center' style = 'border : 2px solid black; border-collapse: collapse;'   >"
			for(i=0 ; i < no ; i++){
				newTableQuery += "<tr style = ''>";
					for(j=0 ; j < 11 ; j++){
						if(j==0) {
							newTableQuery += "<td style='width:20px; border-right: 2px solid black; border-bottom : 2px solid black;'>"+name[i]+"</td>";	
								j++;
						}
						if(j<min[i] || j>max[i]) {
								newTableQuery += "<td style=' width:20px; border-bottom : 2px solid black;'> </td>";
						}	
						else{
								newTableQuery += "<td style='background-color:red; width:20px; border-bottom : 2px solid black;'></td>";
						}						
					}
					newTableQuery += "</tr>";
			}
		newTableQuery += "</table>";
		}
		document.getElementById("tableOutput").innerHTML = newTableQuery;
	}