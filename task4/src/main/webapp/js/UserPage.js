let columnNameArray = ["user","place count","start date", "finish date", "apartament class"];
let rowCount = 0;
var apartaments = 'http://localhost:8082/sdfgbnm/apartaments';
var places = 'http://localhost:8082/sdfgbnm/places';
var listAparataments = '';
var listPlaces = '';
var user;

(function() {	
	var users = 'http://localhost:8082/sdfgbnm/users/1';
	$.getJSON(users, (data) => {
		user = data;
		 });
	
})();

(function() {	
	$.getJSON(apartaments, (data) => {
		data.forEach((option) => {
			listAparataments += `<option>${option}</option>`;
		})
	 });
})();

(function() {	
	$.getJSON(places, (data) => {
			data.forEach((option) => {
				listPlaces += `<option>${option}</option>`;
			})
	 });
})();

(function tableBuild(){
    let value = '';
    for(let i = 0; i < columnNameArray.length; i++){
        value +=  `<th id = "element">${columnNameArray[i]}</th>`;
    }
    document.getElementById('table').innerHTML += `<tr id = "columns">${value}</tr>`;

})();

function addRowInTable(){
    let value = '';
    
    if(rowCount === 0){
	    value +=  `<th id = "element">1</th>`;
	    value += "<th id = 'element'><select id = 'listPlaces' class = 'select'>" + listPlaces + "</select></th>";  
    	value +=  `<th id = "element"><input id = "startDate" type="date" name="calendar"></th>`;
    	value +=  `<th id = "element"><input id = "finishDate" type="date" name="calendar"></th>`;
    	value += "<th id = 'element'><select id = 'apartament' class = 'select'>" + listAparataments + "</select></th>";
  /*  for(let i = 0; i < columnNameArray.length; i++) {
      if(columnNameArray[i] === "start date" || columnNameArray[i] === "finish date") {
      	 value +=  `<th id = "element"><input id = "startDate" type="date" name="calendar"></th>`;
      } else if(i === columnNameArray.length-1) {
          value +=  `<th id = "element"><input type="radio" id="radioButton ${i}" value="checked"></th>`;
      } else if(columnNameArray[i] === "number status" || columnNameArray[i] === "place count") {
      	value += "<th id = 'element'><select id = 'apartament' class = 'select'>" + listAparataments + "</select></th>";   	
      } else if(columnNameArray[i] === "start time") {
      	 value +=  `<th id = "element"><input type="time" id="startTime ${i}"></th>`;
      } else if(columnNameArray[i] === "finish time") {
      	value +=  `<th id = "element"><input type="time" id="finishTime ${i}"></th>`;
      } else if(columnNameArray[i] === "user") {
      	value +=  '<th id = "element"></th>';
      } else {
          value +=  '<th id = "element"><input type="text" size="40"></th>';
      }
  }*/
  
    	document.getElementById('table').innerHTML += `<tr id = "raw ${rowCount}">${value}</tr>`;
    	rowCount++;
    }
}

function saveOrder(){
	var order;
	order = {
			user : user,
			startDate : document.getElementById("startDate").value,
			finishDate : document.getElementById("finishDate").value,
			apartamentClass : document.getElementById("apartament").value,
			desiredPlaceCount : document.getElementById("listPlaces").value,
			cost : 0.0
			};
	post(JSON.stringify(order));
	rowCount = 0;
}

function post(json){
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8082/sdfgbnm/orders", true);
	xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
	/*xhr.onreadystatechange = function() {
	    if(xhr.readyState == 4 && xhr.status == 200) {
	    	
	    }
	}*/
	xhr.send(json);
}
