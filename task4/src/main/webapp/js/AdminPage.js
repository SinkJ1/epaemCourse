let columnNameArray = ["order id", "number", "user name","place count","start date", "finish date", "apartament class","status","price",""];

var orders = 'http://localhost:8082/sdfgbnm/orders/notClosed';
var numbers = 'http://localhost:8082/sdfgbnm/numbers';
var status = 'http://localhost:8082/sdfgbnm/status';
var listOrders = [];
var listUsersName = [];
var listStatus = '';
var numberList = [];
let user;


(function() {	
	$.getJSON(status, (data) => {
		data.forEach((option) => {
			listStatus += `<option>${option}</option>`;
		})
	 });
})();

(function() {	
	$.getJSON(numbers, (data) => {
		for(let i = 0; i < data.length;i++){
			numberList[i] = data[i];
		}
	});
})();

(function() {	
	$.getJSON(orders, (data) => {
		for(let i = 0; i < data.length;i++){
			listOrders[i] = data[i];
		}
		getUsers();
		addRowInTable();
	});
	
})();

function getUsers(){
	for(let i = 0; i < listOrders.length; i++){
			listUsersName[i] = listOrders[i].user.name;			
	}
}

(function tableBuild(){
    let value = '';
    for(let i = 0; i < columnNameArray.length; i++){
        value +=  `<th id = "element">${columnNameArray[i]}</th>`;
    }
    document.getElementById('table').innerHTML += `<tr id = "columns">${value}</tr>`;
    
})();

function addRowInTable(){
    let value = '';
   
    for(let i = 0; i < listOrders.length; i++){
	    value +=  `<th id = "orderId" class = "element">${listOrders[i].id}</th>`;
	    number = numberList[i];
	    value +=  `<th id = "numb" class = "element"><select id = 'number' class = 'select'><option>id=${numberList[i].id} status=${numberList[i].numberStatus} apartament Class = ${numberList[i].apartamentClass} place count = ${numberList[i].placeCount}</option></select></th>`;
	    user = listOrders[i].user;
	    value +=  `<th id = "element" class = "element">${user.name}</th>`;
	    value +=  `<th id = 'desiredPlaceCount' class = "element">${listOrders[i].desiredPlaceCount}</th>`;  
    	value +=  `<th id = 'startDate2' class = "element"><div id = 'startDate'>${listOrders[i].startDate}</div></th>`;
    	value +=  `<th id = "finishDate" class = "element">${listOrders[i].finishDate}</th>`;
    	value +=  `<th id = "apartamentClass" class = "element" >${listOrders[i].apartamentClass}</th>`;
    	value +=  `<th id = "status2" class = "element"><select id = 'status' class = 'select'><option>${listOrders[i].status}<option>${listStatus}</select></th>`;
    	value +=  `<th id = "status2" class = "element">${listOrders[i].cost}</th>`;
    	document.getElementById('table').innerHTML += `<tr id = "raw ${i}">${value}</tr>`;
    	value = '';
    }
};

function saveOrder(){
	var order;
	let sDate = new Date(document.getElementById("startDate").value);
	let fDate = new Date(document.getElementById("finishDate").value);
	let day = Math.ceil(Math.abs(fDate.getTime() - sDate.getTime()) / (1000 * 3600 * 24));
	let cost = day * number.numberCostByDay;
	order = {
			id : 4,//document.getElementById("orderId").value,
			number : number,
			user : user,
			startDate : document.getElementById("startDate").value,
			finishDate : document.getElementById("finishDate").value,
			apartamentClass : document.getElementById("apartamentClass").value,
			desiredPlaceCount : document.getElementById("desiredPlaceCount").value,
			status : document.getElementById("status").value,
			cost : 5.5
			};
	post(JSON.stringify(order));
	rowCount = 0;
}

function post(json){
	var xhr = new XMLHttpRequest();
	xhr.open("PUT", "http://localhost:8082/sdfgbnm/orders", true);
	xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
	xhr.send(json);
}