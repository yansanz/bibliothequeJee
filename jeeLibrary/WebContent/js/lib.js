var btnPopUp = document.getElementById('btnPop');
btnPopUp.addEventListener('click',popUpInfo, false);

var btnPopUp2 = document.getElementById('btnPop2');
btnPopUp2.addEventListener('click',popUpInfo2, false);

var chkB = document.getElementById('boxB');
chkB.addEventListener('change',Emprunt, false);

var chkB = document.getElementById('txtNom');
chkB.addEventListener('change',Emprunt, false);

document.getElementById('boxS').disabled == true;
document.getElementById('btnValid').disabled == true;

var tabl = document.getElementById('iChoix');
tabl.addEventListener('change',getIdCopy, false);

var isbn = document.getElementById('addIsbn');
isbn.addEventListener('change',addBook, false);

var boxAuteur = document.getElementById('boxA');
boxAuteur.addEventListener('change',addAuteur, false);

var zoneAut = document.getElementById('champAuteur').style.visibility  = "visible";

function addAuteurTxt(){
	boxA.value ="";
}
function setAuteur(Auteur ){
	zoneCibl.value = Auteur.value;
}

function popUpInfo() {
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
}
function Emprunt(){
	document.getElementById('boxS').disabled == false;
	document.getElementById('btnValid').disabled == false;
}
function saisiNom(){
	document.getElementById("txInfo").style.visibility = 'hidden';
}
function saisiEx(){
	document.getElementById("txInfo2").style.visibility = 'hidden';
}
function popUpInfo2() {
    var popup = document.getElementById("myPopup2");
    popup.classList.toggle("show");
}
var btnRetour = document.getElementById('btnRestituer');
btnRetour.addEventListener('click',retourBook, false);

function getIdCopy(id){
	var a = document.getElementById("txtCopId");
	a.value = id;
}