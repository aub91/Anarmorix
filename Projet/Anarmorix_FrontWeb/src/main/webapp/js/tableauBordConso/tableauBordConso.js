var listeImages = [];
var interval;
window.onload = function() {
	chargement("carroussel");
}
function chargement(ou){
	let myDiapo = document.getElementById(ou);
	let images = myDiapo.getElementsByTagName("img");
	for (let i = 0; i < images.length; i++) {
		listeImages.push(images[i].src);
		with (images[i].style) {
			width = taille + "px";
			height = taille + "px";
			float = "left";
		}
	}
}
