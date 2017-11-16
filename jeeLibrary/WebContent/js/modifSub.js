var ixtNom = document.getElementById('txtNom');
ixtNom.addEventListener('change',ModifSub, false);

var ixtPrenom = document.getElementById('txtPrenom');
ixtPrenom.addEventListener('change',ModifSub, false);

document.getElementById('txtPrenom').style.background = "yellow";
document.getElementById('txtNom').style.background = "yellow";

function ModifSub(){
	document.getElementById('txtPrenom').style.background = "white";
	document.getElementById('txtNom').style.background = "white";
}