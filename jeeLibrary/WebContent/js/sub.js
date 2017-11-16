var btnPopUp = document.getElementById('btnPop');
btnPopUp.addEventListener('click',popUpInfo, false);


var btnBoxGenre = document.getElementById('boxG');

var btnDel = document.getElementById('delSub');
btnPopUp.addEventListener('click',deleteSub, false);


function popUpInfo() {
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
}
function affichContact(){
	document.getElementById('contact').style.visibility = "visible";
}

function rechAuteur(){
	var btnBoxAuteur = document.getElementById('boxA');
	var txtBox = document.getElementById("boxA").value;
	boxG.value = "";
	txtTitre.value = "";
		
}
function rechTitre(){

	boxG.value = "";
	boxA.value = "";
}
function rechGenre(){
	boxA.value = "";
	txtTitre.value = "";
}
function deleteSub(){
	
}